package com.bestbank.instrumentos.bussiness.dto.req;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class InstrumentoReq {

  @NotNull
  private TipoInstrumento tipoInstrumento;
  
  @NotNull
  private String codPersona;
  
  @NotNull
  private Integer addAutoCtasPasivas;
  
  
}
