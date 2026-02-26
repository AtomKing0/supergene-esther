package com.braze.support;

import android.util.Log;
import bo.app.ad0;
import bo.app.ae;
import bo.app.be;
import bo.app.ce;
import bo.app.de;
import bo.app.ee;
import bo.app.fe;
import bo.app.ge;
import com.ironsource.v8;
import h9.q;
import h9.r;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import kotlin.jvm.internal.t;
import v8.k0;
import v8.l;
import v8.n;

/* JADX INFO: loaded from: classes2.dex */
public final class BrazeLogger {
    private static boolean hasLogLevelBeenSetForAppRun;
    private static boolean isSystemPropLogLevelSet;
    private static q<? super Priority, ? super String, ? super Throwable, k0> onLoggedCallback;
    private static r<? super String, ? super Priority, ? super String, ? super Throwable, k0> sdkDebuggerCallback;
    public static final BrazeLogger INSTANCE = new BrazeLogger();
    private static int logLevel = 4;

    public enum Priority {
        D(3),
        I(4),
        E(6),
        V(2),
        W(5);

        private final int logLevel;

        Priority(int i10) {
            this.logLevel = i10;
        }

        public final int getLogLevel() {
            return this.logLevel;
        }
    }

    private BrazeLogger() {
    }

    public static /* synthetic */ void brazelog$default(BrazeLogger brazeLogger, Object obj, Priority priority, Throwable th, boolean z10, h9.a aVar, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            priority = Priority.D;
        }
        Priority priority2 = priority;
        if ((i10 & 2) != 0) {
            th = null;
        }
        Throwable th2 = th;
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        brazeLogger.brazelog(obj, priority2, th2, z10, (h9.a<String>) aVar);
    }

    public static final void checkForSystemLogLevelProperty(boolean z10) {
        String line;
        t.i("log.tag.APPBOY", v8.h.W);
        try {
            InputStream inputStream = Runtime.getRuntime().exec(new String[]{"/system/bin/getprop", "log.tag.APPBOY"}).getInputStream();
            t.h(inputStream, "getRuntime()\n           …             .inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, p9.d.f32952b);
            line = (inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192)).readLine();
            t.h(line, "{\n            Runtime.ge…er().readLine()\n        }");
        } catch (Exception e10) {
            brazelog$default(INSTANCE, (Object) k.f8124a, Priority.E, (Throwable) e10, false, (h9.a) ad0.f2370a, 4, (Object) null);
            line = "";
        }
        if (p9.q.x("verbose", p9.r.b1(line).toString(), true)) {
            setLogLevel(2);
            isSystemPropLogLevelSet = true;
            BrazeLogger brazeLogger = INSTANCE;
            brazelog$default(brazeLogger, (Object) brazeLogger, Priority.I, (Throwable) null, false, (h9.a) new ae(line), 6, (Object) null);
        }
    }

    public static /* synthetic */ void checkForSystemLogLevelProperty$default(boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        checkForSystemLogLevelProperty(z10);
    }

    public static final void d(String tag, String msg) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        d$default(tag, msg, null, 4, null);
    }

    public static /* synthetic */ void d$default(String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        d(str, str2, th);
    }

    public static final void e(String tag, String msg, Throwable tr) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        t.i(tr, "tr");
        brazelog$default(INSTANCE, tag, Priority.D, tr, false, (h9.a) new ce(msg), 8, (Object) null);
    }

    public static final String getBrazeLogTag(Class<?> classForTag) {
        t.i(classForTag, "classForTag");
        String fullClassName = classForTag.getName();
        int length = fullClassName.length();
        if (length <= 65) {
            t.h(fullClassName, "{\n            // No need…  fullClassName\n        }");
        } else {
            t.h(fullClassName, "fullClassName");
            fullClassName = fullClassName.substring(length - 65);
            t.h(fullClassName, "this as java.lang.String).substring(startIndex)");
        }
        return "Braze v32.1.0 ." + fullClassName;
    }

    public static final void i(String tag, String msg) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        i$default(tag, msg, null, 4, null);
    }

    public static /* synthetic */ void i$default(String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        i(str, str2, th);
    }

    public static final void setInitialLogLevelFromConfiguration(int i10) {
        if (hasLogLevelBeenSetForAppRun) {
            return;
        }
        setLogLevel(i10);
    }

    public static final void setLogLevel(int i10) {
        if (isSystemPropLogLevelSet) {
            BrazeLogger brazeLogger = INSTANCE;
            brazelog$default(brazeLogger, (Object) brazeLogger, Priority.W, (Throwable) null, false, (h9.a) new ee(i10), 6, (Object) null);
        } else {
            hasLogLevelBeenSetForAppRun = true;
            logLevel = i10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toStringSafe(h9.a<? extends Object> aVar) {
        try {
            return String.valueOf(aVar.invoke());
        } catch (Exception unused) {
            return "";
        }
    }

    public static final void v(String tag, String msg) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        v$default(tag, msg, null, 4, null);
    }

    public static /* synthetic */ void v$default(String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        v(str, str2, th);
    }

    public static final void w(String tag, String msg) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        w$default(tag, msg, null, 4, null);
    }

    public static /* synthetic */ void w$default(String str, String str2, Throwable th, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            th = null;
        }
        w(str, str2, th);
    }

    public final String brazeLogTag(Object obj) {
        t.i(obj, "<this>");
        String fullClassName = obj.getClass().getName();
        t.h(fullClassName, "fullClassName");
        String strQ0 = p9.r.Q0(p9.r.U0(fullClassName, '$', null, 2, null), '.', null, 2, null);
        return strQ0.length() == 0 ? getBrazeLogTag(fullClassName) : getBrazeLogTag(strQ0);
    }

    public final void brazelog(Object obj, Priority priority, Throwable th, boolean z10, h9.a<String> message) {
        t.i(obj, "<this>");
        t.i(priority, "priority");
        t.i(message, "message");
        if (logLevel <= priority.getLogLevel() || sdkDebuggerCallback != null) {
            brazelog(brazeLogTag(obj), priority, th, z10, message);
        }
    }

    public final void setSdkDebuggerCallback$android_sdk_base_release(r<? super String, ? super Priority, ? super String, ? super Throwable, k0> rVar) {
        sdkDebuggerCallback = rVar;
    }

    public static final void d(String tag, String msg, Throwable th) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        brazelog$default(INSTANCE, tag, Priority.D, th, false, (h9.a) new be(msg), 8, (Object) null);
    }

    public static final void i(String tag, String msg, Throwable th) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        brazelog$default(INSTANCE, tag, Priority.I, th, false, (h9.a) new de(msg), 8, (Object) null);
    }

    public static final void v(String tag, String msg, Throwable th) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        brazelog$default(INSTANCE, tag, Priority.V, th, false, (h9.a) new fe(msg), 8, (Object) null);
    }

    public static final void w(String tag, String msg, Throwable th) {
        t.i(tag, "tag");
        t.i(msg, "msg");
        brazelog$default(INSTANCE, tag, Priority.W, th, false, (h9.a) new ge(msg), 8, (Object) null);
    }

    public static /* synthetic */ void brazelog$default(BrazeLogger brazeLogger, String str, Priority priority, Throwable th, boolean z10, h9.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            priority = Priority.D;
        }
        Priority priority2 = priority;
        if ((i10 & 4) != 0) {
            th = null;
        }
        Throwable th2 = th;
        if ((i10 & 8) != 0) {
            z10 = false;
        }
        brazeLogger.brazelog(str, priority2, th2, z10, (h9.a<String>) aVar);
    }

    public final void brazelog(String tag, Priority priority, Throwable th, boolean z10, h9.a<String> message) {
        r<? super String, ? super Priority, ? super String, ? super Throwable, k0> rVar;
        t.i(tag, "tag");
        t.i(priority, "priority");
        t.i(message, "message");
        l lVarA = n.a(new b(message));
        q<? super Priority, ? super String, ? super Throwable, k0> qVar = onLoggedCallback;
        if (qVar != null) {
            qVar.invoke(priority, lVarA.getValue(), th);
        }
        if (!z10 && (rVar = sdkDebuggerCallback) != null) {
            rVar.invoke(tag, priority, lVarA.getValue(), th);
        }
        if (logLevel <= priority.getLogLevel()) {
            int i10 = a.f8112a[priority.ordinal()];
            if (i10 == 1) {
                if (th == null) {
                    Log.d(tag, (String) lVarA.getValue());
                    return;
                } else {
                    Log.d(tag, (String) lVarA.getValue(), th);
                    return;
                }
            }
            if (i10 == 2) {
                if (th == null) {
                    Log.i(tag, (String) lVarA.getValue());
                    return;
                } else {
                    Log.i(tag, (String) lVarA.getValue(), th);
                    return;
                }
            }
            if (i10 == 3) {
                if (th == null) {
                    Log.w(tag, (String) lVarA.getValue());
                    return;
                } else {
                    Log.e(tag, (String) lVarA.getValue(), th);
                    return;
                }
            }
            if (i10 == 4) {
                if (th == null) {
                    Log.w(tag, (String) lVarA.getValue());
                    return;
                } else {
                    Log.w(tag, (String) lVarA.getValue(), th);
                    return;
                }
            }
            if (i10 != 5) {
                return;
            }
            if (th == null) {
                Log.v(tag, (String) lVarA.getValue());
            } else {
                Log.v(tag, (String) lVarA.getValue(), th);
            }
        }
    }

    public final String getBrazeLogTag(String str) {
        t.i(str, "<this>");
        return "Braze v32.1.0 ." + str;
    }
}
