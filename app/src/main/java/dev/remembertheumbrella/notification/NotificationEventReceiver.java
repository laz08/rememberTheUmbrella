package dev.remembertheumbrella.notification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

import java.util.Calendar;

/**
 * Notification event receiver.
 */
public class NotificationEventReceiver extends WakefulBroadcastReceiver {

//    http://stackoverflow.com/questions/20501225/using-service-to-run-background-and-create-notification


    public static final String TAG = "NotifEventReceiver";

    private static final int NOTIFICATION_INTERVAL_HOURS = 24;
    private static final String START_NOTIFICATION_SERVICE = "startNotificationService";
    private static final String DELETED_NOTIFICATION = "deletedNotification";

    /**
     * Sets alarm up.
     */
    public static void setUpAlarm(Context ctx) {

        AlarmManager alarmManager = (AlarmManager) ctx.getSystemService(Context.ALARM_SERVICE);
        PendingIntent alarmIntent = getStartPendingIntent(ctx);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,
                getTimeUntilHour(),
                AlarmManager.INTERVAL_HOUR * NOTIFICATION_INTERVAL_HOURS,
                alarmIntent);
    }

    /**
     * Returns start pending intent.
     *
     * @param ctx Context.
     * @return Pending intent.
     */
    private static PendingIntent getStartPendingIntent(Context ctx) {

        Intent i = new Intent(ctx, NotificationEventReceiver.class);
        i.setAction(START_NOTIFICATION_SERVICE);
        return PendingIntent.getBroadcast(ctx, 0, i, PendingIntent.FLAG_UPDATE_CURRENT);
    }

    /**
     * Returns time resting until XXXXXX hour.
     *
     * @return Time in millis until X hour.
     */
    public static long getTimeUntilHour() {

        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 10);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar.getTimeInMillis();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        if (START_NOTIFICATION_SERVICE.equals(intent.getAction())) {

            Log.v(TAG, "onReceive triggered from alarm.");
            startWakefulService(context, NotificationIntentService.from(context));
        }

    }
}
