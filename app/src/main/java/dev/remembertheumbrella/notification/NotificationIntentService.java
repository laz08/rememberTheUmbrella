package dev.remembertheumbrella.notification;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import dev.remembertheumbrella.R;
import dev.remembertheumbrella.activity.TakeUmbrellaActivity;

/**
 * Notification intent service.
 */
public class NotificationIntentService extends IntentService {

    private static final String ACTION_START = "actionStart";

    private static final String TAG = "NotifIntentServ";

    /**
     * Constructor.
     */
    public NotificationIntentService() {

        super(TAG);
    }

    /**
     * Constructor.
     *
     * @param name Name.
     */
    public NotificationIntentService(String name) {

        super(name);
    }


    /**
     * Creates intent notification service.
     *
     * @param ctx Context.
     * @return NotificationService.
     */
    public static Intent from(Context ctx) {

        Intent intent = new Intent(ctx, NotificationIntentService.class);
        intent.setAction(ACTION_START);
        return intent;
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.v(TAG, "OnHandleIntent");
        try {
            String action = intent.getAction();
            if (ACTION_START.equals(action)) {

                processStartNotification();
            }
        } finally {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    /**
     * Processes notification start.
     */
    private void processStartNotification() {


        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle("Scheduled Notification")
                .setAutoCancel(true)
                .setColor(getResources().getColor(R.color.colorAccent))
                .setContentText("This notification has been triggered by Notification Service");
//                .setSmallIcon(R.drawable.notification_icon);

        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0,
                new Intent(this, TakeUmbrellaActivity.class),
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        final NotificationManager manager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }

}
