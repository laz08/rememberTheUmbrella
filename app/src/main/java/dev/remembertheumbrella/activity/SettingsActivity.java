package dev.remembertheumbrella.activity;

import android.os.Bundle;

import butterknife.ButterKnife;
import dev.remembertheumbrella.R;

/**
 * Settings activity.
 */
public class SettingsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);
        
    }
}
