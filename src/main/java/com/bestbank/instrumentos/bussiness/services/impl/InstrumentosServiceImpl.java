package com.bestbank.instrumentos.bussiness.services.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bestbank.instrumentos.bussiness.client.ClientesApiService;
import com.bestbank.instrumentos.bussiness.dto.req.InstrumentoReq;
import com.bestbank.instrumentos.bussiness.dto.res.ClienteRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoAsoRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoRes;
import com.bestbank.instrumentos.bussiness.dto.res.ProductoRes;
import com.bestbank.instrumentos.bussiness.services.InstrumentosService;
import com.bestbank.instrumentos.bussiness.utils.BankFnUtils;
import com.bestbank.instrumentos.bussiness.utils.ModelMapperUtils;
import com.bestbank.instrumentos.bussiness.utils.TarjetaDebitoFake;
import com.bestbank.instrumentos.domain.models.Instrumento;
import com.bestbank.instrumentos.domain.models.ProductoAsociado;
import com.bestbank.instrumentos.domain.repositories.InstrumentosRepository;
import com.bestbank.instrumentos.domain.utils.GrupoProducto;
import com.bestbank.instrumentos.domain.utils.TipoEstado;
import com.bestbank.instrumentos.domain.utils.TipoEstadoFinaciero;
import com.bestbank.instrumentos.domain.utils.TipoInstrumento;
import com.bestbank.instrumentos.domain.utils.TipoProducto;

import reactor.core.publisher.Mono;

@Service
public class InstrumentosServiceImpl implements InstrumentosService {
  
  private final ClientesApiService servClienteApi;
  
  private final InstrumentosRepository instrumentosRepo;
  
  

  public InstrumentosServiceImpl(ClientesApiService servClienteApi,
      InstrumentosRepository instrumentosRepo) {
    this.servClienteApi = servClienteApi;
    this.instrumentosRepo = instrumentosRepo;
  }
  
  
  private Mono<ClienteRes> isClienteOk(String idCliente) {
    return servClienteApi.getClienteById(idCliente)
        .filter(clienteF1 -> 
        clienteF1.getEstado().contentEquals(TipoEstado.NORMAL.getValor()))
        .filter(clienteF2 -> 
        clienteF2.getEstadoFinanciero().equals(TipoEstadoFinaciero.SOLVENTE))
        .switchIfEmpty(Mono.error(
            new Throwable("Cliente no puede Realizar esta Operacion")
        ));
  }
  
  private Mono<ProductoRes> isProductoOk(String idProducto) {
    return servClienteApi.getProducto(idProducto)
        .filter(prodApiF1 -> 
         prodApiF1.getEstado().equals(TipoEstado.NORMAL.getValor()))
        .switchIfEmpty(Mono.error(
            new Throwable("Producto No habilitado")
        ))
        .filter(prodApiF2 -> 
        prodApiF2.getGrupoProducto().equals(GrupoProducto.PASIVOS) 
          && !prodApiF2.getTipoProducto().equals(TipoProducto.DPFJ))
        .switchIfEmpty(Mono.error(
            new Throwable("Producto No Soporta Instrumento")
        ));
  }
  
  
  private Mono<Instrumento> isInstrumentoOk(String idInstrumento) {
    return instrumentosRepo.findById(idInstrumento)
        .filter(instDb -> instDb.getIndEliminado().equals(0))
        .switchIfEmpty(Mono.error(
            new Throwable("Instrumento fue eliminado")
        ))
        .filter(instDb2 -> instDb2.getEstado().contentEquals("0"))
        .switchIfEmpty(Mono.error(
            new Throwable("Instrumento No habilitado")
        ));        
  }
  
  private Mono<Instrumento> isInstrumentoClienteOk(String idInstrumento) {
    return isInstrumentoClienteOk(idInstrumento)
        .flatMap(instDb -> 
          isClienteOk(instDb.getCodPersona())
              .flatMap(clienteApi ->  
                Mono.just(instDb) 
              )
        );
  }
  
  

  @Override
  public Mono<InstrumentoRes> postInstrument(InstrumentoReq instrumento) {
    return isClienteOk(instrumento.getCodPersona())
        .filter(s -> instrumento.getTipoInstrumento() == TipoInstrumento.TARJETA_DEBITO)
        .flatMap(clienteapi -> {
          Instrumento nuevoInstrumento = ModelMapperUtils.map(new TarjetaDebitoFake(), 
              Instrumento.class);
          nuevoInstrumento.setCodPersona(instrumento.getCodPersona());
          nuevoInstrumento.setProductosAsociados(new ArrayList<>());
          return instrumentosRepo.save(nuevoInstrumento)
              .map(nuevoInstrumentoDB -> 
               ModelMapperUtils.map(nuevoInstrumentoDB, InstrumentoRes.class)
              );
        }).switchIfEmpty(Mono.error(
            new Throwable("Instrumeto no se solicita por este canal")
        ));
  }

