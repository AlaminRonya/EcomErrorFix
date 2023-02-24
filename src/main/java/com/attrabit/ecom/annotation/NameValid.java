package com.attrabit.ecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NameValidImpl.class)
public @interface NameValid {
    String message() default "{error.name}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
