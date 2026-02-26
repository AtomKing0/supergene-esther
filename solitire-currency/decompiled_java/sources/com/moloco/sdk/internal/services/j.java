package com.moloco.sdk.internal.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f18788a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f18789b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f18790c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f18791d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f18792e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f18793f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f18794g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final float f18795h;

    public j(int i10, float f10, int i11, float f11, float f12, int i12, float f13, float f14) {
        this.f18788a = i10;
        this.f18789b = f10;
        this.f18790c = i11;
        this.f18791d = f11;
        this.f18792e = f12;
        this.f18793f = i12;
        this.f18794g = f13;
        this.f18795h = f14;
    }

    public final float a() {
        return this.f18792e;
    }

    public final int b() {
        return this.f18793f;
    }

    public final float c() {
        return this.f18791d;
    }

    public final int d() {
        return this.f18790c;
    }

    public final float e() {
        return this.f18789b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f18788a == jVar.f18788a && Float.compare(this.f18789b, jVar.f18789b) == 0 && this.f18790c == jVar.f18790c && Float.compare(this.f18791d, jVar.f18791d) == 0 && Float.compare(this.f18792e, jVar.f18792e) == 0 && this.f18793f == jVar.f18793f && Float.compare(this.f18794g, jVar.f18794g) == 0 && Float.compare(this.f18795h, jVar.f18795h) == 0;
    }

    public final int f() {
        return this.f18788a;
    }

    public final float g() {
        return this.f18794g;
    }

    public final float h() {
        return this.f18795h;
    }

    public int hashCode() {
        return (((((((((((((this.f18788a * 31) + Float.floatToIntBits(this.f18789b)) * 31) + this.f18790c) * 31) + Float.floatToIntBits(this.f18791d)) * 31) + Float.floatToIntBits(this.f18792e)) * 31) + this.f18793f) * 31) + Float.floatToIntBits(this.f18794g)) * 31) + Float.floatToIntBits(this.f18795h);
    }

    @NotNull
    public String toString() {
        return "ScreenInfo(screenWidthPx=" + this.f18788a + ", screenWidthDp=" + this.f18789b + ", screenHeightPx=" + this.f18790c + ", screenHeightDp=" + this.f18791d + ", density=" + this.f18792e + ", dpi=" + this.f18793f + ", xdpi=" + this.f18794g + ", ydpi=" + this.f18795h + ')';
    }
}
