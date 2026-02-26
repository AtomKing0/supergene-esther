package com.google.protobuf;

import com.google.protobuf.FloatValue;
import com.google.protobuf.FloatValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FloatValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FloatValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializefloatValue, reason: not valid java name */
    public static final FloatValue m3959initializefloatValue(@NotNull l<? super FloatValueKt.Dsl, k0> block) {
        t.i(block, "block");
        FloatValueKt.Dsl.Companion companion = FloatValueKt.Dsl.Companion;
        FloatValue.Builder builderNewBuilder = FloatValue.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        FloatValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final FloatValue copy(@NotNull FloatValue floatValue, @NotNull l<? super FloatValueKt.Dsl, k0> block) {
        t.i(floatValue, "<this>");
        t.i(block, "block");
        FloatValueKt.Dsl.Companion companion = FloatValueKt.Dsl.Companion;
        FloatValue.Builder builder = floatValue.toBuilder();
        t.h(builder, "this.toBuilder()");
        FloatValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
