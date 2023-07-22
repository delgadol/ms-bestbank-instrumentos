package com.bestbank.instrumentos.bussiness.dto.res;

import java.util.List;

import com.bestbank.instrumentos.domain.models.ProductoAsociado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class InstrumentoAsoRes extends InstrumentoRes {
  
  private String codPersona;

  private List<ProductoAsociado> productosAsociados;
  
}
