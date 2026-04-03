package com.ironsource.sdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.qf;

/* JADX INFO: loaded from: classes4.dex */
public class Logger {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f15301a;

    public static void d(String str, String str2) {
        if (f15301a) {
            Log.d(str, str2);
        }
    }

    public static void e(String str, String str2) {
        if (f15301a) {
            Log.e(str, str2);
        }
    }

    public static void enableLogging(int i10) {
        f15301a = qf.d.MODE_0.a() != i10;
    }

    public static void i(String str, String str2) {
        if (f15301a) {
            Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (f15301a) {
            Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (f15301a) {
            Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (f15301a) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (f15301a) {
            Log.e(str, str2, th);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (!f15301a || TextUtils.isEmpty(str2)) {
            return;
        }
        Log.i(str, str2, th);
    }

    public static void v(String str, String str2, Throwable th) {
        if (f15301a) {
            Log.v(str, str2, th);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (f15301a) {
            Log.w(str, str2, th);
        }
    }
}
