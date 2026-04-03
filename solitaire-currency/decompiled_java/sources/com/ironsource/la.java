package com.ironsource;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public class la {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static la f12996h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f12999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f13000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f13001e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f13002f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final ce f13003g;

    private la(Context context) {
        ce ceVarF = el.N().f();
        this.f13003g = ceVarF;
        this.f12997a = ceVarF.g();
        this.f12998b = ceVarF.e();
        this.f12999c = ceVarF.l();
        this.f13000d = ceVarF.o();
        this.f13001e = ceVarF.k();
        this.f13002f = ceVarF.j(context);
    }

    public static la b(Context context) {
        if (f12996h == null) {
            f12996h = new la(context);
        }
        return f12996h;
    }

    public static void g() {
        f12996h = null;
    }

    public float a(Context context) {
        return this.f13003g.m(context);
    }

    public String c() {
        return this.f12998b;
    }

    public String d() {
        return this.f12997a;
    }

    public String e() {
        return this.f12999c;
    }

    public String f() {
        return this.f13000d;
    }

    public int a() {
        return this.f13001e;
    }

    public String b() {
        return this.f13002f;
    }
}
