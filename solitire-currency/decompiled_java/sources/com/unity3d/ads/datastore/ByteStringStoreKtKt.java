package com.unity3d.ads.datastore;

import com.unity3d.ads.datastore.ByteStringStoreKt;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ByteStringStoreKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ByteStringStoreKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializebyteStringStore, reason: not valid java name */
    public static final ByteStringStoreOuterClass.ByteStringStore m3997initializebyteStringStore(@NotNull l<? super ByteStringStoreKt.Dsl, k0> block) {
        t.i(block, "block");
        ByteStringStoreKt.Dsl.Companion companion = ByteStringStoreKt.Dsl.Companion;
        ByteStringStoreOuterClass.ByteStringStore.Builder builderNewBuilder = ByteStringStoreOuterClass.ByteStringStore.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ByteStringStoreKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final ByteStringStoreOuterClass.ByteStringStore copy(@NotNull ByteStringStoreOuterClass.ByteStringStore byteStringStore, @NotNull l<? super ByteStringStoreKt.Dsl, k0> block) {
        t.i(byteStringStore, "<this>");
        t.i(block, "block");
        ByteStringStoreKt.Dsl.Companion companion = ByteStringStoreKt.Dsl.Companion;
        ByteStringStoreOuterClass.ByteStringStore.Builder builder = byteStringStore.toBuilder();
        t.h(builder, "this.toBuilder()");
        ByteStringStoreKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
