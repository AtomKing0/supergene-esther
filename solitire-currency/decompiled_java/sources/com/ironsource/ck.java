package com.ironsource;

import android.app.Activity;
import com.ironsource.f1;
import com.ironsource.k1;
import com.ironsource.k9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.interstitial.LevelPlayInterstitialAdListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ck implements lh {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f11577j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k1 f11578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final kh f11579b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final me f11580c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final wd f11581d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final k9 f11582e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private String f11583f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private jh f11584g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private LevelPlayInterstitialAdListener f11585h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private ci f11586i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean a(@NotNull String placementName) {
            boolean zD;
            j0 j0VarA;
            String strE;
            kotlin.jvm.internal.t.i(placementName, "placementName");
            k1 k1VarA = k1.a.a(IronSource.AD_UNIT.INTERSTITIAL, x1.b.MEDIATION);
            if (k1VarA.h()) {
                f8 f8VarA = el.f11917p.d().w().a(placementName, LevelPlay.AdFormat.INTERSTITIAL);
                zD = f8VarA.d();
                j0VarA = k1VarA.e().a();
                strE = f8VarA.e();
            } else {
                j0VarA = k1VarA.e().a();
                strE = "SDK is not initialized";
                zD = false;
            }
            j0VarA.a(placementName, strE, zD);
            return zD;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f11587a = new b();

        private b() {
        }

        @NotNull
        public static final ck a() {
            return new ck(new k1(IronSource.AD_UNIT.INTERSTITIAL, x1.b.MEDIATION), new kh(), null, null, null, 28, null);
        }
    }

    public ck(@NotNull k1 adTools, @NotNull kh interstitialAdControllerFactory, @NotNull me mediationServicesProvider, @NotNull wd adUnitCappingProvider, @NotNull k9 currentTimeProvider) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(interstitialAdControllerFactory, "interstitialAdControllerFactory");
        kotlin.jvm.internal.t.i(mediationServicesProvider, "mediationServicesProvider");
        kotlin.jvm.internal.t.i(adUnitCappingProvider, "adUnitCappingProvider");
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        this.f11578a = adTools;
        this.f11579b = interstitialAdControllerFactory;
        this.f11580c = mediationServicesProvider;
        this.f11581d = adUnitCappingProvider;
        this.f11582e = currentTimeProvider;
        this.f11583f = "";
        this.f11586i = new mh(this);
    }

    @Nullable
    public final jh a() {
        return this.f11584g;
    }

    @NotNull
    public final k1 b() {
        return this.f11578a;
    }

    @NotNull
    public final wd c() {
        return this.f11581d;
    }

    @NotNull
    public final String d() {
        return this.f11583f;
    }

    @NotNull
    public final kh e() {
        return this.f11579b;
    }

    @Nullable
    public final LevelPlayInterstitialAdListener f() {
        return this.f11585h;
    }

    @NotNull
    public final me g() {
        return this.f11580c;
    }

    @Override // com.ironsource.lh
    public void onAdInfoChanged(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdInfoChanged adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f11578a.d(new Runnable() { // from class: com.ironsource.wv
            @Override // java.lang.Runnable
            public final void run() {
                ck.b(this.f16067a, adInfo);
            }
        });
        this.f11578a.e(new Runnable() { // from class: com.ironsource.xv
            @Override // java.lang.Runnable
            public final void run() {
                ck.c(this.f16207a, adInfo);
            }
        });
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ck(k1 k1Var, kh khVar, me meVar, wd wdVar, k9 k9Var, int i10, kotlin.jvm.internal.k kVar) {
        me meVarD = (i10 & 4) != 0 ? el.f11917p.d() : meVar;
        this(k1Var, khVar, meVarD, (i10 & 8) != 0 ? meVarD.s() : wdVar, (i10 & 16) != 0 ? new k9.a() : k9Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ck this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f11578a.e().g().a();
        this$0.f11586i.loadAd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ck this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.a(new mh(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ck this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.a(new mh(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ck this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f11578a.e().g().d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ck this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.a(new mh(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        this$0.a(new vh(this$0, adInfo, this$0.f11582e));
    }

    public final void a(@NotNull final Activity activity, @Nullable final String str) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f11578a.d(new Runnable() { // from class: com.ironsource.gv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(this.f12351a, activity, str);
            }
        });
    }

    public final boolean h() {
        f1 f1VarA = this.f11586i.a();
        this.f11578a.e().e().a(Boolean.valueOf(f1VarA.a()), f1VarA instanceof f1.a ? ((f1.a) f1VarA).d() : null);
        return f1VarA.a();
    }

    public final void i() {
        this.f11578a.d(new Runnable() { // from class: com.ironsource.rv
            @Override // java.lang.Runnable
            public final void run() {
                ck.b(this.f14734a);
            }
        });
    }

    public final void j() {
        a(new wh(this));
        jh jhVar = this.f11584g;
        if (jhVar != null) {
            jhVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ck this$0, LevelPlayAdError error) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        this$0.f11578a.e().g().a(error);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener = this$0.f11585h;
        if (levelPlayInterstitialAdListener != null) {
            levelPlayInterstitialAdListener.onAdInfoChanged(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener = this$0.f11585h;
        if (levelPlayInterstitialAdListener != null) {
            levelPlayInterstitialAdListener.onAdClicked(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener = this$0.f11585h;
        if (levelPlayInterstitialAdListener != null) {
            levelPlayInterstitialAdListener.onAdClosed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener = this$0.f11585h;
        if (levelPlayInterstitialAdListener != null) {
            levelPlayInterstitialAdListener.onAdDisplayed(adInfo);
        }
    }

    public final void a(@NotNull ci state) {
        kotlin.jvm.internal.t.i(state, "state");
        this.f11586i = state;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f11578a.e().g().b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        this$0.f11586i.onAdInfoChanged(adInfo);
    }

    @Override // com.ironsource.lh
    public void c(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdDisplayed adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f11578a.d(new Runnable() { // from class: com.ironsource.uv
            @Override // java.lang.Runnable
            public final void run() {
                ck.e(this.f15623a);
            }
        });
        this.f11578a.e(new Runnable() { // from class: com.ironsource.vv
            @Override // java.lang.Runnable
            public final void run() {
                ck.f(this.f15978a, adInfo);
            }
        });
    }

    @Override // com.ironsource.lh
    public void d(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        this.f11578a.d(new Runnable() { // from class: com.ironsource.fv
            @Override // java.lang.Runnable
            public final void run() {
                ck.g(this.f12188a, adInfo);
            }
        });
        e(adInfo);
    }

    public final void e(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdLoaded adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f11578a.d(new Runnable() { // from class: com.ironsource.mv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(this.f14042a);
            }
        });
        this.f11578a.e(new Runnable() { // from class: com.ironsource.nv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(this.f14181a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck this$0, Activity activity, String str) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(activity, "$activity");
        this$0.f11578a.e().g().c();
        this$0.f11586i.a(activity, str);
    }

    public final void b(@Nullable final LevelPlayAdError levelPlayAdError) {
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdLoadFailed adInfo: " + levelPlayAdError, (String) null, 2, (Object) null));
        this.f11578a.d(new Runnable() { // from class: com.ironsource.sv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(this.f15337a, levelPlayAdError);
            }
        });
        this.f11578a.e(new Runnable() { // from class: com.ironsource.tv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(levelPlayAdError, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck this$0, LevelPlayAdError levelPlayAdError) {
        String errorMessage;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        ut utVarG = this$0.f11578a.e().g();
        int errorCode = levelPlayAdError != null ? levelPlayAdError.getErrorCode() : 0;
        if (levelPlayAdError == null || (errorMessage = levelPlayAdError.getErrorMessage()) == null) {
            errorMessage = "";
        }
        utVarG.b(errorCode, errorMessage);
    }

    public final void b(@NotNull final LevelPlayAdError error, @NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(error, "error");
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdDisplayFailed error: " + error + ", adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f11578a.d(new Runnable() { // from class: com.ironsource.iv
            @Override // java.lang.Runnable
            public final void run() {
                ck.b(this.f12669a, error);
            }
        });
        this.f11578a.e(new Runnable() { // from class: com.ironsource.jv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(this.f12784a, error, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck this$0, LevelPlayAdError error, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(error, "$error");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener = this$0.f11585h;
        if (levelPlayInterstitialAdListener != null) {
            levelPlayInterstitialAdListener.onAdDisplayFailed(error, adInfo);
        }
    }

    @Override // com.ironsource.lh
    public void b(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdClosed adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f11578a.d(new Runnable() { // from class: com.ironsource.kv
            @Override // java.lang.Runnable
            public final void run() {
                ck.c(this.f12929a);
            }
        });
        this.f11578a.e(new Runnable() { // from class: com.ironsource.lv
            @Override // java.lang.Runnable
            public final void run() {
                ck.e(this.f13089a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener = this$0.f11585h;
        if (levelPlayInterstitialAdListener != null) {
            levelPlayInterstitialAdListener.onAdLoaded(adInfo);
        }
    }

    public final void b(@Nullable LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        this.f11585h = levelPlayInterstitialAdListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ck this$0, LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f11585h = levelPlayInterstitialAdListener;
    }

    public final void a(@Nullable jh jhVar) {
        this.f11584g = jhVar;
    }

    @Override // com.ironsource.lh
    public void a(@Nullable LevelPlayAdError levelPlayAdError) {
        this.f11578a.d(new Runnable() { // from class: com.ironsource.qv
            @Override // java.lang.Runnable
            public final void run() {
                ck.f(this.f14601a);
            }
        });
        b(levelPlayAdError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(LevelPlayAdError levelPlayAdError, ck this$0) {
        LevelPlayInterstitialAdListener levelPlayInterstitialAdListener;
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (levelPlayAdError == null || (levelPlayInterstitialAdListener = this$0.f11585h) == null) {
            return;
        }
        levelPlayInterstitialAdListener.onAdLoadFailed(levelPlayAdError);
    }

    @Override // com.ironsource.lh
    public void a(@NotNull LevelPlayAdError error, @NotNull LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(error, "error");
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        this.f11578a.d(new Runnable() { // from class: com.ironsource.hv
            @Override // java.lang.Runnable
            public final void run() {
                ck.d(this.f12511a);
            }
        });
        b(error, adInfo);
    }

    @Override // com.ironsource.lh
    public void a(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        IronLog.CALLBACK.verbose(k1.a(this.f11578a, "onAdClicked adInfo: " + adInfo, (String) null, 2, (Object) null));
        this.f11578a.e(new Runnable() { // from class: com.ironsource.ov
            @Override // java.lang.Runnable
            public final void run() {
                ck.d(this.f14280a, adInfo);
            }
        });
    }

    public final void a(@Nullable final LevelPlayInterstitialAdListener levelPlayInterstitialAdListener) {
        this.f11578a.d(new Runnable() { // from class: com.ironsource.pv
            @Override // java.lang.Runnable
            public final void run() {
                ck.a(this.f14395a, levelPlayInterstitialAdListener);
            }
        });
    }

    public final void a(@NotNull String str) {
        kotlin.jvm.internal.t.i(str, "<set-?>");
        this.f11583f = str;
    }
}
