package com.bestbank.instrumentos.bussiness.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

/**
 * Clase que proporciona funciones y utilidades relacionadas con operaciones bancarias.
 */
public class BankFnUtils {
  
  public static String uniqueProductCode() {
    UUID uuid = UUID.randomUUID();
    return uuid.toString();
  }
  
  public static java.sql.Timestamp getDateTime() {
    return java.sql.Timestamp.valueOf(LocalDateTime.now());
  }
  
  public static Date getLegacyDateTimeNow() {
    LocalDate currentDate = LocalDate.now();
    LocalDate dateToReturn = currentDate.withDayOfMonth(currentDate.getDayOfMonth());
    return Date.from(dateToReturn.atStartOfDay(ZoneId.systemDefault()).toInstant());
  }
  
}
