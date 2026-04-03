package com.king.usdk.braze.pushnotification;

import android.app.Notification;
import androidx.annotation.Keep;
import com.braze.IBrazeNotificationFactory;
import com.braze.models.push.BrazeNotificationPayload;
import com.braze.push.BrazeNotificationFactory;
import com.king.usdk.braze.pushnotification.trackingcommand.Debug;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class CustomNotificationBrazeFactory implements IBrazeNotificationFactory {
    @Override // com.braze.IBrazeNotificationFactory
    public Notification createNotification(BrazeNotificationPayload brazeNotificationPayload) {
        if (!IntentUtils.applicationInForeground(brazeNotificationPayload.getContext())) {
            return BrazeNotificationFactory.getInstance().createNotification(brazeNotificationPayload);
        }
        NotificationModule.addAndTryFlushNotificationTrackingEvent(new Debug(0L, "CustomNotificationBrazeFactory.createNotification", "Notification refused, application in foreground - CampaignId: " + brazeNotificationPayload.getCampaignId()));
        return null;
    }
}
