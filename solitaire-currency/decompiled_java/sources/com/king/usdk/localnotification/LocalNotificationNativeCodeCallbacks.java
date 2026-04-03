package com.king.usdk.localnotification;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class LocalNotificationNativeCodeCallbacks {
    public static native void onLocalNotificationClicked(long j10, String str, String str2, String str3);

    public static native void onLocalNotificationDiscarded(long j10, String str, String str2);

    public static native void onPromotionDebugLog(long j10, long j11, String str, String str2);
}
