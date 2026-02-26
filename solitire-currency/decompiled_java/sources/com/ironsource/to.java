package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;

/* JADX INFO: loaded from: classes4.dex */
public class to extends n7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final to f15411d = new to();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LevelPlayRewardedVideoBaseListener f15412b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LevelPlayRewardedVideoBaseListener f15413c = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f15414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15415b;

        a(boolean z10, AdInfo adInfo) {
            this.f15414a = z10;
            this.f15415b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog ironLog;
            String str;
            if (to.this.f15412b != null) {
                if (this.f15414a) {
                    ((LevelPlayRewardedVideoListener) to.this.f15412b).onAdAvailable(to.this.a(this.f15415b));
                    ironLog = IronLog.CALLBACK;
                    str = "onAdAvailable() adInfo = " + to.this.a(this.f15415b);
                } else {
                    ((LevelPlayRewardedVideoListener) to.this.f15412b).onAdUnavailable();
                    ironLog = IronLog.CALLBACK;
                    str = "onAdUnavailable()";
                }
                ironLog.info(str);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f15417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15418b;

        b(Placement placement, AdInfo adInfo) {
            this.f15417a = placement;
            this.f15418b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                to.this.f15413c.onAdRewarded(this.f15417a, to.this.a(this.f15418b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f15417a + ", adInfo = " + to.this.a(this.f15418b));
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f15420a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15421b;

        c(Placement placement, AdInfo adInfo) {
            this.f15420a = placement;
            this.f15421b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                to.this.f15412b.onAdRewarded(this.f15420a, to.this.a(this.f15421b));
                IronLog.CALLBACK.info("onAdRewarded() placement = " + this.f15420a + ", adInfo = " + to.this.a(this.f15421b));
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f15423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15424b;

        d(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f15423a = ironSourceError;
            this.f15424b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                to.this.f15413c.onAdShowFailed(this.f15423a, to.this.a(this.f15424b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + to.this.a(this.f15424b) + ", error = " + this.f15423a.getErrorMessage());
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f15426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15427b;

        e(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f15426a = ironSourceError;
            this.f15427b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                to.this.f15412b.onAdShowFailed(this.f15426a, to.this.a(this.f15427b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + to.this.a(this.f15427b) + ", error = " + this.f15426a.getErrorMessage());
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f15429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15430b;

        f(Placement placement, AdInfo adInfo) {
            this.f15429a = placement;
            this.f15430b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                to.this.f15413c.onAdClicked(this.f15429a, to.this.a(this.f15430b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f15429a + ", adInfo = " + to.this.a(this.f15430b));
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Placement f15432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15433b;

        g(Placement placement, AdInfo adInfo) {
            this.f15432a = placement;
            this.f15433b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                to.this.f15412b.onAdClicked(this.f15432a, to.this.a(this.f15433b));
                IronLog.CALLBACK.info("onAdClicked() placement = " + this.f15432a + ", adInfo = " + to.this.a(this.f15433b));
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f15435a;

        h(AdInfo adInfo) {
            this.f15435a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                ((LevelPlayRewardedVideoManualListener) to.this.f15413c).onAdReady(to.this.a(this.f15435a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + to.this.a(this.f15435a));
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f15437a;

        i(AdInfo adInfo) {
            this.f15437a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                ((LevelPlayRewardedVideoManualListener) to.this.f15412b).onAdReady(to.this.a(this.f15437a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + to.this.a(this.f15437a));
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f15439a;

        j(IronSourceError ironSourceError) {
            this.f15439a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                ((LevelPlayRewardedVideoManualListener) to.this.f15413c).onAdLoadFailed(this.f15439a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f15439a.getErrorMessage());
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f15441a;

        k(IronSourceError ironSourceError) {
            this.f15441a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                ((LevelPlayRewardedVideoManualListener) to.this.f15412b).onAdLoadFailed(this.f15441a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f15441a.getErrorMessage());
            }
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f15443a;

        l(AdInfo adInfo) {
            this.f15443a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                to.this.f15413c.onAdOpened(to.this.a(this.f15443a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + to.this.a(this.f15443a));
            }
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f15445a;

        m(AdInfo adInfo) {
            this.f15445a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                to.this.f15412b.onAdOpened(to.this.a(this.f15445a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + to.this.a(this.f15445a));
            }
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f15447a;

        n(AdInfo adInfo) {
            this.f15447a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15413c != null) {
                to.this.f15413c.onAdClosed(to.this.a(this.f15447a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + to.this.a(this.f15447a));
            }
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f15449a;

        o(AdInfo adInfo) {
            this.f15449a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (to.this.f15412b != null) {
                to.this.f15412b.onAdClosed(to.this.a(this.f15449a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + to.this.a(this.f15449a));
            }
        }
    }

    class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f15451a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f15452b;

        p(boolean z10, AdInfo adInfo) {
            this.f15451a = z10;
            this.f15452b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            IronLog ironLog;
            String str;
            if (to.this.f15413c != null) {
                if (this.f15451a) {
                    ((LevelPlayRewardedVideoListener) to.this.f15413c).onAdAvailable(to.this.a(this.f15452b));
                    ironLog = IronLog.CALLBACK;
                    str = "onAdAvailable() adInfo = " + to.this.a(this.f15452b);
                } else {
                    ((LevelPlayRewardedVideoListener) to.this.f15413c).onAdUnavailable();
                    ironLog = IronLog.CALLBACK;
                    str = "onAdUnavailable()";
                }
                ironLog.info(str);
            }
        }
    }

    private to() {
    }

    public void c() {
    }

    public void d(AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.f15412b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
    }

    public static to a() {
        return f15411d;
    }

    public void b() {
    }

    public void c(AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.f15412b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(ironSourceError));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.f15412b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoManualListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(ironSourceError));
    }

    public void b(AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.f15412b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new o(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(ironSourceError, adInfo));
        } else if (this.f15412b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(ironSourceError, adInfo));
        }
    }

    public void b(Placement placement, AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(placement, adInfo));
        } else if (this.f15412b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(placement, adInfo));
        }
    }

    public void a(Placement placement, AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(placement, adInfo));
        } else if (this.f15412b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(placement, adInfo));
        }
    }

    public void b(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.f15413c = levelPlayRewardedVideoBaseListener;
    }

    public void a(LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener) {
        this.f15412b = levelPlayRewardedVideoBaseListener;
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }

    public void a(boolean z10, AdInfo adInfo) {
        if (this.f15413c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new p(z10, adInfo));
            return;
        }
        LevelPlayRewardedVideoBaseListener levelPlayRewardedVideoBaseListener = this.f15412b;
        if (levelPlayRewardedVideoBaseListener == null || !(levelPlayRewardedVideoBaseListener instanceof LevelPlayRewardedVideoListener)) {
            return;
        }
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(z10, adInfo));
    }
}
