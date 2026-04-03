package com.moloco.sdk.internal.error.crash.filters;

import androidx.compose.runtime.internal.StabilityInferred;
import com.moloco.sdk.BuildConfig;
import com.moloco.sdk.internal.MolocoLogger;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f17638a = "MolocoSDKExceptionFilter";

    @Override // com.moloco.sdk.internal.error.crash.filters.a
    public boolean a(@NotNull Throwable crash) {
        t.i(crash, "crash");
        StackTraceElement[] stackTrace = crash.getStackTrace();
        t.h(stackTrace, "crash.stackTrace");
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            t.h(className, "stackTraceElement.className");
            if (r.P(className, BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, null)) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f17638a, "SDK detected in stacktrace", null, false, 12, null);
                return true;
            }
        }
        Throwable cause = crash.getCause();
        if (cause == null) {
            return false;
        }
        StackTraceElement[] stackTrace2 = cause.getStackTrace();
        t.h(stackTrace2, "cause.stackTrace");
        for (StackTraceElement stackTraceElement2 : stackTrace2) {
            String className2 = stackTraceElement2.getClassName();
            t.h(className2, "stackTraceElement.className");
            if (r.P(className2, BuildConfig.LIBRARY_PACKAGE_NAME, false, 2, null)) {
                MolocoLogger.error$default(MolocoLogger.INSTANCE, this.f17638a, "SDK detected in stacktrace", null, false, 12, null);
                return true;
            }
        }
        return false;
    }
}
