package com.bestbank.instrumentos.bussiness.dto.req;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa una solicitud de instrumento. 
 * Contiene información y datos relacionados con un instrumento específico.
 */
@Data
public class InstrumentoReq {

  @NotNull
  private TipoInstrumento tipoInstrumento;
  
  @NotNull
  private String codPersona;
    
  
}
