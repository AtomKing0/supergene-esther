package com.unity3d.ads.core.configuration;

import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.configuration.ConfigurationReader;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import s9.o0;
import s9.y;

/* JADX INFO: compiled from: AlternativeFlowReader.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class AlternativeFlowReader {

    @NotNull
    private final ConfigurationReader configurationReader;

    @NotNull
    private final y<Boolean> isAlternativeFlowEnabled;

    @NotNull
    private final y<Boolean> isAlternativeFlowRead;

    @NotNull
    private final SessionRepository sessionRepository;

    public AlternativeFlowReader(@NotNull ConfigurationReader configurationReader, @NotNull SessionRepository sessionRepository) {
        t.i(configurationReader, "configurationReader");
        t.i(sessionRepository, "sessionRepository");
        this.configurationReader = configurationReader;
        this.sessionRepository = sessionRepository;
        Boolean bool = Boolean.FALSE;
        this.isAlternativeFlowRead = o0.a(bool);
        this.isAlternativeFlowEnabled = o0.a(bool);
    }

    public final boolean invoke() {
        if (!this.isAlternativeFlowRead.getValue().booleanValue()) {
            this.isAlternativeFlowEnabled.setValue(Boolean.valueOf(this.configurationReader.getCurrentConfiguration().getExperiments().isBoldSdkNextSessionEnabled() || this.sessionRepository.getNativeConfiguration().getFeatureFlags().getBoldSdkNextSessionEnabled()));
            this.isAlternativeFlowRead.setValue(Boolean.TRUE);
        }
        return this.isAlternativeFlowEnabled.getValue().booleanValue();
    }
}
