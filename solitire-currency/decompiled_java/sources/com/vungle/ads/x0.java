package com.vungle.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.a;
import com.vungle.ads.internal.n;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import com.vungle.ads.x0;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NativeAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class x0 extends u {
    public static final int BOTTOM_LEFT = 2;
    public static final int BOTTOM_RIGHT = 3;

    @NotNull
    public static final a Companion = new a(null);

    @NotNull
    private static final String TAG = "NativeAd";
    public static final int TOP_LEFT = 0;
    public static final int TOP_RIGHT = 1;

    @Nullable
    private com.vungle.ads.internal.ui.view.c adContentView;

    @Nullable
    private ImageView adIconView;
    private int adOptionsPosition;

    @Nullable
    private h1 adOptionsView;

    @NotNull
    private final b adPlayCallback;

    @Nullable
    private FrameLayout adRootView;
    private float aspectRatio;

    @Nullable
    private Collection<? extends View> clickableViews;

    @NotNull
    private final v8.l executors$delegate;

    @NotNull
    private final v8.l imageLoader$delegate;

    @NotNull
    private final v8.l impressionTracker$delegate;

    @NotNull
    private final AtomicBoolean isInvisibleLogged;

    @Nullable
    private Map<String, String> nativeAdAssetMap;

    @Nullable
    private com.vungle.ads.internal.presenter.o presenter;

    /* JADX INFO: compiled from: NativeAd.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.p<Integer, Integer, v8.k0> {
        c() {
            super(2);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.k0 mo4invoke(Integer num, Integer num2) {
            invoke(num.intValue(), num2.intValue());
            return v8.k0.f35197a;
        }

        public final void invoke(int i10, int i11) {
            x0.this.aspectRatio = i10 / i11;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    static final class d extends kotlin.jvm.internal.v implements h9.l<Bitmap, v8.k0> {
        final /* synthetic */ ImageView $imageView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(ImageView imageView) {
            super(1);
            this.$imageView = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
        public static final void m4142invoke$lambda0(ImageView imageView, Bitmap it) {
            kotlin.jvm.internal.t.i(it, "$it");
            imageView.setImageBitmap(it);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Bitmap bitmap) {
            invoke2(bitmap);
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull final Bitmap it) {
            kotlin.jvm.internal.t.i(it, "it");
            final ImageView imageView = this.$imageView;
            if (imageView != null) {
                com.vungle.ads.internal.util.v.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.e1
                    @Override // java.lang.Runnable
                    public final void run() {
                        x0.d.m4142invoke$lambda0(imageView, it);
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    static final class e extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.util.m> {
        e() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.util.m invoke() {
            com.vungle.ads.internal.util.m aVar = com.vungle.ads.internal.util.m.Companion.getInstance();
            aVar.init(x0.this.getExecutors().getIoExecutor());
            return aVar;
        }
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    static final class f extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.n> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(Context context) {
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

    /* JADX INFO: compiled from: NativeAd.kt */
    public static final class h implements n.b {
        h() {
        }

        @Override // com.vungle.ads.internal.n.b
        public void onImpression(@Nullable View view) {
            com.vungle.ads.internal.util.p.Companion.d(x0.TAG, "ImpressionTracker checked the native ad view become visible.");
            com.vungle.ads.internal.presenter.o oVar = x0.this.presenter;
            if (oVar != null) {
                com.vungle.ads.internal.presenter.o.processCommand$default(oVar, "videoViewed", null, 2, null);
            }
            com.vungle.ads.internal.presenter.o oVar2 = x0.this.presenter;
            if (oVar2 != null) {
                oVar2.processCommand("tpat", com.vungle.ads.internal.l.CHECKPOINT_0);
            }
            com.vungle.ads.internal.presenter.o oVar3 = x0.this.presenter;
            if (oVar3 != null) {
                oVar3.onImpression();
            }
        }

        @Override // com.vungle.ads.internal.n.b
        public void onViewInvisible(@Nullable View view) {
            if (x0.this.isInvisibleLogged.getAndSet(true)) {
                return;
            }
            com.vungle.ads.internal.util.p.Companion.d(x0.TAG, "ImpressionTracker checked the native ad view invisible on play.");
            o.INSTANCE.logMetric$vungle_ads_release(new v1(Sdk$SDKMetric.b.VIEW_NOT_VISIBLE_ON_PLAY), (30 & 2) != 0 ? null : x0.this.getPlacementId(), (30 & 4) != 0 ? null : x0.this.getCreativeId(), (30 & 8) != 0 ? null : x0.this.getEventId(), (30 & 16) != 0 ? null : null);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class i extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.executor.a> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(Context context) {
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

    private x0(Context context, String str, com.vungle.ads.c cVar) {
        super(context, str, cVar);
        this.imageLoader$delegate = v8.n.a(new e());
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.executors$delegate = v8.n.b(v8.p.f35201a, new i(context));
        this.impressionTracker$delegate = v8.n.a(new f(context));
        this.isInvisibleLogged = new AtomicBoolean(false);
        this.adOptionsPosition = 1;
        this.adOptionsView = new h1(context);
        this.adPlayCallback = new b(str);
    }

    private final void createMediaAspectRatio() {
        getImageLoader().getImageSize(getMainImagePath(), new c());
    }

    private final void displayImage(String str, ImageView imageView) {
        getImageLoader().displayImage(str, new d(imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.vungle.ads.internal.executor.a getExecutors() {
        return (com.vungle.ads.internal.executor.a) this.executors$delegate.getValue();
    }

    private final com.vungle.ads.internal.util.m getImageLoader() {
        return (com.vungle.ads.internal.util.m) this.imageLoader$delegate.getValue();
    }

    private final com.vungle.ads.internal.n getImpressionTracker() {
        return (com.vungle.ads.internal.n) this.impressionTracker$delegate.getValue();
    }

    private final String getMainImagePath() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_MAIN_IMAGE)) == null) ? "" : str;
    }

    /* JADX INFO: renamed from: registerViewForInteraction$lambda-1, reason: not valid java name */
    private static final com.vungle.ads.internal.platform.d m4133registerViewForInteraction$lambda1(v8.l<? extends com.vungle.ads.internal.platform.d> lVar) {
        return lVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: registerViewForInteraction$lambda-2, reason: not valid java name */
    public static final void m4134registerViewForInteraction$lambda2(x0 this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.vungle.ads.internal.presenter.o oVar = this$0.presenter;
        if (oVar != null) {
            oVar.processCommand("openPrivacy", this$0.getPrivacyUrl$vungle_ads_release());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: registerViewForInteraction$lambda-4$lambda-3, reason: not valid java name */
    public static final void m4135registerViewForInteraction$lambda4$lambda3(x0 this$0, View view) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        com.vungle.ads.internal.presenter.o oVar = this$0.presenter;
        if (oVar != null) {
            oVar.processCommand(com.vungle.ads.internal.presenter.o.DOWNLOAD, this$0.getCtaUrl$vungle_ads_release());
        }
    }

    @NotNull
    public final String getAdBodyText() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_APP_DESCRIPTION)) == null) ? "" : str;
    }

    @NotNull
    public final String getAdCallToActionText() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_CTA_BUTTON_TEXT)) == null) ? "" : str;
    }

    public final int getAdOptionsPosition() {
        return this.adOptionsPosition;
    }

    @NotNull
    public final String getAdSponsoredText() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_SPONSORED_BY)) == null) ? "" : str;
    }

    @Nullable
    public final Double getAdStarRating() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        if (map == null || (str = map.get(f1.TOKEN_APP_RATING_VALUE)) == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Double.valueOf(str);
        } catch (Exception unused) {
            return null;
        }
    }

    @NotNull
    public final String getAdTitle() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_APP_NAME)) == null) ? "" : str;
    }

    @NotNull
    public final String getAppIcon() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_APP_ICON)) == null) ? "" : str;
    }

    @NotNull
    public final String getCtaUrl$vungle_ads_release() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_CTA_BUTTON_URL)) == null) ? "" : str;
    }

    public final float getMediaAspectRatio() {
        return this.aspectRatio;
    }

    @NotNull
    public final String getPrivacyIconUrl$vungle_ads_release() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_VUNGLE_PRIVACY_ICON_URL)) == null) ? "" : str;
    }

    @NotNull
    public final String getPrivacyUrl$vungle_ads_release() {
        String str;
        Map<String, String> map = this.nativeAdAssetMap;
        return (map == null || (str = map.get(f1.TOKEN_VUNGLE_PRIVACY_URL)) == null) ? "" : str;
    }

    public final boolean hasCallToAction() {
        return getCtaUrl$vungle_ads_release().length() > 0;
    }

    @Override // com.vungle.ads.u
    public void onAdLoaded$vungle_ads_release(@NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        super.onAdLoaded$vungle_ads_release(advertisement);
        this.nativeAdAssetMap = advertisement.getMRAIDArgsInMap();
        createMediaAspectRatio();
    }

    public final void performCTA() {
        com.vungle.ads.internal.presenter.o oVar = this.presenter;
        if (oVar != null) {
            oVar.processCommand(com.vungle.ads.internal.presenter.o.DOWNLOAD, getCtaUrl$vungle_ads_release());
        }
    }

    public final void registerViewForInteraction(@NotNull FrameLayout rootView, @NotNull com.vungle.ads.internal.ui.view.c mediaView, @Nullable ImageView imageView, @Nullable Collection<? extends View> collection) {
        String str;
        kotlin.jvm.internal.t.i(rootView, "rootView");
        kotlin.jvm.internal.t.i(mediaView, "mediaView");
        o oVar = o.INSTANCE;
        oVar.logMetric$vungle_ads_release(new v1(Sdk$SDKMetric.b.PLAY_AD_API), (30 & 2) != 0 ? null : getPlacementId(), (30 & 4) != 0 ? null : getCreativeId(), (30 & 8) != 0 ? null : getEventId(), (30 & 16) != 0 ? null : null);
        getResponseToShowMetric$vungle_ads_release().markEnd();
        o.logMetric$vungle_ads_release$default(oVar, getResponseToShowMetric$vungle_ads_release(), getPlacementId(), getCreativeId(), getEventId(), (String) null, 16, (Object) null);
        getShowToPresentMetric$vungle_ads_release().markStart();
        getShowToFailMetric$vungle_ads_release().markStart();
        b2 b2VarCanPlayAd = getAdInternal$vungle_ads_release().canPlayAd(true);
        if (b2VarCanPlayAd != null) {
            if (getAdInternal$vungle_ads_release().isErrorTerminal$vungle_ads_release(b2VarCanPlayAd.getCode())) {
                getAdInternal$vungle_ads_release().setAdState(a.EnumC0499a.ERROR);
                Map<String, String> map = this.nativeAdAssetMap;
                if (map != null) {
                    map.clear();
                }
            }
            v adListener = getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToPlay(this, b2VarCanPlayAd);
                return;
            }
            return;
        }
        this.adRootView = rootView;
        this.adContentView = mediaView;
        this.adIconView = imageView;
        this.clickableViews = collection;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        v8.l lVarB = v8.n.b(v8.p.f35201a, new g(getContext()));
        Context context = getContext();
        com.vungle.ads.internal.load.a adInternal$vungle_ads_release = getAdInternal$vungle_ads_release();
        kotlin.jvm.internal.t.g(adInternal$vungle_ads_release, "null cannot be cast to non-null type com.vungle.ads.internal.presenter.NativePresenterDelegate");
        this.presenter = new com.vungle.ads.internal.presenter.o(context, (com.vungle.ads.internal.presenter.p) adInternal$vungle_ads_release, getAdInternal$vungle_ads_release().getAdvertisement(), getExecutors().getJobExecutor(), m4133registerViewForInteraction$lambda1(lVarB));
        Map<String, String> map2 = this.nativeAdAssetMap;
        if (map2 == null || (str = map2.get(f1.TOKEN_OM_SDK_DATA)) == null) {
            str = "";
        }
        com.vungle.ads.internal.presenter.o oVar2 = this.presenter;
        if (oVar2 != null) {
            oVar2.initOMTracker(str);
        }
        com.vungle.ads.internal.presenter.o oVar3 = this.presenter;
        if (oVar3 != null) {
            oVar3.startTracking(rootView);
        }
        com.vungle.ads.internal.presenter.o oVar4 = this.presenter;
        if (oVar4 != null) {
            oVar4.setEventListener(new com.vungle.ads.internal.presenter.a(this.adPlayCallback, getAdInternal$vungle_ads_release().getPlacement()));
        }
        h1 h1Var = this.adOptionsView;
        if (h1Var != null) {
            h1Var.setOnClickListener(new View.OnClickListener() { // from class: com.vungle.ads.v0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x0.m4134registerViewForInteraction$lambda2(this.f24423a, view);
                }
            });
        }
        if (collection == null) {
            collection = kotlin.collections.u.e(mediaView);
        }
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            ((View) it.next()).setOnClickListener(new View.OnClickListener() { // from class: com.vungle.ads.w0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    x0.m4135registerViewForInteraction$lambda4$lambda3(this.f24425a, view);
                }
            });
        }
        h1 h1Var2 = this.adOptionsView;
        if (h1Var2 != null) {
            h1Var2.renderTo(rootView, this.adOptionsPosition);
        }
        getImpressionTracker().addView(rootView, new h());
        displayImage(getMainImagePath(), mediaView.getMainImage$vungle_ads_release());
        displayImage(getAppIcon(), imageView);
        String privacyIconUrl$vungle_ads_release = getPrivacyIconUrl$vungle_ads_release();
        h1 h1Var3 = this.adOptionsView;
        displayImage(privacyIconUrl$vungle_ads_release, h1Var3 != null ? h1Var3.getPrivacyIcon$vungle_ads_release() : null);
        String watermark$vungle_ads_release = getAdConfig().getWatermark$vungle_ads_release();
        if (watermark$vungle_ads_release != null) {
            Context context2 = rootView.getContext();
            kotlin.jvm.internal.t.h(context2, "rootView.context");
            com.vungle.ads.internal.ui.g gVar = new com.vungle.ads.internal.ui.g(context2, watermark$vungle_ads_release);
            rootView.addView(gVar);
            gVar.bringToFront();
        }
        com.vungle.ads.internal.presenter.o oVar5 = this.presenter;
        if (oVar5 != null) {
            oVar5.prepare();
        }
    }

    public final void setAdOptionsPosition(int i10) {
        this.adOptionsPosition = i10;
    }

    public final void unregisterView() {
        if (getAdInternal$vungle_ads_release().getAdState() == a.EnumC0499a.FINISHED) {
            return;
        }
        Collection<? extends View> collection = this.clickableViews;
        if (collection != null) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                ((View) it.next()).setOnClickListener(null);
            }
        }
        this.clickableViews = null;
        Map<String, String> map = this.nativeAdAssetMap;
        if (map != null) {
            map.clear();
        }
        getImpressionTracker().destroy();
        com.vungle.ads.internal.ui.view.c cVar = this.adContentView;
        if (cVar != null) {
            cVar.destroy();
        }
        this.adContentView = null;
        h1 h1Var = this.adOptionsView;
        if (h1Var != null) {
            h1Var.destroy();
        }
        this.adOptionsView = null;
        try {
            ImageView imageView = this.adIconView;
            Drawable drawable = imageView != null ? imageView.getDrawable() : null;
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
            }
        } catch (Exception e10) {
            com.vungle.ads.internal.util.p.Companion.w(TAG, "error msg: " + e10.getLocalizedMessage());
        }
        ImageView imageView2 = this.adIconView;
        if (imageView2 != null) {
            imageView2.setImageDrawable(null);
        }
        this.adIconView = null;
        com.vungle.ads.internal.presenter.o oVar = this.presenter;
        if (oVar != null) {
            oVar.detach();
        }
    }

    @Override // com.vungle.ads.u
    @NotNull
    public f1 constructAdInternal$vungle_ads_release(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        return new f1(context);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x0(@NotNull Context context, @NotNull String placementId) {
        this(context, placementId, new com.vungle.ads.c());
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
    }

    public static /* synthetic */ void getAdOptionsPosition$annotations() {
    }

    /* JADX INFO: compiled from: NativeAd.kt */
    public static final class b implements com.vungle.ads.internal.presenter.b {
        final /* synthetic */ String $placementId;

        b(String str) {
            this.$placementId = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdClick$lambda-3, reason: not valid java name */
        public static final void m4136onAdClick$lambda3(x0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdClicked(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdEnd$lambda-2, reason: not valid java name */
        public static final void m4137onAdEnd$lambda2(x0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdEnd(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdImpression$lambda-1, reason: not valid java name */
        public static final void m4138onAdImpression$lambda1(x0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdImpression(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdLeftApplication$lambda-4, reason: not valid java name */
        public static final void m4139onAdLeftApplication$lambda4(x0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdLeftApplication(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onAdStart$lambda-0, reason: not valid java name */
        public static final void m4140onAdStart$lambda0(x0 this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdStart(this$0);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: onFailure$lambda-5, reason: not valid java name */
        public static final void m4141onFailure$lambda5(x0 this$0, b2 error) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            kotlin.jvm.internal.t.i(error, "$error");
            v adListener = this$0.getAdListener();
            if (adListener != null) {
                adListener.onAdFailedToPlay(this$0, error);
            }
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdClick(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final x0 x0Var = x0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.y0
                @Override // java.lang.Runnable
                public final void run() {
                    x0.b.m4136onAdClick$lambda3(x0Var);
                }
            });
            x0.this.getDisplayToClickMetric$vungle_ads_release().markEnd();
            o.INSTANCE.logMetric$vungle_ads_release(x0.this.getDisplayToClickMetric$vungle_ads_release(), (16 & 2) != 0 ? null : this.$placementId, (16 & 4) != 0 ? null : x0.this.getCreativeId(), (16 & 8) != 0 ? null : x0.this.getEventId(), (16 & 16) != 0 ? null : null);
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdEnd(@Nullable String str) {
            x0.this.getAdInternal$vungle_ads_release().setAdState(a.EnumC0499a.FINISHED);
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final x0 x0Var = x0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.c1
                @Override // java.lang.Runnable
                public final void run() {
                    x0.b.m4137onAdEnd$lambda2(x0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdImpression(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final x0 x0Var = x0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.d1
                @Override // java.lang.Runnable
                public final void run() {
                    x0.b.m4138onAdImpression$lambda1(x0Var);
                }
            });
            x0.this.getPresentToDisplayMetric$vungle_ads_release().markEnd();
            o.logMetric$vungle_ads_release$default(o.INSTANCE, x0.this.getPresentToDisplayMetric$vungle_ads_release(), this.$placementId, x0.this.getCreativeId(), x0.this.getEventId(), (String) null, 16, (Object) null);
            x0.this.getDisplayToClickMetric$vungle_ads_release().markStart();
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdLeftApplication(@Nullable String str) {
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final x0 x0Var = x0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.b1
                @Override // java.lang.Runnable
                public final void run() {
                    x0.b.m4139onAdLeftApplication$lambda4(x0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdStart(@Nullable String str) {
            x0.this.getAdInternal$vungle_ads_release().setAdState(a.EnumC0499a.PLAYING);
            x0.this.getSignalManager$vungle_ads_release().increaseSessionDepthCounter();
            x0.this.getShowToPresentMetric$vungle_ads_release().markEnd();
            o.logMetric$vungle_ads_release$default(o.INSTANCE, x0.this.getShowToPresentMetric$vungle_ads_release(), this.$placementId, x0.this.getCreativeId(), x0.this.getEventId(), (String) null, 16, (Object) null);
            x0.this.getPresentToDisplayMetric$vungle_ads_release().markStart();
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final x0 x0Var = x0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.z0
                @Override // java.lang.Runnable
                public final void run() {
                    x0.b.m4140onAdStart$lambda0(x0Var);
                }
            });
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onFailure(@NotNull final b2 error) {
            kotlin.jvm.internal.t.i(error, "error");
            x0.this.getAdInternal$vungle_ads_release().setAdState(a.EnumC0499a.ERROR);
            com.vungle.ads.internal.util.v vVar = com.vungle.ads.internal.util.v.INSTANCE;
            final x0 x0Var = x0.this;
            vVar.runOnUiThread(new Runnable() { // from class: com.vungle.ads.a1
                @Override // java.lang.Runnable
                public final void run() {
                    x0.b.m4141onFailure$lambda5(x0Var, error);
                }
            });
            x0.this.getShowToFailMetric$vungle_ads_release().markEnd();
            o.logMetric$vungle_ads_release$default(o.INSTANCE, x0.this.getShowToFailMetric$vungle_ads_release(), this.$placementId, x0.this.getCreativeId(), x0.this.getEventId(), (String) null, 16, (Object) null);
        }

        @Override // com.vungle.ads.internal.presenter.b
        public void onAdRewarded(@Nullable String str) {
        }
    }
}
