package com.ironsource.mediationsdk;

import android.content.Context;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.TextUtils;
import com.ironsource.cr;
import com.ironsource.d4;
import com.ironsource.dr;
import com.ironsource.el;
import com.ironsource.en;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.fl;
import com.ironsource.fr;
import com.ironsource.i9;
import com.ironsource.ja;
import com.ironsource.kb;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.qq;
import com.ironsource.rp;
import com.ironsource.rq;
import com.ironsource.sd;
import com.ironsource.so;
import com.ironsource.t3;
import com.ironsource.uo;
import com.ironsource.vi;
import com.ironsource.vm;
import com.ironsource.x3;
import com.ironsource.xc;
import com.ironsource.zn;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
class s implements vm {
    private static s A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private fr f13847a;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private NetworkStateReceiver f13862p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private CountDownTimer f13863q;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private String f13866t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private cr f13867u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private SegmentListener f13868v;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f13870x;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f13848b = e.f13887f;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private sd f13849c = el.N().t();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13850d = "appKey";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f13851e = getClass().getSimpleName();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f13858l = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f13860n = false;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<en> f13864r = new ArrayList();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private String f13865s = "";

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private f f13872z = new a();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Handler f13859m = IronSourceThreadManager.INSTANCE.getInitHandler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13852f = 1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f13853g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f13854h = 62;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f13855i = 12;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f13856j = 5;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private AtomicBoolean f13861o = new AtomicBoolean(true);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f13857k = false;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f13869w = false;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private vi f13871y = new vi();

