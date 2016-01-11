package dev.remembertheumbrella.api;

import android.content.Context;
import android.content.res.Resources;

import dev.remembertheumbrella.R;
import retrofit2.Retrofit;

/**
 * API Rest Manager
 */
public class ApiRestManager {

    private RetrofitService mService;
    private Context mContext;

//    String bcnId = res.getString(R.string.barcelonaId);
//    String apiKey = res.getString(R.string.weatherAPIKey);

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
                .build();

        mService = retrofit.create(RetrofitService.class);
    }
}
