package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Feedback;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.util.k0;
import java.io.Closeable;
import java.util.List;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scopes.java */
/* JADX INFO: loaded from: classes5.dex */
public final class q4 implements f1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c1 f28099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final c1 f28100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final c1 f28101c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final q4 f28102d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final String f28103e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final j f28104f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final i f28105g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final io.sentry.logger.a f28106h;

    public q4(@NotNull c1 c1Var, @NotNull c1 c1Var2, @NotNull c1 c1Var3, @NotNull String str) {
        this(c1Var, c1Var2, c1Var3, null, str);
    }

    private void A0(@NotNull SentryId sentryId) {
        q0().setLastEventId(sentryId);
    }

    private static void B0(@NotNull SentryOptions sentryOptions) {
        io.sentry.util.w.c(sentryOptions, "SentryOptions is required.");
        if (sentryOptions.getDsn() == null || sentryOptions.getDsn().isEmpty()) {
            throw new IllegalArgumentException("Scopes requires a DSN to be instantiated. Considering using the NoOpScopes if no DSN is available.");
        }
    }

    private void j0(@NotNull r6 r6Var) {
        q0().assignTraceContext(r6Var);
    }

    @NotNull
    private c1 k0(@NotNull c1 c1Var, @Nullable ScopeCallback scopeCallback) {
        if (scopeCallback != null) {
            try {
                c1 c1VarM4211clone = c1Var.m4211clone();
                scopeCallback.run(c1VarM4211clone);
                return c1VarM4211clone;
            } catch (Throwable th) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'ScopeCallback' callback.", th);
            }
        }
        return c1Var;
    }

    @NotNull
    private SentryId l0(@NotNull r6 r6Var, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryIdO = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureEvent' call is a no-op.", new Object[0]);
            return sentryIdO;
        }
        if (r6Var == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "captureEvent called with null parameter.", new Object[0]);
            return sentryIdO;
        }
        try {
            j0(r6Var);
            sentryIdO = p0().o(r6Var, k0(q0(), scopeCallback), l0Var);
            A0(sentryIdO);
            return sentryIdO;
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing event with id: " + r6Var.getEventId(), th);
            return sentryIdO;
        }
    }

    @NotNull
    private SentryId m0(@NotNull Throwable th, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryIdO = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureException' call is a no-op.", new Object[0]);
        } else if (th == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "captureException called with null parameter.", new Object[0]);
        } else {
            try {
                r6 r6Var = new r6(th);
                j0(r6Var);
                sentryIdO = p0().o(r6Var, k0(q0(), scopeCallback), l0Var);
            } catch (Throwable th2) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing exception: " + th.getMessage(), th2);
            }
        }
        A0(sentryIdO);
        return sentryIdO;
    }

    @NotNull
    private SentryId n0(@NotNull String str, @NotNull SentryLevel sentryLevel, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryIdM = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureMessage' call is a no-op.", new Object[0]);
        } else if (str == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "captureMessage called with null parameter.", new Object[0]);
        } else {
            try {
                sentryIdM = p0().m(str, sentryLevel, k0(q0(), scopeCallback));
            } catch (Throwable th) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing message: " + str, th);
            }
        }
        A0(sentryIdM);
        return sentryIdM;
    }

    @NotNull
    private p1 o0(@NotNull y8 y8Var, @NotNull a9 a9Var) {
        p1 p1VarA;
        io.sentry.util.w.c(y8Var, "transactionContext is required");
        y8Var.r(a9Var.a());
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            p1VarA = g3.v();
        } else if (io.sentry.util.c0.b(getOptions().getIgnoredSpanOrigins(), y8Var.f())) {
            getOptions().getLogger().c(SentryLevel.DEBUG, "Returning no-op for span origin %s as the SDK has been configured to ignore it", y8Var.f());
            p1VarA = g3.v();
        } else if (!getOptions().getInstrumenter().equals(y8Var.d())) {
            getOptions().getLogger().c(SentryLevel.DEBUG, "Returning no-op for instrumenter %s as the SDK has been configured to use instrumenter %s", y8Var.d(), getOptions().getInstrumenter());
            p1VarA = g3.v();
        } else if (getOptions().isTracingEnabled()) {
            Double dR0 = r0(y8Var);
            a9Var.j();
            x8 x8VarA = getOptions().getInternalTracesSampler().a(new e4(y8Var, null, dR0, null));
            y8Var.s(x8VarA);
            o1 o1VarM = a9Var.m();
            if (o1VarM == null) {
                o1VarM = getOptions().getSpanFactory();
            }
            p1VarA = o1VarM.a(y8Var, this, a9Var, this.f28104f);
            if (x8VarA.e().booleanValue()) {
                if (x8VarA.b().booleanValue()) {
                    q1 transactionProfiler = getOptions().getTransactionProfiler();
                    if (!transactionProfiler.isRunning()) {
                        transactionProfiler.start();
                        transactionProfiler.a(p1VarA);
                    } else if (a9Var.o()) {
                        transactionProfiler.a(p1VarA);
                    }
                }
                if (getOptions().isContinuousProfilingEnabled()) {
                    v3 profileLifecycle = getOptions().getProfileLifecycle();
                    v3 v3Var = v3.TRACE;
                    if (profileLifecycle == v3Var) {
                        getOptions().getContinuousProfiler().c(v3Var, getOptions().getInternalTracesSampler());
                    }
                }
            }
        } else {
            getOptions().getLogger().c(SentryLevel.INFO, "Tracing is disabled and this 'startTransaction' returns a no-op.", new Object[0]);
            p1VarA = g3.v();
        }
        if (a9Var.p()) {
            p1VarA.h();
        }
        return p1VarA;
    }

    @NotNull
    private Double r0(@NotNull y8 y8Var) {
        Double dN;
        d dVarB = y8Var.b();
        return (dVarB == null || (dN = dVarB.n()) == null) ? q0().getPropagationContext().f() : dN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u0(j1 j1Var) {
        j1Var.a(getOptions().getShutdownTimeoutMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void v0(boolean z10, c1 c1Var) {
        c1Var.getClient().b(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void w0(boolean z10, c1 c1Var) {
        c1Var.getClient().b(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void x0(boolean z10, c1 c1Var) {
        c1Var.getClient().b(z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z0(final z3 z3Var, final c1 c1Var) {
        c1Var.withPropagationContext(new Scope.a() { // from class: io.sentry.p4
            @Override // io.sentry.Scope.a
            public final void a(z3 z3Var2) {
                c1Var.setPropagationContext(z3Var);
            }
        });
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId A(Feedback feedback, l0 l0Var) {
        return e1.i(this, feedback, l0Var);
    }

    @Override // io.sentry.f1
    public void B(@NotNull ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            try {
                scopeCallback.run(u2.a());
                return;
            } catch (Throwable th) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'withIsolationScope' callback.", th);
                return;
            }
        }
        f1 f1VarZ = Z("withIsolationScope");
        try {
            k1 k1VarH = f1VarZ.h();
            try {
                scopeCallback.run(f1VarZ.N());
                if (k1VarH != null) {
                    k1VarH.close();
                }
            } finally {
            }
        } catch (Throwable th2) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'withIsolationScope' callback.", th2);
        }
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId C(r6 r6Var, ScopeCallback scopeCallback) {
        return e1.e(this, r6Var, scopeCallback);
    }

    @Override // io.sentry.f1
    public void D() {
        if (!getOptions().isContinuousProfilingEnabled()) {
            if (getOptions().isProfilingEnabled()) {
                getOptions().getLogger().c(SentryLevel.WARNING, "Continuous Profiling is not enabled. Set profilesSampleRate and profilesSampler to null to enable it.", new Object[0]);
            }
        } else {
            v3 profileLifecycle = getOptions().getProfileLifecycle();
            v3 v3Var = v3.MANUAL;
            if (profileLifecycle != v3Var) {
                getOptions().getLogger().c(SentryLevel.WARNING, "Profiling lifecycle is %s. Profiling cannot be started manually.", getOptions().getProfileLifecycle().name());
            } else {
                getOptions().getContinuousProfiler().c(v3Var, getOptions().getInternalTracesSampler());
            }
        }
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId E(@NotNull r6 r6Var, @Nullable l0 l0Var) {
        return l0(r6Var, l0Var, null);
    }

    @Override // io.sentry.f1
    public /* synthetic */ p1 F(y8 y8Var) {
        return e1.o(this, y8Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ p1 G(String str, String str2) {
        return e1.p(this, str, str2);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId H(r6 r6Var) {
        return e1.d(this, r6Var);
    }

    @Override // io.sentry.f1
    public void I() {
        if (getOptions().isEnableTimeToFullDisplayTracing()) {
            getOptions().getFullyDisplayedReporter().c();
        }
    }

    @Override // io.sentry.f1
    @NotNull
    public p1 J(@NotNull y8 y8Var, @NotNull a9 a9Var) {
        return o0(y8Var, a9Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId K(Throwable th, ScopeCallback scopeCallback) {
        return e1.g(this, th, scopeCallback);
    }

    @Override // io.sentry.f1
    @Nullable
    public Boolean L() {
        return m5.a().b(getOptions().getCacheDirPath(), !getOptions().isEnableAutoSessionTracking());
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId M(@NotNull r6 r6Var, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return l0(r6Var, l0Var, scopeCallback);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 N() {
        return this.f28100b;
    }

    @Override // io.sentry.f1
    public void O(@NotNull ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            try {
                scopeCallback.run(u2.a());
                return;
            } catch (Throwable th) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'withScope' callback.", th);
                return;
            }
        }
        f1 f1VarR = r("withScope");
        try {
            k1 k1VarH = f1VarR.h();
            try {
                scopeCallback.run(f1VarR.getScope());
                if (k1VarH != null) {
                    k1VarH.close();
                }
            } finally {
            }
        } catch (Throwable th2) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'withScope' callback.", th2);
        }
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId P(@NotNull String str, @NotNull SentryLevel sentryLevel, @NotNull ScopeCallback scopeCallback) {
        return n0(str, sentryLevel, scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId Q(Throwable th) {
        return e1.f(this, th);
    }

    @Override // io.sentry.f1
    @Nullable
    public y8 R(@Nullable String str, @Nullable List<String> list) {
        final z3 z3VarB = z3.b(getOptions().getLogger(), str, list);
        n(new ScopeCallback() { // from class: io.sentry.o4
            @Override // io.sentry.ScopeCallback
            public final void run(c1 c1Var) {
                q4.z0(z3VarB, c1Var);
            }
        });
        if (getOptions().isTracingEnabled()) {
            return y8.v(z3VarB);
        }
        return null;
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId S(@NotNull Throwable th, @Nullable l0 l0Var) {
        return m0(th, l0Var, null);
    }

    @Override // io.sentry.f1
    @ApiStatus.Experimental
    @NotNull
    public SentryId T(@NotNull f fVar) {
        SentryId sentryIdL = SentryId.EMPTY_ID;
        if (isEnabled()) {
            try {
                sentryIdL = p0().l(fVar, q0(), null);
            } catch (Throwable th) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing check-in for slug", th);
            }
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureCheckIn' call is a no-op.", new Object[0]);
        }
        A0(sentryIdL);
        return sentryIdL;
    }

    @Override // io.sentry.f1
    public /* synthetic */ void U(String str, String str2) {
        e1.b(this, str, str2);
    }

    @Override // io.sentry.f1
    public /* synthetic */ p1 V(String str, String str2, a9 a9Var) {
        return e1.q(this, str, str2, a9Var);
    }

    @Override // io.sentry.f1
    @Nullable
    public e W() {
        if (isEnabled()) {
            k0.c cVarS = io.sentry.util.k0.s(this, null, getSpan());
            if (cVarS != null) {
                return cVarS.a();
            }
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'getBaggage' call is a no-op.", new Object[0]);
        }
        return null;
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public SentryId X(@NotNull SentryTransaction sentryTransaction, @Nullable v8 v8Var, @Nullable l0 l0Var, @Nullable x3 x3Var) {
        io.sentry.util.w.c(sentryTransaction, "transaction is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return sentryId;
        }
        if (!sentryTransaction.isFinished()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Transaction: %s is not finished and this 'captureTransaction' call is a no-op.", sentryTransaction.getEventId());
            return sentryId;
        }
        if (Boolean.TRUE.equals(Boolean.valueOf(sentryTransaction.isSampled()))) {
            try {
                return p0().a(sentryTransaction, v8Var, q0(), l0Var, x3Var);
            } catch (Throwable th) {
                getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing transaction with id: " + sentryTransaction.getEventId(), th);
                return sentryId;
            }
        }
        getOptions().getLogger().c(SentryLevel.DEBUG, "Transaction %s was dropped due to sampling decision.", sentryTransaction.getEventId());
        if (getOptions().getBackpressureMonitor().a() > 0) {
            io.sentry.clientreport.h clientReportRecorder = getOptions().getClientReportRecorder();
            io.sentry.clientreport.f fVar = io.sentry.clientreport.f.BACKPRESSURE;
            clientReportRecorder.a(fVar, m.Transaction);
            getOptions().getClientReportRecorder().c(fVar, m.Span, sentryTransaction.getSpans().size() + 1);
            return sentryId;
        }
        io.sentry.clientreport.h clientReportRecorder2 = getOptions().getClientReportRecorder();
        io.sentry.clientreport.f fVar2 = io.sentry.clientreport.f.SAMPLE_RATE;
        clientReportRecorder2.a(fVar2, m.Transaction);
        getOptions().getClientReportRecorder().c(fVar2, m.Span, sentryTransaction.getSpans().size() + 1);
        return sentryId;
    }

    @Override // io.sentry.f1
    public k1 Y() {
        if (isEnabled()) {
            return Z("pushIsolationScope").h();
        }
        getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'pushIsolationScope' call is a no-op.", new Object[0]);
        return w2.a();
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 Z(@NotNull String str) {
        return new q4(this.f28099a.m4211clone(), this.f28100b.m4211clone(), this.f28101c, this, str);
    }

    @Override // io.sentry.f1
    @Nullable
    public u7 a0() {
        if (isEnabled()) {
            k0.c cVarS = io.sentry.util.k0.s(this, null, getSpan());
            if (cVarS != null) {
                return cVarS.b();
            }
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'getTraceparent' call is a no-op.", new Object[0]);
        }
        return null;
    }

    @Override // io.sentry.f1
    public void addBreadcrumb(@NotNull Breadcrumb breadcrumb, @Nullable l0 l0Var) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'addBreadcrumb' call is a no-op.", new Object[0]);
        } else if (breadcrumb == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "addBreadcrumb called with null parameter.", new Object[0]);
        } else {
            q0().addBreadcrumb(breadcrumb, l0Var);
        }
    }

    @Override // io.sentry.f1
    public void b(final boolean z10) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'close' call is a no-op.", new Object[0]);
            return;
        }
        try {
            for (v1 v1Var : getOptions().getIntegrations()) {
                if (v1Var instanceof Closeable) {
                    try {
                        ((Closeable) v1Var).close();
                    } catch (Throwable th) {
                        getOptions().getLogger().c(SentryLevel.WARNING, "Failed to close the integration {}.", v1Var, th);
                    }
                }
            }
            n(new ScopeCallback() { // from class: io.sentry.i4
                @Override // io.sentry.ScopeCallback
                public final void run(c1 c1Var) {
                    c1Var.clear();
                }
            });
            h4 h4Var = h4.ISOLATION;
            o(h4Var, new ScopeCallback() { // from class: io.sentry.j4
                @Override // io.sentry.ScopeCallback
                public final void run(c1 c1Var) {
                    c1Var.clear();
                }
            });
            getOptions().getBackpressureMonitor().close();
            getOptions().getTransactionProfiler().close();
            getOptions().getContinuousProfiler().b(true);
            getOptions().getCompositePerformanceCollector().close();
            final j1 executorService = getOptions().getExecutorService();
            if (z10) {
                executorService.submit(new Runnable() { // from class: io.sentry.k4
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27963a.u0(executorService);
                    }
                });
            } else {
                executorService.a(getOptions().getShutdownTimeoutMillis());
            }
            o(h4.CURRENT, new ScopeCallback() { // from class: io.sentry.l4
                @Override // io.sentry.ScopeCallback
                public final void run(c1 c1Var) {
                    q4.v0(z10, c1Var);
                }
            });
            o(h4Var, new ScopeCallback() { // from class: io.sentry.m4
                @Override // io.sentry.ScopeCallback
                public final void run(c1 c1Var) {
                    q4.w0(z10, c1Var);
                }
            });
            o(h4.GLOBAL, new ScopeCallback() { // from class: io.sentry.n4
                @Override // io.sentry.ScopeCallback
                public final void run(c1 c1Var) {
                    q4.x0(z10, c1Var);
                }
            });
        } catch (Throwable th2) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error while closing the Scopes.", th2);
        }
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId b0(Feedback feedback) {
        return e1.h(this, feedback);
    }

    @Override // io.sentry.f1
    public void bindClient(@NotNull i1 i1Var) {
        if (i1Var != null) {
            getOptions().getLogger().c(SentryLevel.DEBUG, "New client bound to scope.", new Object[0]);
            q0().bindClient(i1Var);
        } else {
            getOptions().getLogger().c(SentryLevel.DEBUG, "NoOp client bound to scope.", new Object[0]);
            q0().bindClient(y2.p());
        }
    }

    @Override // io.sentry.f1
    public void c(@NotNull Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, new l0());
    }

    @Override // io.sentry.f1
    public void clearBreadcrumbs() {
        if (isEnabled()) {
            q0().clearBreadcrumbs();
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'clearBreadcrumbs' call is a no-op.", new Object[0]);
        }
    }

    @Override // io.sentry.f1
    public boolean d() {
        return p0().d();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @Nullable
    public io.sentry.transport.b0 e() {
        return p0().e();
    }

    @Override // io.sentry.f1
    public void endSession() {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'endSession' call is a no-op.", new Object[0]);
            return;
        }
        e8 e8VarEndSession = q0().endSession();
        if (e8VarEndSession != null) {
            p0().g(e8VarEndSession, io.sentry.util.m.e(new io.sentry.hints.m()));
        }
    }

    @Override // io.sentry.f1
    public void f(long j10) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'flush' call is a no-op.", new Object[0]);
            return;
        }
        try {
            p0().f(j10);
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'client.flush'.", th);
        }
    }

    @Override // io.sentry.f1
    public /* synthetic */ boolean g() {
        return e1.n(this);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId getLastEventId() {
        return q0().getLastEventId();
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryOptions getOptions() {
        return this.f28105g.getOptions();
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public c1 getScope() {
        return this.f28099a;
    }

    @Override // io.sentry.f1
    @Nullable
    public n1 getSpan() {
        if (isEnabled()) {
            return q0().getSpan();
        }
        getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'getSpan' call is a no-op.", new Object[0]);
        return null;
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @Nullable
    public p1 getTransaction() {
        if (isEnabled()) {
            return q0().getTransaction();
        }
        getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'getTransaction' call is a no-op.", new Object[0]);
        return null;
    }

    @Override // io.sentry.f1
    @NotNull
    public k1 h() {
        return Sentry.setCurrentScopes(this);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public SentryId i(@NotNull p5 p5Var, @Nullable l0 l0Var) {
        io.sentry.util.w.c(p5Var, "SentryEnvelope is required.");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureEnvelope' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            SentryId sentryIdI = p0().i(p5Var, l0Var);
            return sentryIdI != null ? sentryIdI : sentryId;
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing envelope.", th);
            return sentryId;
        }
    }

    @Override // io.sentry.f1
    public boolean isEnabled() {
        return p0().isEnabled();
    }

    @Override // io.sentry.f1
    public void j(@NotNull c9 c9Var) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureUserFeedback' call is a no-op.", new Object[0]);
            return;
        }
        try {
            p0().j(c9Var);
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing captureUserFeedback: " + c9Var.toString(), th);
        }
    }

    @Override // io.sentry.f1
    public void k() {
        if (!getOptions().isContinuousProfilingEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Continuous Profiling is not enabled. Set profilesSampleRate and profilesSampler to null to enable it.", new Object[0]);
            return;
        }
        v3 profileLifecycle = getOptions().getProfileLifecycle();
        v3 v3Var = v3.MANUAL;
        if (profileLifecycle != v3Var) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Profiling lifecycle is %s. Profiling cannot be stopped manually.", getOptions().getProfileLifecycle().name());
        } else {
            getOptions().getLogger().c(SentryLevel.DEBUG, "Stopped continuous Profiling.", new Object[0]);
            getOptions().getContinuousProfiler().e(v3Var);
        }
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId l(@NotNull Throwable th, @Nullable l0 l0Var, @NotNull ScopeCallback scopeCallback) {
        return m0(th, l0Var, scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId m(SentryTransaction sentryTransaction, v8 v8Var, l0 l0Var) {
        return e1.l(this, sentryTransaction, v8Var, l0Var);
    }

    @Override // io.sentry.f1
    public /* synthetic */ void n(ScopeCallback scopeCallback) {
        e1.m(this, scopeCallback);
    }

    @Override // io.sentry.f1
    public void o(@Nullable h4 h4Var, @NotNull ScopeCallback scopeCallback) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'configureScope' call is a no-op.", new Object[0]);
            return;
        }
        try {
            scopeCallback.run(this.f28105g.b(h4Var));
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error in the 'configureScope' callback.", th);
        }
    }

    @Override // io.sentry.f1
    public k1 p() {
        if (isEnabled()) {
            return r("pushScope").h();
        }
        getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'pushScope' call is a no-op.", new Object[0]);
        return w2.a();
    }

    @ApiStatus.Internal
    @NotNull
    public i1 p0() {
        return q0().getClient();
    }

    @Override // io.sentry.f1
    @NotNull
    public io.sentry.logger.a q() {
        return this.f28106h;
    }

    @ApiStatus.Internal
    @NotNull
    public c1 q0() {
        return this.f28105g;
    }

    @Override // io.sentry.f1
    @NotNull
    public f1 r(@NotNull String str) {
        return new q4(this.f28099a.m4211clone(), this.f28100b, this.f28101c, this, str);
    }

    @Override // io.sentry.f1
    public void removeExtra(@Nullable String str) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'removeExtra' call is a no-op.", new Object[0]);
        } else if (str == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "removeExtra called with null parameter.", new Object[0]);
        } else {
            q0().removeExtra(str);
        }
    }

    @Override // io.sentry.f1
    public void removeTag(@Nullable String str) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'removeTag' call is a no-op.", new Object[0]);
        } else if (str == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "removeTag called with null parameter.", new Object[0]);
        } else {
            q0().removeTag(str);
        }
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId s(@NotNull Feedback feedback, @Nullable l0 l0Var, @Nullable ScopeCallback scopeCallback) {
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureFeedback' call is a no-op.", new Object[0]);
            return sentryId;
        }
        if (feedback.getMessage().isEmpty()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "captureFeedback called with empty message.", new Object[0]);
            return sentryId;
        }
        try {
            return p0().h(feedback, l0Var, k0(q0(), scopeCallback));
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing feedback: " + feedback.getMessage(), th);
            return sentryId;
        }
    }

    @Override // io.sentry.f1
    public void setExtra(@Nullable String str, @Nullable String str2) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setExtra' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "setExtra called with null parameter.", new Object[0]);
        } else {
            q0().setExtra(str, str2);
        }
    }

    @Override // io.sentry.f1
    public void setFingerprint(@NotNull List<String> list) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setFingerprint' call is a no-op.", new Object[0]);
        } else if (list == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "setFingerprint called with null parameter.", new Object[0]);
        } else {
            q0().setFingerprint(list);
        }
    }

    @Override // io.sentry.f1
    public void setLevel(@Nullable SentryLevel sentryLevel) {
        if (isEnabled()) {
            q0().setLevel(sentryLevel);
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setLevel' call is a no-op.", new Object[0]);
        }
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    public void setSpanContext(@NotNull Throwable th, @NotNull n1 n1Var, @NotNull String str) {
        q0().setSpanContext(th, n1Var, str);
    }

    @Override // io.sentry.f1
    public void setTag(@Nullable String str, @Nullable String str2) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setTag' call is a no-op.", new Object[0]);
        } else if (str == null || str2 == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "setTag called with null parameter.", new Object[0]);
        } else {
            q0().setTag(str, str2);
        }
    }

    @Override // io.sentry.f1
    public void setTransaction(@Nullable String str) {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setTransaction' call is a no-op.", new Object[0]);
        } else if (str != null) {
            q0().setTransaction(str);
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Transaction cannot be null", new Object[0]);
        }
    }

    @Override // io.sentry.f1
    public void setUser(@Nullable User user) {
        if (isEnabled()) {
            q0().setUser(user);
        } else {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'setUser' call is a no-op.", new Object[0]);
        }
    }

    @Override // io.sentry.f1
    public void startSession() {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'startSession' call is a no-op.", new Object[0]);
            return;
        }
        Scope.d dVarStartSession = q0().startSession();
        if (dVarStartSession == null) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Session could not be started.", new Object[0]);
            return;
        }
        if (dVarStartSession.b() != null) {
            p0().g(dVarStartSession.b(), io.sentry.util.m.e(new io.sentry.hints.m()));
        }
        p0().g(dVarStartSession.a(), io.sentry.util.m.e(new io.sentry.hints.o()));
    }

    @Override // io.sentry.f1
    @Deprecated
    public void t() {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'popScope' call is a no-op.", new Object[0]);
            return;
        }
        q4 q4Var = this.f28102d;
        if (q4Var != null) {
            q4Var.h();
        }
    }

    @Override // io.sentry.f1
    public /* synthetic */ void u(String str) {
        e1.a(this, str);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId v(String str, ScopeCallback scopeCallback) {
        return e1.k(this, str, scopeCallback);
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId w(String str) {
        return e1.j(this, str);
    }

    @Override // io.sentry.f1
    @NotNull
    public SentryId x(@NotNull String str, @NotNull SentryLevel sentryLevel) {
        return n0(str, sentryLevel, null);
    }

    @Override // io.sentry.f1
    @ApiStatus.Internal
    @NotNull
    public SentryId y(@NotNull t3 t3Var) {
        io.sentry.util.w.c(t3Var, "profilingContinuousData is required");
        SentryId sentryId = SentryId.EMPTY_ID;
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Instance is disabled and this 'captureTransaction' call is a no-op.", new Object[0]);
            return sentryId;
        }
        try {
            return p0().n(t3Var, getScope());
        } catch (Throwable th) {
            getOptions().getLogger().b(SentryLevel.ERROR, "Error while capturing profile chunk with id: " + t3Var.l(), th);
            return sentryId;
        }
    }

    @Override // io.sentry.f1
    public /* synthetic */ SentryId z(p5 p5Var) {
        return e1.c(this, p5Var);
    }

    private q4(@NotNull c1 c1Var, @NotNull c1 c1Var2, @NotNull c1 c1Var3, @Nullable q4 q4Var, @NotNull String str) {
        this.f28105g = new i(c1Var3, c1Var2, c1Var);
        this.f28099a = c1Var;
        this.f28100b = c1Var2;
        this.f28101c = c1Var3;
        this.f28102d = q4Var;
        this.f28103e = str;
        SentryOptions options = getOptions();
        B0(options);
        this.f28104f = options.getCompositePerformanceCollector();
        this.f28106h = new io.sentry.logger.c(this);
    }

    @Override // io.sentry.f1
    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public v0 m4213clone() {
        if (!isEnabled()) {
            getOptions().getLogger().c(SentryLevel.WARNING, "Disabled Scopes cloned.", new Object[0]);
        }
        return new q0(Z("scopes clone"));
    }
}
