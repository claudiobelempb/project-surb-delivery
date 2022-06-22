package br.com.surb.surbdeliver.shared.exeptions.service;

import org.springframework.boot.context.properties.bind.validation.ValidationErrors;

import java.io.Serial;
import java.io.Serializable;

public class AppInvalidRequestException extends RuntimeException implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private final ValidationErrors validationErrors;

  public AppInvalidRequestException(ValidationErrors validationErrors) {
    super(validationErrors.toString());
    this.validationErrors = validationErrors;
  }

  public ValidationErrors getValidationErrors() {
    return validationErrors;
  }
}
