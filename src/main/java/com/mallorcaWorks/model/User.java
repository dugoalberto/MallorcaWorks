package com.mallorcaWorks.model;

public interface User {
    String getUsername();
    String getPassword();
    Role getRole();
    boolean credsValid(String username, String password);
}
