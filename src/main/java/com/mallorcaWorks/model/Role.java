package com.mallorcaWorks.model;

public enum Role { 
    
    USER("USER"),
    TEACHER("TEACHER"),
    GRANDMASTER("GRAND_MASTER");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
};
