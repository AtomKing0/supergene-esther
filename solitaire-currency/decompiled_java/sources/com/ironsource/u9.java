package com.ironsource;

import com.ironsource.d0;
import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public class u9 extends d0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u9(@NotNull s1 adUnitData, @NotNull nu waterfallInstances) {
        super(adUnitData, waterfallInstances);
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
    }

    @Override // com.ironsource.d0
    public void a(@NotNull x instance, @NotNull d0.b loadSelection) {
        kotlin.jvm.internal.t.i(instance, "instance");
        kotlin.jvm.internal.t.i(loadSelection, "loadSelection");
        IronLog.INTERNAL.verbose(instance.c().name() + " - Instance " + instance.o() + " is ready to load");
        loadSelection.a().add(instance);
    }
}
