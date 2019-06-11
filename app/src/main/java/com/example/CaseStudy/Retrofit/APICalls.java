package com.example.CaseStudy.Retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.CaseStudy.DriverProfile.RaceData;
import com.example.CaseStudy.LocalDB.CurrentSchedule;
import com.example.CaseStudy.LocalDB.Driver;
import com.example.CaseStudy.LocalDB.Standings;
import com.example.CaseStudy.Model.DriverInfo;
import com.example.CaseStudy.Model.DriverStatistics;
import com.example.CaseStudy.Model.RaceStandings;
import com.example.CaseStudy.Model.Schedule;
import com.example.CaseStudy.Model.SeasonStandings;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICalls {

    // change the mc/ later to a variable to allow changing of series
    private static final String BASE_URL = "http://api.sportradar.us/nascar-ot3/mc/";


    public static RetrofitObjectAPI setUp(String year) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + year)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(RetrofitObjectAPI.class);
    }

    public static void getDriverInfo(final Context context) {

        RetrofitObjectAPI service = setUp("");

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
    } // end getDriverInfo

    public static void getDriverStats(final Context context) {

        RetrofitObjectAPI service = setUp("");
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

    public static void getSeasonStandings(final Context context, int year) {

        RetrofitObjectAPI service = setUp(String.valueOf(year) + "/");
        Call<SeasonStandings> call = service.getSeasonStandings();

        call.enqueue(new Callback<SeasonStandings>() {
            @Override
            public void onResponse(@NonNull Call<SeasonStandings> called, @NonNull Response<SeasonStandings> responses) {

                try {

                    SeasonStandings info = responses.body();

                    if (info == null) {
                        Log.wtf("is this null?", responses.errorBody().string());
                    }
                    Standings.populateStandings(info, context);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<SeasonStandings> called, Throwable t) {
                Log.d("onFailure", t.toString());
            }

        });
    }

    public static void getSeasonSchedule(final Context context, int year) {

        RetrofitObjectAPI service = setUp(year + "/");
        Call<Schedule> call = service.getSeasonSchedule();

        call.enqueue(new Callback<Schedule>() {
            @Override
            public void onResponse(@NonNull Call<Schedule> called, @NonNull Response<Schedule> responses) {

                try {

                    Schedule info = responses.body();
                    CurrentSchedule.populateSchedule(info, context);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Schedule> called, Throwable t) {
                Log.d("onFailure", t.toString());
            }

        });
    }

    public static void getRaceResults(String id) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL + "races/" + id + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);
        Call<RaceStandings> call = service.getRaceResults();


        call.enqueue(new Callback<RaceStandings>() {
            @Override
            public void onResponse(@NonNull Call<RaceStandings> called, @NonNull Response<RaceStandings> responses) {

                try {
                    RaceStandings info = responses.body();
                    RaceData.setStandings(info);

                } catch (Exception e) {
                    Log.d("onResponse", "There is an error");
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(@NonNull Call<RaceStandings> called, Throwable t) {
                Log.d("onFailure", t.toString());
            }

        });
    }
}