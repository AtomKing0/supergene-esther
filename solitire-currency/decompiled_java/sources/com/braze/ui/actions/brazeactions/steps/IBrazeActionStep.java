package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: IBrazeActionStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface IBrazeActionStep {
    boolean isValid(@NotNull StepData stepData);

    void run(@NotNull Context context, @NotNull StepData stepData);
}
