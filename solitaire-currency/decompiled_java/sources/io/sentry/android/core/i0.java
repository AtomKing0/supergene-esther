package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.f0;
import io.sentry.r3;
import io.sentry.r4;
import io.sentry.x3;
import io.sentry.y3;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidTransactionProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
final class i0 implements io.sentry.q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Context f27210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f27212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f27213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f27214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final io.sentry.j1 f27215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final w0 f27216g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f27217h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f27218i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.v f27219j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private y3 f27220k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private f0 f27221l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f27222m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f27223n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    private Date f27224o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NotNull
    private final io.sentry.util.a f27225p;

    public i0(@NotNull Context context, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull w0 w0Var, @NotNull io.sentry.android.core.internal.util.v vVar) {
        this(context, w0Var, vVar, sentryAndroidOptions.getLogger(), sentryAndroidOptions.getProfilingTracesDirPath(), sentryAndroidOptions.isProfilingEnabled(), sentryAndroidOptions.getProfilingTracesHz(), sentryAndroidOptions.getExecutorService());
    }

    private void d() {
        if (this.f27217h) {
            return;
        }
        this.f27217h = true;
        if (!this.f27213d) {
            this.f27211b.c(SentryLevel.INFO, "Profiling is disabled in options.", new Object[0]);
            return;
        }
        String str = this.f27212c;
        if (str == null) {
            this.f27211b.c(SentryLevel.WARNING, "Disabling profiling because no profiling traces dir path is defined in options.", new Object[0]);
            return;
        }
        int i10 = this.f27214e;
        if (i10 <= 0) {
            this.f27211b.c(SentryLevel.WARNING, "Disabling profiling because trace rate is set to %d", Integer.valueOf(i10));
        } else {
            this.f27221l = new f0(str, ((int) TimeUnit.SECONDS.toMicros(1L)) / this.f27214e, this.f27219j, this.f27215f, this.f27211b);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List e() throws Exception {
        return io.sentry.android.core.internal.util.g.a().c();
    }

    @SuppressLint({"NewApi"})
    private boolean f() {
        f0.c cVarJ;
        f0 f0Var = this.f27221l;
        if (f0Var == null || (cVarJ = f0Var.j()) == null) {
            return false;
        }
        this.f27222m = cVarJ.f27186a;
        this.f27223n = cVarJ.f27187b;
        this.f27224o = cVarJ.f27188c;
        return true;
    }

    @SuppressLint({"NewApi"})
    @Nullable
    private x3 g(@NotNull String str, @NotNull String str2, @NotNull String str3, boolean z10, @Nullable List<r3> list, @NotNull SentryOptions sentryOptions) {
        io.sentry.k1 k1VarA = this.f27225p.a();
        try {
            if (this.f27221l == null) {
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
            }
            if (this.f27216g.d() < 22) {
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
            }
            y3 y3Var = this.f27220k;
            if (y3Var != null && y3Var.h().equals(str2)) {
                int i10 = this.f27218i;
                if (i10 > 0) {
                    this.f27218i = i10 - 1;
                }
                this.f27211b.c(SentryLevel.DEBUG, "Transaction %s (%s) finished.", str, str3);
                if (this.f27218i != 0) {
                    y3 y3Var2 = this.f27220k;
                    if (y3Var2 != null) {
                        y3Var2.k(Long.valueOf(SystemClock.elapsedRealtimeNanos()), Long.valueOf(this.f27222m), Long.valueOf(Process.getElapsedCpuTime()), Long.valueOf(this.f27223n));
                    }
                    if (k1VarA != null) {
                        k1VarA.close();
                    }
                    return null;
                }
                f0.b bVarG = this.f27221l.g(false, list);
                if (bVarG == null) {
                    if (k1VarA != null) {
                        k1VarA.close();
                    }
                    return null;
                }
                long j10 = bVarG.f27181a - this.f27222m;
                ArrayList arrayList = new ArrayList(1);
                y3 y3Var3 = this.f27220k;
                if (y3Var3 != null) {
                    arrayList.add(y3Var3);
                }
                this.f27220k = null;
                this.f27218i = 0;
                Long lQ = sentryOptions instanceof SentryAndroidOptions ? j1.i(this.f27210a, (SentryAndroidOptions) sentryOptions).q() : null;
                String string = lQ != null ? Long.toString(lQ.longValue()) : "0";
                String[] strArr = Build.SUPPORTED_ABIS;
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((y3) it.next()).k(Long.valueOf(bVarG.f27181a), Long.valueOf(this.f27222m), Long.valueOf(bVarG.f27182b), Long.valueOf(this.f27223n));
                }
                x3 x3Var = new x3(bVarG.f27183c, this.f27224o, arrayList, str, str2, str3, Long.toString(j10), this.f27216g.d(), (strArr == null || strArr.length <= 0) ? "" : strArr[0], new Callable() { // from class: io.sentry.android.core.h0
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return i0.e();
                    }
                }, this.f27216g.b(), this.f27216g.c(), this.f27216g.e(), this.f27216g.f(), string, sentryOptions.getProguardUuid(), sentryOptions.getRelease(), sentryOptions.getEnvironment(), (bVarG.f27185e || z10) ? "timeout" : "normal", bVarG.f27184d);
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return x3Var;
            }
            this.f27211b.c(SentryLevel.INFO, "Transaction %s (%s) finished, but was not currently being profiled. Skipping", str, str3);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return null;
        } catch (Throwable th) {
            if (k1VarA == null) {
                throw th;
            }
            try {
                k1VarA.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    @Override // io.sentry.q1
    public void a(@NotNull io.sentry.p1 p1Var) {
        io.sentry.k1 k1VarA = this.f27225p.a();
        try {
            if (this.f27218i > 0 && this.f27220k == null) {
                this.f27220k = new y3(p1Var, Long.valueOf(this.f27222m), Long.valueOf(this.f27223n));
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

    @Override // io.sentry.q1
    @Nullable
    public x3 b(@NotNull io.sentry.p1 p1Var, @Nullable List<r3> list, @NotNull SentryOptions sentryOptions) {
        io.sentry.k1 k1VarA = this.f27225p.a();
        try {
            x3 x3VarG = g(p1Var.getName(), p1Var.getEventId().toString(), p1Var.r().n().toString(), false, list, sentryOptions);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return x3VarG;
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

    @Override // io.sentry.q1
    public void close() {
        y3 y3Var = this.f27220k;
        if (y3Var != null) {
            g(y3Var.i(), this.f27220k.h(), this.f27220k.j(), true, null, r4.a().getOptions());
        } else {
            int i10 = this.f27218i;
            if (i10 != 0) {
                this.f27218i = i10 - 1;
            }
        }
        f0 f0Var = this.f27221l;
        if (f0Var != null) {
            f0Var.f();
        }
    }

    @Override // io.sentry.q1
    public boolean isRunning() {
        return this.f27218i != 0;
    }

    @Override // io.sentry.q1
    public void start() {
        io.sentry.k1 k1VarA = this.f27225p.a();
        try {
            if (this.f27216g.d() < 22) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            d();
            int i10 = this.f27218i + 1;
            this.f27218i = i10;
            if (i10 == 1 && f()) {
                this.f27211b.c(SentryLevel.DEBUG, "Profiler started.", new Object[0]);
            } else {
                this.f27218i--;
                this.f27211b.c(SentryLevel.WARNING, "A profile is already running. This profile will be ignored.", new Object[0]);
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

    public i0(@NotNull Context context, @NotNull w0 w0Var, @NotNull io.sentry.android.core.internal.util.v vVar, @NotNull io.sentry.w0 w0Var2, @Nullable String str, boolean z10, int i10, @NotNull io.sentry.j1 j1Var) {
        this.f27217h = false;
        this.f27218i = 0;
        this.f27221l = null;
        this.f27225p = new io.sentry.util.a();
        this.f27210a = (Context) io.sentry.util.w.c(e1.h(context), "The application context is required");
        this.f27211b = (io.sentry.w0) io.sentry.util.w.c(w0Var2, "ILogger is required");
        this.f27219j = (io.sentry.android.core.internal.util.v) io.sentry.util.w.c(vVar, "SentryFrameMetricsCollector is required");
        this.f27216g = (w0) io.sentry.util.w.c(w0Var, "The BuildInfoProvider is required.");
        this.f27212c = str;
        this.f27213d = z10;
        this.f27214e = i10;
        this.f27215f = (io.sentry.j1) io.sentry.util.w.c(j1Var, "The ISentryExecutorService is required.");
        this.f27224o = io.sentry.n.d();
    }
}
