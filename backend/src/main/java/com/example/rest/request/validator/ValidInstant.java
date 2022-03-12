package com.example.rest.request.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = InstantValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidInstant {
    // https://stackoverflow.com/questions/16317207/spring-validation-between-two-date-fields/67807163#67807163

    String message() default "receiveTime must be after current timestamp";

    Class<?>[] groups() default {};

    Class<? extends Payload> [] payload() default {};

}
