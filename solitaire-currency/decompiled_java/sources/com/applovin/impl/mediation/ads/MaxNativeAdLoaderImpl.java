package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.applovin.impl.f6;
import com.applovin.impl.g3;
import com.applovin.impl.h;
import com.applovin.impl.l2;
import com.applovin.impl.m1;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.q2;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.a;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.u2;
import com.applovin.impl.w4;
import com.applovin.impl.z6;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class MaxNativeAdLoaderImpl extends com.applovin.impl.mediation.ads.a implements a.InterfaceC0171a, h.b {
    public static final String KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE = "ad_request_type";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f6018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f6020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private d.b f6021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Object f6022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MaxNativeAdListener f6023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Map f6024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Set f6025h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f6026a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f6027b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f6028c;

        a(MaxNativeAd maxNativeAd, List list, ViewGroup viewGroup) {
            this.f6026a = maxNativeAd;
            this.f6027b = list;
            this.f6028c = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6026a.prepareForInteraction(this.f6027b, this.f6028c)) {
                return;
            }
            com.applovin.impl.sdk.n.h(MaxNativeAdLoaderImpl.this.tag, "Failed to prepare native ad for interaction...");
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MaxNativeAdView f6030a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ u2 f6031b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ MaxNativeAd f6032c;

        b(MaxNativeAdView maxNativeAdView, u2 u2Var, MaxNativeAd maxNativeAd) {
            this.f6030a = maxNativeAdView;
            this.f6031b = u2Var;
            this.f6032c = maxNativeAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Rendering native ad view: " + this.f6030a);
            }
            MaxNativeAdLoaderImpl.this.sdk.w().d(this.f6031b);
            this.f6030a.render(this.f6031b, MaxNativeAdLoaderImpl.this.f6018a, MaxNativeAdLoaderImpl.this.sdk);
            this.f6032c.setNativeAdView(this.f6030a);
            if (this.f6032c.prepareForInteraction(this.f6030a.getClickableViews(), this.f6030a)) {
                return;
            }
            this.f6032c.prepareViewForInteraction(this.f6030a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class c implements a.InterfaceC0165a {
        private c() {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdClicked(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdClicked(nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f6023f);
            }
            l2.a(MaxNativeAdLoaderImpl.this.f6023f, maxAd, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdLoaderImpl.this.a(((MaxErrorImpl) maxError).getLoadTag());
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxNativeAdListener.onNativeAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxNativeAdLoaderImpl.this.f6023f);
            }
            l2.a(MaxNativeAdLoaderImpl.this.f6023f, str, maxError, true);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdLoaded(final MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mediation.ads.u
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6086a.a(maxAd);
                }
            });
        }

        @Override // com.applovin.mediation.MaxAdRevenueListener
        public void onAdRevenuePaid(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.revenueListener);
            }
            l2.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true);
        }

        /* synthetic */ c(MaxNativeAdLoaderImpl maxNativeAdLoaderImpl, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd) {
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Native ad loaded");
            }
            u2 u2Var = (u2) maxAd;
            u2Var.g(MaxNativeAdLoaderImpl.this.f6019b);
            u2Var.f(MaxNativeAdLoaderImpl.this.f6020c);
            synchronized (MaxNativeAdLoaderImpl.this.f6022e) {
                MaxNativeAdLoaderImpl.this.f6025h.add(u2Var);
            }
            MaxNativeAdView maxNativeAdViewA = MaxNativeAdLoaderImpl.this.a(u2Var.J());
            if (maxNativeAdViewA == null) {
                com.applovin.impl.sdk.n nVar2 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl2 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl2.logger.a(maxNativeAdLoaderImpl2.tag, "No custom view provided, checking template");
                }
                String strN0 = u2Var.n0();
                if (StringUtils.isValidString(strN0)) {
                    com.applovin.impl.sdk.n nVar3 = MaxNativeAdLoaderImpl.this.logger;
                    if (com.applovin.impl.sdk.n.a()) {
                        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl3 = MaxNativeAdLoaderImpl.this;
                        maxNativeAdLoaderImpl3.logger.a(maxNativeAdLoaderImpl3.tag, "Using template: " + strN0 + "...");
                    }
                    maxNativeAdViewA = new MaxNativeAdView(strN0, com.applovin.impl.sdk.j.n());
                }
            }
            if (maxNativeAdViewA == null) {
                com.applovin.impl.sdk.n nVar4 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl4 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl4.logger.a(maxNativeAdLoaderImpl4.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                }
                com.applovin.impl.sdk.n nVar5 = MaxNativeAdLoaderImpl.this.logger;
                if (com.applovin.impl.sdk.n.a()) {
                    MaxNativeAdLoaderImpl maxNativeAdLoaderImpl5 = MaxNativeAdLoaderImpl.this;
                    maxNativeAdLoaderImpl5.logger.a(maxNativeAdLoaderImpl5.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=null, nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f6023f);
                }
                l2.a(MaxNativeAdLoaderImpl.this.f6023f, (MaxNativeAdView) null, maxAd, true);
                MaxNativeAdLoaderImpl.this.a(u2Var);
                return;
            }
            a(maxNativeAdViewA);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA, u2Var, u2Var.getNativeAd());
            com.applovin.impl.sdk.n nVar6 = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl6 = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl6.logger.a(maxNativeAdLoaderImpl6.tag, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=" + maxNativeAdViewA + ", nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.f6023f);
            }
            l2.a(MaxNativeAdLoaderImpl.this.f6023f, maxNativeAdViewA, maxAd, true);
            MaxNativeAdLoaderImpl.this.a(u2Var);
            MaxNativeAdLoaderImpl.this.a(maxNativeAdViewA);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayed(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdHidden(MaxAd maxAd) {
        }

        @Override // com.applovin.mediation.MaxAdRequestListener
        public void onAdRequestStarted(String str) {
        }

        private void a(MaxNativeAdView maxNativeAdView) {
            u2 u2VarB;
            com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker == null || (u2VarB = adViewTracker.b()) == null) {
                return;
            }
            com.applovin.impl.sdk.n nVar = MaxNativeAdLoaderImpl.this.logger;
            if (com.applovin.impl.sdk.n.a()) {
                MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = MaxNativeAdLoaderImpl.this;
                maxNativeAdLoaderImpl.logger.a(maxNativeAdLoaderImpl.tag, "Destroying previous ad");
            }
            MaxNativeAdLoaderImpl.this.destroy(u2VarB);
        }

        @Override // com.applovin.mediation.MaxAdListener
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }
    }

    public MaxNativeAdLoaderImpl(String str, com.applovin.impl.sdk.j jVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", jVar);
        this.f6018a = new c(this, null);
        this.f6021d = d.b.PUBLISHER_INITIATED;
        this.f6022e = new Object();
        this.f6024g = new HashMap();
        this.f6025h = new HashSet();
        jVar.j().a(this);
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void destroy() {
        this.f6023f = null;
        this.sdk.j().b(this);
        synchronized (this.f6022e) {
            this.f6024g.clear();
            this.f6025h.clear();
        }
        super.destroy();
    }

    public String getPlacement() {
        return this.f6019b;
    }

    public void handleNativeAdViewRendered(MaxAd maxAd) {
        MaxNativeAd nativeAd = ((u2) maxAd).getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        com.applovin.impl.mediation.ads.b adViewTracker = nativeAd.getAdViewTracker();
        if (adViewTracker != null) {
            adViewTracker.c();
        } else if (com.applovin.impl.sdk.n.a()) {
            this.logger.b(this.tag, "Failed to handle native ad rendered. Could not retrieve tracker. Ad might not have been registered via MaxNativeAdLoader.a(...).");
        }
    }

    public void loadAd(@Nullable MaxNativeAdView maxNativeAdView) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Loading native ad for '" + this.adUnitId + "' into '" + maxNativeAdView + "' and notifying " + this.f6018a + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.Q().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.f6021d, this.localExtraParameters, this.extraParameters, com.applovin.impl.sdk.j.n(), this.f6018a);
    }

    @Override // com.applovin.impl.sdk.a.InterfaceC0171a
    public void onAdExpired(m1 m1Var) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Ad expired for ad unit id " + getAdUnitId());
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "MaxNativeAdListener.onNativeAdExpired(nativeAd=" + m1Var + "), listener=" + this.f6023f);
        }
        l2.b(this.f6023f, (MaxAd) m1Var, true);
    }

    @Override // com.applovin.impl.h.b
    public void onCreativeIdGenerated(String str, String str2) {
        u2 u2Var;
        Iterator it = this.f6025h.iterator();
        while (true) {
            if (!it.hasNext()) {
                u2Var = null;
                break;
            } else {
                u2Var = (u2) it.next();
                if (u2Var.N().equalsIgnoreCase(str)) {
                    break;
                }
            }
        }
        if (u2Var != null) {
            u2Var.h(str2);
            l2.b(this.adReviewListener, str2, u2Var);
            synchronized (this.f6022e) {
                this.f6025h.remove(u2Var);
            }
        }
    }

    public void registerClickableViews(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        u2 u2Var = (u2) maxAd;
        MaxNativeAd nativeAd = u2Var.getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to register native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        u2Var.a(viewGroup);
        this.sdk.w().d(u2Var);
        a((q2) u2Var);
        nativeAd.setClickableViews(list);
        nativeAd.setAdViewTracker(new com.applovin.impl.mediation.ads.b(u2Var, viewGroup, this.f6018a, this.sdk));
        a aVar = new a(nativeAd, list, viewGroup);
        if (nativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(aVar);
        } else {
            this.sdk.j0().a((w4) new f6(this.sdk, "renderMaxNativeAd", aVar), r5.b.MEDIATION);
        }
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof u2)) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        }
        if (maxNativeAdView == null) {
            com.applovin.impl.sdk.n.h(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        }
        u2 u2Var = (u2) maxAd;
        MaxNativeAd nativeAd = u2Var.getNativeAd();
        if (nativeAd == null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.logger.b(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
            }
            return false;
        }
        if (nativeAd.isExpired() && !((Boolean) this.sdk.a(g3.f5226b7)).booleanValue()) {
            com.applovin.impl.sdk.n.h(this.tag, "Cancelled rendering for expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
            return false;
        }
        a(maxNativeAdView, u2Var, nativeAd);
        a(maxNativeAdView);
        return true;
    }

    public void setCustomData(String str) {
        z6.b(str, this.tag);
        this.f6020c = str;
    }

    @Override // com.applovin.impl.mediation.ads.a
    public void setLocalExtraParameter(String str, Object obj) {
        super.setLocalExtraParameter(str, obj);
        if (KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE.equalsIgnoreCase(str) && (obj instanceof d.b)) {
            this.f6021d = (d.b) obj;
        }
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.f6023f = maxNativeAdListener;
    }

    public void setPlacement(String str) {
        this.f6019b = str;
    }

    @NonNull
    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.f6023f + ", revenueListener=" + this.revenueListener + '}';
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(u2 u2Var) {
        if (u2Var.m0().get()) {
            return;
        }
        this.sdk.f().a(u2Var, this);
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f6022e) {
            this.f6024g.put(str, maxNativeAdView);
        }
    }

    public void destroy(MaxAd maxAd) {
        com.applovin.impl.mediation.ads.b adViewTracker;
        if (maxAd instanceof u2) {
            u2 u2Var = (u2) maxAd;
            if (u2Var.q0()) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.logger.a(this.tag, "Native ad (" + u2Var + ") has already been destroyed");
                    return;
                }
                return;
            }
            synchronized (this.f6022e) {
                this.f6025h.remove(u2Var);
            }
            MaxNativeAdView maxNativeAdViewK0 = u2Var.k0();
            if (maxNativeAdViewK0 != null && (adViewTracker = maxNativeAdViewK0.getAdViewTracker()) != null && maxAd.equals(adViewTracker.b())) {
                maxNativeAdViewK0.recycle();
            }
            MaxNativeAd nativeAd = u2Var.getNativeAd();
            if (nativeAd != null && nativeAd.getAdViewTracker() != null) {
                nativeAd.getAdViewTracker().a();
            }
            this.sdk.f().a(u2Var);
            this.sdk.Q().destroyAd(u2Var);
            this.sdk.K().c(this.adUnitId, u2Var.J());
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.logger.a(this.tag, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MaxNativeAdView a(String str) {
        MaxNativeAdView maxNativeAdView;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.f6022e) {
            maxNativeAdView = (MaxNativeAdView) this.f6024g.remove(str);
        }
        return maxNativeAdView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView, u2 u2Var, MaxNativeAd maxNativeAd) {
        u2Var.a(maxNativeAdView);
        a((q2) u2Var);
        b bVar = new b(maxNativeAdView, u2Var, maxNativeAd);
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(bVar);
        } else {
            this.sdk.j0().a((w4) new f6(this.sdk, "renderMaxNativeAd", bVar), r5.b.MEDIATION);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MaxNativeAdView maxNativeAdView) {
        com.applovin.impl.mediation.ads.b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker == null || !maxNativeAdView.isAttachedToWindow()) {
            return;
        }
        adViewTracker.c();
    }
}
