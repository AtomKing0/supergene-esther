package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Span.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class i8 implements n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private n5 f27893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private n5 f27894b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final j8 f27895c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final b8 f27896d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private Throwable f27897e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final f1 f27898f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final p8 f27901i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private l8 f27902j;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27899g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f27900h = new AtomicBoolean(false);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final Map<String, Object> f27903k = new ConcurrentHashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final Map<String, MeasurementValue> f27904l = new ConcurrentHashMap();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final Contexts f27905m = new Contexts();

    i8(@NotNull b8 b8Var, @NotNull f1 f1Var, @NotNull j8 j8Var, @NotNull p8 p8Var, @Nullable l8 l8Var) {
        this.f27895c = j8Var;
        j8Var.r(p8Var.a());
        this.f27896d = (b8) io.sentry.util.w.c(b8Var, "transaction is required");
        this.f27898f = (f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        this.f27901i = p8Var;
        this.f27902j = l8Var;
        n5 n5VarC = p8Var.c();
        if (n5VarC != null) {
            this.f27893a = n5VarC;
        } else {
            this.f27893a = f1Var.getOptions().getDateProvider().a();
        }
    }

    private void J(@NotNull n5 n5Var) {
        this.f27893a = n5Var;
    }

    @NotNull
    private List<i8> w() {
        ArrayList arrayList = new ArrayList();
        for (i8 i8Var : this.f27896d.N()) {
            if (i8Var.A() != null && i8Var.A().equals(D())) {
                arrayList.add(i8Var);
            }
        }
        return arrayList;
    }

    @Nullable
    public o8 A() {
        return this.f27895c.g();
    }

    @Nullable
    public x8 B() {
        return this.f27895c.j();
    }

    @Nullable
    l8 C() {
        return this.f27902j;
    }

    @NotNull
    public o8 D() {
        return this.f27895c.k();
    }

    public Map<String, String> E() {
        return this.f27895c.m();
    }

    @NotNull
    public SentryId F() {
        return this.f27895c.n();
    }

    @Nullable
    public Boolean G() {
        return this.f27895c.h();
    }

    void H(@Nullable l8 l8Var) {
        this.f27902j = l8Var;
    }

    public boolean I(@NotNull n5 n5Var) {
        if (this.f27894b == null) {
            return false;
        }
        this.f27894b = n5Var;
        return true;
    }

    @Override // io.sentry.n1
    @NotNull
    public u7 a() {
        return new u7(this.f27895c.n(), this.f27895c.k(), this.f27895c.i());
    }

    @Override // io.sentry.n1
    @Nullable
    public Boolean d() {
        return this.f27895c.i();
    }

    @Override // io.sentry.n1
    public void e(@Nullable String str) {
        this.f27895c.p(str);
    }

    @Override // io.sentry.n1
    public void f(@NotNull String str, @NotNull Number number) {
        if (isFinished()) {
            this.f27898f.getOptions().getLogger().c(SentryLevel.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.f27904l.put(str, new MeasurementValue(number, null));
        if (this.f27896d.L() != this) {
            this.f27896d.b0(str, number);
        }
    }

    @Override // io.sentry.n1
    public void finish() {
        k(this.f27895c.l());
    }

    @Override // io.sentry.n1
    public boolean g() {
        return false;
    }

    @Override // io.sentry.n1
    @Nullable
    public String getDescription() {
        return this.f27895c.c();
    }

    @Override // io.sentry.n1
    @Nullable
    public q8 getStatus() {
        return this.f27895c.l();
    }

    @Override // io.sentry.n1
    public boolean isFinished() {
        return this.f27899g;
    }

    @Override // io.sentry.n1
    public void j(@Nullable String str, @Nullable Object obj) {
        if (str == null) {
            return;
        }
        if (obj == null) {
            this.f27903k.remove(str);
        } else {
            this.f27903k.put(str, obj);
        }
    }

    @Override // io.sentry.n1
    public void k(@Nullable q8 q8Var) {
        t(q8Var, this.f27898f.getOptions().getDateProvider().a());
    }

    @Override // io.sentry.n1
    @Nullable
    public e l(@Nullable List<String> list) {
        return this.f27896d.l(list);
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 m(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var) {
        return p(str, str2, n5Var, u1Var, new p8());
    }

    @Override // io.sentry.n1
    public void n(@NotNull String str, @NotNull Number number, @NotNull l2 l2Var) {
        if (isFinished()) {
            this.f27898f.getOptions().getLogger().c(SentryLevel.DEBUG, "The span is already finished. Measurement %s cannot be set", str);
            return;
        }
        this.f27904l.put(str, new MeasurementValue(number, l2Var.apiName()));
        if (this.f27896d.L() != this) {
            this.f27896d.c0(str, number, l2Var);
        }
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 p(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var, @NotNull p8 p8Var) {
        return this.f27899g ? e3.v() : this.f27896d.d0(this.f27895c.k(), str, str2, n5Var, u1Var, p8Var);
    }

    @Override // io.sentry.n1
    @NotNull
    public j8 r() {
        return this.f27895c;
    }

    @Override // io.sentry.n1
    @Nullable
    public n5 s() {
        return this.f27894b;
    }

    @Override // io.sentry.n1
    public void t(@Nullable q8 q8Var, @Nullable n5 n5Var) {
        n5 n5Var2;
        if (this.f27899g || !this.f27900h.compareAndSet(false, true)) {
            return;
        }
        this.f27895c.t(q8Var);
        if (n5Var == null) {
            n5Var = this.f27898f.getOptions().getDateProvider().a();
        }
        this.f27894b = n5Var;
        if (this.f27901i.f() || this.f27901i.e()) {
            n5 n5VarU = null;
            n5 n5VarS = null;
            for (i8 i8Var : this.f27896d.L().D().equals(D()) ? this.f27896d.I() : w()) {
                if (n5VarU == null || i8Var.u().e(n5VarU)) {
                    n5VarU = i8Var.u();
                }
                if (n5VarS == null || (i8Var.s() != null && i8Var.s().d(n5VarS))) {
                    n5VarS = i8Var.s();
                }
            }
            if (this.f27901i.f() && n5VarU != null && this.f27893a.e(n5VarU)) {
                J(n5VarU);
            }
            if (this.f27901i.e() && n5VarS != null && ((n5Var2 = this.f27894b) == null || n5Var2.d(n5VarS))) {
                I(n5VarS);
            }
        }
        Throwable th = this.f27897e;
        if (th != null) {
            this.f27898f.setSpanContext(th, this, this.f27896d.getName());
        }
        l8 l8Var = this.f27902j;
        if (l8Var != null) {
            l8Var.a(this);
        }
        this.f27899g = true;
    }

    @Override // io.sentry.n1
    @NotNull
    public n5 u() {
        return this.f27893a;
    }

    @NotNull
    public Map<String, Object> v() {
        return this.f27903k;
    }

    @NotNull
    public Map<String, MeasurementValue> x() {
        return this.f27904l;
    }

    @NotNull
    public String y() {
        return this.f27895c.e();
    }

    @NotNull
    p8 z() {
        return this.f27901i;
    }

    public i8(@NotNull y8 y8Var, @NotNull b8 b8Var, @NotNull f1 f1Var, @NotNull p8 p8Var) {
        j8 j8Var = (j8) io.sentry.util.w.c(y8Var, "context is required");
        this.f27895c = j8Var;
        j8Var.r(p8Var.a());
        this.f27896d = (b8) io.sentry.util.w.c(b8Var, "sentryTracer is required");
        this.f27898f = (f1) io.sentry.util.w.c(f1Var, "scopes are required");
        this.f27902j = null;
        n5 n5VarC = p8Var.c();
        if (n5VarC != null) {
            this.f27893a = n5VarC;
        } else {
            this.f27893a = f1Var.getOptions().getDateProvider().a();
        }
        this.f27901i = p8Var;
    }
}
