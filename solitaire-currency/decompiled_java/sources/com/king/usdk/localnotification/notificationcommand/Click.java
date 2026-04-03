package com.king.usdk.localnotification.notificationcommand;

import androidx.annotation.Keep;
import com.king.usdk.localnotification.LocalNotificationNativeCodeCallbacks;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Click implements NotificationCommand {
    private final String deeplink;
    private final String titleKey;
    private final String trackingType;

    public Click(String str, String str2, String str3) {
        this.titleKey = str;
        this.trackingType = str2;
        this.deeplink = str3;
    }

    @Override // com.king.usdk.localnotification.notificationcommand.NotificationCommand
    public void run(long j10) {
        LocalNotificationNativeCodeCallbacks.onLocalNotificationClicked(j10, this.trackingType, this.titleKey, this.deeplink);
    }
}
