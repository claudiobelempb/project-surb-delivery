package br.com.surb.surbdeliver.shared.validator;

import java.util.Objects;

public class AppValidationErro {
  private final String field;
  private final String errorCode;

  public AppValidationErro(String field, String errorCode) {
    this.field = field;
    this.errorCode = errorCode;
  }

  public String getField() {
    return field;
  }

  public String getErrorCode() {
    return errorCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AppValidationErro that = (AppValidationErro) o;
    return field.equals(that.field) && errorCode.equals(that.errorCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, errorCode);
  }

  @Override
  public String toString() {
    return "AppValidationErrorApp{" +
      "field='" + field + '\'' +
      ", errorCode='" + errorCode + '\'' +
      '}';
  }
}
