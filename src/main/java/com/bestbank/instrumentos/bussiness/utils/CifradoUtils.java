package com.bestbank.instrumentos.bussiness.utils;

public class CifradoUtils {

  public static String cifrarFake(String mensaje, int clave) {
    StringBuilder resultado = new StringBuilder();

    for (int i = 0; i < mensaje.length(); i++) {
      char caracter = mensaje.charAt(i);

      if (Character.isLetter(caracter)) {
        char base = Character.isUpperCase(caracter) ? 'A' : 'a';
        caracter = (char) (((caracter - base + clave) % 26) + base);
      }
      
      resultado.append(caracter);
    }

    return resultado.toString();
  }
  
  public static String descifrarCesar(String mensajeCifrado, int clave) {
    return cifrarFake(mensajeCifrado, 26 - clave);
  }
}
