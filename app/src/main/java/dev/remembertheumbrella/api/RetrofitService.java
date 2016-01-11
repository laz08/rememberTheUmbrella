package dev.remembertheumbrella.api;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit service.
 */
public interface RetrofitService {

    @GET("weather")
    Call<JSONObject> parseStatus(@Query("id") String cityId, @Query("appid") String apiKey, @Query("units") String units);
}
