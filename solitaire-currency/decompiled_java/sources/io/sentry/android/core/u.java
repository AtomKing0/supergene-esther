package io.sentry.android.core;

import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.f0;
import io.sentry.i7;
import io.sentry.n5;
import io.sentry.protocol.SentryId;
import io.sentry.r0;
import io.sentry.t3;
import io.sentry.transport.b0;
import io.sentry.v2;
import io.sentry.v3;
import io.sentry.w8;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidContinuousProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class u implements io.sentry.s0, b0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f27511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f27512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final io.sentry.j1 f27513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final w0 f27514e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.v f27516g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private io.sentry.f1 f27519j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Future<?> f27520k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private io.sentry.j f27521l;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NotNull
    private SentryId f27523n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private SentryId f27524o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final AtomicBoolean f27525p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    private n5 f27526q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private volatile boolean f27527r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f27528s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f27529t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f27530u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final io.sentry.util.a f27531v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final io.sentry.util.a f27532w;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f27515f = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private f0 f27517h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f27518i = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final List<t3.a> f27522m = new ArrayList();

    /* JADX INFO: compiled from: AndroidContinuousProfiler.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27533a;

        static {
            int[] iArr = new int[v3.values().length];
            f27533a = iArr;
            try {
                iArr[v3.TRACE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27533a[v3.MANUAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public u(@NotNull w0 w0Var, @NotNull io.sentry.android.core.internal.util.v vVar, @NotNull io.sentry.w0 w0Var2, @Nullable String str, int i10, @NotNull io.sentry.j1 j1Var) {
        SentryId sentryId = SentryId.EMPTY_ID;
        this.f27523n = sentryId;
        this.f27524o = sentryId;
        this.f27525p = new AtomicBoolean(false);
        this.f27526q = new i7();
        this.f27527r = true;
        this.f27528s = false;
        this.f27529t = false;
        this.f27530u = 0;
        this.f27531v = new io.sentry.util.a();
        this.f27532w = new io.sentry.util.a();
        this.f27510a = w0Var2;
        this.f27516g = vVar;
        this.f27514e = w0Var;
        this.f27511b = str;
        this.f27512c = i10;
        this.f27513d = j1Var;
    }

    private void i() {
        if (this.f27515f) {
            return;
        }
        this.f27515f = true;
        String str = this.f27511b;
        if (str == null) {
            this.f27510a.c(SentryLevel.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        int i10 = this.f27512c;
        if (i10 <= 0) {
            this.f27510a.c(SentryLevel.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i10));
        } else {
            this.f27517h = new f0(str, ((int) TimeUnit.SECONDS.toMicros(1L)) / this.f27512c, this.f27516g, null, this.f27510a);
        }
    }

    private void j() {
        io.sentry.f1 f1Var = this.f27519j;
        if ((f1Var == null || f1Var == v2.a()) && Sentry.getCurrentScopes() != v2.a()) {
            this.f27519j = Sentry.getCurrentScopes();
            this.f27521l = Sentry.getCurrentScopes().getOptions().getCompositePerformanceCollector();
            io.sentry.transport.b0 b0VarE = this.f27519j.e();
            if (b0VarE != null) {
                b0VarE.q(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(SentryOptions sentryOptions, io.sentry.f1 f1Var) {
        if (this.f27525p.get()) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f27522m.size());
        io.sentry.k1 k1VarA = this.f27532w.a();
        try {
            Iterator<t3.a> it = this.f27522m.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().a(sentryOptions));
            }
            this.f27522m.clear();
            if (k1VarA != null) {
                k1VarA.close();
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                f1Var.y((t3) it2.next());
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
    public /* synthetic */ void l() {
        o(true);
    }

    private void m(@NotNull final io.sentry.f1 f1Var, @NotNull final SentryOptions sentryOptions) {
        try {
            sentryOptions.getExecutorService().submit(new Runnable() { // from class: io.sentry.android.core.s
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27491a.k(sentryOptions, f1Var);
                }
            });
        } catch (Throwable th) {
            sentryOptions.getLogger().b(SentryLevel.DEBUG, "Failed to send profile chunks.", th);
        }
    }

    private void n() {
        j();
        if (this.f27514e.d() < 22) {
            return;
        }
        i();
        if (this.f27517h == null) {
            return;
        }
        io.sentry.f1 f1Var = this.f27519j;
        if (f1Var != null) {
            io.sentry.transport.b0 b0VarE = f1Var.e();
            if (b0VarE != null && (b0VarE.J(io.sentry.m.All) || b0VarE.J(io.sentry.m.ProfileChunkUi))) {
                this.f27510a.c(SentryLevel.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
                o(false);
                return;
            } else {
                if (this.f27519j.getOptions().getConnectionStatusProvider().a() == r0.a.DISCONNECTED) {
                    this.f27510a.c(SentryLevel.WARNING, "Device is offline. Stopping profiler.", new Object[0]);
                    o(false);
                    return;
                }
                this.f27526q = this.f27519j.getOptions().getDateProvider().a();
            }
        } else {
            this.f27526q = new i7();
        }
        if (this.f27517h.j() == null) {
            return;
        }
        this.f27518i = true;
        SentryId sentryId = this.f27523n;
        SentryId sentryId2 = SentryId.EMPTY_ID;
        if (sentryId == sentryId2) {
            this.f27523n = new SentryId();
        }
        if (this.f27524o == sentryId2) {
            this.f27524o = new SentryId();
        }
        io.sentry.j jVar = this.f27521l;
        if (jVar != null) {
            jVar.f(this.f27524o.toString());
        }
        try {
            this.f27520k = this.f27513d.b(new Runnable() { // from class: io.sentry.android.core.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27498a.l();
                }
            }, 60000L);
        } catch (RejectedExecutionException e10) {
            this.f27510a.b(SentryLevel.ERROR, "Failed to schedule profiling chunk finish. Did you call Sentry.close()?", e10);
            this.f27528s = true;
        }
    }

    private void o(boolean z10) {
        j();
        io.sentry.k1 k1VarA = this.f27531v.a();
        try {
            Future<?> future = this.f27520k;
            if (future != null) {
                future.cancel(true);
            }
            if (this.f27517h != null && this.f27518i) {
                if (this.f27514e.d() < 22) {
                    if (k1VarA != null) {
                        k1VarA.close();
                        return;
                    }
                    return;
                }
                io.sentry.j jVar = this.f27521l;
                f0.b bVarG = this.f27517h.g(false, jVar != null ? jVar.c(this.f27524o.toString()) : null);
                if (bVarG == null) {
                    this.f27510a.c(SentryLevel.ERROR, "An error occurred while collecting a profile chunk, and it won't be sent.", new Object[0]);
                } else {
                    io.sentry.k1 k1VarA2 = this.f27532w.a();
                    try {
                        this.f27522m.add(new t3.a(this.f27523n, this.f27524o, bVarG.f27184d, bVarG.f27183c, this.f27526q));
                        if (k1VarA2 != null) {
                            k1VarA2.close();
                        }
                    } finally {
                    }
                }
                this.f27518i = false;
                SentryId sentryId = SentryId.EMPTY_ID;
                this.f27524o = sentryId;
                io.sentry.f1 f1Var = this.f27519j;
                if (f1Var != null) {
                    m(f1Var, f1Var.getOptions());
                }
                if (!z10 || this.f27528s) {
                    this.f27523n = sentryId;
                    this.f27510a.c(SentryLevel.DEBUG, "Profile chunk finished.", new Object[0]);
                } else {
                    this.f27510a.c(SentryLevel.DEBUG, "Profile chunk finished. Starting a new one.", new Object[0]);
                    n();
                }
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            SentryId sentryId2 = SentryId.EMPTY_ID;
            this.f27523n = sentryId2;
            this.f27524o = sentryId2;
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

    @Override // io.sentry.transport.b0.b
    public void a(@NotNull io.sentry.transport.b0 b0Var) {
        if (b0Var.J(io.sentry.m.All) || b0Var.J(io.sentry.m.ProfileChunkUi)) {
            this.f27510a.c(SentryLevel.WARNING, "SDK is rate limited. Stopping profiler.", new Object[0]);
            o(false);
        }
    }

    @Override // io.sentry.s0
    public void b(boolean z10) {
        io.sentry.k1 k1VarA = this.f27531v.a();
        try {
            this.f27530u = 0;
            this.f27528s = true;
            if (z10) {
                o(false);
                this.f27525p.set(true);
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

    @Override // io.sentry.s0
    public void c(@NotNull v3 v3Var, @NotNull w8 w8Var) {
        io.sentry.k1 k1VarA = this.f27531v.a();
        try {
            if (this.f27527r) {
                this.f27529t = w8Var.c(io.sentry.util.b0.a().d());
                this.f27527r = false;
            }
            if (!this.f27529t) {
                this.f27510a.c(SentryLevel.DEBUG, "Profiler was not started due to sampling decision.", new Object[0]);
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            int i10 = a.f27533a[v3Var.ordinal()];
            if (i10 == 1) {
                if (this.f27530u < 0) {
                    this.f27530u = 0;
                }
                this.f27530u++;
            } else if (i10 == 2 && isRunning()) {
                this.f27510a.c(SentryLevel.DEBUG, "Profiler is already running.", new Object[0]);
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            if (!isRunning()) {
                this.f27510a.c(SentryLevel.DEBUG, "Started Profiler.", new Object[0]);
                n();
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

    @Override // io.sentry.s0
    public void d() {
        this.f27527r = true;
    }

    @Override // io.sentry.s0
    public void e(@NotNull v3 v3Var) {
        io.sentry.k1 k1VarA = this.f27531v.a();
        try {
            int i10 = a.f27533a[v3Var.ordinal()];
            if (i10 == 1) {
                int i11 = this.f27530u - 1;
                this.f27530u = i11;
                if (i11 > 0) {
                    if (k1VarA != null) {
                        k1VarA.close();
                        return;
                    }
                    return;
                } else {
                    if (i11 < 0) {
                        this.f27530u = 0;
                    }
                    this.f27528s = true;
                }
            } else if (i10 == 2) {
                this.f27528s = true;
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

    @Override // io.sentry.s0
    @NotNull
    public SentryId f() {
        return this.f27523n;
    }

    @Override // io.sentry.s0
    public boolean isRunning() {
        return this.f27518i;
    }
}
