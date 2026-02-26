package com.unity3d.ads.core.data.datasource;

import com.google.protobuf.ByteString;
import com.unity3d.ads.datastore.ByteStringStoreOuterClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: ByteStringDataSource.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface ByteStringDataSource {
    @Nullable
    Object get(@NotNull d<? super ByteStringStoreOuterClass.ByteStringStore> dVar);

    @Nullable
    Object set(@NotNull ByteString byteString, @NotNull d<? super k0> dVar);
}
