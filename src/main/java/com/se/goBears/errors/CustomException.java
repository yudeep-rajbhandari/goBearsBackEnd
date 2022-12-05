package com.se.goBears.errors;

/**
 * This class handles custom exceptions.
 */
public class CustomException extends RuntimeException {
     private String  message;

    public CustomException() {
    }

    public CustomException(
            String message) {
        this.message = message;

    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
