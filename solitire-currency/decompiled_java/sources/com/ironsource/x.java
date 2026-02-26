package com.ironsource;

import com.ironsource.environment.ContextProvider;
import com.ironsource.m1;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.x;
import com.unity3d.mediation.LevelPlayAdInfo;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class x implements AdapterAdListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f16075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final y f16076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private WeakReference<b0> f16077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private c0 f16078d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final BaseAdAdapter<?, ?> f16079e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private ta f16080f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private yp f16081g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f16082h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f16083i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f16084j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f16085k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final AdData f16086l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final f5 f16087m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private final f5 f16088n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f16089o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final String f16090p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final int f16091q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private final String f16092r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NotNull
    private final IronSource.AD_UNIT f16093s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final int f16094t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NotNull
    private final e0 f16095u;

    /* JADX INFO: Access modifiers changed from: private */
    final class a implements NetworkInitializationListener {
        public a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(x this$0) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.D();
        }

        @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
        public void onInitFailed(final int i10, @Nullable final String str) {
            final x xVar = x.this;
            xVar.a(new Runnable() { // from class: com.ironsource.j10
                @Override // java.lang.Runnable
                public final void run() {
                    x.a.a(xVar, i10, str);
                }
            });
        }

        @Override // com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener
        public void onInitSuccess() {
            final x xVar = x.this;
            xVar.a(new Runnable() { // from class: com.ironsource.k10
                @Override // java.lang.Runnable
                public final void run() {
                    x.a.a(xVar);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void a(x this$0, int i10, String str) {
            kotlin.jvm.internal.t.i(this$0, "this$0");
            this$0.a(i10, str);
        }
    }

    public static final class b extends yp {
        b() {
        }

        @Override // com.ironsource.yp
        public void a() {
            long jA = ta.a(x.this.f16080f);
            IronLog.INTERNAL.verbose(x.this.a("Load duration = " + jA + ", isBidder = " + x.this.s()));
            x.this.f16085k = true;
            x.this.e().e().e().a(jA, 1025);
            x.this.e().e().e().a(jA, 1025, "time out");
            x xVar = x.this;
            IronSourceError ironSourceErrorBuildLoadFailedError = ErrorBuilder.buildLoadFailedError("time out");
            kotlin.jvm.internal.t.h(ironSourceErrorBuildLoadFailedError, "buildLoadFailedError(errorMessage)");
            xVar.a(ironSourceErrorBuildLoadFailedError);
        }
    }

    public x(@NotNull p2 adTools, @NotNull y instanceData, @NotNull b0 listener) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f16075a = adTools;
        this.f16076b = instanceData;
        this.f16077c = new WeakReference<>(listener);
        this.f16086l = instanceData.g();
        this.f16087m = instanceData.n();
        this.f16088n = instanceData.p();
        this.f16089o = instanceData.j().j();
        this.f16090p = instanceData.r();
        this.f16091q = instanceData.s();
        this.f16092r = instanceData.w();
        this.f16093s = instanceData.h();
        this.f16094t = instanceData.v();
        this.f16095u = instanceData.t();
        BaseAdAdapter<?, ?> baseAdAdapterA = a(instanceData);
        this.f16079e = baseAdAdapterA;
        adTools.e().a(new z(adTools, instanceData, baseAdAdapterA));
        adTools.e().a(new n4(instanceData.k()));
    }

    private final void A() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        this.f16075a.e().a().a(j());
        b0 b0Var = this.f16077c.get();
        if (b0Var != null) {
            b0Var.a(this);
        }
    }

    private final void B() {
        IronLog ironLog = IronLog.INTERNAL;
        c0 c0Var = null;
        ironLog.verbose(a(this, (String) null, 1, (Object) null));
        F();
        if (this.f16085k || this.f16083i) {
            return;
        }
        this.f16083i = true;
        long jA = ta.a(this.f16080f);
        ironLog.verbose(a("Load duration = " + jA));
        this.f16075a.e().e().a(jA, false);
        a(m1.a.LoadedSuccessfully);
        c0 c0Var2 = this.f16078d;
        if (c0Var2 == null) {
            kotlin.jvm.internal.t.A("loadListener");
        } else {
            c0Var = c0Var2;
        }
        c0Var.a(this);
    }

    private final void C() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        if (this.f16084j) {
            return;
        }
        this.f16084j = true;
        this.f16075a.e().a().g(j());
        a(m1.a.ShowedSuccessfully);
        b0 b0Var = this.f16077c.get();
        if (b0Var != null) {
            b0Var.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        F();
        if (this.f16085k) {
            return;
        }
        z();
    }

    private final void E() {
        F();
        b bVarA = a();
        this.f16081g = bVarA;
        if (bVarA != null) {
            this.f16075a.a((yp) bVarA, TimeUnit.SECONDS.toMillis(m()));
        }
    }

    private final void F() {
        yp ypVar = this.f16081g;
        if (ypVar != null) {
            this.f16075a.b(ypVar);
            this.f16081g = null;
        }
    }

    private final BaseAdAdapter<?, ?> a(y yVar) {
        return this.f16075a.a(yVar);
    }

    private final int m() {
        Integer numE = this.f16076b.n().e();
        return (numE == null || numE.intValue() <= 0) ? this.f16076b.i().i() : numE.intValue();
    }

    private final void z() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        try {
            E();
            y();
        } catch (Throwable th) {
            i9.d().a(th);
            String str = "unexpected error while calling adapter.loadAd() - " + th.getMessage();
            IronLog.INTERNAL.error(a(str));
            this.f16075a.e().g().f(str);
            a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, 510, str);
        }
    }

    public abstract void a(@NotNull f0 f0Var);

    public void b() {
        IronLog.INTERNAL.verbose(a(this, (String) null, 1, (Object) null));
        F();
        this.f16075a.e().e().a(this.f16094t);
    }

    @NotNull
    public final IronSource.AD_UNIT c() {
        return this.f16093s;
    }

    @NotNull
    public LevelPlayAdInfo d() {
        String strB = this.f16076b.i().b().b();
        String string = this.f16076b.h().toString();
        kotlin.jvm.internal.t.h(string, "instanceData.adFormat.toString()");
        return new LevelPlayAdInfo(strB, string, this.f16076b.n().a(j()), null, 8, null);
    }

    @NotNull
    public final p2 e() {
        return this.f16075a;
    }

    @NotNull
    protected final String j() {
        return this.f16076b.i().m();
    }

    @Nullable
    public final f5 k() {
        return this.f16088n;
    }

    @NotNull
    protected final y l() {
        return this.f16076b;
    }

    @NotNull
    public final String n() {
        return this.f16090p;
    }

    @NotNull
    public final String o() {
        return this.f16092r;
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdClicked() {
        a(new Runnable() { // from class: com.ironsource.i10
            @Override // java.lang.Runnable
            public final void run() {
                x.c(this.f12533a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadFailed(@NotNull final AdapterErrorType adapterErrorType, final int i10, @NotNull final String errorMessage) {
        kotlin.jvm.internal.t.i(adapterErrorType, "adapterErrorType");
        kotlin.jvm.internal.t.i(errorMessage, "errorMessage");
        a(new Runnable() { // from class: com.ironsource.g10
            @Override // java.lang.Runnable
            public final void run() {
                x.a(this.f12197a, adapterErrorType, i10, errorMessage);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdLoadSuccess() {
        a(new Runnable() { // from class: com.ironsource.f10
            @Override // java.lang.Runnable
            public final void run() {
                x.d(this.f12017a);
            }
        });
    }

    @Override // com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener
    public void onAdOpened() {
        a(new Runnable() { // from class: com.ironsource.h10
            @Override // java.lang.Runnable
            public final void run() {
                x.e(this.f12364a);
            }
        });
    }

    public final int p() {
        return this.f16091q;
    }

    @NotNull
    public final e0 q() {
        return this.f16095u;
    }

    public final int r() {
        return this.f16094t;
    }

    public final boolean s() {
        return this.f16089o;
    }

    public final boolean t() {
        return this.f16085k;
    }

    public final boolean u() {
        return this.f16083i;
    }

    public final boolean v() {
        return this.f16082h;
    }

    public final boolean w() {
        return this.f16084j;
    }

    public boolean x() {
        return this.f16083i;
    }

    protected abstract void y();

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(x this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.A();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(x this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.B();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(x this$0) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        this$0.C();
    }

    @Nullable
    public final BaseAdAdapter<?, ?> f() {
        return this.f16079e;
    }

    @NotNull
    public final f5 g() {
        return this.f16087m;
    }

    @NotNull
    protected final AdData h() {
        return this.f16086l;
    }

    @Nullable
    protected final Placement i() {
        return this.f16076b.i().b().e();
    }

    private final b a() {
        return new b();
    }

    public static /* synthetic */ String a(x xVar, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createLogMessage");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return xVar.a(str);
    }

    @NotNull
    protected final String a(@Nullable String str) {
        return this.f16075a.a(str, this.f16092r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(int i10, String str) {
        IronLog.INTERNAL.verbose(a("error = " + i10 + ", " + str));
        F();
        this.f16085k = true;
        a(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, i10, str, ta.a(this.f16080f));
        a(new IronSourceError(i10, str));
    }

    public final void a(@NotNull c0 listener) {
        kotlin.jvm.internal.t.i(listener, "listener");
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a(this, (String) null, 1, (Object) null));
        this.f16078d = listener;
        this.f16082h = true;
        try {
            this.f16075a.e().e().a(false);
            this.f16080f = new ta();
            E();
            BaseAdAdapter<?, ?> baseAdAdapter = this.f16079e;
            kotlin.jvm.internal.t.f(baseAdAdapter);
            AdapterBaseInterface networkAdapter = baseAdAdapter.getNetworkAdapter();
            if (networkAdapter != null) {
                networkAdapter.init(this.f16076b.g(), ContextProvider.getInstance().getApplicationContext(), new a());
            } else {
                String str = "loadAd - network adapter not available " + this.f16092r;
                ironLog.error(a(str));
                a(t1.c(this.f16076b.h()), str);
            }
        } catch (Throwable th) {
            i9.d().a(th);
            String str2 = "loadAd - exception = " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str2));
            this.f16075a.e().g().f(str2);
            a(t1.c(this.f16076b.h()), str2);
        }
    }

    protected final void a(@NotNull m1.a performance) {
        kotlin.jvm.internal.t.i(performance, "performance");
        this.f16076b.a(performance);
    }

    private final void a(AdapterErrorType adapterErrorType, int i10, String str) {
        long jA = ta.a(this.f16080f);
        IronLog.INTERNAL.verbose(a("Load duration = " + jA + ", error = " + i10 + ", " + str));
        F();
        a(adapterErrorType, i10, str, jA);
        this.f16085k = true;
        a(new IronSourceError(i10, str));
    }

    private final void a(AdapterErrorType adapterErrorType, int i10, String str, long j10) {
        if (adapterErrorType == AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL) {
            this.f16075a.e().e().b(j10, i10);
        } else {
            this.f16075a.e().e().a(j10, i10, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(IronSourceError ironSourceError) {
        a(m1.a.FailedToLoad);
        c0 c0Var = this.f16078d;
        if (c0Var == null) {
            kotlin.jvm.internal.t.A("loadListener");
            c0Var = null;
        }
        c0Var.a(ironSourceError, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(x this$0, AdapterErrorType adapterErrorType, int i10, String errorMessage) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adapterErrorType, "$adapterErrorType");
        kotlin.jvm.internal.t.i(errorMessage, "$errorMessage");
        this$0.a(adapterErrorType, i10, errorMessage);
    }

    protected final void a(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        this.f16075a.a(callback);
    }

    public final void a(boolean z10) {
        this.f16075a.e().a().a(z10);
    }
}
