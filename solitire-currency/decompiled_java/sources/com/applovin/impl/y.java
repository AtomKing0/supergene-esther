package com.applovin.impl;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f7762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f7763b;

    public y(Map map, List list) {
        this.f7762a = map;
        this.f7763b = list;
    }

    protected boolean a(Object obj) {
        return obj instanceof y;
    }

    public List b() {
        return this.f7763b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof y)) {
            return false;
        }
        y yVar = (y) obj;
        if (!yVar.a(this)) {
            return false;
        }
        Map mapA = a();
        Map mapA2 = yVar.a();
        if (mapA != null ? !mapA.equals(mapA2) : mapA2 != null) {
            return false;
        }
        List listB = b();
        List listB2 = yVar.b();
        return listB != null ? listB.equals(listB2) : listB2 == null;
    }

    public int hashCode() {
        Map mapA = a();
        int iHashCode = mapA == null ? 43 : mapA.hashCode();
        List listB = b();
        return ((iHashCode + 59) * 59) + (listB != null ? listB.hashCode() : 43);
    }

    public String toString() {
        return "AppAdsTxt(domainEntries=" + a() + ", invalidEntries=" + b() + ")";
    }

    public Map a() {
        return this.f7762a;
    }
}
