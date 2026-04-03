package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handleAdmRegistrationIntent$3 extends v implements a<String> {
    final /* synthetic */ String $unregistered;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleAdmRegistrationIntent$3(String str) {
        super(0);
        this.$unregistered = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "The device was un-registered from ADM: " + this.$unregistered;
    }
}
