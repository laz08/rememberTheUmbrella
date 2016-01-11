package dev.remembertheumbrella.api;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Retrofit service.
 */
public interface RetrofitService {

    @GET("/weather?id={id}")
    Call
}
