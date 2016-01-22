package dev.remembertheumbrella.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;
import dev.remembertheumbrella.R;
import dev.remembertheumbrella.WeatherCallback;
import dev.remembertheumbrella.api.ApiRestManager;
import dev.remembertheumbrella.helper.ImageLoaderHelper;
import dev.remembertheumbrella.item.CurrentWeather;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Bind(R.id.current_weather_icon)
    ImageView mWeatherIcon;

    private ApiRestManager mApiRestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        initialize();
        requestCurrentWeather();


    }

    /**
     * Initializes main view.
     */
    private void initialize() {

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mApiRestManager = new ApiRestManager(getApplicationContext());
    }

    /**
     * Requests current weather.
     */
    private void requestCurrentWeather() {

        mApiRestManager.getCurrentWeather(new WeatherCallback() {

            @Override
            public void onWeatherReceived(CurrentWeather currentWeather) {

                Context context = getApplicationContext();

                String iconId = currentWeather.getWeather().getIconId();
                Resources res = context.getResources();
                String extension = res.getString(R.string.iconExtension);

                String url = res.getString(R.string.iconURL) + iconId + extension;
                Log.v(TAG, "URL: " + url);
                ImageLoaderHelper.loadImage(context, url, mWeatherIcon);
            }

            @Override
            public void onError() {

            }
        });
    }
}
