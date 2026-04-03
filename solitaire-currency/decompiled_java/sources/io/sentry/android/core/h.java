package io.sentry.android.core;

import android.app.Activity;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import io.sentry.SentryLevel;
import io.sentry.protocol.MeasurementValue;
import io.sentry.protocol.SentryId;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.VisibleForTesting;

/* JADX INFO: compiled from: ActivityFramesTracker.java */
/* JADX INFO: loaded from: classes5.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private FrameMetricsAggregator f27195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final SentryAndroidOptions f27196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final Map<SentryId, Map<String, MeasurementValue>> f27197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Map<Activity, b> f27198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final u1 f27199e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    protected io.sentry.util.a f27200f;

    /* JADX INFO: compiled from: ActivityFramesTracker.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27201a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27202b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27203c;

        private b(int i10, int i11, int i12) {
            this.f27201a = i10;
            this.f27202b = i11;
            this.f27203c = i12;
        }
    }

    public h(@NotNull io.sentry.util.s sVar, @NotNull SentryAndroidOptions sentryAndroidOptions, @NotNull u1 u1Var) {
        this.f27195a = null;
        this.f27197c = new ConcurrentHashMap();
        this.f27198d = new WeakHashMap();
        this.f27200f = new io.sentry.util.a();
        if (sVar.a("androidx.core.app.FrameMetricsAggregator", sentryAndroidOptions.getLogger())) {
            this.f27195a = new FrameMetricsAggregator();
        }
        this.f27196b = sentryAndroidOptions;
        this.f27199e = u1Var;
    }

    @Nullable
    private b f() {
        FrameMetricsAggregator frameMetricsAggregator;
        int i10;
        int i11;
        SparseIntArray sparseIntArray;
        if (!h() || (frameMetricsAggregator = this.f27195a) == null) {
            return null;
        }
        SparseIntArray[] metrics = frameMetricsAggregator.getMetrics();
        int i12 = 0;
        if (metrics == null || metrics.length <= 0 || (sparseIntArray = metrics[0]) == null) {
            i10 = 0;
            i11 = 0;
        } else {
            int i13 = 0;
            i10 = 0;
            i11 = 0;
            while (i12 < sparseIntArray.size()) {
                int iKeyAt = sparseIntArray.keyAt(i12);
                int iValueAt = sparseIntArray.valueAt(i12);
                i13 += iValueAt;
                if (iKeyAt > 700) {
                    i11 += iValueAt;
                } else if (iKeyAt > 16) {
                    i10 += iValueAt;
                }
                i12++;
            }
            i12 = i13;
        }
        return new b(i12, i10, i11);
    }

    @Nullable
    private b g(@NotNull Activity activity) {
        b bVarF;
        b bVarRemove = this.f27198d.remove(activity);
        if (bVarRemove == null || (bVarF = f()) == null) {
            return null;
        }
        return new b(bVarF.f27201a - bVarRemove.f27201a, bVarF.f27202b - bVarRemove.f27202b, bVarF.f27203c - bVarRemove.f27203c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(Activity activity) {
        this.f27195a.add(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(Runnable runnable, String str) {
        try {
            runnable.run();
        } catch (Throwable unused) {
            if (str != null) {
                this.f27196b.getLogger().c(SentryLevel.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Activity activity) {
        this.f27195a.remove(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        this.f27195a.stop();
    }

    private void m(final Runnable runnable, final String str) {
        try {
            if (io.sentry.android.core.internal.util.d.e().a()) {
                runnable.run();
            } else {
                this.f27199e.b(new Runnable() { // from class: io.sentry.android.core.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27161a.j(runnable, str);
                    }
                });
            }
        } catch (Throwable unused) {
            if (str != null) {
                this.f27196b.getLogger().c(SentryLevel.WARNING, "Failed to execute " + str, new Object[0]);
            }
        }
    }

    private void o(@NotNull Activity activity) {
        b bVarF = f();
        if (bVarF != null) {
            this.f27198d.put(activity, bVarF);
        }
    }

    public void e(@NotNull final Activity activity) {
        io.sentry.k1 k1VarA = this.f27200f.a();
        try {
            if (!h()) {
                if (k1VarA != null) {
                    k1VarA.close();
                }
            } else {
                m(new Runnable() { // from class: io.sentry.android.core.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27144a.i(activity);
                    }
                }, "FrameMetricsAggregator.add");
                o(activity);
                if (k1VarA != null) {
                    k1VarA.close();
                }
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

    @VisibleForTesting
    public boolean h() {
        return (this.f27195a == null || !this.f27196b.isEnableFramesTracking() || this.f27196b.isEnablePerformanceV2()) ? false : true;
    }

    public void n(@NotNull final Activity activity, @NotNull SentryId sentryId) {
        io.sentry.k1 k1VarA = this.f27200f.a();
        try {
            if (!h()) {
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
            }
            m(new Runnable() { // from class: io.sentry.android.core.g
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27192a.k(activity);
                }
            }, null);
            b bVarG = g(activity);
            if (bVarG != null && (bVarG.f27201a != 0 || bVarG.f27202b != 0 || bVarG.f27203c != 0)) {
                MeasurementValue measurementValue = new MeasurementValue(Integer.valueOf(bVarG.f27201a), "none");
                MeasurementValue measurementValue2 = new MeasurementValue(Integer.valueOf(bVarG.f27202b), "none");
                MeasurementValue measurementValue3 = new MeasurementValue(Integer.valueOf(bVarG.f27203c), "none");
                HashMap map = new HashMap();
                map.put(MeasurementValue.KEY_FRAMES_TOTAL, measurementValue);
                map.put(MeasurementValue.KEY_FRAMES_SLOW, measurementValue2);
                map.put(MeasurementValue.KEY_FRAMES_FROZEN, measurementValue3);
                this.f27197c.put(sentryId, map);
                if (k1VarA != null) {
                    k1VarA.close();
                    return;
                }
                return;
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

    public void p() {
        io.sentry.k1 k1VarA = this.f27200f.a();
        try {
            if (h()) {
                m(new Runnable() { // from class: io.sentry.android.core.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f27146a.l();
                    }
                }, "FrameMetricsAggregator.stop");
                this.f27195a.reset();
            }
            this.f27197c.clear();
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

    @Nullable
    public Map<String, MeasurementValue> q(@NotNull SentryId sentryId) {
        io.sentry.k1 k1VarA = this.f27200f.a();
        try {
            if (!h()) {
                if (k1VarA == null) {
                    return null;
                }
                k1VarA.close();
                return null;
            }
            Map<String, MeasurementValue> map = this.f27197c.get(sentryId);
            this.f27197c.remove(sentryId);
            if (k1VarA != null) {
                k1VarA.close();
            }
            return map;
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

    public h(@NotNull io.sentry.util.s sVar, @NotNull SentryAndroidOptions sentryAndroidOptions) {
        this(sVar, sentryAndroidOptions, new u1());
    }
}
