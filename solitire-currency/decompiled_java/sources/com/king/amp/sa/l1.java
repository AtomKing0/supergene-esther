package com.king.amp.sa;

import android.util.Log;
import androidx.annotation.NonNull;
import com.ironsource.v8;

/* JADX INFO: compiled from: Logger.java */
/* JADX INFO: loaded from: classes4.dex */
public class l1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f16808a = false;

    /* JADX INFO: compiled from: Logger.java */
    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f16809a;

        static {
            int[] iArr = new int[b.values().length];
            f16809a = iArr;
            try {
                iArr[b.INFO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16809a[b.DEBUG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16809a[b.WARN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16809a[b.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: Logger.java */
    public enum b {
        INFO,
        DEBUG,
        WARN,
        ERROR
    }

    public static void a(@NonNull String str, String str2) {
        c(b.DEBUG, str, str2, null);
    }

    private static boolean b() {
        try {
            Class.forName("android.util.Log");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static void c(b bVar, @NonNull String str, String str2, Throwable th) {
        if (f16808a || !b()) {
            String str3 = v8.i.f15837d + bVar + "] " + str + ": " + str2;
            if (bVar != b.ERROR) {
                System.out.println(str3);
                return;
            }
            System.err.println(str3);
            if (th != null) {
                th.printStackTrace();
                return;
            }
            return;
        }
        int i10 = a.f16809a[bVar.ordinal()];
        if (i10 == 1) {
            Log.i(str, str2);
            return;
        }
        if (i10 == 2) {
            Log.d(str, str2);
            return;
        }
        if (i10 == 3) {
            Log.w(str, str2);
        } else {
            if (i10 != 4) {
                return;
            }
            if (th != null) {
                Log.e(str, str2, th);
            } else {
                Log.e(str, str2);
            }
        }
    }

    public static void d(@NonNull String str, String str2) {
        c(b.WARN, str, str2, null);
    }

    public static void e(@NonNull String str, String str2, Throwable th) {
        c(b.WARN, str, str2, th);
    }
}
