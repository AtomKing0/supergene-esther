package com.braze;

import android.app.Notification;
import com.braze.models.push.BrazeNotificationPayload;

/* JADX INFO: loaded from: classes2.dex */
public interface IBrazeNotificationFactory {
    Notification createNotification(BrazeNotificationPayload brazeNotificationPayload);
}
