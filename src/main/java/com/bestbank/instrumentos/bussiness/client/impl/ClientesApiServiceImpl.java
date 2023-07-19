package com.bestbank.instrumentos.bussiness.client.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bestbank.instrumentos.bussiness.client.ClientesApiService;
import com.bestbank.instrumentos.bussiness.client.WebClientApi;
import com.bestbank.instrumentos.bussiness.dto.res.ClienteRes;
import com.bestbank.instrumentos.bussiness.dto.res.ProductoRes;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class ClientesApiServiceImpl implements ClientesApiService{


  @Value("${app.clientesUrl}")
  private String clientesUrl;
  
  @Value("${app.productosUrl}")
  private String productoUrl;
  
  
  @Override
  public Mono<ClienteRes> getClienteById(String idCliente) {
    log.info(String.format("Consultando Api Cliente : %s", idCliente));
    return WebClientApi.getMono(String.format(this.clientesUrl, idCliente), 
        ClienteRes.class, String.format("Error al Buscar Cliente : %s", idCliente));
  }


  @Override
  public Mono<ProductoRes> getProducto(String idProducto) {
    log.info(String.format("Consultando Api Producto : %s", idProducto));
    return WebClientApi.getMono(String.format(this.productoUrl, idProducto), 
        ProductoRes.class, String.format("Error al Buscar Producto: %s", idProducto));
  }

}
