package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ln {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f13057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f13058b;

    public ln(@NotNull String url, @Nullable String str) {
        kotlin.jvm.internal.t.i(url, "url");
        this.f13057a = url;
        this.f13058b = str;
    }

    public static /* synthetic */ ln a(ln lnVar, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = lnVar.f13057a;
        }
        if ((i10 & 2) != 0) {
            str2 = lnVar.f13058b;
        }
        return lnVar.a(str, str2);
    }

    @Nullable
    public final String b() {
        return this.f13058b;
    }

    @Nullable
    public final String c() {
        return this.f13058b;
    }

    @NotNull
    public final String d() {
        return this.f13057a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ln)) {
            return false;
        }
        ln lnVar = (ln) obj;
        return kotlin.jvm.internal.t.d(this.f13057a, lnVar.f13057a) && kotlin.jvm.internal.t.d(this.f13058b, lnVar.f13058b);
    }

    public int hashCode() {
        int iHashCode = this.f13057a.hashCode() * 31;
        String str = this.f13058b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "OpenUrl(url=" + this.f13057a + ", packageName=" + this.f13058b + ')';
    }

    public /* synthetic */ ln(String str, String str2, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? "" : str2);
    }

    @NotNull
    public final ln a(@NotNull String url, @Nullable String str) {
        kotlin.jvm.internal.t.i(url, "url");
        return new ln(url, str);
    }

    @NotNull
    public final String a() {
        return this.f13057a;
    }
}
