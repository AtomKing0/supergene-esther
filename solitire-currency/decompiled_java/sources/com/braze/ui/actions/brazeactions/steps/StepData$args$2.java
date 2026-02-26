package com.braze.ui.actions.brazeactions.steps;

import h9.a;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.v;
import o9.m;
import o9.o;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* JADX INFO: compiled from: StepData.kt */
/* JADX INFO: loaded from: classes2.dex */
final class StepData$args$2 extends v implements a<List<? extends Object>> {
    final /* synthetic */ StepData this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StepData$args$2(StepData stepData) {
        super(0);
        this.this$0 = stepData;
    }

    @Override // h9.a
    @NotNull
    public final List<? extends Object> invoke() {
        JSONArray jSONArrayOptJSONArray = this.this$0.getSrcJson().optJSONArray("args");
        return o.w(m.c(jSONArrayOptJSONArray == null ? kotlin.collections.v.l().iterator() : o.s(o.k(d0.a0(n9.o.u(0, jSONArrayOptJSONArray.length())), new StepData$args$2$invoke$$inlined$iterator$1(jSONArrayOptJSONArray)), new StepData$args$2$invoke$$inlined$iterator$2(jSONArrayOptJSONArray)).iterator()));
    }
}
