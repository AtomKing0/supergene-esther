package com.ironsource;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class ds extends u9 {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds(@NotNull s1 adUnitData, @NotNull nu waterfallInstances) {
        super(adUnitData, waterfallInstances);
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
    }

    private final int a(nu nuVar) {
        Integer num;
        List<x> listB = nuVar.b();
        ArrayList arrayList = new ArrayList();
        for (Object obj : listB) {
            if (((x) obj).u()) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (it.hasNext()) {
            Integer numValueOf = Integer.valueOf(b((x) it.next()));
            while (it.hasNext()) {
                Integer numValueOf2 = Integer.valueOf(b((x) it.next()));
                if (numValueOf.compareTo(numValueOf2) > 0) {
                    numValueOf = numValueOf2;
                }
            }
            num = numValueOf;
        } else {
            num = null;
        }
        if (num != null) {
            return num.intValue();
        }
        return Integer.MAX_VALUE;
    }

    private final int b(x xVar) {
        return xVar.g().k();
    }

    @Override // com.ironsource.d0
    protected boolean a(@NotNull x instance, @NotNull nu waterfallInstances) {
        kotlin.jvm.internal.t.i(instance, "instance");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        return a(waterfallInstances) < b(instance);
    }
}
