package com.king.usdk.localnotification.notificationcommand;

import androidx.annotation.Keep;
import com.king.usdk.localnotification.LocalNotificationNativeCodeCallbacks;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Debug implements NotificationCommand {
    private final String codeLocation;
    private final String debugInfo;
    private final long errorCode;

    public Debug(long j10, String str, String str2) {
        this.codeLocation = str;
        this.debugInfo = str2;
        this.errorCode = j10;
    }

    @Override // com.king.usdk.localnotification.notificationcommand.NotificationCommand
    public void run(long j10) {
        LocalNotificationNativeCodeCallbacks.onPromotionDebugLog(j10, this.errorCode, this.codeLocation, this.debugInfo);
    }
}
