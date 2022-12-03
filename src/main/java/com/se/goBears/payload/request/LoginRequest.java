package com.se.goBears.payload.request;

import javax.validation.constraints.NotBlank;


/**
 * This class defines all the variable and method declaration for the login request.
 */
public class LoginRequest {
    /**
     * This variable annotated with @NotBlank defines the username.
     */
    @NotBlank
    private String username;

    /**
     * This variable annotated with @NotBlank defines the password for the user.
     */
    @NotBlank
    private String password;


    /**
     * This method returns the username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the username.
     *
     * @param username is the username for the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method returns the password.
     *
     * @return user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method set the password for a user.
     *
     * @param password is the password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}