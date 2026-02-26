package com.braze.location;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionReceiver$ActionReceiver$Companion$handleGeofenceEvent$4 extends v implements a<String> {
    final /* synthetic */ int $transitionType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionReceiver$ActionReceiver$Companion$handleGeofenceEvent$4(int i10) {
        super(0);
        this.$transitionType = i10;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Unsupported transition type received: " + this.$transitionType;
    }
}
