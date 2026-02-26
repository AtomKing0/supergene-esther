package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class r3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14627a;

    /* JADX WARN: Multi-variable type inference failed */
    public r3() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ r3 a(r3 r3Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = r3Var.f14627a;
        }
        return r3Var.a(str);
    }

    @NotNull
    public final String b() {
        return this.f14627a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r3) && kotlin.jvm.internal.t.d(this.f14627a, ((r3) obj).f14627a);
    }

    public int hashCode() {
        return this.f14627a.hashCode();
    }

    @NotNull
    public String toString() {
        return "ApplicationAuctionSettings(auctionData=" + this.f14627a + ')';
    }

    public r3(@NotNull String auctionData) {
        kotlin.jvm.internal.t.i(auctionData, "auctionData");
        this.f14627a = auctionData;
    }

    @NotNull
    public final r3 a(@NotNull String auctionData) {
        kotlin.jvm.internal.t.i(auctionData, "auctionData");
        return new r3(auctionData);
    }

    public /* synthetic */ r3(String str, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? "" : str);
    }

    @NotNull
    public final String a() {
        return this.f14627a;
    }
}
