package com.selenium.testdata.classes;

import com.selenium.utils.Reader;

public class MissingUserData {
    private String username;
    private String password;

    public MissingUserData(String filename) {
        this.username = Reader.getJson(filename).get("username").toString();
        this.password = Reader.getJson(filename).get("password").toString();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
