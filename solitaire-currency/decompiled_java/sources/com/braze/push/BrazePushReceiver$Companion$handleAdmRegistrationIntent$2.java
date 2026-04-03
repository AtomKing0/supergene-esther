package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handleAdmRegistrationIntent$2 extends v implements a<String> {
    final /* synthetic */ String $registrationId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleAdmRegistrationIntent$2(String str) {
        super(0);
        this.$registrationId = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Registering for ADM messages with registrationId: " + this.$registrationId;
    }
}
