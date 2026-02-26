package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.publisher.privacy.MolocoPrivacy;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t implements j<MolocoPrivacy.PrivacySettings> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.bidtoken.u f18543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f18544c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public MolocoPrivacy.PrivacySettings f18545d;

    public t(@NotNull com.moloco.sdk.internal.services.bidtoken.u privacyProvider) {
        kotlin.jvm.internal.t.i(privacyProvider, "privacyProvider");
        this.f18543b = privacyProvider;
        this.f18544c = "PrivacyStateSignalProvider";
        this.f18545d = privacyProvider.getPrivacy();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public void a() {
        this.f18545d = this.f18543b.getPrivacy();
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    public boolean b() {
        boolean z10 = !kotlin.jvm.internal.t.d(this.f18545d, this.f18543b.getPrivacy());
        MolocoLogger.debugBuildLog$default(MolocoLogger.INSTANCE, this.f18544c, z10 ? "[CBT] privacy updated" : "[CBT] privacy didn't change", false, 4, null);
        return z10;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    public String c() {
        return this.f18544c;
    }

    @Override // com.moloco.sdk.internal.services.bidtoken.providers.j
    @NotNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public MolocoPrivacy.PrivacySettings d() {
        return this.f18545d;
    }
}
