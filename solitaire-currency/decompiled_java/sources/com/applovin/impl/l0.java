package com.applovin.impl;

import android.content.Context;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f5574a = new a("Age Restricted User", n4.f6391m);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f5575b = new a("Has User Consent", n4.f6390l);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final a f5576c = new a("\"Do Not Sell\"", n4.f6392n);

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f5577a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final n4 f5578b;

        a(String str, n4 n4Var) {
            this.f5577a = str;
            this.f5578b = n4Var;
        }

        public Boolean b(Context context) {
            if (context != null) {
                return (Boolean) o4.a(this.f5578b, (Object) null, context);
            }
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to get value for key: " + this.f5578b);
            return null;
        }

        public String a() {
            return this.f5577a;
        }

        public String a(Context context) {
            Boolean boolB = b(context);
            return boolB != null ? boolB.toString() : "No value set";
        }
    }

    public static a a() {
        return f5576c;
    }

    public static a b() {
        return f5575b;
    }

    public static a c() {
        return f5574a;
    }

    public static boolean a(boolean z10, Context context) {
        return a(n4.f6392n, Boolean.valueOf(z10), context);
    }

    public static boolean b(boolean z10, Context context) {
        return a(n4.f6390l, Boolean.valueOf(z10), context);
    }

    public static String a(Context context) {
        return a(f5575b, context) + a(f5576c, context);
    }

    private static boolean a(n4 n4Var, Boolean bool, Context context) {
        if (context == null) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "Failed to update compliance value for key: " + n4Var);
            return false;
        }
        try {
            Boolean bool2 = (Boolean) o4.a(n4Var, (Object) null, context);
            o4.b(n4Var, bool, context);
            return bool2 == null || bool2 != bool;
        } catch (Throwable th) {
            com.applovin.impl.sdk.n.c("ComplianceManager", "Unable to update compliance", th);
            com.applovin.impl.sdk.j jVar = com.applovin.impl.sdk.j.f7084v0;
            if (jVar != null) {
                jVar.A().a("ComplianceManager", "updateCompliance", th);
            }
            return false;
        }
    }

    private static String a(a aVar, Context context) {
        return "\n" + aVar.f5577a + " - " + aVar.a(context);
    }
}
