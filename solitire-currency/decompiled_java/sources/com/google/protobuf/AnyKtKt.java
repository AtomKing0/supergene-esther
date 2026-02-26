package com.google.protobuf;

import com.google.protobuf.Any;
import com.google.protobuf.AnyKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: AnyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AnyKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeany, reason: not valid java name */
    public static final Any m3947initializeany(@NotNull l<? super AnyKt.Dsl, k0> block) {
        t.i(block, "block");
        AnyKt.Dsl.Companion companion = AnyKt.Dsl.Companion;
        Any.Builder builderNewBuilder = Any.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        AnyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Any copy(@NotNull Any any, @NotNull l<? super AnyKt.Dsl, k0> block) {
        t.i(any, "<this>");
        t.i(block, "block");
        AnyKt.Dsl.Companion companion = AnyKt.Dsl.Companion;
        Any.Builder builder = any.toBuilder();
        t.h(builder, "this.toBuilder()");
        AnyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
