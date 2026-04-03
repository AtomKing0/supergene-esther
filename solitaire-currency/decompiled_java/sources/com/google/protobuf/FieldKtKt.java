package com.google.protobuf;

import com.google.protobuf.Field;
import com.google.protobuf.FieldKt;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: FieldKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class FieldKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializefield, reason: not valid java name */
    public static final Field m3956initializefield(@NotNull l<? super FieldKt.Dsl, k0> block) {
        t.i(block, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder builderNewBuilder = Field.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        FieldKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final Field copy(@NotNull Field field, @NotNull l<? super FieldKt.Dsl, k0> block) {
        t.i(field, "<this>");
        t.i(block, "block");
        FieldKt.Dsl.Companion companion = FieldKt.Dsl.Companion;
        Field.Builder builder = field.toBuilder();
        t.h(builder, "this.toBuilder()");
        FieldKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
