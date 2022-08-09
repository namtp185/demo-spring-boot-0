package com.example.application.dto.request.validator;

import java.time.Instant;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InstantValidator implements ConstraintValidator<ValidInstant, Instant> {

    @Override
    public boolean isValid(Instant enteredInstant, ConstraintValidatorContext context) {
        return enteredInstant.isAfter(Instant.now());
    }
    
}
