package com.attrabit.ecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = EmailValidImpl.class)
public @interface EmailValid {
    String message() default "{error.email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
