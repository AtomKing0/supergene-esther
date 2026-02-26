package com.google.protobuf;

import com.google.protobuf.BoolValue;
import com.google.protobuf.BoolValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: BoolValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class BoolValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeboolValue, reason: not valid java name */
    public static final BoolValue m3949initializeboolValue(@NotNull l<? super BoolValueKt.Dsl, k0> block) {
        t.i(block, "block");
        BoolValueKt.Dsl.Companion companion = BoolValueKt.Dsl.Companion;
        BoolValue.Builder builderNewBuilder = BoolValue.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        BoolValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final BoolValue copy(@NotNull BoolValue boolValue, @NotNull l<? super BoolValueKt.Dsl, k0> block) {
        t.i(boolValue, "<this>");
        t.i(block, "block");
        BoolValueKt.Dsl.Companion companion = BoolValueKt.Dsl.Companion;
        BoolValue.Builder builder = boolValue.toBuilder();
        t.h(builder, "this.toBuilder()");
        BoolValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
