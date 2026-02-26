package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CommonGetAdObject.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonGetAdObject implements GetAdObject {

    @NotNull
    private final AdRepository adRepository;

    public CommonGetAdObject(@NotNull AdRepository adRepository) {
        t.i(adRepository, "adRepository");
        this.adRepository = adRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetAdObject
    @Nullable
    public Object invoke(@NotNull String str, @NotNull z8.d<? super AdObject> dVar) {
        return this.adRepository.getAd(ProtobufExtensionsKt.toISO8859ByteString(str), dVar);
    }
}
