package com.example.rest.request.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class LatitudeValidator implements ConstraintValidator<ValidLatitude, Double> {

    @Override
    public boolean isValid(Double enteredLat, ConstraintValidatorContext context) {
        return -90 < enteredLat && enteredLat < 90;
    }
    
}
