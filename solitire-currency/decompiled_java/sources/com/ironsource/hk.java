package com.ironsource;

import com.ironsource.gk;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class hk extends xj implements ol {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final fk f12497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ll f12498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private String f12499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Placement f12500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private jk f12501h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdData f12502i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private AdapterNativeAdViewBinder f12503j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hk(@NotNull fk nativeAd) {
        super(new k1(IronSource.AD_UNIT.NATIVE_AD, x1.b.MEDIATION));
        kotlin.jvm.internal.t.i(nativeAd, "nativeAd");
        this.f12497d = nativeAd;
        this.f12499f = "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hk this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        IronLog.API.info(String.valueOf(this$0));
        try {
            ll llVar = this$0.f12498e;
            if (llVar == null) {
                kotlin.jvm.internal.t.A("nativeAdController");
                llVar = null;
            }
            llVar.b();
            this$0.f12501h = null;
        } catch (Throwable th) {
            i9.d().a(th);
            IronLog.API.error("destroyNativeAd()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(hk this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        ll llVar = null;
        if (this$0.c()) {
            IronLog.INTERNAL.warning(k1.a(this$0.a(), "Native ad load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            ll llVar2 = this$0.f12498e;
            if (llVar2 == null) {
                kotlin.jvm.internal.t.A("nativeAdController");
            } else {
                llVar = llVar2;
            }
            llVar.c();
        }
    }

    @Override // com.ironsource.xj
    public boolean d() {
        this.f12498e = e();
        return true;
    }

    @Nullable
    public final String l() {
        AdapterNativeAdData adapterNativeAdData = this.f12502i;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getTitle();
        }
        return null;
    }

    public final void m() {
        a(new Runnable() { // from class: com.ironsource.ow
            @Override // java.lang.Runnable
            public final void run() {
                hk.b(this.f14282a);
            }
        });
    }

    @Override // com.ironsource.ol
    public void onNativeAdLoadFailed(@Nullable IronSourceError ironSourceError) {
        final LevelPlayAdError levelPlayAdError = new LevelPlayAdError(ironSourceError, null, 2, null);
        b(new Runnable() { // from class: com.ironsource.kw
            @Override // java.lang.Runnable
            public final void run() {
                hk.a(this.f12930a, levelPlayAdError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hk this$0, jk jkVar) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f12501h = jkVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(hk this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        jk jkVar = this$0.f12501h;
        if (jkVar != null) {
            jkVar.c(this$0.f12497d, adInfo);
        }
    }

    private final ll e() {
        this.f12500g = a().f(this.f12499f);
        String strB = b();
        Placement placement = this.f12500g;
        if (placement == null) {
            kotlin.jvm.internal.t.A("placement");
            placement = null;
        }
        vl vlVar = new vl(strB, placement);
        a(vlVar);
        return new ll(this, a(), vlVar);
    }

    public final void f() {
        a(new Runnable() { // from class: com.ironsource.lw
            @Override // java.lang.Runnable
            public final void run() {
                hk.a(this.f13091a);
            }
        });
    }

    @Nullable
    public final String g() {
        AdapterNativeAdData adapterNativeAdData = this.f12502i;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getAdvertiser();
        }
        return null;
    }

    @Nullable
    public final String h() {
        AdapterNativeAdData adapterNativeAdData = this.f12502i;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getBody();
        }
        return null;
    }

    @Nullable
    public final String i() {
        AdapterNativeAdData adapterNativeAdData = this.f12502i;
        if (adapterNativeAdData != null) {
            return adapterNativeAdData.getCallToAction();
        }
        return null;
    }

    @Nullable
    public final gk.a j() {
        NativeAdDataInterface.Image icon;
        AdapterNativeAdData adapterNativeAdData = this.f12502i;
        if (adapterNativeAdData == null || (icon = adapterNativeAdData.getIcon()) == null) {
            return null;
        }
        return new gk.a(icon.getDrawable(), icon.getUri());
    }

    @Nullable
    public final AdapterNativeAdViewBinder k() {
        return this.f12503j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hk this$0, LevelPlayAdError levelPlayError) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(levelPlayError, "$levelPlayError");
        jk jkVar = this$0.f12501h;
        if (jkVar != null) {
            jkVar.a(this$0.f12497d, levelPlayError);
        }
    }

    @Override // com.ironsource.ol
    public void b(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.info(String.valueOf(this));
        il ilVar = new il();
        ll llVar = this.f12498e;
        if (llVar == null) {
            kotlin.jvm.internal.t.A("nativeAdController");
            llVar = null;
        }
        llVar.a(ilVar);
        this.f12502i = ilVar.a();
        this.f12503j = ilVar.b();
        b(new Runnable() { // from class: com.ironsource.mw
            @Override // java.lang.Runnable
            public final void run() {
                hk.b(this.f14043a, adInfo);
            }
        });
    }

    @Override // com.ironsource.ol
    public void j(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.pw
            @Override // java.lang.Runnable
            public final void run() {
                hk.a(this.f14397a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hk this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        jk jkVar = this$0.f12501h;
        if (jkVar != null) {
            jkVar.b(this$0.f12497d, adInfo);
        }
    }

    public final void b(@NotNull final String placementName) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        a(new Runnable() { // from class: com.ironsource.qw
            @Override // java.lang.Runnable
            public final void run() {
                hk.a(this.f14602a, placementName);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(hk this$0, String placementName) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(placementName, "$placementName");
        this$0.f12499f = placementName;
    }

    public final void a(@Nullable final jk jkVar) {
        a(new Runnable() { // from class: com.ironsource.nw
            @Override // java.lang.Runnable
            public final void run() {
                hk.a(this.f14183a, jkVar);
            }
        });
    }
}
