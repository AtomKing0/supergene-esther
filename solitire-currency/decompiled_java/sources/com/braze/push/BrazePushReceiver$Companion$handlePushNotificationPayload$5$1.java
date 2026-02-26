package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePushNotificationPayload$5$1 extends v implements a<String> {
    final /* synthetic */ String $it;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handlePushNotificationPayload$5$1(String str) {
        super(0);
        this.$it = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Push with identifier '" + this.$it + "' has already been seen. Not displaying or forwarding push.";
    }
}
