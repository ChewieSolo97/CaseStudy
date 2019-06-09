package com.example.CaseStudy.Retrofit;

import java.util.List;

import com.example.CaseStudy.Model.DriverInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayAPI {


    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<DriverInfo>> getDriverDetails();

}