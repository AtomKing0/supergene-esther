package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class kc implements ij {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final er f12869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f12870b;

    public kc(@NotNull sd applicationLifecycleService, @NotNull er task) {
        kotlin.jvm.internal.t.i(applicationLifecycleService, "applicationLifecycleService");
        kotlin.jvm.internal.t.i(task, "task");
        this.f12869a = task;
        applicationLifecycleService.a(this);
        f();
    }

    private final long e() {
        return System.currentTimeMillis() - this.f12870b;
    }

    private final void f() {
        this.f12870b = System.currentTimeMillis();
    }

    @Override // com.ironsource.ij
    public void b() {
        this.f12869a.a(Long.valueOf(e()));
        this.f12869a.run();
    }

    @Override // com.ironsource.ij
    public void c() {
        f();
    }

    @Override // com.ironsource.ij
    public void a() {
    }

    @Override // com.ironsource.ij
    public void d() {
    }
}
