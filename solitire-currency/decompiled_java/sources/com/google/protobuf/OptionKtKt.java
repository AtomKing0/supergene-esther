package com.google.protobuf;

import com.google.protobuf.Option;
import com.google.protobuf.OptionKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: OptionKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class OptionKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeoption, reason: not valid java name */
    public static final Option m3965initializeoption(@NotNull l<? super OptionKt.Dsl, k0> block) {
        t.i(block, "block");
        OptionKt.Dsl.Companion companion = OptionKt.Dsl.Companion;
        Option.Builder builderNewBuilder = Option.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        OptionKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Option copy(@NotNull Option option, @NotNull l<? super OptionKt.Dsl, k0> block) {
        t.i(option, "<this>");
        t.i(block, "block");
        OptionKt.Dsl.Companion companion = OptionKt.Dsl.Companion;
        Option.Builder builder = option.toBuilder();
        t.h(builder, "this.toBuilder()");
        OptionKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final Any getValueOrNull(@NotNull OptionOrBuilder optionOrBuilder) {
        t.i(optionOrBuilder, "<this>");
        if (optionOrBuilder.hasValue()) {
            return optionOrBuilder.getValue();
        }
        return null;
    }
}
