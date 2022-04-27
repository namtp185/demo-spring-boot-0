package com.example.application.dto.request.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.example.infrastructure.repository.RoleRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UniqueRolenameValidator implements ConstraintValidator<UniqueRolename, String> {

    RoleRepository roleRepository;

    @Override
    public boolean isValid(String roleName, ConstraintValidatorContext context) {
        return roleRepository.findByRoleName(roleName) == null;
    }
    
}
