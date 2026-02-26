package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.coroutines.jvm.internal.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.d;

/* JADX INFO: compiled from: AndroidAdRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidAdRepository implements AdRepository {

    @NotNull
    private final ConcurrentHashMap<ByteString, AdObject> loadedAds = new ConcurrentHashMap<>();

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    @Nullable
    public Object addAd(@NotNull ByteString byteString, @NotNull AdObject adObject, @NotNull d<? super k0> dVar) {
        this.loadedAds.put(byteString, adObject);
        return k0.f35197a;
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    @Nullable
    public Object getAd(@NotNull ByteString byteString, @NotNull d<? super AdObject> dVar) {
        return this.loadedAds.get(byteString);
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    @Nullable
    public Object hasOpportunityId(@NotNull ByteString byteString, @NotNull d<? super Boolean> dVar) {
        return b.a(this.loadedAds.containsKey(byteString));
    }

    @Override // com.unity3d.ads.core.data.repository.AdRepository
    @Nullable
    public Object removeAd(@NotNull ByteString byteString, @NotNull d<? super k0> dVar) {
        this.loadedAds.remove(byteString);
        return k0.f35197a;
    }
}
