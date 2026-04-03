package com.braze.ui.actions.brazeactions.steps;

import android.content.Context;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import java.util.Iterator;
import kotlin.collections.d0;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import o9.o;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ContainerStep.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContainerStep extends BaseBrazeActionStep {

    @NotNull
    public static final ContainerStep INSTANCE = new ContainerStep();

    private ContainerStep() {
        super(null);
    }

    public final /* synthetic */ Iterator getChildStepIterator$android_sdk_ui_release(StepData data) throws JSONException {
        t.i(data, "data");
        JSONArray jSONArray = data.getSrcJson().getJSONArray("steps");
        return jSONArray == null ? v.l().iterator() : o.s(o.k(d0.a0(n9.o.u(0, jSONArray.length())), new ContainerStep$getChildStepIterator$$inlined$iterator$1(jSONArray)), new ContainerStep$getChildStepIterator$$inlined$iterator$2(jSONArray)).iterator();
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public boolean isValid(@NotNull StepData data) {
        t.i(data, "data");
        return data.getSrcJson().has("steps");
    }

    @Override // com.braze.ui.actions.brazeactions.steps.IBrazeActionStep
    public void run(@NotNull Context context, @NotNull StepData data) throws JSONException {
        t.i(context, "context");
        t.i(data, "data");
        Iterator childStepIterator$android_sdk_ui_release = getChildStepIterator$android_sdk_ui_release(data);
        while (childStepIterator$android_sdk_ui_release.hasNext()) {
            BrazeActionParser.INSTANCE.parse$android_sdk_ui_release(context, StepData.copy$default(data, (JSONObject) childStepIterator$android_sdk_ui_release.next(), null, 2, null));
        }
    }
}
