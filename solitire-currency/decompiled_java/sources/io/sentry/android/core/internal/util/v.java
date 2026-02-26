package io.sentry.android.core.internal.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.FrameMetrics;
import android.view.Window;
import androidx.annotation.RequiresApi;
import io.sentry.SentryLevel;
import io.sentry.android.core.e1;
import io.sentry.android.core.w0;
import io.sentry.c8;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SentryFrameMetricsCollector.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class v implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final long f27338n = TimeUnit.SECONDS.toNanos(1);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final long f27339o = TimeUnit.MILLISECONDS.toNanos(700);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final w0 f27340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Set<Window> f27341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final io.sentry.w0 f27342c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private Handler f27343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private WeakReference<Window> f27344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Map<String, b> f27345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f27346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c f27347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private Window.OnFrameMetricsAvailableListener f27348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private Choreographer f27349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    private Field f27350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f27351l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f27352m;

    /* JADX INFO: compiled from: SentryFrameMetricsCollector.java */
    class a implements c {
        a() {
        }

        @Override // io.sentry.android.core.internal.util.v.c
        public /* synthetic */ void a(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, Handler handler) {
            w.a(this, window, onFrameMetricsAvailableListener, handler);
        }

        @Override // io.sentry.android.core.internal.util.v.c
        public /* synthetic */ void b(Window window, Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener) {
            w.b(this, window, onFrameMetricsAvailableListener);
        }
    }

    /* JADX INFO: compiled from: SentryFrameMetricsCollector.java */
    @ApiStatus.Internal
    public interface b {
        void e(long j10, long j11, long j12, long j13, boolean z10, boolean z11, float f10);
    }

    /* JADX INFO: compiled from: SentryFrameMetricsCollector.java */
    @ApiStatus.Internal
    public interface c {
        @RequiresApi(api = 24)
        void a(@NotNull Window window, @Nullable Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener, @Nullable Handler handler);

        @RequiresApi(api = 24)
        void b(@NotNull Window window, @Nullable Window.OnFrameMetricsAvailableListener onFrameMetricsAvailableListener);
    }

    @SuppressLint({"NewApi"})
    public v(@NotNull Context context, @NotNull io.sentry.w0 w0Var, @NotNull w0 w0Var2) {
        this(context, w0Var, w0Var2, new a());
    }

    @RequiresApi(api = 24)
    private long d(@NotNull FrameMetrics frameMetrics) {
        return frameMetrics.getMetric(0) + frameMetrics.getMetric(1) + frameMetrics.getMetric(2) + frameMetrics.getMetric(3) + frameMetrics.getMetric(4) + frameMetrics.getMetric(5);
    }

    @SuppressLint({"NewApi"})
    private long e(@NotNull FrameMetrics frameMetrics) {
        return this.f27340a.d() >= 26 ? frameMetrics.getMetric(10) : f();
    }

    public static boolean g(long j10) {
        return j10 > f27339o;
    }

    public static boolean h(long j10, long j11) {
        return j10 > j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void i(io.sentry.w0 w0Var, Thread thread, Throwable th) {
        w0Var.b(SentryLevel.ERROR, "Error during frames measurements.", th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j(io.sentry.w0 w0Var) {
        try {
            this.f27349j = Choreographer.getInstance();
        } catch (Throwable th) {
            w0Var.b(SentryLevel.ERROR, "Error retrieving Choreographer instance. Slow and frozen frames will not be reported.", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(w0 w0Var, Window window, FrameMetrics frameMetrics, int i10) {
        long jNanoTime = System.nanoTime();
        float refreshRate = w0Var.d() >= 30 ? window.getContext().getDisplay().getRefreshRate() : window.getWindowManager().getDefaultDisplay().getRefreshRate();
        long j10 = f27338n;
        long jD = d(frameMetrics);
        long jMax = Math.max(0L, jD - ((long) (j10 / refreshRate)));
        long jE = e(frameMetrics);
        if (jE < 0) {
            jE = jNanoTime - jD;
        }
        long jMax2 = Math.max(jE, this.f27352m);
        if (jMax2 == this.f27351l) {
            return;
        }
        this.f27351l = jMax2;
        this.f27352m = jMax2 + jD;
        boolean zH = h(jD, (long) (j10 / (refreshRate - 1.0f)));
        boolean z10 = zH && g(jD);
        Iterator<b> it = this.f27345f.values().iterator();
        while (it.hasNext()) {
            it.next().e(jMax2, this.f27352m, jD, jMax, zH, z10, refreshRate);
            jD = jD;
        }
    }

    private void l(@NotNull Window window) {
        WeakReference<Window> weakReference = this.f27344e;
        if (weakReference == null || weakReference.get() != window) {
            this.f27344e = new WeakReference<>(window);
            p();
        }
    }

    @SuppressLint({"NewApi"})
    private void o(@NotNull Window window) {
        if (this.f27341b.contains(window)) {
            if (this.f27340a.d() >= 24) {
                try {
                    this.f27347h.b(window, this.f27348i);
                } catch (Exception e10) {
                    this.f27342c.b(SentryLevel.ERROR, "Failed to remove frameMetricsAvailableListener", e10);
                }
            }
            this.f27341b.remove(window);
        }
    }

    @SuppressLint({"NewApi"})
    private void p() {
        WeakReference<Window> weakReference = this.f27344e;
        Window window = weakReference != null ? weakReference.get() : null;
        if (window == null || !this.f27346g || this.f27341b.contains(window) || this.f27345f.isEmpty() || this.f27340a.d() < 24 || this.f27343d == null) {
            return;
        }
        this.f27341b.add(window);
        this.f27347h.a(window, this.f27348i, this.f27343d);
    }

    public long f() {
        Field field;
        Choreographer choreographer = this.f27349j;
        if (choreographer == null || (field = this.f27350k) == null) {
            return -1L;
        }
        try {
            Long l10 = (Long) field.get(choreographer);
            if (l10 != null) {
                return l10.longValue();
            }
            return -1L;
        } catch (IllegalAccessException unused) {
            return -1L;
        }
    }

    @Nullable
    public String m(@NotNull b bVar) {
        if (!this.f27346g) {
            return null;
        }
        String strA = c8.a();
        this.f27345f.put(strA, bVar);
        p();
        return strA;
    }

    public void n(@Nullable String str) {
        if (this.f27346g) {
            if (str != null) {
                this.f27345f.remove(str);
            }
            WeakReference<Window> weakReference = this.f27344e;
            Window window = weakReference != null ? weakReference.get() : null;
            if (window == null || !this.f27345f.isEmpty()) {
                return;
            }
            o(window);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NotNull Activity activity) {
        l(activity.getWindow());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NotNull Activity activity) {
        o(activity.getWindow());
        WeakReference<Window> weakReference = this.f27344e;
        if (weakReference == null || weakReference.get() != activity.getWindow()) {
            return;
        }
        this.f27344e = null;
    }

    @SuppressLint({"NewApi", "PrivateApi"})
    public v(@NotNull Context context, @NotNull final io.sentry.w0 w0Var, @NotNull final w0 w0Var2, @NotNull c cVar) {
        this.f27341b = new CopyOnWriteArraySet();
        this.f27345f = new ConcurrentHashMap();
        this.f27346g = false;
        this.f27351l = 0L;
        this.f27352m = 0L;
        Context context2 = (Context) io.sentry.util.w.c(e1.h(context), "The context is required");
        this.f27342c = (io.sentry.w0) io.sentry.util.w.c(w0Var, "Logger is required");
        this.f27340a = (w0) io.sentry.util.w.c(w0Var2, "BuildInfoProvider is required");
        this.f27347h = (c) io.sentry.util.w.c(cVar, "WindowFrameMetricsManager is required");
        if ((context2 instanceof Application) && w0Var2.d() >= 24) {
            this.f27346g = true;
            HandlerThread handlerThread = new HandlerThread("io.sentry.android.core.internal.util.SentryFrameMetricsCollector");
            handlerThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.sentry.android.core.internal.util.s
                @Override // java.lang.Thread.UncaughtExceptionHandler
                public final void uncaughtException(Thread thread, Throwable th) {
                    v.i(w0Var, thread, th);
                }
            });
            handlerThread.start();
            this.f27343d = new Handler(handlerThread.getLooper());
            ((Application) context2).registerActivityLifecycleCallbacks(this);
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.internal.util.t
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27334a.j(w0Var);
                }
            });
            try {
                Field declaredField = Choreographer.class.getDeclaredField("mLastFrameTimeNanos");
                this.f27350k = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e10) {
                w0Var.b(SentryLevel.ERROR, "Unable to get the frame timestamp from the choreographer: ", e10);
            }
            this.f27348i = new Window.OnFrameMetricsAvailableListener() { // from class: io.sentry.android.core.internal.util.u
                @Override // android.view.Window.OnFrameMetricsAvailableListener
                public final void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i10) {
                    this.f27336a.k(w0Var2, window, frameMetrics, i10);
                }
            };
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NotNull Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NotNull Activity activity, @Nullable Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(@NotNull Activity activity, @NotNull Bundle bundle) {
    }
}
