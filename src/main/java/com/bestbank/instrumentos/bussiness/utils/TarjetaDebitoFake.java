package com.bestbank.instrumentos.bussiness.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import lombok.Data;

@Data
public class TarjetaDebitoFake {
  
  private String codigoInstrumento;
  private String codControl;
  private Date fecInicio;
  private Date fecFinal;

  public TarjetaDebitoFake() {
    generarDatosTarjeta();
  }

  private void generarDatosTarjeta() {
    codigoInstrumento = generarNumeroTarjeta();
    codControl = generarCCV();
    LocalDate currentDate = LocalDate.now();
    LocalDate firstDayOfMonth = currentDate.withDayOfMonth(1);
    LocalDate lastDayOfMonth = currentDate.withDayOfMonth(currentDate.lengthOfMonth());
    lastDayOfMonth = lastDayOfMonth.plusYears(5);

    fecInicio = Date.from(firstDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    fecFinal = Date.from(lastDayOfMonth.atStartOfDay(ZoneId.systemDefault()).toInstant());
    
  }

  private String generarNumeroTarjeta() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();

    // Generar el número de tarjeta con 16 dígitos
    for (int i = 0; i < 16; i++) {
      int digit = random.nextInt(10);
      sb.append(digit);
    }
    return sb.toString();
  }

  private String generarCCV() {
    Random random = new Random();
    StringBuilder sb = new StringBuilder();
    // Generar el CCV con 3 dígitos
    for (int i = 0; i < 3; i++) {
      int digit = random.nextInt(10);
      sb.append(digit);
    }
    return sb.toString();
  }


}

