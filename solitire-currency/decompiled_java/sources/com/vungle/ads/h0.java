package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Metrics.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class h0 extends t0 {

    @Nullable
    private Long valueFirst;

    @Nullable
    private Long valueSecond;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h0(@NotNull Sdk$SDKMetric.b metricType) {
        super(metricType);
        kotlin.jvm.internal.t.i(metricType, "metricType");
    }

    @Nullable
    public final Long getValueFirst() {
        return this.valueFirst;
    }

    @Nullable
    public final Long getValueSecond() {
        return this.valueSecond;
    }

    public final void setValueFirst(@Nullable Long l10) {
        this.valueFirst = l10;
    }

    public final void setValueSecond(@Nullable Long l10) {
        this.valueSecond = l10;
    }
}
