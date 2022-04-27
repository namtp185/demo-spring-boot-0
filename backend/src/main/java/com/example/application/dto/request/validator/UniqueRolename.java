package com.example.application.dto.request.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueRolenameValidator.class)
public @interface UniqueRolename {
    String message() default "role existed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
