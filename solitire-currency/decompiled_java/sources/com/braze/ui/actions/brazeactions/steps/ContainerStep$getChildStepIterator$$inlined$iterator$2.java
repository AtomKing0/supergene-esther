package com.braze.ui.actions.brazeactions.steps;

import h9.l;
import kotlin.jvm.internal.v;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: JsonUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContainerStep$getChildStepIterator$$inlined$iterator$2 extends v implements l<Integer, JSONObject> {
    final /* synthetic */ JSONArray $this_iterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContainerStep$getChildStepIterator$$inlined$iterator$2(JSONArray jSONArray) {
        super(1);
        this.$this_iterator = jSONArray;
    }

    public final JSONObject invoke(int i10) throws JSONException {
        Object obj = this.$this_iterator.get(i10);
        if (obj != null) {
            return (JSONObject) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
    }

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, org.json.JSONObject] */
    @Override // h9.l
    public /* bridge */ /* synthetic */ JSONObject invoke(Integer num) {
        return invoke(num.intValue());
    }
}
