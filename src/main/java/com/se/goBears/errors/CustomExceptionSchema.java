package com.se.goBears.errors;

/**
 * This is a custom exception class generated to display error messages.
 */
public class CustomExceptionSchema {
    /**
     * This variable defines the message for the error.
     */
    private String message;

    /**
     * This is a constructor.
     */
    protected CustomExceptionSchema() {
    }

    /**
     * This is a constructor that sets the message value.
     *
     * @param message is the message for the error.
     */
    public CustomExceptionSchema(
            String message) {
        this.message = message;

    }

    /**
     * This method returns the error message.
     *
     * @return error message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the error message.
     *
     * @param message is the error mesage to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }


}
