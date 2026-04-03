package com.braze.ui.actions.brazeactions.steps;

import h9.l;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* JADX INFO: compiled from: JsonUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StepData$args$2$invoke$$inlined$iterator$1 extends v implements l<Integer, Boolean> {
    final /* synthetic */ JSONArray $this_iterator;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepData$args$2$invoke$$inlined$iterator$1(JSONArray jSONArray) {
        super(1);
        this.$this_iterator = jSONArray;
    }

    @NotNull
    public final Boolean invoke(int i10) {
        return Boolean.valueOf(this.$this_iterator.opt(i10) instanceof Object);
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return invoke(num.intValue());
    }
}
