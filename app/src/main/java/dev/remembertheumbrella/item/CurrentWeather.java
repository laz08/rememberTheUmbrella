package dev.remembertheumbrella.item;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CurrentWeather {

    @SerializedName("name")
    String mName;

    @SerializedName("weather")
    ArrayList<Weather> mWeather;


    public String getName() {
        return mName;
    }

    /**
     * Returns current weather.
     *
     * @return Current weather.
     */
    public Weather getWeather() {

        return mWeather.get(0);
    }
}
