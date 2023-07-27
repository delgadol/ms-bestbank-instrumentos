package com.bestbank.instrumentos.domain.models;

import com.bestbank.instrumentos.domain.utils.GrupoProducto;
import com.bestbank.instrumentos.domain.utils.TipoProducto;
import lombok.Data;

/**
 * Clase que representa un producto asociado a un instrumento en el sistema.
 * Esta clase contiene información y datos relacionados con un producto 
 * específico asociado a un instrumento.
 * 
 */

@Data
public class ProductoAsociado {
  
  private String id;
  
  private String codigoProducto;
  
  private Integer indDefecto;
  
  private TipoProducto tipoProducto;
  
  private GrupoProducto grupoProducto;


}
