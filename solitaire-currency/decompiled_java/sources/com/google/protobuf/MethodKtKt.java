package com.google.protobuf;

import com.google.protobuf.Method;
import com.google.protobuf.MethodKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: MethodKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MethodKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializemethod, reason: not valid java name */
    public static final Method m3963initializemethod(@NotNull l<? super MethodKt.Dsl, k0> block) {
        t.i(block, "block");
        MethodKt.Dsl.Companion companion = MethodKt.Dsl.Companion;
        Method.Builder builderNewBuilder = Method.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        MethodKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Method copy(@NotNull Method method, @NotNull l<? super MethodKt.Dsl, k0> block) {
        t.i(method, "<this>");
        t.i(block, "block");
        MethodKt.Dsl.Companion companion = MethodKt.Dsl.Companion;
        Method.Builder builder = method.toBuilder();
        t.h(builder, "this.toBuilder()");
        MethodKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
