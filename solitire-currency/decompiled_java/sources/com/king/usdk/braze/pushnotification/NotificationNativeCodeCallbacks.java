package com.king.usdk.braze.pushnotification;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class NotificationNativeCodeCallbacks {
    public static native void onPromotionDebugLog(long j10, long j11, String str, String str2);

    public static native void onPushNotificationClicked(long j10, String str, String str2, String str3);

    public static native void onPushNotificationDiscarded(long j10, String str, String str2, String str3);

    public static native void onPushNotificationReceived(long j10, String str, String str2, String str3);
}
