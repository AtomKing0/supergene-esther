package com.vungle.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.a;
import com.vungle.ads.internal.n;
import com.vungle.ads.internal.omsdk.d;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.internal.ui.view.b;
import com.vungle.ads.internal.util.p;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: VungleBannerView.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a2 extends RelativeLayout {

    @NotNull
    public static final b Companion = new b(null);

    @NotNull
    private static final String TAG = "VungleBannerView";

    @Nullable
    private r adListener;

    @NotNull
    private final z1 adSize;

    @NotNull
    private final com.vungle.ads.internal.h adViewImpl;

    @Nullable
    private com.vungle.ads.internal.ui.view.b adWidget;
    private int calculatedPixelHeight;
    private int calculatedPixelWidth;

    @NotNull
    private final AtomicBoolean destroyed;

    @Nullable
    private com.vungle.ads.internal.ui.g imageView;

    @NotNull
    private final v8.l impressionTracker$delegate;

    @NotNull
    private final AtomicBoolean isAdAttachedToWindow;

    @NotNull
    private final AtomicBoolean isAdDownloaded;

    @NotNull
    private final AtomicBoolean isInvisibleLogged;
    private boolean isOnImpressionCalled;
    private boolean isReceiverRegistered;

    @NotNull
    private final String placementId;

    @Nullable
    private com.vungle.ads.internal.presenter.l presenter;

    @NotNull
    private final AtomicBoolean presenterStarted;

    @NotNull
    private final com.vungle.ads.internal.util.s ringerModeReceiver;

    /* JADX INFO: compiled from: VungleBannerView.kt */
    public static final class a implements r {
        a() {
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdClicked(@NotNull u baseAd) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdClicked(baseAd);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdEnd(@NotNull u baseAd) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdEnd(baseAd);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdFailedToLoad(@NotNull u baseAd, @NotNull b2 adError) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            kotlin.jvm.internal.t.i(adError, "adError");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToLoad(baseAd, adError);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdFailedToPlay(@NotNull u baseAd, @NotNull b2 adError) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            kotlin.jvm.internal.t.i(adError, "adError");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToPlay(baseAd, adError);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdImpression(@NotNull u baseAd) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdImpression(baseAd);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdLeftApplication(@NotNull u baseAd) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdLeftApplication(baseAd);
            }
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdLoaded(@NotNull u baseAd) throws InstantiationException {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            a2.this.onBannerAdLoaded(baseAd);
        }

        @Override // com.vungle.ads.r, com.vungle.ads.v
        public void onAdStart(@NotNull u baseAd) {
            kotlin.jvm.internal.t.i(baseAd, "baseAd");
            r adListener = a2.this.getAdListener();
            if (adListener != null) {
                adListener.onAdStart(baseAd);
            }
        }
    }

    /* JADX INFO: compiled from: VungleBannerView.kt */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: VungleBannerView.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.n> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.n invoke() {
            return new com.vungle.ads.internal.n(this.$context);
        }
    }

    /* JADX INFO: compiled from: VungleBannerView.kt */
    public static final class d implements n.b {
        d() {
        }

        @Override // com.vungle.ads.internal.n.b
        public void onImpression(@Nullable View view) {
            com.vungle.ads.internal.util.p.Companion.d(a2.TAG, "ImpressionTracker checked the banner view become visible.");
            a2.this.isOnImpressionCalled = true;
            a2.this.checkHardwareAcceleration();
            com.vungle.ads.internal.presenter.l lVar = a2.this.presenter;
            if (lVar != null) {
                lVar.start();
            }
        }

        @Override // com.vungle.ads.internal.n.b
        public void onViewInvisible(@Nullable View view) {
            a2.this.logViewInvisibleOnPlay();
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class e extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.executor.a, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.executor.a invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.executor.a.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class f extends kotlin.jvm.internal.v implements h9.a<d.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.omsdk.d$b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final d.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(d.b.class);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class g extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.platform.d> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.platform.d, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.platform.d invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.platform.d.class);
        }
    }

    /* JADX INFO: compiled from: VungleBannerView.kt */
    public static final class h implements b.a {
        h() {
        }

        @Override // com.vungle.ads.internal.ui.view.b.a
        public void close() {
            a2.this.finishAdInternal(false);
        }
    }

    /* JADX INFO: compiled from: VungleBannerView.kt */
    public static final class i implements b.d {
        i() {
        }

        @Override // com.vungle.ads.internal.ui.view.b.d
        public boolean onTouch(@Nullable MotionEvent motionEvent) {
            com.vungle.ads.internal.presenter.l lVar = a2.this.presenter;
            if (lVar == null) {
                return false;
            }
            lVar.onViewTouched(motionEvent);
            return false;
        }
    }

    /* JADX INFO: compiled from: VungleBannerView.kt */
    public static final class j extends com.vungle.ads.internal.presenter.a {
        j(com.vungle.ads.internal.presenter.c cVar, com.vungle.ads.internal.model.j jVar) {
            super(cVar, jVar);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a2(@NotNull Context context, @NotNull String placementId, @NotNull z1 adSize) {
        super(context);
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
        kotlin.jvm.internal.t.i(adSize, "adSize");
        this.placementId = placementId;
        this.adSize = adSize;
        this.ringerModeReceiver = new com.vungle.ads.internal.util.s();
        com.vungle.ads.internal.h hVar = new com.vungle.ads.internal.h(context, placementId, adSize, new com.vungle.ads.c());
        this.adViewImpl = hVar;
        this.destroyed = new AtomicBoolean(false);
        this.presenterStarted = new AtomicBoolean(false);
        this.isAdDownloaded = new AtomicBoolean(false);
        this.isAdAttachedToWindow = new AtomicBoolean(false);
        this.isInvisibleLogged = new AtomicBoolean(false);
        this.impressionTracker$delegate = v8.n.a(new c(context));
        hVar.setAdListener(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void checkHardwareAcceleration() {
        com.vungle.ads.internal.util.p.Companion.w(TAG, "hardwareAccelerated = " + isHardwareAccelerated());
        if (isHardwareAccelerated()) {
            return;
        }
        o.INSTANCE.logMetric$vungle_ads_release(Sdk$SDKMetric.b.HARDWARE_ACCELERATE_DISABLED, (34 & 2) != 0 ? 0L : 0L, (34 & 4) != 0 ? null : this.placementId, (34 & 8) != 0 ? null : getCreativeId(), (34 & 16) != 0 ? null : getEventId(), (34 & 32) == 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishAdInternal(boolean z10) {
        if (this.destroyed.get()) {
            return;
        }
        this.destroyed.set(true);
        int i10 = (z10 ? 4 : 0) | 2;
        com.vungle.ads.internal.presenter.l lVar = this.presenter;
        if (lVar != null) {
            lVar.stop();
        }
        com.vungle.ads.internal.presenter.l lVar2 = this.presenter;
        if (lVar2 != null) {
            lVar2.detach(i10);
        }
        getImpressionTracker().destroy();
        try {
            ViewParent parent = getParent();
            if (parent != null && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(this);
            }
            removeAllViews();
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.d(TAG, "Removing webView error: " + e10);
        }
    }

    private final com.vungle.ads.internal.n getImpressionTracker() {
        return (com.vungle.ads.internal.n) this.impressionTracker$delegate.getValue();
    }

    public static /* synthetic */ void load$default(a2 a2Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = null;
        }
        a2Var.load(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void logViewInvisibleOnPlay() {
        if (this.isInvisibleLogged.getAndSet(true)) {
            return;
        }
        com.vungle.ads.internal.util.p.Companion.d(TAG, "ImpressionTracker checked the banner view invisible on play. " + hashCode());
        o.INSTANCE.logMetric$vungle_ads_release(new v1(Sdk$SDKMetric.b.VIEW_NOT_VISIBLE_ON_PLAY), (30 & 2) != 0 ? null : this.placementId, (30 & 4) != 0 ? null : getCreativeId(), (30 & 8) != 0 ? null : getEventId(), (30 & 16) != 0 ? null : null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onBannerAdLoaded(u uVar) throws InstantiationException {
        o oVar = o.INSTANCE;
        oVar.logMetric$vungle_ads_release(new v1(Sdk$SDKMetric.b.PLAY_AD_API), (30 & 2) != 0 ? null : this.placementId, (30 & 4) != 0 ? null : getCreativeId(), (30 & 8) != 0 ? null : getEventId(), (30 & 16) != 0 ? null : null);
        b2 b2VarCanPlayAd = this.adViewImpl.getAdInternal$vungle_ads_release().canPlayAd(true);
        if (b2VarCanPlayAd != null) {
            if (this.adViewImpl.getAdInternal$vungle_ads_release().isErrorTerminal$vungle_ads_release(b2VarCanPlayAd.getCode())) {
                this.adViewImpl.getAdInternal$vungle_ads_release().setAdState(a.EnumC0499a.ERROR);
            }
            r rVar = this.adListener;
            if (rVar != null) {
                rVar.onAdFailedToPlay(uVar, b2VarCanPlayAd);
                return;
            }
            return;
        }
        com.vungle.ads.internal.model.b advertisement = this.adViewImpl.getAdInternal$vungle_ads_release().getAdvertisement();
        com.vungle.ads.internal.model.j placement = this.adViewImpl.getAdInternal$vungle_ads_release().getPlacement();
        if (advertisement == null || placement == null) {
            r rVar2 = this.adListener;
            if (rVar2 != null) {
                rVar2.onAdFailedToPlay(uVar, new m0(b2.AD_UNABLE_TO_PLAY, null, 2, null));
                return;
            }
            return;
        }
        this.adViewImpl.getAdInternal$vungle_ads_release().cancelDownload$vungle_ads_release();
        willPresentAdView(advertisement, placement, getAdViewSize());
        this.adViewImpl.getResponseToShowMetric$vungle_ads_release().markEnd();
        o.logMetric$vungle_ads_release$default(oVar, this.adViewImpl.getResponseToShowMetric$vungle_ads_release(), this.placementId, getCreativeId(), getEventId(), (String) null, 16, (Object) null);
        this.adViewImpl.getShowToPresentMetric$vungle_ads_release().markStart();
        this.adViewImpl.getShowToFailMetric$vungle_ads_release().markStart();
        this.isAdDownloaded.set(true);
        r rVar3 = this.adListener;
        if (rVar3 != null) {
            rVar3.onAdLoaded(uVar);
        }
        renderAd();
    }

    private final void renderAd() {
        if (this.destroyed.get()) {
            com.vungle.ads.internal.util.p.Companion.w(TAG, "renderAd() - destroyed");
            return;
        }
        if (!this.isAdDownloaded.get()) {
            com.vungle.ads.internal.util.p.Companion.d(TAG, "renderAd() - not ready: not downloaded.");
            return;
        }
        if (!this.isAdAttachedToWindow.get()) {
            com.vungle.ads.internal.util.p.Companion.d(TAG, "renderAd() - not ready: not attached.");
            logViewInvisibleOnPlay();
            return;
        }
        if (!this.presenterStarted.getAndSet(true)) {
            com.vungle.ads.internal.presenter.l lVar = this.presenter;
            if (lVar != null) {
                lVar.prepare();
            }
            getImpressionTracker().addView(this, new d());
        }
        com.vungle.ads.internal.ui.view.b bVar = this.adWidget;
        if (bVar != null) {
            if (!kotlin.jvm.internal.t.d(bVar != null ? bVar.getParent() : null, this)) {
                addView(this.adWidget, this.calculatedPixelWidth, this.calculatedPixelHeight);
                com.vungle.ads.internal.ui.g gVar = this.imageView;
                if (gVar != null) {
                    addView(gVar, this.calculatedPixelWidth, this.calculatedPixelHeight);
                    com.vungle.ads.internal.ui.g gVar2 = this.imageView;
                    if (gVar2 != null) {
                        gVar2.bringToFront();
                    }
                }
            }
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.calculatedPixelHeight;
            layoutParams.width = this.calculatedPixelWidth;
            requestLayout();
        }
    }

    private final void setAdVisibility(boolean z10) {
        com.vungle.ads.internal.presenter.l lVar;
        if (!this.isOnImpressionCalled || this.destroyed.get() || (lVar = this.presenter) == null) {
            return;
        }
        lVar.setAdVisibility(z10);
    }

    private final void willPresentAdView(com.vungle.ads.internal.model.b bVar, com.vungle.ads.internal.model.j jVar, z1 z1Var) throws InstantiationException {
        com.vungle.ads.internal.util.x xVar = com.vungle.ads.internal.util.x.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.t.h(context, "context");
        this.calculatedPixelHeight = xVar.dpToPixels(context, z1Var.getHeight());
        Context context2 = getContext();
        kotlin.jvm.internal.t.h(context2, "context");
        this.calculatedPixelWidth = xVar.dpToPixels(context2, z1Var.getWidth());
        j jVar2 = new j(this.adViewImpl.getAdPlayCallback$vungle_ads_release(), this.adViewImpl.getAdInternal$vungle_ads_release().getPlacement());
        try {
            Context context3 = getContext();
            kotlin.jvm.internal.t.h(context3, "context");
            com.vungle.ads.internal.ui.view.b bVar2 = new com.vungle.ads.internal.ui.view.b(context3);
            this.adWidget = bVar2;
            bVar2.setCloseDelegate(new h());
            bVar2.setOnViewTouchListener(new i());
            ServiceLocator.Companion companion = ServiceLocator.Companion;
            Context context4 = getContext();
            kotlin.jvm.internal.t.h(context4, "context");
            v8.p pVar = v8.p.f35201a;
            v8.l lVarB = v8.n.b(pVar, new e(context4));
            Context context5 = getContext();
            kotlin.jvm.internal.t.h(context5, "context");
            com.vungle.ads.internal.omsdk.d dVarMake = m4019willPresentAdView$lambda3(v8.n.b(pVar, new f(context5))).make(com.vungle.ads.internal.k.INSTANCE.omEnabled() && bVar.omEnabled());
            Context context6 = getContext();
            kotlin.jvm.internal.t.h(context6, "context");
            v8.l lVarB2 = v8.n.b(pVar, new g(context6));
            com.vungle.ads.internal.ui.f fVar = new com.vungle.ads.internal.ui.f(bVar, jVar, m4018willPresentAdView$lambda2(lVarB).getOffloadExecutor(), null, m4020willPresentAdView$lambda4(lVarB2), 8, null);
            this.ringerModeReceiver.setWebClient(fVar);
            fVar.setWebViewObserver(dVarMake);
            com.vungle.ads.internal.presenter.l lVar = new com.vungle.ads.internal.presenter.l(bVar2, bVar, jVar, fVar, m4018willPresentAdView$lambda2(lVarB).getJobExecutor(), dVarMake, this.adViewImpl.getAdInternal$vungle_ads_release().getBidPayload(), m4020willPresentAdView$lambda4(lVarB2));
            lVar.setEventListener(jVar2);
            this.presenter = lVar;
            String watermark$vungle_ads_release = getAdConfig().getWatermark$vungle_ads_release();
            if (watermark$vungle_ads_release != null) {
                Context context7 = getContext();
                kotlin.jvm.internal.t.h(context7, "context");
                this.imageView = new com.vungle.ads.internal.ui.g(context7, watermark$vungle_ads_release);
            }
        } catch (InstantiationException e10) {
            com.vungle.ads.b bVar3 = new com.vungle.ads.b();
            bVar3.setPlacementId$vungle_ads_release(bVar3.getPlacementId());
            bVar3.setEventId$vungle_ads_release(bVar3.getEventId());
            bVar3.setCreativeId$vungle_ads_release(bVar3.getCreativeId());
            jVar2.onError(bVar3.logError$vungle_ads_release(), this.placementId);
            throw e10;
        }
    }

    /* JADX INFO: renamed from: willPresentAdView$lambda-2, reason: not valid java name */
    private static final com.vungle.ads.internal.executor.a m4018willPresentAdView$lambda2(v8.l<? extends com.vungle.ads.internal.executor.a> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: willPresentAdView$lambda-3, reason: not valid java name */
    private static final d.b m4019willPresentAdView$lambda3(v8.l<d.b> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: renamed from: willPresentAdView$lambda-4, reason: not valid java name */
    private static final com.vungle.ads.internal.platform.d m4020willPresentAdView$lambda4(v8.l<? extends com.vungle.ads.internal.platform.d> lVar) {
        return lVar.getValue();
    }

    public final void finishAd() {
        finishAdInternal(true);
    }

    @NotNull
    public final com.vungle.ads.c getAdConfig() {
        return this.adViewImpl.getAdConfig();
    }

    @Nullable
    public final r getAdListener() {
        return this.adListener;
    }

    @NotNull
    public final z1 getAdSize() {
        return this.adSize;
    }

    @NotNull
    public final z1 getAdViewSize() {
        return this.adViewImpl.getAdViewSize();
    }

    @Nullable
    public final String getCreativeId() {
        return this.adViewImpl.getCreativeId();
    }

    @Nullable
    public final String getEventId() {
        return this.adViewImpl.getEventId();
    }

    @NotNull
    public final String getPlacementId() {
        return this.placementId;
    }

    public final void load(@Nullable String str) {
        this.adViewImpl.load(str);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        p.a aVar = com.vungle.ads.internal.util.p.Companion;
        aVar.d(TAG, "onAttachedToWindow(): " + hashCode());
        this.isAdAttachedToWindow.set(true);
        if (this.adViewImpl.getAdInternal$vungle_ads_release().getPlacement() != null) {
            try {
                if (!this.isReceiverRegistered) {
                    getContext().registerReceiver(this.ringerModeReceiver, new IntentFilter("android.media.RINGER_MODE_CHANGED"));
                    this.isReceiverRegistered = true;
                    aVar.d(TAG, "registerReceiver(): " + this.ringerModeReceiver.hashCode());
                }
            } catch (Exception e10) {
                com.vungle.ads.internal.util.p.Companion.e(TAG, "registerReceiver error: " + e10.getLocalizedMessage());
            }
        }
        renderAd();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.vungle.ads.internal.util.p.Companion.d(TAG, "onDetachedFromWindow(): " + hashCode());
        this.isAdAttachedToWindow.set(false);
        if (this.adViewImpl.getAdInternal$vungle_ads_release().getPlacement() != null) {
            try {
                if (this.isReceiverRegistered) {
                    getContext().unregisterReceiver(this.ringerModeReceiver);
                    this.isReceiverRegistered = false;
                }
            } catch (Exception e10) {
                com.vungle.ads.internal.util.p.Companion.e(TAG, "unregisterReceiver error: " + e10.getLocalizedMessage());
            }
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i10) {
        super.onWindowVisibilityChanged(i10);
        setAdVisibility(i10 == 0);
    }

    public final void setAdListener(@Nullable r rVar) {
        this.adListener = rVar;
    }
}
