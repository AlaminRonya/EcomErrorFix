package com.attrabit.ecom.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiMessage extends Throwable {
    private final String message;
}
