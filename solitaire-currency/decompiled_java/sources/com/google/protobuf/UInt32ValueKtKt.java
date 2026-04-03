package com.google.protobuf;

import com.google.protobuf.UInt32Value;
import com.google.protobuf.UInt32ValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: UInt32ValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UInt32ValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeuInt32Value, reason: not valid java name */
    public static final UInt32Value m3971initializeuInt32Value(@NotNull l<? super UInt32ValueKt.Dsl, k0> block) {
        t.i(block, "block");
        UInt32ValueKt.Dsl.Companion companion = UInt32ValueKt.Dsl.Companion;
        UInt32Value.Builder builderNewBuilder = UInt32Value.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        UInt32ValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final UInt32Value copy(@NotNull UInt32Value uInt32Value, @NotNull l<? super UInt32ValueKt.Dsl, k0> block) {
        t.i(uInt32Value, "<this>");
        t.i(block, "block");
        UInt32ValueKt.Dsl.Companion companion = UInt32ValueKt.Dsl.Companion;
        UInt32Value.Builder builder = uInt32Value.toBuilder();
        t.h(builder, "this.toBuilder()");
        UInt32ValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
