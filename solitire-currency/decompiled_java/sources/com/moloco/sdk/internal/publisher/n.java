package com.moloco.sdk.internal.publisher;

import com.moloco.sdk.publisher.AdFormatType;
import com.moloco.sdk.publisher.AdLoad;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    @NotNull
    public static final g0 a(@Nullable AdLoad.Listener listener, @NotNull com.moloco.sdk.acm.f acmLoadTimerEvent, @NotNull AdFormatType adFormatType) {
        kotlin.jvm.internal.t.i(acmLoadTimerEvent, "acmLoadTimerEvent");
        kotlin.jvm.internal.t.i(adFormatType, "adFormatType");
        return new k(listener, com.moloco.sdk.internal.w.a(), acmLoadTimerEvent, adFormatType);
    }
}
