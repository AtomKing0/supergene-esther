package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;

/* JADX INFO: loaded from: classes4.dex */
public class gf extends n7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final gf f12235d = new gf();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LevelPlayInterstitialListener f12236b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LevelPlayInterstitialListener f12237c = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12238a;

        a(AdInfo adInfo) {
            this.f12238a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdShowSucceeded(gf.this.a(this.f12238a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + gf.this.a(this.f12238a));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f12240a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f12241b;

        b(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f12240a = ironSourceError;
            this.f12241b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdShowFailed(this.f12240a, gf.this.a(this.f12241b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + gf.this.a(this.f12241b) + ", error = " + this.f12240a.getErrorMessage());
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f12243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ AdInfo f12244b;

        c(IronSourceError ironSourceError, AdInfo adInfo) {
            this.f12243a = ironSourceError;
            this.f12244b = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdShowFailed(this.f12243a, gf.this.a(this.f12244b));
                IronLog.CALLBACK.info("onAdShowFailed() adInfo = " + gf.this.a(this.f12244b) + ", error = " + this.f12243a.getErrorMessage());
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12246a;

        d(AdInfo adInfo) {
            this.f12246a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdClicked(gf.this.a(this.f12246a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + gf.this.a(this.f12246a));
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12248a;

        e(AdInfo adInfo) {
            this.f12248a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdClicked(gf.this.a(this.f12248a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + gf.this.a(this.f12248a));
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12250a;

        f(AdInfo adInfo) {
            this.f12250a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdReady(gf.this.a(this.f12250a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + gf.this.a(this.f12250a));
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12252a;

        g(AdInfo adInfo) {
            this.f12252a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdReady(gf.this.a(this.f12252a));
                IronLog.CALLBACK.info("onAdReady() adInfo = " + gf.this.a(this.f12252a));
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f12254a;

        h(IronSourceError ironSourceError) {
            this.f12254a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdLoadFailed(this.f12254a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f12254a.getErrorMessage());
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f12256a;

        i(IronSourceError ironSourceError) {
            this.f12256a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdLoadFailed(this.f12256a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f12256a.getErrorMessage());
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12258a;

        j(AdInfo adInfo) {
            this.f12258a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdOpened(gf.this.a(this.f12258a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + gf.this.a(this.f12258a));
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12260a;

        k(AdInfo adInfo) {
            this.f12260a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdOpened(gf.this.a(this.f12260a));
                IronLog.CALLBACK.info("onAdOpened() adInfo = " + gf.this.a(this.f12260a));
            }
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12262a;

        l(AdInfo adInfo) {
            this.f12262a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdClosed(gf.this.a(this.f12262a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + gf.this.a(this.f12262a));
            }
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12264a;

        m(AdInfo adInfo) {
            this.f12264a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12236b != null) {
                gf.this.f12236b.onAdClosed(gf.this.a(this.f12264a));
                IronLog.CALLBACK.info("onAdClosed() adInfo = " + gf.this.a(this.f12264a));
            }
        }
    }

    class n implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f12266a;

        n(AdInfo adInfo) {
            this.f12266a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (gf.this.f12237c != null) {
                gf.this.f12237c.onAdShowSucceeded(gf.this.a(this.f12266a));
                IronLog.CALLBACK.info("onAdShowSucceeded() adInfo = " + gf.this.a(this.f12266a));
            }
        }
    }

    private gf() {
    }

    public static synchronized gf a() {
        return f12235d;
    }

    public void c(AdInfo adInfo) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new m(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(adInfo));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new n(adInfo));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public void b(AdInfo adInfo) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(ironSourceError));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(ironSourceError));
        }
    }

    public synchronized void b(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.f12237c = levelPlayInterstitialListener;
    }

    public void a(IronSourceError ironSourceError, AdInfo adInfo) {
        if (this.f12237c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(ironSourceError, adInfo));
        } else if (this.f12236b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(ironSourceError, adInfo));
        }
    }

    public synchronized void a(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        this.f12236b = levelPlayInterstitialListener;
    }

    private void a(String str) {
        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.CALLBACK, str, 1);
    }
}
