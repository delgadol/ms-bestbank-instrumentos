package com.bestbank.instrumentos.domain.utils;

/**
 * Enumerado que representa los diferentes tipos de instrumentos en el sistema.
 * Este enumerado contiene los posibles valores para el tipo de instrumento 
 * utilizado en algún contexto del sistema.
 */

public enum TipoInstrumento {
  
  TARJETA_DEBITO("Tajeta Debito"),
  CHEQUERA_25CHEQUES("Chequera 25 Cheques"),
  CHEQUERA_100CHEQUES("Chequera 100 Cheques");
  
  private String description;

  private TipoInstrumento(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
  

}
