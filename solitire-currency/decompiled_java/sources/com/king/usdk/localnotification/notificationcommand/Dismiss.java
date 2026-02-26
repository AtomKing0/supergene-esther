package com.king.usdk.localnotification.notificationcommand;

import androidx.annotation.Keep;
import com.king.usdk.localnotification.LocalNotificationNativeCodeCallbacks;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Dismiss implements NotificationCommand {
    private final String titleKey;
    private final String trackingType;

    public Dismiss(String str, String str2) {
        this.titleKey = str;
        this.trackingType = str2;
    }

    @Override // com.king.usdk.localnotification.notificationcommand.NotificationCommand
    public void run(long j10) {
        LocalNotificationNativeCodeCallbacks.onLocalNotificationDiscarded(j10, this.trackingType, this.titleKey);
    }
}
