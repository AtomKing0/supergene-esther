package a4;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import io.sentry.protocol.SentryStackFrame;
import java.net.UnknownHostException;

/* JADX INFO: compiled from: Log.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private static int f245b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private static boolean f246c = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Object f244a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private static a f247d = a.f248a;

    /* JADX INFO: compiled from: Log.java */
    public interface a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f248a = new C0004a();

        /* JADX INFO: renamed from: a4.t$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Log.java */
        class C0004a implements a {
            C0004a() {
            }

            @Override // a4.t.a
            public void a(String str, String str2) {
                Log.w(str, str2);
            }

            @Override // a4.t.a
            public void b(String str, String str2) {
                Log.e(str, str2);
            }

            @Override // a4.t.a
            public void c(String str, String str2) {
                Log.i(str, str2);
            }

            @Override // a4.t.a
            public void d(String str, String str2) {
                Log.d(str, str2);
            }
        }

        void a(String str, String str2);

        void b(String str, String str2);

        void c(String str, String str2);

        void d(String str, String str2);
    }

    private static String a(String str, @Nullable Throwable th) {
        String strE = e(th);
        if (TextUtils.isEmpty(strE)) {
            return str;
        }
        return str + "\n  " + strE.replace("\n", "\n  ") + '\n';
    }

    public static void b(@Size(max = 23) String str, String str2) {
        synchronized (f244a) {
            if (f245b == 0) {
                f247d.d(str, str2);
            }
        }
    }

    public static void c(@Size(max = 23) String str, String str2) {
        synchronized (f244a) {
            if (f245b <= 3) {
                f247d.b(str, str2);
            }
        }
    }

    public static void d(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        c(str, a(str2, th));
    }

    @Nullable
    public static String e(@Nullable Throwable th) {
        synchronized (f244a) {
            if (th == null) {
                return null;
            }
            if (h(th)) {
                return "UnknownHostException (no network)";
            }
            if (f246c) {
                return Log.getStackTraceString(th).trim().replace("\t", "    ");
            }
            return th.getMessage();
        }
    }

    public static void f(@Size(max = 23) String str, String str2) {
        synchronized (f244a) {
            if (f245b <= 1) {
                f247d.c(str, str2);
            }
        }
    }

    public static void g(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        f(str, a(str2, th));
    }

    private static boolean h(@Nullable Throwable th) {
        while (th != null) {
            if (th instanceof UnknownHostException) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static void i(@Size(max = 23) String str, String str2) {
        synchronized (f244a) {
            if (f245b <= 2) {
                f247d.a(str, str2);
            }
        }
    }

    public static void j(@Size(max = 23) String str, String str2, @Nullable Throwable th) {
        i(str, a(str2, th));
    }
}
