package com.king.usdk.localnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocalNotificationBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "LocalNotificationBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        AndroidLogger.d(TAG, "Intent received: " + action);
        if (Notifier.NOTIFICATION_DISCARDED_ACTION.equals(action)) {
            LocalIntentUtils.handleNotification(intent);
        }
    }
}
