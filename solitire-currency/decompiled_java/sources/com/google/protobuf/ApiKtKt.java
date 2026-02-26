package com.google.protobuf;

import com.google.protobuf.Api;
import com.google.protobuf.ApiKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ApiKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ApiKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeapi, reason: not valid java name */
    public static final Api m3948initializeapi(@NotNull l<? super ApiKt.Dsl, k0> block) {
        t.i(block, "block");
        ApiKt.Dsl.Companion companion = ApiKt.Dsl.Companion;
        Api.Builder builderNewBuilder = Api.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ApiKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Api copy(@NotNull Api api, @NotNull l<? super ApiKt.Dsl, k0> block) {
        t.i(api, "<this>");
        t.i(block, "block");
        ApiKt.Dsl.Companion companion = ApiKt.Dsl.Companion;
        Api.Builder builder = api.toBuilder();
        t.h(builder, "this.toBuilder()");
        ApiKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SourceContext getSourceContextOrNull(@NotNull ApiOrBuilder apiOrBuilder) {
        t.i(apiOrBuilder, "<this>");
        if (apiOrBuilder.hasSourceContext()) {
            return apiOrBuilder.getSourceContext();
        }
        return null;
    }
}
