package dev.remembertheumbrella.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import butterknife.ButterKnife;
import dev.remembertheumbrella.R;

/**
 * Settings item view.
 */
public class SettingsItemView extends RelativeLayout {

    /**
     * Constructor.
     *
     * @param context Context.
     */
    public SettingsItemView(Context context) {

        super(context);
        initialize();
    }

    /**
     * Constructor.
     *
     * @param context Context.
     * @param attrs   AttributeSet.
     */
    public SettingsItemView(Context context, AttributeSet attrs) {

        super(context, attrs);
        initialize();
    }

    /**
     * Initializes custom view.
     */
    private void initialize() {

        View layout = inflate(getContext(), R.layout.view_settings_item, this);
        ButterKnife.bind(this, layout);
    }
}
