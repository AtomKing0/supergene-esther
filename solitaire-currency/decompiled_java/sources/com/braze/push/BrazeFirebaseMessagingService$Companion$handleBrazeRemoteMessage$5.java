package com.braze.push;

import h9.a;
import java.util.Map;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$5 extends v implements a<String> {
    final /* synthetic */ Map<String, String> $remoteMessageData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$5(Map<String, String> map) {
        super(0);
        this.$remoteMessageData = map;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Got remote message from FCM: " + this.$remoteMessageData;
    }
}
