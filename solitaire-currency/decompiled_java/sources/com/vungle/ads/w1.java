package com.vungle.ads;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Metrics.kt */
/* JADX INFO: loaded from: classes4.dex */
public class w1 extends h0 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w1(@NotNull Sdk$SDKMetric.b metricType) {
        super(metricType);
        kotlin.jvm.internal.t.i(metricType, "metricType");
    }

    private final long getCurrentTime() {
        return System.currentTimeMillis();
    }

    public final long calculateIntervalDuration() {
        long currentTime = getCurrentTime();
        Long valueSecond = getValueSecond();
        long jLongValue = valueSecond != null ? valueSecond.longValue() : currentTime;
        Long valueFirst = getValueFirst();
        if (valueFirst != null) {
            currentTime = valueFirst.longValue();
        }
        return jLongValue - currentTime;
    }

    @Override // com.vungle.ads.t0
    public long getValue() {
        return calculateIntervalDuration();
    }

    public void markEnd() {
        setValueSecond(Long.valueOf(getCurrentTime()));
    }

    public void markStart() {
        setValueFirst(Long.valueOf(getCurrentTime()));
    }
}
