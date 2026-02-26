package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$4 extends v implements a<String> {
    public static final BrazePushReceiver$Companion$handlePushNotificationPayload$4 INSTANCE = new BrazePushReceiver$Companion$handlePushNotificationPayload$4();

    BrazePushReceiver$Companion$handlePushNotificationPayload$4() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Push message is uninstall tracking push. Doing nothing. Not forwarding this notification to broadcast receivers.";
    }
}
