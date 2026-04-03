package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class p7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f6563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f6564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f6565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f6567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f6568f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f6569g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f6570h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final float f6571i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final float f6572j;

    public p7(JSONObject jSONObject, com.applovin.impl.sdk.j jVar) {
        jVar.I();
        if (com.applovin.impl.sdk.n.a()) {
            jVar.I().d("VideoButtonProperties", "Updating video button properties with JSON = " + JsonUtils.maybeConvertToIndentedString(jSONObject));
        }
        this.f6563a = JsonUtils.getInt(jSONObject, "width", 64);
        this.f6564b = JsonUtils.getInt(jSONObject, "height", 7);
        this.f6565c = JsonUtils.getInt(jSONObject, "margin", 20);
        this.f6566d = JsonUtils.getInt(jSONObject, "gravity", 85);
        this.f6567e = JsonUtils.getBoolean(jSONObject, "tap_to_fade", Boolean.FALSE).booleanValue();
        this.f6568f = JsonUtils.getInt(jSONObject, "tap_to_fade_duration_milliseconds", 500);
        this.f6569g = JsonUtils.getInt(jSONObject, "fade_in_duration_milliseconds", 500);
        this.f6570h = JsonUtils.getInt(jSONObject, "fade_out_duration_milliseconds", 500);
        this.f6571i = JsonUtils.getFloat(jSONObject, "fade_in_delay_seconds", 1.0f);
        this.f6572j = JsonUtils.getFloat(jSONObject, "fade_out_delay_seconds", 6.0f);
    }

    public float a() {
        return this.f6571i;
    }

    public long b() {
        return this.f6569g;
    }

    public float c() {
        return this.f6572j;
    }

    public long d() {
        return this.f6570h;
    }

    public int e() {
        return this.f6566d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        p7 p7Var = (p7) obj;
        return this.f6563a == p7Var.f6563a && this.f6564b == p7Var.f6564b && this.f6565c == p7Var.f6565c && this.f6566d == p7Var.f6566d && this.f6567e == p7Var.f6567e && this.f6568f == p7Var.f6568f && this.f6569g == p7Var.f6569g && this.f6570h == p7Var.f6570h && Float.compare(p7Var.f6571i, this.f6571i) == 0 && Float.compare(p7Var.f6572j, this.f6572j) == 0;
    }

    public int f() {
        return this.f6564b;
    }

    public int g() {
        return this.f6565c;
    }

    public long h() {
        return this.f6568f;
    }

    public int hashCode() {
        int i10 = ((((((((((((((this.f6563a * 31) + this.f6564b) * 31) + this.f6565c) * 31) + this.f6566d) * 31) + (this.f6567e ? 1 : 0)) * 31) + this.f6568f) * 31) + this.f6569g) * 31) + this.f6570h) * 31;
        float f10 = this.f6571i;
        int iFloatToIntBits = (i10 + (f10 != 0.0f ? Float.floatToIntBits(f10) : 0)) * 31;
        float f11 = this.f6572j;
        return iFloatToIntBits + (f11 != 0.0f ? Float.floatToIntBits(f11) : 0);
    }

    public int i() {
        return this.f6563a;
    }

    public boolean j() {
        return this.f6567e;
    }

    public String toString() {
        return "VideoButtonProperties{widthPercentOfScreen=" + this.f6563a + ", heightPercentOfScreen=" + this.f6564b + ", margin=" + this.f6565c + ", gravity=" + this.f6566d + ", tapToFade=" + this.f6567e + ", tapToFadeDurationMillis=" + this.f6568f + ", fadeInDurationMillis=" + this.f6569g + ", fadeOutDurationMillis=" + this.f6570h + ", fadeInDelay=" + this.f6571i + ", fadeOutDelay=" + this.f6572j + '}';
    }
}
