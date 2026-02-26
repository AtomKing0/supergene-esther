package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Metrics.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class v1 extends t0 {

    @Nullable
    private Long value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v1(@NotNull Sdk$SDKMetric.b metricType) {
        super(metricType);
        kotlin.jvm.internal.t.i(metricType, "metricType");
    }

    public final void addValue(long j10) {
        Long l10 = this.value;
        this.value = Long.valueOf((l10 != null ? l10.longValue() : 0L) + j10);
    }

    @Nullable
    /* JADX INFO: renamed from: getValue, reason: collision with other method in class */
    public final Long m4132getValue() {
        return this.value;
    }

    public final void markTime() {
        this.value = Long.valueOf(System.currentTimeMillis());
    }

    public final void setValue(@Nullable Long l10) {
        this.value = l10;
    }

    @Override // com.vungle.ads.t0
    public long getValue() {
        Long l10 = this.value;
        if (l10 != null) {
            return l10.longValue();
        }
        return 0L;
    }
}
