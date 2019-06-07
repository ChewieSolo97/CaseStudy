package Retrofit;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.CaseStudy.LocalDB.Driver;

import java.util.List;

import POJO.Classes.DriverInfo;
import POJO.Classes.DriverStatistics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICalls {

    private static DriverInfo information;
    private static DriverStatistics statistics;

    // these will have to be split up
    public static void getDriverData(final Context context) {

        // the mc at the end can be changed to the other series
        String url = "http://api.sportradar.us/nascar-ot3/mc/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitObjectAPI service = retrofit.create(RetrofitObjectAPI.class);

        Call<DriverInfo> call = service.getDriverInfo();

        call.enqueue(new Callback<DriverInfo>() {
            @Override
            public void onResponse(@NonNull Call<DriverInfo> called, @NonNull Response<DriverInfo> responses) {

                try {

                    DriverInfo info = responses.body();
                    if (info == null) {
                        Log.v("WHATATTATAT", responses.errorBody().string());
                    } else {
                        Log.v("whyyyyyy", info.getDrivers().get(0).getFull_name());
                    }
                    setDriverInfo(info);

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

        Call<DriverStatistics> call2 = service.getDriverStats();
        call2.enqueue(new Callback<DriverStatistics>() {
            @Override
            public void onResponse(@NonNull Call<DriverStatistics> called, @NonNull Response<DriverStatistics> responses) {

                try {
                    DriverStatistics stats = responses.body();
                    setDriverStats(stats);
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

        //Log.v("Find THIS!!!!!", info.getDrivers().get(0).getFull_name());

        //Driver.populateDriver(information, statistics, context);
    }

    public static void setDriverStats(DriverStatistics stats) {
        statistics = stats;
    }
    public static void setDriverInfo(DriverInfo info) {
        information = info;
    }
}


//List<DriverInfo.Drivers> testing = test.getDrivers();

//                    for (Drivers sup : testing) {
//                        Driver.addDriver(sup.getFull_name(), getApplicationContext());
//
//                    }
//                    List<String> list = Driver.getDrivers(context);
//
//                    for (String driver : list) {
//                        Log.v("THISBETTERWORK", driver);
//                    }