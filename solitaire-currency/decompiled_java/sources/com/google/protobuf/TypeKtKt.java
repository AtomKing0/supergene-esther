package com.google.protobuf;

import com.google.protobuf.Type;
import com.google.protobuf.TypeKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TypeKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class TypeKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializetype, reason: not valid java name */
    public static final Type m3970initializetype(@NotNull l<? super TypeKt.Dsl, k0> block) {
        t.i(block, "block");
        TypeKt.Dsl.Companion companion = TypeKt.Dsl.Companion;
        Type.Builder builderNewBuilder = Type.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        TypeKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Type copy(@NotNull Type type, @NotNull l<? super TypeKt.Dsl, k0> block) {
        t.i(type, "<this>");
        t.i(block, "block");
        TypeKt.Dsl.Companion companion = TypeKt.Dsl.Companion;
        Type.Builder builder = type.toBuilder();
        t.h(builder, "this.toBuilder()");
        TypeKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @Nullable
    public static final SourceContext getSourceContextOrNull(@NotNull TypeOrBuilder typeOrBuilder) {
        t.i(typeOrBuilder, "<this>");
        if (typeOrBuilder.hasSourceContext()) {
            return typeOrBuilder.getSourceContext();
        }
        return null;
    }
}
