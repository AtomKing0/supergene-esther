package com.google.protobuf;

import com.google.protobuf.DoubleValue;
import com.google.protobuf.DoubleValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DoubleValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DoubleValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializedoubleValue, reason: not valid java name */
    public static final DoubleValue m3951initializedoubleValue(@NotNull l<? super DoubleValueKt.Dsl, k0> block) {
        t.i(block, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.Companion;
        DoubleValue.Builder builderNewBuilder = DoubleValue.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DoubleValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final DoubleValue copy(@NotNull DoubleValue doubleValue, @NotNull l<? super DoubleValueKt.Dsl, k0> block) {
        t.i(doubleValue, "<this>");
        t.i(block, "block");
        DoubleValueKt.Dsl.Companion companion = DoubleValueKt.Dsl.Companion;
        DoubleValue.Builder builder = doubleValue.toBuilder();
        t.h(builder, "this.toBuilder()");
        DoubleValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
