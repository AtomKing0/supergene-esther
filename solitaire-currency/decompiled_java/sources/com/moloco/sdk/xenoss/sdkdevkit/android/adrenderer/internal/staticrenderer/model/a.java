package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.staticrenderer.model;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f19758b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f19759c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f19760d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f19761e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f19762f;

    public a(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f19757a = i10;
        this.f19758b = i11;
        this.f19759c = i12;
        this.f19760d = i13;
        this.f19761e = i14;
        this.f19762f = i15;
    }

    public final int a() {
        return this.f19761e;
    }

    public final int b() {
        return this.f19762f;
    }

    public final int c() {
        return this.f19757a;
    }

    public final int d() {
        return this.f19758b;
    }

    public final int e() {
        return this.f19759c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f19757a == aVar.f19757a && this.f19758b == aVar.f19758b && this.f19759c == aVar.f19759c && this.f19760d == aVar.f19760d && this.f19761e == aVar.f19761e && this.f19762f == aVar.f19762f;
    }

    public final int f() {
        return this.f19760d;
    }

    public int hashCode() {
        return (((((((((this.f19757a * 31) + this.f19758b) * 31) + this.f19759c) * 31) + this.f19760d) * 31) + this.f19761e) * 31) + this.f19762f;
    }

    @NotNull
    public String toString() {
        return "AdTouch(viewPositionX=" + this.f19757a + ", viewPositionY=" + this.f19758b + ", viewSizeHeight=" + this.f19759c + ", viewSizeWidth=" + this.f19760d + ", touchX=" + this.f19761e + ", touchY=" + this.f19762f + ')';
    }
}
