package io.sentry.android.core;

import io.sentry.android.core.internal.util.v;
import io.sentry.e3;
import io.sentry.g3;
import io.sentry.i7;
import io.sentry.n5;
import io.sentry.protocol.MeasurementValue;
import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SpanFrameMetricsCollector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class k2 implements io.sentry.z0, v.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f27375h = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final i7 f27376i = new i7(new Date(0), 0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f27377a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.android.core.internal.util.v f27379c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private volatile String f27380d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    protected final io.sentry.util.a f27378b = new io.sentry.util.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final SortedSet<io.sentry.n1> f27381e = new TreeSet(new Comparator() { // from class: io.sentry.android.core.j2
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return k2.j((io.sentry.n1) obj, (io.sentry.n1) obj2);
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final ConcurrentSkipListSet<a> f27382f = new ConcurrentSkipListSet<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f27383g = 16666666;

    /* JADX INFO: compiled from: SpanFrameMetricsCollector.java */
    private static class a implements Comparable<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f27384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f27385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f27386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f27387d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f27388e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final boolean f27389f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final long f27390g;

        a(long j10) {
            this(j10, j10, 0L, 0L, false, false, 0L);
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public int compareTo(@NotNull a aVar) {
            return Long.compare(this.f27385b, aVar.f27385b);
        }

        a(long j10, long j11, long j12, long j13, boolean z10, boolean z11, long j14) {
            this.f27384a = j10;
            this.f27385b = j11;
            this.f27386c = j12;
            this.f27387d = j13;
            this.f27388e = z10;
            this.f27389f = z11;
            this.f27390g = j14;
        }
    }

    public k2(@NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull io.sentry.android.core.internal.util.v vVar) {
        this.f27379c = vVar;
        this.f27377a = sentryAndroidOptions.isEnablePerformanceV2() && sentryAndroidOptions.isEnableFramesTracking();
    }

    private static int g(@NotNull i2 i2Var, long j10, long j11, long j12) {
        long jMax = Math.max(0L, j11 - j12);
        if (!io.sentry.android.core.internal.util.v.h(jMax, j10)) {
            return 0;
        }
        i2Var.a(jMax, Math.max(0L, jMax - j10), true, io.sentry.android.core.internal.util.v.g(jMax));
        return 1;
    }

    private void h(@NotNull io.sentry.n1 n1Var) {
        io.sentry.k1 k1VarA = this.f27378b.a();
        try {
            if (!this.f27381e.remove(n1Var)) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            n5 n5VarS = n1Var.s();
            if (n5VarS == null) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            long jK = k(n1Var.u());
            long jK2 = k(n5VarS);
            long j10 = jK2 - jK;
            long j11 = 0;
            if (j10 <= 0) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            i2 i2Var = new i2();
            long j12 = this.f27383g;
            if (!this.f27382f.isEmpty()) {
                for (a aVar : this.f27382f.tailSet(new a(jK))) {
                    if (aVar.f27384a > jK2) {
                        break;
                    }
                    if (aVar.f27384a >= jK && aVar.f27385b <= jK2) {
                        i2Var.a(aVar.f27386c, aVar.f27387d, aVar.f27388e, aVar.f27389f);
                    } else if ((jK > aVar.f27384a && jK < aVar.f27385b) || (jK2 > aVar.f27384a && jK2 < aVar.f27385b)) {
                        long jMin = Math.min(aVar.f27387d - Math.max(j11, Math.max(j11, jK - aVar.f27384a) - aVar.f27390g), j10);
                        long jMin2 = Math.min(jK2, aVar.f27385b) - Math.max(jK, aVar.f27384a);
                        i2Var.a(jMin2, jMin, io.sentry.android.core.internal.util.v.h(jMin2, aVar.f27390g), io.sentry.android.core.internal.util.v.g(jMin2));
                    }
                    j12 = aVar.f27390g;
                    j11 = 0;
                }
            }
            long j13 = j12;
            int iF = i2Var.f();
            long jF = this.f27379c.f();
            if (jF != -1) {
                iF = iF + g(i2Var, j13, jK2, jF) + i(i2Var, j13, j10);
            }
            double dE = (i2Var.e() + i2Var.c()) / 1.0E9d;
            n1Var.j("frames.total", Integer.valueOf(iF));
            n1Var.j("frames.slow", Integer.valueOf(i2Var.d()));
            n1Var.j("frames.frozen", Integer.valueOf(i2Var.b()));
            n1Var.j("frames.delay", Double.valueOf(dE));
            if (n1Var instanceof io.sentry.p1) {
                n1Var.f(MeasurementValue.KEY_FRAMES_TOTAL, Integer.valueOf(iF));
                n1Var.f(MeasurementValue.KEY_FRAMES_SLOW, Integer.valueOf(i2Var.d()));
                n1Var.f(MeasurementValue.KEY_FRAMES_FROZEN, Integer.valueOf(i2Var.b()));
                n1Var.f(MeasurementValue.KEY_FRAMES_DELAY, Double.valueOf(dE));
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
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

    private static int i(@NotNull i2 i2Var, long j10, long j11) {
        long jG = j11 - i2Var.g();
        if (jG > 0) {
            return (int) Math.ceil(jG / j10);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j(io.sentry.n1 n1Var, io.sentry.n1 n1Var2) {
        if (n1Var == n1Var2) {
            return 0;
        }
        int iCompareTo = n1Var.u().compareTo(n1Var2.u());
        return iCompareTo != 0 ? iCompareTo : n1Var.r().k().toString().compareTo(n1Var2.r().k().toString());
    }

    private static long k(@NotNull n5 n5Var) {
        if (n5Var instanceof i7) {
            return n5Var.c(f27376i);
        }
        return System.nanoTime() - (io.sentry.n.i(System.currentTimeMillis()) - n5Var.g());
    }

    @Override // io.sentry.z0
    public void a(@NotNull io.sentry.n1 n1Var) {
        if (!this.f27377a || (n1Var instanceof e3) || (n1Var instanceof g3)) {
            return;
        }
        io.sentry.k1 k1VarA = this.f27378b.a();
        try {
            if (!this.f27381e.contains(n1Var)) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            if (k1VarA != null) {
                k1VarA.close();
            }
            h(n1Var);
            k1VarA = this.f27378b.a();
            try {
                if (this.f27381e.isEmpty()) {
                    clear();
                } else {
                    this.f27382f.headSet(new a(k(this.f27381e.first().u()))).clear();
                }
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } finally {
            }
        } finally {
        }
    }

    @Override // io.sentry.z0
    public void b(@NotNull io.sentry.n1 n1Var) {
        if (!this.f27377a || (n1Var instanceof e3) || (n1Var instanceof g3)) {
            return;
        }
        io.sentry.k1 k1VarA = this.f27378b.a();
        try {
            this.f27381e.add(n1Var);
            if (this.f27380d == null) {
                this.f27380d = this.f27379c.m(this);
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

    @Override // io.sentry.z0
    public void clear() {
        io.sentry.k1 k1VarA = this.f27378b.a();
        try {
            if (this.f27380d != null) {
                this.f27379c.n(this.f27380d);
                this.f27380d = null;
            }
            this.f27382f.clear();
            this.f27381e.clear();
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

    @Override // io.sentry.android.core.internal.util.v.b
    public void e(long j10, long j11, long j12, long j13, boolean z10, boolean z11, float f10) {
        if (this.f27382f.size() > 3600) {
            return;
        }
        long j14 = (long) (f27375h / ((double) f10));
        this.f27383g = j14;
        if (z10 || z11) {
            this.f27382f.add(new a(j10, j11, j12, j13, z10, z11, j14));
        }
    }
}
