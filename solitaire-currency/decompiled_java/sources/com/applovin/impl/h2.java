package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.StrictMode;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.Lifecycle;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.adview.AppLovinFullscreenAdViewObserver;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.p1;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class h2 implements AppLovinInterstitialAdDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f5316a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WeakReference f5317b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f5318c = Collections.synchronizedMap(new HashMap());

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile AppLovinAdLoadListener f5319d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile AppLovinAdDisplayListener f5320e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile AppLovinAdVideoPlaybackListener f5321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile AppLovinAdClickListener f5322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile com.applovin.impl.sdk.ad.b f5323h;

    class a implements AppLovinAdLoadListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void adReceived(AppLovinAd appLovinAd) {
            h2.this.b(appLovinAd);
            h2.this.showAndRender(appLovinAd);
        }

        @Override // com.applovin.sdk.AppLovinAdLoadListener
        public void failedToReceiveAd(int i10) {
            h2.this.b(i10);
        }
    }

    public h2(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        if (context == null) {
            throw new IllegalArgumentException("No context specified");
        }
        this.f5316a = appLovinSdk.a();
        this.f5317b = new WeakReference(context);
    }

    private long g() {
        String str = this.f5316a.g0().getExtraParameters().get("fullscreen_ad_display_delay_enabled");
        if (str == null || Boolean.parseBoolean(str)) {
            return Math.max(0L, ((Long) this.f5316a.a(l4.M1)).longValue());
        }
        return 0L;
    }

    private void i() {
        if (this.f5316a.e().a() == null) {
            this.f5316a.E().c(v1.f7568r);
        }
    }

    public com.applovin.impl.sdk.ad.b f() {
        return this.f5323h;
    }

    public Map h() {
        return this.f5318c;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f5322g = appLovinAdClickListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f5320e = appLovinAdDisplayListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5319d = appLovinAdLoadListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f5321f = appLovinAdVideoPlaybackListener;
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void setExtraInfo(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No key specified");
        }
        this.f5318c.put(str, obj);
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void show() {
        a(new a());
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd) {
        AppLovinAd appLovinAdA = z6.a(appLovinAd, this.f5316a);
        Context contextE = e();
        String strA = a(appLovinAdA, appLovinAd, contextE);
        if (StringUtils.isValidString(strA)) {
            a(appLovinAd, strA);
        } else {
            a((com.applovin.impl.sdk.ad.b) appLovinAdA, contextE);
        }
    }

    public String toString() {
        return "AppLovinInterstitialAdDialog{}";
    }

    private Context e() {
        return (Context) this.f5317b.get();
    }

    public AppLovinAdDisplayListener c() {
        return this.f5320e;
    }

    public AppLovinAdVideoPlaybackListener d() {
        return this.f5321f;
    }

    public AppLovinAdClickListener b() {
        return this.f5322g;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(Context context) {
        Intent intent = new Intent(context, (Class<?>) AppLovinFullscreenActivity.class);
        intent.putExtra("com.applovin.interstitial.sdk_key", this.f5316a.b0());
        AppLovinFullscreenActivity.parentInterstitialWrapper = this;
        if (this.f5316a.e().a() == null && ((Boolean) this.f5316a.a(l4.f5681l2)).booleanValue()) {
            intent.addFlags(8388608);
        }
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        if (context instanceof Activity) {
            context.startActivity(intent);
            ((Activity) context).overridePendingTransition(0, 0);
        } else {
            intent.addFlags(268435456);
            context.startActivity(intent);
        }
        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Lifecycle lifecycle, AppLovinAd appLovinAd, ViewGroup viewGroup, Context context) {
        a((com.applovin.impl.sdk.ad.b) appLovinAd, viewGroup, new AppLovinFullscreenAdViewObserver(lifecycle, this), context);
    }

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdDisplayListener appLovinAdDisplayListener, String str, Throwable th, AppLovinFullscreenActivity appLovinFullscreenActivity) {
        com.applovin.impl.sdk.n.c("InterstitialAdDialogWrapper", str, th);
        if (appLovinAdDisplayListener instanceof f2) {
            l2.a(appLovinAdDisplayListener, str);
        } else {
            l2.b(appLovinAdDisplayListener, bVar);
        }
        if (appLovinFullscreenActivity != null) {
            appLovinFullscreenActivity.dismiss();
        }
    }

    @Override // com.applovin.adview.AppLovinInterstitialAdDialog
    public void showAndRender(AppLovinAd appLovinAd, final ViewGroup viewGroup, final Lifecycle lifecycle) {
        if (viewGroup != null && lifecycle != null) {
            final AppLovinAd appLovinAdA = z6.a(appLovinAd, this.f5316a);
            final Context contextE = e();
            String strA = a(appLovinAdA, appLovinAd, contextE);
            if (StringUtils.isValidString(strA)) {
                a(appLovinAd, strA);
                return;
            } else {
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.w9
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f7691a.a(lifecycle, appLovinAdA, viewGroup, contextE);
                    }
                });
                return;
            }
        }
        com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
        a(appLovinAd, "Failed to show interstitial: attempting to show ad with null container view or lifecycle object");
    }

    class b implements p1.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f5325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AppLovinFullscreenAdViewObserver f5326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ViewGroup f5327c;

        b(Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, ViewGroup viewGroup) {
            this.f5325a = context;
            this.f5326b = appLovinFullscreenAdViewObserver;
            this.f5327c = viewGroup;
        }

        @Override // com.applovin.impl.p1.d
        public void a(p1 p1Var) {
            if (d.a((Activity) this.f5325a)) {
                com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: attempting to show ad when parent activity is finishing");
                h2.a(h2.this.f5323h, h2.this.f5320e, "Failed to show interstitial: attempting to show ad when parent activity is finishing", null, null);
                return;
            }
            this.f5326b.setPresenter(p1Var);
            try {
                p1Var.a(this.f5327c);
            } catch (Throwable th) {
                String str = "Failed to show interstitial: presenter threw exception " + th;
                com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", str);
                h2.a(h2.this.f5323h, h2.this.f5320e, str, null, null);
            }
        }

        @Override // com.applovin.impl.p1.d
        public void a(String str, Throwable th) {
            h2.a(h2.this.f5323h, h2.this.f5320e, str, th, null);
        }
    }

    public void a() {
        this.f5322g = null;
        this.f5319d = null;
        this.f5321f = null;
        this.f5320e = null;
    }

    private void a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f5316a.k().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinAdLoadListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final AppLovinAd appLovinAd) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.s9
            @Override // java.lang.Runnable
            public final void run() {
                this.f6835a.a(appLovinAd);
            }
        });
    }

    private String a(AppLovinAd appLovinAd, AppLovinAd appLovinAd2, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Failed to show interstitial: stale activity reference provided");
            return "Failed to show interstitial: stale activity reference provided";
        }
        if (appLovinAd == null) {
            com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Unable to retrieve the loaded ad: " + appLovinAd2);
            return "Unable to retrieve the loaded ad";
        }
        if (!((AppLovinAdImpl) appLovinAd).hasShown() || !((Boolean) this.f5316a.a(l4.f5787z1)).booleanValue()) {
            return null;
        }
        com.applovin.impl.sdk.n.h("InterstitialAdDialogWrapper", "Attempting to show ad again: " + appLovinAd);
        return "Attempting to show ad again";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final int i10) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.u9
            @Override // java.lang.Runnable
            public final void run() {
                this.f7538a.a(i10);
            }
        });
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final Context context) {
        i();
        this.f5316a.f().a(bVar);
        this.f5323h = bVar;
        long jG = g();
        this.f5316a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5316a.I().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + jG + "ms...");
        }
        if (((Boolean) this.f5316a.a(l4.Q0)).booleanValue()) {
            this.f5316a.h().a(this.f5323h);
        }
        new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.v9
            @Override // java.lang.Runnable
            public final void run() {
                this.f7645a.a(context);
            }
        }, jG);
    }

    private void a(com.applovin.impl.sdk.ad.b bVar, final ViewGroup viewGroup, final AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver, final Context context) {
        i();
        this.f5316a.f().a(bVar);
        this.f5323h = bVar;
        long jG = g();
        this.f5316a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5316a.I().a("InterstitialAdDialogWrapper", "Presenting ad with delay " + jG + "ms...");
        }
        if (((Boolean) this.f5316a.a(l4.Q0)).booleanValue()) {
            this.f5316a.h().a(this.f5323h);
        }
        new Handler(context.getMainLooper()).postDelayed(new Runnable() { // from class: com.applovin.impl.t9
            @Override // java.lang.Runnable
            public final void run() {
                this.f7472a.a(viewGroup, context, appLovinFullscreenAdViewObserver);
            }
        }, jG);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(ViewGroup viewGroup, Context context, AppLovinFullscreenAdViewObserver appLovinFullscreenAdViewObserver) {
        this.f5316a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f5316a.I().a("InterstitialAdDialogWrapper", "Presenting ad in a containerView(" + viewGroup + ")");
        }
        viewGroup.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        p1.a(this.f5323h, this.f5322g, this.f5320e, this.f5321f, this.f5318c, this.f5316a, (Activity) context, new b(context, appLovinFullscreenAdViewObserver, viewGroup));
    }

    private void a(AppLovinAd appLovinAd, String str) {
        if (this.f5320e != null) {
            if (this.f5320e instanceof f2) {
                ((f2) this.f5320e).onAdDisplayFailed(str);
            } else {
                this.f5320e.adHidden(appLovinAd);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinAd appLovinAd) {
        if (this.f5319d != null) {
            this.f5319d.adReceived(appLovinAd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(int i10) {
        if (this.f5319d != null) {
            this.f5319d.failedToReceiveAd(i10);
        }
    }
}
