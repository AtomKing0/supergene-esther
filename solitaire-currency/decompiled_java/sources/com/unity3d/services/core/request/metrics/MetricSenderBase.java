package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.properties.InitializationStatusReader;
import com.unity3d.services.core.properties.SdkProperties;
import com.unity3d.services.core.request.metrics.SDKMetricsSender;
import kotlin.collections.q0;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.y;

/* JADX INFO: compiled from: MetricSenderBase.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class MetricSenderBase implements SDKMetricsSender {

    @NotNull
    private final InitializationStatusReader _initStatusReader;

    public MetricSenderBase(@NotNull InitializationStatusReader _initStatusReader) {
        t.i(_initStatusReader, "_initStatusReader");
        this._initStatusReader = _initStatusReader;
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(@NotNull String str) {
        SDKMetricsSender.DefaultImpls.sendEvent(this, str);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetricWithInitState(@NotNull Metric metric) {
        t.i(metric, "metric");
        sendMetric(Metric.copy$default(metric, null, null, r0.n(metric.getTags(), q0.e(y.a("state", this._initStatusReader.getInitializationStateString(SdkProperties.getCurrentInitializationState())))), 3, null));
    }
}
