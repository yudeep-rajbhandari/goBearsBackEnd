package com.se.goBears.entity;

import org.springframework.http.HttpStatus;

/**
 * This class defines custom class for the error generation.
 */
public class Error {
    /**
     * This variable stores a custom message for a specified error code.
     */
    String message;
    /**
     * This variable defines a specific code for an error.
     */
    HttpStatus code;


    /**
     * This method with an input message and code returns an error object with defined message and error code.
     *
     * @param message is the message for the error.
     * @param code    is the error code for an error.
     */
    public Error(String message, HttpStatus code) {
        this.message = message;
        this.code = code;
    }

    /**
     * This method returns the defined error message.
     *
     * @return the error message
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the defined error message.
     *
     * @param message is the message to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * This method returns the code for the error.
     *
     * @return code for the error.
     */
    public HttpStatus getCode() {
        return code;
    }

    /**
     * This method sets the code for the error.
     *
     * @param code is the code to be set.
     */
    public void setCode(HttpStatus code) {
        this.code = code;
    }

}
