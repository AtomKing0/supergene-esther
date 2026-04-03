package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class jb implements tk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final RewardedAdRequest f12722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final dp f12723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final j3 f12724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final IronSourceError f12725d;

    public jb(@NotNull RewardedAdRequest adRequest, @NotNull dp adLoadTaskListener, @NotNull j3 analytics, @NotNull IronSourceError error) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(adLoadTaskListener, "adLoadTaskListener");
        kotlin.jvm.internal.t.i(analytics, "analytics");
        kotlin.jvm.internal.t.i(error, "error");
        this.f12722a = adRequest;
        this.f12723b = adLoadTaskListener;
        this.f12724c = analytics;
        this.f12725d = error;
    }

    @NotNull
    public final IronSourceError a() {
        return this.f12725d;
    }

    @Override // com.ironsource.tk
    public void start() {
        eb ebVar = new eb(this.f12724c, this.f12722a.getAdId$mediationsdk_release(), this.f12722a.getProviderName$mediationsdk_release());
        ebVar.a();
        ebVar.a(this.f12725d);
        this.f12723b.onAdLoadFailed(this.f12725d);
    }
}
