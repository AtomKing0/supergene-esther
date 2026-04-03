package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: CommonSetInitializationState.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class CommonSetInitializationState implements SetInitializationState {

    @NotNull
    private final SessionRepository sessionRepository;

    public CommonSetInitializationState(@NotNull SessionRepository sessionRepository) {
        t.i(sessionRepository, "sessionRepository");
        this.sessionRepository = sessionRepository;
    }

    @Override // com.unity3d.ads.core.domain.SetInitializationState
    public void invoke(@NotNull InitializationState state) {
        t.i(state, "state");
        this.sessionRepository.setInitializationState(state);
    }
}
