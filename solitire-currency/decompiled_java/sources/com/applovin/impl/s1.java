package com.applovin.impl;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.applovin.impl.a7;
import com.applovin.impl.w0;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.iab.omid.library.applovin.adsession.FriendlyObstructionPurpose;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class s1 extends t1 {

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    private final a7 f6795m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    private final Set f6796n0;

    class a implements w0.b {
        a() {
        }

        @Override // com.applovin.impl.w0.b
        public void a() {
            long seconds = TimeUnit.MILLISECONDS.toSeconds(s1.this.f7410d0 - ((long) (s1.this.M.getDuration() - s1.this.M.getCurrentPosition())));
            int iZ = s1.this.z();
            HashSet hashSet = new HashSet();
            for (k7 k7Var : new HashSet(s1.this.f6796n0)) {
                if (k7Var.a(seconds, iZ)) {
                    hashSet.add(k7Var);
                    s1.this.f6796n0.remove(k7Var);
                }
            }
            s1.this.a(hashSet);
            if (iZ >= 25 && iZ < 50) {
                s1.this.f6795m0.getAdEventTracker().x();
                return;
            }
            if (iZ >= 50 && iZ < 75) {
                s1.this.f6795m0.getAdEventTracker().y();
            } else if (iZ >= 75) {
                s1.this.f6795m0.getAdEventTracker().C();
            }
        }

        @Override // com.applovin.impl.w0.b
        public boolean b() {
            return !s1.this.f7413g0;
        }
    }

    public s1(com.applovin.impl.sdk.ad.b bVar, final Activity activity, Map map, final com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        super(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
        HashSet hashSet = new HashSet();
        this.f6796n0 = hashSet;
        a7 a7Var = (a7) bVar;
        this.f6795m0 = a7Var;
        if (a7Var.q1()) {
            ImageView imageViewA = g7.a(a7Var.k1().e(), activity, jVar);
            this.U = imageViewA;
            imageViewA.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.cd
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f4974a.a(activity, jVar, view);
                }
            });
        }
        a7.d dVar = a7.d.VIDEO;
        hashSet.addAll(a7Var.a(dVar, l7.f5822a));
        a(a7.d.IMPRESSION);
        a(dVar, "creativeView");
        a7Var.getAdEventTracker().g();
    }

    private void U() {
        if (!D() || this.f6796n0.isEmpty()) {
            return;
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.k("AppLovinFullscreenActivity", "Firing " + this.f6796n0.size() + " un-fired video progress trackers when video was completed.");
        }
        a(this.f6796n0);
    }

    @Override // com.applovin.impl.t1
    public void A() {
        a(a7.d.VIDEO, "skip");
        this.f6795m0.getAdEventTracker().B();
        super.A();
    }

    @Override // com.applovin.impl.t1
    protected void B() {
        super.B();
        a7 a7Var = this.f6795m0;
        if (a7Var != null) {
            a7Var.getAdEventTracker().i();
        }
    }

    @Override // com.applovin.impl.t1
    protected void L() {
        long jU;
        int iP;
        long millis = 0;
        if (this.f6795m0.T() >= 0 || this.f6795m0.U() >= 0) {
            if (this.f6795m0.T() >= 0) {
                jU = this.f6795m0.T();
            } else {
                a7 a7Var = this.f6795m0;
                n7 n7VarO1 = a7Var.o1();
                if (n7VarO1 == null || n7VarO1.d() <= 0) {
                    long j10 = this.f7410d0;
                    if (j10 > 0) {
                        millis = j10;
                    }
                } else {
                    millis = TimeUnit.SECONDS.toMillis(n7VarO1.d());
                }
                if (a7Var.X0() && (iP = (int) a7Var.p()) > 0) {
                    millis += TimeUnit.SECONDS.toMillis(iP);
                }
                jU = (long) (millis * (((double) this.f6795m0.U()) / 100.0d));
            }
            b(jU);
        }
    }

    @Override // com.applovin.impl.t1
    protected void P() {
        super.P();
        a7 a7Var = this.f6795m0;
        if (a7Var != null) {
            a7Var.getAdEventTracker().j();
        }
    }

    @Override // com.applovin.impl.t1
    public void Q() {
        U();
        if (!m7.a(this.f6795m0)) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "VAST ad does not have valid companion ad - dismissing...");
            }
            c();
        } else {
            if (this.f7413g0) {
                return;
            }
            a(a7.d.COMPANION, "creativeView");
            this.f6795m0.getAdEventTracker().w();
            super.Q();
        }
    }

    @Override // com.applovin.impl.t1
    public void S() {
        super.S();
        a(a7.d.VIDEO, this.f7409c0 ? "mute" : "unmute");
        this.f6795m0.getAdEventTracker().b(this.f7409c0);
    }

    @Override // com.applovin.impl.t1, com.applovin.impl.p1
    public void c() {
        if (this.f6795m0 != null) {
            a(a7.d.VIDEO, "close");
            a(a7.d.COMPANION, "close");
        }
        super.c();
    }

    @Override // com.applovin.impl.t1
    public void d(String str) {
        a(a7.d.ERROR, f7.MEDIA_FILE_ERROR);
        this.f6795m0.getAdEventTracker().b(str);
        super.d(str);
    }

    @Override // com.applovin.impl.p1
    public void r() {
        super.r();
        a(this.f7413g0 ? a7.d.COMPANION : a7.d.VIDEO, "pause");
        this.f6795m0.getAdEventTracker().z();
    }

    @Override // com.applovin.impl.p1
    public void s() {
        super.s();
        a(this.f7413g0 ? a7.d.COMPANION : a7.d.VIDEO, "resume");
        this.f6795m0.getAdEventTracker().A();
    }

    @Override // com.applovin.impl.t1, com.applovin.impl.p1
    public void u() {
        this.Z.c();
        super.u();
    }

    @Override // com.applovin.impl.t1, com.applovin.impl.p1
    public void v() {
        a((ViewGroup) null);
    }

    private boolean T() {
        return this.U != null && this.f6795m0.q1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Activity activity, com.applovin.impl.sdk.j jVar, View view) {
        Uri uriC = this.f6795m0.k1().c();
        if (uriC != null) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Industry Icon clicked, opening URL: " + uriC);
            }
            a(a7.d.INDUSTRY_ICON_CLICK);
            w6.a(uriC, activity, jVar);
        }
    }

    @Override // com.applovin.impl.t1
    protected void c(long j10) {
        super.c(j10);
        this.f6795m0.getAdEventTracker().b(TimeUnit.MILLISECONDS.toSeconds(j10), z6.e(this.f6507b));
    }

    @Override // com.applovin.impl.t1, com.applovin.impl.p1
    public void a(ViewGroup viewGroup) {
        super.a(viewGroup);
        if (T()) {
            a(a7.d.INDUSTRY_ICON_IMPRESSION);
            this.U.setVisibility(0);
        }
        this.Z.a("PROGRESS_TRACKING", TimeUnit.SECONDS.toMillis(1L), new a());
        ArrayList arrayList = new ArrayList();
        com.applovin.impl.a aVar = this.N;
        if (aVar != null) {
            arrayList.add(new u3(aVar, FriendlyObstructionPurpose.OTHER, "video stream buffering indicator"));
        }
        com.applovin.impl.adview.g gVar = this.O;
        if (gVar != null) {
            arrayList.add(new u3(gVar, FriendlyObstructionPurpose.CLOSE_AD, "skip button"));
        }
        e0 e0Var = this.P;
        if (e0Var != null) {
            arrayList.add(new u3(e0Var, FriendlyObstructionPurpose.OTHER, "countdown clock"));
        }
        ProgressBar progressBar = this.S;
        if (progressBar != null) {
            arrayList.add(new u3(progressBar, FriendlyObstructionPurpose.OTHER, "progress bar"));
        }
        ProgressBar progressBar2 = this.T;
        if (progressBar2 != null) {
            arrayList.add(new u3(progressBar2, FriendlyObstructionPurpose.OTHER, "postitial progress bar"));
        }
        ImageView imageView = this.Q;
        if (imageView != null) {
            arrayList.add(new u3(imageView, FriendlyObstructionPurpose.VIDEO_CONTROLS, "mute button"));
        }
        com.applovin.impl.adview.l lVar = this.R;
        if (lVar != null) {
            arrayList.add(new u3(lVar, FriendlyObstructionPurpose.VIDEO_CONTROLS, "generic webview overlay containing HTML controls"));
        }
        com.applovin.impl.adview.k kVar = this.f6514i;
        if (kVar != null && kVar.a()) {
            com.applovin.impl.adview.k kVar2 = this.f6514i;
            arrayList.add(new u3(kVar2, FriendlyObstructionPurpose.NOT_VISIBLE, kVar2.getIdentifier()));
        }
        this.f6795m0.getAdEventTracker().b(this.M, arrayList);
    }

    @Override // com.applovin.impl.t1
    public void a(MotionEvent motionEvent, Bundle bundle) {
        a(a7.d.VIDEO_CLICK);
        this.f6795m0.getAdEventTracker().v();
        super.a(motionEvent, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Set set) {
        a(set, f7.UNSPECIFIED);
    }

    private void a(a7.d dVar) {
        a(dVar, f7.UNSPECIFIED);
    }

    private void a(a7.d dVar, String str) {
        a(dVar, str, f7.UNSPECIFIED);
    }

    private void a(a7.d dVar, f7 f7Var) {
        a(dVar, "", f7Var);
    }

    private void a(a7.d dVar, String str, f7 f7Var) {
        a(this.f6795m0.a(dVar, str), f7Var);
    }

    private void a(Set set, f7 f7Var) {
        if (set == null || set.isEmpty()) {
            return;
        }
        long seconds = TimeUnit.MILLISECONDS.toSeconds(this.M.getCurrentPosition());
        o7 o7VarP1 = this.f6795m0.p1();
        Uri uriD = o7VarP1 != null ? o7VarP1.d() : null;
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Firing " + set.size() + " tracker(s): " + set);
        }
        m7.a(set, seconds, uriD, f7Var, this.f6507b);
    }
}
