package com.braze.ui.actions.brazeactions.steps;

import h9.l;
import kotlin.jvm.internal.v;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: compiled from: JsonUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepData$args$2$invoke$$inlined$iterator$2 extends v implements l<Integer, Object> {
    final /* synthetic */ JSONArray $this_iterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepData$args$2$invoke$$inlined$iterator$2(JSONArray jSONArray) {
        super(1);
        this.$this_iterator = jSONArray;
    }

    public final Object invoke(int i10) throws JSONException {
        Object obj = this.$this_iterator.get(i10);
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Any");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Object invoke(Integer num) {
        return invoke(num.intValue());
    }
}
