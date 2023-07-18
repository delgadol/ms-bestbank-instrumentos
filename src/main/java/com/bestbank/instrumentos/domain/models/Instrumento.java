package com.bestbank.instrumentos.domain.models;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Instrumento {
  
  @Id
  private String id;
  
  private TipoInstrumento tipoInstrumento;
  
  private String codigoInstrumento;
  
  private String codPersona;
  
  private Integer indEliminado;
  
  private List<ProductoAsociado> productosAsociados;
  
  private String Estado;
  
  private Date fecCreacion;
  
  private Date fecModificacion;
  

}
