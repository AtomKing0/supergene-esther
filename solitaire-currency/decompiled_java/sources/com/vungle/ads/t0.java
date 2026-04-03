package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Metrics.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class t0 {

    @Nullable
    private String meta;

    @NotNull
    private Sdk$SDKMetric.b metricType;

    public t0(@NotNull Sdk$SDKMetric.b metricType) {
        kotlin.jvm.internal.t.i(metricType, "metricType");
        this.metricType = metricType;
    }

    @Nullable
    public final String getMeta() {
        return this.meta;
    }

    @NotNull
    public final Sdk$SDKMetric.b getMetricType() {
        return this.metricType;
    }

    public abstract long getValue();

    public final void setMeta(@Nullable String str) {
        this.meta = str;
    }

    public final void setMetricType(@NotNull Sdk$SDKMetric.b bVar) {
        kotlin.jvm.internal.t.i(bVar, "<set-?>");
        this.metricType = bVar;
    }
}
