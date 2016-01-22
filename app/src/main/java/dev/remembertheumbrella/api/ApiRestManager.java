package dev.remembertheumbrella.api;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import dev.remembertheumbrella.R;
import dev.remembertheumbrella.item.CurrentWeather;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.GsonConverterFactory;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * API Rest Manager
 */
public class ApiRestManager {

    public static final String TAG = "RESTManager";
    private RetrofitService mService;
    private Context mContext;

    /**
     * Constructor.
     *
     * @param ctx Context.
     */
    public ApiRestManager(Context ctx) {

        mContext = ctx;
        Resources res = mContext.getResources();

        String weatherURL = res.getString(R.string.weatherURL);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(weatherURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mService = retrofit.create(RetrofitService.class);
    }

    /**
     * Returns current weather status.
     */
    public void getCurrentWeather() {

        Resources res = mContext.getResources();

        String bcnId = res.getString(R.string.barcelonaId);
        String apiKey = res.getString(R.string.weatherAPIKey);

        Call<CurrentWeather> call = mService.getCurrentWeatherStatus(bcnId, apiKey, "metric", "ca");

        call.enqueue(new Callback<CurrentWeather>() {

            @Override
            public void onResponse(Response<CurrentWeather> response) {

                Log.v(TAG, "Is success: " + response.isSuccess());
                if (response.isSuccess()) {

                    CurrentWeather currentWeather = response.body();
                    Log.v(TAG, "Name: " + currentWeather.getName());
                    Log.v(TAG, "Description:" + currentWeather.getWeather().getDescription());

                }
            }

            @Override
            public void onFailure(Throwable t) {

                Log.v(TAG, "OnFailure");
            }
        });
    }
}
