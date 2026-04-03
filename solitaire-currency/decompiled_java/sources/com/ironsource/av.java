package com.ironsource;

import com.ironsource.mediationsdk.logger.IronSourceError;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class av {
    public static void a(au auVar, boolean z10, @NotNull h9.a lazyError) {
        kotlin.jvm.internal.t.i(lazyError, "lazyError");
        if (!z10) {
            throw new fq((IronSourceError) lazyError.invoke());
        }
    }
}
