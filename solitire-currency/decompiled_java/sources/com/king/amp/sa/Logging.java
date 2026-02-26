package com.king.amp.sa;

import android.util.Log;
import androidx.annotation.Keep;
import com.ironsource.v8;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes4.dex */
@Keep
public class Logging {
    public static final String TAG = "ABM";

    private Logging() {
    }

    public static String getCallerInfo() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i10 = 1; i10 < stackTrace.length; i10++) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            if (!stackTraceElement.getClassName().equals(Logging.class.getName()) && stackTraceElement.getClassName().indexOf("java.lang.Thread") != 0) {
                return stackTraceElement.getClassName() + ": " + stackTraceElement.getFileName() + "(" + stackTraceElement.getLineNumber() + ")[" + stackTraceElement.getMethodName() + v8.i.f15839e;
            }
        }
        return "";
    }

    private static native void logBreadcrumb(String str);

    public static void logBreadcrumb(String str, String str2) {
        try {
            logBreadcrumb(str + ": " + str2);
        } catch (UnsatisfiedLinkError unused) {
            Log.d(str, str2);
        }
    }

    private static native void logDebug(String str);

    public static void logDebug(String str, String str2) {
        try {
            logDebug(str + ": " + getCallerInfo() + ": " + str2);
        } catch (UnsatisfiedLinkError unused) {
            Log.d(str, str2);
        }
    }

    private static native void logError(String str);

    public static void logError(String str, String str2) {
        try {
            logError(str + ": " + str2);
        } catch (UnsatisfiedLinkError unused) {
            Log.e(str, str2);
        }
    }

    public static void logException(String str, Exception exc) {
        StringWriter stringWriter = new StringWriter();
        exc.printStackTrace(new PrintWriter(stringWriter));
        String str2 = str + " ErrorApi:" + exc.getMessage() + " StackTrace:" + stringWriter.toString();
        try {
            logWarning(str2);
        } catch (UnsatisfiedLinkError unused) {
            Log.w(TAG, str2);
        }
    }

    private static native void logInfo(String str);

    public static void logInfo(String str, String str2) {
        try {
            logInfo(str + ": " + str2);
        } catch (UnsatisfiedLinkError unused) {
            Log.i(str, str2);
        }
    }

    private static native void logWarning(String str);

    public static void logWarning(String str, String str2) {
        try {
            logWarning(str + ": " + str2);
        } catch (UnsatisfiedLinkError unused) {
            Log.w(str, str2);
        }
    }
}
