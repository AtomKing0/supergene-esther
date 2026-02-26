package com.vungle.ads;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: BaseAd.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class u implements com.vungle.ads.a {

    @NotNull
    private final com.vungle.ads.c adConfig;

    @NotNull
    private final v8.l adInternal$delegate;

    @Nullable
    private v adListener;

    @NotNull
    private final Context context;

    @Nullable
    private String creativeId;

    @NotNull
    private final l1 displayToClickMetric;

    @Nullable
    private String eventId;

    @NotNull
    private final String placementId;

    @NotNull
    private final w1 presentToDisplayMetric;

    @NotNull
    private final w1 requestToResponseMetric;

    @NotNull
    private final w1 responseToShowMetric;

    @NotNull
    private final w1 showToFailMetric;

    @NotNull
    private final w1 showToPresentMetric;

    @NotNull
    private final v8.l signalManager$delegate;

    @Nullable
    private com.vungle.ads.internal.signals.c signaledAd;

    /* JADX INFO: compiled from: BaseAd.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.a> {
        a() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.a invoke() {
            u uVar = u.this;
            return uVar.constructAdInternal$vungle_ads_release(uVar.getContext());
        }
    }

    /* JADX INFO: compiled from: BaseAd.kt */
    public static final class b implements com.vungle.ads.internal.load.a {
        final /* synthetic */ String $adMarkup;

        b(String str) {
            this.$adMarkup = str;
        }

        @Override // com.vungle.ads.internal.load.a
        public void onFailure(@NotNull b2 error) {
            kotlin.jvm.internal.t.i(error, "error");
            u uVar = u.this;
            uVar.onLoadFailure$vungle_ads_release(uVar, error);
        }

        @Override // com.vungle.ads.internal.load.a
        public void onSuccess(@NotNull com.vungle.ads.internal.model.b advertisement) {
            kotlin.jvm.internal.t.i(advertisement, "advertisement");
            u.this.onAdLoaded$vungle_ads_release(advertisement);
            u uVar = u.this;
            uVar.onLoadSuccess$vungle_ads_release(uVar, this.$adMarkup);
        }
    }

    /* JADX INFO: compiled from: ServiceLocator.kt */
    public static final class c extends kotlin.jvm.internal.v implements h9.a<com.vungle.ads.internal.signals.b> {
        final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(0);
            this.$context = context;
        }

        /* JADX WARN: Type inference failed for: r0v2, types: [com.vungle.ads.internal.signals.b, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final com.vungle.ads.internal.signals.b invoke() {
            return ServiceLocator.Companion.getInstance(this.$context).getService(com.vungle.ads.internal.signals.b.class);
        }
    }

    public u(@NotNull Context context, @NotNull String placementId, @NotNull com.vungle.ads.c adConfig) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(placementId, "placementId");
        kotlin.jvm.internal.t.i(adConfig, "adConfig");
        this.context = context;
        this.placementId = placementId;
        this.adConfig = adConfig;
        this.adInternal$delegate = v8.n.a(new a());
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.signalManager$delegate = v8.n.b(v8.p.f35201a, new c(context));
        this.requestToResponseMetric = new w1(Sdk$SDKMetric.b.AD_REQUEST_TO_RESPONSE_DURATION_MS);
        this.responseToShowMetric = new w1(Sdk$SDKMetric.b.AD_RESPONSE_TO_SHOW_DURATION_MS);
        this.showToPresentMetric = new w1(Sdk$SDKMetric.b.AD_SHOW_TO_PRESENT_DURATION_MS);
        this.presentToDisplayMetric = new w1(Sdk$SDKMetric.b.AD_PRESENT_TO_DISPLAY_DURATION_MS);
        this.showToFailMetric = new w1(Sdk$SDKMetric.b.AD_SHOW_TO_FAIL_DURATION_MS);
        this.displayToClickMetric = new l1(Sdk$SDKMetric.b.AD_DISPLAY_TO_CLICK_DURATION_MS);
    }

    private final void onLoadEnd() {
        this.requestToResponseMetric.markEnd();
        o.logMetric$vungle_ads_release$default(o.INSTANCE, this.requestToResponseMetric, this.placementId, this.creativeId, this.eventId, (String) null, 16, (Object) null);
        this.responseToShowMetric.markStart();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onLoadFailure$lambda-1, reason: not valid java name */
    public static final void m4130onLoadFailure$lambda1(u this$0, b2 vungleError) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(vungleError, "$vungleError");
        v vVar = this$0.adListener;
        if (vVar != null) {
            vVar.onAdFailedToLoad(this$0, vungleError);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: onLoadSuccess$lambda-0, reason: not valid java name */
    public static final void m4131onLoadSuccess$lambda0(u this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        v vVar = this$0.adListener;
        if (vVar != null) {
            vVar.onAdLoaded(this$0);
        }
    }

    @Override // com.vungle.ads.a
    @NotNull
    public Boolean canPlayAd() {
        return Boolean.valueOf(com.vungle.ads.internal.a.canPlayAd$default(getAdInternal$vungle_ads_release(), false, 1, null) == null);
    }

    @NotNull
    public abstract com.vungle.ads.internal.a constructAdInternal$vungle_ads_release(@NotNull Context context);

    @NotNull
    public final com.vungle.ads.c getAdConfig() {
        return this.adConfig;
    }

    @NotNull
    public final com.vungle.ads.internal.a getAdInternal$vungle_ads_release() {
        return (com.vungle.ads.internal.a) this.adInternal$delegate.getValue();
    }

    @Nullable
    public final v getAdListener() {
        return this.adListener;
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    @Nullable
    public final String getCreativeId() {
        return this.creativeId;
    }

    @NotNull
    public final l1 getDisplayToClickMetric$vungle_ads_release() {
        return this.displayToClickMetric;
    }

    @Nullable
    public final String getEventId() {
        return this.eventId;
    }

    @NotNull
    public final String getPlacementId() {
        return this.placementId;
    }

    @NotNull
    public final w1 getPresentToDisplayMetric$vungle_ads_release() {
        return this.presentToDisplayMetric;
    }

    @NotNull
    public final w1 getRequestToResponseMetric$vungle_ads_release() {
        return this.requestToResponseMetric;
    }

    @NotNull
    public final w1 getResponseToShowMetric$vungle_ads_release() {
        return this.responseToShowMetric;
    }

    @NotNull
    public final w1 getShowToFailMetric$vungle_ads_release() {
        return this.showToFailMetric;
    }

    @NotNull
    public final w1 getShowToPresentMetric$vungle_ads_release() {
        return this.showToPresentMetric;
    }

    @NotNull
    public final com.vungle.ads.internal.signals.b getSignalManager$vungle_ads_release() {
        return (com.vungle.ads.internal.signals.b) this.signalManager$delegate.getValue();
    }

    @Nullable
    public final com.vungle.ads.internal.signals.c getSignaledAd$vungle_ads_release() {
        return this.signaledAd;
    }

    @Override // com.vungle.ads.a, com.vungle.ads.i0
    public void load(@Nullable String str) {
        this.requestToResponseMetric.markStart();
        getAdInternal$vungle_ads_release().loadAd(this.placementId, str, new b(str));
    }

    public void onAdLoaded$vungle_ads_release(@NotNull com.vungle.ads.internal.model.b advertisement) {
        kotlin.jvm.internal.t.i(advertisement, "advertisement");
        advertisement.setAdConfig(this.adConfig);
        this.creativeId = advertisement.getCreativeId();
        String strEventId = advertisement.eventId();
        this.eventId = strEventId;
        com.vungle.ads.internal.signals.c cVar = this.signaledAd;
        if (cVar == null) {
            return;
        }
        cVar.setEventId(strEventId);
    }

    public void onLoadFailure$vungle_ads_release(@NotNull u baseAd, @NotNull final b2 vungleError) {
        kotlin.jvm.internal.t.i(baseAd, "baseAd");
        kotlin.jvm.internal.t.i(vungleError, "vungleError");
        com.vungle.ads.internal.util.v.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.s
            @Override // java.lang.Runnable
            public final void run() {
                u.m4130onLoadFailure$lambda1(this.f24420a, vungleError);
            }
        });
        onLoadEnd();
    }

    public void onLoadSuccess$vungle_ads_release(@NotNull u baseAd, @Nullable String str) {
        kotlin.jvm.internal.t.i(baseAd, "baseAd");
        com.vungle.ads.internal.util.v.INSTANCE.runOnUiThread(new Runnable() { // from class: com.vungle.ads.t
            @Override // java.lang.Runnable
            public final void run() {
                u.m4131onLoadSuccess$lambda0(this.f24422a);
            }
        });
        onLoadEnd();
    }

    public final void setAdListener(@Nullable v vVar) {
        this.adListener = vVar;
    }

    public final void setSignaledAd$vungle_ads_release(@Nullable com.vungle.ads.internal.signals.c cVar) {
        this.signaledAd = cVar;
    }

    @VisibleForTesting(otherwise = 2)
    public static /* synthetic */ void getRequestToResponseMetric$vungle_ads_release$annotations() {
    }
}
