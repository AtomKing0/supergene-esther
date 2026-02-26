package com.google.protobuf;

import com.google.protobuf.Int64Value;
import com.google.protobuf.Int64ValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Int64ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Int64ValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeint64Value, reason: not valid java name */
    public static final Int64Value m3961initializeint64Value(@NotNull l<? super Int64ValueKt.Dsl, k0> block) {
        t.i(block, "block");
        Int64ValueKt.Dsl.Companion companion = Int64ValueKt.Dsl.Companion;
        Int64Value.Builder builderNewBuilder = Int64Value.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        Int64ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Int64Value copy(@NotNull Int64Value int64Value, @NotNull l<? super Int64ValueKt.Dsl, k0> block) {
        t.i(int64Value, "<this>");
        t.i(block, "block");
        Int64ValueKt.Dsl.Companion companion = Int64ValueKt.Dsl.Companion;
        Int64Value.Builder builder = int64Value.toBuilder();
        t.h(builder, "this.toBuilder()");
        Int64ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
