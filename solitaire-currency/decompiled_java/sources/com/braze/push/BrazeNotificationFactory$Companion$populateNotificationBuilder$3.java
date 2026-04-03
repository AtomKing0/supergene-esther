package com.braze.push;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeNotificationFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeNotificationFactory$Companion$populateNotificationBuilder$3 extends v implements a<String> {
    public static final BrazeNotificationFactory$Companion$populateNotificationBuilder$3 INSTANCE = new BrazeNotificationFactory$Companion$populateNotificationBuilder$3();

    BrazeNotificationFactory$Companion$populateNotificationBuilder$3() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "BrazeNotificationPayload has null app configuration provider. Not creating notification";
    }
}
