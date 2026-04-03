package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CommonGetInitializationState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonGetInitializationState implements GetInitializationState {

    @NotNull
    private final SessionRepository sessionRepository;

    public CommonGetInitializationState(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.GetInitializationState
    @NotNull
    public InitializationState invoke() {
        return this.sessionRepository.getInitializationState();
    }
}
