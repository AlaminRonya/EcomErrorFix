package com.attrabit.ecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = AlphanumericValidImpl.class)
public @interface AlphanumericValid {

    String message() default "{error.alphanumeric}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
