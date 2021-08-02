package com.mallorcaWorks.model;

public enum Role { 
    
    TEACHER("Teacher"),
    GRANDMASTER("Grandmaster");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() { return value; }
};
