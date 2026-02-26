package com.google.protobuf;

import com.google.protobuf.ListValue;
import com.google.protobuf.ListValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ListValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ListValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializelistValue, reason: not valid java name */
    public static final ListValue m3962initializelistValue(@NotNull l<? super ListValueKt.Dsl, k0> block) {
        t.i(block, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder builderNewBuilder = ListValue.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ListValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final ListValue copy(@NotNull ListValue listValue, @NotNull l<? super ListValueKt.Dsl, k0> block) {
        t.i(listValue, "<this>");
        t.i(block, "block");
        ListValueKt.Dsl.Companion companion = ListValueKt.Dsl.Companion;
        ListValue.Builder builder = listValue.toBuilder();
        t.h(builder, "this.toBuilder()");
        ListValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
