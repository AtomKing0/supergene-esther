package com.ironsource;

import android.content.Context;
import android.content.IntentFilter;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.NetworkStateReceiver;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.g2;
import com.ironsource.k7;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.h;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
import com.ironsource.qe;
import com.ironsource.t7;
import com.ironsource.x1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class h7<Smash extends k7<?>, Listener extends AdapterAdListener> implements j2, l4, w1, xk, vm, o, pu, r7, ko {
    private AdInfo A;
    private lj B;
    final mg C;
    final mg.a D;
    protected final qe E;
    private final qe.a F;
    private boolean G;
    private ts H;
    private AtomicBoolean I;

    @Nullable
    private ti J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected ou<Smash> f12401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected ConcurrentHashMap<String, h.a> f12402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected com.ironsource.mediationsdk.e f12403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected com.ironsource.mediationsdk.h f12404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f12405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected String f12406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected JSONObject f12407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected f5 f12408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected Placement f12409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected boolean f12410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private NetworkStateReceiver f12411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected hr f12412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected ta f12413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    protected ta f12414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    protected q0 f12415o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    protected f f12416p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected i2 f12417q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    protected yb f12418r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    protected x1 f12419s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    protected e2 f12420t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    protected r f12421u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    protected IronSourceSegment f12422v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    protected UUID f12423w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    protected final Object f12424x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private long f12425y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private Boolean f12426z;

    class a extends yp {
        a() {
        }

        @Override // com.ironsource.yp
        public void a() {
            h7.this.B();
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ NetworkSettings f12428a;

        b(NetworkSettings networkSettings) {
            this.f12428a = networkSettings;
        }

        @Override // java.lang.Runnable
        public void run() {
            h7.this.c(this.f12428a);
        }
    }

    class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            h7.this.D();
        }
    }

    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h7.this.f12407g = new JSONObject();
            h7.this.f12419s.f16110i.a();
            HashMap map = new HashMap();
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList2 = new ArrayList();
            h7.this.b(map, arrayList, sb, arrayList2);
            if (h7.this.f12415o.e()) {
                h7.this.a(map, arrayList, sb, arrayList2);
            } else {
                h7.this.a(map, arrayList, sb.toString());
            }
        }
    }

    class e implements t7.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map f12432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ StringBuilder f12433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ List f12434c;

        e(Map map, StringBuilder sb, List list) {
            this.f12432a = map;
            this.f12433b = sb;
            this.f12434c = list;
        }

        @Override // com.ironsource.t7.b
        public void a(@NotNull List<u7> list, long j10, @NotNull List<String> list2) {
            h7.this.f12419s.f16109h.a(j10);
            for (u7 u7Var : list) {
                NetworkSettings networkSettingsA = h7.this.f12415o.a(u7Var.c());
                Map<String, Object> mapB = h7.this.b(networkSettingsA, com.ironsource.mediationsdk.c.b().b(networkSettingsA, h7.this.f12415o.b(), h7.this.k()));
                if (u7Var.a() != null) {
                    this.f12432a.put(u7Var.c(), u7Var.a());
                    StringBuilder sb = this.f12433b;
                    sb.append(u7Var.d());
                    sb.append(u7Var.c());
                    sb.append(",");
                    h7.this.f12419s.f16109h.a(mapB, u7Var.e());
                } else {
                    h7.this.f12419s.f16109h.a(mapB, u7Var.e(), u7Var.b());
                }
            }
            Iterator<String> it = list2.iterator();
            while (it.hasNext()) {
                NetworkSettings networkSettingsA2 = h7.this.f12415o.a(it.next());
                h7.this.f12419s.f16109h.b(h7.this.b(networkSettingsA2, com.ironsource.mediationsdk.c.b().b(networkSettingsA2, h7.this.f12415o.b(), h7.this.k())), j10);
            }
            h7.this.a((Map<String, Object>) this.f12432a, (List<String>) this.f12434c, this.f12433b.toString());
        }

        @Override // com.ironsource.t7.b
        public void onFailure(String str) {
            h7.this.f12419s.f16109h.a(str);
            h7.this.a((Map<String, Object>) this.f12432a, (List<String>) this.f12434c, this.f12433b.toString());
        }
    }

    protected enum f {
        NONE,
        READY_TO_LOAD,
        AUCTION,
        LOADING,
        READY_TO_SHOW,
        SHOWING
    }

    h7(me meVar, le leVar, q0 q0Var, lj ljVar, IronSourceSegment ironSourceSegment) {
        this.f12406f = "";
        this.f12410j = false;
        this.f12424x = new Object();
        this.f12425y = 0L;
        this.I = new AtomicBoolean(false);
        this.f12423w = UUID.randomUUID();
        this.C = meVar.k();
        this.D = leVar.e();
        this.E = meVar.x();
        this.F = leVar.m();
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + q0Var.b() + ", loading mode = " + q0Var.i().a());
        StringBuilder sb = new StringBuilder();
        sb.append(q0Var.b());
        sb.append(" initiated object per waterfall mode");
        IronSourceUtils.sendAutomationLog(sb.toString());
        ta taVar = new ta();
        this.J = a(q0Var);
        this.f12422v = ironSourceSegment;
        this.f12415o = q0Var;
        this.f12419s = new x1(q0Var.b(), x1.b.MEDIATION, this);
        this.f12420t = g();
        this.f12417q = h();
        a(f.NONE);
        this.B = ljVar;
        this.f12401a = new ou<>(this.f12415o.d().f(), this.f12415o.d().i(), this);
        this.f12419s.f16107f.a(o(), this.f12415o.i().a().toString());
        this.f12402b = new ConcurrentHashMap<>();
        this.f12409i = null;
        G();
        this.f12407g = new JSONObject();
        if (this.f12415o.r()) {
            this.f12403c = new com.ironsource.mediationsdk.e(new com.ironsource.mediationsdk.f(this.f12415o.d(), IronSourceUtils.getSessionId()));
        }
        this.f12404d = new com.ironsource.mediationsdk.h(this.f12415o.k(), this.f12415o.d().c());
        s();
        r();
        this.f12413m = new ta();
        a(f.READY_TO_LOAD);
        this.f12418r = new yb(q0Var.a(), this);
        this.f12421u = new r();
        this.f12419s.f16107f.a(ta.a(taVar));
        if (this.f12415o.i().e()) {
            ironLog.verbose("first automatic load");
            A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        f fVar;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        synchronized (this.f12424x) {
            if (this.f12415o.i().e() && this.f12412l.a()) {
                ironLog.verbose(b("all smashes are capped"));
                a(t1.a(this.f12415o.b()), "all smashes are capped", false);
                return;
            }
            if (!t() && this.f12416p == f.SHOWING) {
                IronLog.API.error(b("load cannot be invoked while showing an ad"));
                a(new IronSourceError(t1.d(this.f12415o.b()), "load cannot be invoked while showing an ad"));
                return;
            }
            if (this.f12415o.i().a() != g2.a.AUTOMATIC_LOAD_WHILE_SHOW && this.f12415o.i().a() != g2.a.MANUAL_WITH_LOAD_ON_SHOW && (((fVar = this.f12416p) != f.READY_TO_LOAD && fVar != f.READY_TO_SHOW) || com.ironsource.mediationsdk.n.a().b(this.f12415o.b()))) {
                IronLog.API.error(b("load is already in progress"));
                return;
            }
            this.f12407g = new JSONObject();
            F();
            if (v()) {
                this.f12419s.f16108g.a();
            } else {
                this.f12419s.f16108g.a(q());
            }
            this.f12414n = new ta();
            if (this.f12415o.r()) {
                if (!this.f12402b.isEmpty()) {
                    this.f12404d.a(this.f12402b);
                    this.f12402b.clear();
                }
                K();
            } else {
                a(f.LOADING);
            }
            if (this.f12415o.r()) {
                return;
            }
            ironLog.verbose(b("auction disabled"));
            L();
            C();
        }
    }

    private void C() {
        uu<Smash> uuVarE = E();
        if (uuVarE.c()) {
            a(509, "Mediation No fill", false);
        }
        Iterator<Smash> it = uuVarE.a().iterator();
        while (it.hasNext()) {
            it.next().E();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        IronLog.INTERNAL.verbose(i());
        AsyncTask.execute(new d());
    }

    private uu<Smash> E() {
        IronLog.INTERNAL.verbose();
        return new tu(this.f12415o).d(this.f12401a.b());
    }

    private void F() {
        this.f12421u.a(this.f12415o.b(), false);
    }

    private void K() {
        IronLog.INTERNAL.verbose(i());
        synchronized (this.f12424x) {
            f fVar = this.f12416p;
            f fVar2 = f.AUCTION;
            if (fVar == fVar2) {
                return;
            }
            a(fVar2);
            this.I.set(false);
            long jK = this.f12415o.d().k() - ta.a(this.f12413m);
            if (jK > 0) {
                new Timer().schedule(new c(), jK);
            } else {
                D();
            }
        }
    }

    private void L() {
        IronLog.INTERNAL.verbose(i());
        a(j(), m());
    }

    private Smash a(f5 f5Var, String str) {
        NetworkSettings networkSettingsA = this.f12415o.a(f5Var.c());
        if (networkSettingsA != null) {
            com.ironsource.mediationsdk.c.b().b(networkSettingsA, this.f12415o.b(), k());
            BaseAdAdapter<?, Listener> baseAdAdapterA = a(networkSettingsA, this.f12415o.b());
            if (baseAdAdapterA != null) {
                Smash smash = (Smash) a(networkSettingsA, baseAdAdapterA, this.C.a(this.f12415o.b()), str, f5Var);
                this.f12402b.put(f5Var.c(), h.a.ISAuctionPerformanceDidntAttemptToLoad);
                return smash;
            }
            IronLog.INTERNAL.error(b("addSmashToWaterfall - could not load ad adapter for " + networkSettingsA.getProviderInstanceName()));
        } else {
            String str2 = "could not find matching provider settings for auction response item - item = " + f5Var.c() + " state = " + this.f12416p;
            IronLog.INTERNAL.error(b(str2));
            this.f12419s.f16112k.g(str2);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(NetworkSettings networkSettings) {
        IronLog.INTERNAL.verbose(b(String.format("Start initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName())));
        AdData adDataA = a(networkSettings, this.f12415o.p());
        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f12415o.b(), k());
        if (adapterBaseInterfaceB != null) {
            try {
                adapterBaseInterfaceB.init(adDataA, ContextProvider.getInstance().getApplicationContext(), null);
            } catch (Exception e10) {
                i9.d().a(e10);
                this.f12419s.f16112k.f("initProvider - exception while calling networkAdapter.init with " + networkSettings.getProviderName() + " - " + e10);
            }
        }
        IronLog.INTERNAL.verbose(b(String.format("Done initializing provider %s on thread %s", networkSettings.getProviderInstanceName(), Thread.currentThread().getName())));
    }

    private boolean d(NetworkSettings networkSettings) {
        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f12415o.b(), k());
        if (adapterBaseInterfaceB instanceof AdapterSettingsInterface) {
            return this.f12401a.a(this.f12415o.i().a(), networkSettings.getProviderInstanceName(), networkSettings.getProviderTypeForReflection(), a(networkSettings, adapterBaseInterfaceB), adapterBaseInterfaceB, this.f12415o.b());
        }
        return false;
    }

    private List<f5> j() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (NetworkSettings networkSettings : this.f12415o.k()) {
            if (!networkSettings.isBidder(this.f12415o.b()) && d(networkSettings)) {
                gr grVar = new gr(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.f12415o.b()));
                if (!this.f12412l.b(grVar)) {
                    copyOnWriteArrayList.add(new f5(grVar.c()));
                }
            }
        }
        return copyOnWriteArrayList;
    }

    private int p() {
        return 1;
    }

    private void r() {
        IronLog.INTERNAL.verbose(i());
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings networkSettings : this.f12415o.k()) {
            if (c(networkSettings, com.ironsource.mediationsdk.c.b().b(networkSettings, this.f12415o.b(), k()))) {
                arrayList.add(new b(networkSettings));
            }
        }
        IronSourceThreadManager.INSTANCE.executeTasks(this.f12415o.l(), this.f12415o.q(), arrayList);
    }

    private void s() {
        ArrayList arrayList = new ArrayList();
        for (NetworkSettings networkSettings : this.f12415o.k()) {
            arrayList.add(new gr(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.f12415o.b())));
        }
        hr hrVar = new hr();
        this.f12412l = hrVar;
        hrVar.a(arrayList);
    }

    public void A() {
        if (c()) {
            a(new a());
        } else {
            B();
        }
    }

    protected void G() {
        com.ironsource.mediationsdk.n.a().a(this.f12415o.b(), this.f12415o.g());
    }

    protected boolean H() {
        return true;
    }

    protected boolean I() {
        return true;
    }

    public void J() {
        Iterator<NetworkSettings> it = this.f12415o.k().iterator();
        while (it.hasNext()) {
            com.ironsource.mediationsdk.c.b().b(it.next(), this.f12415o.b(), k());
        }
    }

    protected abstract Smash a(NetworkSettings networkSettings, BaseAdAdapter<?, Listener> baseAdAdapter, int i10, String str, f5 f5Var);

    protected String b(String str) {
        String str2 = this.f12415o.b().name() + " state:" + this.f12416p;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    protected abstract JSONObject b(NetworkSettings networkSettings);

    @Override // com.ironsource.j2
    public void e(k7<?> k7Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(k7Var.k()));
        if (!k7Var.h().equals(this.f12401a.c())) {
            ironLog.error(b("invoked from " + k7Var.c() + " with state = " + this.f12416p + " auctionId: " + k7Var.h() + " and the current id is " + this.f12401a.c()));
            ut utVar = this.f12419s.f16112k;
            StringBuilder sb = new StringBuilder();
            sb.append("onAdLoadSuccess invoked with state = ");
            sb.append(this.f12416p);
            utVar.n(sb.toString());
            return;
        }
        if (this.f12415o.n()) {
            List<Smash> listB = this.f12401a.b();
            tu tuVar = new tu(this.f12415o);
            boolean zA = tuVar.a(k7Var, listB);
            synchronized (this.f12424x) {
                if (zA) {
                    if (w()) {
                        i(k7Var);
                    }
                }
                if (tuVar.a(listB)) {
                    i(tuVar.c(listB));
                }
            }
        }
        this.f12402b.put(k7Var.c(), h.a.ISAuctionPerformanceLoadedSuccessfully);
        if (a(f.LOADING, f.READY_TO_SHOW)) {
            long jA = ta.a(this.f12414n);
            if (v()) {
                this.f12419s.f16108g.a(jA);
            } else {
                this.f12419s.f16108g.a(jA, q());
            }
            if (this.f12415o.i().e()) {
                this.f12418r.a(0L);
            }
            if (!this.f12415o.n()) {
                i(k7Var);
            }
            h(k7Var);
        }
    }

    @Override // com.ironsource.j2
    public void f(k7<?> k7Var) {
        IronLog.INTERNAL.verbose(b(k7Var.k()));
        this.f12419s.f16111j.a(n());
        this.f12420t.a(this.f12409i, k7Var.f());
    }

    protected abstract e2 g();

    protected void g(k7<?> k7Var) {
        this.f12420t.d(k7Var.f());
    }

    protected i2 h() {
        return new i2(this.f12415o.i(), this);
    }

    protected String i() {
        return b((String) null);
    }

    public UUID k() {
        return this.f12423w;
    }

    protected abstract String l();

    protected String m() {
        return "fallback_" + System.currentTimeMillis();
    }

    protected String n() {
        Placement placement = this.f12409i;
        return placement == null ? "" : placement.getPlacementName();
    }

    abstract String o();

    protected boolean q() {
        return false;
    }

    protected boolean t() {
        return false;
    }

    protected boolean u() {
        return false;
    }

    protected abstract boolean v();

    protected boolean w() {
        boolean z10;
        synchronized (this.f12424x) {
            f fVar = this.f12416p;
            z10 = fVar == f.LOADING || fVar == f.READY_TO_SHOW;
        }
        return z10;
    }

    protected boolean x() {
        boolean z10;
        synchronized (this.f12424x) {
            z10 = this.f12416p == f.READY_TO_SHOW;
        }
        return z10;
    }

    protected boolean y() {
        boolean z10;
        synchronized (this.f12424x) {
            z10 = this.f12416p == f.AUCTION;
        }
        return z10;
    }

    protected boolean z() {
        boolean z10;
        synchronized (this.f12424x) {
            z10 = this.f12416p == f.LOADING;
        }
        return z10;
    }

    public h7(q0 q0Var, lj ljVar, IronSourceSegment ironSourceSegment) {
        this(el.N(), el.I(), q0Var, ljVar, ironSourceSegment);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Object> b(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        HashMap map = new HashMap();
        try {
            map.put(IronSourceConstants.EVENTS_PROVIDER, networkSettings.getProviderDefaultInstance());
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, adapterBaseInterface.getAdapterVersion());
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, adapterBaseInterface.getNetworkSDKVersion());
            map.put("spId", networkSettings.getSubProviderId());
            map.put("instanceType", Integer.valueOf(networkSettings.getInstanceType(this.f12415o.b())));
            map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(p()));
        } catch (Exception e10) {
            i9.d().a(e10);
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.INTERNAL, "getProviderEventData " + networkSettings.getProviderDefaultInstance(), e10);
        }
        return map;
    }

    protected LoadWhileShowSupportState a(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        return LoadWhileShowSupportState.NONE;
    }

    @Override // com.ironsource.ko
    public boolean c() {
        ti tiVar = this.J;
        if (tiVar == null || tiVar == Thread.currentThread()) {
            return false;
        }
        return this.f12415o.m();
    }

    protected void h(k7<?> k7Var) {
        if (this.f12415o.i().f()) {
            a(k7Var, k7Var.f());
        } else {
            a(true, false, k7Var);
        }
    }

    protected void i(k7<?> k7Var) {
        if (this.f12415o.r() && this.I.compareAndSet(false, true)) {
            f5 f5VarI = k7Var.i();
            this.f12403c.a(f5VarI, k7Var.l(), this.f12408h);
            ArrayList<String> arrayList = new ArrayList<>();
            ConcurrentHashMap<String, f5> concurrentHashMap = new ConcurrentHashMap<>();
            for (Smash smash : this.f12401a.b()) {
                arrayList.add(smash.c());
                concurrentHashMap.put(smash.c(), smash.i());
            }
            this.f12403c.a(arrayList, concurrentHashMap, k7Var.l(), this.f12408h, f5VarI);
        }
    }

    private boolean c(NetworkSettings networkSettings, AdapterBaseInterface adapterBaseInterface) {
        if (this.f12401a.a(adapterBaseInterface, this.f12415o.b(), networkSettings.getProviderInstanceName())) {
            return false;
        }
        return networkSettings.shouldEarlyInit() || networkSettings.isIronSource() || networkSettings.isBidder(this.f12415o.b());
    }

    protected BaseAdAdapter<?, Listener> a(NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        BaseAdAdapter<?, Listener> baseAdAdapter = (BaseAdAdapter<?, Listener>) com.ironsource.mediationsdk.c.b().a(networkSettings, ad_unit, k());
        if (baseAdAdapter != null) {
            return baseAdAdapter;
        }
        return null;
    }

    @Override // com.ironsource.o
    public void b() {
        if (this.f12415o.i().e()) {
            a(f.READY_TO_LOAD);
            b(true);
            A();
        }
    }

    private boolean c(u1 u1Var) {
        return new ArrayList(Arrays.asList(u1.LOAD_AD_SUCCESS, u1.LOAD_AD_FAILED, u1.LOAD_AD_FAILED_WITH_REASON, u1.AUCTION_SUCCESS, u1.AUCTION_FAILED, u1.AUCTION_FAILED_NO_CANDIDATES, u1.AD_FORMAT_CAPPED, u1.AD_OPENED, u1.SHOW_AD, u1.SHOW_AD_FAILED, u1.AD_CLICKED, u1.RELOAD_AD_FAILED_WITH_REASON, u1.RELOAD_AD_SUCCESS, u1.AD_LEFT_APPLICATION)).contains(u1Var);
    }

    protected AdData a(NetworkSettings networkSettings, String str) {
        return AdData.createAdDataForNetworkAdapter(b(networkSettings), this.f12415o.b(), str);
    }

    protected void b(f5 f5Var, String str) {
        if (f5Var == null) {
            IronLog.INTERNAL.error(b("reportImpressionDataToPublisher - no auctionResponseItem or listener"));
            x1 x1Var = this.f12419s;
            if (x1Var != null) {
                x1Var.f16112k.f("reportImpressionDataToPublisher - no auctionResponseItem or listener");
                return;
            }
            return;
        }
        ImpressionData impressionDataA = f5Var.a(str);
        if (impressionDataA != null) {
            for (ImpressionDataListener impressionDataListener : new HashSet(this.B.a())) {
                IronLog.CALLBACK.info(b("onImpressionSuccess " + impressionDataListener.getClass().getSimpleName() + ": " + impressionDataA));
                impressionDataListener.onImpressionSuccess(impressionDataA);
            }
        }
    }

    @Nullable
    private ti a(q0 q0Var) {
        if (q0Var.m()) {
            return IronSourceThreadManager.INSTANCE.getSharedManagersThread();
        }
        return null;
    }

    private boolean c(boolean z10) {
        Boolean bool = this.f12426z;
        if (bool == null) {
            return false;
        }
        return (z10 && !bool.booleanValue() && u()) || (!z10 && this.f12426z.booleanValue());
    }

    protected String a(f5 f5Var, int i10) {
        return String.format("%s%s", Integer.valueOf(i10), f5Var.c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private String a(List<f5> list, String str) {
        IronLog.INTERNAL.verbose(b("waterfall.size() = " + list.size()));
        this.f12402b.clear();
        StringBuilder sb = new StringBuilder();
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            f5 f5Var = list.get(i10);
            k7 k7VarA = a(f5Var, str);
            if (k7VarA != null) {
                copyOnWriteArrayList.add(k7VarA);
                sb.append(a(f5Var, k7VarA.l()));
            }
            if (i10 != list.size() - 1) {
                sb.append(",");
            }
        }
        this.f12401a.a(this.f12415o.i().a(), copyOnWriteArrayList, str);
        IronLog.INTERNAL.verbose(b("updateWaterfall() - next waterfall is " + ((Object) sb)));
        return sb.toString();
    }

    @Override // com.ironsource.j2
    public void b(k7<?> k7Var) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b(k7Var.k()));
        this.f12419s.f16111j.g(n());
        this.f12401a.a(k7Var);
        this.f12401a.b(k7Var);
        this.f12412l.a(k7Var);
        if (this.f12412l.b(k7Var)) {
            ironLog.verbose(b(k7Var.c() + " was session capped"));
            k7Var.N();
            IronSourceUtils.sendAutomationLog(k7Var.c() + " was session capped");
        }
        this.F.a(ContextProvider.getInstance().getApplicationContext(), n(), this.f12415o.b());
        if (this.E.b(ContextProvider.getInstance().getApplicationContext(), this.f12409i, this.f12415o.b())) {
            ironLog.verbose(b("placement " + n() + " is capped"));
            this.f12419s.f16111j.b(n(), null);
        }
        this.D.b(this.f12415o.b());
        if (this.f12415o.r()) {
            f5 f5VarI = k7Var.i();
            this.f12403c.a(f5VarI, k7Var.l(), this.f12408h, n());
            this.f12402b.put(k7Var.c(), h.a.ISAuctionPerformanceShowedSuccessfully);
            if (H()) {
                b(f5VarI, n());
            }
        }
        g(k7Var);
        if (this.f12415o.i().e()) {
            b(false);
        }
        this.f12417q.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Map<String, Object> map, List<String> list, StringBuilder sb, List<q7> list2) {
        StringBuilder sb2;
        String providerName;
        String string;
        StringBuilder sb3;
        String str;
        for (NetworkSettings networkSettings : this.f12415o.k()) {
            ts tsVar = this.H;
            if (tsVar == null || tsVar.a(networkSettings, this.f12415o.b())) {
                if (!this.f12412l.b(new gr(networkSettings.getProviderInstanceName(), networkSettings.getMaxAdsPerSession(this.f12415o.b()))) && d(networkSettings)) {
                    AdData adDataA = a(networkSettings, (String) null);
                    if (networkSettings.isBidder(this.f12415o.b())) {
                        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f12415o.b(), k());
                        if (!(adapterBaseInterfaceB instanceof s7)) {
                            if (adapterBaseInterfaceB == null) {
                                sb2 = new StringBuilder();
                                sb2.append("prepareAuctionCandidates - could not load network adapter ");
                                providerName = networkSettings.getProviderName();
                            } else {
                                sb2 = new StringBuilder();
                                sb2.append("network adapter ");
                                sb2.append(networkSettings.getProviderName());
                                providerName = " does not implementing BiddingDataInterface";
                            }
                            sb2.append(providerName);
                            string = sb2.toString();
                        } else if (this.f12415o.e()) {
                            list2.add(new q7(networkSettings.getInstanceType(this.f12415o.b()), networkSettings.getProviderInstanceName(), adDataA, (s7) adapterBaseInterfaceB, this, networkSettings));
                        } else {
                            try {
                                Map<String, Object> mapA = ((s7) adapterBaseInterfaceB).a(adDataA);
                                if (mapA != null) {
                                    map.put(networkSettings.getProviderInstanceName(), mapA);
                                    sb.append(networkSettings.getInstanceType(this.f12415o.b()));
                                    sb.append(networkSettings.getProviderInstanceName());
                                    sb.append(",");
                                } else {
                                    this.f12419s.f16112k.a(b(networkSettings, adapterBaseInterfaceB), "Missing bidding data");
                                }
                            } catch (Exception e10) {
                                e = e10;
                                i9.d().a(e);
                                sb3 = new StringBuilder();
                                str = "prepareAuctionCandidates - exception while calling networkAdapter.getBiddingData - ";
                                sb3.append(str);
                                sb3.append(e.getMessage());
                                string = sb3.toString();
                                IronLog.INTERNAL.error(string);
                                this.f12419s.f16112k.f(string);
                            } catch (NoClassDefFoundError e11) {
                                e = e11;
                                i9.d().a(e);
                                sb3 = new StringBuilder();
                                str = "prepareAuctionCandidates - error while calling networkAdapter.getBiddingData - ";
                                sb3.append(str);
                                sb3.append(e.getMessage());
                                string = sb3.toString();
                                IronLog.INTERNAL.error(string);
                                this.f12419s.f16112k.f(string);
                            }
                        }
                        this.f12419s.f16112k.f(string);
                    } else {
                        list.add(networkSettings.getProviderInstanceName());
                        sb.append(networkSettings.getInstanceType(this.f12415o.b()));
                        sb.append(networkSettings.getProviderInstanceName());
                        sb.append(",");
                    }
                }
            }
        }
    }

    private void b(JSONObject jSONObject) {
        int i10;
        try {
            if (jSONObject == null) {
                this.f12415o.b(false);
                IronLog.INTERNAL.verbose(b("loading configuration from auction response is null, using the following: " + this.f12415o.s()));
                return;
            }
            try {
                if (jSONObject.has(com.ironsource.mediationsdk.d.f13342w) && (i10 = jSONObject.getInt(com.ironsource.mediationsdk.d.f13342w)) > 0) {
                    this.f12415o.a(i10);
                }
                if (jSONObject.has(com.ironsource.mediationsdk.d.f13343x)) {
                    this.f12415o.a(jSONObject.getBoolean(com.ironsource.mediationsdk.d.f13343x));
                }
                this.f12415o.b(jSONObject.optBoolean(com.ironsource.mediationsdk.d.f13344y, false));
            } catch (JSONException e10) {
                i9.d().a(e10);
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.error("failed to update loading configuration for" + this.f12415o.b() + " Error: " + e10.getMessage());
                ironLog.verbose(b(this.f12415o.s()));
            }
        } finally {
            IronLog.INTERNAL.verbose(b(this.f12415o.s()));
        }
    }

    @Override // com.ironsource.w1
    public Map<String, Object> a(u1 u1Var) {
        HashMap map = new HashMap();
        map.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, 1);
        JSONObject jSONObject = this.f12407g;
        if (jSONObject != null && jSONObject.length() > 0) {
            map.put("genericParams", this.f12407g);
        }
        map.put("sessionDepth", Integer.valueOf(this.C.a(this.f12415o.b())));
        if (c(u1Var)) {
            map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f12405e));
            if (!TextUtils.isEmpty(this.f12406f)) {
                map.put(IronSourceConstants.AUCTION_FALLBACK, this.f12406f);
            }
        }
        if (b(u1Var) && !TextUtils.isEmpty(this.f12401a.c())) {
            map.put("auctionId", this.f12401a.c());
        }
        return map;
    }

    @Override // com.ironsource.xk
    public void a() {
        IronLog.INTERNAL.verbose(i());
        A();
    }

    protected void b(boolean z10) {
        a(false, z10, (k7<?>) null);
    }

    private boolean b(u1 u1Var) {
        return !new ArrayList(Arrays.asList(u1.INIT_STARTED, u1.LOAD_AD, u1.AUCTION_REQUEST, u1.AUCTION_REQUEST_WATERFALL, u1.AUCTION_FAILED_NO_CANDIDATES, u1.COLLECT_TOKEN, u1.COLLECT_TOKENS_COMPLETED, u1.COLLECT_TOKENS_FAILED, u1.INSTANCE_COLLECT_TOKEN, u1.INSTANCE_COLLECT_TOKEN_SUCCESS, u1.INSTANCE_COLLECT_TOKEN_FAILED, u1.INSTANCE_COLLECT_TOKEN_TIMED_OUT)).contains(u1Var);
    }

    @Override // com.ironsource.pu
    public void a(int i10) {
        this.f12419s.f16112k.t("waterfalls hold too many with size = " + i10);
    }

    @Override // com.ironsource.l4
    public void a(int i10, String str, int i11, String str2, long j10) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        if (!y()) {
            String str3 = "unexpected auction fail - error = " + i10 + ", " + str + " state = " + this.f12416p;
            ironLog.error(b(str3));
            this.f12419s.f16112k.h(str3);
            return;
        }
        String str4 = "Auction failed | moving to fallback waterfall (error " + i10 + " - " + str + ")";
        ironLog.verbose(b(str4));
        IronSourceUtils.sendAutomationLog(l() + ": " + str4);
        this.f12405e = i11;
        this.f12406f = str2;
        this.f12407g = new JSONObject();
        L();
        this.f12419s.f16110i.a(j10, i10, str);
        a(f.LOADING);
        C();
    }

    protected void a(int i10, String str, boolean z10) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose();
        a(f.READY_TO_LOAD);
        ironLog.verbose(b("errorCode = " + i10 + ", errorReason = " + str));
        if (this.f12415o.i().f()) {
            if (!z10) {
                this.f12419s.f16108g.a(ta.a(this.f12414n), i10, str);
            }
            a(new IronSourceError(i10, str));
        } else {
            if (!z10) {
                this.f12419s.f16112k.b(i10, str);
            }
            b(false);
        }
        this.f12417q.e();
    }

    protected void a(Context context, com.ironsource.mediationsdk.i iVar, l4 l4Var) {
        com.ironsource.mediationsdk.e eVar = this.f12403c;
        if (eVar != null) {
            eVar.a(context, iVar, l4Var);
        } else {
            IronLog.INTERNAL.error(b("mAuctionHandler is null"));
        }
    }

    public void a(Context context, boolean z10) {
        IronLog.INTERNAL.verbose(b("track = " + z10));
        try {
            this.f12410j = z10;
            if (z10) {
                if (this.f12411k == null) {
                    this.f12411k = new NetworkStateReceiver(context, this);
                }
                context.getApplicationContext().registerReceiver(this.f12411k, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } else if (this.f12411k != null) {
                context.getApplicationContext().unregisterReceiver(this.f12411k);
            }
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error("Got an error from receiver with message: " + e10.getMessage());
        }
    }

    protected void a(e2 e2Var) {
        this.f12420t = e2Var;
    }

    protected void a(f fVar) {
        synchronized (this.f12424x) {
            IronLog.INTERNAL.verbose("set current state to = " + fVar);
            this.f12416p = fVar;
        }
    }

    protected void a(k7<?> k7Var, AdInfo adInfo) {
        this.f12420t.c(adInfo);
    }

    public void a(IronSourceSegment ironSourceSegment) {
        this.f12422v = ironSourceSegment;
    }

    protected void a(IronSourceError ironSourceError) {
        com.ironsource.mediationsdk.n.a().b(this.f12415o.b(), ironSourceError);
    }

    @Override // com.ironsource.j2
    public void a(IronSourceError ironSourceError, k7<?> k7Var) {
        uu<Smash> uuVarE;
        k7<?> k7VarC;
        synchronized (this.f12424x) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose(b(k7Var.k() + " - error = " + ironSourceError));
            if (k7Var.h().equals(this.f12401a.c()) && this.f12416p != f.AUCTION) {
                this.f12402b.put(k7Var.c(), h.a.ISAuctionPerformanceFailedToLoad);
                if (z() || x()) {
                    uuVarE = E();
                    if (uuVarE.c()) {
                        a(509, "Mediation No fill", false);
                        return;
                    }
                } else {
                    uuVarE = null;
                }
                if (uuVarE == null) {
                    return;
                }
                if (this.f12415o.n()) {
                    synchronized (this.f12424x) {
                        if (uuVarE.b() && w() && (k7VarC = new tu(this.f12415o).c(this.f12401a.b())) != null) {
                            i(k7VarC);
                        }
                    }
                }
                Iterator<Smash> it = uuVarE.a().iterator();
                while (it.hasNext()) {
                    it.next().E();
                }
                return;
            }
            ironLog.error(b("onAdLoadFailed was invoked from " + k7Var.c() + " with state =" + this.f12416p + " auctionId: " + k7Var.h() + " and the current id is " + this.f12401a.c()));
            ut utVar = this.f12419s.f16112k;
            StringBuilder sb = new StringBuilder();
            sb.append("onAdLoadFailed was invoked with state =");
            sb.append(this.f12416p);
            utVar.m(sb.toString());
        }
    }

    @Override // com.ironsource.r7
    public void a(NetworkSettings networkSettings) {
        AdapterBaseInterface adapterBaseInterfaceB = com.ironsource.mediationsdk.c.b().b(networkSettings, this.f12415o.b(), k());
        if (adapterBaseInterfaceB != null) {
            this.f12419s.f16109h.a(b(networkSettings, adapterBaseInterfaceB));
        }
    }

    public void a(ts tsVar) {
        this.H = tsVar;
        this.G = tsVar != null;
        this.f12426z = null;
    }

    @Override // com.ironsource.ko
    public void a(Runnable runnable) {
        ti tiVar = this.J;
        if (tiVar != null) {
            tiVar.a(runnable);
        }
    }

    @Override // com.ironsource.r7
    public void a(String str) {
        this.f12419s.f16112k.f(str);
    }

    @Override // com.ironsource.l4
    public void a(List<f5> list, String str, f5 f5Var, JSONObject jSONObject, JSONObject jSONObject2, int i10, long j10, int i11, String str2) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(i());
        if (!y()) {
            ironLog.error(b("unexpected auction success for auctionId - " + str + " state = " + this.f12416p));
            ut utVar = this.f12419s.f16112k;
            StringBuilder sb = new StringBuilder();
            sb.append("unexpected auction success, state = ");
            sb.append(this.f12416p);
            utVar.i(sb.toString());
            return;
        }
        this.f12406f = "";
        this.f12405e = i10;
        this.f12408h = f5Var;
        this.f12407g = jSONObject;
        if (!TextUtils.isEmpty(str2)) {
            this.f12419s.f16112k.a(i11, str2);
        }
        a(jSONObject2);
        if (this.f12421u.a(this.f12415o.b())) {
            this.f12419s.f16110i.a(str);
            a(IronSourceError.ERROR_AD_FORMAT_CAPPED, "Ad unit is capped", true);
            return;
        }
        String strA = a(list, str);
        this.f12419s.f16110i.a(j10, this.f12415o.s());
        this.f12419s.f16110i.c(strA);
        a(f.LOADING);
        C();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(b("auction waterfallString = " + str));
        boolean z10 = false;
        if (map.size() == 0 && list.size() == 0) {
            ironLog.verbose(b("auction failed - no candidates"));
            this.f12419s.f16110i.a(1005, "No candidates available for auctioning");
            a(t1.e(this.f12415o.b()), "no available ad to load", false);
            return;
        }
        this.f12419s.f16110i.b(str);
        if (this.f12403c == null) {
            ironLog.error(b("mAuctionHandler is null"));
            return;
        }
        int iA = this.C.a(this.f12415o.b());
        com.ironsource.mediationsdk.i iVar = new com.ironsource.mediationsdk.i(this.f12415o.b());
        iVar.b(IronSourceUtils.isEncryptedResponse());
        iVar.a(map);
        iVar.a(list);
        iVar.a(this.f12404d);
        iVar.a(iA);
        iVar.a(this.f12422v);
        iVar.d(this.G);
        ts tsVar = this.H;
        if (tsVar != null && tsVar.b()) {
            z10 = true;
        }
        iVar.e(z10);
        a(ContextProvider.getInstance().getApplicationContext(), iVar, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Map<String, Object> map, List<String> list, StringBuilder sb, List<q7> list2) {
        if (list2.isEmpty()) {
            a(map, list, sb.toString());
            return;
        }
        t7 t7Var = new t7();
        e eVar = new e(map, sb, list);
        this.f12419s.f16109h.a();
        t7Var.a(list2, eVar, this.f12415o.f(), TimeUnit.MILLISECONDS);
    }

    private void a(JSONObject jSONObject) {
        this.f12421u.a(this.f12415o.b(), jSONObject != null ? jSONObject.optBoolean(com.ironsource.mediationsdk.d.f13324e, false) : false);
        b(jSONObject);
    }

    @Override // com.ironsource.vm
    public void a(boolean z10) {
        if (!this.f12410j || this.f12415o.i().f()) {
            return;
        }
        IronLog.INTERNAL.verbose("network availability changed to - " + z10);
        if (c(z10)) {
            a(z10, false, (k7<?>) null);
        }
    }

    protected void a(boolean z10, boolean z11, k7<?> k7Var) {
        synchronized (this.f12424x) {
            Boolean bool = this.f12426z;
            if (bool == null || bool.booleanValue() != z10) {
                this.f12426z = Boolean.valueOf(z10);
                long time = 0;
                if (this.f12425y != 0) {
                    time = new Date().getTime() - this.f12425y;
                }
                this.f12425y = new Date().getTime();
                this.f12419s.f16108g.a(z10, time, z11);
                AdInfo adInfoF = k7Var != null ? k7Var.f() : this.A;
                this.A = adInfoF;
                e2 e2Var = this.f12420t;
                if (!z10) {
                    adInfoF = null;
                }
                e2Var.a(z10, adInfoF);
            }
        }
    }

    protected boolean a(f fVar, f fVar2) {
        boolean z10;
        synchronized (this.f12424x) {
            if (this.f12416p == fVar) {
                IronLog.INTERNAL.verbose("expected state = " + fVar + ", state to set = " + fVar2);
                this.f12416p = fVar2;
                z10 = true;
            } else {
                IronLog.INTERNAL.verbose("wrong state, current state = " + this.f12416p + ", expected state = " + fVar);
                z10 = false;
            }
        }
        return z10;
    }
}
