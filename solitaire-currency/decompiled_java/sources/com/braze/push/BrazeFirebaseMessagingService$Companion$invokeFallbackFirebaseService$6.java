package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$6 extends v implements a<String> {
    final /* synthetic */ String $classpath;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$Companion$invokeFallbackFirebaseService$6(String str) {
        super(0);
        this.$classpath = str;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Attempting to invoke firebase messaging fallback service " + this.$classpath + ".onMessageReceived";
    }
}
