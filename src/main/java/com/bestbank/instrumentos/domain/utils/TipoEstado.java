package com.bestbank.instrumentos.domain.utils;

public enum TipoEstado {
  
  NORMAL("0"),
  SOLO_CONSULTAS("1"),
  SUSPENDIDO("2");
  
  TipoEstado(String descripcion) {
    this.valor = descripcion;
  }

  private String valor;

  public String getValor() {
    return valor;
  }
  
  
  
}
