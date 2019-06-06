package Retrofit;

import POJO.Classes.Drivers;
import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitObjectAPI {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("2019/drivers/list.json?api_key=6n4nwyb2rg53e24yw3xnnj88")
    Call<Drivers> getDriversDetails();
}