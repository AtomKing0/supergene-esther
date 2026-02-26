package com.applovin.impl;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class h3 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set f5329b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h3 f5330c = a("ar");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final h3 f5331d = a("ttdasi_ms");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f5332a;

    public interface a {
        Object a(Object obj);
    }

    private h3(String str) {
        this.f5332a = str;
    }

    protected boolean a(Object obj) {
        return obj instanceof h3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h3)) {
            return false;
        }
        h3 h3Var = (h3) obj;
        if (!h3Var.a(this)) {
            return false;
        }
        String strA = a();
        String strA2 = h3Var.a();
        return strA != null ? strA.equals(strA2) : strA2 == null;
    }

    public int hashCode() {
        String strA = a();
        return (strA == null ? 43 : strA.hashCode()) + 59;
    }

    public String toString() {
        return this.f5332a;
    }

    public String a() {
        return this.f5332a;
    }

    private static h3 a(String str) {
        Set set = f5329b;
        if (!set.contains(str)) {
            set.add(str);
            return new h3(str);
        }
        throw new IllegalArgumentException("Key has already been used: " + str);
    }
}
