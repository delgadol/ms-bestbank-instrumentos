package com.bestbank.instrumentos.bussiness.dto.res;

import java.util.Date;


import com.bestbank.instrumentos.domain.utils.TipoInstrumento;

import lombok.Data;

@Data
public class InstrumentoRes {

  private String id;
  
  private TipoInstrumento tipoInstrumento;
  
  private String codigoInstrumento;
  
  private Date fecInicio;
  
  private Date fecFinal;
  
}
