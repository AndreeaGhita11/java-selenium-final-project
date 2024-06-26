package com.selenium.testdata.classes;

import com.selenium.utils.Reader;

public class OrderDetailsData {
    private String firstname;
    private String lastname;
    private String postalcode;

    public OrderDetailsData(String filename) {
        this.firstname = Reader.getJson(filename).get("firstname").toString();
        this.lastname = Reader.getJson(filename).get("lastname").toString();
        this.postalcode = Reader.getJson(filename).get("postalcode").toString();
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }
}
