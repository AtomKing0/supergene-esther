package com.moloco.sdk.internal.services;

import android.content.Context;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class o implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final Context f18806a;

    public o(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        this.f18806a = context;
    }

    @Override // com.moloco.sdk.internal.services.l
    @NotNull
    public j a() {
        com.moloco.sdk.common_adapter_internal.a aVarInvoke = com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.o.a(this.f18806a).invoke();
        float fE = aVarInvoke.e();
        return new j(aVarInvoke.f(), fE, aVarInvoke.c(), aVarInvoke.b(), aVarInvoke.d(), aVarInvoke.a(), this.f18806a.getResources().getDisplayMetrics().xdpi, this.f18806a.getResources().getDisplayMetrics().ydpi);
    }

    @Override // com.moloco.sdk.internal.services.l
    @NotNull
    public p b() {
        int i10 = this.f18806a.getResources().getConfiguration().orientation;
        return i10 != 1 ? i10 != 2 ? p.UNKNOWN : p.LANDSCAPE : p.PORTRAIT;
    }

    @Override // com.moloco.sdk.internal.services.l
    @NotNull
    public j invoke() {
        return a();
    }
}
