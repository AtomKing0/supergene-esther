package com.google.protobuf;

import com.google.protobuf.EnumValue;
import com.google.protobuf.EnumValueKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: EnumValueKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EnumValueKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeenumValue, reason: not valid java name */
    public static final EnumValue m3955initializeenumValue(@NotNull l<? super EnumValueKt.Dsl, k0> block) {
        t.i(block, "block");
        EnumValueKt.Dsl.Companion companion = EnumValueKt.Dsl.Companion;
        EnumValue.Builder builderNewBuilder = EnumValue.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        EnumValueKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final EnumValue copy(@NotNull EnumValue enumValue, @NotNull l<? super EnumValueKt.Dsl, k0> block) {
        t.i(enumValue, "<this>");
        t.i(block, "block");
        EnumValueKt.Dsl.Companion companion = EnumValueKt.Dsl.Companion;
        EnumValue.Builder builder = enumValue.toBuilder();
        t.h(builder, "this.toBuilder()");
        EnumValueKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
