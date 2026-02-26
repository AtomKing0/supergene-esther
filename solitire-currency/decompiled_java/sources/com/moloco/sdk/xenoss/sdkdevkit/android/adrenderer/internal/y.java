package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class y {
    @NotNull
    public static final u a(@NotNull com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.media.f mediaCacheRepository, @NotNull com.moloco.sdk.internal.error.b errorReportingService) {
        kotlin.jvm.internal.t.i(mediaCacheRepository, "mediaCacheRepository");
        kotlin.jvm.internal.t.i(errorReportingService, "errorReportingService");
        return new v(mediaCacheRepository, errorReportingService);
    }

    public static final void c(String str) {
        MolocoLogger.debug$default(MolocoLogger.INSTANCE, "DECLoaderImpl", str, false, 4, null);
    }
}
