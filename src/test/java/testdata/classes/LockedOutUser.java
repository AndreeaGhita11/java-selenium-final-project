package testdata.classes;

import utils.Reader;

public class LockedOutUser {
    private String username;
    private String password;

    public LockedOutUser(String filename) {
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
