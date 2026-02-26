package com.ironsource;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class a9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f11202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JSONObject f11203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f11204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11205d;

    public a9(String str) {
        this.f11202a = str;
    }

    public String a() {
        return this.f11205d;
    }

    public String b() {
        return this.f11202a;
    }

    public JSONObject c() {
        return this.f11203b;
    }

    public String d() {
        return this.f11204c;
    }

    public a9(String str, String str2, String str3) {
        this.f11202a = str;
        this.f11204c = str2;
        this.f11205d = str3;
    }

    public a9(String str, JSONObject jSONObject) {
        this.f11202a = str;
        this.f11203b = jSONObject;
    }

    public a9(String str, JSONObject jSONObject, String str2, String str3) {
        this.f11202a = str;
        this.f11203b = jSONObject;
        this.f11204c = str2;
        this.f11205d = str3;
    }
}
