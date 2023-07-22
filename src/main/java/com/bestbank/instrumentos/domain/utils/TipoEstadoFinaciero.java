package com.bestbank.instrumentos.domain.utils;

/**
 * Enumerado que representa los diferentes tipos de estados 
 * financieros en el sistema.
 * Este enumerado contiene los posibles valores para el estado 
 * financiero de algún elemento en el sistema.
 * 
 */

public enum TipoEstadoFinaciero {
  
  SOLVENTE("SOLVENTE"),
  DEUDOR("DEUDOR");
  
  TipoEstadoFinaciero(String descripcion) {
    this.descripcion = descripcion;
  }

  private String descripcion;

  public String getDescripcion() {
    return descripcion;
  }
  

}