  @Override
  public Mono<InstrumentoRes> getInstrumentById(String idInstrumento) {
    return isInstrumentoOk(idInstrumento)
        .map(instDb -> ModelMapperUtils.map(instDb, InstrumentoRes.class));
  }

  @Override
  public Mono<InstrumentoRes> delInstrumenById(String idInstrumento) {
    return isInstrumentoOk(idInstrumento)
        .flatMap(itemDb -> {
          Instrumento modInstrumento = ModelMapperUtils.map(itemDb, Instrumento.class);
          modInstrumento.setIndEliminado(1);
          modInstrumento.setFecModificacion(BankFnUtils.getLegacyDateTimeNow());
          return instrumentosRepo.save(modInstrumento)
              .map(nuevoInstrumentoDB -> 
                ModelMapperUtils.map(nuevoInstrumentoDB, InstrumentoRes.class)
              );
        });
  }
  
  private List<ProductoAsociado> setProdAsociadoAuto(List<ProductoAsociado> items) {
    Integer existeAsociado = items
        .stream()
        .filter(itemF1 -> itemF1.getIndDefecto().equals(1))
        .toList()
        .size();
    
    if (existeAsociado == 0 && !items.isEmpty()) {
      items.get(0).setIndDefecto(1);
    }
    return items;
  }

  @Override
  public Mono<InstrumentoAsoRes> putAsocProdInstrument(String idInstrumento,
      String idProducto) {
    return isProductoOk(idProducto)
        .flatMap(prodApi -> 
          isInstrumentoOk(idInstrumento)
              .filter(intF1 -> 
              intF1.getCodPersona().equals(prodApi.getCodigoPersona()))
              .switchIfEmpty(Mono.error(
                  new Throwable("Cliente Producto Incorrecto")
              ))
              .flatMap(intDb -> {
                List<ProductoAsociado> prodAsociados = 
                    intDb.getProductosAsociados();
                Integer existeProducto = prodAsociados
                    .stream()
                    .filter(item -> item.getId().equals(idProducto))
                    .toList()
                    .size();
                if (existeProducto > 0) {
                  return Mono.error(
                      new Throwable("Producto ya esta registrado")
                  );
                }
                ProductoAsociado prodAsociado = 
                    ModelMapperUtils.map(prodApi, ProductoAsociado.class);
                prodAsociado.setIndDefecto(0);
                prodAsociados.add(prodAsociado);
                // Ordenar la lista por indPrincipal (1 primero, 0 después)
                prodAsociados.sort(
                    Comparator.comparingInt(ProductoAsociado::getIndDefecto).reversed()
                );
                setProdAsociadoAuto(prodAsociados);
                Instrumento modInstrumento = 
                    ModelMapperUtils.map(intDb, Instrumento.class);
                modInstrumento.setProductosAsociados(prodAsociados);
                modInstrumento.setFecModificacion(BankFnUtils.getLegacyDateTimeNow());
                return instrumentosRepo.save(modInstrumento)
                    .map(s -> ModelMapperUtils.map(s, InstrumentoAsoRes.class));
              })
        );
  }

  @Override
  public Mono<InstrumentoAsoRes> delAsocProdInstrument(String idInstrumento,
      String idProducto) {
    return isProductoOk(idProducto)
        .flatMap(prodApi -> 
          isInstrumentoOk(idInstrumento)
              .flatMap(intDb -> {
                List<ProductoAsociado> prodAsociadosMod = intDb.getProductosAsociados()
                    .stream()
                    .filter(item -> !item.getId().equals(idProducto))
                    .toList();
                setProdAsociadoAuto(prodAsociadosMod);
                Instrumento modInstrumento = 
                    ModelMapperUtils.map(intDb, Instrumento.class);
                modInstrumento.setProductosAsociados(prodAsociadosMod);
                modInstrumento.setFecModificacion(BankFnUtils.getLegacyDateTimeNow());
                return instrumentosRepo.save(modInstrumento)
                    .map(s -> ModelMapperUtils.map(s, InstrumentoAsoRes.class));
              })
        );
  }

  @Override
  public Mono<InstrumentoAsoRes> getAsocProdInstrument(String idInstrumento) {
    return instrumentosRepo.findById(idInstrumento)
        .filter(itemf1 -> itemf1.getIndEliminado().equals(0))
        .map(s -> ModelMapperUtils.map(s, InstrumentoAsoRes.class))
        .switchIfEmpty(Mono.error(
            new Throwable("Instrumento no encontrado")
        ));
  }
  
  

}
