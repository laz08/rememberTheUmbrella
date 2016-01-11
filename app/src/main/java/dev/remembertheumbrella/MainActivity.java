package dev.remembertheumbrella;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dev.remembertheumbrella.api.ApiRestManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiRestManager apiRestManager = new ApiRestManager(getApplicationContext());
        apiRestManager.getStatus();
    }
}
