package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$4 extends v implements a<String> {
    public static final BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$4 INSTANCE = new BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$4();

    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$4() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "FallbackFirebaseMessagingService is not enabled";
    }
}
