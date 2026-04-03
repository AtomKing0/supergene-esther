package io.sentry.android.core.performance;

import android.os.Looper;
import android.os.SystemClock;
import io.sentry.android.core.w;
import io.sentry.n1;
import io.sentry.n5;
import io.sentry.q8;
import io.sentry.u1;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ActivityLifecycleSpanHelper.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f27445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private n5 f27446b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private n5 f27447c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private n1 f27448d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private n1 f27449e = null;

    public b(@NotNull String str) {
        this.f27445a = str;
    }

    @NotNull
    private n1 d(@NotNull n1 n1Var, @NotNull String str, @NotNull n5 n5Var) {
        n1 n1VarM = n1Var.m("activity.load", str, n5Var, u1.SENTRY);
        f(n1VarM);
        return n1VarM;
    }

    private void f(@NotNull n1 n1Var) {
        n1Var.j("thread.id", Long.valueOf(Looper.getMainLooper().getThread().getId()));
        n1Var.j("thread.name", "main");
        Boolean bool = Boolean.TRUE;
        n1Var.j("ui.contributes_to_ttid", bool);
        n1Var.j("ui.contributes_to_ttfd", bool);
    }

    public void a() {
        n1 n1Var = this.f27448d;
        if (n1Var != null && !n1Var.isFinished()) {
            this.f27448d.k(q8.CANCELLED);
        }
        this.f27448d = null;
        n1 n1Var2 = this.f27449e;
        if (n1Var2 != null && !n1Var2.isFinished()) {
            this.f27449e.k(q8.CANCELLED);
        }
        this.f27449e = null;
    }

    public void b(@Nullable n1 n1Var) {
        if (this.f27446b == null || n1Var == null) {
            return;
        }
        n1 n1VarD = d(n1Var, this.f27445a + ".onCreate", this.f27446b);
        this.f27448d = n1VarD;
        n1VarD.finish();
    }

    public void c(@Nullable n1 n1Var) {
        if (this.f27447c == null || n1Var == null) {
            return;
        }
        n1 n1VarD = d(n1Var, this.f27445a + ".onStart", this.f27447c);
        this.f27449e = n1VarD;
        n1VarD.finish();
    }

    public void e() {
        n1 n1Var = this.f27448d;
        if (n1Var == null || this.f27449e == null) {
            return;
        }
        n5 n5VarS = n1Var.s();
        n5 n5VarS2 = this.f27449e.s();
        if (n5VarS == null || n5VarS2 == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        n5 n5VarA = w.a();
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long millis = timeUnit.toMillis(n5VarA.c(this.f27448d.u()));
        long millis2 = timeUnit.toMillis(n5VarA.c(n5VarS));
        long millis3 = timeUnit.toMillis(n5VarA.c(this.f27449e.u()));
        long millis4 = timeUnit.toMillis(n5VarA.c(n5VarS2));
        c cVar = new c();
        cVar.c().r(this.f27448d.getDescription(), timeUnit.toMillis(this.f27448d.u().g()), jUptimeMillis - millis, jUptimeMillis - millis2);
        cVar.d().r(this.f27449e.getDescription(), timeUnit.toMillis(this.f27449e.u().g()), jUptimeMillis - millis3, jUptimeMillis - millis4);
        h.q().e(cVar);
    }

    public void g(@NotNull n5 n5Var) {
        this.f27446b = n5Var;
    }

    public void h(@NotNull n5 n5Var) {
        this.f27447c = n5Var;
    }
}
