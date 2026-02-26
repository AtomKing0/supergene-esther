package com.braze.location;

import com.braze.location.BrazeActionReceiver;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionReceiver$ActionReceiver$performWork$3 extends v implements a<String> {
    final /* synthetic */ BrazeActionReceiver.ActionReceiver this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionReceiver$ActionReceiver$performWork$3(BrazeActionReceiver.ActionReceiver actionReceiver) {
        super(0);
        this.this$0 = actionReceiver;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "BrazeActionReceiver received intent with geofence transition: " + this.this$0.action;
    }
}
