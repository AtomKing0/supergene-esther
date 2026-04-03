package com.ironsource;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes4.dex */
public final class a3 implements wr<JSONArray> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<z2> f11184a = new ArrayList();

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11185a;

        static {
            int[] iArr = new int[vr.values().length];
            try {
                iArr[vr.FullHistory.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[vr.CurrentlyLoadedAds.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f11185a = iArr;
        }
    }

    private final List<z2> b() {
        List<z2> list = this.f11184a;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((z2) obj).e() != tr.LoadRequest) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private final List<z2> a() {
        List<z2> list = this.f11184a;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            z2 z2Var = (z2) next;
            if ((z2Var.e() == tr.LoadSuccess || z2Var.e() == tr.LoadRequest) ? false : true) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(arrayList, 10));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((z2) it2.next()).a());
        }
        Set setT0 = kotlin.collections.d0.T0(arrayList2);
        List<z2> list2 = this.f11184a;
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : list2) {
            z2 z2Var2 = (z2) obj;
            if (z2Var2.e() == tr.LoadSuccess && !setT0.contains(z2Var2.a())) {
                arrayList3.add(obj);
            }
        }
        return arrayList3;
    }

    @Override // com.ironsource.od
    @NotNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public JSONArray a(@NotNull vr mode) {
        kotlin.jvm.internal.t.i(mode, "mode");
        int i10 = a.f11185a[mode.ordinal()];
        if (i10 == 1) {
            List<z2> listB = b();
            ArrayList arrayList = new ArrayList(kotlin.collections.w.v(listB, 10));
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(((z2) it.next()).d());
            }
            return new JSONArray((Collection) arrayList);
        }
        if (i10 != 2) {
            throw new v8.q();
        }
        List<z2> listA = a();
        ArrayList arrayList2 = new ArrayList(kotlin.collections.w.v(listA, 10));
        Iterator<T> it2 = listA.iterator();
        while (it2.hasNext()) {
            arrayList2.add(((z2) it2.next()).c());
        }
        return new JSONArray((Collection) arrayList2);
    }

    public final void a(@NotNull z2 event) {
        kotlin.jvm.internal.t.i(event, "event");
        this.f11184a.add(event);
    }
}
