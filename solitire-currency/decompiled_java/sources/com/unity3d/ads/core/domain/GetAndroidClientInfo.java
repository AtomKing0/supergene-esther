package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.manager.OmidManager;
import com.unity3d.ads.core.data.repository.MediationRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import gatewayprotocol.v1.ClientInfoKt;
import gatewayprotocol.v1.ClientInfoOuterClass;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: GetAndroidClientInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class GetAndroidClientInfo implements GetClientInfo {

    @NotNull
    private final MediationRepository mediationRepository;

    @NotNull
    private final OmidManager omidManager;

    @NotNull
    private final SessionRepository sessionRepository;

    public GetAndroidClientInfo(@NotNull SessionRepository sessionRepository, @NotNull MediationRepository mediationRepository, @NotNull OmidManager omidManager) {
        t.i(sessionRepository, "sessionRepository");
        t.i(mediationRepository, "mediationRepository");
        t.i(omidManager, "omidManager");
        this.sessionRepository = sessionRepository;
        this.mediationRepository = mediationRepository;
        this.omidManager = omidManager;
    }

    @Override // com.unity3d.ads.core.domain.GetClientInfo
    @NotNull
    public ClientInfoOuterClass.ClientInfo invoke() {
        ClientInfoKt.Dsl.Companion companion = ClientInfoKt.Dsl.Companion;
        ClientInfoOuterClass.ClientInfo.Builder builderNewBuilder = ClientInfoOuterClass.ClientInfo.newBuilder();
        t.h(builderNewBuilder, "newBuilder()");
        ClientInfoKt.Dsl dsl_create = companion._create(builderNewBuilder);
        dsl_create.setSdkVersion(41203);
        dsl_create.setSdkVersionName("4.12.3");
        dsl_create.setGameId(this.sessionRepository.getGameId());
        dsl_create.setTest(this.sessionRepository.isTestModeEnabled());
        dsl_create.setPlatform(ClientInfoOuterClass.Platform.PLATFORM_ANDROID);
        dsl_create.setMediationProvider(this.mediationRepository.getMediationProvider().invoke());
        String name = this.mediationRepository.getName();
        if (name != null && dsl_create.getMediationProvider() == ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_CUSTOM) {
            dsl_create.setCustomMediationName(name);
        }
        String version = this.mediationRepository.getVersion();
        if (version != null) {
            dsl_create.setMediationVersion(version);
        }
        dsl_create.setOmidVersion(this.omidManager.getVersion());
        dsl_create.setOmidPartnerVersion("1");
        dsl_create.setSdkDevelopmentPlatform(MadeWithUnityDetector.isMadeWithUnity() ? "Unity" : "");
        return dsl_create._build();
    }
}
