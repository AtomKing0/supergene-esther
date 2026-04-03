package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class u5 implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final du f15560a;

    public u5(@NotNull du viewBinder) {
        kotlin.jvm.internal.t.i(viewBinder, "viewBinder");
        this.f15560a = viewBinder;
    }

    @Override // com.ironsource.f0
    public /* synthetic */ void a(oc ocVar) {
        dw.a(this, ocVar);
    }

    @Override // com.ironsource.f0
    public /* synthetic */ void a(pl plVar) {
        dw.b(this, plVar);
    }

    @Override // com.ironsource.f0
    public void a(@NotNull q5 bannerAdInstance) {
        kotlin.jvm.internal.t.i(bannerAdInstance, "bannerAdInstance");
        bannerAdInstance.a(this.f15560a);
    }
}
