package com.se.goBears.payload.response;

import java.util.List;


/**
 * This class handles the Jwt response for user authorization.
 */
public class JwtResponse {
    /**
     * The variable defines the token to be generated for authorization.
     */
    private String token;
    /**
     * This variable defines the token type.
     */
    private String type = "Bearer";
    /**
     * The variable defines the user id.
     */
    private Long id;
    /**
     * The variable defines the username.
     */
    private String username;
    /**
     * The variable defines the user email.
     */
    private String email;
    /**
     * The variable defines the list of roles assigned to the user.
     */
    private List<String> roles;


    /**
     * This is the constructor for a JwtResponse object.
     *
     * @param accessToken is the generated access token.
     * @param id          is the user id.
     * @param username    is the username.
     * @param email       is the user email.
     * @param roles       is the user role.
     */
    public JwtResponse(String accessToken, Long id, String username, String email, List<String> roles) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    /**
     * This method returns the user access token
     *
     * @return access token
     */
    public String getAccessToken() {
        return token;
    }

    /**
     * This method sets the user access token
     *
     * @param accessToken is the access token to be set.
     */
    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    /**
     * This method returns the token type
     *
     * @return token type
     */
    public String getTokenType() {
        return type;
    }

    /**
     * This method sets the token type.
     *
     * @param tokenType token type to be set.
     */
    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    /**
     * THis method returns the user id.
     *
     * @return user id.
     */
    public Long getId() {
        return id;
    }

    /**
     * This method sets the user id.
     *
     * @param id user id to be set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method returns the user email.
     *
     * @return user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method sets the user email.
     *
     * @param email user email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method returns the username.
     *
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method sets the user username.
     *
     * @param username username.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This method returns a list of user roles.
     *
     * @return a list of user roles.
     */
    public List<String> getRoles() {
        return roles;
    }
}

