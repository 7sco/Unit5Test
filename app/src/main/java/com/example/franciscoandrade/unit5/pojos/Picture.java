package com.example.franciscoandrade.unit5.pojos;

import java.io.Serializable;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public class Picture implements Serializable {

    private String large;
    private String medium;
    private String thumbnail;

    public String getLarge() {
        return large;
    }

    public String getMedium() {
        return medium;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
