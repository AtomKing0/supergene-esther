package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handlePush$performWork$3 extends v implements a<String> {
    public static final BrazePushReceiver$Companion$handlePush$performWork$3 INSTANCE = new BrazePushReceiver$Companion$handlePush$performWork$3();

    BrazePushReceiver$Companion$handlePush$performWork$3() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Received a message not sent from Braze. Ignoring the message.";
    }
}
