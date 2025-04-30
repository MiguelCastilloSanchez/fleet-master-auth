package com.example.auth.infrastructure.user.validation.security;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = RightCodeValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RightCode {
  String message() default "The code is not valid.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}