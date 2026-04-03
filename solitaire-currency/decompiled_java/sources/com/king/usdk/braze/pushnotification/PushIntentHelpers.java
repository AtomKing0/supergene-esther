package com.king.usdk.braze.pushnotification;

import android.os.Bundle;
import androidx.annotation.Keep;
import com.king.usdk.braze.AndroidLogger;
import com.king.usdk.braze.pushnotification.trackingcommand.Click;
import com.king.usdk.braze.pushnotification.trackingcommand.Dismiss;
import com.king.usdk.braze.pushnotification.trackingcommand.Processed;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class PushIntentHelpers {
    private static final int FIRST_PUSH_NOTIFICATION_ID = 65536;
    private static final int LAST_PUSH_NOTIFICATION_ID = 1048576;
    private static final String TAG = "PushIntentHelpers";

    private PushIntentHelpers() {
    }

    private static String getJsonString(Bundle bundle) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String str : bundle.keySet()) {
                jSONObject.put(str, JSONObject.wrap(bundle.get(str)));
            }
        } catch (JSONException e10) {
            AndroidLogger.ex(TAG, "Can't process the bundle", e10);
        }
        return jSONObject.toString();
    }

    public static void reportPushNotificationClicked(String str, String str2, Bundle bundle) {
        String jsonString = getJsonString(bundle);
        AndroidLogger.d(TAG, String.format("Push Notification Payload '%s'", jsonString));
        NotificationModule.addAndTryFlushNotificationTrackingEvent(new Click(str2, str, jsonString));
    }

    public static void reportPushNotificationDismissed(String str, String str2, Bundle bundle) {
        String jsonString = getJsonString(bundle);
        AndroidLogger.d(TAG, String.format("Push Notification Payload '%s'", jsonString));
        NotificationModule.addAndTryFlushNotificationTrackingEvent(new Dismiss(str2, str, jsonString));
    }

    public static void reportPushNotificationReceived(String str, String str2, Bundle bundle) {
        String jsonString = getJsonString(bundle);
        AndroidLogger.d(TAG, String.format("Push Notification Payload '%s'", jsonString));
        NotificationModule.addAndTryFlushNotificationTrackingEvent(new Processed(str2, str, jsonString));
    }
}
