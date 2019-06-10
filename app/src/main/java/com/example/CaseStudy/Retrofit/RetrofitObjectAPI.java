package com.example.CaseStudy.Retrofit;

import com.example.CaseStudy.Model.DriverInfo;
import com.example.CaseStudy.Model.DriverStatistics;
import com.example.CaseStudy.Model.SeasonStandings;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitObjectAPI {

    String API_KEY = "6n4nwyb2rg53e24yw3xnnj88";

    // year can be changed
    @GET("2019/drivers/list.json?api_key=" + API_KEY)
    Call<DriverInfo> getDriverInfo();

    @GET("drivers/2019/drivers.json?api_key=" + API_KEY)
    Call<DriverStatistics> getDriverStats();

    @GET("/standings/drivers.xml?api_key=" + API_KEY)
    Call<SeasonStandings> getSeasonStandings();
}