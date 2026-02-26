package com.ironsource;

import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.ironsource.mediationsdk.d f12214b;

    public g5(@NotNull String serverData) {
        kotlin.jvm.internal.t.i(serverData, "serverData");
        this.f12213a = serverData;
        this.f12214b = com.ironsource.mediationsdk.d.b();
    }

    public static /* synthetic */ g5 a(g5 g5Var, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = g5Var.f12213a;
        }
        return g5Var.a(str);
    }

    private final String c() {
        return this.f12213a;
    }

    @NotNull
    public final Map<String, String> b() {
        Map<String, String> mapB = this.f12214b.b(this.f12213a);
        kotlin.jvm.internal.t.h(mapB, "auctionDataUtils.getAuct…verDataParams(serverData)");
        return mapB;
    }

    @NotNull
    public final String d() {
        String strC = this.f12214b.c(this.f12213a);
        kotlin.jvm.internal.t.h(strC, "auctionDataUtils.getDyna…romServerData(serverData)");
        return strC;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g5) && kotlin.jvm.internal.t.d(this.f12213a, ((g5) obj).f12213a);
    }

    public int hashCode() {
        return this.f12213a.hashCode();
    }

    @NotNull
    public String toString() {
        return "AuctionServerData(serverData=" + this.f12213a + ')';
    }

    @NotNull
    public final g5 a(@NotNull String serverData) {
        kotlin.jvm.internal.t.i(serverData, "serverData");
        return new g5(serverData);
    }

    @NotNull
    public final String a() {
        String strA = this.f12214b.a(this.f12213a);
        kotlin.jvm.internal.t.h(strA, "auctionDataUtils.getAdmFromServerData(serverData)");
        return strA;
    }
}
