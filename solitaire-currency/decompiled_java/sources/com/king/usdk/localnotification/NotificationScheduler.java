package com.king.usdk.localnotification;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public interface NotificationScheduler {
    void cancelAllNotifications();

    void scheduleLocalNotification(int i10, long j10, LocalNotification localNotification);
}
