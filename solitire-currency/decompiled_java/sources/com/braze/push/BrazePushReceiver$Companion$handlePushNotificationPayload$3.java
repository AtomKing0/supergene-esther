package com.braze.push;

import android.os.Bundle;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$3 extends v implements a<String> {
    final /* synthetic */ Bundle $notificationExtras;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handlePushNotificationPayload$3(Bundle bundle) {
        super(0);
        this.$notificationExtras = bundle;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Push message payload received: " + this.$notificationExtras;
    }
}
