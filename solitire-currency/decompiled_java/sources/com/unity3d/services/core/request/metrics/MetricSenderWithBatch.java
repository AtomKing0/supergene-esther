package com.unity3d.services.core.request.metrics;

import android.text.TextUtils;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.properties.InitializationStatusReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: MetricSenderWithBatch.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MetricSenderWithBatch extends MetricSenderBase {

    @NotNull
    private SDKMetricsSender _original;

    @NotNull
    private final LinkedBlockingQueue<Metric> _queue;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSenderWithBatch(@NotNull SDKMetricsSender _original, @NotNull InitializationStatusReader initializationStatusReader) {
        super(initializationStatusReader);
        t.i(_original, "_original");
        t.i(initializationStatusReader, "initializationStatusReader");
        this._original = _original;
        this._queue = new LinkedBlockingQueue<>();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    @Nullable
    public String getMetricEndPoint() {
        return this._original.getMetricEndPoint();
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendEvent(@NotNull String event, @Nullable String str, @NotNull Map<String, String> tags) {
        t.i(event, "event");
        t.i(tags, "tags");
        if (!(event.length() == 0)) {
            sendMetrics(u.e(new Metric(event, str, tags)));
            return;
        }
        DeviceLog.debug("Metric event not sent due to being empty: " + event);
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public void sendMetric(@NotNull Metric metric) {
        t.i(metric, "metric");
        sendMetrics(u.e(metric));
    }

    @Override // com.unity3d.services.core.request.metrics.SDKMetricsSender
    public synchronized void sendMetrics(@NotNull List<Metric> metrics) {
        t.i(metrics, "metrics");
        this._queue.addAll(metrics);
        if (!TextUtils.isEmpty(this._original.getMetricEndPoint()) && this._queue.size() > 0) {
            ArrayList arrayList = new ArrayList();
            this._queue.drainTo(arrayList);
            this._original.sendMetrics(arrayList);
        }
    }

    public final void sendQueueIfNeeded() {
        sendMetrics(v.l());
    }

    public final void updateOriginal(@NotNull SDKMetricsSender metrics) {
        t.i(metrics, "metrics");
        this._original = metrics;
    }
}
