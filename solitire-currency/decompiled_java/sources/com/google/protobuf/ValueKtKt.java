package com.google.protobuf;

import com.google.protobuf.Value;
import com.google.protobuf.ValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializevalue, reason: not valid java name */
    public static final Value m3973initializevalue(@NotNull l<? super ValueKt.Dsl, k0> block) {
        t.i(block, "block");
        ValueKt.Dsl.Companion companion = ValueKt.Dsl.Companion;
        Value.Builder builderNewBuilder = Value.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Value copy(@NotNull Value value, @NotNull l<? super ValueKt.Dsl, k0> block) {
        t.i(value, "<this>");
        t.i(block, "block");
        ValueKt.Dsl.Companion companion = ValueKt.Dsl.Companion;
        Value.Builder builder = value.toBuilder();
        t.h(builder, "this.toBuilder()");
        ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final ListValue getListValueOrNull(@NotNull ValueOrBuilder valueOrBuilder) {
        t.i(valueOrBuilder, "<this>");
        if (valueOrBuilder.hasListValue()) {
            return valueOrBuilder.getListValue();
        }
        return null;
    }

    @Nullable
    public static final Struct getStructValueOrNull(@NotNull ValueOrBuilder valueOrBuilder) {
        t.i(valueOrBuilder, "<this>");
        if (valueOrBuilder.hasStructValue()) {
            return valueOrBuilder.getStructValue();
        }
        return null;
    }
}
