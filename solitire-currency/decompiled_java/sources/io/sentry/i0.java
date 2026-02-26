package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.protocol.SentrySpan;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ExternalOptions.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i0 {

    @Nullable
    private Boolean A;

    @Nullable
    private Boolean B;

    @Nullable
    private String C;

    @Nullable
    private List<String> D;

    @Nullable
    private List<String> E;

    @Nullable
    private Boolean F;

    @Nullable
    private Boolean G;

    @Nullable
    private Boolean H;

    @Nullable
    private Boolean I;

    @Nullable
    private Boolean J;

    @Nullable
    private Boolean K;

    @Nullable
    private SentryOptions.f L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private String f27859a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private String f27860b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private String f27861c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private String f27862d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f27863e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private Boolean f27864f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Boolean f27865g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private Boolean f27866h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Double f27867i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Double f27868j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private SentryOptions.j f27869k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private SentryOptions.i f27871m;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private String f27876r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @Nullable
    private Long f27877s;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private List<String> f27879u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @Nullable
    private Boolean f27880v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @Nullable
    private Boolean f27881w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    private Boolean f27883y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @Nullable
    private Boolean f27884z;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final Map<String, String> f27870l = new ConcurrentHashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private final List<String> f27872n = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final List<String> f27873o = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private List<String> f27874p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private final List<String> f27875q = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private final Set<Class<? extends Throwable>> f27878t = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NotNull
    private Set<String> f27882x = new CopyOnWriteArraySet();

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static i0 g(@NotNull io.sentry.config.g gVar, @NotNull w0 w0Var) {
        i0 i0Var = new i0();
        i0Var.X(gVar.getProperty("dsn"));
        i0Var.f0(gVar.getProperty("environment"));
        i0Var.r0(gVar.getProperty("release"));
        i0Var.W(gVar.getProperty("dist"));
        i0Var.v0(gVar.getProperty("servername"));
        i0Var.d0(gVar.f("uncaught.handler.enabled"));
        i0Var.n0(gVar.f("uncaught.handler.print-stacktrace"));
        i0Var.y0(gVar.c("traces-sample-rate"));
        i0Var.o0(gVar.c("profiles-sample-rate"));
        i0Var.V(gVar.f("debug"));
        i0Var.Z(gVar.f("enable-deduplication"));
        i0Var.s0(gVar.f("send-client-reports"));
        i0Var.g0(gVar.f("force-init"));
        String property = gVar.getProperty("max-request-body-size");
        if (property != null) {
            i0Var.m0(SentryOptions.j.valueOf(property.toUpperCase(Locale.ROOT)));
        }
        for (Map.Entry<String, String> entry : gVar.a(SentrySpan.JsonKeys.TAGS).entrySet()) {
            i0Var.x0(entry.getKey(), entry.getValue());
        }
        String property2 = gVar.getProperty("proxy.host");
        String property3 = gVar.getProperty("proxy.user");
        String property4 = gVar.getProperty("proxy.pass");
        String strD = gVar.d("proxy.port", "80");
        if (property2 != null) {
            i0Var.q0(new SentryOptions.i(property2, strD, property3, property4));
        }
        Iterator<String> it = gVar.e("in-app-includes").iterator();
        while (it.hasNext()) {
            i0Var.e(it.next());
        }
        Iterator<String> it2 = gVar.e("in-app-excludes").iterator();
        while (it2.hasNext()) {
            i0Var.d(it2.next());
        }
        List<String> listE = gVar.getProperty("trace-propagation-targets") != null ? gVar.e("trace-propagation-targets") : null;
        if (listE == null && gVar.getProperty("tracing-origins") != null) {
            listE = gVar.e("tracing-origins");
        }
        if (listE != null) {
            Iterator<String> it3 = listE.iterator();
            while (it3.hasNext()) {
                i0Var.f(it3.next());
            }
        }
        Iterator<String> it4 = gVar.e("context-tags").iterator();
        while (it4.hasNext()) {
            i0Var.b(it4.next());
        }
        i0Var.p0(gVar.getProperty("proguard-uuid"));
        Iterator<String> it5 = gVar.e("bundle-ids").iterator();
        while (it5.hasNext()) {
            i0Var.a(it5.next());
        }
        i0Var.i0(gVar.b("idle-timeout"));
        i0Var.k0(gVar.g("ignored-errors"));
        i0Var.e0(gVar.f("enabled"));
        i0Var.b0(gVar.f("enable-pretty-serialization-output"));
        i0Var.u0(gVar.f("send-modules"));
        i0Var.t0(gVar.f("send-default-pii"));
        i0Var.j0(gVar.g("ignored-checkins"));
        i0Var.l0(gVar.g("ignored-transactions"));
        i0Var.Y(gVar.f("enable-backpressure-handling"));
        i0Var.h0(gVar.f("global-hub-mode"));
        i0Var.T(gVar.f("capture-open-telemetry-events"));
        i0Var.a0(gVar.f("logs.enabled"));
        for (String str : gVar.e("ignored-exceptions-for-type")) {
            try {
                Class<?> cls = Class.forName(str);
                if (Throwable.class.isAssignableFrom(cls)) {
                    i0Var.c(cls);
                } else {
                    w0Var.c(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s does not extend Throwable", str, str);
                }
            } catch (ClassNotFoundException unused) {
                w0Var.c(SentryLevel.WARNING, "Skipping setting %s as ignored-exception-for-type. Reason: %s class is not found", str, str);
            }
        }
        Long lB = gVar.b("cron.default-checkin-margin");
        Long lB2 = gVar.b("cron.default-max-runtime");
        String property5 = gVar.getProperty("cron.default-timezone");
        Long lB3 = gVar.b("cron.default-failure-issue-threshold");
        Long lB4 = gVar.b("cron.default-recovery-threshold");
        if (lB != null || lB2 != null || property5 != null || lB3 != null || lB4 != null) {
            SentryOptions.f fVar = new SentryOptions.f();
            fVar.f(lB);
            fVar.h(lB2);
            fVar.j(property5);
            fVar.g(lB3);
            fVar.i(lB4);
            i0Var.U(fVar);
        }
        i0Var.c0(gVar.f("enable-spotlight"));
        i0Var.w0(gVar.getProperty("spotlight-connection-url"));
        return i0Var;
    }

    @Nullable
    public String A() {
        return this.f27876r;
    }

    @Nullable
    public SentryOptions.i B() {
        return this.f27871m;
    }

    @Nullable
    public String C() {
        return this.f27861c;
    }

    @Nullable
    public Boolean D() {
        return this.f27881w;
    }

    @Nullable
    public String E() {
        return this.f27863e;
    }

    @ApiStatus.Experimental
    @Nullable
    public String F() {
        return this.C;
    }

    @NotNull
    public Map<String, String> G() {
        return this.f27870l;
    }

    @Nullable
    public List<String> H() {
        return this.f27874p;
    }

    @Nullable
    public Double I() {
        return this.f27867i;
    }

    @ApiStatus.Experimental
    @Nullable
    public Boolean J() {
        return this.K;
    }

    @ApiStatus.Experimental
    @Nullable
    public Boolean K() {
        return this.H;
    }

    @ApiStatus.Experimental
    @Nullable
    public Boolean L() {
        return this.B;
    }

    @Nullable
    public Boolean M() {
        return this.f27884z;
    }

    @ApiStatus.Experimental
    @Nullable
    public Boolean N() {
        return this.A;
    }

    @Nullable
    public Boolean O() {
        return this.f27883y;
    }

    @Nullable
    public Boolean P() {
        return this.J;
    }

    @ApiStatus.Experimental
    @Nullable
    public Boolean Q() {
        return this.I;
    }

    @Nullable
    public Boolean R() {
        return this.G;
    }

    @Nullable
    public Boolean S() {
        return this.F;
    }

    @ApiStatus.Experimental
    public void T(@Nullable Boolean bool) {
        this.K = bool;
    }

    @ApiStatus.Experimental
    public void U(@Nullable SentryOptions.f fVar) {
        this.L = fVar;
    }

    public void V(@Nullable Boolean bool) {
        this.f27865g = bool;
    }

    public void W(@Nullable String str) {
        this.f27862d = str;
    }

    public void X(@Nullable String str) {
        this.f27859a = str;
    }

    @ApiStatus.Experimental
    public void Y(@Nullable Boolean bool) {
        this.H = bool;
    }

    public void Z(@Nullable Boolean bool) {
        this.f27866h = bool;
    }

    public void a(@NotNull String str) {
        this.f27882x.add(str);
    }

    @ApiStatus.Experimental
    public void a0(@Nullable Boolean bool) {
        this.B = bool;
    }

    public void b(@NotNull String str) {
        this.f27875q.add(str);
    }

    public void b0(@Nullable Boolean bool) {
        this.f27884z = bool;
    }

    public void c(@NotNull Class<? extends Throwable> cls) {
        this.f27878t.add(cls);
    }

    @ApiStatus.Experimental
    public void c0(@Nullable Boolean bool) {
        this.A = bool;
    }

    public void d(@NotNull String str) {
        this.f27872n.add(str);
    }

    public void d0(@Nullable Boolean bool) {
        this.f27864f = bool;
    }

    public void e(@NotNull String str) {
        this.f27873o.add(str);
    }

    public void e0(@Nullable Boolean bool) {
        this.f27883y = bool;
    }

    public void f(@NotNull String str) {
        if (this.f27874p == null) {
            this.f27874p = new CopyOnWriteArrayList();
        }
        if (str.isEmpty()) {
            return;
        }
        this.f27874p.add(str);
    }

    public void f0(@Nullable String str) {
        this.f27860b = str;
    }

    public void g0(@Nullable Boolean bool) {
        this.J = bool;
    }

    @NotNull
    public Set<String> h() {
        return this.f27882x;
    }

    public void h0(@Nullable Boolean bool) {
        this.I = bool;
    }

    @NotNull
    public List<String> i() {
        return this.f27875q;
    }

    public void i0(@Nullable Long l10) {
        this.f27877s = l10;
    }

    @ApiStatus.Experimental
    @Nullable
    public SentryOptions.f j() {
        return this.L;
    }

    @ApiStatus.Experimental
    public void j0(@Nullable List<String> list) {
        this.D = list;
    }

    @Nullable
    public Boolean k() {
        return this.f27865g;
    }

    public void k0(@Nullable List<String> list) {
        this.f27879u = list;
    }

    @Nullable
    public String l() {
        return this.f27862d;
    }

    public void l0(@Nullable List<String> list) {
        this.E = list;
    }

    @Nullable
    public String m() {
        return this.f27859a;
    }

    public void m0(@Nullable SentryOptions.j jVar) {
        this.f27869k = jVar;
    }

    @Nullable
    public Boolean n() {
        return this.f27866h;
    }

    public void n0(@Nullable Boolean bool) {
        this.f27880v = bool;
    }

    @Nullable
    public Boolean o() {
        return this.f27864f;
    }

    public void o0(@Nullable Double d10) {
        this.f27868j = d10;
    }

    @Nullable
    public String p() {
        return this.f27860b;
    }

    public void p0(@Nullable String str) {
        this.f27876r = str;
    }

    @Nullable
    public Long q() {
        return this.f27877s;
    }

    public void q0(@Nullable SentryOptions.i iVar) {
        this.f27871m = iVar;
    }

    @ApiStatus.Experimental
    @Nullable
    public List<String> r() {
        return this.D;
    }

    public void r0(@Nullable String str) {
        this.f27861c = str;
    }

    @Nullable
    public List<String> s() {
        return this.f27879u;
    }

    public void s0(@Nullable Boolean bool) {
        this.f27881w = bool;
    }

    @NotNull
    public Set<Class<? extends Throwable>> t() {
        return this.f27878t;
    }

    public void t0(@Nullable Boolean bool) {
        this.G = bool;
    }

    @Nullable
    public List<String> u() {
        return this.E;
    }

    public void u0(@Nullable Boolean bool) {
        this.F = bool;
    }

    @NotNull
    public List<String> v() {
        return this.f27872n;
    }

    public void v0(@Nullable String str) {
        this.f27863e = str;
    }

    @NotNull
    public List<String> w() {
        return this.f27873o;
    }

    @ApiStatus.Experimental
    public void w0(@Nullable String str) {
        this.C = str;
    }

    @Nullable
    public SentryOptions.j x() {
        return this.f27869k;
    }

    public void x0(@NotNull String str, @NotNull String str2) {
        this.f27870l.put(str, str2);
    }

    @Nullable
    public Boolean y() {
        return this.f27880v;
    }

    public void y0(@Nullable Double d10) {
        this.f27867i = d10;
    }

    @Nullable
    public Double z() {
        return this.f27868j;
    }
}
