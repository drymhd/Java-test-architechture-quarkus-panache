package com.drymhd.rest.utils;

public class ExceptionResponse extends Exception {
    protected String message;
    protected int code;
    public ExceptionResponse(String message, int code){
        this.message    = message;
        this.code       = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }
}
