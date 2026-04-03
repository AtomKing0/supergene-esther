package com.applovin.impl;

import java.util.Map;
import java.util.Objects;
import java.util.UUID;

/* JADX INFO: loaded from: classes2.dex */
public class l1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f5580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map f5581c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f5579a = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f5582d = System.currentTimeMillis();

    public l1(String str, Map map) {
        this.f5580b = str;
        this.f5581c = map;
    }

    public long a() {
        return this.f5582d;
    }

    public String b() {
        return this.f5579a;
    }

    public String c() {
        return this.f5580b;
    }

    public Map d() {
        return this.f5581c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        l1 l1Var = (l1) obj;
        if (this.f5582d == l1Var.f5582d && Objects.equals(this.f5580b, l1Var.f5580b) && Objects.equals(this.f5581c, l1Var.f5581c)) {
            return Objects.equals(this.f5579a, l1Var.f5579a);
        }
        return false;
    }

    public int hashCode() {
        String str = this.f5580b;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.f5581c;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        long j10 = this.f5582d;
        int i10 = (iHashCode2 + ((int) (j10 ^ (j10 >>> 32)))) * 31;
        String str2 = this.f5579a;
        return i10 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        return "Event{name='" + this.f5580b + "', id='" + this.f5579a + "', creationTimestampMillis=" + this.f5582d + ", parameters=" + this.f5581c + '}';
    }
}
