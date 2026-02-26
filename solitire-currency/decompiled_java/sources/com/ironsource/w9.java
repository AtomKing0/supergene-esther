package com.ironsource;

import com.ironsource.k7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class w9<Smash extends k7<?>> extends vu<Smash> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w9(int i10, boolean z10, @NotNull List<? extends Smash> waterfall) {
        super(i10, z10, waterfall);
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
    }

    @Override // com.ironsource.vu
    public void c(@NotNull Smash smash) {
        kotlin.jvm.internal.t.i(smash, "smash");
        IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.k() + " is ready to load");
        smash.a(true);
        c().add(smash);
    }
}
