package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationStyleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$1 extends v implements a<String> {
    public static final BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$1 INSTANCE = new BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$1();

    BrazeNotificationStyleFactory$Companion$getConversationalPushStyle$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Reply person does not exist in mapping. Not rendering a style";
    }
}
