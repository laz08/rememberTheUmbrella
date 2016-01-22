package dev.remembertheumbrella;

import dev.remembertheumbrella.item.CurrentWeather;

/**
 * Weather callback.
 */
public interface WeatherCallback {

    /**
     * On weather received.
     */
    void onWeatherReceived(CurrentWeather currentWeather);

    /**
     * On error.
     */
    void onError();
}
