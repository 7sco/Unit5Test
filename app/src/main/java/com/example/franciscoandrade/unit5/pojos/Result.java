package com.example.franciscoandrade.unit5.pojos;




import java.io.Serializable;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public class Result implements Serializable {

    private Name name;
    private Location location;
    private String email;
    private String dob;
    private String cell;
    private Picture picture;

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getCell() {
        return cell;
    }

    public Picture getPicture() {
        return picture;
    }
}
