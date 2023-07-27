package com.bestbank.instrumentos.bussiness.utils;

import com.bestbank.instrumentos.domain.utils.TipoInstrumento;
import java.util.Date;
import java.util.Random;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * Clase que representa una tarjeta de débito falsa para pruebas y simulaciones.
 * Esta clase es utilizada para emular una tarjeta de débito en el sistema sin 
 * realizar operaciones reales.
 * Su propósito es proporcionar un objeto que cumpla con la interfaz de 
 * tarjeta de débito para pruebas y desarrollo.
 * 
 */
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
  private final Random random = new Random();
  

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
    StringBuilder sb = new StringBuilder();

    // Generar el número de tarjeta con 16 dígitos
    for (int i = 0; i < 16; i++) {
      int digit = random.nextInt(10);
      sb.append(digit);
    }
    return sb.toString();
  }

  private String generarCCV() {
    StringBuilder sb = new StringBuilder();
    // Generar el CCV con 3 dígitos
    for (int i = 0; i < 3; i++) {
      int digit = random.nextInt(10);
      sb.append(digit);
    }
    return sb.toString();
  }


}

