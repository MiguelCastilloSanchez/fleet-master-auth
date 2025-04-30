package com.example.auth.infrastructure.config.exception;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.*;

@RestControllerAdvice
@SuppressWarnings("rawtypes")
public class ErrorsHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  public ResponseEntity handleError404() {
    return ResponseEntity.notFound().build();
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity handleError400(MethodArgumentNotValidException ex) {
    List<FieldError> errors = ex.getFieldErrors();

    List<ValidationErrorData> messages = new ArrayList<>(errors.size());

    errors.forEach(error -> {
      // If there's more than one error message for a field, the errors will be listed in the message
      if (messages.stream().anyMatch(dataErrorValidation -> Objects.equals(dataErrorValidation.field(), error.getField()))) {
        ValidationErrorData data = messages.stream().filter(dataErrorValidation ->
                Objects.equals(dataErrorValidation.field(), error.getField())
        ).findFirst().get();

        messages.remove(data);
        List<String> mensagens = data.messages();
        String errorMessage = error.getDefaultMessage();
        mensagens.add(errorMessage);
        messages.add(new ValidationErrorData(error.getField(), mensagens));
      } else {
        messages.add(new ValidationErrorData(error));
      }
    });

    return ResponseEntity.badRequest().body(messages);
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  public ResponseEntity handleError400(HttpMessageNotReadableException ex) {
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity handleValidationerror(ConstraintViolationException ex) {

    Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();

    List<ValidationErrorData> messages = new ArrayList<>(constraintViolations.size());

    constraintViolations.forEach(constraintViolation -> {
      // If there's more than one error message for a field, the errors will be listed in the message
      if (messages.stream().anyMatch(dataErrorValidation -> Objects.equals(dataErrorValidation.field(), constraintViolation.getPropertyPath().toString()))) {
        ValidationErrorData data = messages.stream().filter(dataErrorValidation ->
                Objects.equals(dataErrorValidation.field(), constraintViolation.getPropertyPath().toString())
        ).findFirst().get();
        messages.remove(data);

        List<String> mensagens = data.messages();
        mensagens.add(constraintViolation.getMessage());
        messages.add(new ValidationErrorData(constraintViolation.getPropertyPath().toString(),
                mensagens));
      }

      messages.add(new ValidationErrorData(constraintViolation.getPropertyPath().toString(),
              Collections.singletonList(constraintViolation.getMessage())));
    });

    return ResponseEntity.badRequest().body(messages);
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity handleError500(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error: " + ex.getLocalizedMessage());
  }

  @ExceptionHandler(JpaSystemException.class)
  public ResponseEntity handleError500(JpaSystemException ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error: " + ex.getLocalizedMessage());
  }

  private record ValidationErrorData(String field, List<String> messages) {
    public ValidationErrorData(FieldError error) {
      this(error.getField(), new ArrayList<>(Collections.singletonList(error.getDefaultMessage())));
    }
  }

}