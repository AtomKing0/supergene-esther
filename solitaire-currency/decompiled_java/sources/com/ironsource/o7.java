package com.ironsource;

import com.ironsource.d0;
import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class o7 extends d0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o7(@NotNull s1 adUnitData, @NotNull nu waterfallInstances) {
        super(adUnitData, waterfallInstances);
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
    }

    @Override // com.ironsource.d0
    public void a(@NotNull x instance, @NotNull d0.b loadSelection) {
        String str;
        kotlin.jvm.internal.t.i(instance, "instance");
        kotlin.jvm.internal.t.i(loadSelection, "loadSelection");
        if (!instance.s()) {
            IronLog.INTERNAL.verbose(instance.c().name() + " - Instance " + instance.n() + " (non-bidder) is ready to load");
            loadSelection.a().add(instance);
            return;
        }
        loadSelection.a(true);
        if (loadSelection.e()) {
            str = "Advanced Loading: Starting to load bidder " + instance.n() + ". No other instances will be loaded at the same time.";
            loadSelection.a().add(instance);
        } else {
            str = "Advanced Loading: Won't start loading bidder " + instance.n() + " as a non bidder is being loaded";
        }
        IronLog.INTERNAL.verbose(instance.c().name() + " - " + str);
    }

    @Override // com.ironsource.d0
    public boolean a(@NotNull d0.b loadSelection) {
        kotlin.jvm.internal.t.i(loadSelection, "loadSelection");
        return super.a(loadSelection) || loadSelection.d();
    }
}
