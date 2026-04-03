package com.ironsource;

import android.app.Activity;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class qc implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Activity f14467a;

    public qc(@NotNull Activity activity) {
        kotlin.jvm.internal.t.i(activity, "activity");
        this.f14467a = activity;
    }

    @Override // com.ironsource.f0
    public void a(@NotNull oc fullscreenAdInstance) {
        kotlin.jvm.internal.t.i(fullscreenAdInstance, "fullscreenAdInstance");
        fullscreenAdInstance.a(this.f14467a);
    }

    @Override // com.ironsource.f0
    public /* synthetic */ void a(pl plVar) {
        dw.b(this, plVar);
    }

    @Override // com.ironsource.f0
    public /* synthetic */ void a(q5 q5Var) {
        dw.c(this, q5Var);
    }
}
