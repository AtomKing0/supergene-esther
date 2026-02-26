package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NoOpStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class NoOpStep implements IBrazeActionStep {

    @NotNull
    public static final NoOpStep INSTANCE = new NoOpStep();

    private NoOpStep() {
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return false;
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
    }
}
