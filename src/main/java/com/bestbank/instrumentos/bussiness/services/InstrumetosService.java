package com.bestbank.instrumentos.bussiness.services;

import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoAsoRes;
import com.bestbank.instrumentos.bussiness.dto.res.InstrumentoRes;

import reactor.core.publisher.Mono;

public interface InstrumetosService {
  
  public Mono<InstrumentoRes> getinstrumenById(String idInstrumento);
  
  public Mono<InstrumentoRes> delInstrumenById(String idInstrumento);
  
  public Mono<InstrumentoAsoRes> putAsocProdInstrument(String idInstrumento, 
      String idProducto);
  
  public Mono<InstrumentoAsoRes> delAsocProdInstrument(String idInstrumento, 
      String idProducto);
  
  public Mono<InstrumentoAsoRes> getAsocProdInstrument(String idInstrumento); 

}
