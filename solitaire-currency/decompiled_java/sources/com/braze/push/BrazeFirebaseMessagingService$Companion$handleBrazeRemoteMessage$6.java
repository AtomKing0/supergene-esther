package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeFirebaseMessagingService.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$6 extends v implements a<String> {
    final /* synthetic */ String $key;
    final /* synthetic */ String $value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeFirebaseMessagingService$Companion$handleBrazeRemoteMessage$6(String str, String str2) {
        super(0);
        this.$key = str;
        this.$value = str2;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Adding bundle item from FCM remote data with key: " + this.$key + " and value: " + this.$value;
    }
}
