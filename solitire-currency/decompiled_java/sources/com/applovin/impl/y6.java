package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import java.util.Locale;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public final class y6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f7840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7842c = a(n4.f6387i, (String) o4.a(n4.f6386h, (Object) null, com.applovin.impl.sdk.j.n()));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7843d;

    public y6(com.applovin.impl.sdk.j jVar) {
        this.f7840a = jVar;
        this.f7843d = a(n4.f6388j, (String) jVar.a(l4.f5630f));
        a(d());
    }

    private String a(n4 n4Var, String str) {
        String str2 = (String) o4.a(n4Var, (Object) null, com.applovin.impl.sdk.j.n());
        if (StringUtils.isValidString(str2)) {
            return str2;
        }
        if (!StringUtils.isValidString(str)) {
            str = UUID.randomUUID().toString().toLowerCase(Locale.US);
        }
        o4.b(n4Var, str, com.applovin.impl.sdk.j.n());
        return str;
    }

    private String d() {
        if (!((Boolean) this.f7840a.a(l4.f5754u3)).booleanValue()) {
            this.f7840a.c(n4.f6385g);
        }
        String str = (String) this.f7840a.a(n4.f6385g);
        if (!StringUtils.isValidString(str)) {
            return null;
        }
        this.f7840a.I();
        if (com.applovin.impl.sdk.n.a()) {
            this.f7840a.I().a("AppLovinSdk", "Using identifier (" + str + ") from previous session");
        }
        return str;
    }

    public String b() {
        return this.f7842c;
    }

    public String c() {
        return this.f7841b;
    }

    public void a(String str) {
        if (((Boolean) this.f7840a.a(l4.f5754u3)).booleanValue()) {
            this.f7840a.b(n4.f6385g, str);
        }
        this.f7841b = str;
        this.f7840a.r().b(str, a());
    }

    public static String a(com.applovin.impl.sdk.j jVar) {
        n4 n4Var = n4.f6389k;
        String str = (String) jVar.a(n4Var);
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String strValueOf = String.valueOf(((int) (Math.random() * 100.0d)) + 1);
        jVar.b(n4Var, strValueOf);
        return strValueOf;
    }

    public String a() {
        return this.f7843d;
    }
}
