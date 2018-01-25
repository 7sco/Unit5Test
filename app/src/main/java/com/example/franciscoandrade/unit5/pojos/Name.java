package com.example.franciscoandrade.unit5.pojos;

import java.io.Serializable;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public class Name  implements Serializable {
    private String title;
    private String first;
    private String last;

    public String getTitle() {
        return title;
    }

    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }
}
