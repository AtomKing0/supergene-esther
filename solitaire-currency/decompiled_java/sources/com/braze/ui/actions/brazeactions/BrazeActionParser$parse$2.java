package com.braze.ui.actions.brazeactions;

import com.braze.ui.actions.brazeactions.steps.StepData;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionParser$parse$2 extends v implements a<String> {
    final /* synthetic */ StepData $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionParser$parse$2(StepData stepData) {
        super(0);
        this.$data = stepData;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Failed to run with data " + this.$data;
    }
}
