package com.attrabit.ecom.annotation;

import io.micrometer.common.util.StringUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NullValidImpl implements ConstraintValidator<NullValid, String> {

    @Override
    public void initialize(NullValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(value.trim()) || value.equals("")) {
            return false;
        }

        return true;
    }

}
