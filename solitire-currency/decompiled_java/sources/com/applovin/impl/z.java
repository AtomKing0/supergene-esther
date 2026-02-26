package com.applovin.impl;

/* JADX INFO: loaded from: classes2.dex */
public class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f7857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f7858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f7859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f7860d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f7861e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f7862f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f7863g;

    public z(String str, int i10) {
        this.f7861e = str;
        this.f7862f = i10;
        String[] strArrSplit = str.split(",");
        boolean z10 = strArrSplit.length == 3 || strArrSplit.length == 4;
        this.f7863g = z10;
        if (z10) {
            this.f7857a = a(strArrSplit[0]);
            this.f7858b = a(strArrSplit[1]);
            this.f7859c = a(strArrSplit[2]);
            this.f7860d = strArrSplit.length == 4 ? a(strArrSplit[3]) : "";
            return;
        }
        this.f7857a = "";
        this.f7858b = "";
        this.f7859c = "";
        this.f7860d = "";
    }

    protected boolean a(Object obj) {
        return obj instanceof z;
    }

    public String b() {
        return this.f7857a;
    }

    public String c() {
        return this.f7858b;
    }

    public String d() {
        return this.f7861e;
    }

    public String e() {
        return this.f7859c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        if (!zVar.a(this)) {
            return false;
        }
        String strB = b();
        String strB2 = zVar.b();
        if (strB != null ? !strB.equals(strB2) : strB2 != null) {
            return false;
        }
        String strC = c();
        String strC2 = zVar.c();
        if (strC != null ? !strC.equals(strC2) : strC2 != null) {
            return false;
        }
        String strE = e();
        String strE2 = zVar.e();
        if (strE != null ? !strE.equals(strE2) : strE2 != null) {
            return false;
        }
        String strA = a();
        String strA2 = zVar.a();
        return strA != null ? strA.equals(strA2) : strA2 == null;
    }

    public int f() {
        return this.f7862f;
    }

    public boolean g() {
        return this.f7857a.equals("applovin.com");
    }

    public boolean h() {
        return this.f7863g;
    }

    public int hashCode() {
        String strB = b();
        int iHashCode = strB == null ? 43 : strB.hashCode();
        String strC = c();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strC == null ? 43 : strC.hashCode());
        String strE = e();
        int iHashCode3 = (iHashCode2 * 59) + (strE == null ? 43 : strE.hashCode());
        String strA = a();
        return (iHashCode3 * 59) + (strA != null ? strA.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxtEntry(domainName=" + b() + ", publisherId=" + c() + ", relationship=" + e() + ", certificateAuthorityId=" + a() + ", rawValue=" + d() + ", rowNumber=" + f() + ", valid=" + h() + ")";
    }

    public String a() {
        return this.f7860d;
    }

    private String a(String str) {
        return str.replace((char) 173, ' ').trim();
    }

    public z(String str) {
        this(str, -1);
    }
}
