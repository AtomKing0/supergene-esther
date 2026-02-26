package com.moloco.sdk.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.internal.StabilityInferred;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class MolocoLogger {

    @NotNull
    private static final String MOLOCO_TAG = "Moloco";

    @NotNull
    public static final MolocoLogger INSTANCE = new MolocoLogger();

    @NotNull
    private static c configuration = new d(new b());

    @NotNull
    private static final LinkedHashSet<LoggerListener> listeners = new LinkedHashSet<>();
    public static final int $stable = 8;

    public interface LoggerListener {
        void onLog(@NotNull String str, @NotNull String str2);
    }

    public interface a {
        boolean a();
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final C0300b f17521b = new C0300b(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f17522a;

        public static final class a extends kotlin.jvm.internal.v implements h9.a<k0> {
            public a() {
                super(0);
            }

            public final void b() {
                b bVar = b.this;
                bVar.b(bVar.d());
            }

            @Override // h9.a
            public /* bridge */ /* synthetic */ k0 invoke() {
                b();
                return k0.f35197a;
            }
        }

        /* JADX INFO: renamed from: com.moloco.sdk.internal.MolocoLogger$b$b, reason: collision with other inner class name */
        public static final class C0300b {
            public /* synthetic */ C0300b(kotlin.jvm.internal.k kVar) {
                this();
            }

            public C0300b() {
            }
        }

        public b() {
            y8.a.b(false, false, null, null, 0, new a(), 31, null);
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.a
        public boolean a() {
            return this.f17522a;
        }

        public void b(boolean z10) {
            this.f17522a = z10;
        }

        public final boolean d() {
            return Boolean.parseBoolean(a("debug.moloco.internal_logging"));
        }

        public final String a(String str) {
            try {
                Object objInvoke = Class.forName("android.os.SystemProperties").getMethod("get", String.class).invoke(null, str);
                kotlin.jvm.internal.t.g(objInvoke, "null cannot be cast to non-null type kotlin.String");
                String str2 = (String) objInvoke;
                try {
                    if (TextUtils.isEmpty(str2)) {
                        return null;
                    }
                } catch (Exception unused) {
                }
                return str2;
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    public interface c {
        void a(boolean z10);

        boolean a();

        boolean b();

        boolean c();
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final a f17524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f17525b;

        public d(@NotNull a adb) {
            kotlin.jvm.internal.t.i(adb, "adb");
            this.f17524a = adb;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public boolean a() {
            return this.f17524a.a();
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public boolean b() {
            return this.f17525b;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public boolean c() {
            return false;
        }

        @Override // com.moloco.sdk.internal.MolocoLogger.c
        public void a(boolean z10) {
            this.f17525b = z10;
        }
    }

    private MolocoLogger() {
    }

    public static final void addListener(@NotNull LoggerListener loggerListener) {
        kotlin.jvm.internal.t.i(loggerListener, "loggerListener");
        listeners.add(loggerListener);
    }

    public static /* synthetic */ void debug$default(MolocoLogger molocoLogger, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        molocoLogger.debug(str, str2, z10);
    }

    public static /* synthetic */ void debugBuildLog$default(MolocoLogger molocoLogger, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        molocoLogger.debugBuildLog(str, str2, z10);
    }

    public static /* synthetic */ void error$default(MolocoLogger molocoLogger, String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        molocoLogger.error(str, str2, th, z10);
    }

    private final StackTraceElement findMostRelevantStackTrace(StackTraceElement[] stackTraceElementArr) {
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (!kotlin.jvm.internal.t.d(stackTraceElement.getClassName(), INSTANCE.getClass().getCanonicalName())) {
                return stackTraceElement;
            }
        }
        return (StackTraceElement) kotlin.collections.p.N(stackTraceElementArr);
    }

    private final void fireListeners(String str, String str2) {
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((LoggerListener) it.next()).onLog(INSTANCE.prefixWithMolocoName(str), str2);
        }
    }

    public static final boolean getLogEnabled() {
        c cVar = configuration;
        return cVar.c() || cVar.a() || cVar.b();
    }

    public static /* synthetic */ void info$default(MolocoLogger molocoLogger, String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        molocoLogger.info(str, str2, th, z10);
    }

    private final String prefixWithMethodName(String str) {
        try {
            return '[' + getCallingMethodName() + "] " + str;
        } catch (Exception unused) {
            return str;
        }
    }

    private final String prefixWithMolocoName(String str) {
        if (p9.q.K(str, MOLOCO_TAG, false, 2, null)) {
            return str;
        }
        return MOLOCO_TAG + str;
    }

    public static final void removeListener(@NotNull LoggerListener loggerListener) {
        kotlin.jvm.internal.t.i(loggerListener, "loggerListener");
        listeners.remove(loggerListener);
    }

    public static final void setLogEnabled(boolean z10) {
        configuration.a(z10);
    }

    public static /* synthetic */ void tlog$default(MolocoLogger molocoLogger, String str, Throwable th, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            th = null;
        }
        molocoLogger.tlog(str, th);
    }

    public static /* synthetic */ void warn$default(MolocoLogger molocoLogger, String str, String str2, Throwable th, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = MOLOCO_TAG;
        }
        if ((i10 & 4) != 0) {
            th = null;
        }
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        molocoLogger.warn(str, str2, th, z10);
    }

    public final void adapter(@NotNull String tag, boolean z10, @NotNull String msg) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(msg, "msg");
        if (getLogEnabled() || z10) {
            Log.i(prefixWithMolocoName(tag), prefixWithMethodName(msg));
        }
    }

    public final void debug(@NotNull String tag, @NotNull String msg, boolean z10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(msg, "msg");
        if (getLogEnabled() || z10) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.d(strPrefixWithMolocoName, strPrefixWithMethodName);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    public final void debugBuildLog(@NotNull String tag, @NotNull String msg, boolean z10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(msg, "msg");
    }

    public final void error(@NotNull String tag, @NotNull String msg, @Nullable Throwable th, boolean z10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(msg, "msg");
        if (getLogEnabled() || z10) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.e(strPrefixWithMolocoName, strPrefixWithMethodName, th);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    @NotNull
    public final String getCallingMethodName() throws ClassNotFoundException {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        kotlin.jvm.internal.t.h(stackTrace, "Throwable().stackTrace");
        StackTraceElement stackTraceElementFindMostRelevantStackTrace = findMostRelevantStackTrace(stackTrace);
        String className = stackTraceElementFindMostRelevantStackTrace.getClassName();
        stackTraceElementFindMostRelevantStackTrace.getMethodName();
        Class<?> cls = Class.forName(className);
        cls.isAnonymousClass();
        cls.getDeclaredMethods();
        String methodName = stackTraceElementFindMostRelevantStackTrace.getMethodName();
        if (kotlin.jvm.internal.t.d(methodName, "invokeSuspend")) {
            String className2 = stackTraceElementFindMostRelevantStackTrace.getClassName();
            kotlin.jvm.internal.t.h(className2, "stackTraceElement.className");
            methodName = p9.r.R0(p9.r.w0(className2, "$1"), "$", null, 2, null);
        }
        kotlin.jvm.internal.t.h(methodName, "stackTraceElement.method…t\n            }\n        }");
        return methodName;
    }

    public final void info(@NotNull String tag, @NotNull String msg, @Nullable Throwable th, boolean z10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(msg, "msg");
        if (getLogEnabled() || z10) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.i(strPrefixWithMolocoName, strPrefixWithMethodName, th);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    @VisibleForTesting(otherwise = 5)
    public final void setConfiguration$moloco_sdk_release(@NotNull c configuration2) {
        kotlin.jvm.internal.t.i(configuration2, "configuration");
        configuration = configuration2;
    }

    public final void tlog(@NotNull String msg, @Nullable Throwable th) {
        kotlin.jvm.internal.t.i(msg, "msg");
        Log.i("==tlog==", prefixWithMethodName(msg), th);
    }

    public final void warn(@NotNull String tag, @NotNull String msg, @Nullable Throwable th, boolean z10) {
        kotlin.jvm.internal.t.i(tag, "tag");
        kotlin.jvm.internal.t.i(msg, "msg");
        if (getLogEnabled() || z10) {
            String strPrefixWithMolocoName = prefixWithMolocoName(tag);
            String strPrefixWithMethodName = prefixWithMethodName(msg);
            Log.w(strPrefixWithMolocoName, strPrefixWithMethodName, th);
            fireListeners(strPrefixWithMolocoName, strPrefixWithMethodName);
        }
    }

    public static /* synthetic */ void getLogEnabled$annotations() {
    }
}
