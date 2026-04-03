package com.moloco.sdk.internal.ortb.model;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class f {
    @NotNull
    public static final String a(@NotNull c cVar) {
        kotlin.jvm.internal.t.i(cVar, "<this>");
        String strC = cVar.d().c();
        return strC == null ? "UNKNOWN_MTID" : strC;
    }
}
