package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.Braze;
import com.braze.BrazeUser;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AddToSubscriptionGroupStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddToSubscriptionGroupStep extends BaseBrazeActionStep {

    @NotNull
    public static final AddToSubscriptionGroupStep INSTANCE = new AddToSubscriptionGroupStep();

    /* JADX INFO: renamed from: com.braze.ui.actions.brazeactions.steps.AddToSubscriptionGroupStep$run$1, reason: invalid class name */
    /* JADX INFO: compiled from: AddToSubscriptionGroupStep.kt */
    static final class AnonymousClass1 extends v implements l<BrazeUser, k0> {
        final /* synthetic */ String $subscriptionGroupId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(1);
            this.$subscriptionGroupId = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(BrazeUser brazeUser) {
            invoke2(brazeUser);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull BrazeUser it) {
            t.i(it, "it");
            it.addToSubscriptionGroup(this.$subscriptionGroupId);
        }
    }

    private AddToSubscriptionGroupStep() {
        super(null);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return StepData.isArgCountInBounds$default(data, 1, null, 2, null) && data.isArgString(0);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        BaseBrazeActionStep.Companion.runOnUser$android_sdk_ui_release(Braze.Companion.getInstance(context), new AnonymousClass1(String.valueOf(data.getFirstArg())));
    }
}
