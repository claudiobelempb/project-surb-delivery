package br.com.surb.surbdeliver.shared.exeptions.resource;

import br.com.surb.surbdeliver.shared.constants.AppExceptionMessageConstants;
import br.com.surb.surbdeliver.shared.exeptions.service.AppDataBaseException;
import br.com.surb.surbdeliver.shared.exeptions.service.AppEntityNotFoundException;
import br.com.surb.surbdeliver.shared.exeptions.service.AppForbiddenException;
import br.com.surb.surbdeliver.shared.exeptions.service.AppUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice
public class AppResourceAdviceExceptionHandler implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final AppStandarError error = new AppStandarError();

    @ExceptionHandler(AppEntityNotFoundException.class)
    public ResponseEntity<AppStandarError> entityNotFound(
      AppEntityNotFoundException error, HttpServletRequest request) {
      HttpStatus status = HttpStatus.NOT_FOUND;
      AppStandarError err = new AppStandarError();
      err.setTimestamp(Instant.now());
      err.setStatus(status.value());
      err.setError(AppExceptionMessageConstants.RESOURCE_NOT_FOUND);
      err.setMessage(error.getMessage());
      err.setPath(request.getRequestURI());
      return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AppDataBaseException.class)
    public ResponseEntity<AppStandarError> database(AppDataBaseException e, HttpServletRequest request) {
      HttpStatus status = HttpStatus.BAD_REQUEST;
      AppStandarError err = new AppStandarError();
      err.setTimestamp(Instant.now());
      err.setStatus(status.value());
      err.setError(AppExceptionMessageConstants.DATABASE_EXCEPTION);
      err.setMessage(e.getMessage());
      err.setPath(request.getRequestURI());
      return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<AppValidationError> validation(
      MethodArgumentNotValidException e, HttpServletRequest request) {
      HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
      AppValidationError err = new AppValidationError();
      err.setTimestamp(Instant.now());
      err.setStatus(status.value());
      err.setError(AppExceptionMessageConstants.VALIDATION_EXCEPTION);
      err.setMessage(e.getMessage());
      err.setPath(request.getRequestURI());

      for (FieldError field : e.getBindingResult().getFieldErrors()) {
        err.addError(field.getField(), field.getDefaultMessage());
      }

      return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(AppForbiddenException.class)
    public ResponseEntity<AppOAuthCustomError> forbidden(AppForbiddenException e, HttpServletRequest request) {
      HttpStatus status = HttpStatus.FORBIDDEN;
      AppOAuthCustomError customError = new AppOAuthCustomError("Forbidden", e.getMessage());
      return ResponseEntity.status(status).body(customError);
    }

    @ExceptionHandler(AppUnauthorizedException.class)
    public ResponseEntity<AppOAuthCustomError> unauthorized(AppUnauthorizedException e, HttpServletRequest request) {
      HttpStatus status = HttpStatus.UNAUTHORIZED;
      AppOAuthCustomError customError = new AppOAuthCustomError("Unauthorized", e.getMessage());
      return ResponseEntity.status(status).body(customError);
    }
  }
