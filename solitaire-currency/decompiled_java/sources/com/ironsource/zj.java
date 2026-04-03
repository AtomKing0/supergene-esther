package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.sdk.mediation.R;
import com.ironsource.x1;
import com.unity3d.mediation.LevelPlay;
import com.unity3d.mediation.LevelPlayAdError;
import com.unity3d.mediation.LevelPlayAdInfo;
import com.unity3d.mediation.LevelPlayAdSize;
import com.unity3d.mediation.banner.LevelPlayBannerAdViewListener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class zj extends xj implements p5 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final p6 f16421d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final pg f16422e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private LevelPlayAdSize f16423f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private LevelPlayBannerAdViewListener f16424g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private String f16425h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private o5 f16426i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Placement f16427j;

    public static final class a extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f16428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f16429b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ zj f16430c;

        a(String str, String str2, zj zjVar) {
            this.f16428a = str;
            this.f16429b = str2;
            this.f16430c = zjVar;
        }

        @Override // com.ironsource.yp
        public void a() {
            String str = this.f16428a;
            if (str != null) {
                this.f16430c.a(str);
            }
            String str2 = this.f16429b;
            if (str2 != null) {
                this.f16430c.f16423f = LevelPlayAdSize.Companion.createAdSize$mediationsdk_release(str2);
            }
        }

        @Override // com.ironsource.yp
        public void a(@NotNull Throwable t10) throws Throwable {
            kotlin.jvm.internal.t.i(t10, "t");
            if (t10 instanceof IllegalArgumentException) {
                throw t10;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zj(@NotNull p6 bannerContainer, @Nullable AttributeSet attributeSet) {
        super(new k1(IronSource.AD_UNIT.BANNER, x1.b.MEDIATION));
        kotlin.jvm.internal.t.i(bannerContainer, "bannerContainer");
        this.f16421d = bannerContainer;
        this.f16422e = el.f11917p.d().n();
        this.f16423f = LevelPlayAdSize.BANNER;
        this.f16425h = "";
        if (attributeSet != null) {
            Context context = bannerContainer.getContext();
            kotlin.jvm.internal.t.h(context, "bannerContainer.context");
            a(context, attributeSet);
        }
    }

    private final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LevelPlayBannerAdView);
        kotlin.jvm.internal.t.h(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…le.LevelPlayBannerAdView)");
        a().d(new a(typedArrayObtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adUnitId), typedArrayObtainStyledAttributes.getString(R.styleable.LevelPlayBannerAdView_adSize), this));
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(zj this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f16421d.removeAllViews();
        ViewParent parent = this$0.f16421d.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this$0.f16421d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(zj this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (this$0.c()) {
            IronLog.INTERNAL.warning(k1.a(this$0.a(), "Banner load already called", (String) null, 2, (Object) null));
            return;
        }
        this$0.a(true);
        if (this$0.d()) {
            o5 o5VarE = this$0.e();
            o5VarE.d();
            this$0.f16426i = o5VarE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(zj this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        o5 o5Var = this$0.f16426i;
        if (o5Var != null) {
            o5Var.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(final zj this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        if (!this$0.c()) {
            IronLog.INTERNAL.warning(k1.a(this$0.a(), "Banner not loaded", (String) null, 2, (Object) null));
            return;
        }
        if (this$0.f16426i == null) {
            IronLog.INTERNAL.warning(k1.a(this$0.a(), "Banner already destroyed", (String) null, 2, (Object) null));
            return;
        }
        ok.a(this$0.a(), new Runnable() { // from class: com.ironsource.r10
            @Override // java.lang.Runnable
            public final void run() {
                zj.b(this.f14623a);
            }
        }, 0L, 2, (Object) null);
        o5 o5Var = this$0.f16426i;
        if (o5Var != null) {
            o5Var.c();
        }
        this$0.f16426i = null;
        this$0.f16424g = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(zj this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdDisplayed(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(zj this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLeftApplication(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(zj this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoaded(adInfo);
        }
    }

    private final o5 e() {
        Placement placement;
        this.f16427j = a().a(this.f16425h);
        Context context = this.f16421d.getContext();
        if (context instanceof Activity) {
            ContextProvider.getInstance().updateActivity((Activity) context);
        }
        String strB = b();
        Placement placement2 = this.f16427j;
        Placement placement3 = null;
        if (placement2 == null) {
            kotlin.jvm.internal.t.A("bannerPlacement");
            placement = null;
        } else {
            placement = placement2;
        }
        c6 c6Var = new c6(strB, placement, this.f16423f, null, null, this.f16422e.a(), 24, null);
        a(c6Var);
        ISBannerSize iSBannerSizeA = a().a(c6Var.g());
        lb lbVarE = a().e();
        k1 k1VarA = a();
        Placement placement4 = this.f16427j;
        if (placement4 == null) {
            kotlin.jvm.internal.t.A("bannerPlacement");
        } else {
            placement3 = placement4;
        }
        lbVarE.a(new s6(k1VarA, iSBannerSizeA, placement3.getPlacementName()));
        return new o5(this, a(), c6Var, this.f16421d);
    }

    public final void f() {
        a(new Runnable() { // from class: com.ironsource.v10
            @Override // java.lang.Runnable
            public final void run() {
                zj.a(this.f15639a);
            }
        });
    }

    @NotNull
    public final LevelPlayAdSize g() {
        return this.f16423f;
    }

    @Nullable
    public final LevelPlayBannerAdViewListener h() {
        return this.f16424g;
    }

    @NotNull
    public final String i() {
        return this.f16425h;
    }

    @NotNull
    public final pg j() {
        return this.f16422e;
    }

    public final void k() {
        a(new Runnable() { // from class: com.ironsource.w10
            @Override // java.lang.Runnable
            public final void run() {
                zj.c(this.f15987a);
            }
        });
    }

    public final void l() {
        a(new Runnable() { // from class: com.ironsource.s10
            @Override // java.lang.Runnable
            public final void run() {
                zj.d(this.f14775a);
            }
        });
    }

    public final void m() {
        a(new Runnable() { // from class: com.ironsource.o10
            @Override // java.lang.Runnable
            public final void run() {
                zj.e(this.f14199a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(zj this$0, LevelPlayAdError it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "$it");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdLoadFailed(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(zj this$0, LevelPlayAdSize adSize) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adSize, "$adSize");
        if (this$0.c()) {
            return;
        }
        this$0.f16423f = adSize;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(zj this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        o5 o5Var = this$0.f16426i;
        if (o5Var != null) {
            o5Var.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(zj this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdExpanded(adInfo);
        }
    }

    @Override // com.ironsource.p5
    public void c(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.q10
            @Override // java.lang.Runnable
            public final void run() {
                zj.b(this.f14428a, adInfo);
            }
        });
    }

    @Override // com.ironsource.xj
    public boolean d() {
        LevelPlayAdError levelPlayAdError;
        if (b().length() == 0) {
            levelPlayAdError = new LevelPlayAdError(b(), LevelPlayAdError.ERROR_CODE_NO_AD_UNIT_ID_SPECIFIED, "Ad unit ID should be specified");
        } else {
            if (a().h()) {
                ak akVarA = el.f11917p.d().r().a();
                if (akVarA != null && akVarA.a(b(), LevelPlay.AdFormat.BANNER)) {
                    return true;
                }
                LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this.f16424g;
                if (levelPlayBannerAdViewListener != null) {
                    levelPlayBannerAdViewListener.onAdLoadFailed(new LevelPlayAdError(b(), LevelPlayAdError.ERROR_CODE_INVALID_AD_UNIT_ID, "Invalid ad unit id"));
                }
                return false;
            }
            levelPlayAdError = new LevelPlayAdError(b(), LevelPlayAdError.ERROR_CODE_LOAD_BEFORE_INIT_SUCCESS_CALLBACK, "load must be called after init success callback");
        }
        a(levelPlayAdError);
        return false;
    }

    @Override // com.ironsource.p5
    public void g(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.t10
            @Override // java.lang.Runnable
            public final void run() {
                zj.a(this.f15361a, adInfo);
            }
        });
    }

    @Override // com.ironsource.p5
    public void k(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.p10
            @Override // java.lang.Runnable
            public final void run() {
                zj.c(this.f14293a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(zj this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdClicked(adInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(zj this$0, LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adInfo, "$adInfo");
        LevelPlayBannerAdViewListener levelPlayBannerAdViewListener = this$0.f16424g;
        if (levelPlayBannerAdViewListener != null) {
            levelPlayBannerAdViewListener.onAdCollapsed(adInfo);
        }
    }

    public final void b(@NotNull final String placementName) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        a(new Runnable() { // from class: com.ironsource.u10
            @Override // java.lang.Runnable
            public final void run() {
                zj.a(this.f15546a, placementName);
            }
        });
    }

    @Override // com.ironsource.p5
    public void e(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.z10
            @Override // java.lang.Runnable
            public final void run() {
                zj.e(this.f16363a, adInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(zj this$0, LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.f16424g = levelPlayBannerAdViewListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(zj this$0, String placementName) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(placementName, "$placementName");
        if (this$0.c()) {
            return;
        }
        this$0.f16425h = placementName;
    }

    @Override // com.ironsource.p5
    public void a(@Nullable final LevelPlayAdError levelPlayAdError) {
        if (levelPlayAdError != null) {
            b(new Runnable() { // from class: com.ironsource.b20
                @Override // java.lang.Runnable
                public final void run() {
                    zj.a(this.f11337a, levelPlayAdError);
                }
            });
        }
    }

    @Override // com.ironsource.p5
    public void a(@NotNull final LevelPlayAdInfo adInfo) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.y10
            @Override // java.lang.Runnable
            public final void run() {
                zj.f(this.f16239a, adInfo);
            }
        });
    }

    @Override // com.ironsource.p5
    public void a(@NotNull final LevelPlayAdInfo adInfo, boolean z10) {
        kotlin.jvm.internal.t.i(adInfo, "adInfo");
        b(new Runnable() { // from class: com.ironsource.c20
            @Override // java.lang.Runnable
            public final void run() {
                zj.d(this.f11489a, adInfo);
            }
        });
    }

    public final void a(@NotNull final LevelPlayAdSize adSize) {
        kotlin.jvm.internal.t.i(adSize, "adSize");
        a(new Runnable() { // from class: com.ironsource.a20
            @Override // java.lang.Runnable
            public final void run() {
                zj.b(this.f11182a, adSize);
            }
        });
    }

    public final void a(@Nullable final LevelPlayBannerAdViewListener levelPlayBannerAdViewListener) {
        a(new Runnable() { // from class: com.ironsource.x10
            @Override // java.lang.Runnable
            public final void run() {
                zj.a(this.f16122a, levelPlayBannerAdViewListener);
            }
        });
    }
}
