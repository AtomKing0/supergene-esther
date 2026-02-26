package com.braze.location;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionReceiver$ActionReceiver$Companion$handleGeofenceEvent$1 extends v implements a<String> {
    final /* synthetic */ int $errorCode;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionReceiver$ActionReceiver$Companion$handleGeofenceEvent$1(int i10) {
        super(0);
        this.$errorCode = i10;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Location Services error: " + this.$errorCode;
    }
}
