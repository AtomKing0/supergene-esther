package com.braze.location;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionReceiver.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionReceiver$ActionReceiver$performWork$2 extends v implements a<String> {
    public static final BrazeActionReceiver$ActionReceiver$performWork$2 INSTANCE = new BrazeActionReceiver$ActionReceiver$performWork$2();

    BrazeActionReceiver$ActionReceiver$performWork$2() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Received intent with null action. Doing nothing.";
    }
}
