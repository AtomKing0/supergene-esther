package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handleAdmRegistrationIntent$1 extends v implements a<String> {
    final /* synthetic */ String $error;
    final /* synthetic */ String $errorDescription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazePushReceiver$Companion$handleAdmRegistrationIntent$1(String str, String str2) {
        super(0);
        this.$error = str;
        this.$errorDescription = str2;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Error during ADM registration: " + this.$error + " description: " + this.$errorDescription;
    }
}
