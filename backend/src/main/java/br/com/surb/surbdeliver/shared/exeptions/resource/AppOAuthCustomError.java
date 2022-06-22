package br.com.surb.surbdeliver.shared.exeptions.resource;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;

public class AppOAuthCustomError implements Serializable {
  @Serial
  private static final long serialVersionUID = 1L;

  private String error;

  @JsonProperty("error_description")
  private String errorDescription;

  public AppOAuthCustomError(){}

  public AppOAuthCustomError(String error, String errorDescription) {
    this.error = error;
    this.errorDescription = errorDescription;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }

  public String getErrorDescription() {
    return errorDescription;
  }

  public void setErrorDescription(String errorDescription) {
    this.errorDescription = errorDescription;
  }
}
