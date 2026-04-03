package com.ironsource;

import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class k2 extends com.ironsource.mediationsdk.h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final Map<String, g0> f12815e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k2(@NotNull List<? extends NetworkSettings> providers, int i10) {
        super(providers, i10);
        kotlin.jvm.internal.t.i(providers, "providers");
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(providers, 10)), 16));
        Iterator<T> it = providers.iterator();
        while (it.hasNext()) {
            v8.s sVarA = v8.y.a(((NetworkSettings) it.next()).getProviderName(), new g0(i10));
            linkedHashMap.put(sVarA.c(), sVarA.d());
        }
        this.f12815e = linkedHashMap;
    }

    @Override // com.ironsource.mediationsdk.h
    @NotNull
    public String a(@NotNull String instanceName) {
        String strD;
        kotlin.jvm.internal.t.i(instanceName, "instanceName");
        g0 g0Var = this.f12815e.get(instanceName);
        return (g0Var == null || (strD = g0Var.d()) == null) ? "" : strD;
    }

    public final void a(@NotNull nu waterfallInstances) {
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        List<x> listB = waterfallInstances.b();
        LinkedHashMap linkedHashMap = new LinkedHashMap(n9.o.e(kotlin.collections.q0.d(kotlin.collections.w.v(listB, 10)), 16));
        for (x xVar : listB) {
            v8.s sVarA = v8.y.a(xVar.n(), xVar.q());
            linkedHashMap.put(sVarA.c(), sVarA.d());
        }
        a(linkedHashMap);
    }

    private final void a(Map<String, e0> map) {
        for (Map.Entry<String, g0> entry : this.f12815e.entrySet()) {
            entry.getValue().a(map.get(entry.getKey()));
        }
    }
}
