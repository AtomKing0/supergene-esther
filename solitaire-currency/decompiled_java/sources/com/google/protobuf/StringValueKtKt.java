package com.google.protobuf;

import com.google.protobuf.StringValue;
import com.google.protobuf.StringValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: StringValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class StringValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializestringValue, reason: not valid java name */
    public static final StringValue m3967initializestringValue(@NotNull l<? super StringValueKt.Dsl, k0> block) {
        t.i(block, "block");
        StringValueKt.Dsl.Companion companion = StringValueKt.Dsl.Companion;
        StringValue.Builder builderNewBuilder = StringValue.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        StringValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final StringValue copy(@NotNull StringValue stringValue, @NotNull l<? super StringValueKt.Dsl, k0> block) {
        t.i(stringValue, "<this>");
        t.i(block, "block");
        StringValueKt.Dsl.Companion companion = StringValueKt.Dsl.Companion;
        StringValue.Builder builder = stringValue.toBuilder();
        t.h(builder, "this.toBuilder()");
        StringValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
