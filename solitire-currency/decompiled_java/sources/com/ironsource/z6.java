package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.sdk.utils.SDKUtils;
import com.unity3d.ironsourceads.AdSize;
import com.unity3d.ironsourceads.banner.BannerAdLoaderListener;
import com.unity3d.ironsourceads.banner.BannerAdRequest;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class z6 implements wk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final BannerAdRequest f16387a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final BannerAdLoaderListener f16388b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final x2 f16389c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final i3 f16390d;

    public z6(@NotNull BannerAdRequest adRequest, @NotNull BannerAdLoaderListener publisherListener, @NotNull x2 adapterConfigProvider, @NotNull i3 analyticsFactory) {
        kotlin.jvm.internal.t.i(adRequest, "adRequest");
        kotlin.jvm.internal.t.i(publisherListener, "publisherListener");
        kotlin.jvm.internal.t.i(adapterConfigProvider, "adapterConfigProvider");
        kotlin.jvm.internal.t.i(analyticsFactory, "analyticsFactory");
        this.f16387a = adRequest;
        this.f16388b = publisherListener;
        this.f16389c = adapterConfigProvider;
        this.f16390d = analyticsFactory;
    }

    @Override // com.ironsource.wk
    @NotNull
    public tk a() throws Exception {
        IronSourceError ironSourceErrorA;
        String instanceId = this.f16387a.getInstanceId();
        String sDKVersion = SDKUtils.getSDKVersion();
        IronSource.AD_UNIT ad_unit = IronSource.AD_UNIT.BANNER;
        kotlin.jvm.internal.t.h(sDKVersion, "getSDKVersion()");
        j3 j3VarA = this.f16390d.a(new d3(sDKVersion, instanceId, ad_unit, false, false, false, 56, null));
        try {
            uk ukVarA = new vk(this.f16387a.getAdm(), this.f16387a.getProviderName$mediationsdk_release(), this.f16389c, cm.f11590e.a().c().get()).a();
            new x6(ukVarA, this.f16387a.getSize()).a();
            om omVar = new om();
            d5 d5Var = new d5(this.f16387a.getAdm(), this.f16387a.getProviderName$mediationsdk_release());
            BannerAdRequest bannerAdRequest = this.f16387a;
            AdSize size = bannerAdRequest.getSize();
            kotlin.jvm.internal.t.f(ukVarA);
            ve veVar = ve.f15889a;
            return new w6(bannerAdRequest, size, d5Var, ukVarA, omVar, j3VarA, new y6(veVar, this.f16388b), new x5(j3VarA, veVar.c()), null, null, 768, null);
        } catch (Exception e10) {
            i9.d().a(e10);
            if (e10 instanceof fq) {
                ironSourceErrorA = ((fq) e10).a();
            } else {
                hb hbVar = hb.f12462a;
                String message = e10.getMessage();
                if (message == null) {
                    message = "Unknown error";
                }
                ironSourceErrorA = hbVar.a(message);
            }
            return new gb(ironSourceErrorA, new y6(ve.f15889a, this.f16388b), j3VarA);
        }
    }

    public /* synthetic */ z6(BannerAdRequest bannerAdRequest, BannerAdLoaderListener bannerAdLoaderListener, x2 x2Var, i3 i3Var, int i10, kotlin.jvm.internal.k kVar) {
        this(bannerAdRequest, bannerAdLoaderListener, x2Var, (i10 & 8) != 0 ? new h3(IronSource.AD_UNIT.BANNER) : i3Var);
    }
}
