package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class x9 extends su {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final on f16170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final nu f16171e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x9(@NotNull p2 adTools, @NotNull on outcomeReporter, @NotNull nu waterfallInstances) {
        super(adTools, outcomeReporter);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(outcomeReporter, "outcomeReporter");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        this.f16170d = outcomeReporter;
        this.f16171e = waterfallInstances;
    }

    @Override // com.ironsource.su
    public void a() {
    }

    @Override // com.ironsource.su
    public void b(@NotNull x instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
        this.f16170d.a(this.f16171e.b(), instance);
    }

    @Override // com.ironsource.su
    public void c(@NotNull x instanceToShow) {
        kotlin.jvm.internal.t.i(instanceToShow, "instanceToShow");
    }

    @Override // com.ironsource.su
    public void a(@NotNull x instance) {
        kotlin.jvm.internal.t.i(instance, "instance");
    }
}
