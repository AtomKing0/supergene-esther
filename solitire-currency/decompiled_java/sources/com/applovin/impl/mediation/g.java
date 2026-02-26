package com.applovin.impl.mediation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.a3;
import com.applovin.impl.f6;
import com.applovin.impl.g3;
import com.applovin.impl.g4;
import com.applovin.impl.l4;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.q2;
import com.applovin.impl.r4;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.t2;
import com.applovin.impl.w4;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.adapter.MaxAdViewAdapter;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.mediation.adapter.MaxAppOpenAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdViewAdapter;
import com.applovin.mediation.adapter.MaxInterstitialAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdViewAdapter;
import com.applovin.mediation.adapter.MaxRewardedAdapter;
import com.applovin.mediation.adapter.MaxSignalProvider;
import com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener;
import com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterSignalCollectionParameters;
import com.applovin.mediation.adapters.MediationAdapterBase;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import com.unity3d.services.ads.gmascar.bridges.mobileads.MobileAdsBridgeBase;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f6213b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.applovin.impl.sdk.n f6214c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f6215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a3 f6216e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f6217f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MaxAdapter f6218g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f6219h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private q2 f6220i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private View f6221j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private MaxNativeAd f6222k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private MaxNativeAdView f6223l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ViewGroup f6224m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private MaxAdapterResponseParameters f6226o;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final boolean f6230s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f6212a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final b f6225n = new b(this, null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f6227p = new AtomicBoolean(true);

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f6228q = new AtomicBoolean(false);

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f6229r = new AtomicBoolean(false);

    class a implements MaxSignalCollectionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ r4 f6231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ g4 f6232b;

        a(r4 r4Var, g4 g4Var) {
            this.f6231a = r4Var;
            this.f6232b = g4Var;
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
        public void onSignalCollected(String str) {
            if (this.f6231a.x() && TextUtils.isEmpty(str)) {
                this.f6232b.a(new MaxErrorImpl("Signal is not a valid string"));
            } else {
                this.f6232b.b(str);
            }
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxSignalCollectionListener
        public void onSignalCollectionFailed(String str) {
            this.f6232b.a(new MaxErrorImpl(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements MaxInterstitialAdapterListener, MaxAppOpenAdapterListener, MaxRewardedAdapterListener, MaxAdViewAdapterListener, MaxNativeAdAdapterListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private MediationServiceImpl.b f6234a;

        private b() {
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked() {
            onAdViewAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed() {
            onAdViewAdCollapsed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAdViewAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed() {
            onAdViewAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded() {
            onAdViewAdExpanded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden() {
            onAdViewAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": adview ad ad failed to load with error: " + maxAdapterError);
            }
            a("onAdViewAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view) {
            onAdViewAdLoaded(view, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked() {
            onAppOpenAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onAppOpenAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed() {
            onAppOpenAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden() {
            onAppOpenAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": app open ad failed to load with error: " + maxAdapterError);
            }
            a("onAppOpenAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded() {
            onAppOpenAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked() {
            onInterstitialAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onInterstitialAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed() {
            onInterstitialAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden() {
            onInterstitialAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": interstitial ad failed to load with error " + maxAdapterError);
            }
            a("onInterstitialAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded() {
            onInterstitialAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked() {
            onNativeAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": native ad displayed with extra info: " + bundle);
            }
            a("onNativeAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": native ad ad failed to load with error: " + maxAdapterError);
            }
            a("onNativeAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdLoaded(MaxNativeAd maxNativeAd, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": native ad loaded with extra info: " + bundle);
            }
            g.this.f6222k = maxNativeAd;
            c("onNativeAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked() {
            onRewardedAdClicked(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError) {
            onRewardedAdDisplayFailed(maxAdapterError, null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed() {
            onRewardedAdDisplayed(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden() {
            onRewardedAdHidden(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoadFailed(MaxAdapterError maxAdapterError) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": rewarded ad failed to load with error: " + maxAdapterError);
            }
            a("onRewardedAdLoadFailed", maxAdapterError);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded() {
            onRewardedAdLoaded(null);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onUserRewarded(MaxReward maxReward) {
            onUserRewarded(maxReward, null);
        }

        /* synthetic */ b(g gVar, a aVar) {
            this();
        }

        private void b(String str, final Bundle bundle) {
            if (g.this.f6220i.w().compareAndSet(false, true)) {
                a(str, this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.v0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6338a.i(bundle);
                    }
                });
            }
        }

        private void c(String str, final Bundle bundle) {
            if (!g.this.f6220i.w().get()) {
                g.this.f6229r.set(true);
                a(str, this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.y0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6353a.j(bundle);
                    }
                });
                return;
            }
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.b("MediationAdapterWrapper", g.this.f6217f + ": blocking ad loaded callback for " + g.this.f6220i + " since onAdHidden() has been called");
            }
            g.this.f6213b.r().a(g.this.f6220i, str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Bundle bundle) {
            this.f6234a.a(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(Bundle bundle) {
            this.f6234a.a(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f(Bundle bundle) {
            this.f6234a.a(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(Bundle bundle) {
            this.f6234a.c(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(Bundle bundle) {
            this.f6234a.c(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i(Bundle bundle) {
            this.f6234a.e(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void j(Bundle bundle) {
            if (g.this.f6228q.compareAndSet(false, true)) {
                this.f6234a.f(g.this.f6220i, bundle);
            }
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": adview ad clicked with extra info: " + bundle);
            }
            a("onAdViewAdClicked", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.w0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6343a.a(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdCollapsed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": adview ad collapsed");
            }
            a("onAdViewAdCollapsed", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.u0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6334a.a();
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": adview ad failed to display with error: " + maxAdapterError);
            }
            a("onAdViewAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": adview ad displayed with extra info: " + bundle);
            }
            a("onAdViewAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdExpanded(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": adview ad expanded");
            }
            a("onAdViewAdExpanded", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.s0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6325a.b(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": adview ad hidden with extra info: " + bundle);
            }
            b("onAdViewAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAdViewAdapterListener
        public void onAdViewAdLoaded(View view, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": adview ad loaded with extra info: " + bundle);
            }
            g.this.f6221j = view;
            c("onAdViewAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": app open ad clicked with extra info: " + bundle);
            }
            a("onAppOpenAdClicked", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.l0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6286a.c(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": app open ad display failed with error: " + maxAdapterError);
            }
            a("onAppOpenAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": app open ad displayed with extra info: " + bundle);
            }
            a("onAppOpenAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": app open ad hidden with extra info: " + bundle);
            }
            b("onAppOpenAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxAppOpenAdapterListener
        public void onAppOpenAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": app open ad loaded with extra info: " + bundle);
            }
            c("onAppOpenAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": interstitial ad clicked with extra info: " + bundle);
            }
            a("onInterstitialAdClicked", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.o0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6305a.d(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": interstitial ad failed to display with error " + maxAdapterError);
            }
            a("onInterstitialAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": interstitial ad displayed with extra info: " + bundle);
            }
            a("onInterstitialAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": interstitial ad hidden with extra info " + bundle);
            }
            b("onInterstitialAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxInterstitialAdapterListener
        public void onInterstitialAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": interstitial ad loaded with extra info: " + bundle);
            }
            c("onInterstitialAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxNativeAdAdapterListener
        public void onNativeAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": native ad clicked");
            }
            a("onNativeAdClicked", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.k0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6277a.e(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdClicked(final Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": rewarded ad clicked with extra info: " + bundle);
            }
            a("onRewardedAdClicked", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.x0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6348a.f(bundle);
                }
            });
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayFailed(MaxAdapterError maxAdapterError, Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.k("MediationAdapterWrapper", g.this.f6217f + ": rewarded ad display failed with error: " + maxAdapterError);
            }
            a("onRewardedAdDisplayFailed", maxAdapterError, bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdDisplayed(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": rewarded ad displayed with extra info: " + bundle);
            }
            a("onRewardedAdDisplayed", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdHidden(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": rewarded ad hidden with extra info: " + bundle);
            }
            b("onRewardedAdHidden", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onRewardedAdLoaded(Bundle bundle) {
            com.applovin.impl.sdk.n unused = g.this.f6214c;
            if (com.applovin.impl.sdk.n.a()) {
                g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": rewarded ad loaded with extra info: " + bundle);
            }
            c("onRewardedAdLoaded", bundle);
        }

        @Override // com.applovin.mediation.adapter.listeners.MaxRewardedAdapterListener
        public void onUserRewarded(final MaxReward maxReward, final Bundle bundle) {
            if (g.this.f6220i instanceof t2) {
                final t2 t2Var = (t2) g.this.f6220i;
                if (t2Var.l0().compareAndSet(false, true)) {
                    com.applovin.impl.sdk.n unused = g.this.f6214c;
                    if (com.applovin.impl.sdk.n.a()) {
                        g.this.f6214c.d("MediationAdapterWrapper", g.this.f6217f + ": user was rewarded: " + maxReward);
                    }
                    a("onUserRewarded", this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.t0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f6328a.a(t2Var, maxReward, bundle);
                        }
                    });
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(Bundle bundle) {
            this.f6234a.d(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(MediationServiceImpl.b bVar) {
            if (bVar != null) {
                this.f6234a = bVar;
                return;
            }
            throw new IllegalArgumentException("No listener specified");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(Bundle bundle) {
            this.f6234a.a(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError) {
            if (g.this.f6220i.w().get()) {
                com.applovin.impl.sdk.n unused = g.this.f6214c;
                if (com.applovin.impl.sdk.n.a()) {
                    g.this.f6214c.b("MediationAdapterWrapper", g.this.f6217f + ": blocking ad load failed callback for " + g.this.f6220i + " since onAdHidden() has been called");
                }
                g.this.f6213b.r().a(g.this.f6220i, str);
                return;
            }
            a(str, this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.q0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6315a.a(maxError);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError) {
            if (g.this.f6228q.compareAndSet(false, true)) {
                this.f6234a.onAdLoadFailed(g.this.f6219h, maxError);
            }
        }

        private void a(String str, final Bundle bundle) {
            if (g.this.f6220i.w().get()) {
                com.applovin.impl.sdk.n unused = g.this.f6214c;
                if (com.applovin.impl.sdk.n.a()) {
                    g.this.f6214c.b("MediationAdapterWrapper", g.this.f6217f + ": blocking ad displayed callback for " + g.this.f6220i + " since onAdHidden() has been called");
                }
                g.this.f6213b.r().a(g.this.f6220i, str);
                return;
            }
            if (!((Boolean) g.this.f6213b.a(g3.f5254y7)).booleanValue()) {
                if (g.this.f6220i.u().compareAndSet(false, true)) {
                    a(str, this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.n0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f6299a.h(bundle);
                        }
                    });
                    return;
                }
                return;
            }
            a(str, this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.m0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6294a.g(bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str, final MaxError maxError, final Bundle bundle) {
            if (g.this.f6220i.w().get()) {
                com.applovin.impl.sdk.n unused = g.this.f6214c;
                if (com.applovin.impl.sdk.n.a()) {
                    g.this.f6214c.b("MediationAdapterWrapper", g.this.f6217f + ": blocking ad display failed callback for " + g.this.f6220i + " since onAdHidden() has been called");
                }
                g.this.f6213b.r().a(g.this.f6220i, str);
                return;
            }
            a(str, this.f6234a, new Runnable() { // from class: com.applovin.impl.mediation.r0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6319a.a(maxError, bundle);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxError maxError, Bundle bundle) {
            this.f6234a.a(g.this.f6220i, maxError, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(t2 t2Var, MaxReward maxReward, Bundle bundle) {
            this.f6234a.a(t2Var, maxReward, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Bundle bundle) {
            this.f6234a.a(g.this.f6220i, bundle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            this.f6234a.onAdCollapsed(g.this.f6220i);
        }

        private void a(final String str, final MaxAdListener maxAdListener, final Runnable runnable) {
            g.this.f6212a.post(new Runnable() { // from class: com.applovin.impl.mediation.p0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6309a.a(runnable, maxAdListener, str);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(Runnable runnable, MaxAdListener maxAdListener, String str) {
            try {
                runnable.run();
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to forward call (" + str + ") to " + (maxAdListener != null ? maxAdListener.getClass().getName() : null), th);
                g.this.f6213b.A().a("MediationAdapterWrapper", str, th, CollectionUtils.hashMap("adapter_class", g.this.f6216e.b()));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class c implements MaxAdapter.OnCompletionListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.applovin.impl.sdk.j f6236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a3 f6237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f6238c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final MaxAdapter.OnCompletionListener f6239d;

        public c(com.applovin.impl.sdk.j jVar, a3 a3Var, long j10, MaxAdapter.OnCompletionListener onCompletionListener) {
            this.f6236a = jVar;
            this.f6237b = a3Var;
            this.f6238c = j10;
            this.f6239d = onCompletionListener;
        }

        @Override // com.applovin.mediation.adapter.MaxAdapter.OnCompletionListener
        public void onCompletion(final MaxAdapter.InitializationStatus initializationStatus, final String str) {
            AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.mediation.z0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6359a.a(initializationStatus, str);
                }
            }, this.f6237b.h());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(MaxAdapter.InitializationStatus initializationStatus, String str) {
            this.f6236a.L().a(this.f6237b, SystemClock.elapsedRealtime() - this.f6238c, initializationStatus, str);
            MaxAdapter.OnCompletionListener onCompletionListener = this.f6239d;
            if (onCompletionListener != null) {
                onCompletionListener.onCompletion(initializationStatus, str);
            }
        }
    }

    private class d extends w4 {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final WeakReference f6240g;

        /* synthetic */ d(g gVar, a aVar) {
            this();
        }

        private void b(q2 q2Var) {
            if (q2Var != null) {
                this.f7677a.S().a(q2Var);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (g.this.f6228q.get()) {
                return;
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f7679c.b(this.f7678b, g.this.f6217f + " is timing out " + g.this.f6220i + "...");
            }
            b(g.this.f6220i);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-5101, "Adapter timed out");
            b bVar = (b) this.f6240g.get();
            if (bVar != null) {
                bVar.a(this.f7678b, maxErrorImpl);
            }
        }

        private d() {
            super("TaskTimeoutMediatedAd", g.this.f6213b);
            this.f6240g = new WeakReference(g.this.f6225n);
        }
    }

    g(a3 a3Var, MaxAdapter maxAdapter, boolean z10, com.applovin.impl.sdk.j jVar) {
        if (a3Var == null) {
            throw new IllegalArgumentException("No adapter name specified");
        }
        if (maxAdapter == null) {
            throw new IllegalArgumentException("No adapter specified");
        }
        if (jVar == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f6215d = a3Var.c();
        this.f6218g = maxAdapter;
        this.f6213b = jVar;
        this.f6214c = jVar.I();
        this.f6216e = a3Var;
        this.f6217f = maxAdapter.getClass().getSimpleName();
        this.f6230s = z10;
    }

    public String toString() {
        return "MediationAdapterWrapper{adapterTag='" + this.f6217f + "'}";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        a("destroy");
        MaxAdapter maxAdapter = this.f6218g;
        if (maxAdapter != null) {
            this.f6218g = null;
            maxAdapter.onDestroy();
        } else if (com.applovin.impl.sdk.n.a()) {
            this.f6214c.k("MediationAdapterWrapper", "Mediation adapter '" + this.f6217f + "' is already destroyed");
        }
        this.f6221j = null;
        this.f6222k = null;
        this.f6223l = null;
        this.f6224m = null;
    }

    public String i() {
        MaxAdapter maxAdapter = this.f6218g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getSdkVersion();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to get adapter's SDK version for " + this.f6215d, th);
            this.f6213b.A().a("MediationAdapterWrapper", "sdk_version", th, CollectionUtils.hashMap("adapter_class", this.f6216e.b()));
            a("sdk_version");
            this.f6213b.M().a(this.f6216e.b(), "sdk_version", this.f6220i);
            return null;
        }
    }

    public boolean j() {
        return this.f6228q.get() && this.f6229r.get();
    }

    public boolean k() {
        return this.f6227p.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxAppOpenAdapter) this.f6218g).loadAppOpenAd(maxAdapterResponseParameters, activity, this.f6225n);
    }

    public MediationServiceImpl.b c() {
        return this.f6225n.f6234a;
    }

    public View d() {
        return this.f6221j;
    }

    public MaxNativeAd e() {
        return this.f6222k;
    }

    public MaxNativeAdView f() {
        return this.f6223l;
    }

    public String g() {
        return this.f6215d;
    }

    public ViewGroup h() {
        return this.f6224m;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxRewardedAdapter) this.f6218g).loadRewardedAd(maxAdapterResponseParameters, activity, this.f6225n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MediationAdapterBase) this.f6218g).loadNativeAd(maxAdapterResponseParameters, activity, this.f6225n);
    }

    void a(final MaxAdapterInitializationParameters maxAdapterInitializationParameters, final Activity activity, final MaxAdapter.OnCompletionListener onCompletionListener) {
        b(MobileAdsBridgeBase.initializeMethodName, new Runnable() { // from class: com.applovin.impl.mediation.j0
            @Override // java.lang.Runnable
            public final void run() {
                this.f6266a.a(onCompletionListener, maxAdapterInitializationParameters, activity);
            }
        });
    }

    public void b(q2 q2Var, final Activity activity) {
        Runnable runnable;
        if (a(q2Var, activity)) {
            if (q2Var.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6332a.a(activity);
                    }
                };
            } else if (q2Var.getFormat() == MaxAdFormat.APP_OPEN) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.b0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6091a.b(activity);
                    }
                };
            } else if (q2Var.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6097a.c(activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + q2Var + ": " + q2Var.getFormat() + " is not a supported ad format");
            }
            a(runnable, q2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapter.OnCompletionListener onCompletionListener, MaxAdapterInitializationParameters maxAdapterInitializationParameters, Activity activity) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6214c.a("MediationAdapterWrapper", "Initializing " + this.f6217f + " on thread: " + Thread.currentThread() + " with 'run_on_ui_thread' value: " + this.f6216e.r());
        }
        this.f6218g.initialize(maxAdapterInitializationParameters, activity, new c(this.f6213b, this.f6216e, jElapsedRealtime, onCompletionListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Activity activity) {
        ((MaxRewardedAdapter) this.f6218g).showRewardedAd(this.f6226o, activity, this.f6225n);
    }

    void a(String str, q2 q2Var) {
        this.f6219h = str;
        this.f6220i = q2Var;
    }

    public void a(MaxNativeAdView maxNativeAdView) {
        this.f6223l = maxNativeAdView;
    }

    public void a(ViewGroup viewGroup) {
        this.f6224m = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity) {
        ((MaxAppOpenAdapter) this.f6218g).showAppOpenAd(this.f6226o, activity, this.f6225n);
    }

    public void a(String str, final MaxAdapterResponseParameters maxAdapterResponseParameters, final q2 q2Var, final Activity activity, MediationServiceImpl.b bVar) {
        final Runnable runnable;
        if (q2Var != null) {
            if (!this.f6227p.get()) {
                String str2 = "Mediation adapter '" + this.f6217f + "' was disabled due to earlier failures. Loading ads with this adapter is disabled.";
                com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str2);
                bVar.onAdLoadFailed(str, new MaxErrorImpl(-1, str2));
                return;
            }
            this.f6226o = maxAdapterResponseParameters;
            this.f6225n.a(bVar);
            final MaxAdFormat format = q2Var.getFormat();
            if (format == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6335a.a(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (format == MaxAdFormat.APP_OPEN) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6340a.b(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (format == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6345a.c(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (format == MaxAdFormat.NATIVE) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6350a.d(maxAdapterResponseParameters, activity);
                    }
                };
            } else if (format.isAdViewAd()) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.z
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6355a.a(maxAdapterResponseParameters, format, activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to load " + q2Var + ": " + q2Var.getFormat() + " is not a supported ad format");
            }
            a("load_ad", format, new Runnable() { // from class: com.applovin.impl.mediation.a0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f5963a.a(q2Var, runnable);
                }
            });
            return;
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxRewardedAdViewAdapter) this.f6218g).showRewardedAd(this.f6226o, viewGroup, lifecycle, activity, this.f6225n);
    }

    public String b() {
        MaxAdapter maxAdapter = this.f6218g;
        if (maxAdapter == null) {
            return null;
        }
        try {
            return maxAdapter.getAdapterVersion();
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed to get adapter version for " + this.f6215d, th);
            this.f6213b.A().a("MediationAdapterWrapper", "adapter_version", th, CollectionUtils.hashMap("adapter_class", this.f6216e.b()));
            a("adapter_version");
            this.f6213b.M().a(this.f6216e.b(), "adapter_version", this.f6220i);
            return null;
        }
    }

    private void b(String str, Runnable runnable) {
        a(str, (MaxAdFormat) null, runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, Activity activity) {
        ((MaxInterstitialAdapter) this.f6218g).loadInterstitialAd(maxAdapterResponseParameters, activity, this.f6225n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, Activity activity) {
        ((MaxAdViewAdapter) this.f6218g).loadAdViewAd(maxAdapterResponseParameters, maxAdFormat, activity, this.f6225n);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(q2 q2Var, Runnable runnable) {
        a(this.f6216e, q2Var);
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start loading ad for " + this.f6215d + " due to: " + th;
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
            this.f6225n.a("load_ad", new MaxErrorImpl(-1, str));
            this.f6213b.A().a("MediationAdapterWrapper", "load_ad", th, CollectionUtils.hashMap("adapter_class", this.f6216e.b()));
            a("load_ad");
            this.f6213b.M().a(this.f6216e.b(), "load_ad", this.f6220i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity) {
        ((MaxInterstitialAdapter) this.f6218g).showInterstitialAd(this.f6226o, activity, this.f6225n);
    }

    public void a(q2 q2Var, final ViewGroup viewGroup, final Lifecycle lifecycle, final Activity activity) {
        Runnable runnable;
        if (a(q2Var, activity)) {
            if (q2Var.getFormat() == MaxAdFormat.INTERSTITIAL) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.e0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6192a.a(viewGroup, lifecycle, activity);
                    }
                };
            } else if (q2Var.getFormat() == MaxAdFormat.REWARDED) {
                runnable = new Runnable() { // from class: com.applovin.impl.mediation.f0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6208a.b(viewGroup, lifecycle, activity);
                    }
                };
            } else {
                throw new IllegalStateException("Failed to show " + q2Var + ": " + q2Var.getFormat() + " is not a supported ad format");
            }
            a(runnable, q2Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        ((MaxInterstitialAdViewAdapter) this.f6218g).showInterstitialAd(this.f6226o, viewGroup, lifecycle, activity, this.f6225n);
    }

    private boolean a(q2 q2Var, Activity activity) {
        if (q2Var != null) {
            if (q2Var.A() == null) {
                com.applovin.impl.sdk.n.h("MediationAdapterWrapper", "Adapter has been garbage collected");
                this.f6225n.a("ad_show", new MaxErrorImpl(-1, "Adapter has been garbage collected"), (Bundle) null);
                return false;
            }
            if (q2Var.A() == this) {
                if (activity == null && MaxAdFormat.APP_OPEN != q2Var.getFormat()) {
                    throw new IllegalArgumentException("No activity specified");
                }
                if (!this.f6227p.get()) {
                    String str = "Mediation adapter '" + this.f6217f + "' is disabled. Showing ads with this adapter is disabled.";
                    com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
                    this.f6225n.a("ad_show", new MaxErrorImpl(-1, str), (Bundle) null);
                    return false;
                }
                if (j()) {
                    return true;
                }
                throw new IllegalStateException("Mediation adapter '" + this.f6217f + "' does not have an ad loaded. Please load an ad first");
            }
            throw new IllegalArgumentException("Mediated ad belongs to a different adapter");
        }
        throw new IllegalArgumentException("No mediated ad specified");
    }

    private void a(final Runnable runnable, q2 q2Var) {
        a("show_ad", q2Var.getFormat(), new Runnable() { // from class: com.applovin.impl.mediation.i0
            @Override // java.lang.Runnable
            public final void run() {
                this.f6257a.a(runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            String str = "Failed to start displaying ad for " + this.f6215d + " due to: " + th;
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", str);
            this.f6225n.a("show_ad", new MaxErrorImpl(-1, str), (Bundle) null);
            this.f6213b.A().a("MediationAdapterWrapper", "show_ad", th, CollectionUtils.hashMap("adapter_class", this.f6216e.b()));
            a("show_ad");
            this.f6213b.M().a(this.f6216e.b(), "show_ad", this.f6220i);
        }
    }

    void a(final MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, final r4 r4Var, final Activity activity, final g4 g4Var) {
        if (g4Var != null) {
            if (!this.f6227p.get()) {
                com.applovin.impl.sdk.n.h("MediationAdapterWrapper", "Mediation adapter '" + this.f6217f + "' is disabled. Signal collection ads with this adapter is disabled.");
                g4Var.a(new MaxErrorImpl("The adapter (" + this.f6217f + ") is disabled"));
                return;
            }
            MaxAdapter maxAdapter = this.f6218g;
            if (maxAdapter instanceof MaxSignalProvider) {
                final MaxSignalProvider maxSignalProvider = (MaxSignalProvider) maxAdapter;
                b("collect_signal", new Runnable() { // from class: com.applovin.impl.mediation.g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6242a.a(maxSignalProvider, maxAdapterSignalCollectionParameters, activity, r4Var, g4Var);
                    }
                });
                return;
            }
            g4Var.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_NOT_SUPPORTED, "The adapter (" + this.f6217f + ") does not support signal collection"));
            return;
        }
        throw new IllegalArgumentException("No callback specified");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(MaxSignalProvider maxSignalProvider, MaxAdapterSignalCollectionParameters maxAdapterSignalCollectionParameters, Activity activity, r4 r4Var, g4 g4Var) {
        try {
            maxSignalProvider.collectSignal(maxAdapterSignalCollectionParameters, activity, new a(r4Var, g4Var));
        } catch (Throwable th) {
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl("Failed signal collection for " + this.f6215d + " due to: " + th);
            com.applovin.impl.sdk.n.h("MediationAdapterWrapper", maxErrorImpl.getMessage());
            g4Var.a(maxErrorImpl);
            this.f6213b.A().a("MediationAdapterWrapper", "collect_signal", th, CollectionUtils.hashMap("adapter_class", this.f6216e.b()));
            a("collect_signal");
            this.f6213b.M().a(this.f6216e.b(), "collect_signal", this.f6220i);
        }
        if (!g4Var.c() && r4Var.m() == 0) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6214c.a("MediationAdapterWrapper", "Failing signal collection " + r4Var + " since it has 0 timeout");
            }
            g4Var.a(new MaxErrorImpl(MaxAdapterError.ERROR_CODE_SIGNAL_COLLECTION_TIMEOUT, "The adapter (" + this.f6217f + ") has 0 timeout"));
        }
    }

    void a() {
        if (this.f6230s) {
            return;
        }
        b("destroy", new Runnable() { // from class: com.applovin.impl.mediation.h0
            @Override // java.lang.Runnable
            public final void run() {
                this.f6253a.l();
            }
        });
    }

    private void a(a3 a3Var, q2 q2Var) {
        a(new d(this, null), a3Var, q2Var);
    }

    private void a(w4 w4Var, a3 a3Var, q2 q2Var) {
        long jM = a3Var.m();
        if (jM <= 0) {
            if (com.applovin.impl.sdk.n.a()) {
                com.applovin.impl.sdk.n nVar = this.f6214c;
                StringBuilder sb = new StringBuilder();
                sb.append("Non-positive timeout set for ");
                if (q2Var != null) {
                    a3Var = q2Var;
                }
                sb.append(a3Var);
                sb.append(", not scheduling a timeout");
                nVar.a("MediationAdapterWrapper", sb.toString());
                return;
            }
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            com.applovin.impl.sdk.n nVar2 = this.f6214c;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Setting timeout ");
            sb2.append(jM);
            sb2.append("ms for ");
            if (q2Var != null) {
                a3Var = q2Var;
            }
            sb2.append(a3Var);
            nVar2.a("MediationAdapterWrapper", sb2.toString());
        }
        this.f6213b.j0().a(w4Var, r5.b.TIMEOUT, jM);
    }

    private void a(String str) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6214c.d("MediationAdapterWrapper", "Marking " + this.f6217f + " as disabled due to: " + str);
        }
        this.f6227p.set(false);
    }

    private void a(final String str, MaxAdFormat maxAdFormat, final Runnable runnable) {
        Runnable runnable2 = new Runnable() { // from class: com.applovin.impl.mediation.d0
            @Override // java.lang.Runnable
            public final void run() {
                this.f6138a.a(str, runnable);
            }
        };
        if (a(str, maxAdFormat)) {
            this.f6212a.post(runnable2);
            return;
        }
        f6 f6Var = new f6(this.f6213b, str + ":" + this.f6216e.c(), runnable2);
        if (((Boolean) this.f6213b.a(l4.X)).booleanValue()) {
            this.f6213b.j0().a(f6Var, this.f6216e);
        } else {
            this.f6213b.j0().a(f6Var);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str, Runnable runnable) {
        try {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6214c.a("MediationAdapterWrapper", this.f6217f + ": running " + str + "...");
            }
            runnable.run();
            if (com.applovin.impl.sdk.n.a()) {
                this.f6214c.a("MediationAdapterWrapper", this.f6217f + ": finished " + str + "");
            }
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("MediationAdapterWrapper", "Failed operation " + str + " for " + this.f6215d, th);
            StringBuilder sb = new StringBuilder();
            sb.append("fail_");
            sb.append(str);
            a(sb.toString());
            if (!str.equals("destroy")) {
                this.f6213b.M().a(this.f6216e.b(), str, this.f6220i);
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("is_wrapper", com.ironsource.mediationsdk.metadata.a.f13688g);
            CollectionUtils.putStringIfValid("adapter_class", this.f6216e.b(), mapHashMap);
            this.f6213b.A().a("MediationAdapterWrapper", str, th, mapHashMap);
        }
    }

    private boolean a(String str, MaxAdFormat maxAdFormat) {
        Boolean boolY;
        Boolean boolA0;
        Boolean boolZ;
        MaxAdapter maxAdapter = this.f6218g;
        if (maxAdapter == null) {
            return this.f6216e.r();
        }
        if (MobileAdsBridgeBase.initializeMethodName.equals(str)) {
            Boolean boolShouldInitializeOnUiThread = maxAdapter.shouldInitializeOnUiThread();
            if (boolShouldInitializeOnUiThread != null) {
                return boolShouldInitializeOnUiThread.booleanValue();
            }
        } else if ("collect_signal".equals(str)) {
            Boolean boolShouldCollectSignalsOnUiThread = maxAdapter.shouldCollectSignalsOnUiThread();
            if (boolShouldCollectSignalsOnUiThread != null) {
                return boolShouldCollectSignalsOnUiThread.booleanValue();
            }
        } else if ("load_ad".equals(str) && maxAdFormat != null) {
            q2 q2Var = this.f6220i;
            if (q2Var != null && (boolZ = q2Var.Z()) != null) {
                return boolZ.booleanValue();
            }
            Boolean boolShouldLoadAdsOnUiThread = maxAdapter.shouldLoadAdsOnUiThread(maxAdFormat);
            if (boolShouldLoadAdsOnUiThread != null) {
                return boolShouldLoadAdsOnUiThread.booleanValue();
            }
        } else if ("show_ad".equals(str) && maxAdFormat != null) {
            q2 q2Var2 = this.f6220i;
            if (q2Var2 != null && (boolA0 = q2Var2.a0()) != null) {
                return boolA0.booleanValue();
            }
            Boolean boolShouldShowAdsOnUiThread = maxAdapter.shouldShowAdsOnUiThread(maxAdFormat);
            if (boolShouldShowAdsOnUiThread != null) {
                return boolShouldShowAdsOnUiThread.booleanValue();
            }
        } else if ("destroy".equals(str)) {
            q2 q2Var3 = this.f6220i;
            if (q2Var3 != null && (boolY = q2Var3.Y()) != null) {
                return boolY.booleanValue();
            }
            Boolean boolShouldDestroyOnUiThread = maxAdapter.shouldDestroyOnUiThread();
            if (boolShouldDestroyOnUiThread != null) {
                return boolShouldDestroyOnUiThread.booleanValue();
            }
            return true;
        }
        return this.f6216e.r();
    }
}
