package com.unity3d.ads.core.data.repository;

import com.unity3d.ads.core.data.datasource.DeveloperConsentDataSource;
import gatewayprotocol.v1.DeveloperConsentOuterClass;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AndroidDeveloperConsentRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AndroidDeveloperConsentRepository implements DeveloperConsentRepository {

    @NotNull
    private final DeveloperConsentOuterClass.DeveloperConsent developerConsent;

    public AndroidDeveloperConsentRepository(@NotNull DeveloperConsentDataSource developerConsentDataSource) {
        t.i(developerConsentDataSource, "developerConsentDataSource");
        this.developerConsent = developerConsentDataSource.getDeveloperConsent();
    }

    @Override // com.unity3d.ads.core.data.repository.DeveloperConsentRepository
    @NotNull
    public DeveloperConsentOuterClass.DeveloperConsent getDeveloperConsent() {
        return this.developerConsent;
    }
}
