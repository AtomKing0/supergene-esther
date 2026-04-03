package com.moloco.sdk.internal.error.api;

import com.moloco.sdk.internal.MolocoLogger;
import com.moloco.sdk.internal.services.r;
import com.moloco.sdk.internal.utils.d;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final r f17624a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.a f17625b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f17626c;

    public b(@NotNull r timeProviderService, @NotNull com.moloco.sdk.xenoss.sdkdevkit.android.persistenttransport.a httpClient) {
        t.i(timeProviderService, "timeProviderService");
        t.i(httpClient, "httpClient");
        this.f17624a = timeProviderService;
        this.f17625b = httpClient;
        this.f17626c = "ErrorReportingApi";
    }

    @Override // com.moloco.sdk.internal.error.api.a
    public void a(@NotNull Throwable error) {
        t.i(error, "error");
        MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f17626c, "SDK Crashed", error, false, 8, null);
    }

    @Override // com.moloco.sdk.internal.error.api.a
    public void b(@NotNull String error, @NotNull String url, @NotNull com.moloco.sdk.internal.error.a errorMetadata) {
        t.i(error, "error");
        t.i(url, "url");
        t.i(errorMetadata, "errorMetadata");
        String strE = d.e(d.d(url, error, this.f17624a.invoke()), errorMetadata.a());
        MolocoLogger.info$default(MolocoLogger.INSTANCE, this.f17626c, "Reporting error: " + error + " to url: " + strE, null, false, 12, null);
        this.f17625b.a(strE);
    }
}
