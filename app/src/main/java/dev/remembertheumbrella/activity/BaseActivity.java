package dev.remembertheumbrella.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Base activity.
 */
public class BaseActivity extends AppCompatActivity {

    /**
     * Opens settings activity.
     *
     * @param ctx Context.
     */
    protected static void openSettingsActivityFrom(Context ctx) {

        Intent i = new Intent(ctx, SettingsActivity.class);
        ctx.startActivity(i);
    }
}
