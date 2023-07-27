package com.bestbank.instrumentos.bussiness.dto.res;


import com.bestbank.instrumentos.domain.utils.TipoCliente;
import com.bestbank.instrumentos.domain.utils.TipoEstadoFinaciero;
import lombok.Data;

/**
 * Clase que representa la respuesta de un cliente.
 */
@Data
public class ClienteRes {
  
  private String id;
  
  private String nombres;
  
  private String apellidos;
  
  private String estado;
  
  private TipoCliente tipoCliente;
  
  private TipoEstadoFinaciero estadoFinanciero;
  
}
