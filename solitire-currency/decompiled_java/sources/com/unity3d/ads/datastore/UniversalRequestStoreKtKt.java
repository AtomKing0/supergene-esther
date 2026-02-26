package com.unity3d.ads.datastore;

import com.unity3d.ads.datastore.UniversalRequestStoreKt;
import com.unity3d.ads.datastore.UniversalRequestStoreOuterClass;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: UniversalRequestStoreKt.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class UniversalRequestStoreKtKt {
    @NotNull
    /* JADX INFO: renamed from: -initializeuniversalRequestStore, reason: not valid java name */
    public static final UniversalRequestStoreOuterClass.UniversalRequestStore m3998initializeuniversalRequestStore(@NotNull l<? super UniversalRequestStoreKt.Dsl, k0> block) {
        t.i(block, "block");
        UniversalRequestStoreKt.Dsl.Companion companion = UniversalRequestStoreKt.Dsl.Companion;
        UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builderNewBuilder = UniversalRequestStoreOuterClass.UniversalRequestStore.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        UniversalRequestStoreKt.Dsl dsl_create = companion._create(builderNewBuilder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }

    @NotNull
    public static final UniversalRequestStoreOuterClass.UniversalRequestStore copy(@NotNull UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, @NotNull l<? super UniversalRequestStoreKt.Dsl, k0> block) {
        t.i(universalRequestStore, "<this>");
        t.i(block, "block");
        UniversalRequestStoreKt.Dsl.Companion companion = UniversalRequestStoreKt.Dsl.Companion;
        UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = universalRequestStore.toBuilder();
        t.h(builder, "this.toBuilder()");
        UniversalRequestStoreKt.Dsl dsl_create = companion._create(builder);
        block.invoke(dsl_create);
        return dsl_create._build();
    }
}
