package com.ironsource;

import androidx.media3.exoplayer.RendererCapabilities;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.interstitial.InterstitialAdLoaderListener;
import com.unity3d.ironsourceads.interstitial.InterstitialAdRequest;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class uh implements wk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final InterstitialAdRequest f15590a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final InterstitialAdLoaderListener f15591b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final x2 f15592c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final i3 f15593d;

    public uh(@NotNull InterstitialAdRequest adRequest, @NotNull InterstitialAdLoaderListener publisherListener, @NotNull x2 adapterConfigProvider, @NotNull i3 analyticsFactory) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(publisherListener, "publisherListener");
        kotlin.jvm.internal.t.i(adapterConfigProvider, "adapterConfigProvider");
        kotlin.jvm.internal.t.i(analyticsFactory, "analyticsFactory");
        this.f15590a = adRequest;
        this.f15591b = publisherListener;
        this.f15592c = adapterConfigProvider;
        this.f15593d = analyticsFactory;
    }

    @Override // com.ironsource.wk
    @NotNull
    public tk a() throws Exception {
        IronSourceError ironSourceErrorB;
        String instanceId = this.f15590a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.INTERSTITIAL;
        kotlin.jvm.internal.t.h(sDKVersion, "getSDKVersion()");
        j3 j3VarA = this.f15593d.a(new d3(sDKVersion, instanceId, ad_unit, false, false, false, 56, null));
        try {
            uk ukVarA = new vk(this.f15590a.getAdm(), this.f15590a.getProviderName$mediationsdk_release(), this.f15592c, cm.f11590e.a().c().get()).a();
            new sh(ukVarA).a();
            om omVar = new om();
            d5 d5Var = new d5(this.f15590a.getAdm(), this.f15590a.getProviderName$mediationsdk_release());
            InterstitialAdRequest interstitialAdRequest = this.f15590a;
            kotlin.jvm.internal.t.f(ukVarA);
            ve veVar = ve.f15889a;
            return new rh(interstitialAdRequest, ukVarA, new th(veVar, this.f15591b), d5Var, omVar, j3VarA, new nh(j3VarA, veVar.c()), null, null, RendererCapabilities.DECODER_SUPPORT_MASK, null);
        } catch (Exception e10) {
            i9.d().a(e10);
            if (e10 instanceof fq) {
                ironSourceErrorB = ((fq) e10).a();
            } else {
                hb hbVar = hb.f12462a;
                String message = e10.getMessage();
                if (message == null) {
                    message = "unknown error";
                }
                ironSourceErrorB = hbVar.b(message);
            }
            return new ib(this.f15590a, new th(ve.f15889a, this.f15591b), j3VarA, ironSourceErrorB);
        }
    }

    public /* synthetic */ uh(InterstitialAdRequest interstitialAdRequest, InterstitialAdLoaderListener interstitialAdLoaderListener, x2 x2Var, i3 i3Var, int i10, kotlin.jvm.internal.k kVar) {
        this(interstitialAdRequest, interstitialAdLoaderListener, x2Var, (i10 & 8) != 0 ? new h3(IronSource.AD_UNIT.INTERSTITIAL) : i3Var);
    }
}
