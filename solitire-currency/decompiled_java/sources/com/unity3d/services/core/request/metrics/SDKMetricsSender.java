package com.unity3d.services.core.request.metrics;

import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SDKMetricsSender.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface SDKMetricsSender {

    /* JADX INFO: compiled from: SDKMetricsSender.kt */
    public static final class DefaultImpls {
        public static void sendEvent(@NotNull SDKMetricsSender sDKMetricsSender, @NotNull String event) {
            t.i(event, "event");
            sendEvent$default(sDKMetricsSender, event, null, null, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void sendEvent$default(SDKMetricsSender sDKMetricsSender, String str, String str2, Map map, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
            }
            if ((i10 & 2) != 0) {
                str2 = null;
            }
            if ((i10 & 4) != 0) {
                map = r0.g();
            }
            sDKMetricsSender.sendEvent(str, str2, map);
        }
    }

    @Nullable
    String getMetricEndPoint();

    void sendEvent(@NotNull String str);

    void sendEvent(@NotNull String str, @Nullable String str2, @NotNull Map<String, String> map);

    void sendMetric(@NotNull Metric metric);

    void sendMetricWithInitState(@NotNull Metric metric);

    void sendMetrics(@NotNull List<Metric> list);
}
