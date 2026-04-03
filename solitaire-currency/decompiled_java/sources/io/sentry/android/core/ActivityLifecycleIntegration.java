package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import io.sentry.Scope;
import io.sentry.ScopeCallback;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.a9;
import io.sentry.android.core.performance.h;
import io.sentry.g3;
import io.sentry.i7;
import io.sentry.k0;
import io.sentry.l2;
import io.sentry.n5;
import io.sentry.p8;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.q8;
import io.sentry.x8;
import io.sentry.y8;
import io.sentry.z8;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: loaded from: classes5.dex */
public final class ActivityLifecycleIntegration implements io.sentry.v1, Closeable, Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Application f26996a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final w0 f26997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f26998c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private SentryAndroidOptions f26999d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27002g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private io.sentry.n1 f27005j;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private final h f27012q;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f27000e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27001f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27003h = false;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private io.sentry.k0 f27004i = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final WeakHashMap<Activity, io.sentry.n1> f27006k = new WeakHashMap<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private final WeakHashMap<Activity, io.sentry.n1> f27007l = new WeakHashMap<>();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final WeakHashMap<Activity, io.sentry.android.core.performance.b> f27008m = new WeakHashMap<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private n5 f27009n = new i7(new Date(0), 0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @Nullable
    private Future<?> f27010o = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final WeakHashMap<Activity, io.sentry.p1> f27011p = new WeakHashMap<>();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27013r = new io.sentry.util.a();

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27014s = false;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27015t = new io.sentry.util.a();

    public ActivityLifecycleIntegration(@NotNull Application application, @NotNull w0 w0Var, @NotNull h hVar) {
        this.f26996a = (Application) io.sentry.util.w.c(application, "Application is required");
        this.f26997b = (w0) io.sentry.util.w.c(w0Var, "BuildInfoProvider is required");
        this.f27012q = (h) io.sentry.util.w.c(hVar, "ActivityFramesTracker is required");
        if (w0Var.d() >= 29) {
            this.f27002g = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void d1(@Nullable io.sentry.n1 n1Var, @Nullable io.sentry.n1 n1Var2) {
        if (n1Var == null || n1Var.isFinished()) {
            return;
        }
        n1Var.e(Q0(n1Var));
        n5 n5VarS = n1Var2 != null ? n1Var2.s() : null;
        if (n5VarS == null) {
            n5VarS = n1Var.u();
        }
        K0(n1Var, n5VarS, q8.DEADLINE_EXCEEDED);
    }

    private void I0(@Nullable io.sentry.n1 n1Var) {
        if (n1Var == null || n1Var.isFinished()) {
            return;
        }
        n1Var.finish();
    }

    private void J0(@Nullable io.sentry.n1 n1Var, @NotNull n5 n5Var) {
        K0(n1Var, n5Var, null);
    }

    private void K0(@Nullable io.sentry.n1 n1Var, @NotNull n5 n5Var, @Nullable q8 q8Var) {
        if (n1Var == null || n1Var.isFinished()) {
            return;
        }
        if (q8Var == null) {
            q8Var = n1Var.getStatus() != null ? n1Var.getStatus() : q8.OK;
        }
        n1Var.t(q8Var, n5Var);
    }

    private void L0(@Nullable io.sentry.n1 n1Var, @NotNull q8 q8Var) {
        if (n1Var == null || n1Var.isFinished()) {
            return;
        }
        n1Var.k(q8Var);
    }

    private void M0(@Nullable final io.sentry.p1 p1Var, @Nullable io.sentry.n1 n1Var, @Nullable io.sentry.n1 n1Var2) {
        if (p1Var == null || p1Var.isFinished()) {
            return;
        }
        L0(n1Var, q8.DEADLINE_EXCEEDED);
        d1(n1Var2, n1Var);
        S();
        q8 status = p1Var.getStatus();
        if (status == null) {
            status = q8.OK;
        }
        p1Var.k(status);
        io.sentry.f1 f1Var = this.f26998c;
        if (f1Var != null) {
            f1Var.n(new ScopeCallback() { // from class: io.sentry.android.core.k
                @Override // io.sentry.ScopeCallback
                public final void run(io.sentry.c1 c1Var) {
                    this.f27369a.X0(p1Var, c1Var);
                }
            });
        }
    }

    @NotNull
    private String N0(@NotNull Activity activity) {
        return activity.getClass().getSimpleName();
    }

    @NotNull
    private String O0(boolean z10) {
        return z10 ? "Cold Start" : "Warm Start";
    }

    @NotNull
    private String P0(boolean z10) {
        return z10 ? "app.start.cold" : "app.start.warm";
    }

    @NotNull
    private String Q0(@NotNull io.sentry.n1 n1Var) {
        String description = n1Var.getDescription();
        if (description != null && description.endsWith(" - Deadline Exceeded")) {
            return description;
        }
        return n1Var.getDescription() + " - Deadline Exceeded";
    }

    @NotNull
    private String R0(@NotNull String str) {
        return str + " full display";
    }

    private void S() {
        Future<?> future = this.f27010o;
        if (future != null) {
            future.cancel(false);
            this.f27010o = null;
        }
    }

    @NotNull
    private String S0(@NotNull String str) {
        return str + " initial display";
    }

    private boolean T0(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        return sentryAndroidOptions.isTracingEnabled() && sentryAndroidOptions.isEnableAutoActivityLifecycleTracing();
    }

    private boolean U0(@NotNull Activity activity) {
        return this.f27011p.containsKey(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V0(io.sentry.c1 c1Var, io.sentry.p1 p1Var, io.sentry.p1 p1Var2) {
        if (p1Var2 == null) {
            c1Var.setTransaction(p1Var);
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f26999d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "Transaction '%s' won't be bound to the Scope since there's one already in there.", p1Var.getName());
        }
    }

    private void W() {
        this.f27003h = false;
        this.f27009n = new i7(new Date(0L), 0L);
        this.f27008m.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W0(io.sentry.p1 p1Var, io.sentry.c1 c1Var, io.sentry.p1 p1Var2) {
        if (p1Var2 == p1Var) {
            c1Var.clearTransaction();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c1(WeakReference weakReference, String str, io.sentry.p1 p1Var) {
        Activity activity = (Activity) weakReference.get();
        if (activity != null) {
            this.f27012q.n(activity, p1Var.getEventId());
            return;
        }
        SentryAndroidOptions sentryAndroidOptions = this.f26999d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.WARNING, "Unable to track activity frames as the Activity %s has been destroyed.", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f1, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void b1(@Nullable io.sentry.n1 n1Var, @Nullable io.sentry.n1 n1Var2) {
        io.sentry.android.core.performance.h hVarQ = io.sentry.android.core.performance.h.q();
        io.sentry.android.core.performance.i iVarL = hVarQ.l();
        io.sentry.android.core.performance.i iVarR = hVarQ.r();
        if (iVarL.n() && iVarL.m()) {
            iVarL.t();
        }
        if (iVarR.n() && iVarR.m()) {
            iVarR.t();
        }
        i0();
        io.sentry.k1 k1VarA = this.f27015t.a();
        try {
            SentryAndroidOptions sentryAndroidOptions = this.f26999d;
            if (sentryAndroidOptions == null || n1Var2 == null) {
                I0(n1Var2);
                if (this.f27014s) {
                    I0(n1Var);
                }
            } else {
                n5 n5VarA = sentryAndroidOptions.getDateProvider().a();
                long millis = TimeUnit.NANOSECONDS.toMillis(n5VarA.c(n1Var2.u()));
                Long lValueOf = Long.valueOf(millis);
                l2.a aVar = l2.a.MILLISECOND;
                n1Var2.n(MeasurementValue.KEY_TIME_TO_INITIAL_DISPLAY, lValueOf, aVar);
                if (n1Var != null && this.f27014s) {
                    this.f27014s = false;
                    n1Var2.n(MeasurementValue.KEY_TIME_TO_FULL_DISPLAY, Long.valueOf(millis), aVar);
                    n1Var.n(MeasurementValue.KEY_TIME_TO_FULL_DISPLAY, Long.valueOf(millis), aVar);
                    J0(n1Var, n5VarA);
                }
                J0(n1Var2, n5VarA);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g1, reason: merged with bridge method [inline-methods] */
    public void Z0(@NotNull io.sentry.n1 n1Var, @NotNull io.sentry.n1 n1Var2) {
        S();
        io.sentry.k1 k1VarA = this.f27015t.a();
        try {
            if (!n1Var.isFinished()) {
                this.f27014s = true;
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            SentryAndroidOptions sentryAndroidOptions = this.f26999d;
            if (sentryAndroidOptions != null) {
                n5 n5VarA = sentryAndroidOptions.getDateProvider().a();
                n1Var2.n(MeasurementValue.KEY_TIME_TO_FULL_DISPLAY, Long.valueOf(TimeUnit.NANOSECONDS.toMillis(n5VarA.c(n1Var2.u()))), l2.a.MILLISECOND);
                J0(n1Var2, n5VarA);
            } else {
                I0(n1Var2);
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

    private void h1(@NotNull p8 p8Var) {
        p8Var.g("auto.ui.activity");
    }

    private void i0() {
        n5 n5VarE = io.sentry.android.core.performance.h.q().m(this.f26999d).e();
        if (!this.f27000e || n5VarE == null) {
            return;
        }
        J0(this.f27005j, n5VarE);
    }

    private void i1(@NotNull Activity activity) {
        Boolean boolValueOf;
        n5 n5Var;
        n5 n5Var2;
        final WeakReference weakReference = new WeakReference(activity);
        if (this.f26998c == null || U0(activity)) {
            return;
        }
        if (!this.f27000e) {
            this.f27011p.put(activity, g3.v());
            if (this.f26999d.isEnableAutoTraceIdGeneration()) {
                io.sentry.util.k0.r(this.f26998c);
                return;
            }
            return;
        }
        j1();
        final String strN0 = N0(activity);
        io.sentry.android.core.performance.i iVarM = io.sentry.android.core.performance.h.q().m(this.f26999d);
        x8 x8Var = null;
        if (e1.t() && iVarM.n()) {
            n5 n5VarH = iVarM.h();
            boolValueOf = Boolean.valueOf(io.sentry.android.core.performance.h.q().n() == h.a.COLD);
            n5Var = n5VarH;
        } else {
            boolValueOf = null;
            n5Var = null;
        }
        a9 a9Var = new a9();
        a9Var.s(30000L);
        if (this.f26999d.isEnableActivityLifecycleTracingAutoFinish()) {
            a9Var.t(this.f26999d.getIdleTimeout());
            a9Var.i(true);
        }
        a9Var.v(true);
        a9Var.u(new z8() { // from class: io.sentry.android.core.o
            @Override // io.sentry.z8
            public final void a(io.sentry.p1 p1Var) {
                this.f27425a.c1(weakReference, strN0, p1Var);
            }
        });
        if (this.f27003h || n5Var == null || boolValueOf == null) {
            n5Var2 = this.f27009n;
        } else {
            x8 x8VarK = io.sentry.android.core.performance.h.q().k();
            io.sentry.android.core.performance.h.q().B(null);
            x8Var = x8VarK;
            n5Var2 = n5Var;
        }
        a9Var.h(n5Var2);
        a9Var.r(x8Var != null);
        h1(a9Var);
        final io.sentry.p1 p1VarJ = this.f26998c.J(new y8(strN0, TransactionNameSource.COMPONENT, "ui.load", x8Var), a9Var);
        p8 p8Var = new p8();
        h1(p8Var);
        if (!this.f27003h && n5Var != null && boolValueOf != null) {
            this.f27005j = p1VarJ.p(P0(boolValueOf.booleanValue()), O0(boolValueOf.booleanValue()), n5Var, io.sentry.u1.SENTRY, p8Var);
            i0();
        }
        String strS0 = S0(strN0);
        io.sentry.u1 u1Var = io.sentry.u1.SENTRY;
        final io.sentry.n1 n1VarP = p1VarJ.p("ui.load.initial_display", strS0, n5Var2, u1Var, p8Var);
        this.f27006k.put(activity, n1VarP);
        if (this.f27001f && this.f27004i != null && this.f26999d != null) {
            final io.sentry.n1 n1VarP2 = p1VarJ.p("ui.load.full_display", R0(strN0), n5Var2, u1Var, p8Var);
            try {
                this.f27007l.put(activity, n1VarP2);
                this.f27010o = this.f26999d.getExecutorService().b(new Runnable() { // from class: io.sentry.android.core.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27436a.d1(n1VarP2, n1VarP);
                    }
                }, 25000L);
            } catch (RejectedExecutionException e10) {
                this.f26999d.getLogger().b(SentryLevel.ERROR, "Failed to call the executor. Time to full display span will not be finished automatically. Did you call Sentry.close()?", e10);
            }
        }
        this.f26998c.n(new ScopeCallback() { // from class: io.sentry.android.core.q
            @Override // io.sentry.ScopeCallback
            public final void run(io.sentry.c1 c1Var) {
                this.f27478a.e1(p1VarJ, c1Var);
            }
        });
        this.f27011p.put(activity, p1VarJ);
    }

    private void j1() {
        for (Map.Entry<Activity, io.sentry.p1> entry : this.f27011p.entrySet()) {
            M0(entry.getValue(), this.f27006k.get(entry.getKey()), this.f27007l.get(entry.getKey()));
        }
    }

    private void k1(@NotNull Activity activity, boolean z10) {
        if (this.f27000e && z10) {
            M0(this.f27011p.get(activity), null, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: R, reason: merged with bridge method [inline-methods] */
    public void e1(@NotNull final io.sentry.c1 c1Var, @NotNull final io.sentry.p1 p1Var) {
        c1Var.withTransaction(new Scope.c() { // from class: io.sentry.android.core.r
            @Override // io.sentry.Scope.c
            public final void a(io.sentry.p1 p1Var2) {
                this.f27484a.V0(c1Var, p1Var, p1Var2);
            }
        });
    }

    @Override // io.sentry.v1
    public void c(@NotNull io.sentry.f1 f1Var, @NotNull SentryOptions sentryOptions) {
        this.f26999d = (SentryAndroidOptions) io.sentry.util.w.c(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.f26998c = (io.sentry.f1) io.sentry.util.w.c(f1Var, "Scopes are required");
        this.f27000e = T0(this.f26999d);
        this.f27004i = this.f26999d.getFullyDisplayedReporter();
        this.f27001f = this.f26999d.isEnableTimeToFullDisplayTracing();
        this.f26996a.registerActivityLifecycleCallbacks(this);
        this.f26999d.getLogger().c(SentryLevel.DEBUG, "ActivityLifecycleIntegration installed.", new Object[0]);
        io.sentry.util.p.a("ActivityLifecycle");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f26996a.unregisterActivityLifecycleCallbacks(this);
        SentryAndroidOptions sentryAndroidOptions = this.f26999d;
        if (sentryAndroidOptions != null) {
            sentryAndroidOptions.getLogger().c(SentryLevel.DEBUG, "ActivityLifecycleIntegration removed.", new Object[0]);
        }
        this.f27012q.p();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void X0(@NotNull final io.sentry.c1 c1Var, @NotNull final io.sentry.p1 p1Var) {
        c1Var.withTransaction(new Scope.c() { // from class: io.sentry.android.core.n
            @Override // io.sentry.Scope.c
            public final void a(io.sentry.p1 p1Var2) {
                ActivityLifecycleIntegration.W0(p1Var, c1Var, p1Var2);
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        io.sentry.k0 k0Var;
        SentryAndroidOptions sentryAndroidOptions;
        if (!this.f27002g) {
            onActivityPreCreated(activity, bundle);
        }
        io.sentry.k1 k1VarA = this.f27013r.a();
        try {
            if (this.f26998c != null && (sentryAndroidOptions = this.f26999d) != null && sentryAndroidOptions.isEnableScreenTracking()) {
                final String strA = io.sentry.android.core.internal.util.e.a(activity);
                this.f26998c.n(new ScopeCallback() { // from class: io.sentry.android.core.l
                    @Override // io.sentry.ScopeCallback
                    public final void run(io.sentry.c1 c1Var) {
                        c1Var.setScreen(strA);
                    }
                });
            }
            i1(activity);
            final io.sentry.n1 n1Var = this.f27006k.get(activity);
            final io.sentry.n1 n1Var2 = this.f27007l.get(activity);
            this.f27003h = true;
            if (this.f27000e && n1Var != null && n1Var2 != null && (k0Var = this.f27004i) != null) {
                k0Var.b(new k0.a() { // from class: io.sentry.android.core.m
                    @Override // io.sentry.k0.a
                    public final void a() {
                        this.f27405a.Z0(n1Var, n1Var2);
                    }
                });
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f27013r.a();
        try {
            io.sentry.android.core.performance.b bVarRemove = this.f27008m.remove(activity);
            if (bVarRemove != null) {
                bVarRemove.a();
            }
            if (this.f27000e) {
                L0(this.f27005j, q8.CANCELLED);
                io.sentry.n1 n1Var = this.f27006k.get(activity);
                io.sentry.n1 n1Var2 = this.f27007l.get(activity);
                L0(n1Var, q8.DEADLINE_EXCEEDED);
                d1(n1Var2, n1Var);
                S();
                k1(activity, true);
                this.f27005j = null;
                this.f27006k.remove(activity);
                this.f27007l.remove(activity);
            }
            this.f27011p.remove(activity);
            if (this.f27011p.isEmpty() && !activity.isChangingConfigurations()) {
                W();
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f27013r.a();
        try {
            if (!this.f27002g) {
                onActivityPrePaused(activity);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        io.sentry.android.core.performance.b bVar = this.f27008m.get(activity);
        if (bVar != null) {
            io.sentry.p1 p1Var = this.f27005j;
            if (p1Var == null) {
                p1Var = this.f27011p.get(activity);
            }
            bVar.b(p1Var);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(@NotNull Activity activity) {
        io.sentry.android.core.performance.b bVar = this.f27008m.get(activity);
        if (bVar != null) {
            io.sentry.p1 p1Var = this.f27005j;
            if (p1Var == null) {
                p1Var = this.f27011p.get(activity);
            }
            bVar.c(p1Var);
            bVar.e();
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
        io.sentry.android.core.performance.b bVar = new io.sentry.android.core.performance.b(activity.getClass().getName());
        this.f27008m.put(activity, bVar);
        if (this.f27003h) {
            return;
        }
        io.sentry.f1 f1Var = this.f26998c;
        n5 n5VarA = f1Var != null ? f1Var.getOptions().getDateProvider().a() : w.a();
        this.f27009n = n5VarA;
        bVar.g(n5VarA);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(@NotNull Activity activity) {
        this.f27003h = true;
        io.sentry.f1 f1Var = this.f26998c;
        this.f27009n = f1Var != null ? f1Var.getOptions().getDateProvider().a() : w.a();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStarted(@NotNull Activity activity) {
        io.sentry.android.core.performance.b bVar = this.f27008m.get(activity);
        if (bVar != null) {
            SentryAndroidOptions sentryAndroidOptions = this.f26999d;
            bVar.h(sentryAndroidOptions != null ? sentryAndroidOptions.getDateProvider().a() : w.a());
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f27013r.a();
        try {
            if (!this.f27002g) {
                onActivityPostStarted(activity);
            }
            if (this.f27000e) {
                final io.sentry.n1 n1Var = this.f27006k.get(activity);
                final io.sentry.n1 n1Var2 = this.f27007l.get(activity);
                if (activity.getWindow() != null) {
                    io.sentry.android.core.internal.util.l.f(activity, new Runnable() { // from class: io.sentry.android.core.i
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f27207a.a1(n1Var2, n1Var);
                        }
                    }, this.f26997b);
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.j
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f27353a.b1(n1Var2, n1Var);
                        }
                    });
                }
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        io.sentry.k1 k1VarA = this.f27013r.a();
        try {
            if (!this.f27002g) {
                onActivityPostCreated(activity, null);
                onActivityPreStarted(activity);
            }
            if (this.f27000e) {
                this.f27012q.e(activity);
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

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
    }
}
