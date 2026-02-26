package com.google.protobuf;

import com.google.protobuf.Empty;
import com.google.protobuf.EmptyKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: EmptyKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EmptyKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeempty, reason: not valid java name */
    public static final Empty m3953initializeempty(@NotNull l<? super EmptyKt.Dsl, k0> block) {
        t.i(block, "block");
        EmptyKt.Dsl.Companion companion = EmptyKt.Dsl.Companion;
        Empty.Builder builderNewBuilder = Empty.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        EmptyKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Empty copy(@NotNull Empty empty, @NotNull l<? super EmptyKt.Dsl, k0> block) {
        t.i(empty, "<this>");
        t.i(block, "block");
        EmptyKt.Dsl.Companion companion = EmptyKt.Dsl.Companion;
        Empty.Builder builder = empty.toBuilder();
        t.h(builder, "this.toBuilder()");
        EmptyKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
