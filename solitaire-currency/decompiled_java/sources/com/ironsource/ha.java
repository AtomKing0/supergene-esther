package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class ha {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f12450h = 0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f12451i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f12452j = 2;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f12453k = 3;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f12454l = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f12455a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12456b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f12457c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, String> f12458d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12459e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f12460f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private mi f12461g;

    public ha(mi miVar) {
        this(miVar.e(), miVar.g(), miVar.a(), miVar.b());
        this.f12461g = miVar;
    }

    public void a() {
        Map<String, String> map = this.f12458d;
        if (map != null) {
            map.clear();
        }
        this.f12458d = null;
    }

    public Map<String, String> b() {
        HashMap map = new HashMap();
        map.put("demandSourceId", this.f12456b);
        map.put("demandSourceName", this.f12455a);
        Map<String, String> map2 = this.f12458d;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public mi c() {
        return this.f12461g;
    }

    public boolean d() {
        return this.f12460f;
    }

    public int e() {
        return this.f12459e;
    }

    public String f() {
        return this.f12455a;
    }

    public Map<String, String> g() {
        return this.f12458d;
    }

    public String h() {
        return this.f12456b;
    }

    public an i() {
        if (this.f12461g != null) {
            return c().b();
        }
        return null;
    }

    public int j() {
        return this.f12457c;
    }

    public boolean k() {
        Map<String, String> map = this.f12458d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.f12458d.get("rewarded"));
    }

    public ha(String str, String str2, Map<String, String> map, an anVar) {
        this.f12457c = -1;
        this.f12456b = str;
        this.f12455a = str2;
        this.f12458d = map;
        this.f12459e = 0;
        this.f12460f = false;
        this.f12461g = null;
    }

    public void a(boolean z10) {
        this.f12460f = z10;
    }

    public synchronized void b(int i10) {
        this.f12459e = i10;
    }

    public void c(int i10) {
        this.f12457c = i10;
    }

    public boolean a(int i10) {
        return this.f12457c == i10;
    }
}
