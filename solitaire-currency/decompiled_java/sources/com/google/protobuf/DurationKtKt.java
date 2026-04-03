package com.google.protobuf;

import com.google.protobuf.Duration;
import com.google.protobuf.DurationKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: DurationKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class DurationKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeduration, reason: not valid java name */
    public static final Duration m3952initializeduration(@NotNull l<? super DurationKt.Dsl, k0> block) {
        t.i(block, "block");
        DurationKt.Dsl.Companion companion = DurationKt.Dsl.Companion;
        Duration.Builder builderNewBuilder = Duration.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        DurationKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Duration copy(@NotNull Duration duration, @NotNull l<? super DurationKt.Dsl, k0> block) {
        t.i(duration, "<this>");
        t.i(block, "block");
        DurationKt.Dsl.Companion companion = DurationKt.Dsl.Companion;
        Duration.Builder builder = duration.toBuilder();
        t.h(builder, "this.toBuilder()");
        DurationKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
