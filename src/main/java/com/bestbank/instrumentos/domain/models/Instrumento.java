package com.bestbank.instrumentos.domain.models;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Instrumento {
  
  @Id
  private String id;
  
  private TipoInstrumento tipoInstrumento;
  
  private String codigoInstrumento;
  
  private String codPersona;
  
  private String codControl;
  
  private Date fecInicio;
  
  private Date fecFinal;
  
  private List<ProductoAsociado> productosAsociados;
  
  private Integer indEliminado;
  
  private String estado;
  
  private Date fecCreacion;
  
  private Date fecModificacion;
  

}
