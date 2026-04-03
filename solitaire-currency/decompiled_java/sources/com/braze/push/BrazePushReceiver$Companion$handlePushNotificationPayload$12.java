package com.braze.push;

import androidx.core.app.NotificationManagerCompat;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$12 extends v implements a<String> {
    final /* synthetic */ NotificationManagerCompat $notificationManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handlePushNotificationPayload$12(NotificationManagerCompat notificationManagerCompat) {
        super(0);
        this.$notificationManager = notificationManagerCompat;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Value of notificationManager.areNotificationsEnabled() = " + this.$notificationManager.areNotificationsEnabled();
    }
}
