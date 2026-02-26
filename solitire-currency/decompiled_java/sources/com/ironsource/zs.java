package com.ironsource;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseWrapper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class zs {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final zs f16492a = new zs();

    private zs() {
    }

    public final int a() {
        return el.f11917p.d().f().j();
    }

    @Nullable
    public final String b(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return v3.b(context, c(context));
    }

    @Nullable
    public final String c(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return v3.g(context);
    }

    @NotNull
    public final ConcurrentHashMap<String, List<String>> d() {
        ConcurrentHashMap<String, List<String>> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.putAll(com.ironsource.mediationsdk.c.b().c());
        concurrentHashMap.putAll(lj.b().c());
        return concurrentHashMap;
    }

    public final boolean e() {
        return IronSource.isInterstitialReady();
    }

    public final boolean f() {
        return IronSource.isRewardedVideoAvailable();
    }

    public final void g() {
        IronSource.loadInterstitial();
    }

    public final void h() {
        IronSource.loadRewardedVideo();
    }

    public final void i() {
        com.ironsource.mediationsdk.p.m().R();
    }

    @NotNull
    public final ISBannerSize a(@Nullable String str, int i10, int i11) {
        return new ISBannerSize(str, i10, i11);
    }

    @NotNull
    public final JSONObject b() {
        JSONObject jSONObjectB = xc.a().b();
        kotlin.jvm.internal.t.h(jSONObjectB, "getProperties().toJSON()");
        return jSONObjectB;
    }

    @NotNull
    public final JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            ConcurrentHashMap<String, AdapterBaseWrapper> networkAdaptersMap = com.ironsource.mediationsdk.c.b().d();
            kotlin.jvm.internal.t.h(networkAdaptersMap, "networkAdaptersMap");
            for (Map.Entry<String, AdapterBaseWrapper> entry : networkAdaptersMap.entrySet()) {
                if (entry.getValue().getAdapterBaseInterface() != null) {
                    zs zsVar = f16492a;
                    String key = entry.getKey();
                    kotlin.jvm.internal.t.h(key, "entry.key");
                    String strA = zsVar.a(key);
                    AdapterBaseInterface adapterBaseInterface = entry.getValue().getAdapterBaseInterface();
                    kotlin.jvm.internal.t.h(adapterBaseInterface, "entry.value.adapterBaseInterface");
                    String adapterVersion = adapterBaseInterface.getAdapterVersion();
                    kotlin.jvm.internal.t.h(adapterVersion, "adapterBaseInterface.adapterVersion");
                    jSONObject.putOpt(strA, zsVar.a(adapterVersion, adapterBaseInterface.getNetworkSDKVersion()));
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
        }
        return jSONObject;
    }

    @NotNull
    public final IronSourceBannerLayout a(@NotNull Activity activity, @NotNull ISBannerSize size) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(size, "size");
        IronSourceBannerLayout ironSourceBannerLayoutB = com.ironsource.mediationsdk.p.m().b(activity, size);
        kotlin.jvm.internal.t.h(ironSourceBannerLayoutB, "getInstance().createBanner(activity, size)");
        return ironSourceBannerLayoutB;
    }

    public final void b(@Nullable Activity activity) {
        if (activity != null) {
            IronSource.showRewardedVideo(activity);
        } else {
            IronSource.showRewardedVideo();
        }
    }

    @Nullable
    public final String a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return v3.a(context, c(context));
    }

    public final void b(@Nullable IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.loadBanner(ironSourceBannerLayout);
    }

    @NotNull
    public final String a(@NotNull NetworkSettings networkSettings) {
        kotlin.jvm.internal.t.i(networkSettings, "networkSettings");
        String providerDefaultInstance = networkSettings.getProviderDefaultInstance();
        return providerDefaultInstance == null ? new String() : providerDefaultInstance;
    }

    public final void b(@NotNull String message) {
        kotlin.jvm.internal.t.i(message, "message");
        IronLog.INTERNAL.error(message);
    }

    @NotNull
    public final String a(@Nullable Placement placement) {
        String placementName;
        return (placement == null || (placementName = placement.getPlacementName()) == null) ? new String() : placementName;
    }

    @NotNull
    public final String a(@NotNull String key) {
        List listC0;
        kotlin.jvm.internal.t.i(key, "key");
        try {
            if (!p9.r.P(key, "-", false, 2, null)) {
                if (!p9.r.P(key, "_", false, 2, null)) {
                    return key;
                }
                listC0 = p9.r.C0(key, new String[]{"_"}, false, 0, 6, null);
            } else {
                String str = (String) kotlin.collections.d0.t0(p9.r.C0(key, new String[]{"-"}, false, 0, 6, null));
                if (!p9.r.P(str, "_", false, 2, null)) {
                    return str;
                }
                listC0 = p9.r.C0(str, new String[]{"_"}, false, 0, 6, null);
            }
            return (String) kotlin.collections.d0.i0(listC0);
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.getMessage());
            return key;
        }
    }

    private final JSONObject a(String str, String str2) {
        return new JSONObject(kotlin.collections.r0.j(v8.y.a(qs.f14584c, str), v8.y.a("sdkVersion", str2)));
    }

    @NotNull
    public final JSONObject a(boolean z10) {
        JSONObject mediationAdditionalData = IronSourceUtils.getMediationAdditionalData(z10);
        kotlin.jvm.internal.t.h(mediationAdditionalData, "getMediationAdditionalData(isDemandOnlyMode)");
        return mediationAdditionalData;
    }

    public final void a(int i10, @NotNull JSONObject data) {
        kotlin.jvm.internal.t.i(data, "data");
        rp.i().a(new kb(i10, data));
    }

    public final void a(@Nullable Activity activity) {
        if (activity != null) {
            IronSource.showInterstitial(activity);
        } else {
            IronSource.showInterstitial();
        }
    }

    public final void a(@NotNull IronSource.AD_UNIT adUnit, @NotNull ts loadAdConfig) {
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        kotlin.jvm.internal.t.i(loadAdConfig, "loadAdConfig");
        com.ironsource.mediationsdk.p.m().a(adUnit, loadAdConfig);
    }

    public final void a(@Nullable IronSourceBannerLayout ironSourceBannerLayout) {
        IronSource.destroyBanner(ironSourceBannerLayout);
    }

    public final void a(@Nullable LevelPlayBannerListener levelPlayBannerListener) {
        m5.a().b(levelPlayBannerListener);
    }

    public final void a(@Nullable LevelPlayInterstitialListener levelPlayInterstitialListener) {
        gf.a().b(levelPlayInterstitialListener);
    }

    public final void a(@Nullable LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        to.a().b(levelPlayRewardedVideoBaseListener);
    }

    public final boolean a(@NotNull NetworkSettings networkSettings, @NotNull IronSource.AD_UNIT adUnit) {
        kotlin.jvm.internal.t.i(networkSettings, "networkSettings");
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        return networkSettings.isBidder(adUnit);
    }
}
