package com.moloco.sdk.internal.services.config.handlers;

import com.moloco.sdk.i;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {
    @Override // com.moloco.sdk.internal.services.config.handlers.a
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.moloco.sdk.internal.configs.a a(@NotNull i sdkInitResponse) {
        t.i(sdkInitResponse, "sdkInitResponse");
        if (!sdkInitResponse.k()) {
            return com.moloco.sdk.internal.configs.b.a();
        }
        i.h hVarG = sdkInitResponse.g();
        String strD = hVarG.d();
        t.h(strD, "operationalMetricsConfig.url");
        return new com.moloco.sdk.internal.configs.a(strD, hVarG.c());
    }

    @Override // com.moloco.sdk.internal.services.config.handlers.a
    @NotNull
    public Class<com.moloco.sdk.internal.configs.a> a() {
        return com.moloco.sdk.internal.configs.a.class;
    }
}
