package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2 extends v implements a<String> {
    public static final BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2 INSTANCE = new BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2();

    BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "ADM enabled in braze.xml. Continuing to process ADM registration intent.";
    }
}
