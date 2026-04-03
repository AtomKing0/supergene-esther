package com.braze.ui.actions.brazeactions.steps;

import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StepData.kt */
/* JADX INFO: loaded from: classes2.dex */
final class StepData$firstArg$2 extends v implements a<Object> {
    final /* synthetic */ StepData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StepData$firstArg$2(StepData stepData) {
        super(0);
        this.this$0 = stepData;
    }

    @Override // h9.a
    @Nullable
    public final Object invoke() {
        return this.this$0.getArg$android_sdk_ui_release(0);
    }
}
