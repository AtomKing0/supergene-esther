package com.applovin.impl;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f4882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final AppLovinAdServiceImpl f4883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AppLovinAd f4884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f4885e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private SoftReference f4886f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f4888h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile double f4890j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f4881a = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f4887g = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile boolean f4889i = false;

    class a implements AppLovinAdRewardListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().b("IncentivizedAdController", "User over quota: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().b("IncentivizedAdController", "Reward rejected: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().a("IncentivizedAdController", "Reward validated: " + map);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i10) {
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().b("IncentivizedAdController", "Reward validation failed: " + i10);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class b implements AppLovinAdLoadListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinAdLoadListener f4892a;

        b(AppLovinAdLoadListener appLovinAdLoadListener) {
            this.f4892a = appLovinAdLoadListener;
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(final AppLovinAd appLovinAd) {
            b2.this.f4884d = appLovinAd;
            if (this.f4892a != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.n8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6424a.a(appLovinAd);
                    }
                });
            }
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(final int i10) {
            if (this.f4892a != null) {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.o8
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6480a.a(i10);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(AppLovinAd appLovinAd) {
            try {
                this.f4892a.adReceived(appLovinAd);
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinIncentivizedInterstitial", "Unable to notify ad listener about a newly loaded ad", th);
                b2.this.f4882b.A().a("IncentivizedAdController", "adLoaded", th);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a(int i10) {
            try {
                this.f4892a.failedToReceiveAd(i10);
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinIncentivizedInterstitial", "Unable to notify listener about ad load failure", th);
                b2.this.f4882b.A().a("IncentivizedAdController", "adLoadFailed", th);
            }
        }
    }

    private class c implements f2, AppLovinAdVideoPlaybackListener, AppLovinAdRewardListener, AppLovinAdClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AppLovinAd f4894a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AppLovinAdDisplayListener f4895b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final AppLovinAdClickListener f4896c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final AppLovinAdVideoPlaybackListener f4897d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final AppLovinAdRewardListener f4898e;

        /* synthetic */ c(b2 b2Var, AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener, a aVar) {
            this(appLovinAd, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        }

        private void a(com.applovin.impl.sdk.ad.b bVar) {
            String str;
            int i10;
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().a("IncentivizedAdController", "Finishing direct ad...");
            }
            String strB = b2.this.b();
            if (!StringUtils.isValidString(strB) || !b2.this.f4889i) {
                b2.this.f4882b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    b2.this.f4882b.I().b("IncentivizedAdController", "Invalid reward state - result: " + strB + " and wasFullyEngaged: " + b2.this.f4889i);
                }
                b2.this.f4882b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    b2.this.f4882b.I().a("IncentivizedAdController", "Cancelling any incoming reward requests for this ad");
                }
                bVar.c();
                if (b2.this.f4889i) {
                    b2.this.f4882b.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        b2.this.f4882b.I().b("IncentivizedAdController", "User closed the ad after fully watching but reward validation task did not return on time");
                    }
                    str = "network_timeout";
                    i10 = AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT;
                } else {
                    b2.this.f4882b.I();
                    if (com.applovin.impl.sdk.n.a()) {
                        b2.this.f4882b.I().b("IncentivizedAdController", "User close the ad prematurely");
                    }
                    str = "user_closed_video";
                    i10 = AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO;
                }
                bVar.a(b4.a(str));
                b2.this.f4882b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    b2.this.f4882b.I().a("IncentivizedAdController", "Notifying listener of reward validation failure");
                }
                l2.a(this.f4898e, bVar, i10);
                b2.this.f4882b.g().a(y1.f7803r, bVar, CollectionUtils.hashMap("error_message", str + ", Percentage Watched: " + b2.this.f4890j));
            }
            if (bVar.E0().getAndSet(true)) {
                return;
            }
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().a("IncentivizedAdController", "Scheduling report rewarded ad...");
            }
            b2.this.f4882b.j0().a((w4) new a6(bVar, b2.this.f4882b), r5.b.OTHER);
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            l2.a(this.f4896c, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            l2.a(this.f4895b, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            String str;
            AppLovinAd appLovinAdF = appLovinAd instanceof com.applovin.impl.sdk.ad.c ? ((com.applovin.impl.sdk.ad.c) appLovinAd).f() : appLovinAd;
            if (appLovinAdF instanceof com.applovin.impl.sdk.ad.b) {
                a((com.applovin.impl.sdk.ad.b) appLovinAdF);
            } else {
                if (appLovinAdF == null) {
                    str = "null/expired ad";
                } else {
                    str = "invalid ad of type: " + appLovinAdF;
                }
                b2.this.f4882b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    b2.this.f4882b.I().b("IncentivizedAdController", "Received `adHidden` callback for " + str);
                }
            }
            b2.this.a(appLovinAdF);
            b2.this.f4882b.I();
            if (com.applovin.impl.sdk.n.a()) {
                b2.this.f4882b.I().a("IncentivizedAdController", "Notifying listener of rewarded ad dismissal");
            }
            l2.b(this.f4895b, appLovinAd);
        }

        @Override // com.applovin.impl.f2
        public void onAdDisplayFailed(String str) {
            String str2;
            AppLovinAd appLovinAdF = this.f4894a;
            if (appLovinAdF instanceof com.applovin.impl.sdk.ad.c) {
                appLovinAdF = ((com.applovin.impl.sdk.ad.c) appLovinAdF).f();
            }
            boolean z10 = this.f4895b instanceof f2;
            if (appLovinAdF instanceof com.applovin.impl.sdk.ad.b) {
                a((com.applovin.impl.sdk.ad.b) appLovinAdF);
            } else {
                if (appLovinAdF == null) {
                    str2 = "null/expired ad";
                } else {
                    str2 = "invalid ad of type: " + appLovinAdF;
                }
                b2.this.f4882b.I();
                if (com.applovin.impl.sdk.n.a()) {
                    com.applovin.impl.sdk.n nVarI = b2.this.f4882b.I();
                    StringBuilder sb = new StringBuilder();
                    sb.append("Received `");
                    sb.append(z10 ? "adDisplayFailed" : "adHidden");
                    sb.append("` callback for ");
                    sb.append(str2);
                    nVarI.b("IncentivizedAdController", sb.toString());
                }
            }
            b2.this.a(appLovinAdF);
            if (z10) {
                l2.a(this.f4895b, str);
            } else {
                l2.b(this.f4895b, this.f4894a);
            }
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userOverQuota(AppLovinAd appLovinAd, Map map) {
            b2.this.a("quota_exceeded");
            l2.b(this.f4898e, appLovinAd, map);
            b2.this.f4882b.g().a(y1.f7801q, (com.applovin.impl.sdk.ad.b) appLovinAd, CollectionUtils.hashMap("error_message", "quota_exceeded"));
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
            b2.this.a("rejected");
            l2.a(this.f4898e, appLovinAd, map);
            b2.this.f4882b.g().a(y1.f7801q, (com.applovin.impl.sdk.ad.b) appLovinAd, CollectionUtils.hashMap("error_message", "rejected"));
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
            b2.this.a("accepted");
            l2.c(this.f4898e, appLovinAd, map);
        }

        @Override // com.applovin.sdk.AppLovinAdRewardListener
        public void validationRequestFailed(AppLovinAd appLovinAd, int i10) {
            b2.this.a("network_timeout");
            l2.a(this.f4898e, appLovinAd, i10);
            b2.this.f4882b.g().a(y1.f7801q, (com.applovin.impl.sdk.ad.b) appLovinAd, CollectionUtils.hashMap("error_message", "network_timeout"));
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackBegan(AppLovinAd appLovinAd) {
            l2.a(this.f4897d, appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdVideoPlaybackListener
        public void videoPlaybackEnded(AppLovinAd appLovinAd, double d10, boolean z10) {
            l2.a(this.f4897d, appLovinAd, d10, z10);
            b2.this.f4890j = d10;
            b2.this.f4889i = z10;
        }

        private c(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
            this.f4894a = appLovinAd;
            this.f4895b = appLovinAdDisplayListener;
            this.f4896c = appLovinAdClickListener;
            this.f4897d = appLovinAdVideoPlaybackListener;
            this.f4898e = appLovinAdRewardListener;
        }
    }

    public b2(String str, AppLovinSdk appLovinSdk) {
        this.f4882b = appLovinSdk.a();
        this.f4883c = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f4885e = str;
    }

    private void e() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        SoftReference softReference = this.f4886f;
        if (softReference == null || (appLovinAdLoadListener = (AppLovinAdLoadListener) softReference.get()) == null) {
            return;
        }
        appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
    }

    public boolean d() {
        return this.f4884d != null;
    }

    public String c() {
        return this.f4885e;
    }

    public void b(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f4882b.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f4882b.I().a("IncentivizedAdController", "User requested preload of incentivized ad...");
        }
        this.f4886f = new SoftReference(appLovinAdLoadListener);
        if (d()) {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f4884d);
                return;
            }
            return;
        }
        a(new b(appLovinAdLoadListener));
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f4883c.loadNextIncentivizedAd(this.f4885e, appLovinAdLoadListener);
    }

    private void a(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.f4884d;
        }
        AppLovinAdImpl appLovinAdImpl2 = appLovinAdImpl;
        if (appLovinAdImpl2 != null) {
            a(appLovinAdImpl2, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
        }
    }

    public void b(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (appLovinAdRewardListener == null) {
            appLovinAdRewardListener = a();
        }
        a(appLovinAd, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    public void b(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        a(appLovinAd, viewGroup, lifecycle, context, appLovinAdRewardListener == null ? a() : appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }

    private void a(AppLovinAd appLovinAd, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdImpl appLovinAdImpl;
        if (appLovinAd != null) {
            appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        } else {
            appLovinAdImpl = (AppLovinAdImpl) this.f4884d;
        }
        if (appLovinAdImpl != null) {
            a(appLovinAdImpl, viewGroup, lifecycle, context, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        } else {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        String str;
        synchronized (this.f4887g) {
            str = this.f4888h;
        }
        return str;
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f4882b.j0().a((w4) new g6(bVar, appLovinAdRewardListener, this.f4882b), r5.b.OTHER);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        synchronized (this.f4887g) {
            this.f4888h = str;
        }
    }

    public void a(String str, Object obj) {
        this.f4881a.put(str, obj);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        c cVar = new c(this, appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
        AppLovinAd appLovinAdA = z6.a(appLovinAdImpl, this.f4882b);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, cVar, cVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.f4882b.r0(), context);
        for (String str : this.f4881a.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.f4881a.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(cVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, cVar);
    }

    private void a(AppLovinAdImpl appLovinAdImpl, ViewGroup viewGroup, Lifecycle lifecycle, Context context, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        c cVar = new c(this, appLovinAdImpl, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, null);
        AppLovinAd appLovinAdA = z6.a(appLovinAdImpl, this.f4882b);
        String strA = a(appLovinAdA, appLovinAdImpl);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAdImpl, strA, cVar, cVar);
            return;
        }
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialogCreate = AppLovinInterstitialAd.create(this.f4882b.r0(), context);
        for (String str : this.f4881a.keySet()) {
            appLovinInterstitialAdDialogCreate.setExtraInfo(str, this.f4881a.get(str));
        }
        appLovinInterstitialAdDialogCreate.setAdDisplayListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdVideoPlaybackListener(cVar);
        appLovinInterstitialAdDialogCreate.setAdClickListener(cVar);
        appLovinInterstitialAdDialogCreate.showAndRender(appLovinAdA, viewGroup, lifecycle);
        a((com.applovin.impl.sdk.ad.b) appLovinAdA, cVar);
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2) {
        if (appLovinAd == null) {
            com.applovin.impl.sdk.n.h("IncentivizedAdController", "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.: " + appLovinAd2);
            return "Unable to retrieve the loaded ad. This can occur when attempting to show an expired ad.";
        }
        if (appLovinAd2.getType() == AppLovinAdType.INCENTIVIZED) {
            return null;
        }
        com.applovin.impl.sdk.n.h("IncentivizedAdController", "Attempting to display ad with invalid ad type: " + appLovinAd2.getType());
        return "Attempting to display ad with invalid ad type";
    }

    private void a(AppLovinAd appLovinAd, String str, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, f2 f2Var) {
        this.f4882b.E().c(v1.f7565o);
        l2.a(appLovinAdVideoPlaybackListener, appLovinAd, 0.0d, false);
        l2.a(f2Var, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAd2 = this.f4884d;
        if (appLovinAd2 == null) {
            return;
        }
        if (!(appLovinAd2 instanceof com.applovin.impl.sdk.ad.c)) {
            if (appLovinAd == appLovinAd2) {
                this.f4884d = null;
            }
        } else {
            com.applovin.impl.sdk.ad.c cVar = (com.applovin.impl.sdk.ad.c) appLovinAd2;
            if (cVar.f() == null || appLovinAd == cVar.f()) {
                this.f4884d = null;
            }
        }
    }

    private AppLovinAdRewardListener a() {
        return new a();
    }
}
