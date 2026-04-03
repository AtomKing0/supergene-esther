package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.ironsource.el;
import com.ironsource.gc;
import com.ironsource.gl;
import com.ironsource.ha;
import com.ironsource.hc;
import com.ironsource.hl;
import com.ironsource.hm;
import com.ironsource.i0;
import com.ironsource.i9;
import com.ironsource.ia;
import com.ironsource.jd;
import com.ironsource.k8;
import com.ironsource.l3;
import com.ironsource.ld;
import com.ironsource.n9;
import com.ironsource.nb;
import com.ironsource.o9;
import com.ironsource.p9;
import com.ironsource.qf;
import com.ironsource.ra;
import com.ironsource.rf;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sf;
import com.ironsource.v8;
import com.ironsource.ve;
import com.ironsource.vp;
import com.ironsource.wu;
import com.ironsource.xf;
import com.ironsource.y8;
import com.ironsource.yf;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class e implements com.ironsource.sdk.controller.c, com.ironsource.sdk.controller.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.ironsource.sdk.controller.l f14931b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private CountDownTimer f14933d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ve f14936g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final wu f14937h;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final hm f14940k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f14930a = e.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private qf.b f14932c = qf.b.None;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k8 f14934e = new k8("NativeCommandExecutor");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final k8 f14935f = new k8("ControllerCommandsExecutor");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Map<String, l.a> f14938i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, l.b> f14939j = new HashMap();

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o9 f14942b;

        a(JSONObject jSONObject, o9 o9Var) {
            this.f14941a = jSONObject;
            this.f14942b = o9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14941a, this.f14942b);
            }
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ha f14944a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f14945b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o9 f14946c;

        b(ha haVar, Map map, o9 o9Var) {
            this.f14944a = haVar;
            this.f14945b = map;
            this.f14946c = o9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14944a, this.f14945b, this.f14946c);
            }
        }
    }

    class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14948a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14949b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ha f14950c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ n9 f14951d;

        c(String str, String str2, ha haVar, n9 n9Var) {
            this.f14948a = str;
            this.f14949b = str2;
            this.f14950c = haVar;
            this.f14951d = n9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14948a, this.f14949b, this.f14950c, this.f14951d);
            }
        }
    }

    class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n9 f14954b;

        d(JSONObject jSONObject, n9 n9Var) {
            this.f14953a = jSONObject;
            this.f14954b = n9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14953a, this.f14954b);
            }
        }
    }

    /* JADX INFO: renamed from: com.ironsource.sdk.controller.e$e, reason: collision with other inner class name */
    class RunnableC0267e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ha f14956a;

        RunnableC0267e(ha haVar) {
            this.f14956a = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14956a);
            }
        }
    }

    class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ha f14958a;

        f(ha haVar) {
            this.f14958a = haVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.b(this.f14958a);
            }
        }
    }

    class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ha f14960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f14961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ n9 f14962c;

        g(ha haVar, Map map, n9 n9Var) {
            this.f14960a = haVar;
            this.f14961b = map;
            this.f14962c = n9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14960a, this.f14961b, this.f14962c);
            }
        }
    }

    class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ l.a f14964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f.c f14965b;

        h(l.a aVar, f.c cVar) {
            this.f14964a = aVar;
            this.f14965b = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                if (this.f14964a != null) {
                    e.this.f14938i.put(this.f14965b.f(), this.f14964a);
                }
                e.this.f14931b.a(this.f14965b, this.f14964a);
            }
        }
    }

    class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14967a;

        i(JSONObject jSONObject) {
            this.f14967a = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.b(this.f14967a);
            }
        }
    }

    class j implements Runnable {
        j() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.destroy();
                e.this.f14931b = null;
            }
        }
    }

    class k extends CountDownTimer {
        k(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f14930a, "Global Controller Timer Finish");
            e.this.d(v8.c.f15708k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            Logger.i(e.this.f14930a, "Global Controller Timer Tick " + j10);
        }
    }

    class l implements Runnable {
        l() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.this.c();
        }
    }

    class m implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14973b;

        m(String str, String str2) {
            this.f14972a = str;
            this.f14973b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                e eVar = e.this;
                eVar.f14931b = eVar.b(eVar.f14937h.b(), e.this.f14937h.d(), e.this.f14937h.f(), e.this.f14937h.e(), e.this.f14937h.g(), e.this.f14937h.c(), this.f14972a, this.f14973b);
                e.this.f14931b.a();
            } catch (Throwable th) {
                i9.d().a(th);
                e.this.d(Log.getStackTraceString(th));
            }
        }
    }

    class n extends CountDownTimer {
        n(long j10, long j11) {
            super(j10, j11);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Logger.i(e.this.f14930a, "Recovered Controller | Global Controller Timer Finish");
            e.this.d(v8.c.f15708k);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            Logger.i(e.this.f14930a, "Recovered Controller | Global Controller Timer Tick " + j10);
        }
    }

    class o implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ha f14978c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ p9 f14979d;

        o(String str, String str2, ha haVar, p9 p9Var) {
            this.f14976a = str;
            this.f14977b = str2;
            this.f14978c = haVar;
            this.f14979d = p9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14976a, this.f14977b, this.f14978c, this.f14979d);
            }
        }
    }

    class p implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f14981a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ p9 f14982b;

        p(JSONObject jSONObject, p9 p9Var) {
            this.f14981a = jSONObject;
            this.f14982b = p9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14981a, this.f14982b);
            }
        }
    }

    class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f14985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ha f14986c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ o9 f14987d;

        q(String str, String str2, ha haVar, o9 o9Var) {
            this.f14984a = str;
            this.f14985b = str2;
            this.f14986c = haVar;
            this.f14987d = o9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14984a, this.f14985b, this.f14986c, this.f14987d);
            }
        }
    }

    class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f14989a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ o9 f14990b;

        r(String str, o9 o9Var) {
            this.f14989a = str;
            this.f14990b = o9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (e.this.f14931b != null) {
                e.this.f14931b.a(this.f14989a, this.f14990b);
            }
        }
    }

    class s implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ha f14992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ Map f14993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ o9 f14994c;

        s(ha haVar, Map map, o9 o9Var) {
            this.f14992a = haVar;
            this.f14993b = map;
            this.f14994c = o9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            xf.a(vp.f15942j, new sf().a(nb.f14124v, this.f14992a.f()).a(nb.f14125w, yf.a(this.f14992a, qf.e.Interstitial)).a(nb.f14126x, Boolean.valueOf(yf.a(this.f14992a))).a(nb.I, Long.valueOf(i0.f12521a.b(this.f14992a.h()))).a());
            if (e.this.f14931b != null) {
                e.this.f14931b.b(this.f14992a, this.f14993b, this.f14994c);
            }
        }
    }

    public e(Context context, y8 y8Var, ia iaVar, ve veVar, int i10, JSONObject jSONObject, String str, String str2, hm hmVar) {
        this.f14940k = hmVar;
        this.f14936g = veVar;
        String networkStorageDir = IronSourceStorageUtils.getNetworkStorageDir(context);
        ra raVarA = ra.a(networkStorageDir, veVar, jSONObject);
        this.f14937h = new wu(context, y8Var, iaVar, i10, raVarA, networkStorageDir);
        a(context, y8Var, iaVar, i10, raVarA, networkStorageDir, str, str2);
    }

    private l.a h() {
        return new l.a() { // from class: com.ironsource.sdk.controller.y
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                this.f15284a.a(aVar);
            }
        };
    }

    private l.b i() {
        return new l.b() { // from class: com.ironsource.sdk.controller.w
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(gl glVar) {
                this.f15274a.a(glVar);
            }
        };
    }

    private void k() {
        Logger.i(this.f14930a, "handleReadyState");
        this.f14932c = qf.b.Ready;
        CountDownTimer countDownTimer = this.f14933d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        m();
        this.f14935f.c();
        this.f14935f.a();
        com.ironsource.sdk.controller.l lVar = this.f14931b;
        if (lVar != null) {
            lVar.e();
        }
    }

    private boolean l() {
        return qf.b.Ready.equals(this.f14932c);
    }

    private void m() {
        this.f14937h.a(true);
        com.ironsource.sdk.controller.l lVar = this.f14931b;
        if (lVar != null) {
            lVar.a(this.f14937h.i());
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void destroy() {
        Logger.i(this.f14930a, "destroy controller");
        CountDownTimer countDownTimer = this.f14933d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        k8 k8Var = this.f14935f;
        if (k8Var != null) {
            k8Var.b();
        }
        this.f14933d = null;
        b(new j());
    }

    @Override // com.ironsource.sdk.controller.l
    @Deprecated
    public void e() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void f() {
        com.ironsource.sdk.controller.l lVar;
        if (!l() || (lVar = this.f14931b) == null) {
            return;
        }
        lVar.f();
    }

    @Override // com.ironsource.sdk.controller.l
    public qf.c g() {
        com.ironsource.sdk.controller.l lVar = this.f14931b;
        return lVar != null ? lVar.g() : qf.c.None;
    }

    public com.ironsource.sdk.controller.l j() {
        return this.f14931b;
    }

    private void e(String str) {
        IronSourceNetwork.updateInitFailed(new rf(1001, str));
    }

    @Override // com.ironsource.sdk.controller.l
    public void d() {
        com.ironsource.sdk.controller.l lVar;
        if (!l() || (lVar = this.f14931b) == null) {
            return;
        }
        lVar.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public v b(Context context, y8 y8Var, ia iaVar, int i10, ra raVar, String str, String str2, String str3) throws Throwable {
        xf.a(vp.f15935c);
        v vVar = new v(context, iaVar, y8Var, this, this.f14936g, i10, raVar, str, h(), i(), str2, str3);
        hc hcVar = new hc(context, raVar, new gc(this.f14936g.a()), new hl(raVar.a()));
        vVar.a(new u(context));
        vVar.a(new com.ironsource.sdk.controller.o(context));
        vVar.a(new com.ironsource.sdk.controller.q(context));
        vVar.a(new com.ironsource.sdk.controller.i(context));
        vVar.a(new com.ironsource.sdk.controller.a(context));
        vVar.a(new com.ironsource.sdk.controller.j(raVar.a(), hcVar));
        vVar.a(new l3());
        return vVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str) {
        xf.a(vp.f15936d, new sf().a(nb.A, str).a());
        this.f14932c = qf.b.Loading;
        this.f14931b = new com.ironsource.sdk.controller.n(str, this.f14936g);
        this.f14934e.c();
        this.f14934e.a();
        ve veVar = this.f14936g;
        if (veVar != null) {
            veVar.c(new l());
        }
    }

    @Override // com.ironsource.sdk.controller.c
    public void c() {
        Logger.i(this.f14930a, "handleControllerReady ");
        this.f14940k.a(g());
        if (qf.c.Web.equals(g())) {
            xf.a(vp.f15937e, new sf().a(nb.f14127y, String.valueOf(this.f14937h.l())).a());
            IronSourceNetwork.updateInitSucceeded();
        }
        k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Context context, y8 y8Var, ia iaVar, int i10, ra raVar, String str, String str2, String str3) {
        try {
            v vVarB = b(context, y8Var, iaVar, i10, raVar, str, str2, str3);
            this.f14931b = vVarB;
            vVarB.a();
        } catch (Throwable th) {
            i9.d().a(th);
            d(Log.getStackTraceString(th));
        }
    }

    @Override // com.ironsource.sdk.controller.c
    public void b() {
        Logger.i(this.f14930a, "handleControllerLoaded");
        this.f14932c = qf.b.Loaded;
        this.f14934e.c();
        this.f14934e.a();
    }

    @Override // com.ironsource.sdk.controller.l
    public void a() {
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(Context context) {
        com.ironsource.sdk.controller.l lVar;
        if (!l() || (lVar = this.f14931b) == null) {
            return;
        }
        lVar.b(context);
    }

    @Override // com.ironsource.sdk.controller.c
    public void c(String str) {
        xf.a(vp.f15957y, new sf().a(nb.f14127y, str).a());
        CountDownTimer countDownTimer = this.f14933d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Activity activity) {
        this.f14931b.a(activity);
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(ha haVar) {
        this.f14935f.a(new f(haVar));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(Context context) {
        com.ironsource.sdk.controller.l lVar;
        if (!l() || (lVar = this.f14931b) == null) {
            return;
        }
        lVar.a(context);
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(ha haVar, Map<String, String> map, o9 o9Var) {
        this.f14935f.a(new s(haVar, map, o9Var));
    }

    private void a(final Context context, final y8 y8Var, final ia iaVar, final int i10, final ra raVar, final String str, final String str2, final String str3) {
        int iA = el.N().d().a();
        if (iA > 0) {
            xf.a(vp.B, new sf().a(nb.f14127y, String.valueOf(iA)).a());
        }
        a(new Runnable() { // from class: com.ironsource.sdk.controller.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f15275a.c(context, y8Var, iaVar, i10, raVar, str, str2, str3);
            }
        }, iA);
        this.f14933d = new k(200000L, 1000L).start();
    }

    private void b(Runnable runnable) {
        a(runnable, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(gl glVar) {
        l.b bVar = this.f14939j.get(glVar.d());
        if (bVar != null) {
            bVar.a(glVar);
        }
    }

    @Override // com.ironsource.sdk.controller.c
    public void b(String str) {
        Logger.i(this.f14930a, "handleControllerFailed ");
        sf sfVar = new sf();
        sfVar.a(nb.A, str);
        sfVar.a(nb.f14127y, String.valueOf(this.f14937h.l()));
        xf.a(vp.f15947o, sfVar.a());
        this.f14937h.a(false);
        e(str);
        if (this.f14933d != null) {
            Logger.i(this.f14930a, "cancel timer mControllerReadyTimer");
            this.f14933d.cancel();
        }
        d(str);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar) {
        this.f14935f.a(new RunnableC0267e(haVar));
    }

    @Override // com.ironsource.sdk.controller.l
    public void b(JSONObject jSONObject) {
        this.f14935f.a(new i(jSONObject));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar, Map<String, String> map, n9 n9Var) {
        this.f14935f.a(new g(haVar, map, n9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(ha haVar, Map<String, String> map, o9 o9Var) {
        this.f14935f.a(new b(haVar, map, o9Var));
    }

    @Override // com.ironsource.nd
    public void a(@NotNull jd jdVar) {
        vp.a aVar;
        sf sfVar;
        StringBuilder sb;
        ld ldVarB = jdVar.b();
        if (ldVarB == ld.SendEvent) {
            aVar = vp.A;
            sfVar = new sf();
            sb = new StringBuilder();
        } else {
            if (ldVarB != ld.NativeController) {
                return;
            }
            com.ironsource.sdk.controller.n nVar = new com.ironsource.sdk.controller.n(jdVar.a(), this.f14936g);
            this.f14931b = nVar;
            this.f14940k.a(nVar.g());
            xf.a(vp.f15936d, new sf().a(nb.A, jdVar.a() + " : strategy: " + ldVarB).a());
            aVar = vp.A;
            sfVar = new sf();
            sb = new StringBuilder();
        }
        sb.append(jdVar.a());
        sb.append(" : strategy: ");
        sb.append(ldVarB);
        xf.a(aVar, sfVar.a(nb.f14127y, sb.toString()).a());
    }

    private void a(qf.e eVar, ha haVar, String str, String str2) {
        Logger.i(this.f14930a, "recoverWebController for product: " + eVar.toString());
        sf sfVar = new sf();
        sfVar.a(nb.f14125w, eVar.toString());
        sfVar.a(nb.f14124v, haVar.f());
        xf.a(vp.f15934b, sfVar.a());
        this.f14937h.n();
        destroy();
        b(new m(str, str2));
        this.f14933d = new n(200000L, 1000L).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(f.a aVar) {
        l.a aVarRemove = this.f14938i.remove(aVar.c());
        if (aVarRemove != null) {
            aVarRemove.a(aVar);
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(f.c cVar, @Nullable l.a aVar) {
        this.f14935f.a(new h(aVar, cVar));
    }

    public void a(Runnable runnable) {
        this.f14934e.a(runnable);
    }

    private void a(Runnable runnable, long j10) {
        ve veVar = this.f14936g;
        if (veVar != null) {
            veVar.d(runnable, j10);
        } else {
            Logger.e(this.f14930a, "mThreadManager = null");
        }
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, o9 o9Var) {
        Logger.i(this.f14930a, "load interstitial");
        this.f14935f.a(new r(str, o9Var));
    }

    public void a(String str, l.b bVar) {
        this.f14939j.put(str, bVar);
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, n9 n9Var) {
        if (this.f14937h.a(g(), this.f14932c)) {
            a(qf.e.Banner, haVar, str, str2);
        }
        this.f14935f.a(new c(str, str2, haVar, n9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, o9 o9Var) {
        if (this.f14937h.a(g(), this.f14932c)) {
            a(qf.e.Interstitial, haVar, str, str2);
        }
        this.f14935f.a(new q(str, str2, haVar, o9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(String str, String str2, ha haVar, p9 p9Var) {
        if (this.f14937h.a(g(), this.f14932c)) {
            a(qf.e.RewardedVideo, haVar, str, str2);
        }
        this.f14935f.a(new o(str, str2, haVar, p9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject) {
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, n9 n9Var) {
        this.f14935f.a(new d(jSONObject, n9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, o9 o9Var) {
        this.f14935f.a(new a(jSONObject, o9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public void a(JSONObject jSONObject, p9 p9Var) {
        this.f14935f.a(new p(jSONObject, p9Var));
    }

    @Override // com.ironsource.sdk.controller.l
    public boolean a(String str) {
        if (this.f14931b == null || !l()) {
            return false;
        }
        return this.f14931b.a(str);
    }
}
