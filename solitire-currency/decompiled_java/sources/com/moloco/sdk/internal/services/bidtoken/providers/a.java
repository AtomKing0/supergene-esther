package com.moloco.sdk.internal.services.bidtoken.providers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Boolean f18484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Boolean f18485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Boolean f18486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Float f18487d;

    public a() {
        this(null, null, null, null, 15, null);
    }

    @Nullable
    public final Boolean a() {
        return this.f18484a;
    }

    @Nullable
    public final Boolean b() {
        return this.f18485b;
    }

    @Nullable
    public final Float c() {
        return this.f18487d;
    }

    @Nullable
    public final Boolean d() {
        return this.f18486c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return kotlin.jvm.internal.t.d(this.f18484a, aVar.f18484a) && kotlin.jvm.internal.t.d(this.f18485b, aVar.f18485b) && kotlin.jvm.internal.t.d(this.f18486c, aVar.f18486c) && kotlin.jvm.internal.t.d(this.f18487d, aVar.f18487d);
    }

    public int hashCode() {
        Boolean bool = this.f18484a;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        Boolean bool2 = this.f18485b;
        int iHashCode2 = (iHashCode + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.f18486c;
        int iHashCode3 = (iHashCode2 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        Float f10 = this.f18487d;
        return iHashCode3 + (f10 != null ? f10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AccessibilitySignal(accessibilityCaptioningEnabled=" + this.f18484a + ", accessibilityLargePointerIcon=" + this.f18485b + ", reduceBrightColorsActivated=" + this.f18486c + ", fontScale=" + this.f18487d + ')';
    }

    public a(@Nullable Boolean bool, @Nullable Boolean bool2, @Nullable Boolean bool3, @Nullable Float f10) {
        this.f18484a = bool;
        this.f18485b = bool2;
        this.f18486c = bool3;
        this.f18487d = f10;
    }

    public /* synthetic */ a(Boolean bool, Boolean bool2, Boolean bool3, Float f10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : bool, (i10 & 2) != 0 ? null : bool2, (i10 & 4) != 0 ? null : bool3, (i10 & 8) != 0 ? null : f10);
    }
}
