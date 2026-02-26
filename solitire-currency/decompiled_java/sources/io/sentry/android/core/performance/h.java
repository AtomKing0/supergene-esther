package io.sentry.android.core.performance;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.e1;
import io.sentry.android.core.f1;
import io.sentry.android.core.internal.util.l;
import io.sentry.android.core.w0;
import io.sentry.k1;
import io.sentry.q1;
import io.sentry.s0;
import io.sentry.s2;
import io.sentry.x8;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: AppStartMetrics.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class h extends io.sentry.android.core.performance.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @Nullable
    private static volatile h f27457p;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static long f27456o = SystemClock.uptimeMillis();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NotNull
    public static final io.sentry.util.a f27458q = new io.sentry.util.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private a f27459a = a.UNKNOWN;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private q1 f27466h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private s0 f27467i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private x8 f27468j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f27469k = false;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f27470l = true;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AtomicInteger f27471m = new AtomicInteger();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final AtomicBoolean f27472n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final i f27461c = new i();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final i f27462d = new i();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final i f27463e = new i();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final Map<ContentProvider, i> f27464f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<c> f27465g = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f27460b = e1.t();

    /* JADX INFO: compiled from: AppStartMetrics.java */
    public enum a {
        UNKNOWN,
        COLD,
        WARM
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public void v() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f27455a.s();
            }
        });
    }

    @NotNull
    public static h q() {
        if (f27457p == null) {
            k1 k1VarA = f27458q.a();
            try {
                if (f27457p == null) {
                    f27457p = new h();
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
        return f27457p;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s() {
        if (this.f27471m.get() == 0) {
            this.f27460b = false;
            q1 q1Var = this.f27466h;
            if (q1Var != null && q1Var.isRunning()) {
                this.f27466h.close();
                this.f27466h = null;
            }
            s0 s0Var = this.f27467i;
            if (s0Var == null || !s0Var.isRunning()) {
                return;
            }
            this.f27467i.b(true);
            this.f27467i = null;
        }
    }

    public void A(@Nullable q1 q1Var) {
        this.f27466h = q1Var;
    }

    public void B(@Nullable x8 x8Var) {
        this.f27468j = x8Var;
    }

    public boolean C() {
        return this.f27470l && this.f27460b;
    }

    public void e(@NotNull c cVar) {
        this.f27465g.add(cVar);
    }

    @NotNull
    public i g() {
        i iVar = new i();
        iVar.r("Process Initialization", this.f27461c.i(), this.f27461c.k(), f27456o);
        return iVar;
    }

    @NotNull
    public List<c> h() {
        ArrayList arrayList = new ArrayList(this.f27465g);
        Collections.sort(arrayList);
        return arrayList;
    }

    @Nullable
    public s0 i() {
        return this.f27467i;
    }

    @Nullable
    public q1 j() {
        return this.f27466h;
    }

    @Nullable
    public x8 k() {
        return this.f27468j;
    }

    @NotNull
    public i l() {
        return this.f27461c;
    }

    @NotNull
    public i m(@NotNull SentryAndroidOptions sentryAndroidOptions) {
        if (this.f27459a != a.UNKNOWN && this.f27460b) {
            if (sentryAndroidOptions.isEnablePerformanceV2()) {
                i iVarL = l();
                if (iVarL.n() && iVarL.d() <= TimeUnit.MINUTES.toMillis(1L)) {
                    return iVarL;
                }
            }
            i iVarR = r();
            if (iVarR.n() && iVarR.d() <= TimeUnit.MINUTES.toMillis(1L)) {
                return iVarR;
            }
        }
        return new i();
    }

    @NotNull
    public a n() {
        return this.f27459a;
    }

    @NotNull
    public i o() {
        return this.f27463e;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle bundle) {
        f1.c().d(activity);
        if (this.f27471m.incrementAndGet() == 1 && !this.f27472n.get()) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            long jK = jUptimeMillis - this.f27461c.k();
            if (!this.f27460b || jK > TimeUnit.MINUTES.toMillis(1L)) {
                this.f27459a = a.WARM;
                this.f27470l = true;
                this.f27461c.p();
                this.f27461c.s();
                this.f27461c.q(jUptimeMillis);
                f27456o = jUptimeMillis;
                this.f27464f.clear();
                this.f27463e.p();
            } else {
                this.f27459a = bundle == null ? a.COLD : a.WARM;
            }
        }
        this.f27460b = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(@NonNull Activity activity) {
        f1.c().a(activity);
        if (this.f27471m.decrementAndGet() != 0 || activity.isChangingConfigurations()) {
            return;
        }
        this.f27460b = false;
        this.f27470l = true;
        this.f27472n.set(false);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(@NonNull Activity activity) {
        f1.c().a(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(@NonNull Activity activity) {
        f1.c().d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(@NonNull Activity activity) {
        f1.c().d(activity);
        if (this.f27472n.get()) {
            return;
        }
        if (activity.getWindow() != null) {
            l.f(activity, new Runnable() { // from class: io.sentry.android.core.performance.d
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27452a.t();
                }
            }, new w0(s2.e()));
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.e
                @Override // java.lang.Runnable
                public final void run() {
                    this.f27453a.u();
                }
            });
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(@NonNull Activity activity) {
        f1.c().a(activity);
    }

    @NotNull
    public List<i> p() {
        ArrayList arrayList = new ArrayList(this.f27464f.values());
        Collections.sort(arrayList);
        return arrayList;
    }

    @NotNull
    public i r() {
        return this.f27462d;
    }

    public void w() {
        this.f27470l = false;
        this.f27464f.clear();
        this.f27465g.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public synchronized void u() {
        if (!this.f27472n.getAndSet(true)) {
            h hVarQ = q();
            hVarQ.r().t();
            hVarQ.l().t();
        }
    }

    public void y(@NotNull Application application) {
        if (this.f27469k) {
            return;
        }
        boolean z10 = true;
        this.f27469k = true;
        if (!this.f27460b && !e1.t()) {
            z10 = false;
        }
        this.f27460b = z10;
        application.registerActivityLifecycleCallbacks(f27457p);
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: io.sentry.android.core.performance.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f27454a.v();
            }
        });
    }

    public void z(@Nullable s0 s0Var) {
        this.f27467i = s0Var;
    }
}
