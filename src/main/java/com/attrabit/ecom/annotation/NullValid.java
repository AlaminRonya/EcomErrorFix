package com.attrabit.ecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NullValidImpl.class)
public @interface NullValid {

    String message() default "{error.empty}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}