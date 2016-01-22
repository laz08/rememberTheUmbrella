package dev.remembertheumbrella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dev.remembertheumbrella.api.ApiRestManager;

public class MainActivity extends AppCompatActivity {

    private ApiRestManager mApiRestManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mApiRestManager = new ApiRestManager(getApplicationContext());
        mApiRestManager.getCurrentWeather();


    }
}
