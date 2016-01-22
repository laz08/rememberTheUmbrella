package dev.remembertheumbrella.api;

import dev.remembertheumbrella.item.CurrentWeather;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Retrofit service.
 */
public interface RetrofitService {

    @GET("data/2.5/weather")
    Call<CurrentWeather> getCurrentWeatherStatus(
            @Query("id") String cityId,
            @Query("appid") String apiKey,
            @Query("units") String units,
            @Query("lang") String lang
    );

}
