package com.moloco.sdk.internal.error;

import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.services.config.a f17627a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final com.moloco.sdk.internal.error.api.a f17628b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f17629c;

    public c(@NotNull com.moloco.sdk.internal.services.config.a configService, @NotNull com.moloco.sdk.internal.error.api.a errorReportingApi) {
        t.i(configService, "configService");
        t.i(errorReportingApi, "errorReportingApi");
        this.f17627a = configService;
        this.f17628b = errorReportingApi;
        this.f17629c = "ErrorReportingServiceImpl";
    }

    @Override // com.moloco.sdk.internal.error.b
    public void a(@NotNull String error, @NotNull a errorMetadata) {
        t.i(error, "error");
        t.i(errorMetadata, "errorMetadata");
        if (this.f17627a.a("ReportSDKError")) {
            String strB = this.f17627a.b("ReportSDKError");
            if (strB == null) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f17629c, "Error reporting is enabled but with invalid url", null, false, 12, null);
                return;
            } else {
                this.f17628b.b(error, strB, errorMetadata);
                return;
            }
        }
        MolocoLogger.warn$default(MolocoLogger.INSTANCE, this.f17629c, "Error reporting is disabled. Tried to report error: " + error, null, false, 12, null);
    }
}
