package com.attrabit.ecom.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidImpl implements ConstraintValidator<NameValid, String> {
    private final Pattern VALID_NAME_REGEX = Pattern.compile("^[A-Z][a-zA-z .:-]+");


    @Override
    public void initialize(NameValid constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isEmpty(s) || StringUtils.isEmpty(s.trim())) {
            return false;
        }
        Matcher matcher = VALID_NAME_REGEX.matcher(s);
        return matcher.find();
    }
}
