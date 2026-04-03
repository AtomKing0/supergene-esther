package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$2 extends v implements a<String> {
    final /* synthetic */ String $fallbackClassPath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$2(String str) {
        super(0);
        this.$fallbackClassPath = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Fallback FCM service enabled. Attempting to use fallback class at " + this.$fallbackClassPath;
    }
}
