package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.support.PermissionUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: RequestPushPermissionStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RequestPushPermissionStep extends BaseBrazeActionStep {

    @NotNull
    public static final RequestPushPermissionStep INSTANCE = new RequestPushPermissionStep();

    private RequestPushPermissionStep() {
        super(null);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return true;
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        PermissionUtils.requestPushPermissionPrompt(BrazeInAppMessageManager.Companion.getInstance().getActivity());
    }
}
