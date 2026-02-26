package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class v0 implements u0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final nm f15633a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f15634a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f15635b = 1000;

        private a() {
        }
    }

    public v0(@NotNull nm networkLoadApi) {
        kotlin.jvm.internal.t.i(networkLoadApi, "networkLoadApi");
        this.f15633a = networkLoadApi;
    }

    @Override // com.ironsource.u0
    @NotNull
    public String a() {
        return this.f15633a.a();
    }

    @Override // com.ironsource.u0
    public void a(@NotNull mi adInstance, @NotNull Map<String, String> loadParams) {
        kotlin.jvm.internal.t.i(adInstance, "adInstance");
        kotlin.jvm.internal.t.i(loadParams, "loadParams");
        try {
            this.f15633a.a(adInstance, new pm(null, false, 3, null));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.ADAPTER_API.verbose("load ad with identifier: " + adInstance.e() + " failed. error: " + e10.getMessage());
            StringBuilder sb = new StringBuilder();
            sb.append("1000: loadAd failed: ");
            sb.append(e10.getMessage());
            String string = sb.toString();
            an anVarB = adInstance.b();
            if (anVarB instanceof lc) {
                an anVarB2 = adInstance.b();
                kotlin.jvm.internal.t.g(anVarB2, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.FullScreenAdInstanceListenerWrapper");
                ((lc) anVarB2).onInterstitialLoadFailed(string);
            } else if (anVarB instanceof cn) {
                an anVarB3 = adInstance.b();
                kotlin.jvm.internal.t.g(anVarB3, "null cannot be cast to non-null type com.unity3d.ironsourceads.internal.OnBannerListenerWrapper");
                ((cn) anVarB3).onBannerLoadFail(string);
            }
        }
    }
}
