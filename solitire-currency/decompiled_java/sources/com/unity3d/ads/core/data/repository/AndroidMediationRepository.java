package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.datasource.MediationDataSource;
import gatewayprotocol.v1.ClientInfoOuterClass;
import h9.a;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidMediationRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidMediationRepository implements MediationRepository {

    @NotNull
    private final MediationDataSource mediationDataSource;

    public AndroidMediationRepository(@NotNull MediationDataSource mediationDataSource) {
        t.i(mediationDataSource, "mediationDataSource");
        this.mediationDataSource = mediationDataSource;
    }

    @Override // com.unity3d.ads.core.data.repository.MediationRepository
    @NotNull
    public a<ClientInfoOuterClass.MediationProvider> getMediationProvider() {
        return new AndroidMediationRepository$mediationProvider$1(this);
    }

    @Override // com.unity3d.ads.core.data.repository.MediationRepository
    @Nullable
    public String getName() {
        return this.mediationDataSource.getName();
    }

    @Override // com.unity3d.ads.core.data.repository.MediationRepository
    @Nullable
    public String getVersion() {
        return this.mediationDataSource.getVersion();
    }
}
