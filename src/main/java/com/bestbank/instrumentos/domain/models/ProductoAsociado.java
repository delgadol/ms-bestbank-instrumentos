package com.bestbank.instrumentos.domain.models;

import com.bestbank.instrumentos.domain.utils.GrupoProducto;
import com.bestbank.instrumentos.domain.utils.TipoProducto;

import lombok.Data;

@Data
public class ProductoAsociado {
  
  private String id;
  
  private String codigoProducto;
  
  private Integer indDefecto;
  
  private TipoProducto tipoProducto;
  
  private GrupoProducto grupoProducto;


}
