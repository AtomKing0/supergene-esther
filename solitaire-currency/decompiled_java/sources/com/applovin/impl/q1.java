package com.applovin.impl;

import android.app.Activity;
import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.r5;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class q1 extends p1 {
    private final r1 J;
    private c0 K;
    private long L;
    private final AtomicBoolean M;

    public q1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        this.J = new r1(this.f6506a, this.f6509d, this.f6507b);
        this.M = new AtomicBoolean();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Marking ad as fully watched");
        }
        this.M.set(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        this.f6520o = SystemClock.elapsedRealtime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E() {
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.adview.g gVar = this.f6515j;
        if (gVar != null) {
            arrayList.add(new u3(gVar, FriendlyObstructionPurpose.CLOSE_AD, "close button"));
        }
        com.applovin.impl.adview.k kVar = this.f6514i;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f6514i;
            arrayList.add(new u3(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f6506a.getAdEventTracker().b(this.f6513h, arrayList);
    }

    protected void F() {
        long jU;
        long millis = 0;
        if (this.f6506a.T() >= 0 || this.f6506a.U() >= 0) {
            if (this.f6506a.T() >= 0) {
                jU = this.f6506a.T();
            } else {
                if (this.f6506a.X0()) {
                    int iG1 = (int) ((com.applovin.impl.sdk.ad.a) this.f6506a).g1();
                    if (iG1 > 0) {
                        millis = TimeUnit.SECONDS.toMillis(iG1);
                    } else {
                        int iP = (int) this.f6506a.p();
                        if (iP > 0) {
                            millis = TimeUnit.SECONDS.toMillis(iP);
                        }
                    }
                }
                jU = (long) (millis * (((double) this.f6506a.U()) / 100.0d));
            }
            b(jU);
        }
    }

    @Override // com.applovin.impl.c2.a
    public void a() {
    }

    @Override // com.applovin.impl.p1
    public void c() {
        l();
        c0 c0Var = this.K;
        if (c0Var != null) {
            c0Var.a();
            this.K = null;
        }
        super.c();
    }

    @Override // com.applovin.impl.p1
    public void e() {
        super.e();
        x();
    }

    @Override // com.applovin.impl.p1
    public void f() {
        super.f();
        x();
    }

    @Override // com.applovin.impl.p1
    protected void l() {
        super.a(A(), false, B(), -2L);
    }

    @Override // com.applovin.impl.p1
    public void v() {
        a((ViewGroup) null);
    }

    @Override // com.applovin.impl.p1
    protected void w() {
        super.w();
        this.M.set(true);
    }

    @Override // com.applovin.impl.p1
    protected void x() {
        this.J.a(this.f6516k);
        this.f6520o = SystemClock.elapsedRealtime();
        this.M.set(true);
    }

    private int A() {
        c0 c0Var;
        int iMin = 100;
        if (h()) {
            if (!B() && (c0Var = this.K) != null) {
                iMin = (int) Math.min(100.0d, ((this.L - c0Var.b()) / this.L) * 100.0d);
            }
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Ad engaged at " + iMin + "%");
            }
        }
        return iMin;
    }

    private long z() {
        com.applovin.impl.sdk.ad.b bVar = this.f6506a;
        if (!(bVar instanceof com.applovin.impl.sdk.ad.a)) {
            return 0L;
        }
        float fG1 = ((com.applovin.impl.sdk.ad.a) bVar).g1();
        if (fG1 <= 0.0f) {
            fG1 = this.f6506a.p();
        }
        return (long) (z6.c(fG1) * (((double) this.f6506a.E()) / 100.0d));
    }

    protected boolean B() {
        if (!(this.G && this.f6506a.a1()) && h()) {
            return this.M.get();
        }
        return true;
    }

    @Override // com.applovin.impl.p1
    public void a(long j10) {
    }

    @Override // com.applovin.impl.p1
    public void a(ViewGroup viewGroup) {
        this.J.a(this.f6515j, this.f6514i, this.f6513h, viewGroup);
        if (a(false)) {
            return;
        }
        com.applovin.impl.adview.k kVar = this.f6514i;
        if (kVar != null) {
            kVar.b();
        }
        this.f6513h.renderAd(this.f6506a);
        a("javascript:al_onPoststitialShow();", this.f6506a.D());
        if (h()) {
            long jZ = z();
            this.L = jZ;
            if (jZ > 0) {
                if (com.applovin.impl.sdk.n.a()) {
                    this.f6508c.a("AppLovinFullscreenActivity", "Scheduling timer for ad fully watched in " + this.L + "ms...");
                }
                this.K = c0.a(this.L, this.f6507b, new Runnable() { // from class: com.applovin.impl.oc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6488a.C();
                    }
                });
            }
        }
        if (this.f6515j != null) {
            if (this.f6506a.p() >= 0) {
                a(this.f6515j, this.f6506a.p(), new Runnable() { // from class: com.applovin.impl.pc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f6581a.D();
                    }
                });
            } else {
                this.f6515j.setVisibility(0);
            }
        }
        F();
        this.f6507b.j0().a(new f6(this.f6507b, "updateMainViewOM", new Runnable() { // from class: com.applovin.impl.qc
            @Override // java.lang.Runnable
            public final void run() {
                this.f6721a.E();
            }
        }), r5.b.OTHER, TimeUnit.SECONDS.toMillis(1L));
        o();
        super.c(z6.e(this.f6507b));
    }

    @Override // com.applovin.impl.c2.a
    public void b() {
    }

    @Override // com.applovin.impl.p1
    public void u() {
    }
}
