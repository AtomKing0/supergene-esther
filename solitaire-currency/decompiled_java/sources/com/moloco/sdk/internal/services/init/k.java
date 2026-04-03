package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.internal.services.init.h;
import com.moloco.sdk.internal.t;
import e8.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class k {
    public static final boolean a(int i10) {
        v.a aVar = v.f25372c;
        return i10 == aVar.U().e0() || i10 == aVar.K().e0() || i10 < 400 || i10 >= 500;
    }

    public static final boolean b(@NotNull t.a<com.moloco.sdk.i, h> aVar) {
        kotlin.jvm.internal.t.i(aVar, "<this>");
        if (aVar.a() instanceof h.b) {
            return a(((h.b) aVar.a()).a());
        }
        return true;
    }
}
