package com.se.goBears.entity;

import java.security.Principal;
import java.util.Objects;

/**
 *  This entity class defines the methods and variables for the entity AnonymousPrinciple.
 */
public class AnonymousPrinciple implements Principal {
    private String name;

    private String username;
    private State state = State.Online;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object another) {
        if (!(another instanceof Principal))
            return false;

        Principal principal = (Principal) another;
        return principal.getName() == this.name;

    }

    public enum State {
        Online, DoNotDisturb
    }
}
