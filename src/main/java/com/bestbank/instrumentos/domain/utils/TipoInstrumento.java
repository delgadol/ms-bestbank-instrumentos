package com.bestbank.instrumentos.domain.utils;

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
