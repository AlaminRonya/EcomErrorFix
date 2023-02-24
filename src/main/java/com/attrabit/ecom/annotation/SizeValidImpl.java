package com.attrabit.ecom.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

public class SizeValidImpl implements ConstraintValidator<SizeValid, String> {
    private int min;
    private int max;

    @Override
    public void initialize(SizeValid constraintAnnotation) {
        this.min = constraintAnnotation.min();
        this.max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(value.trim())) {
            return false;
        }

        return value.length() >= this.min && value.length() <= this.max;
    }

}