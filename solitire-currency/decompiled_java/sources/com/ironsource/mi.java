package com.ironsource;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class mi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f14009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f14010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f14011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f14012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private hf f14013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, String> f14014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private an f14015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f14016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f14017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f14018j;

    mi(String str, String str2, boolean z10, boolean z11, boolean z12, boolean z13, String str3, Map<String, String> map, an anVar, hf hfVar) {
        this.f14010b = str;
        this.f14011c = str2;
        this.f14009a = z10;
        this.f14012d = z11;
        this.f14014f = map;
        this.f14015g = anVar;
        this.f14013e = hfVar;
        this.f14017i = z12;
        this.f14018j = z13;
        this.f14016h = str3;
    }

    public Map<String, String> a() {
        HashMap map = new HashMap();
        map.put("instanceId", this.f14010b);
        map.put("instanceName", this.f14011c);
        map.put("rewarded", Boolean.toString(this.f14009a));
        map.put("inAppBidding", Boolean.toString(this.f14012d));
        map.put("isOneFlow", Boolean.toString(this.f14017i));
        map.put(v8.f15667r, String.valueOf(2));
        hf hfVar = this.f14013e;
        map.put("width", hfVar != null ? Integer.toString(hfVar.c()) : "0");
        hf hfVar2 = this.f14013e;
        map.put("height", hfVar2 != null ? Integer.toString(hfVar2.a()) : "0");
        hf hfVar3 = this.f14013e;
        map.put("label", hfVar3 != null ? hfVar3.b() : "");
        map.put(v8.f15671v, Boolean.toString(i()));
        if (this.f14018j) {
            map.put("isMultipleAdObjects", com.ironsource.mediationsdk.metadata.a.f13688g);
        }
        String str = this.f14016h;
        if (str != null) {
            map.put("adUnitId", str);
        }
        Map<String, String> map2 = this.f14014f;
        if (map2 != null) {
            map.putAll(map2);
        }
        return map;
    }

    public final an b() {
        return this.f14015g;
    }

    public String c() {
        return this.f14016h;
    }

    public Map<String, String> d() {
        return this.f14014f;
    }

    public String e() {
        return this.f14010b;
    }

    public String f() {
        return this.f14011c.replaceAll("IronSource_", "");
    }

    public String g() {
        return this.f14011c;
    }

    public hf h() {
        return this.f14013e;
    }

    public boolean i() {
        return h() != null && h().d();
    }

    public boolean j() {
        return this.f14012d;
    }

    public boolean k() {
        return j() || m();
    }

    public boolean l() {
        return this.f14018j;
    }

    public boolean m() {
        return this.f14017i;
    }

    public boolean n() {
        return this.f14009a;
    }

    public void a(an anVar) {
        this.f14015g = anVar;
    }

    public void a(String str) {
        this.f14016h = str;
    }
}
