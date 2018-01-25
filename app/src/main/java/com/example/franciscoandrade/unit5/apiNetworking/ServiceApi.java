package com.example.franciscoandrade.unit5.apiNetworking;

import com.example.franciscoandrade.unit5.pojos.RootObject;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by franciscoandrade on 1/24/18.
 */

public interface ServiceApi {

    @GET("?nat=us&inc=name,location,cell,email,dob,picture&results=20")
    Call<RootObject> getResponseGet();
}
