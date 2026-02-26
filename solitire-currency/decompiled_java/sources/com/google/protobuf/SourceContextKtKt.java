package com.google.protobuf;

import com.google.protobuf.SourceContext;
import com.google.protobuf.SourceContextKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SourceContextKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class SourceContextKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializesourceContext, reason: not valid java name */
    public static final SourceContext m3966initializesourceContext(@NotNull l<? super SourceContextKt.Dsl, k0> block) {
        t.i(block, "block");
        SourceContextKt.Dsl.Companion companion = SourceContextKt.Dsl.Companion;
        SourceContext.Builder builderNewBuilder = SourceContext.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        SourceContextKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final SourceContext copy(@NotNull SourceContext sourceContext, @NotNull l<? super SourceContextKt.Dsl, k0> block) {
        t.i(sourceContext, "<this>");
        t.i(block, "block");
        SourceContextKt.Dsl.Companion companion = SourceContextKt.Dsl.Companion;
        SourceContext.Builder builder = sourceContext.toBuilder();
        t.h(builder, "this.toBuilder()");
        SourceContextKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
