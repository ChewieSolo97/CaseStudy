package Retrofit;

import java.util.List;

import POJO.Classes.Drivers;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayAPI {


    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Drivers>> getDriverDetails();

}