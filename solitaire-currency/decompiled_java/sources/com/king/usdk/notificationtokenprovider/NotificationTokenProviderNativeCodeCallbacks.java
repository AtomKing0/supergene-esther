package com.king.usdk.notificationtokenprovider;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class NotificationTokenProviderNativeCodeCallbacks {
    public static native void onDeviceIdRegistered(long j10, String str, boolean z10);

    public static native void onPromotionDebugLog(long j10, long j11, String str, String str2);
}
