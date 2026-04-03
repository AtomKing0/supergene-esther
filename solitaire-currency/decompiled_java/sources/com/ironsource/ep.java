package com.ironsource;

import androidx.media3.exoplayer.RendererCapabilities;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.rewarded.RewardedAdLoaderListener;
import com.unity3d.ironsourceads.rewarded.RewardedAdRequest;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ep implements wk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final RewardedAdRequest f11986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final RewardedAdLoaderListener f11987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final x2 f11988c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final i3 f11989d;

    public ep(@NotNull RewardedAdRequest adRequest, @NotNull RewardedAdLoaderListener publisherListener, @NotNull x2 adapterConfigProvider, @NotNull i3 analyticsFactory) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(publisherListener, "publisherListener");
        kotlin.jvm.internal.t.i(adapterConfigProvider, "adapterConfigProvider");
        kotlin.jvm.internal.t.i(analyticsFactory, "analyticsFactory");
        this.f11986a = adRequest;
        this.f11987b = publisherListener;
        this.f11988c = adapterConfigProvider;
        this.f11989d = analyticsFactory;
    }

    @Override // com.ironsource.wk
    @NotNull
    public tk a() throws Exception {
        IronSourceError ironSourceErrorD;
        String instanceId = this.f11986a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.REWARDED_VIDEO;
        kotlin.jvm.internal.t.h(sDKVersion, "getSDKVersion()");
        j3 j3VarA = this.f11989d.a(new d3(sDKVersion, instanceId, ad_unit, false, false, false, 56, null));
        try {
            uk ukVarA = new vk(this.f11986a.getAdm(), this.f11986a.getProviderName$mediationsdk_release(), this.f11988c, cm.f11590e.a().c().get()).a();
            new cp(ukVarA).a();
            om omVar = new om();
            d5 d5Var = new d5(this.f11986a.getAdm(), this.f11986a.getProviderName$mediationsdk_release());
            RewardedAdRequest rewardedAdRequest = this.f11986a;
            kotlin.jvm.internal.t.f(ukVarA);
            ve veVar = ve.f15889a;
            return new bp(rewardedAdRequest, ukVarA, new dp(veVar, this.f11987b), d5Var, omVar, j3VarA, new wo(j3VarA, veVar.c()), null, null, RendererCapabilities.DECODER_SUPPORT_MASK, null);
        } catch (Exception e10) {
            i9.d().a(e10);
            if (e10 instanceof fq) {
                ironSourceErrorD = ((fq) e10).a();
            } else {
                hb hbVar = hb.f12462a;
                String message = e10.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                ironSourceErrorD = hbVar.d(message);
            }
            return new jb(this.f11986a, new dp(ve.f15889a, this.f11987b), j3VarA, ironSourceErrorD);
        }
    }

    public /* synthetic */ ep(RewardedAdRequest rewardedAdRequest, RewardedAdLoaderListener rewardedAdLoaderListener, x2 x2Var, i3 i3Var, int i10, kotlin.jvm.internal.k kVar) {
        this(rewardedAdRequest, rewardedAdLoaderListener, x2Var, (i10 & 8) != 0 ? new h3(IronSource.AD_UNIT.REWARDED_VIDEO) : i3Var);
    }
}
