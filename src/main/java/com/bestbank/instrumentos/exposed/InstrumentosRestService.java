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

import com.bestbank.instrumentos.bussiness.dto.req.InstrumentoModReq;
import com.bestbank.instrumentos.bussiness.dto.req.InstrumentoReq;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoAsoRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoRes;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/v1/instrumentos")
@Validated
public class InstrumentosRestService {
  
  
  
  @PostMapping("")
  public Mono<InstrumentoRes> postInstrument(@Valid @RequestBody InstrumentoReq instrumento) {
    return null;
  }
  
  
  @PutMapping("/{idInstrumento}")
  public Mono<InstrumentoRes> putInstrument(@Valid @RequestBody InstrumentoModReq instrumento) {
    return null;
  }
  
  @GetMapping("/{idInstrumento}")
  public Mono<InstrumentoRes> getinstrumenById(@)
  
  @PutMapping("/{idInstrumento}/asociaciones/{idProducto}")
  public Mono<InstrumentoAsoRes> putAsocProInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento, 
      @PathVariable(name = "idProducto") String idProducto) {
    return null;
  } 
  
  @DeleteMapping("/{idInstrumento}/asociaciones/{idProducto}")
  public Mono<InstrumentoAsoRes> delAsocProInstrument(
      @PathVariable(name = "idInstrumento") String idInstrumento, 
      @PathVariable(name = "idProducto") String idProducto) {
    return null;
  } 
  

}
