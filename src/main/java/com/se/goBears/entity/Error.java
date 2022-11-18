package com.se.goBears.entity;

import org.springframework.http.HttpStatus;

public class Error {
    String message;
    HttpStatus code;


    public Error(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public  HttpStatus getCode() {
        return code;
    }

    public void setCode( HttpStatus code) {
        this.code = code;
    }

}
