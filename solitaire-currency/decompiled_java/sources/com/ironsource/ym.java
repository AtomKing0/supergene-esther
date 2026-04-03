package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ym extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ym(@NotNull Exception e10) {
        super("Missing Headers", e10);
        kotlin.jvm.internal.t.i(e10, "e");
    }
}
