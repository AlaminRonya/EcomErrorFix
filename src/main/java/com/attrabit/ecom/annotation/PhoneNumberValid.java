package com.attrabit.ecom.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidImpl.class)
public @interface PhoneNumberValid {
    String message() default "{error.phoneNumber}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
