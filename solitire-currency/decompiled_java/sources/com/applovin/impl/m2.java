package com.applovin.impl;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class m2 implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5865a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f5867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final v2 f5868d;

    m2(String str, String str2, boolean z10, v2 v2Var) {
        this.f5865a = str;
        this.f5866b = str2;
        this.f5867c = z10;
        this.f5868d = v2Var;
    }

    public String a() {
        return this.f5866b;
    }

    public List b() {
        List listL = this.f5868d.l();
        return (listL == null || listL.isEmpty()) ? Collections.singletonList(this.f5865a) : listL;
    }

    public String c() {
        return this.f5865a;
    }

    public v2 d() {
        return this.f5868d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        m2 m2Var = (m2) obj;
        String str = this.f5865a;
        if (str == null ? m2Var.f5865a != null : !str.equals(m2Var.f5865a)) {
            return false;
        }
        String str2 = this.f5866b;
        if (str2 == null ? m2Var.f5866b == null : str2.equals(m2Var.f5866b)) {
            return this.f5867c == m2Var.f5867c;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f5865a;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.f5866b;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + (this.f5867c ? 1 : 0);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(m2 m2Var) {
        return this.f5866b.compareToIgnoreCase(m2Var.f5866b);
    }
}
