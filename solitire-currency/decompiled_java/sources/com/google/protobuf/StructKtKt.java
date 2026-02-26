package com.google.protobuf;

import com.google.protobuf.Struct;
import com.google.protobuf.StructKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: StructKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StructKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializestruct, reason: not valid java name */
    public static final Struct m3968initializestruct(@NotNull l<? super StructKt.Dsl, k0> block) {
        t.i(block, "block");
        StructKt.Dsl.Companion companion = StructKt.Dsl.Companion;
        Struct.Builder builderNewBuilder = Struct.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        StructKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Struct copy(@NotNull Struct struct, @NotNull l<? super StructKt.Dsl, k0> block) {
        t.i(struct, "<this>");
        t.i(block, "block");
        StructKt.Dsl.Companion companion = StructKt.Dsl.Companion;
        Struct.Builder builder = struct.toBuilder();
        t.h(builder, "this.toBuilder()");
        StructKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
