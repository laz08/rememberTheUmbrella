package dev.remembertheumbrella.activity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import dev.remembertheumbrella.R;
import dev.remembertheumbrella.WeatherCallback;
import dev.remembertheumbrella.api.ApiRestManager;
import dev.remembertheumbrella.helper.ImageLoaderHelper;
import dev.remembertheumbrella.item.CurrentWeather;
import dev.remembertheumbrella.notification.NotificationEventReceiver;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Bind(R.id.current_weather_icon)
    ImageView mWeatherIcon;

    @Bind(R.id.city_name)
    TextView mCity;

    @Bind(R.id.description)
    TextView mDescription;

    @Bind(R.id.temperature)
    TextView mTemperature;

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
        startNotificationAlarm();
    }

    /**
     * Starts notification alarm.
     */
    private void startNotificationAlarm() {

        Log.v(TAG, "Starting notification alarm.");
        NotificationEventReceiver.setUpAlarm(getApplicationContext());
    }

    /**
     * Requests current weather.
     */
    private void requestCurrentWeather() {

        mApiRestManager.getCurrentWeather(new WeatherCallback() {

            @Override
            public void onWeatherReceived(CurrentWeather currentWeather) {

                loadIcon(currentWeather);
                fillInformation(currentWeather);
            }

            @Override
            public void onError() {

            }
        });
    }

    /**
     * Fills information texts.
     *
     * @param currentWeather Current weather.
     */
    private void fillInformation(CurrentWeather currentWeather) {

        mCity.setText(currentWeather.getName());
        mDescription.setText(currentWeather.getWeather().getDescription());
    }

    /**
     * Loads icon.
     *
     * @param currentWeather Current weather.
     */
    private void loadIcon(CurrentWeather currentWeather) {

        Context context = getApplicationContext();
        String iconId = currentWeather.getWeather().getIconId();
        Resources res = context.getResources();
        String extension = res.getString(R.string.iconExtension);

        String url = res.getString(R.string.iconURL) + iconId + extension;
        Log.v(TAG, "URL: " + url);
        ImageLoaderHelper.loadImage(context, url, mWeatherIcon);
    }
}
