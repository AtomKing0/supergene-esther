package com.ironsource;

import com.ironsource.d0;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.su;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ku implements c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final p2 f12919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final s1 f12920b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final qu f12921c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final lu f12922d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private d0 f12923e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private su f12924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final List<x> f12925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private x f12926h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f12927i;

    public static final class a implements mu {
        a() {
        }

        @Override // com.ironsource.mu
        public void a(int i10, @NotNull String errorReason) {
            kotlin.jvm.internal.t.i(errorReason, "errorReason");
            if (ku.this.f12927i) {
                return;
            }
            ku.this.f12921c.a(i10, errorReason);
        }

        @Override // com.ironsource.mu
        public void a(@NotNull nu waterfallInstances) {
            kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
            if (ku.this.f12927i) {
                return;
            }
            ku.this.a(waterfallInstances);
        }
    }

    public ku(@NotNull p2 adTools, @NotNull s1 adUnitData, @NotNull qu listener) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(listener, "listener");
        this.f12919a = adTools;
        this.f12920b = adUnitData;
        this.f12921c = listener;
        this.f12922d = lu.f13085d.a(adTools, adUnitData);
        this.f12925g = new ArrayList();
    }

    private final boolean c() {
        return this.f12926h != null;
    }

    private final void d() {
        d0 d0Var = this.f12923e;
        su suVar = null;
        if (d0Var == null) {
            kotlin.jvm.internal.t.A("adInstanceLoadStrategy");
            d0Var = null;
        }
        d0.b bVarD = d0Var.d();
        if (bVarD.e()) {
            this.f12921c.a(509, "Mediation No fill");
            return;
        }
        if (!bVarD.f()) {
            Iterator<x> it = bVarD.a().iterator();
            while (it.hasNext()) {
                it.next().a(this);
            }
        } else {
            su suVar2 = this.f12924f;
            if (suVar2 == null) {
                kotlin.jvm.internal.t.A("waterfallReporter");
            } else {
                suVar = suVar2;
            }
            suVar.a();
        }
    }

    public final void b(@NotNull x instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        su suVar = this.f12924f;
        if (suVar == null) {
            kotlin.jvm.internal.t.A("waterfallReporter");
            suVar = null;
        }
        suVar.a(instance, this.f12920b.m(), this.f12920b.p());
    }

    public final void a() {
        this.f12927i = true;
        x xVar = this.f12926h;
        if (xVar != null) {
            xVar.b();
        }
    }

    public final boolean b() {
        Iterator<x> it = this.f12925g.iterator();
        while (it.hasNext()) {
            if (it.next().x()) {
                return true;
            }
        }
        return false;
    }

    public final void a(@NotNull a0 adInstanceFactory) {
        kotlin.jvm.internal.t.i(adInstanceFactory, "adInstanceFactory");
        this.f12922d.a(adInstanceFactory, new a());
    }

    public final void a(@NotNull f0 adInstancePresenter) {
        kotlin.jvm.internal.t.i(adInstancePresenter, "adInstancePresenter");
        d0 d0Var = this.f12923e;
        su suVar = null;
        if (d0Var == null) {
            kotlin.jvm.internal.t.A("adInstanceLoadStrategy");
            d0Var = null;
        }
        d0.c cVarC = d0Var.c();
        x xVarC = cVarC.c();
        if (xVarC != null) {
            this.f12926h = xVarC;
            su suVar2 = this.f12924f;
            if (suVar2 == null) {
                kotlin.jvm.internal.t.A("waterfallReporter");
            } else {
                suVar = suVar2;
            }
            suVar.a(cVarC.c(), cVarC.d());
            this.f12925g.clear();
            cVarC.c().a(adInstancePresenter);
        }
    }

    @Override // com.ironsource.c0
    public void a(@NotNull IronSourceError error, @NotNull x instance) {
        kotlin.jvm.internal.t.i(error, "error");
        kotlin.jvm.internal.t.i(instance, "instance");
        if (this.f12927i) {
            return;
        }
        d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(nu nuVar) {
        this.f12923e = d0.f11729c.a(this.f12920b, nuVar);
        su.a aVar = su.f15334c;
        p2 p2Var = this.f12919a;
        s1 s1Var = this.f12920b;
        on onVarA = this.f12922d.a();
        d0 d0Var = this.f12923e;
        if (d0Var == null) {
            kotlin.jvm.internal.t.A("adInstanceLoadStrategy");
            d0Var = null;
        }
        this.f12924f = aVar.a(p2Var, s1Var, onVarA, nuVar, d0Var);
        d();
    }

    @Override // com.ironsource.c0
    public void a(@NotNull x instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        if (this.f12927i || c()) {
            return;
        }
        su suVar = this.f12924f;
        d0 d0Var = null;
        su suVar2 = null;
        if (suVar == null) {
            kotlin.jvm.internal.t.A("waterfallReporter");
            suVar = null;
        }
        suVar.a(instance);
        this.f12925g.add(instance);
        if (this.f12925g.size() == 1) {
            su suVar3 = this.f12924f;
            if (suVar3 == null) {
                kotlin.jvm.internal.t.A("waterfallReporter");
            } else {
                suVar2 = suVar3;
            }
            suVar2.b(instance);
            this.f12921c.b(instance);
            return;
        }
        d0 d0Var2 = this.f12923e;
        if (d0Var2 == null) {
            kotlin.jvm.internal.t.A("adInstanceLoadStrategy");
        } else {
            d0Var = d0Var2;
        }
        if (d0Var.a(instance)) {
            this.f12921c.a(instance);
        }
    }
}