    class a extends f {
        a() {
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            dr drVarI;
            try {
                p pVarM = p.m();
                if (!TextUtils.isEmpty(s.this.f13865s)) {
                    xc.a().a("userId", s.this.f13865s);
                }
                if (!TextUtils.isEmpty(s.this.f13866t)) {
                    xc.a().a("appKey", s.this.f13866t);
                }
                s.this.f13871y.i(s.this.f13865s);
                s.this.f13870x = new Date().getTime();
                so.c().a();
                s.this.f13867u = pVarM.b(ContextProvider.getInstance().getApplicationContext(), s.this.f13865s, this.f13890c);
                if (s.this.f13867u != null) {
                    s.this.f13859m.removeCallbacks(this);
                    if (s.this.f13867u.p()) {
                        s.this.b(d.INITIATED);
                        new fl().a(s.this.f13867u.c().b().d().b(), pVarM.B());
                        d4 d4VarE = s.this.f13867u.c().b().e();
                        if (d4VarE != null) {
                            ja jaVar = ja.f12717a;
                            jaVar.c(d4VarE.g());
                            jaVar.a(d4VarE.f());
                            jaVar.a(d4VarE.j());
                            IronSourceThreadManager.INSTANCE.setUseSharedExecutorService(d4VarE.h());
                            s.this.f13849c.a(d4VarE);
                        }
                        s.this.a(ContextProvider.getInstance().getApplicationContext(), s.this.f13867u);
                        pVarM.a(new Date().getTime() - s.this.f13870x, s.this.f13867u.h());
                        if (d4VarE != null && d4VarE.e()) {
                            new uo(rp.i(), new h9.a() { // from class: com.ironsource.mediationsdk.b0
                                @Override // h9.a
                                public final Object invoke() {
                                    return Long.valueOf(System.currentTimeMillis());
                                }
                            }, el.N(), IronSourceThreadManager.INSTANCE.getThreadPoolExecutor()).c(ContextProvider.getInstance().getApplicationContext());
                        }
                        s.this.f13847a = new fr();
                        s.this.f13847a.a(s.this.f13849c);
                        if (s.this.f13867u.c().b().f() && ContextProvider.getInstance().getApplicationContext() != null) {
                            IntegrationHelper.validateIntegration(ContextProvider.getInstance().getApplicationContext());
                        }
                        List<IronSource.AD_UNIT> listG = s.this.f13867u.g();
                        Iterator it = s.this.f13864r.iterator();
                        while (it.hasNext()) {
                            ((en) it.next()).a(listG, s.this.h(), s.this.f13867u.c());
                        }
                        new zn.a().a();
                        if (s.this.f13868v != null && (drVarI = s.this.f13867u.c().b().i()) != null && !TextUtils.isEmpty(drVarI.c())) {
                            s.this.f13868v.onSegmentReceived(drVarI.c());
                        }
                        x3 x3VarC = s.this.f13867u.c().b().c();
                        if (x3VarC.f()) {
                            i9.d().a(x3VarC.b(), x3VarC.d(), x3VarC.c(), x3VarC.e(), IronSourceUtils.getSessionId(), x3VarC.a(), x3VarC.g());
                        }
                    } else if (!s.this.f13858l) {
                        s.this.b(d.INIT_FAILED);
                        s.this.f13858l = true;
                        Iterator it2 = s.this.f13864r.iterator();
                        while (it2.hasNext()) {
                            ((en) it2.next()).d("serverResponseIsNotValid");
                        }
                    }
                } else {
                    if (s.this.f13853g == 3) {
                        s.this.f13869w = true;
                        Iterator it3 = s.this.f13864r.iterator();
                        while (it3.hasNext()) {
                            ((en) it3.next()).a();
                        }
                    }
                    if (this.f13888a && s.this.f13853g < s.this.f13854h) {
                        s.this.f13857k = true;
                        s.this.f13859m.postDelayed(this, s.this.f13852f * 1000);
                        if (s.this.f13853g < s.this.f13855i) {
                            s.a(s.this, 2);
                        }
                    }
                    if ((!this.f13888a || s.this.f13853g == s.this.f13856j) && !s.this.f13858l) {
                        s.this.f13858l = true;
                        if (TextUtils.isEmpty(this.f13889b)) {
                            this.f13889b = "noServerResponse";
                        }
                        Iterator it4 = s.this.f13864r.iterator();
                        while (it4.hasNext()) {
                            ((en) it4.next()).d(this.f13889b);
                        }
                        s.this.b(d.INIT_FAILED);
                        IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No server response", 1);
                    }
                    s.f(s.this);
                }
                s.this.e();
            } catch (Exception e10) {
                i9.d().a(e10);
                IronLog.INTERNAL.error(e10.toString());
            }
        }
    }

    class b implements Runnable {

        class a extends CountDownTimer {
            a(long j10, long j11) {
                super(j10, j11);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                if (s.this.f13858l) {
                    return;
                }
                s.this.f13858l = true;
                Iterator it = s.this.f13864r.iterator();
                while (it.hasNext()) {
                    ((en) it.next()).d("noInternetConnection");
                }
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, "Mediation availability false reason: No internet connection", 1);
            }

