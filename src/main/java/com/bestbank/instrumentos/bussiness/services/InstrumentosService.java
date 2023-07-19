package com.bestbank.instrumentos.bussiness.services;

import org.springframework.web.bind.annotation.RequestBody;

import com.bestbank.instrumentos.bussiness.dto.req.InstrumentoReq;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoAsoRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoRes;

import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

public interface InstrumentosService {
  
  public Mono<InstrumentoRes> postInstrument(InstrumentoReq instrumento);
  
  public Mono<InstrumentoRes> getInstrumentById(String idInstrumento);
  
  public Mono<InstrumentoRes> delInstrumenById(String idInstrumento);
  
  public Mono<InstrumentoAsoRes> putAsocProdInstrument(String idInstrumento, 
      String idProducto);
  
  public Mono<InstrumentoAsoRes> delAsocProdInstrument(String idInstrumento, 
      String idProducto);
  
  public Mono<InstrumentoAsoRes> getAsocProdInstrument(String idInstrumento); 

}
