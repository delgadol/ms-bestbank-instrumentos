package com.bestbank.instrumentos.domain.models;

import java.util.Date;

import com.bestbank.instrumentos.domain.utils.GrupoProducto;
import com.bestbank.instrumentos.domain.utils.TipoProducto;

import lombok.Data;

@Data
public class ProductoAsociado {
  
  private String id;
  
  private String codigoProducto;
  
  private String indDefecto;
  
  private TipoProducto tipoProducto;
  
  private GrupoProducto grupoProducto;

  private Integer indEliminado;
  
  private Date fechaCreacion;
  
  private Date fechaModificacion;

}
