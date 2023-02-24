package com.attrabit.ecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordValidImpl.class)
public @interface PasswordValid {
    String message() default "{error.password}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
