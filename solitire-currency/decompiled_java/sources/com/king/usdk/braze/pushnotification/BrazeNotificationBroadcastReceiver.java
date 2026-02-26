package com.king.usdk.braze.pushnotification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.king.usdk.braze.AndroidLogger;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class BrazeNotificationBroadcastReceiver extends BroadcastReceiver {
    private static final String BRAZE_TRACKING_TYPE = "braze";
    private static final String CID_FIELD = "cid";
    private static final String TAG = "BrazeNotificationBroadcastReceiver";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        if (extras == null) {
            AndroidLogger.e(TAG, "Received invalid Intent with no extras! Ignoring");
        }
        String string = extras.getString("cid");
        if (string == null) {
            AndroidLogger.e(TAG, "Unexpected braze broadcast about push without CID! Ignoring");
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            AndroidLogger.e(TAG, "Braze intent without action! Ignoring");
            return;
        }
        AndroidLogger.d(TAG, "Intent received: " + action);
        switch (action) {
            case "com.braze.push.intent.NOTIFICATION_OPENED":
                PushIntentHelpers.reportPushNotificationClicked(BRAZE_TRACKING_TYPE, string, extras);
                break;
            case "com.braze.push.intent.NOTIFICATION_RECEIVED":
                PushIntentHelpers.reportPushNotificationReceived(BRAZE_TRACKING_TYPE, string, extras);
                break;
            case "com.braze.push.intent.NOTIFICATION_DELETED":
                PushIntentHelpers.reportPushNotificationDismissed(BRAZE_TRACKING_TYPE, string, extras);
                break;
        }
    }
}
