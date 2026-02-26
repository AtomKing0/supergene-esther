package com.unity3d.services.core.request.metrics;

import com.unity3d.services.core.log.DeviceLog;
import java.util.List;
import kotlinx.coroutines.l0;
import org.jetbrains.annotations.NotNull;
import z8.a;
import z8.g;

/* JADX INFO: compiled from: CoroutineExceptionHandler.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1 extends a implements l0 {
    final /* synthetic */ List $metrics$inlined;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MetricSender$sendMetrics$$inlined$CoroutineExceptionHandler$1(l0.b bVar, List list) {
        super(bVar);
        this.$metrics$inlined = list;
    }

    @Override // kotlinx.coroutines.l0
    public void handleException(@NotNull g gVar, @NotNull Throwable th) {
        DeviceLog.debug("Metric " + this.$metrics$inlined + " failed to send with error: " + th);
    }
}
