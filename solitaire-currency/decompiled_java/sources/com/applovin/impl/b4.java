package com.applovin.impl;

import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class b4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f4902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map f4903b;

    private b4(String str, Map map) {
        this.f4902a = str;
        this.f4903b = map;
    }

    public static b4 a(String str) {
        return a(str, null);
    }

    public String b() {
        return this.f4902a;
    }

    public String toString() {
        return "PendingReward{result='" + this.f4902a + "'params='" + this.f4903b + "'}";
    }

    public static b4 a(String str, Map map) {
        return new b4(str, map);
    }

    public Map a() {
        return this.f4903b;
    }
}
