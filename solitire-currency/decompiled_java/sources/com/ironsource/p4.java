package com.ironsource;

import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class p4 implements q4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final fh f14303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final com.ironsource.mediationsdk.d f14304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final v4 f14305c;

    public p4(@NotNull fh instanceInfo, @NotNull com.ironsource.mediationsdk.d auctionDataUtils, @Nullable v4 v4Var) {
        kotlin.jvm.internal.t.i(instanceInfo, "instanceInfo");
        kotlin.jvm.internal.t.i(auctionDataUtils, "auctionDataUtils");
        this.f14303a = instanceInfo;
        this.f14304b = auctionDataUtils;
        this.f14305c = v4Var;
    }

    @Override // com.ironsource.q4
    public void a(@NotNull String methodName) {
        List<String> listL;
        kotlin.jvm.internal.t.i(methodName, "methodName");
        v4 v4Var = this.f14305c;
        if (v4Var == null || (listL = v4Var.b()) == null) {
            listL = kotlin.collections.v.l();
        }
        a(listL, methodName);
    }

    @Override // com.ironsource.q4
    public void b(@NotNull String methodName) {
        List<String> listL;
        kotlin.jvm.internal.t.i(methodName, "methodName");
        v4 v4Var = this.f14305c;
        if (v4Var == null || (listL = v4Var.c()) == null) {
            listL = kotlin.collections.v.l();
        }
        a(listL, methodName);
    }

    @Override // com.ironsource.q4
    public void c(@NotNull String methodName) {
        List<String> listL;
        kotlin.jvm.internal.t.i(methodName, "methodName");
        v4 v4Var = this.f14305c;
        if (v4Var == null || (listL = v4Var.a()) == null) {
            listL = kotlin.collections.v.l();
        }
        a(listL, methodName);
    }

    private final void a(List<String> list, String str) {
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            this.f14304b.a(str, this.f14303a.e(), com.ironsource.mediationsdk.d.b().a((String) it.next(), this.f14303a.e(), this.f14303a.f(), this.f14303a.d(), "", "", "", ""));
        }
    }
}
