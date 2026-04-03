package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazePushReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3 extends v implements a<String> {
    public static final BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3 INSTANCE = new BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3();

    BrazePushReceiver$Companion$handleAdmRegistrationEventIfEnabled$3() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "ADM not enabled in braze.xml. Ignoring ADM registration intent. Note: you must set com_braze_push_adm_messaging_registration_enabled to true in your braze.xml to enable ADM.";
    }
}
