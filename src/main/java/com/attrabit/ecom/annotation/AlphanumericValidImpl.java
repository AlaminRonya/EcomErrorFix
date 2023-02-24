package com.attrabit.ecom.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AlphanumericValidImpl implements ConstraintValidator<AlphanumericValid, String> {
    @Override
    public void initialize(AlphanumericValid constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value) || StringUtils.isEmpty(value.trim())) {
            return false;
        }

        Pattern pt = Pattern.compile("^[a-zA-Z0-9]+$");
        Matcher mt = pt.matcher(value.toString());
        return mt.matches();
    }

}