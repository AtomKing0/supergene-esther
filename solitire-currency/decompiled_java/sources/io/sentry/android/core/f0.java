package io.sentry.android.core;

import android.annotation.SuppressLint;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.SentryLevel;
import io.sentry.android.core.internal.util.v;
import io.sentry.c8;
import io.sentry.i7;
import io.sentry.r3;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: AndroidProfiler.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class f0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final File f27165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f27166c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f27169f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.v f27170g;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    private final io.sentry.j1 f27175l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27176m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f27164a = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Future<?> f27167d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private File f27168e = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<io.sentry.profilemeasurements.b> f27171h = new ArrayDeque<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<io.sentry.profilemeasurements.b> f27172i = new ArrayDeque<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private final ArrayDeque<io.sentry.profilemeasurements.b> f27173j = new ArrayDeque<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private final Map<String, io.sentry.profilemeasurements.a> f27174k = new HashMap();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f27177n = false;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NotNull
    protected final io.sentry.util.a f27178o = new io.sentry.util.a();

    /* JADX INFO: compiled from: AndroidProfiler.java */
    class a implements v.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f27179a = 0.0f;

        a() {
        }

        @Override // io.sentry.android.core.internal.util.v.b
        public void e(long j10, long j11, long j12, long j13, boolean z10, boolean z11, float f10) {
            i7 i7Var = new i7();
            long jNanoTime = ((j11 - System.nanoTime()) + SystemClock.elapsedRealtimeNanos()) - f0.this.f27164a;
            if (jNanoTime < 0) {
                return;
            }
            if (z11) {
                f0.this.f27173j.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Long.valueOf(j12), i7Var));
            } else if (z10) {
                f0.this.f27172i.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Long.valueOf(j12), i7Var));
            }
            if (f10 != this.f27179a) {
                this.f27179a = f10;
                f0.this.f27171h.addLast(new io.sentry.profilemeasurements.b(Long.valueOf(jNanoTime), Float.valueOf(f10), i7Var));
            }
        }
    }

    /* JADX INFO: compiled from: AndroidProfiler.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f27181a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f27182b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final File f27183c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public final Map<String, io.sentry.profilemeasurements.a> f27184d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f27185e;

        public b(long j10, long j11, boolean z10, @NotNull File file, @NotNull Map<String, io.sentry.profilemeasurements.a> map) {
            this.f27181a = j10;
            this.f27183c = file;
            this.f27182b = j11;
            this.f27184d = map;
            this.f27185e = z10;
        }
    }

    /* JADX INFO: compiled from: AndroidProfiler.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f27186a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f27187b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public final Date f27188c;

        public c(long j10, long j11, @NotNull Date date) {
            this.f27186a = j10;
            this.f27187b = j11;
            this.f27188c = date;
        }
    }

    public f0(@NotNull String str, int i10, @NotNull io.sentry.android.core.internal.util.v vVar, @Nullable io.sentry.j1 j1Var, @NotNull io.sentry.w0 w0Var) {
        this.f27165b = new File((String) io.sentry.util.w.c(str, "TracesFilesDirPath is required"));
        this.f27166c = i10;
        this.f27176m = (io.sentry.w0) io.sentry.util.w.c(w0Var, "Logger is required");
        this.f27175l = j1Var;
        this.f27170g = (io.sentry.android.core.internal.util.v) io.sentry.util.w.c(vVar, "SentryFrameMetricsCollector is required");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h() {
        g(true, null);
    }

    @SuppressLint({"NewApi"})
    private void i(@Nullable List<r3> list) {
        long jElapsedRealtimeNanos = (SystemClock.elapsedRealtimeNanos() - this.f27164a) - TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
        if (list != null) {
            ArrayDeque arrayDeque = new ArrayDeque(list.size());
            ArrayDeque arrayDeque2 = new ArrayDeque(list.size());
            ArrayDeque arrayDeque3 = new ArrayDeque(list.size());
            synchronized (list) {
                for (r3 r3Var : list) {
                    io.sentry.k kVarC = r3Var.c();
                    io.sentry.m2 m2VarD = r3Var.d();
                    if (kVarC != null) {
                        arrayDeque3.add(new io.sentry.profilemeasurements.b(Long.valueOf(kVarC.b().g() + jElapsedRealtimeNanos), Double.valueOf(kVarC.a()), kVarC.b()));
                    }
                    if (m2VarD != null && m2VarD.b() > -1) {
                        arrayDeque.add(new io.sentry.profilemeasurements.b(Long.valueOf(m2VarD.a().g() + jElapsedRealtimeNanos), Long.valueOf(m2VarD.b()), m2VarD.a()));
                    }
                    if (m2VarD != null && m2VarD.c() > -1) {
                        arrayDeque2.add(new io.sentry.profilemeasurements.b(Long.valueOf(m2VarD.a().g() + jElapsedRealtimeNanos), Long.valueOf(m2VarD.c()), m2VarD.a()));
                    }
                }
            }
            if (!arrayDeque3.isEmpty()) {
                this.f27174k.put("cpu_usage", new io.sentry.profilemeasurements.a("percent", arrayDeque3));
            }
            if (!arrayDeque.isEmpty()) {
                this.f27174k.put("memory_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque));
            }
            if (arrayDeque2.isEmpty()) {
                return;
            }
            this.f27174k.put("memory_native_footprint", new io.sentry.profilemeasurements.a("byte", arrayDeque2));
        }
    }

    public void f() {
        io.sentry.k1 k1VarA = this.f27178o.a();
        try {
            Future<?> future = this.f27167d;
            if (future != null) {
                future.cancel(true);
                this.f27167d = null;
            }
            if (this.f27177n) {
                g(true, null);
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

    @SuppressLint({"NewApi"})
    @Nullable
    public b g(boolean z10, @Nullable List<r3> list) {
        io.sentry.k1 k1VarA = this.f27178o.a();
        try {
            if (!this.f27177n) {
                this.f27176m.c(SentryLevel.WARNING, "Profiler not running", new Object[0]);
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
            }
            try {
                Debug.stopMethodTracing();
            } finally {
                try {
                } finally {
                }
            }
            this.f27170g.n(this.f27169f);
            long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            if (this.f27168e == null) {
                this.f27176m.c(SentryLevel.ERROR, "Trace file does not exists", new Object[0]);
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
            }
            if (!this.f27172i.isEmpty()) {
                this.f27174k.put("slow_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.f27172i));
            }
            if (!this.f27173j.isEmpty()) {
                this.f27174k.put("frozen_frame_renders", new io.sentry.profilemeasurements.a("nanosecond", this.f27173j));
            }
            if (!this.f27171h.isEmpty()) {
                this.f27174k.put("screen_frame_rates", new io.sentry.profilemeasurements.a("hz", this.f27171h));
            }
            i(list);
            Future<?> future = this.f27167d;
            if (future != null) {
                future.cancel(true);
                this.f27167d = null;
            }
            b bVar = new b(jElapsedRealtimeNanos, elapsedCpuTime, z10, this.f27168e, this.f27174k);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return bVar;
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

    @SuppressLint({"NewApi"})
    @Nullable
    public c j() {
        io.sentry.k1 k1VarA = this.f27178o.a();
        try {
            int i10 = this.f27166c;
            if (i10 == 0) {
                this.f27176m.c(SentryLevel.WARNING, "Disabling profiling because intervaUs is set to %d", Integer.valueOf(i10));
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
            }
            if (this.f27177n) {
                this.f27176m.c(SentryLevel.WARNING, "Profiling has already started...", new Object[0]);
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
            }
            this.f27168e = new File(this.f27165b, c8.a() + ".trace");
            this.f27174k.clear();
            this.f27171h.clear();
            this.f27172i.clear();
            this.f27173j.clear();
            this.f27169f = this.f27170g.m(new a());
            try {
                io.sentry.j1 j1Var = this.f27175l;
                if (j1Var != null) {
                    this.f27167d = j1Var.b(new Runnable() { // from class: io.sentry.android.core.e0
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f27147a.h();
                        }
                    }, 30000L);
                }
            } catch (RejectedExecutionException e10) {
                this.f27176m.b(SentryLevel.ERROR, "Failed to call the executor. Profiling will not be automatically finished. Did you call Sentry.close()?", e10);
            }
            this.f27164a = SystemClock.elapsedRealtimeNanos();
            Date dateD = io.sentry.n.d();
            long elapsedCpuTime = Process.getElapsedCpuTime();
            try {
                Debug.startMethodTracingSampling(this.f27168e.getPath(), 3000000, this.f27166c);
                this.f27177n = true;
                c cVar = new c(this.f27164a, elapsedCpuTime, dateD);
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return cVar;
            } catch (Throwable th) {
                g(false, null);
                this.f27176m.b(SentryLevel.ERROR, "Unable to start a profile: ", th);
                this.f27177n = false;
                if (k1VarA != null) {
                    k1VarA.close();
                }
                return null;
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
