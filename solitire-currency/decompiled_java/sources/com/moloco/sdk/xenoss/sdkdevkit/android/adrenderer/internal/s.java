package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f19697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f19698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f19699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f19700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final String f19701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final String f19702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    public final String f19703g;

    public s(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        this.f19697a = str;
        this.f19698b = str2;
        this.f19699c = str3;
        this.f19700d = str4;
        this.f19701e = str5;
        this.f19702f = str6;
        this.f19703g = str7;
    }

    public static /* synthetic */ s a(s sVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = sVar.f19697a;
        }
        if ((i10 & 2) != 0) {
            str2 = sVar.f19698b;
        }
        String str8 = str2;
        if ((i10 & 4) != 0) {
            str3 = sVar.f19699c;
        }
        String str9 = str3;
        if ((i10 & 8) != 0) {
            str4 = sVar.f19700d;
        }
        String str10 = str4;
        if ((i10 & 16) != 0) {
            str5 = sVar.f19701e;
        }
        String str11 = str5;
        if ((i10 & 32) != 0) {
            str6 = sVar.f19702f;
        }
        String str12 = str6;
        if ((i10 & 64) != 0) {
            str7 = sVar.f19703g;
        }
        return sVar.b(str, str8, str9, str10, str11, str12, str7);
    }

    @NotNull
    public final s b(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7) {
        return new s(str, str2, str3, str4, str5, str6, str7);
    }

    @Nullable
    public final String c() {
        return this.f19697a;
    }

    @Nullable
    public final String d() {
        return this.f19698b;
    }

    @Nullable
    public final String e() {
        return this.f19699c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return kotlin.jvm.internal.t.d(this.f19697a, sVar.f19697a) && kotlin.jvm.internal.t.d(this.f19698b, sVar.f19698b) && kotlin.jvm.internal.t.d(this.f19699c, sVar.f19699c) && kotlin.jvm.internal.t.d(this.f19700d, sVar.f19700d) && kotlin.jvm.internal.t.d(this.f19701e, sVar.f19701e) && kotlin.jvm.internal.t.d(this.f19702f, sVar.f19702f) && kotlin.jvm.internal.t.d(this.f19703g, sVar.f19703g);
    }

    @Nullable
    public final String f() {
        return this.f19701e;
    }

    @Nullable
    public final String g() {
        return this.f19700d;
    }

    @Nullable
    public final String h() {
        return this.f19702f;
    }

    public int hashCode() {
        String str = this.f19697a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f19698b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f19699c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f19700d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.f19701e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.f19702f;
        int iHashCode6 = (iHashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.f19703g;
        return iHashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    @Nullable
    public final String i() {
        return this.f19703g;
    }

    @NotNull
    public String toString() {
        return "DEC(appIconUri=" + this.f19697a + ", appName=" + this.f19698b + ", ctaText=" + this.f19699c + ", ctaUrl=" + this.f19700d + ", ctaTrackingUrl=" + this.f19701e + ", impressionTrackingUrl=" + this.f19702f + ", skipToDECTrackingUrl=" + this.f19703g + ')';
    }
}
