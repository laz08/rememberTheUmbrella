package dev.remembertheumbrella.api;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import dev.remembertheumbrella.R;
import dev.remembertheumbrella.WeatherStatus;
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

    public void getStatus() {

        Resources res = mContext.getResources();

        String bcnId = res.getString(R.string.barcelonaId);
        String apiKey = res.getString(R.string.weatherAPIKey);

        Call<WeatherStatus> call = mService.parseStatus(bcnId, apiKey, "metric");

        call.enqueue(new Callback<WeatherStatus>() {

            @Override
            public void onResponse(Response<WeatherStatus> response) {

                Log.v(TAG, "Is success: " + response.isSuccess());
                if (response.isSuccess()) {

                    WeatherStatus body = response.body();
                    Log.v(TAG, "Name: " + body.getName());
                    Log.v(TAG, "Description:" + body.getWeather().get(0).getDescription());

                }
            }

            @Override
            public void onFailure(Throwable t) {

                Log.v(TAG, "OnFailure");
            }
        });
    }
}
