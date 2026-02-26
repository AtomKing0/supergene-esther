package com.braze.push;

import android.content.Intent;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1 extends v implements a<String> {
    final /* synthetic */ Intent $intent;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$1(Intent intent) {
        super(0);
        this.$intent = intent;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Received ADM registration. Message: " + this.$intent;
    }
}
