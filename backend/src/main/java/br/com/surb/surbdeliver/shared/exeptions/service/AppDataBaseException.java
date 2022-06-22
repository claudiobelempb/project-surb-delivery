package br.com.surb.surbdeliver.shared.exeptions.service;

import java.io.Serial;
import java.io.Serializable;

public class AppDataBaseException extends RuntimeException implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  public AppDataBaseException(String message) {
    super(message);
  }
}
