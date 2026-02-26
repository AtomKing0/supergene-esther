package com.ironsource;

import com.ironsource.f1;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.x1;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s1 f12943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final p2 f12944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private WeakReference<f2> f12945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final ku f12946d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final WeakReference<d2> f12947e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private ta f12948f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final lb f12949g;

    protected class a implements b0 {
        public a() {
        }

        @Override // com.ironsource.b0
        public void a(@NotNull x instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            l1.this.f12949g.a().a(l1.this.i());
            d2 d2Var = (d2) l1.this.f12947e.get();
            if (d2Var != null) {
                d2Var.j(new p1(l1.this, instance.d()));
            }
        }

        @Override // com.ironsource.b0
        public void b(@NotNull x instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            IronLog.INTERNAL.verbose(l1.this.a(instance.o()));
            l1.this.j().b(instance);
            l1.this.f12949g.a().g(l1.this.i());
            l1.this.g().n().b(l1.this.f().b().a());
            d2 d2Var = (d2) l1.this.f12947e.get();
            if (d2Var != null) {
                d2Var.m(new p1(l1.this, instance.d()));
            }
        }
    }

    public static final class b implements qu {
        b() {
        }

        @Override // com.ironsource.qu
        public void a(int i10, @NotNull String errorReason) {
            kotlin.jvm.internal.t.i(errorReason, "errorReason");
            l1.this.a(i10, errorReason);
        }

        @Override // com.ironsource.qu
        public void b(@NotNull x instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            l1.this.f12949g.e().a(ta.a(l1.this.f12948f), false);
            WeakReference weakReference = l1.this.f12945c;
            if (weakReference == null) {
                kotlin.jvm.internal.t.A("loadListener");
                weakReference = null;
            }
            f2 f2Var = (f2) weakReference.get();
            if (f2Var != null) {
                f2Var.l(new p1(l1.this, instance.d()));
            }
        }

        @Override // com.ironsource.qu
        public void a(@NotNull x instance) {
            kotlin.jvm.internal.t.i(instance, "instance");
            l1.this.g().e().a().e(l1.this.i());
            WeakReference weakReference = l1.this.f12945c;
            if (weakReference == null) {
                kotlin.jvm.internal.t.A("loadListener");
                weakReference = null;
            }
            f2 f2Var = (f2) weakReference.get();
            if (f2Var != null) {
                f2Var.i(new p1(l1.this, instance.d()));
            }
        }
    }

    public l1(@NotNull k1 adTools, @NotNull s1 adUnitData, @NotNull d2 listener) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f12943a = adUnitData;
        p2 p2Var = new p2(adTools, adUnitData, x1.b.MEDIATION);
        this.f12944b = p2Var;
        this.f12946d = new ku(p2Var, adUnitData, c());
        this.f12947e = new WeakReference<>(listener);
        this.f12949g = p2Var.e();
        IronLog.INTERNAL.verbose("adFormat = " + adUnitData.b().a() + ", adUnitId = " + adUnitData.b().b());
    }

    private final b c() {
        return new b();
    }

    @NotNull
    protected abstract a0 a();

    @NotNull
    public n1 b() {
        return new n1(this.f12943a.b());
    }

    @NotNull
    public f1 e() {
        return this.f12946d.b() ? new f1.b(false, 1, null) : new f1.a(false, null, 3, null);
    }

    @NotNull
    protected final s1 f() {
        return this.f12943a;
    }

    @NotNull
    protected final p2 g() {
        return this.f12944b;
    }

    @Nullable
    protected final Placement h() {
        return this.f12943a.b().e();
    }

    @NotNull
    protected final String i() {
        return this.f12943a.m();
    }

    @NotNull
    protected final ku j() {
        return this.f12946d;
    }

    @NotNull
    protected final String a(@Nullable String str) {
        return k1.a(this.f12944b, str, (String) null, 2, (Object) null);
    }

    public final void d() {
        IronLog.INTERNAL.verbose(k1.a(this.f12944b, (String) null, (String) null, 3, (Object) null));
        this.f12946d.a();
    }

    protected final void a(int i10, @NotNull String errorReason) {
        kotlin.jvm.internal.t.i(errorReason, "errorReason");
        IronLog.INTERNAL.verbose(a("errorCode = " + i10 + ", errorReason = " + errorReason));
        this.f12949g.e().a(ta.a(this.f12948f), i10, errorReason);
        WeakReference<f2> weakReference = this.f12945c;
        if (weakReference == null) {
            kotlin.jvm.internal.t.A("loadListener");
            weakReference = null;
        }
        f2 f2Var = weakReference.get();
        if (f2Var != null) {
            f2Var.a(new p1(this, null, 2, null), new IronSourceError(i10, errorReason));
        }
    }

    public final void a(@NotNull f0 adInstancePresenter) {
        kotlin.jvm.internal.t.i(adInstancePresenter, "adInstancePresenter");
        this.f12946d.a(adInstancePresenter);
    }

    public final void a(@NotNull f2 loadListener) {
        kotlin.jvm.internal.t.i(loadListener, "loadListener");
        IronLog.INTERNAL.verbose(k1.a(this.f12944b, (String) null, (String) null, 3, (Object) null));
        this.f12944b.a(b());
        this.f12945c = new WeakReference<>(loadListener);
        this.f12949g.a(this.f12943a.v());
        this.f12948f = new ta();
        this.f12946d.a(a());
    }
}
