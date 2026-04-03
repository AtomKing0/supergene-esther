package com.king.usdk.localnotification;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.king.usdk.localnotification.notificationcommand.Click;
import com.king.usdk.localnotification.notificationcommand.Debug;
import com.king.usdk.localnotification.notificationcommand.Dismiss;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocalIntentUtils {
    private static final String TAG = "LocalIntentUtils";

    private LocalIntentUtils() {
    }

    public static boolean applicationInForeground(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        boolean z10 = false;
        if (runningAppProcesses != null && !runningAppProcesses.isEmpty() && runningAppProcesses.get(0).processName.equalsIgnoreCase(context.getPackageName()) && runningAppProcesses.get(0).importance == 100) {
            z10 = true;
        }
        AndroidLogger.d(TAG, "applicationInForeground: " + z10);
        return z10;
    }

    public static void handleNotification(Intent intent) {
        if (!isValidIntent(intent)) {
            AndroidLogger.i(TAG, "Ignoring empty intent");
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "LocalIntentUtils.handleNotification", "Ignoring empty intent"));
            return;
        }
        Bundle extras = intent.getExtras();
        if (!isLocalNotification(extras)) {
            AndroidLogger.i(TAG, "Ignoring not local notification intent");
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "LocalIntentUtils.handleNotification", "Ignoring not local notification intent"));
        } else {
            String string = extras.getString(NotificationSchedulerKeys.KEY_TRACKING_TYPE);
            String string2 = extras.getString(NotificationSchedulerKeys.KEY_TITLE_KEY);
            LocalNotificationModule.addAndTryFlushNotificationTrackingEvent(Notifier.NOTIFICATION_DISCARDED_ACTION.equals(intent.getAction()) ? new Dismiss(string2, string) : new Click(string2, string, extras.getString(NotificationSchedulerKeys.KEY_DEEPLINK)));
        }
    }

    private static boolean isLocalNotification(Bundle bundle) {
        return bundle != null && bundle.getInt(Notifier.NOTIFICATION_KEY) == 1;
    }

    private static boolean isValidIntent(Intent intent) {
        return (intent == null || intent.getExtras() == null) ? false : true;
    }
}
