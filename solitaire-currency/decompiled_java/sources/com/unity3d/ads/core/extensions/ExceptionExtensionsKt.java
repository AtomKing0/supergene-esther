package com.unity3d.ads.core.extensions;

import com.unity3d.services.SDKErrorHandler;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import p9.r;

/* JADX INFO: compiled from: ExceptionExtensions.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class ExceptionExtensionsKt {
    @NotNull
    public static final String retrieveUnityCrashValue(@NotNull Throwable th) {
        StackTraceElement stackTraceElement;
        boolean zP;
        String className;
        t.i(th, "<this>");
        StackTraceElement[] stackTrace = th.getStackTrace();
        t.h(stackTrace, "this.stackTrace");
        int length = stackTrace.length;
        int i10 = 0;
        while (true) {
            stackTraceElement = null;
            if (i10 >= length) {
                break;
            }
            StackTraceElement stackTraceElement2 = stackTrace[i10];
            if (stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null) {
                zP = false;
            } else {
                t.h(className, "className");
                zP = r.P(className, SDKErrorHandler.UNITY_PACKAGE, false, 2, null);
            }
            if (zP) {
                stackTraceElement = stackTraceElement2;
                break;
            }
            i10++;
        }
        if (stackTraceElement == null) {
            return "unknown";
        }
        String fileName = stackTraceElement.getFileName();
        if (fileName == null) {
            fileName = "unknown";
        } else {
            t.h(fileName, "it.fileName ?: SDKErrorHandler.UNKNOWN_FILE");
        }
        String str = fileName + '_' + stackTraceElement.getLineNumber();
        return str != null ? str : "unknown";
    }
}
