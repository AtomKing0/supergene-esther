package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;

/* JADX INFO: loaded from: classes4.dex */
public class m5 extends n7 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final m5 f13126d = new m5();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LevelPlayBannerListener f13127b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LevelPlayBannerListener f13128c = null;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13129a;

        a(AdInfo adInfo) {
            this.f13129a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13127b != null) {
                m5.this.f13127b.onAdLeftApplication(m5.this.a(this.f13129a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + m5.this.a(this.f13129a));
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13131a;

        b(AdInfo adInfo) {
            this.f13131a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13128c != null) {
                m5.this.f13128c.onAdClicked(m5.this.a(this.f13131a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + m5.this.a(this.f13131a));
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13133a;

        c(AdInfo adInfo) {
            this.f13133a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13127b != null) {
                m5.this.f13127b.onAdClicked(m5.this.a(this.f13133a));
                IronLog.CALLBACK.info("onAdClicked() adInfo = " + m5.this.a(this.f13133a));
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13135a;

        d(AdInfo adInfo) {
            this.f13135a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13128c != null) {
                m5.this.f13128c.onAdLoaded(m5.this.a(this.f13135a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + m5.this.a(this.f13135a));
            }
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13137a;

        e(AdInfo adInfo) {
            this.f13137a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13127b != null) {
                m5.this.f13127b.onAdLoaded(m5.this.a(this.f13137a));
                IronLog.CALLBACK.info("onAdLoaded() adInfo = " + m5.this.a(this.f13137a));
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f13139a;

        f(IronSourceError ironSourceError) {
            this.f13139a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13128c != null) {
                m5.this.f13128c.onAdLoadFailed(this.f13139a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f13139a.getErrorMessage());
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ IronSourceError f13141a;

        g(IronSourceError ironSourceError) {
            this.f13141a = ironSourceError;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13127b != null) {
                m5.this.f13127b.onAdLoadFailed(this.f13141a);
                IronLog.CALLBACK.info("onAdLoadFailed() error = " + this.f13141a.getErrorMessage());
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13143a;

        h(AdInfo adInfo) {
            this.f13143a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13128c != null) {
                m5.this.f13128c.onAdScreenPresented(m5.this.a(this.f13143a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + m5.this.a(this.f13143a));
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13145a;

        i(AdInfo adInfo) {
            this.f13145a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13127b != null) {
                m5.this.f13127b.onAdScreenPresented(m5.this.a(this.f13145a));
                IronLog.CALLBACK.info("onAdScreenPresented() adInfo = " + m5.this.a(this.f13145a));
            }
        }
    }

    class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13147a;

        j(AdInfo adInfo) {
            this.f13147a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13128c != null) {
                m5.this.f13128c.onAdScreenDismissed(m5.this.a(this.f13147a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + m5.this.a(this.f13147a));
            }
        }
    }

    class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13149a;

        k(AdInfo adInfo) {
            this.f13149a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13127b != null) {
                m5.this.f13127b.onAdScreenDismissed(m5.this.a(this.f13149a));
                IronLog.CALLBACK.info("onAdScreenDismissed() adInfo = " + m5.this.a(this.f13149a));
            }
        }
    }

    class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdInfo f13151a;

        l(AdInfo adInfo) {
            this.f13151a = adInfo;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (m5.this.f13128c != null) {
                m5.this.f13128c.onAdLeftApplication(m5.this.a(this.f13151a));
                IronLog.CALLBACK.info("onAdLeftApplication() adInfo = " + m5.this.a(this.f13151a));
            }
        }
    }

    private m5() {
    }

    public static m5 a() {
        return f13126d;
    }

    public LevelPlayBannerListener b() {
        return this.f13127b;
    }

    public void c(AdInfo adInfo) {
        if (this.f13128c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new l(adInfo));
        } else if (this.f13127b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new a(adInfo));
        }
    }

    public void d(AdInfo adInfo) {
        if (this.f13128c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new d(adInfo));
        } else if (this.f13127b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new e(adInfo));
        }
    }

    public void e(AdInfo adInfo) {
        if (this.f13128c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new j(adInfo));
        } else if (this.f13127b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new k(adInfo));
        }
    }

    public void f(AdInfo adInfo) {
        if (this.f13128c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new h(adInfo));
        } else if (this.f13127b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new i(adInfo));
        }
    }

    public void a(IronSourceError ironSourceError) {
        if (this.f13128c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new f(ironSourceError));
        } else if (this.f13127b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new g(ironSourceError));
        }
    }

    public void b(AdInfo adInfo) {
        if (this.f13128c != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(adInfo));
        } else if (this.f13127b != null) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new c(adInfo));
        }
    }

    public void a(LevelPlayBannerListener levelPlayBannerListener) {
        this.f13127b = levelPlayBannerListener;
    }

    public void b(LevelPlayBannerListener levelPlayBannerListener) {
        this.f13128c = levelPlayBannerListener;
    }
}
