package com.moloco.sdk.common_adapter_internal;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17482a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17483b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f17484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f17485d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17486e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f17487f;

    public a(int i10, int i11, float f10, float f11, int i12, float f12) {
        this.f17482a = i10;
        this.f17483b = i11;
        this.f17484c = f10;
        this.f17485d = f11;
        this.f17486e = i12;
        this.f17487f = f12;
    }

    public final int a() {
        return this.f17486e;
    }

    public final float b() {
        return this.f17485d;
    }

    public final int c() {
        return this.f17483b;
    }

    public final float d() {
        return this.f17487f;
    }

    public final float e() {
        return this.f17484c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f17482a == aVar.f17482a && this.f17483b == aVar.f17483b && Float.compare(this.f17484c, aVar.f17484c) == 0 && Float.compare(this.f17485d, aVar.f17485d) == 0 && this.f17486e == aVar.f17486e && Float.compare(this.f17487f, aVar.f17487f) == 0;
    }

    public final int f() {
        return this.f17482a;
    }

    public int hashCode() {
        return (((((((((this.f17482a * 31) + this.f17483b) * 31) + Float.floatToIntBits(this.f17484c)) * 31) + Float.floatToIntBits(this.f17485d)) * 31) + this.f17486e) * 31) + Float.floatToIntBits(this.f17487f);
    }

    @NotNull
    public String toString() {
        return "ScreenData(widthPx=" + this.f17482a + ", heightPx=" + this.f17483b + ", widthDp=" + this.f17484c + ", heightDp=" + this.f17485d + ", dpi=" + this.f17486e + ", pxRatio=" + this.f17487f + ')';
    }
}
