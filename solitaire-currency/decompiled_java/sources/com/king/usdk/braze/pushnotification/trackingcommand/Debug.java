package com.king.usdk.braze.pushnotification.trackingcommand;

import androidx.annotation.Keep;
import com.king.usdk.braze.pushnotification.NotificationNativeCodeCallbacks;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Debug implements NotificationTrackingCommand {
    private final String codeLocation;
    private final String debugInfo;
    private final long errorCode;

    public Debug(long j10, String str, String str2) {
        this.codeLocation = str;
        this.debugInfo = str2;
        this.errorCode = j10;
    }

    @Override // com.king.usdk.braze.pushnotification.trackingcommand.NotificationTrackingCommand
    public void run(long j10) {
        NotificationNativeCodeCallbacks.onPromotionDebugLog(j10, this.errorCode, this.codeLocation, this.debugInfo);
    }
}
