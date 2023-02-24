package com.attrabit.ecom.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidImpl implements ConstraintValidator<PasswordValid, String> {
    private final Pattern VALID_PASSWORD_REGEX = Pattern.compile("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$");

    @Override
    public void initialize(PasswordValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s) || StringUtils.isEmpty(s.trim())) {
            return false;
        }
        Matcher matcher = VALID_PASSWORD_REGEX.matcher(s);
        return matcher.find();
    }
}
