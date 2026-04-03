package com.ironsource;

import com.ironsource.bf;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerListener;
import com.ironsource.mediationsdk.logger.IronSourceError;

/* JADX INFO: loaded from: classes4.dex */
public class l5 extends bf.a<ISDemandOnlyBannerListener> {

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ IronSourceError f12970b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f12971c;

        a(String str, IronSourceError ironSourceError, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f12969a = str;
            this.f12970b = ironSourceError;
            this.f12971c = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            l5.this.a(this.f12969a, "onBannerAdLoadFailed() error = " + this.f12970b.getErrorMessage());
            this.f12971c.onBannerAdLoadFailed(this.f12969a, this.f12970b);
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f12974b;

        b(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f12973a = str;
            this.f12974b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            l5.this.a(this.f12973a, "onBannerAdLoaded()");
            this.f12974b.onBannerAdLoaded(this.f12973a);
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f12977b;

        c(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f12976a = str;
            this.f12977b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            l5.this.a(this.f12976a, "onBannerAdShown()");
            this.f12977b.onBannerAdShown(this.f12976a);
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12979a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f12980b;

        d(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f12979a = str;
            this.f12980b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            l5.this.a(this.f12979a, "onBannerAdClicked()");
            this.f12980b.onBannerAdClicked(this.f12979a);
        }
    }

    class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f12982a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ISDemandOnlyBannerListener f12983b;

        e(String str, ISDemandOnlyBannerListener iSDemandOnlyBannerListener) {
            this.f12982a = str;
            this.f12983b = iSDemandOnlyBannerListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            l5.this.a(this.f12982a, "onBannerAdLeftApplication()");
            this.f12983b.onBannerAdLeftApplication(this.f12982a);
        }
    }

    public void a(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new d(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void b(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new e(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void c(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new b(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void d(String str) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new c(str, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }

    public void a(String str, IronSourceError ironSourceError) {
        ISDemandOnlyBannerListener iSDemandOnlyBannerListenerA = a();
        a(new a(str, ironSourceError, iSDemandOnlyBannerListenerA), iSDemandOnlyBannerListenerA != null);
    }
}
