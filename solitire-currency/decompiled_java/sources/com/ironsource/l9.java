package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f12993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final String f12994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final String f12995d;

    public l9() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ l9 a(l9 l9Var, String str, String str2, String str3, String str4, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = l9Var.f12992a;
        }
        if ((i10 & 2) != 0) {
            str2 = l9Var.f12993b;
        }
        if ((i10 & 4) != 0) {
            str3 = l9Var.f12994c;
        }
        if ((i10 & 8) != 0) {
            str4 = l9Var.f12995d;
        }
        return l9Var.a(str, str2, str3, str4);
    }

    @NotNull
    public final String b() {
        return this.f12993b;
    }

    @NotNull
    public final String c() {
        return this.f12994c;
    }

    @NotNull
    public final String d() {
        return this.f12995d;
    }

    @NotNull
    public final String e() {
        return this.f12995d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l9)) {
            return false;
        }
        l9 l9Var = (l9) obj;
        return kotlin.jvm.internal.t.d(this.f12992a, l9Var.f12992a) && kotlin.jvm.internal.t.d(this.f12993b, l9Var.f12993b) && kotlin.jvm.internal.t.d(this.f12994c, l9Var.f12994c) && kotlin.jvm.internal.t.d(this.f12995d, l9Var.f12995d);
    }

    @NotNull
    public final String f() {
        return this.f12994c;
    }

    @NotNull
    public final String g() {
        return this.f12992a;
    }

    @NotNull
    public final String h() {
        return this.f12993b;
    }

    public int hashCode() {
        return (((((this.f12992a.hashCode() * 31) + this.f12993b.hashCode()) * 31) + this.f12994c.hashCode()) * 31) + this.f12995d.hashCode();
    }

    @NotNull
    public String toString() {
        return "CustomAdapterSettings(customNetworkAdapterName=" + this.f12992a + ", customRewardedVideoAdapterName=" + this.f12993b + ", customInterstitialAdapterName=" + this.f12994c + ", customBannerAdapterName=" + this.f12995d + ')';
    }

    public l9(@NotNull String customNetworkAdapterName, @NotNull String customRewardedVideoAdapterName, @NotNull String customInterstitialAdapterName, @NotNull String customBannerAdapterName) {
        kotlin.jvm.internal.t.i(customNetworkAdapterName, "customNetworkAdapterName");
        kotlin.jvm.internal.t.i(customRewardedVideoAdapterName, "customRewardedVideoAdapterName");
        kotlin.jvm.internal.t.i(customInterstitialAdapterName, "customInterstitialAdapterName");
        kotlin.jvm.internal.t.i(customBannerAdapterName, "customBannerAdapterName");
        this.f12992a = customNetworkAdapterName;
        this.f12993b = customRewardedVideoAdapterName;
        this.f12994c = customInterstitialAdapterName;
        this.f12995d = customBannerAdapterName;
    }

    @NotNull
    public final l9 a(@NotNull String customNetworkAdapterName, @NotNull String customRewardedVideoAdapterName, @NotNull String customInterstitialAdapterName, @NotNull String customBannerAdapterName) {
        kotlin.jvm.internal.t.i(customNetworkAdapterName, "customNetworkAdapterName");
        kotlin.jvm.internal.t.i(customRewardedVideoAdapterName, "customRewardedVideoAdapterName");
        kotlin.jvm.internal.t.i(customInterstitialAdapterName, "customInterstitialAdapterName");
        kotlin.jvm.internal.t.i(customBannerAdapterName, "customBannerAdapterName");
        return new l9(customNetworkAdapterName, customRewardedVideoAdapterName, customInterstitialAdapterName, customBannerAdapterName);
    }

    public /* synthetic */ l9(String str, String str2, String str3, String str4, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? "" : str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? "" : str3, (i10 & 8) != 0 ? "" : str4);
    }

    @NotNull
    public final String a() {
        return this.f12992a;
    }
}
