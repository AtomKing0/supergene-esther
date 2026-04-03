package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: AdRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface AdRepository {
    @Nullable
    Object addAd(@NotNull ByteString byteString, @NotNull AdObject adObject, @NotNull d<? super k0> dVar);

    @Nullable
    Object getAd(@NotNull ByteString byteString, @NotNull d<? super AdObject> dVar);

    @Nullable
    Object hasOpportunityId(@NotNull ByteString byteString, @NotNull d<? super Boolean> dVar);

    @Nullable
    Object removeAd(@NotNull ByteString byteString, @NotNull d<? super k0> dVar);
}
