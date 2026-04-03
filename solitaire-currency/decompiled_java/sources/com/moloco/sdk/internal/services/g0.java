package com.moloco.sdk.internal.services;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f18679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f18680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final String f18681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final String f18682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f18683g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public final String f18684h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    public final String f18685i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final float f18686j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f18687k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public final String f18688l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NotNull
    public final String f18689m;

    public g0(@NotNull String manufacturer, @NotNull String model, @NotNull String hwVersion, boolean z10, @NotNull String os, @NotNull String osVersion, int i10, @NotNull String language, @NotNull String mobileCarrier, float f10, long j10, @NotNull String hardware, @NotNull String brand) {
        kotlin.jvm.internal.t.i(manufacturer, "manufacturer");
        kotlin.jvm.internal.t.i(model, "model");
        kotlin.jvm.internal.t.i(hwVersion, "hwVersion");
        kotlin.jvm.internal.t.i(os, "os");
        kotlin.jvm.internal.t.i(osVersion, "osVersion");
        kotlin.jvm.internal.t.i(language, "language");
        kotlin.jvm.internal.t.i(mobileCarrier, "mobileCarrier");
        kotlin.jvm.internal.t.i(hardware, "hardware");
        kotlin.jvm.internal.t.i(brand, "brand");
        this.f18677a = manufacturer;
        this.f18678b = model;
        this.f18679c = hwVersion;
        this.f18680d = z10;
        this.f18681e = os;
        this.f18682f = osVersion;
        this.f18683g = i10;
        this.f18684h = language;
        this.f18685i = mobileCarrier;
        this.f18686j = f10;
        this.f18687k = j10;
        this.f18688l = hardware;
        this.f18689m = brand;
    }

    @NotNull
    public final String a() {
        return this.f18689m;
    }

    public final long b() {
        return this.f18687k;
    }

    @NotNull
    public final String c() {
        return this.f18688l;
    }

    @NotNull
    public final String d() {
        return this.f18679c;
    }

    @NotNull
    public final String e() {
        return this.f18684h;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        return kotlin.jvm.internal.t.d(this.f18677a, g0Var.f18677a) && kotlin.jvm.internal.t.d(this.f18678b, g0Var.f18678b) && kotlin.jvm.internal.t.d(this.f18679c, g0Var.f18679c) && this.f18680d == g0Var.f18680d && kotlin.jvm.internal.t.d(this.f18681e, g0Var.f18681e) && kotlin.jvm.internal.t.d(this.f18682f, g0Var.f18682f) && this.f18683g == g0Var.f18683g && kotlin.jvm.internal.t.d(this.f18684h, g0Var.f18684h) && kotlin.jvm.internal.t.d(this.f18685i, g0Var.f18685i) && Float.compare(this.f18686j, g0Var.f18686j) == 0 && this.f18687k == g0Var.f18687k && kotlin.jvm.internal.t.d(this.f18688l, g0Var.f18688l) && kotlin.jvm.internal.t.d(this.f18689m, g0Var.f18689m);
    }

    @NotNull
    public final String f() {
        return this.f18677a;
    }

    @NotNull
    public final String g() {
        return this.f18685i;
    }

    @NotNull
    public final String h() {
        return this.f18678b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v5, types: [int] */
    public int hashCode() {
        int iHashCode = ((((this.f18677a.hashCode() * 31) + this.f18678b.hashCode()) * 31) + this.f18679c.hashCode()) * 31;
        boolean z10 = this.f18680d;
        ?? r12 = z10;
        if (z10) {
            r12 = 1;
        }
        return ((((((((((((((((((iHashCode + r12) * 31) + this.f18681e.hashCode()) * 31) + this.f18682f.hashCode()) * 31) + this.f18683g) * 31) + this.f18684h.hashCode()) * 31) + this.f18685i.hashCode()) * 31) + Float.floatToIntBits(this.f18686j)) * 31) + androidx.compose.animation.a.a(this.f18687k)) * 31) + this.f18688l.hashCode()) * 31) + this.f18689m.hashCode();
    }

    @NotNull
    public final String i() {
        return this.f18681e;
    }

    @NotNull
    public final String j() {
        return this.f18682f;
    }

    public final float k() {
        return this.f18686j;
    }

    public final boolean l() {
        return this.f18680d;
    }

    @NotNull
    public String toString() {
        return "DeviceInfo(manufacturer=" + this.f18677a + ", model=" + this.f18678b + ", hwVersion=" + this.f18679c + ", isTablet=" + this.f18680d + ", os=" + this.f18681e + ", osVersion=" + this.f18682f + ", apiLevel=" + this.f18683g + ", language=" + this.f18684h + ", mobileCarrier=" + this.f18685i + ", screenDensity=" + this.f18686j + ", dbtMs=" + this.f18687k + ", hardware=" + this.f18688l + ", brand=" + this.f18689m + ')';
    }
}
