package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.TransactionNameSource;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryTracer.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class b8 implements p1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final i8 f27598b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final f1 f27600d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private String f27601e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private volatile TimerTask f27603g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private volatile TimerTask f27604h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private volatile Timer f27605i;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private TransactionNameSource f27610n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private final u1 f27611o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final Contexts f27612p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private final j f27613q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private final a9 f27614r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final SentryId f27597a = new SentryId();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<i8> f27599c = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private c f27602f = c.f27617c;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27606j = new io.sentry.util.a();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27607k = new io.sentry.util.a();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f27608l = new AtomicBoolean(false);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f27609m = new AtomicBoolean(false);

    /* JADX INFO: compiled from: SentryTracer.java */
    class a extends TimerTask {
        a() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b8.this.Y();
        }
    }

    /* JADX INFO: compiled from: SentryTracer.java */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            b8.this.X();
        }
    }

    /* JADX INFO: compiled from: SentryTracer.java */
    private static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final c f27617c = d();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final boolean f27618a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final q8 f27619b;

        private c(boolean z10, @Nullable q8 q8Var) {
            this.f27618a = z10;
            this.f27619b = q8Var;
        }

        @NotNull
        static c c(@Nullable q8 q8Var) {
            return new c(true, q8Var);
        }

        @NotNull
        private static c d() {
            return new c(false, null);
        }
    }

    b8(@NotNull y8 y8Var, @NotNull f1 f1Var, @NotNull a9 a9Var, @Nullable j jVar) {
        this.f27605i = null;
        Contexts contexts = new Contexts();
        this.f27612p = contexts;
        io.sentry.util.w.c(y8Var, "context is required");
        io.sentry.util.w.c(f1Var, "scopes are required");
        i8 i8Var = new i8(y8Var, this, f1Var, a9Var);
        this.f27598b = i8Var;
        this.f27601e = y8Var.w();
        this.f27611o = y8Var.d();
        this.f27600d = f1Var;
        this.f27613q = jVar;
        this.f27610n = y8Var.y();
        this.f27614r = a9Var;
        a0(i8Var);
        SentryId sentryIdF = f1Var.getOptions().getContinuousProfiler().f();
        if (!sentryIdF.equals(SentryId.EMPTY_ID) && Boolean.TRUE.equals(d())) {
            contexts.setProfile(new u3(sentryIdF));
        }
        if (jVar != null) {
            jVar.e(this);
        }
        if (a9Var.l() == null && a9Var.k() == null) {
            return;
        }
        this.f27605i = new Timer(true);
        Z();
        q();
    }

    private void D() {
        k1 k1VarA = this.f27606j.a();
        try {
            if (this.f27604h != null) {
                this.f27604h.cancel();
                this.f27609m.set(false);
                this.f27604h = null;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private void E() {
        k1 k1VarA = this.f27606j.a();
        try {
            if (this.f27603g != null) {
                this.f27603g.cancel();
                this.f27608l.set(false);
                this.f27603g = null;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @NotNull
    private n1 F(@NotNull j8 j8Var, @NotNull p8 p8Var) {
        if (this.f27598b.isFinished()) {
            return e3.v();
        }
        if (!this.f27611o.equals(j8Var.d())) {
            return e3.v();
        }
        if (io.sentry.util.c0.b(this.f27600d.getOptions().getIgnoredSpanOrigins(), p8Var.a())) {
            return e3.v();
        }
        o8 o8VarG = j8Var.g();
        String strE = j8Var.e();
        String strC = j8Var.c();
        if (this.f27599c.size() >= this.f27600d.getOptions().getMaxSpans()) {
            this.f27600d.getOptions().getLogger().c(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", strE, strC);
            return e3.v();
        }
        io.sentry.util.w.c(o8VarG, "parentSpanId is required");
        io.sentry.util.w.c(strE, "operation is required");
        E();
        i8 i8Var = new i8(this, this.f27600d, j8Var, p8Var, new l8() { // from class: io.sentry.a8
            @Override // io.sentry.l8
            public final void a(i8 i8Var2) {
                this.f26985a.R(i8Var2);
            }
        });
        a0(i8Var);
        this.f27599c.add(i8Var);
        j jVar = this.f27613q;
        if (jVar != null) {
            jVar.b(i8Var);
        }
        return i8Var;
    }

    @NotNull
    private n1 G(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var, @NotNull p8 p8Var) {
        if (this.f27598b.isFinished()) {
            return e3.v();
        }
        if (!this.f27611o.equals(u1Var)) {
            return e3.v();
        }
        if (this.f27599c.size() < this.f27600d.getOptions().getMaxSpans()) {
            return this.f27598b.p(str, str2, n5Var, u1Var, p8Var);
        }
        this.f27600d.getOptions().getLogger().c(SentryLevel.WARNING, "Span operation: %s, description: %s dropped due to limit reached. Returning NoOpSpan.", str, str2);
        return e3.v();
    }

    private boolean P() {
        ListIterator<i8> listIterator = this.f27599c.listIterator();
        while (listIterator.hasNext()) {
            i8 next = listIterator.next();
            if (!next.isFinished() && next.s() == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(i8 i8Var) {
        j jVar = this.f27613q;
        if (jVar != null) {
            jVar.a(i8Var);
        }
        c cVar = this.f27602f;
        if (this.f27614r.l() == null) {
            if (cVar.f27618a) {
                k(cVar.f27619b);
            }
        } else if (!this.f27614r.q() || P()) {
            q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(l8 l8Var, AtomicReference atomicReference, i8 i8Var) {
        if (l8Var != null) {
            l8Var.a(i8Var);
        }
        z8 z8VarN = this.f27614r.n();
        if (z8VarN != null) {
            z8VarN.a(this);
        }
        j jVar = this.f27613q;
        if (jVar != null) {
            atomicReference.set(jVar.l(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(c1 c1Var, p1 p1Var) {
        if (p1Var == this) {
            c1Var.clearTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(final c1 c1Var) {
        c1Var.withTransaction(new Scope.c() { // from class: io.sentry.z7
            @Override // io.sentry.Scope.c
            public final void a(p1 p1Var) {
                this.f28531a.T(c1Var, p1Var);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(c1 c1Var) {
        c1Var.setTransaction(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(AtomicReference atomicReference, c1 c1Var) {
        atomicReference.set(c1Var.getReplayId());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X() {
        q8 status = getStatus();
        if (status == null) {
            status = q8.DEADLINE_EXCEEDED;
        }
        b(status, this.f27614r.l() != null, null);
        this.f27609m.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y() {
        q8 status = getStatus();
        if (status == null) {
            status = q8.OK;
        }
        k(status);
        this.f27608l.set(false);
    }

    private void Z() {
        Long lK = this.f27614r.k();
        if (lK != null) {
            k1 k1VarA = this.f27606j.a();
            try {
                if (this.f27605i != null) {
                    D();
                    this.f27609m.set(true);
                    this.f27604h = new b();
                    try {
                        this.f27605i.schedule(this.f27604h, lK.longValue());
                    } catch (Throwable th) {
                        this.f27600d.getOptions().getLogger().b(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                        X();
                    }
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } catch (Throwable th2) {
                if (k1VarA != null) {
                    try {
                        k1VarA.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }
    }

    private void a0(@NotNull n1 n1Var) {
        io.sentry.util.thread.a threadChecker = this.f27600d.getOptions().getThreadChecker();
        SentryId sentryIdF = this.f27600d.getOptions().getContinuousProfiler().f();
        if (!sentryIdF.equals(SentryId.EMPTY_ID) && Boolean.TRUE.equals(n1Var.d())) {
            n1Var.j("profiler_id", sentryIdF.toString());
        }
        n1Var.j("thread.id", String.valueOf(threadChecker.c()));
        n1Var.j("thread.name", threadChecker.b());
    }

    private void e0(@NotNull d dVar) {
        k1 k1VarA = this.f27607k.a();
        try {
            if (dVar.w()) {
                final AtomicReference atomicReference = new AtomicReference();
                this.f27600d.n(new ScopeCallback() { // from class: io.sentry.v7
                    @Override // io.sentry.ScopeCallback
                    public final void run(c1 c1Var) {
                        b8.W(atomicReference, c1Var);
                    }
                });
                dVar.O(r().n(), (SentryId) atomicReference.get(), this.f27600d.getOptions(), M(), getName(), O());
                dVar.d();
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void H(@Nullable q8 q8Var, @Nullable n5 n5Var, boolean z10, @Nullable l0 l0Var) {
        n5 n5VarS = this.f27598b.s();
        if (n5Var == null) {
            n5Var = n5VarS;
        }
        if (n5Var == null) {
            n5Var = this.f27600d.getOptions().getDateProvider().a();
        }
        for (i8 i8Var : this.f27599c) {
            if (i8Var.z().d()) {
                i8Var.t(q8Var != null ? q8Var : r().f27951g, n5Var);
            }
        }
        this.f27602f = c.c(q8Var);
        if (this.f27598b.isFinished()) {
            return;
        }
        if (!this.f27614r.q() || P()) {
            final AtomicReference atomicReference = new AtomicReference();
            final l8 l8VarC = this.f27598b.C();
            this.f27598b.H(new l8() { // from class: io.sentry.w7
                @Override // io.sentry.l8
                public final void a(i8 i8Var2) {
                    this.f28454a.S(l8VarC, atomicReference, i8Var2);
                }
            });
            this.f27598b.t(this.f27602f.f27619b, n5Var);
            Boolean bool = Boolean.TRUE;
            x3 x3VarB = (bool.equals(d()) && bool.equals(Q())) ? this.f27600d.getOptions().getTransactionProfiler().b(this, (List) atomicReference.get(), this.f27600d.getOptions()) : null;
            if (this.f27600d.getOptions().isContinuousProfilingEnabled()) {
                v3 profileLifecycle = this.f27600d.getOptions().getProfileLifecycle();
                v3 v3Var = v3.TRACE;
                if (profileLifecycle == v3Var) {
                    this.f27600d.getOptions().getContinuousProfiler().e(v3Var);
                }
            }
            if (atomicReference.get() != null) {
                ((List) atomicReference.get()).clear();
            }
            this.f27600d.n(new ScopeCallback() { // from class: io.sentry.x7
                @Override // io.sentry.ScopeCallback
                public final void run(c1 c1Var) {
                    this.f28490a.U(c1Var);
                }
            });
            SentryTransaction sentryTransaction = new SentryTransaction(this);
            if (this.f27605i != null) {
                k1 k1VarA = this.f27606j.a();
                try {
                    if (this.f27605i != null) {
                        E();
                        D();
                        this.f27605i.cancel();
                        this.f27605i = null;
                    }
                    if (k1VarA != null) {
                        k1VarA.close();
                    }
                } catch (Throwable th) {
                    if (k1VarA != null) {
                        try {
                            k1VarA.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            if (z10 && this.f27599c.isEmpty() && this.f27614r.l() != null) {
                this.f27600d.getOptions().getLogger().c(SentryLevel.DEBUG, "Dropping idle transaction %s because it has no child spans", this.f27601e);
            } else {
                sentryTransaction.getMeasurements().putAll(this.f27598b.x());
                this.f27600d.X(sentryTransaction, i(), l0Var, x3VarB);
            }
        }
    }

    @NotNull
    public List<i8> I() {
        return this.f27599c;
    }

    @ApiStatus.Internal
    @NotNull
    public Contexts J() {
        return this.f27612p;
    }

    @Nullable
    public Map<String, Object> K() {
        return this.f27598b.v();
    }

    @NotNull
    i8 L() {
        return this.f27598b;
    }

    @Nullable
    public x8 M() {
        return this.f27598b.B();
    }

    @NotNull
    public List<i8> N() {
        return this.f27599c;
    }

    @NotNull
    public TransactionNameSource O() {
        return this.f27610n;
    }

    @Nullable
    public Boolean Q() {
        return this.f27598b.G();
    }

    @Override // io.sentry.n1
    @NotNull
    public u7 a() {
        return this.f27598b.a();
    }

    @Override // io.sentry.p1
    @NotNull
    public void b(@NotNull q8 q8Var, boolean z10, @Nullable l0 l0Var) {
        if (isFinished()) {
            return;
        }
        n5 n5VarA = this.f27600d.getOptions().getDateProvider().a();
        ListIterator listIteratorD = io.sentry.util.c.d((CopyOnWriteArrayList) this.f27599c);
        while (listIteratorD.hasPrevious()) {
            i8 i8Var = (i8) listIteratorD.previous();
            i8Var.H(null);
            i8Var.t(q8Var, n5VarA);
        }
        H(q8Var, n5VarA, z10, l0Var);
    }

    @ApiStatus.Internal
    public void b0(@NotNull String str, @NotNull Number number) {
        if (this.f27598b.x().containsKey(str)) {
            return;
        }
        f(str, number);
    }

    @Override // io.sentry.p1
    @ApiStatus.Internal
    public void c(@NotNull String str, @NotNull TransactionNameSource transactionNameSource) {
        if (this.f27598b.isFinished()) {
            this.f27600d.getOptions().getLogger().c(SentryLevel.DEBUG, "The transaction is already finished. Name %s cannot be set", str);
        } else {
            this.f27601e = str;
            this.f27610n = transactionNameSource;
        }
    }

    @ApiStatus.Internal
    public void c0(@NotNull String str, @NotNull Number number, @NotNull l2 l2Var) {
        if (this.f27598b.x().containsKey(str)) {
            return;
        }
        n(str, number, l2Var);
    }

    @Override // io.sentry.n1
    @Nullable
    public Boolean d() {
        return this.f27598b.d();
    }

    @NotNull
    n1 d0(@NotNull o8 o8Var, @NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var, @NotNull p8 p8Var) {
        j8 j8VarA = r().a(str, o8Var, null);
        j8VarA.p(str2);
        j8VarA.q(u1Var);
        p8Var.h(n5Var);
        return F(j8VarA, p8Var);
    }

    @Override // io.sentry.n1
    public void e(@Nullable String str) {
        if (this.f27598b.isFinished()) {
            this.f27600d.getOptions().getLogger().c(SentryLevel.DEBUG, "The transaction is already finished. Description %s cannot be set", str);
        } else {
            this.f27598b.e(str);
        }
    }

    @Override // io.sentry.n1
    public void f(@NotNull String str, @NotNull Number number) {
        this.f27598b.f(str, number);
    }

    @Override // io.sentry.n1
    public void finish() {
        k(getStatus());
    }

    @Override // io.sentry.n1
    public boolean g() {
        return false;
    }

    @Override // io.sentry.n1
    @Nullable
    public String getDescription() {
        return this.f27598b.getDescription();
    }

    @Override // io.sentry.p1
    @NotNull
    public SentryId getEventId() {
        return this.f27597a;
    }

    @Override // io.sentry.p1
    @NotNull
    public String getName() {
        return this.f27601e;
    }

    @Override // io.sentry.n1
    @Nullable
    public q8 getStatus() {
        return this.f27598b.getStatus();
    }

    @Override // io.sentry.n1
    @ApiStatus.Internal
    @NotNull
    public k1 h() {
        this.f27600d.n(new ScopeCallback() { // from class: io.sentry.y7
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                this.f28514a.V(c1Var);
            }
        });
        return w2.a();
    }

    @Override // io.sentry.n1
    @Nullable
    public v8 i() {
        d dVarB;
        if (!this.f27600d.getOptions().isTraceSampling() || (dVarB = r().b()) == null) {
            return null;
        }
        e0(dVarB);
        return dVarB.R();
    }

    @Override // io.sentry.n1
    public boolean isFinished() {
        return this.f27598b.isFinished();
    }

    @Override // io.sentry.n1
    public void j(@Nullable String str, @Nullable Object obj) {
        if (this.f27598b.isFinished()) {
            this.f27600d.getOptions().getLogger().c(SentryLevel.DEBUG, "The transaction is already finished. Data %s cannot be set", str);
        } else {
            this.f27598b.j(str, obj);
        }
    }

    @Override // io.sentry.n1
    public void k(@Nullable q8 q8Var) {
        t(q8Var, null);
    }

    @Override // io.sentry.n1
    @Nullable
    public e l(@Nullable List<String> list) {
        d dVarB;
        if (!this.f27600d.getOptions().isTraceSampling() || (dVarB = r().b()) == null) {
            return null;
        }
        e0(dVarB);
        return e.a(dVarB, list);
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 m(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var) {
        return p(str, str2, n5Var, u1Var, new p8());
    }

    @Override // io.sentry.n1
    public void n(@NotNull String str, @NotNull Number number, @NotNull l2 l2Var) {
        this.f27598b.n(str, number, l2Var);
    }

    @Override // io.sentry.p1
    @Nullable
    public n1 o() {
        ListIterator listIteratorD = io.sentry.util.c.d((CopyOnWriteArrayList) this.f27599c);
        while (listIteratorD.hasPrevious()) {
            i8 i8Var = (i8) listIteratorD.previous();
            if (!i8Var.isFinished()) {
                return i8Var;
            }
        }
        return null;
    }

    @Override // io.sentry.n1
    @NotNull
    public n1 p(@NotNull String str, @Nullable String str2, @Nullable n5 n5Var, @NotNull u1 u1Var, @NotNull p8 p8Var) {
        return G(str, str2, n5Var, u1Var, p8Var);
    }

    @Override // io.sentry.p1
    public void q() {
        Long l10;
        k1 k1VarA = this.f27606j.a();
        try {
            if (this.f27605i != null && (l10 = this.f27614r.l()) != null) {
                E();
                this.f27608l.set(true);
                this.f27603g = new a();
                try {
                    this.f27605i.schedule(this.f27603g, l10.longValue());
                } catch (Throwable th) {
                    this.f27600d.getOptions().getLogger().b(SentryLevel.WARNING, "Failed to schedule finish timer", th);
                    Y();
                }
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
        } catch (Throwable th2) {
            if (k1VarA != null) {
                try {
                    k1VarA.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
            }
            throw th2;
        }
    }

    @Override // io.sentry.n1
    @NotNull
    public j8 r() {
        return this.f27598b.r();
    }

    @Override // io.sentry.n1
    @Nullable
    public n5 s() {
        return this.f27598b.s();
    }

    @Override // io.sentry.n1
    @ApiStatus.Internal
    public void t(@Nullable q8 q8Var, @Nullable n5 n5Var) {
        H(q8Var, n5Var, true, null);
    }

    @Override // io.sentry.n1
    @NotNull
    public n5 u() {
        return this.f27598b.u();
    }
}
