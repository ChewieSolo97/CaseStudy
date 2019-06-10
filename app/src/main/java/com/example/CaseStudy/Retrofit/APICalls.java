package com.example.CaseStudy.Retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.CaseStudy.LocalDB.Driver;

import com.example.CaseStudy.Model.DriverInfo;
import com.example.CaseStudy.Model.DriverStatistics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICalls {

    // change the mc/ later to a variable to allow changing of series
    private static final String BASE_URL = "http://api.sportradar.us/nascar-ot3/mc/";

    private static DriverInfo information;
    private static DriverStatistics statistics;

    public static void setDriverStats(DriverStatistics stats) {
        statistics = stats;
    }
    public static void setDriverInfo(DriverInfo info) {
        information = info;
        //Log.wtf("why is this", information.getDrivers().get(0).getFull_name());
    }

    public static RetrofitObjectAPI setUp() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitObjectAPI.class);
    }

    public static void getDriverInfo(final Context context) {

        RetrofitObjectAPI service = setUp();

        Call<DriverInfo> call = service.getDriverInfo();

        call.enqueue(new Callback<DriverInfo>() {
            @Override
            public void onResponse(@NonNull Call<DriverInfo> called, @NonNull Response<DriverInfo> responses) {

                try {

                    DriverInfo info = responses.body();

                    if (info == null) {
                        Log.wtf("is this null?", responses.errorBody().string());
                    }

                    Driver.populateDriverInfo(info, context);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(@NonNull Call<DriverInfo> called, Throwable t) {
                Log.d("onFailure", t.toString());
            }

        });


        //Log.wtf("why is this", information.getDrivers().get(0).getFull_name());
//        Driver.populateDriverInfo(information, context);
    }

    public static void getDriverStats(final Context context) {

        RetrofitObjectAPI service = setUp();
        Call<DriverStatistics> call2 = service.getDriverStats();
        call2.enqueue(new Callback<DriverStatistics>() {
            @Override
            public void onResponse(@NonNull Call<DriverStatistics> called, @NonNull Response<DriverStatistics> responses) {

                try {
                    DriverStatistics stats = responses.body();
                    if (stats == null) {
                        Log.wtf("is this null?", responses.errorBody().string());
                    }
                    Driver.populateDriverStats(stats, context);
                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<DriverStatistics> called, Throwable t) {
                Log.d("onFailure", t.toString());
            }
        });

    }
}