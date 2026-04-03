package com.google.protobuf;

import com.google.protobuf.Enum;
import com.google.protobuf.EnumKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: EnumKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class EnumKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeenum, reason: not valid java name */
    public static final Enum m3954initializeenum(@NotNull l<? super EnumKt.Dsl, k0> block) {
        t.i(block, "block");
        EnumKt.Dsl.Companion companion = EnumKt.Dsl.Companion;
        Enum.Builder builderNewBuilder = Enum.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        EnumKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Enum copy(@NotNull Enum r22, @NotNull l<? super EnumKt.Dsl, k0> block) {
        t.i(r22, "<this>");
        t.i(block, "block");
        EnumKt.Dsl.Companion companion = EnumKt.Dsl.Companion;
        Enum.Builder builder = r22.toBuilder();
        t.h(builder, "this.toBuilder()");
        EnumKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SourceContext getSourceContextOrNull(@NotNull EnumOrBuilder enumOrBuilder) {
        t.i(enumOrBuilder, "<this>");
        if (enumOrBuilder.hasSourceContext()) {
            return enumOrBuilder.getSourceContext();
        }
        return null;
    }
}
