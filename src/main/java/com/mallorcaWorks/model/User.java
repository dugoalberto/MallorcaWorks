package com.mallorcaWorks.model;

public interface User {
    String getUsername();
    Role getRole();
    boolean credsValid(String username, String password);
}
