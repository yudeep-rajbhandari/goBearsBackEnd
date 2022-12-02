package com.se.goBears.payload.response;


/**
 * This is a message response class to generate custom authorization message.
 */
public class MessageResponse {
    /**
     * This variable defines the message.
     */
    private String message;

    /**
     * This method sets the response message.
     *
     * @param message message to be set.
     */
    public MessageResponse(String message) {
        this.message = message;
    }

    /**
     * This method returns the response message.
     *
     * @return reponse message.
     */
    public String getMessage() {
        return message;
    }

    /**
     * This method sets the response message.
     *
     * @param message is the message to be set.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
