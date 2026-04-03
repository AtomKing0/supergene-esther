package com.braze.push;

import com.google.firebase.messaging.r0;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1 extends v implements a<String> {
    final /* synthetic */ r0 $remoteMessage;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$1(r0 r0Var) {
        super(0);
        this.$remoteMessage = r0Var;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Remote message did not originate from Braze. Not consuming remote message: " + this.$remoteMessage;
    }
}
