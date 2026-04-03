package com.braze.ui.actions.brazeactions.steps;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BaseBrazeActionStep.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BaseBrazeActionStep$Companion$runOnUser$1$onError$1 extends v implements a<String> {
    public static final BaseBrazeActionStep$Companion$runOnUser$1$onError$1 INSTANCE = new BaseBrazeActionStep$Companion$runOnUser$1$onError$1();

    BaseBrazeActionStep$Companion$runOnUser$1$onError$1() {
        super(0);
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to run on Braze user object";
    }
}
