package com.applovin.impl;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinBidTokenCollectionListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.bt;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5583a = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f5584b = true;

    public static void a(boolean z10) {
        f5584b = z10;
    }

    public static void b(boolean z10) {
        f5583a = z10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, String str) {
        try {
            appLovinBidTokenCollectionListener.onBidTokenCollected(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify bid token listener about successful bid token collection", th);
            c("onBidTokenCollected", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, String str) {
        try {
            appLovinBidTokenCollectionListener.onBidTokenCollectionFailed(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify bid token listener about bid token collection failure", th);
            c("onBidTokenCollectionFailed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adLeftApplication(a(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adOpenedFullscreen(a(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
        }
    }

    public static void a(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, final String str) {
        if (appLovinBidTokenCollectionListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.oa
                @Override // java.lang.Runnable
                public final void run() {
                    l2.c(appLovinBidTokenCollectionListener, str);
                }
            });
        }
    }

    public static void b(final AppLovinBidTokenCollectionListener appLovinBidTokenCollectionListener, final String str) {
        if (appLovinBidTokenCollectionListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.fb
                @Override // java.lang.Runnable
                public final void run() {
                    l2.d(appLovinBidTokenCollectionListener, str);
                }
            });
        }
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final String str) {
        if (appLovinAdDisplayListener instanceof f2) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.pa
                @Override // java.lang.Runnable
                public final void run() {
                    l2.b(appLovinAdDisplayListener, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdDisplayListener appLovinAdDisplayListener, String str) {
        ((f2) appLovinAdDisplayListener).onAdDisplayFailed(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userOverQuota(a(appLovinAd), map);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardVerified(a(appLovinAd), map);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
        }
    }

    public static void b(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.pb
            @Override // java.lang.Runnable
            public final void run() {
                l2.d(appLovinAdDisplayListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adDisplayed(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
            c("adDisplayed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adHidden(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
            c("adHidden", th);
        }
    }

    public static void a(final AppLovinAdDisplayListener appLovinAdDisplayListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdDisplayListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ma
            @Override // java.lang.Runnable
            public final void run() {
                l2.c(appLovinAdDisplayListener, appLovinAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdClickListener.adClicked(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
            c("adClicked", th);
        }
    }

    public static void e(MaxAdListener maxAdListener, MaxAd maxAd) {
        e(maxAdListener, maxAd, false);
    }

    public static void f(MaxAdListener maxAdListener, MaxAd maxAd) {
        f(maxAdListener, maxAd, false);
    }

    public static void a(final AppLovinAdClickListener appLovinAdClickListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdClickListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ha
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(appLovinAdClickListener, appLovinAd);
            }
        });
    }

    public static void e(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ob
            @Override // java.lang.Runnable
            public final void run() {
                l2.e(z10, maxAdListener, maxAd);
            }
        });
    }

    public static void f(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.eb
            @Override // java.lang.Runnable
            public final void run() {
                l2.f(z10, maxAdListener, maxAd);
            }
        });
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.kb
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(appLovinAdVideoPlaybackListener, appLovinAd);
            }
        });
    }

    public static void c(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.qa
            @Override // java.lang.Runnable
            public final void run() {
                l2.f(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adClosedFullscreen(a(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxAdListener.onAdHidden(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdHidden", th, z10);
                b("maxAdHidden", th, z10);
                return;
            }
        }
        maxAdListener.onAdHidden(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxAdListener.onAdLoaded(maxAd);
                return;
            } catch (Throwable th) {
                a(bt.f11470j, th, z10);
                b("maxAdLoaded", th, z10);
                return;
            }
        }
        maxAdListener.onAdLoaded(maxAd);
    }

    public static void a(final AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, final AppLovinAd appLovinAd, final double d10, final boolean z10) {
        if (appLovinAd == null || appLovinAdVideoPlaybackListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.cb
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(appLovinAdVideoPlaybackListener, appLovinAd, d10, z10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackBegan(a(appLovinAd));
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
        }
    }

    public static void c(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.lb
            @Override // java.lang.Runnable
            public final void run() {
                l2.f(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ia
            @Override // java.lang.Runnable
            public final void run() {
                l2.d(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void c(MaxAdListener maxAdListener, MaxAd maxAd) {
        c(maxAdListener, maxAd, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardRejected(a(appLovinAd), map);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
        }
    }

    public static void a(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView, final AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ua
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinAdViewDisplayErrorCode);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d10, boolean z10) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(a(appLovinAd), d10, z10);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
        }
    }

    public static void c(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.na
            @Override // java.lang.Runnable
            public final void run() {
                l2.c(z10, maxAdListener, maxAd);
            }
        });
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.hb
            @Override // java.lang.Runnable
            public final void run() {
                l2.d(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxAdListener.onAdDisplayed(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdDisplayed", th, z10);
                b("maxAdDisplayed", th, z10);
                return;
            }
        }
        maxAdListener.onAdDisplayed(maxAd);
    }

    public static void d(MaxAdListener maxAdListener, MaxAd maxAd) {
        d(maxAdListener, maxAd, false);
    }

    public static void a(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final int i10) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.db
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(appLovinAdRewardListener, appLovinAd, i10);
            }
        });
    }

    public static void b(final AppLovinAdViewEventListener appLovinAdViewEventListener, final AppLovinAd appLovinAd, final AppLovinAdView appLovinAdView) {
        if (appLovinAd == null || appLovinAdViewEventListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ja
            @Override // java.lang.Runnable
            public final void run() {
                l2.e(appLovinAdViewEventListener, appLovinAd, appLovinAdView);
            }
        });
    }

    public static void d(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.nb
            @Override // java.lang.Runnable
            public final void run() {
                l2.d(z10, maxAdListener, maxAd);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        a(maxAdListener, str, maxError, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        try {
            appLovinAdViewEventListener.adFailedToDisplay(a(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th);
        }
    }

    public static void a(final MaxAdListener maxAdListener, final String str, final MaxError maxError, final boolean z10) {
        if (str == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ga
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdListener, str, maxError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdExpanded", th, z10);
                b("maxAdExpanded", th, z10);
                return;
            }
        }
        ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdListener maxAdListener, String str, MaxError maxError) {
        if (c(z10)) {
            try {
                maxAdListener.onAdLoadFailed(str, maxError);
                return;
            } catch (Throwable th) {
                a(bt.f11462b, th, z10);
                b("maxAdLoadFailed", th, z10);
                return;
            }
        }
        maxAdListener.onAdLoadFailed(str, maxError);
    }

    public static void b(final AppLovinAdRewardListener appLovinAdRewardListener, final AppLovinAd appLovinAd, final Map map) {
        if (appLovinAd == null || appLovinAdRewardListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.za
            @Override // java.lang.Runnable
            public final void run() {
                l2.e(appLovinAdRewardListener, appLovinAd, map);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i10) {
        try {
            appLovinAdRewardListener.validationRequestFailed(a(appLovinAd), i10);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
        }
    }

    private static boolean c(boolean z10) {
        return z10 ? f5583a : f5584b;
    }

    private static void c(String str, Throwable th) {
        com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
        if (jVar != null) {
            jVar.A().a("ListenerCallbackInvoker", str, th);
        }
    }

    public static void b(MaxAdListener maxAdListener, MaxAd maxAd) {
        b(maxAdListener, maxAd, false);
    }

    public static void b(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || !(maxAdListener instanceof MaxAdViewAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.gb
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(z10, maxAdListener, maxAd);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd) {
        a(maxAdListener, maxAd, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ya
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdCollapsed", th, z10);
                b("maxAdCollapsed", th, z10);
                return;
            }
        }
        ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxAdListener.onAdClicked(maxAd);
                return;
            } catch (Throwable th) {
                a(bt.f11466f, th, z10);
                b("maxAdClicked", th, z10);
                return;
            }
        }
        maxAdListener.onAdClicked(maxAd);
    }

    public static void b(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.va
            @Override // java.lang.Runnable
            public final void run() {
                l2.b(z10, maxNativeAdListener, maxAd);
            }
        });
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        a(maxAdListener, maxAd, maxError, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z10, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxNativeAdListener.onNativeAdExpired(maxAd);
                return;
            } catch (Throwable th) {
                a("onNativeAdExpired", th, z10);
                b("maxNativeAdExpired", th, z10);
                return;
            }
        }
        maxNativeAdListener.onNativeAdExpired(maxAd);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxError maxError, final boolean z10) {
        if (maxAd == null || maxAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.la
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdListener, maxAd, maxError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        if (c(z10)) {
            try {
                maxAdListener.onAdDisplayFailed(maxAd, maxError);
                return;
            } catch (Throwable th) {
                a("onAdDisplayFailed", th, z10);
                b("maxAdDisplayFailed", th, z10);
                return;
            }
        }
        maxAdListener.onAdDisplayFailed(maxAd, maxError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str) {
        try {
            appLovinPostbackListener.onPostbackSuccess(str);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th);
        }
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        a(maxAdRevenueListener, maxAd, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str, int i10) {
        try {
            appLovinPostbackListener.onPostbackFailure(str, i10);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i10 + "):", th);
        }
    }

    public static void a(final MaxAdRevenueListener maxAdRevenueListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxAdRevenueListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ta
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdRevenueListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxAdRevenueListener.onAdRevenuePaid(maxAd);
                return;
            } catch (Throwable th) {
                a("onAdRevenuePaid", th, z10);
                b("maxAdPaidRevenue", th, z10);
                return;
            }
        }
        maxAdRevenueListener.onAdRevenuePaid(maxAd);
    }

    public static void b(final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, final AppLovinError appLovinError) {
        if (appLovinNativeAdLoadListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.xa
                @Override // java.lang.Runnable
                public final void run() {
                    l2.a(appLovinNativeAdLoadListener, appLovinError);
                }
            });
        }
    }

    public static void b(final AppLovinNativeAdEventListener appLovinNativeAdEventListener, final AppLovinNativeAd appLovinNativeAd) {
        if (appLovinNativeAdEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sa
                @Override // java.lang.Runnable
                public final void run() {
                    l2.a(appLovinNativeAdEventListener, appLovinNativeAd);
                }
            });
        }
    }

    public static void b(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        a(maxAdReviewListener, str, maxAd, false);
    }

    private static void b(String str, Throwable th) {
        com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Error in publisher callback '" + str + "'", th);
    }

    private static void b(String str, Throwable th, boolean z10) {
        if (com.applovin.impl.sdk.j.f7084v0 != null) {
            com.applovin.impl.sdk.j.f7084v0.A().a("ListenerCallbackInvoker", str, th, CollectionUtils.hashMap("details", "isPublisherCallback=" + z10));
        }
    }

    public static void a(MaxAdRequestListener maxAdRequestListener, String str) {
        a(maxAdRequestListener, str, false);
    }

    public static void a(final MaxAdRequestListener maxAdRequestListener, final String str, final boolean z10) {
        if (str == null || maxAdRequestListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ib
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdRequestListener, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdRequestListener maxAdRequestListener, String str) {
        if (c(z10)) {
            try {
                maxAdRequestListener.onAdRequestStarted(str);
                return;
            } catch (Throwable th) {
                a("onAdRequestStarted", th, z10);
                b("maxAdRequestStarted", th, z10);
                return;
            }
        }
        maxAdRequestListener.onAdRequestStarted(str);
    }

    public static void a(final MaxAdExpirationListener maxAdExpirationListener, final MaxAd maxAd, final MaxAd maxAd2, final boolean z10) {
        if (maxAd == null || maxAd2 == null || maxAdExpirationListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ka
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdExpirationListener, maxAd, maxAd2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdExpirationListener maxAdExpirationListener, MaxAd maxAd, MaxAd maxAd2) {
        if (c(z10)) {
            try {
                maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
                return;
            } catch (Throwable th) {
                a("onExpiredAdReloaded", th, z10);
                b("maxExpiredAdReloaded", th, z10);
                return;
            }
        }
        maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        a(maxAdListener, maxAd, maxReward, false);
    }

    public static void a(final MaxAdListener maxAdListener, final MaxAd maxAd, final MaxReward maxReward, final boolean z10) {
        if (maxAd == null || !(maxAdListener instanceof MaxRewardedAdListener)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.qb
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxAdListener, maxAd, maxReward);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        if (c(z10)) {
            try {
                ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
                return;
            } catch (Throwable th) {
                a("onUserRewarded", th, z10);
                b("maxRewardedUser", th, z10);
                return;
            }
        }
        ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxNativeAdView maxNativeAdView, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.ab
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxNativeAdListener, maxNativeAdView, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxNativeAdListener maxNativeAdListener, MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
                return;
            } catch (Throwable th) {
                a("onNativeAdLoaded", th, z10);
                b("maxNativeAdLoaded", th, z10);
                return;
            }
        }
        maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final String str, final MaxError maxError, final boolean z10) {
        if (str == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.wa
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxNativeAdListener, str, maxError);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxNativeAdListener maxNativeAdListener, String str, MaxError maxError) {
        if (c(z10)) {
            try {
                maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
                return;
            } catch (Throwable th) {
                a("onNativeAdLoadFailed", th, z10);
                b("maxNativeAdLoadFailed", th, z10);
                return;
            }
        }
        maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
    }

    public static void a(final MaxNativeAdListener maxNativeAdListener, final MaxAd maxAd, final boolean z10) {
        if (maxAd == null || maxNativeAdListener == null) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.jb
            @Override // java.lang.Runnable
            public final void run() {
                l2.a(z10, maxNativeAdListener, maxAd);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z10, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (c(z10)) {
            try {
                maxNativeAdListener.onNativeAdClicked(maxAd);
                return;
            } catch (Throwable th) {
                a("onNativeAdClicked", th, z10);
                b("maxNativeAdClicked", th, z10);
                return;
            }
        }
        maxNativeAdListener.onNativeAdClicked(maxAd);
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.mb
                @Override // java.lang.Runnable
                public final void run() {
                    l2.b(appLovinPostbackListener, str);
                }
            });
        }
    }

    public static void a(final AppLovinPostbackListener appLovinPostbackListener, final String str, final int i10) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.ra
                @Override // java.lang.Runnable
                public final void run() {
                    l2.b(appLovinPostbackListener, str, i10);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, AppLovinError appLovinError) {
        try {
            appLovinNativeAdLoadListener.onNativeAdLoadFailed(appLovinError);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad failing to load", th);
            c("nativeAdLoadFailed", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(AppLovinNativeAdEventListener appLovinNativeAdEventListener, AppLovinNativeAd appLovinNativeAd) {
        try {
            appLovinNativeAdEventListener.onNativeAdClicked(appLovinNativeAd);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad click", th);
            c("nativeAdClicked", th);
        }
    }

    public static void a(final MaxAdReviewListener maxAdReviewListener, final String str, final MaxAd maxAd, boolean z10) {
        if (maxAdReviewListener != null) {
            AppLovinSdkUtils.runOnUiThread(z10, new Runnable() { // from class: com.applovin.impl.bb
                @Override // java.lang.Runnable
                public final void run() {
                    l2.a(maxAdReviewListener, str, maxAd);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        try {
            maxAdReviewListener.onCreativeIdGenerated(str, maxAd);
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ListenerCallbackInvoker", "Unable to notify Ad Review creative id generated", th);
            c("adReviewCreativeIdGenerated", th);
        }
    }

    private static AppLovinAd a(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        return appLovinAdImpl.getDummyAd() != null ? appLovinAdImpl.getDummyAd() : appLovinAd;
    }

    private static void a(String str, Throwable th, boolean z10) {
        if (z10) {
            b(str, th);
        } else {
            a(str, th);
        }
    }

    private static void a(String str, Throwable th) {
        com.applovin.impl.sdk.n.b("ListenerCallbackInvoker", "Error in internal callback '" + str + "'", th);
    }
}
