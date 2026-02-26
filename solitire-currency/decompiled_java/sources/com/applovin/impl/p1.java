package com.applovin.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinFullscreenActivity;
import com.applovin.impl.adview.a;
import com.applovin.impl.adview.e;
import com.applovin.impl.c2;
import com.applovin.impl.d0;
import com.applovin.impl.r5;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.h;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p1 implements c2.a, AppLovinBroadcastManager.Receiver, a.b {
    protected AppLovinAdClickListener A;
    protected AppLovinAdDisplayListener B;
    protected AppLovinAdVideoPlaybackListener C;
    protected final c2 D;
    protected t6 E;
    protected t6 F;
    protected boolean G;
    private final d0 H;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final com.applovin.impl.sdk.ad.b f6506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.applovin.impl.sdk.j f6507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected final com.applovin.impl.sdk.n f6508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected Activity f6509d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final com.applovin.impl.b f6511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final h.a f6512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected AppLovinAdView f6513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected com.applovin.impl.adview.k f6514i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected final com.applovin.impl.adview.g f6515j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected final com.applovin.impl.adview.g f6516k;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected long f6521p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f6522q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected boolean f6523r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected int f6524s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected boolean f6525t;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    protected boolean f6531z;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Handler f6510e = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected final long f6517l = SystemClock.elapsedRealtime();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicBoolean f6518m = new AtomicBoolean();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f6519n = new AtomicBoolean();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected long f6520o = -1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f6526u = 0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final ArrayList f6527v = new ArrayList();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected int f6528w = 0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected int f6529x = 0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    protected int f6530y = com.applovin.impl.sdk.h.f7069h;
    private boolean I = false;

    class a implements AppLovinAdDisplayListener {
        a() {
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adDisplayed(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = p1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                p1.this.f6508c.a("AppLovinFullscreenActivity", "Web content rendered");
            }
        }

        @Override // com.applovin.sdk.AppLovinAdDisplayListener
        public void adHidden(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = p1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                p1.this.f6508c.a("AppLovinFullscreenActivity", "Closing from WebView");
            }
            p1.this.c();
        }
    }

    class b implements h.a {
        b() {
        }

        @Override // com.applovin.impl.sdk.h.a
        public void a(int i10) {
            p1 p1Var = p1.this;
            if (p1Var.f6530y != com.applovin.impl.sdk.h.f7069h) {
                p1Var.f6531z = true;
            }
            com.applovin.impl.adview.b bVarF = p1Var.f6513h.getController().f();
            if (bVarF == null) {
                com.applovin.impl.sdk.n nVar = p1.this.f6508c;
                if (com.applovin.impl.sdk.n.a()) {
                    p1.this.f6508c.k("AppLovinFullscreenActivity", "Unable to handle ringer mode change: no valid web view.");
                }
            } else if (com.applovin.impl.sdk.h.a(i10) && !com.applovin.impl.sdk.h.a(p1.this.f6530y)) {
                bVarF.a("javascript:al_muteSwitchOn();");
            } else if (i10 == 2) {
                bVarF.a("javascript:al_muteSwitchOff();");
            }
            p1.this.f6530y = i10;
        }
    }

    class c extends com.applovin.impl.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f6534a;

        c(com.applovin.impl.sdk.j jVar) {
            this.f6534a = jVar;
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (!activity.getClass().getName().equals(z6.a(activity.getApplicationContext(), "AppLovinFullscreenActivity", this.f6534a)) || p1.this.f6519n.get()) {
                return;
            }
            com.applovin.impl.sdk.n.h("AppLovinFullscreenActivity", "Dismissing on-screen ad due to app relaunched via launcher.");
            try {
                p1.this.c();
            } catch (Throwable th) {
                com.applovin.impl.sdk.n.c("AppLovinFullscreenActivity", "Failed to dismiss ad.", th);
                try {
                    p1.this.k();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public interface d {
        void a(p1 p1Var);

        void a(String str, Throwable th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    class e implements AppLovinAdClickListener, View.OnClickListener {
        private e() {
        }

        @Override // com.applovin.sdk.AppLovinAdClickListener
        public void adClicked(AppLovinAd appLovinAd) {
            com.applovin.impl.sdk.n nVar = p1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                p1.this.f6508c.a("AppLovinFullscreenActivity", "Clicking through graphic");
            }
            l2.a(p1.this.A, appLovinAd);
            p1.this.f6529x++;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            p1 p1Var = p1.this;
            if (view != p1Var.f6515j || !((Boolean) p1Var.f6507b.a(l4.O1)).booleanValue()) {
                com.applovin.impl.sdk.n nVar = p1.this.f6508c;
                if (com.applovin.impl.sdk.n.a()) {
                    p1.this.f6508c.b("AppLovinFullscreenActivity", "Unhandled click on widget: " + view);
                    return;
                }
                return;
            }
            p1.c(p1.this);
            if (p1.this.f6506a.S0()) {
                p1.this.c("javascript:al_onCloseButtonTapped(" + p1.this.f6526u + "," + p1.this.f6528w + "," + p1.this.f6529x + ");");
            }
            List listL = p1.this.f6506a.L();
            com.applovin.impl.sdk.n nVar2 = p1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                p1.this.f6508c.a("AppLovinFullscreenActivity", "Handling close button tap " + p1.this.f6526u + " with multi close delay: " + listL);
            }
            if (listL == null || listL.size() <= p1.this.f6526u) {
                p1.this.c();
                return;
            }
            p1.this.f6527v.add(Long.valueOf(SystemClock.elapsedRealtime() - p1.this.f6520o));
            List listJ = p1.this.f6506a.J();
            if (listJ != null && listJ.size() > p1.this.f6526u) {
                p1 p1Var2 = p1.this;
                p1Var2.f6515j.a((e.a) listJ.get(p1Var2.f6526u));
            }
            com.applovin.impl.sdk.n nVar3 = p1.this.f6508c;
            if (com.applovin.impl.sdk.n.a()) {
                p1.this.f6508c.a("AppLovinFullscreenActivity", "Scheduling next close button with delay: " + listL.get(p1.this.f6526u));
            }
            p1.this.f6515j.setVisibility(8);
            p1 p1Var3 = p1.this;
            p1Var3.a(p1Var3.f6515j, ((Integer) listL.get(p1Var3.f6526u)).intValue(), new Runnable() { // from class: com.applovin.impl.nc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f6432a.a();
                }
            });
        }

        /* synthetic */ e(p1 p1Var, a aVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void a() {
            p1.this.f6520o = SystemClock.elapsedRealtime();
        }
    }

    p1(com.applovin.impl.sdk.ad.b bVar, Activity activity, Map map, com.applovin.impl.sdk.j jVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f6506a = bVar;
        this.f6507b = jVar;
        this.f6508c = jVar.I();
        this.f6509d = activity;
        this.A = appLovinAdClickListener;
        this.B = appLovinAdDisplayListener;
        this.C = appLovinAdVideoPlaybackListener;
        c2 c2Var = new c2(activity, jVar);
        this.D = c2Var;
        c2Var.a(this);
        this.H = new d0(jVar);
        e eVar = new e(this, null);
        if (((Boolean) jVar.a(l4.f5673k2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.render_process_gone"));
        }
        if (((Boolean) jVar.a(l4.f5721q2)).booleanValue()) {
            AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.al_onPoststitialShow_evaluation_error"));
        }
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_shown"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_hidden"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.custom_tabs_failure"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.external_redirect_success"));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter("com.applovin.external_redirect_failure"));
        n1 n1Var = new n1(jVar.r0(), AppLovinAdSize.INTERSTITIAL, activity);
        this.f6513h = n1Var;
        n1Var.setAdClickListener(eVar);
        this.f6513h.setAdDisplayListener(new a());
        bVar.e().putString("ad_view_address", q7.a(this.f6513h));
        this.f6513h.getController().a(this);
        x1 x1Var = new x1(map, jVar);
        if (x1Var.c()) {
            this.f6514i = new com.applovin.impl.adview.k(x1Var, activity);
        }
        jVar.k().trackImpression(bVar);
        List listL = bVar.L();
        if (bVar.p() >= 0 || listL != null) {
            com.applovin.impl.adview.g gVar = new com.applovin.impl.adview.g(bVar.n(), activity);
            this.f6515j = gVar;
            gVar.setVisibility(8);
            gVar.setOnClickListener(eVar);
        } else {
            this.f6515j = null;
        }
        com.applovin.impl.adview.g gVar2 = new com.applovin.impl.adview.g(e.a.WHITE_ON_TRANSPARENT, activity);
        this.f6516k = gVar2;
        gVar2.setOnClickListener(new View.OnClickListener() { // from class: com.applovin.impl.gc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f5285a.b(view);
            }
        });
        if (bVar.W0()) {
            this.f6512g = new b();
        } else {
            this.f6512g = null;
        }
        this.f6511f = new c(jVar);
    }

    static /* synthetic */ int c(p1 p1Var) {
        int i10 = p1Var.f6526u;
        p1Var.f6526u = i10 + 1;
        return i10;
    }

    private void y() {
        if (this.f6512g != null) {
            this.f6507b.p().a(this.f6512g);
        }
        if (this.f6511f != null) {
            this.f6507b.e().a(this.f6511f);
        }
    }

    public abstract void a(long j10);

    public abstract void a(ViewGroup viewGroup);

    protected void k() {
        if (this.f6519n.compareAndSet(false, true)) {
            l2.b(this.B, this.f6506a);
            this.f6507b.D().b(this.f6506a);
            this.f6507b.g().a(y1.f7797o, this.f6506a);
        }
    }

    protected abstract void l();

    protected void m() {
        t6 t6Var = this.E;
        if (t6Var != null) {
            t6Var.d();
        }
    }

    protected void n() {
        t6 t6Var = this.E;
        if (t6Var != null) {
            t6Var.e();
        }
    }

    protected void o() {
        com.applovin.impl.adview.b bVarF;
        if (this.f6513h == null || !this.f6506a.w0() || (bVarF = this.f6513h.getController().f()) == null) {
            return;
        }
        this.H.a(bVarF, new d0.c() { // from class: com.applovin.impl.jc
            @Override // com.applovin.impl.d0.c
            public final void a(View view) {
                this.f5503a.a(view);
            }
        });
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (action == null) {
        }
        switch (action) {
            case "com.applovin.al_onPoststitialShow_evaluation_error":
                e();
                break;
            case "com.applovin.external_redirect_success":
            case "com.applovin.external_redirect_failure":
                b(action, map);
                break;
            case "com.applovin.custom_tabs_failure":
            case "com.applovin.custom_tabs_hidden":
            case "com.applovin.custom_tabs_shown":
                a(action, map);
                break;
            case "com.applovin.render_process_gone":
                if (!this.f6523r) {
                    f();
                    break;
                }
                break;
        }
    }

    public void p() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onBackPressed()");
        }
        if (this.I) {
            c();
        }
        if (this.f6506a.S0()) {
            c("javascript:onBackPressed();");
        }
    }

    public void q() {
        AppLovinAdView appLovinAdView = this.f6513h;
        if (appLovinAdView != null) {
            ViewParent parent = appLovinAdView.getParent();
            this.f6513h.destroy();
            this.f6513h = null;
            if ((parent instanceof ViewGroup) && i()) {
                ((ViewGroup) parent).removeAllViews();
            }
        }
        l();
        k();
        this.A = null;
        this.B = null;
        this.C = null;
        this.f6509d = null;
        AppLovinBroadcastManager.unregisterReceiver(this);
    }

    public void r() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onPause()");
        }
        b("javascript:al_onAppPaused();");
        if (this.D.b()) {
            this.D.a();
        }
        m();
    }

    public void s() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onResume()");
        }
        b("javascript:al_onAppResumed();");
        n();
        if (this.D.b()) {
            this.D.a();
        }
    }

    public void t() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onStop()");
        }
    }

    public abstract void u();

    public abstract void v();

    protected void w() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "Setting ad fully watched");
        }
        this.G = true;
    }

    protected abstract void x();

    public static void a(com.applovin.impl.sdk.ad.b bVar, AppLovinAdClickListener appLovinAdClickListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, Map map, com.applovin.impl.sdk.j jVar, Activity activity, d dVar) {
        p1 s1Var;
        if (bVar instanceof a7) {
            try {
                s1Var = new s1(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th) {
                dVar.a("Failed to create FullscreenVastVideoAdPresenter with sdk: " + jVar + " and throwable: " + th.getMessage(), th);
                return;
            }
        } else if (bVar.hasVideoUrl()) {
            try {
                s1Var = new t1(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th2) {
                dVar.a("Failed to create FullscreenVideoAdPresenter with sdk: " + jVar + " and throwable: " + th2.getMessage(), th2);
                return;
            }
        } else {
            try {
                s1Var = new q1(bVar, activity, map, jVar, appLovinAdClickListener, appLovinAdDisplayListener, appLovinAdVideoPlaybackListener);
            } catch (Throwable th3) {
                dVar.a("Failed to create FullscreenGraphicAdPresenter with sdk: " + jVar + " and throwable: " + th3.getMessage(), th3);
                return;
            }
        }
        s1Var.y();
        dVar.a(s1Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j() {
        if (this.f6506a.E0().getAndSet(true)) {
            return;
        }
        this.f6507b.j0().a((w4) new a6(this.f6506a, this.f6507b), r5.b.OTHER);
    }

    protected void c(boolean z10) {
        a(z10, ((Long) this.f6507b.a(l4.f5657i2)).longValue());
        l2.a(this.B, this.f6506a);
        this.f6507b.D().a(this.f6506a);
        if (this.f6506a.hasVideoUrl() || h()) {
            l2.a(this.C, this.f6506a);
        }
        new a4(this.f6509d).a(this.f6506a);
        this.f6506a.setHasShown(true);
    }

    public void e() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "Handling al_onPoststitialShow evaluation error");
        }
    }

    public void f() {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "Handling render process crash");
        }
        this.f6523r = true;
    }

    public boolean g() {
        return this.f6522q;
    }

    protected boolean h() {
        return AppLovinAdType.INCENTIVIZED == this.f6506a.getType();
    }

    protected boolean i() {
        return this.f6509d instanceof AppLovinFullscreenActivity;
    }

    public void b(boolean z10) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onWindowFocusChanged(boolean) - " + z10);
        }
        b("javascript:al_onWindowFocusChanged( " + z10 + " );");
        t6 t6Var = this.F;
        if (t6Var != null) {
            if (z10) {
                t6Var.e();
            } else {
                t6Var.d();
            }
        }
    }

    protected int d() {
        int iR = this.f6506a.r();
        return (iR <= 0 && ((Boolean) this.f6507b.a(l4.f5649h2)).booleanValue()) ? this.f6524s + 1 : iR;
    }

    protected void b(String str) {
        if (this.f6506a.A0()) {
            a(str, 0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        q7.a(gVar, 400L, new Runnable() { // from class: com.applovin.impl.hc
            @Override // java.lang.Runnable
            public final void run() {
                p1.a(gVar, runnable);
            }
        });
    }

    public void c() {
        this.f6522q = true;
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "dismiss()");
        }
        com.applovin.impl.sdk.ad.b bVar = this.f6506a;
        if (bVar != null) {
            bVar.getAdEventTracker().f();
        }
        this.f6510e.removeCallbacksAndMessages(null);
        a("javascript:al_onPoststitialDismiss();", this.f6506a != null ? r0.C() : 0L);
        k();
        this.H.b();
        if (this.f6512g != null) {
            this.f6507b.p().b(this.f6512g);
        }
        if (this.f6511f != null) {
            this.f6507b.e().b(this.f6511f);
        }
        if (i()) {
            this.f6509d.finish();
            return;
        }
        this.f6507b.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f6507b.I().a("AppLovinFullscreenActivity", "Fullscreen ad shown in container view dismissed, destroying the presenter.");
        }
        q();
    }

    protected void b(long j10) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Scheduling report reward in " + TimeUnit.MILLISECONDS.toSeconds(j10) + " seconds...");
        }
        this.E = t6.a(j10, this.f6507b, new Runnable() { // from class: com.applovin.impl.lc
            @Override // java.lang.Runnable
            public final void run() {
                this.f5834a.j();
            }
        });
    }

    protected boolean a(boolean z10) {
        List listA = z6.a(z10, this.f6506a, this.f6507b, this.f6509d);
        if (listA.isEmpty()) {
            return false;
        }
        if (((Boolean) this.f6507b.a(l4.f5684l5)).booleanValue()) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.b("AppLovinFullscreenActivity", "Dismissing ad due to missing resources: " + listA);
            }
            if (((Boolean) this.f6507b.a(l4.f5708o5)).booleanValue()) {
                AppLovinAdDisplayListener appLovinAdDisplayListener = this.B;
                if (appLovinAdDisplayListener instanceof f2) {
                    l2.a(appLovinAdDisplayListener, "Missing ad resources");
                }
                c();
            } else {
                h2.a(this.f6506a, this.B, "Missing ad resources", null, null);
                c();
            }
            HashMap map = new HashMap();
            CollectionUtils.putStringIfValid("error_message", "Missing ad resources: " + listA, map);
            CollectionUtils.putStringIfValid("details", "Failing ad display", map);
            this.f6507b.A().a(y1.f7788j0, "missingCachedAdResources", map);
            return ((Boolean) this.f6507b.a(l4.f5700n5)).booleanValue();
        }
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.b("AppLovinFullscreenActivity", "Streaming ad due to missing ad resources: " + listA);
        }
        this.f6506a.J0();
        HashMap map2 = new HashMap();
        CollectionUtils.putStringIfValid("error_message", "Missing ad resources: " + listA, map2);
        CollectionUtils.putStringIfValid("details", "Streaming ad", map2);
        this.f6507b.A().a(y1.f7788j0, "missingCachedAdResources", map2);
        return false;
    }

    private void b(String str, Map map) {
        String str2;
        str.hashCode();
        if (str.equals("com.applovin.external_redirect_success")) {
            str2 = "success";
        } else if (!str.equals("com.applovin.external_redirect_failure")) {
            return;
        } else {
            str2 = "failure";
        }
        a("al_onExternalRedirectEvent", str2, map);
    }

    public void c(String str) {
        a(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(final com.applovin.impl.adview.g gVar, final Runnable runnable) {
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.kc
            @Override // java.lang.Runnable
            public final void run() {
                p1.b(gVar, runnable);
            }
        });
    }

    public void a(Configuration configuration) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onConfigurationChanged(Configuration) -  " + configuration);
        }
    }

    public void a(int i10, KeyEvent keyEvent) {
        if (this.f6508c != null && com.applovin.impl.sdk.n.a()) {
            this.f6508c.d("AppLovinFullscreenActivity", "onKeyDown(int, KeyEvent) -  " + i10 + ", " + keyEvent);
        }
        com.applovin.impl.sdk.ad.b bVar = this.f6506a;
        if (bVar == null || !bVar.V0()) {
            return;
        }
        if (i10 == 24 || i10 == 25) {
            c("javascript:al_onVolumeChangedEvent('" + (i10 == 24 ? "volume_up" : "volume_down") + "');");
        }
    }

    protected void a(final String str, long j10) {
        if (j10 < 0 || !StringUtils.isValidString(str)) {
            return;
        }
        a(new Runnable() { // from class: com.applovin.impl.ic
            @Override // java.lang.Runnable
            public final void run() {
                this.f5406a.a(str);
            }
        }, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(String str) {
        com.applovin.impl.adview.b bVarF;
        AppLovinAdView appLovinAdView = this.f6513h;
        if (appLovinAdView == null || (bVarF = appLovinAdView.getController().f()) == null) {
            return;
        }
        bVarF.a(str);
    }

    protected void a(final com.applovin.impl.adview.g gVar, long j10, final Runnable runnable) {
        if (j10 >= ((Long) this.f6507b.a(l4.N1)).longValue()) {
            return;
        }
        this.F = t6.a(TimeUnit.SECONDS.toMillis(j10), this.f6507b, new Runnable() { // from class: com.applovin.impl.mc
            @Override // java.lang.Runnable
            public final void run() {
                p1.c(gVar, runnable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.adview.g gVar, Runnable runnable) {
        gVar.bringToFront();
        runnable.run();
    }

    protected void a(int i10, boolean z10, boolean z11, long j10) {
        if (this.f6518m.compareAndSet(false, true)) {
            if (this.f6506a.hasVideoUrl() || h()) {
                l2.a(this.C, this.f6506a, i10, z11);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.f6517l;
            this.f6507b.k().trackVideoEnd(this.f6506a, TimeUnit.MILLISECONDS.toSeconds(jElapsedRealtime), i10, z10);
            long jElapsedRealtime2 = this.f6520o != -1 ? SystemClock.elapsedRealtime() - this.f6520o : -1L;
            this.f6507b.k().trackFullScreenAdClosed(this.f6506a, jElapsedRealtime2, this.f6527v, j10, this.f6531z, this.f6530y);
            if (com.applovin.impl.sdk.n.a()) {
                this.f6508c.a("AppLovinFullscreenActivity", "Video ad ended at percent: " + i10 + "%, elapsedTime: " + jElapsedRealtime + "ms, skipTimeMillis: " + j10 + "ms, closeTimeMillis: " + jElapsedRealtime2 + "ms");
            }
        }
    }

    @Override // com.applovin.impl.adview.a.b
    public void a(com.applovin.impl.adview.a aVar) {
        if (com.applovin.impl.sdk.n.a()) {
            this.f6508c.a("AppLovinFullscreenActivity", "Fully watched from ad web view...");
        }
        this.G = true;
    }

    protected void a(boolean z10, long j10) {
        if (this.f6506a.K0()) {
            a(z10 ? "javascript:al_mute();" : "javascript:al_unmute();", j10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (((Boolean) this.f6507b.a(l4.J0)).booleanValue()) {
            this.f6507b.C().c(this.f6506a, com.applovin.impl.sdk.j.n());
        }
        Map mapB = a2.b(this.f6506a);
        mapB.putAll(a2.a(this.f6506a));
        this.f6507b.A().d(y1.f7786i0, mapB);
        if (((Boolean) this.f6507b.a(l4.H5)).booleanValue()) {
            w();
        }
        if (((Boolean) this.f6507b.a(l4.D5)).booleanValue()) {
            c();
            return;
        }
        this.I = ((Boolean) this.f6507b.a(l4.E5)).booleanValue();
        if (((Boolean) this.f6507b.a(l4.F5)).booleanValue()) {
            x();
        }
    }

    private void a(String str, Map map) {
        String str2;
        str.hashCode();
        switch (str) {
            case "com.applovin.custom_tabs_failure":
                str2 = "failure";
                break;
            case "com.applovin.custom_tabs_hidden":
                str2 = "hidden";
                break;
            case "com.applovin.custom_tabs_shown":
                str2 = "shown";
                break;
            default:
                return;
        }
        a("al_onInAppBrowserEvent", str2, map);
    }

    private void a(String str, String str2, Map map) {
        JSONObject jSONObject;
        try {
            jSONObject = CollectionUtils.toJson(map);
        } catch (JSONException unused) {
            jSONObject = new JSONObject();
        }
        c("javascript:" + str + "('" + str2 + "'," + jSONObject + ");");
    }

    protected void a(Runnable runnable, long j10) {
        AppLovinSdkUtils.runOnUiThreadDelayed(runnable, j10, this.f6510e);
    }
}
