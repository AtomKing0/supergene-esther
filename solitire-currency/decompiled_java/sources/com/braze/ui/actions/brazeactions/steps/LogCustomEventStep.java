package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import kotlin.jvm.internal.t;
import n9.i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: LogCustomEventStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class LogCustomEventStep extends BaseBrazeActionStep {

    @NotNull
    public static final LogCustomEventStep INSTANCE = new LogCustomEventStep();

    private LogCustomEventStep() {
        super(null);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return StepData.isArgCountInBounds$default(data, 0, new i(1, 2), 1, null) && data.isArgString(0) && data.isArgOptionalJsonObject(1);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        Braze.Companion.getInstance(context).logCustomEvent(String.valueOf(data.getFirstArg()), data.coerceArgToPropertiesOrNull(1));
    }
}
