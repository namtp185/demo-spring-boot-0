package com.example.application.dto.request.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LongtitudeValidator implements ConstraintValidator<ValidLongtitude, Double> {

    @Override
    public boolean isValid(Double enteredLon, ConstraintValidatorContext context) {
        return -180 < enteredLon && enteredLon < 180;
    }
    
}
