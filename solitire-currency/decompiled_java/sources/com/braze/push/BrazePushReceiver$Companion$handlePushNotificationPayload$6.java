package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$6 extends v implements a<String> {
    public static final BrazePushReceiver$Companion$handlePushNotificationPayload$6 INSTANCE = new BrazePushReceiver$Companion$handlePushNotificationPayload$6();

    BrazePushReceiver$Companion$handlePushNotificationPayload$6() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Bypassing push display due to test in-app message presence and eager test in-app message display configuration setting.";
    }
}
