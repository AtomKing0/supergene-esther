package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$3 extends v implements a<String> {
    public static final BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$3 INSTANCE = new BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$3();

    BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$3() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to create conversation push style. Returning null.";
    }
}
