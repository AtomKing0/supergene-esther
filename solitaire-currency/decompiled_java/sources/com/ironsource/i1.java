package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private IronSource.AD_UNIT f12524a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f12525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private NetworkSettings f12526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f12527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f12528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private JSONObject f12529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f12530g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f12531h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private String f12532i;

    public i1(IronSource.AD_UNIT ad_unit, String str, int i10, JSONObject jSONObject, String str2, int i11, String str3, NetworkSettings networkSettings, int i12) {
        this.f12524a = ad_unit;
        this.f12525b = str;
        this.f12528e = i10;
        this.f12529f = jSONObject;
        this.f12530g = str2;
        this.f12531h = i11;
        this.f12532i = str3;
        this.f12526c = networkSettings;
        this.f12527d = i12;
    }

    public IronSource.AD_UNIT a() {
        return this.f12524a;
    }

    public String b() {
        return this.f12532i;
    }

    public String c() {
        return this.f12530g;
    }

    public int d() {
        return this.f12531h;
    }

    public JSONObject e() {
        return this.f12529f;
    }

    public int f() {
        return this.f12527d;
    }

    public NetworkSettings g() {
        return this.f12526c;
    }

    public int h() {
        return this.f12528e;
    }

    public String i() {
        return this.f12525b;
    }
}
