package com.bestbank.instrumentos.domain.utils;

/**
 * Enumerado que representa los diferentes tipos de estados un cliente.
 * Este enumerado contiene los posibles valores para el estado de algún 
 * elemento en el sistema.
 */
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
