package com.ironsource.sdk.controller;

import android.webkit.JavascriptInterface;
import com.ironsource.sdk.controller.v;
import com.ironsource.sdk.utils.Logger;
import java.lang.reflect.Method;
import java.security.AccessControlException;

/* JADX INFO: loaded from: classes4.dex */
class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14897b = "b";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v.r f14898a;

    b(v.r rVar) {
        this.f14898a = rVar;
    }

    void a(String str) {
        v.r rVar = this.f14898a;
        if (rVar != null) {
            rVar.c(str);
        }
    }

    synchronized void a(String str, String str2) throws Exception {
        if (this.f14898a == null) {
            Logger.e(f14897b, "!!! nativeAPI == null !!!");
            return;
        }
        Method declaredMethod = v.r.class.getDeclaredMethod(str, String.class);
        if (declaredMethod.isAnnotationPresent(JavascriptInterface.class)) {
            declaredMethod.invoke(this.f14898a, str2);
            return;
        }
        throw new AccessControlException("Trying to access a private function: " + str);
    }
}
