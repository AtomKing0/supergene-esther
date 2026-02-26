package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ib implements tk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final InterstitialAdRequest f12588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final th f12589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final j3 f12590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final IronSourceError f12591d;

    public ib(@NotNull InterstitialAdRequest adRequest, @NotNull th adLoadTaskListener, @NotNull j3 analytics, @NotNull IronSourceError error) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(error, "error");
        this.f12588a = adRequest;
        this.f12589b = adLoadTaskListener;
        this.f12590c = analytics;
        this.f12591d = error;
    }

    @NotNull
    public final IronSourceError a() {
        return this.f12591d;
    }

    @Override // com.ironsource.tk
    public void start() {
        eb ebVar = new eb(this.f12590c, this.f12588a.getAdId$mediationsdk_release(), this.f12588a.getProviderName$mediationsdk_release());
        ebVar.a();
        ebVar.a(this.f12591d);
        this.f12589b.onAdLoadFailed(this.f12591d);
    }
}
