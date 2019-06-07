package Retrofit;

import java.util.List;

import POJO.Classes.DriverInfo;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayAPI {


    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<DriverInfo>> getDriverDetails();

}