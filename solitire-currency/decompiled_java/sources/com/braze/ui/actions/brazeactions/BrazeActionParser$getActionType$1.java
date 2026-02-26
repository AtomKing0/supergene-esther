package com.braze.ui.actions.brazeactions;

import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.actions.brazeactions.steps.StepData;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: BrazeActionParser.kt */
/* JADX INFO: loaded from: classes2.dex */
final class BrazeActionParser$getActionType$1 extends v implements a<String> {
    final /* synthetic */ StepData $data;
    final /* synthetic */ BrazeActionParser.ActionType $type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BrazeActionParser$getActionType$1(BrazeActionParser.ActionType actionType, StepData stepData) {
        super(0);
        this.$type = actionType;
        this.$data = stepData;
    }

    @Override // h9.a
    @NotNull
    public final String invoke() {
        return "Cannot parse invalid action of type " + this.$type + " and data " + this.$data;
    }
}
