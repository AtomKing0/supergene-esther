package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.datasource.LegacyUserConsentDataSource;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidLegacyUserConsentRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidLegacyUserConsentRepository implements LegacyUserConsentRepository {

    @NotNull
    private final LegacyUserConsentDataSource legacyUserConsentDataSource;

    public AndroidLegacyUserConsentRepository(@NotNull LegacyUserConsentDataSource legacyUserConsentDataSource) {
        t.i(legacyUserConsentDataSource, "legacyUserConsentDataSource");
        this.legacyUserConsentDataSource = legacyUserConsentDataSource;
    }

    @Override // com.unity3d.ads.core.data.repository.LegacyUserConsentRepository
    @Nullable
    public String getLegacyFlowUserConsent() {
        return this.legacyUserConsentDataSource.getPrivacyData();
    }
}
