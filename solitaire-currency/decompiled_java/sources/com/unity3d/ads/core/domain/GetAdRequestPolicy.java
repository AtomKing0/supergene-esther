package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetAdRequestPolicy.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAdRequestPolicy implements GetRequestPolicy {

    @NotNull
    private final SessionRepository sessionRepository;

    public GetAdRequestPolicy(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetRequestPolicy
    @NotNull
    public RequestPolicy invoke() {
        return new RequestPolicy(this.sessionRepository.getNativeConfiguration().getAdPolicy().getRetryPolicy().getMaxDuration(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getRetryPolicy().getRetryMaxInterval(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getRetryPolicy().getRetryWaitBase(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getRetryPolicy().getRetryJitterPct(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getTimeoutPolicy().getConnectTimeoutMs(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getTimeoutPolicy().getReadTimeoutMs(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getTimeoutPolicy().getWriteTimeoutMs(), this.sessionRepository.getNativeConfiguration().getAdPolicy().getRetryPolicy().getShouldStoreLocally());
    }
}
