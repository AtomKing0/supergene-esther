package com.ironsource;

import android.text.TextUtils;
import com.ironsource.environment.ContextProvider;
import com.ironsource.gs;
import com.ironsource.j2;
import com.ironsource.lg;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAdFullScreenInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdInfo;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.x1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class k7<Listener extends j2> implements NetworkInitializationListener, gs.a, w1, AdapterAdListener, lg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected i1 f12817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Listener f12818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected BaseAdAdapter<?, AdapterAdListener> f12819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected x1 f12820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected h f12821e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected Placement f12823g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    protected v2 f12824h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected JSONObject f12825i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected String f12826j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected AdData f12827k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    protected Long f12828l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected ta f12829m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final f5 f12831o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final ko f12832p;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private AtomicBoolean f12822f = new AtomicBoolean(false);

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private gs f12830n = new gs(TimeUnit.SECONDS.toMillis(s()));

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    protected final Object f12833q = new Object();

    class a extends yp {
        a() {
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.L();
        }
    }

    class b extends yp {
        b() {
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.K();
        }
    }

    class c extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f12836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f12837b;

        c(int i10, String str) {
            this.f12836a = i10;
            this.f12837b = str;
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.a(this.f12836a, this.f12837b);
        }
    }

    class d extends yp {
        d() {
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.I();
        }
    }

    class e extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AdapterErrorType f12840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f12841b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f12842c;

        e(AdapterErrorType adapterErrorType, int i10, String str) {
            this.f12840a = adapterErrorType;
            this.f12841b = i10;
            this.f12842c = str;
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.a(this.f12840a, this.f12841b, this.f12842c);
        }
    }

    class f extends yp {
        f() {
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.J();
        }
    }

    class g extends yp {
        g() {
        }

        @Override // com.ironsource.yp
        public void a() {
            k7.this.H();
        }
    }

    protected enum h {
        NONE,
        INIT_IN_PROGRESS,
        READY_TO_LOAD,
        LOADING,
        LOADED,
        SHOWING,
        FAILED
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k7(ko koVar, i1 i1Var, BaseAdAdapter<?, ?> baseAdAdapter, v2 v2Var, f5 f5Var, Listener listener) {
        this.f12817a = i1Var;
        this.f12818b = listener;
        this.f12820d = new x1(i1Var.a(), x1.b.PROVIDER, this);
        this.f12824h = v2Var;
        this.f12825i = v2Var.c();
        this.f12819c = baseAdAdapter;
        this.f12831o = f5Var;
        this.f12832p = koVar;
        a(h.NONE);
    }

    private boolean D() {
        return this.f12821e == h.INIT_IN_PROGRESS;
    }

    private void F() {
        IronLog.INTERNAL.verbose(d());
        a(h.LOADING);
        a(false);
        try {
            this.f12830n.a((gs.a) this);
            G();
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage() + " - state = " + this.f12821e;
            IronLog.INTERNAL.error(a(str));
            x1 x1Var = this.f12820d;
            if (x1Var != null) {
                x1Var.f16112k.f(str);
            }
            onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        IronLog.INTERNAL.verbose(d());
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.a(j());
        }
        this.f12818b.f(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        boolean zO;
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        gs gsVar = this.f12830n;
        if (gsVar != null) {
            gsVar.e();
        }
        synchronized (this.f12833q) {
            h hVar = this.f12821e;
            zO = false;
            if (hVar == h.LOADING) {
                long jA = ta.a(this.f12829m);
                ironLog.verbose(a("Load duration = " + jA));
                if (this.f12820d != null) {
                    if (v()) {
                        this.f12820d.f16108g.a(jA);
                    } else {
                        this.f12820d.f16108g.a(jA, false);
                    }
                }
                a(h.LOADED);
                zO = O();
            } else if (hVar != h.FAILED) {
                ironLog.error(a(String.format("unexpected load success for %s, state - %s", k(), this.f12821e)));
                String str = String.format("unexpected load success, state - %s", this.f12821e);
                if (this.f12820d != null) {
                    if (v()) {
                        this.f12820d.f16112k.q(str);
                    } else {
                        this.f12820d.f16112k.n(str);
                    }
                }
            }
        }
        if (zO) {
            this.f12818b.e(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        IronLog.INTERNAL.verbose(d());
        a(h.SHOWING);
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.g(j());
        }
        this.f12818b.b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        if (D()) {
            gs gsVar = this.f12830n;
            if (gsVar != null) {
                gsVar.e();
            }
            a(h.READY_TO_LOAD);
            F();
            return;
        }
        if (this.f12821e == h.FAILED) {
            return;
        }
        ironLog.error(a(String.format("unexpected init success for %s, state - %s", k(), this.f12821e)));
        if (this.f12820d != null) {
            this.f12820d.f16112k.l(String.format("unexpected init success, state - %s", this.f12821e));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        long jA = ta.a(this.f12829m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + jA + ", state = " + this.f12821e + ", isBidder = " + w()));
        synchronized (this.f12833q) {
            if (!z()) {
                ironLog.error(a(String.format("unexpected timeout for %s, state - %s, error - %s", k(), this.f12821e, 1025)));
                if (this.f12820d != null) {
                    this.f12820d.f16112k.s(String.format("unexpected timeout, state - %s, error - %s", this.f12821e, 1025));
                }
            } else {
                a(h.FAILED);
                x1 x1Var = this.f12820d;
                if (x1Var != null) {
                    x1Var.f16108g.a(jA, 1025);
                    this.f12820d.f16108g.a(jA, 1025, "time out");
                }
                this.f12818b.a(ErrorBuilder.buildLoadFailedError("time out"), this);
            }
        }
    }

    private int o() {
        return 1;
    }

    private int s() {
        f5 f5Var = this.f12831o;
        if (f5Var == null) {
            return this.f12817a.f();
        }
        Integer numE = f5Var.e();
        int iF = (numE == null || numE.intValue() <= 0) ? this.f12817a.f() : numE.intValue();
        IronLog.INTERNAL.verbose(a("Load timeout for " + this.f12831o.c() + " - " + iF + " seconds"));
        return iF;
    }

    public AtomicBoolean A() {
        return this.f12822f;
    }

    public boolean B() {
        return y();
    }

    public boolean C() {
        return this.f12821e == h.SHOWING;
    }

    public void E() {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(d());
        f5 f5VarI = i();
        String strJ = f5VarI.j();
        Map<String, Object> mapA = hj.a(f5VarI.a());
        mapA.put("adUnit", this.f12817a.a());
        b(strJ);
        try {
            boolean z10 = false;
            if (v()) {
                this.f12820d.f16108g.a();
            } else {
                this.f12820d.f16108g.a(false);
            }
            this.f12828l = null;
            this.f12829m = new ta();
            this.f12827k = a(strJ, mapA);
            synchronized (this.f12833q) {
                if (this.f12821e != h.NONE) {
                    z10 = true;
                } else {
                    a(h.INIT_IN_PROGRESS);
                }
            }
            if (z10) {
                String str = "loadAd - incorrect state while loading, state = " + this.f12821e;
                ironLog.error(a(str));
                this.f12820d.f16112k.f(str);
                onInitFailed(t1.c(this.f12817a.a()), str);
                return;
            }
            this.f12830n.a((gs.a) this);
            AdapterBaseInterface networkAdapter = this.f12819c.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.f12827k, ContextProvider.getInstance().getApplicationContext(), this);
                return;
            }
            String str2 = "loadAd - network adapter not available " + k();
            ironLog.error(a(str2));
            onInitFailed(t1.c(this.f12817a.a()), str2);
        } catch (Throwable th) {
            i9.d().a(th);
            String str3 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str3));
            x1 x1Var = this.f12820d;
            if (x1Var != null) {
                x1Var.f16112k.f(str3);
            }
            onInitFailed(t1.c(this.f12817a.a()), str3);
        }
    }

    protected void G() {
        Object obj = this.f12819c;
        if (obj instanceof AdapterAdFullScreenInterface) {
            ((AdapterAdFullScreenInterface) obj).loadAd(this.f12827k, ContextProvider.getInstance().getCurrentActiveActivity(), this);
        } else {
            IronLog.INTERNAL.error(a("adapter not instance of AdapterAdFullScreenInterface"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0057 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0006, B:12:0x0053, B:14:0x0057, B:15:0x005c, B:17:0x0060, B:18:0x0065, B:9:0x000d, B:11:0x004e), top: B:25:0x0001, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0060 A[Catch: all -> 0x0067, TryCatch #1 {, blocks: (B:3:0x0001, B:6:0x0006, B:12:0x0053, B:14:0x0057, B:15:0x005c, B:17:0x0060, B:18:0x0065, B:9:0x000d, B:11:0x004e), top: B:25:0x0001, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void M() {
        /*
            r4 = this;
            monitor-enter(r4)
            com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter<?, com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener> r0 = r4.f12819c     // Catch: java.lang.Throwable -> L67
            r1 = 0
            if (r0 == 0) goto L53
            r0.releaseMemory()     // Catch: java.lang.Exception -> Lc java.lang.Throwable -> L67
            r4.f12819c = r1     // Catch: java.lang.Exception -> Lc java.lang.Throwable -> L67
            goto L53
        Lc:
            r0 = move-exception
            com.ironsource.i9 r2 = com.ironsource.i9.d()     // Catch: java.lang.Throwable -> L67
            r2.a(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L67
            r2.<init>()     // Catch: java.lang.Throwable -> L67
            java.lang.String r3 = "Exception while calling adapter.releaseMemory() from "
            r2.append(r3)     // Catch: java.lang.Throwable -> L67
            com.ironsource.v2 r3 = r4.f12824h     // Catch: java.lang.Throwable -> L67
            java.lang.String r3 = r3.f()     // Catch: java.lang.Throwable -> L67
            r2.append(r3)     // Catch: java.lang.Throwable -> L67
            java.lang.String r3 = " - "
            r2.append(r3)     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L67
            r2.append(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = " - state = "
            r2.append(r0)     // Catch: java.lang.Throwable -> L67
            com.ironsource.k7$h r0 = r4.f12821e     // Catch: java.lang.Throwable -> L67
            r2.append(r0)     // Catch: java.lang.Throwable -> L67
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L67
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch: java.lang.Throwable -> L67
            java.lang.String r3 = r4.a(r0)     // Catch: java.lang.Throwable -> L67
            r2.error(r3)     // Catch: java.lang.Throwable -> L67
            com.ironsource.x1 r2 = r4.f12820d     // Catch: java.lang.Throwable -> L67
            if (r2 == 0) goto L53
            com.ironsource.ut r2 = r2.f16112k     // Catch: java.lang.Throwable -> L67
            r2.f(r0)     // Catch: java.lang.Throwable -> L67
        L53:
            com.ironsource.x1 r0 = r4.f12820d     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L5c
            r0.f()     // Catch: java.lang.Throwable -> L67
            r4.f12820d = r1     // Catch: java.lang.Throwable -> L67
        L5c:
            com.ironsource.gs r0 = r4.f12830n     // Catch: java.lang.Throwable -> L67
            if (r0 == 0) goto L65
            r0.d()     // Catch: java.lang.Throwable -> L67
            r4.f12830n = r1     // Catch: java.lang.Throwable -> L67
        L65:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L67
            return
        L67:
            r0 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L67
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.k7.M():void");
    }

    public void N() {
        IronLog.INTERNAL.verbose(d());
        x1 x1Var = this.f12820d;
        if (x1Var != null) {
            x1Var.f16111j.a();
        }
    }

    protected boolean O() {
        return true;
    }

    protected AdData a(String str, Map<String, Object> map) {
        return new AdData(str, q(), a(map));
    }

    @Override // com.ironsource.lg.b
    public int b() {
        return this.f12824h.e();
    }

    @Override // com.ironsource.lg.b
    public String c() {
        return this.f12824h.f();
    }

    protected String d() {
        return a((String) null);
    }

    public Long e() {
        return this.f12828l;
    }

    public AdInfo f() {
        return new AdInfo(this.f12831o.a(j()));
    }

    public IronSource.AD_UNIT g() {
        return this.f12817a.a();
    }

    public String h() {
        return this.f12817a.c();
    }

    public f5 i() {
        return this.f12831o;
    }

    protected String j() {
        Placement placement = this.f12823g;
        return placement == null ? "" : placement.getPlacementName();
    }

    public String k() {
        return String.format("%s %s", c(), Integer.valueOf(hashCode()));
    }

    public int l() {
        return this.f12824h.d();
    }

    public String m() {
        return this.f12824h.h().isMultipleInstances() ? this.f12824h.h().getProviderTypeForReflection() : this.f12824h.f();
    }

    public String n() {
        return this.f12824h.g();
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        if (this.f12832p.c()) {
            this.f12832p.a(new g());
        } else {
            H();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(@NotNull AdapterErrorType adapterErrorType, int i10, String str) {
        if (this.f12832p.c()) {
            this.f12832p.a(new e(adapterErrorType, i10, str));
        } else {
            a(adapterErrorType, i10, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess() {
        if (this.f12832p.c()) {
            this.f12832p.a(new d());
        } else {
            I();
        }
    }

    public void onAdOpened() {
        if (this.f12832p.c()) {
            this.f12832p.a(new f());
        } else {
            J();
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitFailed(int i10, String str) {
        if (this.f12832p.c()) {
            this.f12832p.a(new c(i10, str));
        } else {
            a(i10, str);
        }
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
    public void onInitSuccess() {
        if (this.f12832p.c()) {
            this.f12832p.a(new b());
        } else {
            K();
        }
    }

    public NetworkSettings p() {
        return this.f12817a.g();
    }

    protected Map<String, Object> q() {
        HashMap map = new HashMap();
        map.putAll(hj.a(this.f12825i));
        return map;
    }

    public Integer r() {
        i1 i1Var = this.f12817a;
        if (i1Var != null) {
            return Integer.valueOf(i1Var.h());
        }
        return null;
    }

    public h t() {
        return this.f12821e;
    }

    protected ko u() {
        return this.f12832p;
    }

    protected boolean v() {
        return false;
    }

    public boolean w() {
        return this.f12824h.j();
    }

    public boolean x() {
        return this.f12821e == h.FAILED;
    }

    public boolean y() {
        return this.f12821e == h.LOADED;
    }

    public boolean z() {
        h hVar = this.f12821e;
        return hVar == h.INIT_IN_PROGRESS || hVar == h.LOADING;
    }

    protected String a(String str) {
        String str2 = this.f12817a.a().name() + " - " + k() + " - state = " + this.f12821e;
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str2 + " - " + str;
    }

    public Map<String, Object> a(u1 u1Var) {
        HashMap map = new HashMap();
        try {
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter = this.f12819c;
            map.put(IronSourceConstants.EVENTS_PROVIDER_ADAPTER_VERSION, baseAdAdapter != null ? baseAdAdapter.getNetworkAdapter().getAdapterVersion() : "");
            BaseAdAdapter<?, AdapterAdListener> baseAdAdapter2 = this.f12819c;
            map.put(IronSourceConstants.EVENTS_PROVIDER_SDK_VERSION, baseAdAdapter2 != null ? baseAdAdapter2.getNetworkAdapter().getNetworkSDKVersion() : "");
        } catch (Exception e10) {
            i9.d().a(e10);
            IronLog.INTERNAL.error(a("could not get adapter version for event data" + k()));
        }
        map.put("spId", this.f12824h.i());
        map.put(IronSourceConstants.EVENTS_PROVIDER, this.f12824h.a());
        map.put("instanceType", Integer.valueOf(l()));
        map.put(IronSourceConstants.EVENTS_PROGRAMMATIC, Integer.valueOf(o()));
        if (!TextUtils.isEmpty(this.f12826j)) {
            map.put("dynamicDemandSource", this.f12826j);
        }
        map.put("sessionDepth", r());
        if (this.f12817a.e() != null && this.f12817a.e().length() > 0) {
            map.put("genericParams", this.f12817a.e());
        }
        if (!TextUtils.isEmpty(this.f12817a.c())) {
            map.put("auctionId", this.f12817a.c());
        }
        if (b(u1Var)) {
            map.put(IronSourceConstants.AUCTION_TRIALS, Integer.valueOf(this.f12817a.d()));
            if (!TextUtils.isEmpty(this.f12817a.b())) {
                map.put(IronSourceConstants.AUCTION_FALLBACK, this.f12817a.b());
            }
        }
        if (!TextUtils.isEmpty(this.f12817a.g().getCustomNetwork())) {
            map.put(IronSourceConstants.EVENTS_CUSTOM_NETWORK_FIELD, this.f12817a.g().getCustomNetwork());
        }
        return map;
    }

    public void b(String str) {
        this.f12826j = com.ironsource.mediationsdk.d.b().c(str);
    }

    private boolean b(u1 u1Var) {
        return new ArrayList(Arrays.asList(u1.LOAD_AD, u1.LOAD_AD_SUCCESS, u1.LOAD_AD_FAILED, u1.LOAD_AD_FAILED_WITH_REASON, u1.LOAD_AD_NO_FILL, u1.RELOAD_AD, u1.RELOAD_AD_SUCCESS, u1.RELOAD_AD_FAILED_WITH_REASON, u1.RELOAD_AD_NO_FILL, u1.DESTROY_AD, u1.AD_PRESENT_SCREEN, u1.AD_DISMISS_SCREEN, u1.AD_LEFT_APPLICATION, u1.AD_OPENED, u1.AD_CLOSED, u1.SHOW_AD, u1.SHOW_AD_FAILED, u1.AD_CLICKED, u1.AD_REWARDED)).contains(u1Var);
    }

    protected Map<String, Object> a(Map<String, Object> map) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put("userId", this.f12817a.i());
        return map;
    }

    @Override // com.ironsource.gs.a
    public void a() {
        if (this.f12832p.c()) {
            this.f12832p.a(new a());
        } else {
            L();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i10, String str) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("error = " + i10 + ", " + str));
        if (D()) {
            gs gsVar = this.f12830n;
            if (gsVar != null) {
                gsVar.e();
            }
            a(h.FAILED);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i10, str, ta.a(this.f12829m));
            this.f12818b.a(new IronSourceError(i10, str), this);
            return;
        }
        if (this.f12821e == h.FAILED) {
            return;
        }
        ironLog.error(a(String.format("unexpected init failed for %s, state - %s, error - %s, %s", k(), this.f12821e, Integer.valueOf(i10), str)));
        if (this.f12820d != null) {
            this.f12820d.f16112k.k(String.format("unexpected init failed, state - %s, error - %s, %s", this.f12821e, Integer.valueOf(i10), str));
        }
    }

    protected void a(h hVar) {
        IronLog.INTERNAL.verbose(d());
        this.f12821e = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NotNull AdapterErrorType adapterErrorType, int i10, String str) {
        long jA = ta.a(this.f12829m);
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("Load duration = " + jA + ", error = " + i10 + ", " + str));
        gs gsVar = this.f12830n;
        if (gsVar != null) {
            gsVar.e();
        }
        synchronized (this.f12833q) {
            h hVar = this.f12821e;
            if (hVar == h.LOADING) {
                a(adapterErrorType, i10, str, jA);
                a(h.FAILED);
                this.f12818b.a(new IronSourceError(i10, str), this);
                return;
            }
            if (hVar == h.FAILED) {
                a(adapterErrorType, i10, str, jA);
                return;
            }
            if (hVar == h.LOADED && adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED) {
                this.f12828l = Long.valueOf(System.currentTimeMillis());
                ironLog.error(a(String.format("ad expired for %s, state = %s", this.f12824h.f(), this.f12821e)));
                x1 x1Var = this.f12820d;
                if (x1Var != null) {
                    x1Var.f16112k.a(String.format("ad expired, state = %s", this.f12821e));
                }
                return;
            }
            ironLog.error(a(String.format("unexpected load failed for %s, state - %s, error - %s, %s", k(), this.f12821e, Integer.valueOf(i10), str)));
            String str2 = String.format("unexpected load failed, state - %s, error - %s, %s", this.f12821e, Integer.valueOf(i10), str);
            if (this.f12820d != null) {
                if (v()) {
                    this.f12820d.f16112k.p(str2);
                } else if (this.f12817a.a() != IronSource.AD_UNIT.REWARDED_VIDEO || this.f12821e != h.SHOWING) {
                    this.f12820d.f16112k.m(str2);
                }
            }
        }
    }

    private void a(AdapterErrorType adapterErrorType, int i10, String str, long j10) {
        if (this.f12820d != null) {
            if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
                if (v()) {
                    this.f12820d.f16108g.c(j10, i10);
                    return;
                } else {
                    this.f12820d.f16108g.b(j10, i10);
                    return;
                }
            }
            if (TextUtils.isEmpty(str)) {
                this.f12820d.f16108g.a(j10, i10);
            } else if (v()) {
                this.f12820d.f16108g.b(j10, i10, str);
            } else {
                this.f12820d.f16108g.a(j10, i10, str);
            }
        }
    }

    public void a(boolean z10) {
        this.f12822f.set(z10);
    }
}
