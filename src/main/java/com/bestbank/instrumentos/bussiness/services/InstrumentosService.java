package com.bestbank.instrumentos.bussiness.services;

import com.bestbank.instrumentos.bussiness.dto.req.InstrumentoReq;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoAsoRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoRes;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Interfaz que define las operaciones disponibles para manipular instrumentos. 
 * Proporciona métodos para obtener información y realizar acciones relacionadas 
 * con instrumentos.
 */
public interface InstrumentosService {
  
  public Mono<InstrumentoRes> postInstrument(InstrumentoReq instrumento);
  
  public Mono<InstrumentoRes> getInstrumentById(String idInstrumento);
  
  public Mono<InstrumentoRes> delInstrumenById(String idInstrumento);
  
  public Mono<InstrumentoAsoRes> putAsocProdInstrument(String idInstrumento, 
      String idProducto);
  
  public Mono<InstrumentoAsoRes> delAsocProdInstrument(String idInstrumento, 
      String idProducto);
  
  public Mono<InstrumentoAsoRes> getAsocProdInstrument(String idInstrumento); 
  
  public Flux<InstrumentoRes> getAllInstrumentByClientId(String idCliente); 

}
