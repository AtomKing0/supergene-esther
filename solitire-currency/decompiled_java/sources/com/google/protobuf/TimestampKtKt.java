package com.google.protobuf;

import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TimestampKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TimestampKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializetimestamp, reason: not valid java name */
    public static final Timestamp m3969initializetimestamp(@NotNull l<? super TimestampKt.Dsl, k0> block) {
        t.i(block, "block");
        TimestampKt.Dsl.Companion companion = TimestampKt.Dsl.Companion;
        Timestamp.Builder builderNewBuilder = Timestamp.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TimestampKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Timestamp copy(@NotNull Timestamp timestamp, @NotNull l<? super TimestampKt.Dsl, k0> block) {
        t.i(timestamp, "<this>");
        t.i(block, "block");
        TimestampKt.Dsl.Companion companion = TimestampKt.Dsl.Companion;
        Timestamp.Builder builder = timestamp.toBuilder();
        t.h(builder, "this.toBuilder()");
        TimestampKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
