package com.ironsource;

/* JADX INFO: loaded from: classes4.dex */
public class s2 extends wp {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static String f14776h = "type";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static String f14777i = "numOfAdUnits";

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static String f14778j = "firstCampaignCredits";

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f14779k = "totalNumberCredits";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f14780l = "productType";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f14783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f14784e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f14785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f14786g;

    public s2(String str) {
        boolean z10;
        super(str);
        if (a(f14776h)) {
            k(d(f14776h));
        }
        if (a(f14777i)) {
            h(d(f14777i));
            z10 = true;
        } else {
            z10 = false;
        }
        a(z10);
        if (a(f14778j)) {
            g(d(f14778j));
        }
        if (a(f14779k)) {
            j(d(f14779k));
        }
        if (a(f14780l)) {
            i(d(f14780l));
        }
    }

    private void a(boolean z10) {
        this.f14786g = z10;
    }

    public String b() {
        return this.f14784e;
    }

    public String c() {
        return this.f14783d;
    }

    public String d() {
        return this.f14782c;
    }

    public String e() {
        return this.f14785f;
    }

    public String f() {
        return this.f14781b;
    }

    public void g(String str) {
        this.f14784e = str;
    }

    public void h(String str) {
        this.f14783d = str;
    }

    public void i(String str) {
        this.f14782c = str;
    }

    public void j(String str) {
        this.f14785f = str;
    }

    public void k(String str) {
        this.f14781b = str;
    }

    public boolean g() {
        return this.f14786g;
    }
}
