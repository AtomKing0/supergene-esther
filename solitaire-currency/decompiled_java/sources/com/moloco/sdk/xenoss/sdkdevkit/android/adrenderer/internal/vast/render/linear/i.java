package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.linear;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model.t;
import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render.d;
import kotlinx.coroutines.b2;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.m0;
import v8.q;

/* JADX INFO: loaded from: classes4.dex */
public final class i {
    @NotNull
    public static final g d(@Nullable Boolean bool, int i10, @Nullable t tVar) {
        if (kotlin.jvm.internal.t.d(bool, Boolean.FALSE)) {
            tVar = null;
        } else if (kotlin.jvm.internal.t.d(bool, Boolean.TRUE)) {
            tVar = new t.b(((long) i10) * 1000);
        } else if (bool != null) {
            throw new q();
        }
        return new h(tVar);
    }

    public static final int f(n9.i iVar, int i10) {
        return m0.a(o.c((((double) (o.e(iVar.e() - iVar.b(), 0) * i10)) / 100.0d) / ((double) 1000), 0.0d));
    }

    public static final long g(long j10) {
        return j10 / 1000;
    }

    public static final d.a h(int i10) {
        return i10 == 0 ? d.a.C0463a.f21255a : new d.a.b(i10, null);
    }

    public static final boolean i(b2 b2Var) {
        return b2Var == null || b2Var.isCancelled() || b2Var.i();
    }
}
