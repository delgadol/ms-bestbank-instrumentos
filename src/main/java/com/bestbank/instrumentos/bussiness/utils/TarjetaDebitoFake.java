package com.bestbank.instrumentos.bussiness.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class TarjetaDebitoFake {
  
  private String codigoInstrumento;
  private String codControl;
  private Date fecInicio;
  private Date fecFinal;
  // Adcionales //
  private Integer indEliminado;
  private String estado;
  private Date fecCreacion;  
  private Date fecModificacion;
  private TipoInstrumento tipoInstrumento;
  
  

  public TarjetaDebitoFake() {
    generarDatosTarjeta();
  }

  private void generarDatosTarjeta() {
    codigoInstrumento = generarNumeroTarjeta();
    codControl = generarCCV();
    fecInicio = BankFnUtils.getLegacyFirtDateOfMonth();
    fecFinal = BankFnUtils.getLegacyEndDateOfMonth(5);
    // Adcionales //
    indEliminado = 0;
    estado = "0";
    fecCreacion = BankFnUtils.getLegacyDateTimeNow();  
    fecModificacion = BankFnUtils.getLegacyDateTimeNow();
    tipoInstrumento = TipoInstrumento.TARJETA_DEBITO;
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

