package Retrofit;

import java.util.List;

import POJO.Classes.Drivers;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitArrayAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/RetrofitAndroidArrayResponse")
    Call<List<Drivers>> getDriverDetails();

}