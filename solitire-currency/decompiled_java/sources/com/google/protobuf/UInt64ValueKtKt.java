package com.google.protobuf;

import com.google.protobuf.UInt64Value;
import com.google.protobuf.UInt64ValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: UInt64ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UInt64ValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeuInt64Value, reason: not valid java name */
    public static final UInt64Value m3972initializeuInt64Value(@NotNull l<? super UInt64ValueKt.Dsl, k0> block) {
        t.i(block, "block");
        UInt64ValueKt.Dsl.Companion companion = UInt64ValueKt.Dsl.Companion;
        UInt64Value.Builder builderNewBuilder = UInt64Value.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        UInt64ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final UInt64Value copy(@NotNull UInt64Value uInt64Value, @NotNull l<? super UInt64ValueKt.Dsl, k0> block) {
        t.i(uInt64Value, "<this>");
        t.i(block, "block");
        UInt64ValueKt.Dsl.Companion companion = UInt64ValueKt.Dsl.Companion;
        UInt64Value.Builder builder = uInt64Value.toBuilder();
        t.h(builder, "this.toBuilder()");
        UInt64ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
