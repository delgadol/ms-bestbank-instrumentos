package com.bestbank.instrumentos.exposed;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bestbank.instrumentos.bussiness.dto.req.InstrumentoReq;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoAsoRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoRes;
import com.bestbank.instrumentos.bussiness.services.InstrumentosService;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/instrumentos")
@Validated
public class InstrumentosRestService {
  
  private final InstrumentosService servInstrumentos; 
  
  
  
  public InstrumentosRestService(InstrumentosService servInstrumentos) {
    this.servInstrumentos = servInstrumentos;
  }

  /**
   * Crea un nuevo instrumento en el sistema a partir de los datos proporcionados
   *  en la solicitud.
   *
   * @param instrumento El objeto InstrumentoReq que contiene los datos 
   * del nuevo instrumento a crear.
   * @return Un Mono con la respuesta de la solicitud (InstrumentoRes).
   */

  /**
   * Crea un nuevo instrumento en el sistema a partir de los datos proporcionados 
   * en la solicitud.
   *
   * @param instrumento El objeto InstrumentoReq que contiene los datos del nuevo 
   * instrumento a crear.
   * @return Un Mono que representa la respuesta de la solicitud (InstrumentoRes).
   */
  @PostMapping("")
  public Mono<InstrumentoRes> postInstrument(@Valid @RequestBody InstrumentoReq instrumento) {
    return servInstrumentos.postInstrument(instrumento);
  }
  
  /**
   * Obtiene un instrumento del sistema por su identificador único.
   *
   * @param idInstrumento El identificador único del instrumento que se desea obtener.
   * @return Un Mono que representa la respuesta de la solicitud (InstrumentoRes).
   */
  @GetMapping("/{idInstrumento}")
  public Mono<InstrumentoRes> getinstrumenById(
      @PathVariable(name = "idInstrumento") String idInstrumento) {
    return servInstrumentos.getInstrumentById(idInstrumento);
  }
  
  /**
   * Elimina un instrumento del sistema por su identificador único.
   *
   * @param idInstrumento El identificador único del instrumento que se desea eliminar.
   * @return Un Mono que representa la respuesta de la solicitud (InstrumentoRes).
   */

  @DeleteMapping("/{idInstrumento}")
  public Mono<InstrumentoRes> delInstrumenById(
      @PathVariable(name = "idInstrumento") String idInstrumento) {
    return servInstrumentos.delInstrumenById(idInstrumento);
  }
  
  
  @PutMapping("/{idInstrumento}/asociaciones/{idProducto}")
  public Mono<InstrumentoAsoRes> putAsocProdInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento, 
      @PathVariable(name = "idProducto") String idProducto) {
    return servInstrumentos.putAsocProdInstrument(idInstrumento, idProducto);
  } 
  
  /**
   * Asocia un producto específico a un instrumento en el sistema.
   *
   * @param idInstrumento El identificador único del instrumento al que se desea asociar 
   * el producto.
   * @param idProducto El identificador único del producto que se desea asociar al instrumento.
   * @return Un Mono que representa la respuesta de la solicitud (InstrumentoAsoRes).
   */

  @DeleteMapping("/{idInstrumento}/asociaciones/{idProducto}")
  public Mono<InstrumentoAsoRes> delAsocProdInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento, 
      @PathVariable(name = "idProducto") String idProducto) {
    return servInstrumentos.delAsocProdInstrument(idInstrumento, idProducto);
  } 
  
  /**
   * Desasocia un producto específico de un instrumento en el sistema.
   *
   * @param idInstrumento El identificador único del instrumento del que se desea desasociar 
   * el producto.
   * @param idProducto El identificador único del producto que se desea desasociar del 
   * instrumento.
   * @return Un Mono que representa la respuesta de la solicitud (InstrumentoAsoRes).
   */
  @GetMapping("/{idInstrumento}/asociaciones")
  public Mono<InstrumentoAsoRes> getAsocProdInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento) {
    return servInstrumentos.getAsocProdInstrument(idInstrumento);
  } 
  
}
