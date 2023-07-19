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
import com.bestbank.instrumentos.bussiness.services.impl.InstrumentosServiceImpl;

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


  @PostMapping("")
  public Mono<InstrumentoRes> postInstrument(@Valid @RequestBody InstrumentoReq instrumento) {
    return servInstrumentos.postInstrument(instrumento);
  }
  
  
  @GetMapping("/{idInstrumento}")
  public Mono<InstrumentoRes> getinstrumenById(
      @PathVariable(name = "idInstrumento") String idInstrumento) {
    return servInstrumentos.getInstrumentById(idInstrumento);
  }
  
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
  
  @DeleteMapping("/{idInstrumento}/asociaciones/{idProducto}")
  public Mono<InstrumentoAsoRes> delAsocProdInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento, 
      @PathVariable(name = "idProducto") String idProducto) {
    return servInstrumentos.delAsocProdInstrument(idInstrumento, idProducto);
  } 
  
  @GetMapping("/{idInstrumento}/asociaciones")
  public Mono<InstrumentoAsoRes> getAsocProdInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento) {
    return servInstrumentos.getAsocProdInstrument(idInstrumento);
  } 
  
}
