package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.UriAction;
import kotlin.jvm.internal.t;
import n9.i;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: OpenLinkExternallyStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OpenLinkExternallyStep extends BaseBrazeActionStep {

    @NotNull
    public static final OpenLinkExternallyStep INSTANCE = new OpenLinkExternallyStep();

    private OpenLinkExternallyStep() {
        super(null);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return StepData.isArgCountInBounds$default(data, 0, new i(1, 2), 1, null) && data.isArgString(0);
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) {
        t.i(context, "context");
        t.i(data, "data");
        String strValueOf = String.valueOf(data.getFirstArg());
        IBrazeDeeplinkHandler companion = BrazeDeeplinkHandler.Companion.getInstance();
        UriAction uriActionCreateUriActionFromUrlString = companion.createUriActionFromUrlString(strValueOf, null, false, data.getChannel());
        if (uriActionCreateUriActionFromUrlString != null) {
            companion.gotoUri(context, uriActionCreateUriActionFromUrlString);
        }
    }
}
