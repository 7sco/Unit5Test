package com.example.franciscoandrade.unit5.pojos;


import java.io.Serializable;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public class Location implements Serializable {
    private String street;
    private String city;
    private String state;
    private int postcode;

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getPostcode() {
        return postcode;
    }
}
