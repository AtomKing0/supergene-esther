package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.BrazeUser;
import com.braze.support.BrazeLogger;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SetCustomUserAttributeStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SetCustomUserAttributeStep extends BaseBrazeActionStep {

    @NotNull
    public static final SetCustomUserAttributeStep INSTANCE;

    @NotNull
    private static final String TAG;

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.SetCustomUserAttributeStep$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: SetCustomUserAttributeStep.kt */
    static final class AnonymousClass1 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ StepData $data;
        final /* synthetic */ Object $value;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(StepData stepData, Object obj) {
            super(1);
            this.$data = stepData;
            this.$value = obj;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            BrazeUser.setCustomAttribute$default(it, String.valueOf(this.$data.getFirstArg()), this.$value, false, 4, null);
        }
    }

    static {
        SetCustomUserAttributeStep setCustomUserAttributeStep = new SetCustomUserAttributeStep();
        INSTANCE = setCustomUserAttributeStep;
        TAG = BrazeLogger.INSTANCE.brazeLogTag(setCustomUserAttributeStep);
    }

    private SetCustomUserAttributeStep() {
        super(null);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return StepData.isArgCountInBounds$default(data, 2, null, 2, null) && data.isArgString(0) && data.getSecondArg() != null;
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        Object secondArg = data.getSecondArg();
        if (secondArg == null) {
            return;
        }
        BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(context), new AnonymousClass1(data, secondArg));
    }
}
