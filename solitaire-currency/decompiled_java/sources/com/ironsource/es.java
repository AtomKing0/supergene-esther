package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class es extends su {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final on f11991d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final nu f11992e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final d0 f11993f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public es(@NotNull p2 adTools, @NotNull on outcomeReporter, @NotNull nu waterfallInstances, @NotNull d0 adInstanceLoadStrategy) {
        super(adTools, outcomeReporter);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(outcomeReporter, "outcomeReporter");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        kotlin.jvm.internal.t.i(adInstanceLoadStrategy, "adInstanceLoadStrategy");
        this.f11991d = outcomeReporter;
        this.f11992e = waterfallInstances;
        this.f11993f = adInstanceLoadStrategy;
    }

    @Override // com.ironsource.su
    public void a() {
        x xVarA = this.f11993f.c().a();
        if (xVarA != null) {
            this.f11991d.a(this.f11992e.b(), xVarA);
        }
    }

    @Override // com.ironsource.su
    public void b(@NotNull x instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
    }

    @Override // com.ironsource.su
    public void c(@NotNull x instanceToShow) {
        kotlin.jvm.internal.t.i(instanceToShow, "instanceToShow");
        this.f11991d.a(this.f11992e.b(), instanceToShow);
    }

    @Override // com.ironsource.su
    public void a(@NotNull x instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        if (!this.f11993f.a(instance) && (!this.f11993f.a() || (instance = this.f11993f.c().a()) == null)) {
            return;
        }
        this.f11991d.a(this.f11992e.b(), instance);
    }
}
