package com.example.franciscoandrade.unit5.pojos;

import java.io.Serializable;
import java.util.List;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public class RootObject implements Serializable {
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }
}
