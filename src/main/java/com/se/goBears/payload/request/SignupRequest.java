package com.se.goBears.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;


/**
 * This class handles the user sign up request.
 */
public class SignupRequest {
    /**
     * This variable annotated with @NotBlank and @Size defiles a username with minimum size of 3 and maximum
     * size of 20.
     */
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    /**
     * This variable annotated with @NotBlank and @Size defiles an email with maximum
     * size of 50.
     */
    @NotBlank
    @Size(max = 50)
    @Email
    private String email;


    /**
     * This variable defines the role for the user.
     */
    private Set<String> role;

    /**
     * This variable annotated with @NotBlank and @Size defiles a password of minimum size of 6 and maximum
     * size of 40.
     */
    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    /**
     * The method returns the username.
     *
     * @return username.
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
     * This method returns the email for the user.
     *
     * @return the user email.
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method set the email for the user.
     *
     * @param email is the email of the user.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * This method get the password for the user.
     *
     * @return user password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method sets the password for the user.
     *
     * @param password is the password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method returns the set of role for the user.
     *
     * @return set of user roles.
     */
    public Set<String> getRole() {
        return this.role;
    }

    /**
     * The method sets the user role for a user.
     *
     * @param role is the role to be set.
     */
    public void setRole(Set<String> role) {
        this.role = role;
    }
}
