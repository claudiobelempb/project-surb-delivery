package br.com.surb.surbdeliver.shared.validator;

import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppValidationErrors implements Streamable<AppValidationErro> {

  private static final long serialVersionUID = 1L;

  private final List<AppValidationErro> validationErrors;

  public AppValidationErrors() {
    this.validationErrors = new ArrayList<>();
  }

  public AppValidationErrors addErrors(String field, String errorCode) {
    return addErrors(new AppValidationErro(field, errorCode));
  }

  public AppValidationErrors addErrors(AppValidationErro validationError) {
    validationErrors.add(validationError);
    return this;
  }

  public AppValidationErro getErrorIndex(int index) {
    return validationErrors.get(index);
  }

  public int getErrorOfNumber() {
    return validationErrors.size();
  }

  public boolean hasErrors(){
    return !validationErrors.isEmpty();
  }

  @Override
  public String toString() {
    return "ValidationErrors{" +
      "validationErrors=" + validationErrors +
      '}';
  }

  @Override
  public Iterator<AppValidationErro> iterator() {
    return validationErrors.iterator();
  }
}
