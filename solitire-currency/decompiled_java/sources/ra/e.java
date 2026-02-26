package ra;

import android.util.Log;
import ga.z;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.r0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p9.r;

/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f33415a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final CopyOnWriteArraySet<Logger> f33416b = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Map<String, String> f33417c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r22 = z.class.getPackage();
        String name = r22 == null ? null : r22.getName();
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = z.class.getName();
        t.h(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = oa.e.class.getName();
        t.h(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = ka.e.class.getName();
        t.h(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f33417c = r0.u(linkedHashMap);
    }

    private e() {
    }

    private final void c(String str, String str2) {
        Logger logger = Logger.getLogger(str);
        if (f33416b.add(logger)) {
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(f.f33418a);
        }
    }

    private final String d(String str) {
        String str2 = f33417c.get(str);
        return str2 == null ? p9.t.h1(str, 23) : str2;
    }

    public final void a(@NotNull String loggerName, int i10, @NotNull String message, @Nullable Throwable th) {
        int iMin;
        t.i(loggerName, "loggerName");
        t.i(message, "message");
        String strD = d(loggerName);
        if (Log.isLoggable(strD, i10)) {
            if (th != null) {
                message = message + '\n' + ((Object) Log.getStackTraceString(th));
            }
            int length = message.length();
            int i11 = 0;
            while (i11 < length) {
                int iD0 = r.d0(message, '\n', i11, false, 4, null);
                if (iD0 == -1) {
                    iD0 = length;
                }
                while (true) {
                    iMin = Math.min(iD0, i11 + 4000);
                    String strSubstring = message.substring(i11, iMin);
                    t.h(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i10, strD, strSubstring);
                    if (iMin >= iD0) {
                        break;
                    } else {
                        i11 = iMin;
                    }
                }
                i11 = iMin + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry<String, String> entry : f33417c.entrySet()) {
            c(entry.getKey(), entry.getValue());
        }
    }
}
