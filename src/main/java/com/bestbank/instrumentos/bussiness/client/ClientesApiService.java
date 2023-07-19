package com.bestbank.instrumentos.bussiness.client;

import com.bestbank.instrumentos.bussiness.dto.res.ClienteRes;
import com.bestbank.instrumentos.bussiness.dto.res.ProductoRes;

import reactor.core.publisher.Mono;

public interface ClientesApiService {
  
  Mono<ClienteRes> getClienteById(String idCliente);
  
  public Mono<ProductoRes> getProducto(String idProducto);
  
}
