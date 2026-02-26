package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class xe implements g4 {
    @Override // com.ironsource.g4
    public void a(@NotNull ij observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        IronLog.INTERNAL.verbose("Adding lifecycle event observer");
        com.ironsource.lifecycle.b.d().a(observer);
    }

    @Override // com.ironsource.g4
    public void b(@NotNull ij observer) {
        kotlin.jvm.internal.t.i(observer, "observer");
        IronLog.INTERNAL.verbose("Removing lifecycle event observer");
        com.ironsource.lifecycle.b.d().b(observer);
    }
}
