package com.bestbank.instrumentos.bussiness.dto.res;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;
import java.util.Date;
import lombok.Data;

/**
 * Clase que representa la respuesta de una solicitud de instrumento.
 *Contiene información y datos relacionados con la respuesta de un instrumento 
 *específico.
 *
 */
@Data
public class InstrumentoRes {

  private String id;
  
  private TipoInstrumento tipoInstrumento;
  
  private String codigoInstrumento;
  
  private Date fecInicio;
  
  private Date fecFinal;
  
  private Date fecCreacion;
  
}
