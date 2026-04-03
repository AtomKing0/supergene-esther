package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.ClientInfoOuterClass;
import h9.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MediationRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface MediationRepository {
    @NotNull
    a<ClientInfoOuterClass.MediationProvider> getMediationProvider();

    @Nullable
    String getName();

    @Nullable
    String getVersion();
}
