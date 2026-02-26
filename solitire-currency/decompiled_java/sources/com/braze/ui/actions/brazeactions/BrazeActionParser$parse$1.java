package com.braze.ui.actions.brazeactions;

import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.actions.brazeactions.steps.StepData;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionParser$parse$1 extends v implements a<String> {
    final /* synthetic */ BrazeActionParser.ActionType $actionType;
    final /* synthetic */ StepData $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionParser$parse$1(BrazeActionParser.ActionType actionType, StepData stepData) {
        super(0);
        this.$actionType = actionType;
        this.$data = stepData;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Performing Braze Action type " + this.$actionType + " with data " + this.$data;
    }
}
