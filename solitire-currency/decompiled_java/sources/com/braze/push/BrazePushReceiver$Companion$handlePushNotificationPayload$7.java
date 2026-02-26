package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$7 extends v implements a<String> {
    public static final BrazePushReceiver$Companion$handlePushNotificationPayload$7 INSTANCE = new BrazePushReceiver$Companion$handlePushNotificationPayload$7();

    BrazePushReceiver$Companion$handlePushNotificationPayload$7() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Received visible push notification";
    }
}
