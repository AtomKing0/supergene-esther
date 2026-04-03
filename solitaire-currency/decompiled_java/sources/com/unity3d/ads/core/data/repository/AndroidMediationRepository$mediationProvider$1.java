package com.unity3d.ads.core.data.repository;

import gatewayprotocol.v1.ClientInfoOuterClass;
import h9.a;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import p9.q;

/* JADX INFO: compiled from: AndroidMediationRepository.kt */
/* JADX INFO: loaded from: classes4.dex */
final class AndroidMediationRepository$mediationProvider$1 extends v implements a<ClientInfoOuterClass.MediationProvider> {
    final /* synthetic */ AndroidMediationRepository this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidMediationRepository$mediationProvider$1(AndroidMediationRepository androidMediationRepository) {
        super(0);
        this.this$0 = androidMediationRepository;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final ClientInfoOuterClass.MediationProvider invoke() {
        String name = this.this$0.getName();
        if (name != null) {
            ClientInfoOuterClass.MediationProvider mediationProvider = q.K(name, "AppLovinSdk_", false, 2, null) ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_MAX : q.x(name, "AdMob", true) ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_ADMOB : q.x(name, "MAX", true) ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_MAX : q.x(name, "ironSource", true) ? ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_LEVELPLAY : ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_CUSTOM;
            if (mediationProvider != null) {
                return mediationProvider;
            }
        }
        return ClientInfoOuterClass.MediationProvider.MEDIATION_PROVIDER_UNSPECIFIED;
    }
}
