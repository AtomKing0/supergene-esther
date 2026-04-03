package com.google.protobuf;

import com.google.protobuf.Int32Value;
import com.google.protobuf.Int32ValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Int32ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class Int32ValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeint32Value, reason: not valid java name */
    public static final Int32Value m3960initializeint32Value(@NotNull l<? super Int32ValueKt.Dsl, k0> block) {
        t.i(block, "block");
        Int32ValueKt.Dsl.Companion companion = Int32ValueKt.Dsl.Companion;
        Int32Value.Builder builderNewBuilder = Int32Value.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        Int32ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Int32Value copy(@NotNull Int32Value int32Value, @NotNull l<? super Int32ValueKt.Dsl, k0> block) {
        t.i(int32Value, "<this>");
        t.i(block, "block");
        Int32ValueKt.Dsl.Companion companion = Int32ValueKt.Dsl.Companion;
        Int32Value.Builder builder = int32Value.toBuilder();
        t.h(builder, "this.toBuilder()");
        Int32ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
