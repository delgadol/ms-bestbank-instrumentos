package com.bestbank.instrumentos.bussiness.client.impl;

import com.bestbank.instrumentos.bussiness.client.ClientesApiService;
import com.bestbank.instrumentos.bussiness.client.WebClientApi;
import com.bestbank.instrumentos.bussiness.dto.res.ClienteRes;
import com.bestbank.instrumentos.bussiness.dto.res.ProductoRes;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

/**
 * Implementación de la interfaz ClientesApiService que 
 * proporciona las operaciones para manipular la entidad de Clientes.
 */
@Log4j2
@Service
public class ClientesApiServiceImpl implements ClientesApiService {

  private final WebClientApi webClientApi;
  

  public ClientesApiServiceImpl(WebClientApi webClientApi) {
    super();
    this.webClientApi = webClientApi;
  }


  @Value("${app.simpleId}")
  private String simpleIdUrl;
  
  
  @Value("${app.clientesUrl}")
  private String clientesBaseUrl;
  
  @Value("${app.productosUrl}")
  private String productoBaseUrl;
  
  
  @Override
  public Mono<ClienteRes> getClienteById(String idCliente) {
    log.info(String.format("Consultando Api Cliente : %s", idCliente));
    return webClientApi.getMono(clientesBaseUrl,String.format(this.simpleIdUrl, idCliente), 
        ClienteRes.class, String.format("Error al Buscar Cliente : %s", idCliente));
  }


  @Override
  public Mono<ProductoRes> getProducto(String idProducto) {
    log.info(String.format("Consultando Api Producto : %s", idProducto));
    return webClientApi.getMono(productoBaseUrl,String.format(this.simpleIdUrl, idProducto), 
        ProductoRes.class, String.format("Error al Buscar Producto: %s", idProducto));
  }

}
