package com.bestbank.instrumentos.bussiness.dto.res;


import com.bestbank.instrumentos.domain.utils.GrupoProducto;
import com.bestbank.instrumentos.domain.utils.TipoCliente;
import com.bestbank.instrumentos.domain.utils.TipoProducto;
import lombok.Data;

/**
 * Clase que representa la respuesta de un producto.
 */
@Data
public class ProductoRes {
  
  private String id;
  
  private GrupoProducto grupoProducto;
  
  private TipoProducto tipoProducto;
  
  private String codigoProducto;
  
  private String codigoPersona;
  
  private String estado;
  
  private TipoCliente tipoCliente;
  
  private Integer maxOperacionesMes;
  
  private Integer minDiaMesOperacion;  
  

}
