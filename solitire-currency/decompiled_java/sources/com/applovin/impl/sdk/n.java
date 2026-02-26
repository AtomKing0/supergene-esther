package com.applovin.impl.sdk;

import android.text.TextUtils;
import android.util.Log;
import com.applovin.impl.l4;
import com.applovin.impl.n2;
import com.ironsource.v8;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f7183b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final j f7184a;

    n(j jVar) {
        this.f7184a = jVar;
        a("SDK Session Begin");
    }

    public static void a(boolean z10) {
        f7183b = z10;
    }

    public static void c(String str, String str2, Throwable th) {
        if (!f7183b || a()) {
            Log.e("AppLovinSdk", v8.i.f15837d + str + "] " + str2, th);
        }
    }

    public static void e(String str, String str2) {
        g(str, str2);
    }

    public static void g(String str, String str2) {
        if (!f7183b || a()) {
            Log.d("AppLovinSdk", v8.i.f15837d + str + "] " + str2);
        }
    }

    public static void h(String str, String str2) {
        c(str, str2, null);
    }

    public static void i(String str, String str2) {
        if (!f7183b || a()) {
            Log.i("AppLovinSdk", v8.i.f15837d + str + "] " + str2);
        }
    }

    public static void j(String str, String str2) {
        if (!f7183b || a()) {
            Log.w("AppLovinSdk", v8.i.f15837d + str + "] " + str2);
        }
    }

    public static void l(String str, String str2) {
        j jVar = j.f7084v0;
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (a()) {
            j.f7084v0.I().k(str, str2);
        }
    }

    public void b(String str, String str2) {
        a(str, str2, null);
    }

    public void d(String str, String str2) {
        Log.i("AppLovinSdk", v8.i.f15837d + str + "] " + str2);
    }

    public void f(String str, String str2) {
        int iIntValue;
        if (a(this.f7184a) && !TextUtils.isEmpty(str2) && (iIntValue = ((Integer) this.f7184a.a(l4.f5726r)).intValue()) > 0) {
            int length = str2.length();
            int i10 = ((length + iIntValue) - 1) / iIntValue;
            for (int i11 = 0; i11 < i10; i11++) {
                int i12 = i11 * iIntValue;
                a(str, str2.substring(i12, Math.min(length, i12 + iIntValue)));
            }
        }
    }

    public void k(String str, String str2) {
        d(str, str2, null);
    }

    private void a(String str) {
        n2 n2Var = new n2();
        n2Var.a().a(str).a();
        g("AppLovinSdk", n2Var.toString());
    }

    public static void b(String str, String str2, Throwable th) {
        j jVar = j.f7084v0;
        if (jVar == null) {
            return;
        }
        jVar.I();
        if (a()) {
            j.f7084v0.I().a(str, str2, th);
        }
    }

    public void d(String str, String str2, Throwable th) {
        Log.w("AppLovinSdk", v8.i.f15837d + str + "] " + str2, th);
    }

    public static void c(String str, String str2) {
        b(str, str2, null);
    }

    public void a(String str, Throwable th) {
        for (Throwable th2 : th.getSuppressed()) {
            b(str, th2.toString());
        }
    }

    public void a(String str, String str2) {
        Log.d("AppLovinSdk", v8.i.f15837d + str + "] " + str2);
    }

    public void a(String str, String str2, Throwable th) {
        Log.e("AppLovinSdk", v8.i.f15837d + str + "] " + str2, th);
    }

    public static boolean a() {
        return a(j.f7084v0);
    }

    public static boolean a(j jVar) {
        return jVar != null && jVar.h0().c();
    }
}