            @Override // android.os.CountDownTimer
            public void onTick(long j10) {
                if (j10 <= 45000) {
                    s.this.f13869w = true;
                    Iterator it = s.this.f13864r.iterator();
                    while (it.hasNext()) {
                        ((en) it.next()).a();
                    }
                }
            }
        }

        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            s.this.f13863q = new a(60000L, 15000L).start();
        }
    }

    static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13876a;

        static {
            int[] iArr = new int[d.values().length];
            f13876a = iArr;
            try {
                iArr[d.INIT_IN_PROGRESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13876a[d.INIT_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13876a[d.INITIATED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    enum d {
        NOT_INIT,
        INIT_IN_PROGRESS,
        INIT_FAILED,
        INITIATED
    }

    public static class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static int f13882a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static int f13883b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static int f13884c = 2;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static int f13885d = 3;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static int f13886e = 4;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static int f13887f = 5;
    }

    abstract class f implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f13889b;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f13888a = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected p.c f13890c = new a();

        class a implements p.c {
            a() {
            }

            @Override // com.ironsource.mediationsdk.p.c
            public void a(String str) {
                f fVar = f.this;
                fVar.f13888a = false;
                fVar.f13889b = str;
            }
        }

        f() {
        }
    }

    private s() {
    }

    private static int a(d dVar) {
        int i10 = c.f13876a[dVar.ordinal()];
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? e.f13882a : e.f13883b : e.f13886e : e.f13885d;
    }

    public static synchronized s c() {
        if (A == null) {
            A = new s();
        }
        return A;
    }

    static /* synthetic */ int f(s sVar) {
        int i10 = sVar.f13853g;
        sVar.f13853g = i10 + 1;
        return i10;
    }

    public int b() {
        return this.f13848b;
    }

    public synchronized boolean d() {
        return this.f13869w;
    }

    static /* synthetic */ int a(s sVar, int i10) {
        int i11 = sVar.f13852f * i10;
        sVar.f13852f = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (el.N().d().b()) {
            rp.i().a(new kb(IronSourceConstants.EP_CONFIG_RECEIVED, null));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        return this.f13857k;
    }

    void f() {
        b(d.INIT_FAILED);
    }

    public synchronized void g() {
        int iA = a(a());
        this.f13848b = iA;
        this.f13871y.c(iA);
    }

    public void b(en enVar) {
        if (enVar == null || this.f13864r.size() == 0) {
            return;
        }
        this.f13864r.remove(enVar);
    }

    public synchronized void b(d dVar) {
        IronLog.INTERNAL.verbose("old status: " + a() + ", new status: " + dVar + ")");
        rq.f14723a.a(qq.values()[dVar.ordinal()]);
    }

    public synchronized d a() {
        return d.values()[rq.f14723a.a().ordinal()];
    }

    public void a(Context context, cr crVar) {
        this.f13871y.i(crVar.f().h());
        this.f13871y.b(crVar.f().d());
        t3 t3VarB = crVar.c().b();
        this.f13871y.a(t3VarB.a());
        this.f13871y.c(t3VarB.b().b());
        this.f13871y.b(t3VarB.j().b());
        this.f13871y.a(Boolean.valueOf(IronSourceUtils.getFirstSession(context)));
        d4 d4VarE = crVar.c().b().e();
        this.f13871y.b(d4VarE.b());
        el.I().v().a(d4VarE.c());
    }

    public synchronized void a(Context context, String str, String str2, IronSource.AD_UNIT... ad_unitArr) {
        try {
            AtomicBoolean atomicBoolean = this.f13861o;
            if (atomicBoolean == null || !atomicBoolean.compareAndSet(true, false)) {
                IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.API, this.f13851e + ": Multiple calls to init are not allowed", 2);
            } else {
                b(d.INIT_IN_PROGRESS);
                this.f13865s = str2;
                this.f13866t = str;
                if (IronSourceUtils.isNetworkConnected(context)) {
                    this.f13859m.post(this.f13872z);
                } else {
                    this.f13860n = true;
                    if (this.f13862p == null) {
                        this.f13862p = new NetworkStateReceiver(context, this);
                    }
                    context.registerReceiver(this.f13862p, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new b());
                }
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(e10.toString());
        }
    }

    public void a(en enVar) {
        if (enVar == null) {
            return;
        }
        this.f13864r.add(enVar);
    }

    public void a(SegmentListener segmentListener) {
        this.f13868v = segmentListener;
    }

    @Override // com.ironsource.vm
    public void a(boolean z10) {
        if (this.f13860n && z10) {
            CountDownTimer countDownTimer = this.f13863q;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f13860n = false;
            this.f13857k = true;
            rp.i().a(new kb(IronSourceConstants.INIT_AFTER_REACHABILITY_CHANGE, IronSourceUtils.getMediationAdditionalData(false)));
            this.f13859m.post(this.f13872z);
        }
    }
}
