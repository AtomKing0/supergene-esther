package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ri {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14698a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f14699b;

    public ri(@NotNull String advId, @NotNull String advIdType) {
        kotlin.jvm.internal.t.i(advId, "advId");
        kotlin.jvm.internal.t.i(advIdType, "advIdType");
        this.f14698a = advId;
        this.f14699b = advIdType;
    }

    public static /* synthetic */ ri a(ri riVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = riVar.f14698a;
        }
        if ((i10 & 2) != 0) {
            str2 = riVar.f14699b;
        }
        return riVar.a(str, str2);
    }

    @NotNull
    public final String b() {
        return this.f14699b;
    }

    @NotNull
    public final String c() {
        return this.f14698a;
    }

    @NotNull
    public final String d() {
        return this.f14699b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ri)) {
            return false;
        }
        ri riVar = (ri) obj;
        return kotlin.jvm.internal.t.d(this.f14698a, riVar.f14698a) && kotlin.jvm.internal.t.d(this.f14699b, riVar.f14699b);
    }

    public int hashCode() {
        return (this.f14698a.hashCode() * 31) + this.f14699b.hashCode();
    }

    @NotNull
    public String toString() {
        return "IronSourceAdvId(advId=" + this.f14698a + ", advIdType=" + this.f14699b + ')';
    }

    @NotNull
    public final ri a(@NotNull String advId, @NotNull String advIdType) {
        kotlin.jvm.internal.t.i(advId, "advId");
        kotlin.jvm.internal.t.i(advIdType, "advIdType");
        return new ri(advId, advIdType);
    }

    @NotNull
    public final String a() {
        return this.f14698a;
    }
}
