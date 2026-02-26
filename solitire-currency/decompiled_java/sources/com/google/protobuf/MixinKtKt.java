package com.google.protobuf;

import com.google.protobuf.Mixin;
import com.google.protobuf.MixinKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: MixinKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MixinKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializemixin, reason: not valid java name */
    public static final Mixin m3964initializemixin(@NotNull l<? super MixinKt.Dsl, k0> block) {
        t.i(block, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder builderNewBuilder = Mixin.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        MixinKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Mixin copy(@NotNull Mixin mixin, @NotNull l<? super MixinKt.Dsl, k0> block) {
        t.i(mixin, "<this>");
        t.i(block, "block");
        MixinKt.Dsl.Companion companion = MixinKt.Dsl.Companion;
        Mixin.Builder builder = mixin.toBuilder();
        t.h(builder, "this.toBuilder()");
        MixinKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
