package com.GoogleplusloginDemo.apiclient;

import com.GoogleplusloginDemo.pojo.Example;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by chavali on 2017-02-25.
 */

public interface ApiInterface {

    @GET("v2/upcomingGuides/")
    Call<Example> getguide();


}
