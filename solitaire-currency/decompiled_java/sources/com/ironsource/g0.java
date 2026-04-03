package com.ironsource;

import com.ironsource.m1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f12193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<e0> f12194b = new CopyOnWriteArrayList();

    public g0(int i10) {
        this.f12193a = i10;
    }

    private final boolean b() {
        return this.f12193a == 0;
    }

    private final boolean c() {
        return this.f12193a != -1;
    }

    public final void a(@Nullable e0 e0Var) {
        if (b()) {
            return;
        }
        if (a()) {
            kotlin.collections.a0.N(this.f12194b);
        }
        if (e0Var == null) {
            e0Var = new e0(m1.a.NotPartOfWaterfall);
        }
        this.f12194b.add(e0Var);
    }

    @NotNull
    public final String d() {
        List<e0> list = this.f12194b;
        ArrayList arrayList = new ArrayList(kotlin.collections.w.v(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((e0) it.next()).b().ordinal()));
        }
        return kotlin.collections.d0.r0(arrayList, ",", null, null, 0, null, null, 62, null);
    }

    private final boolean a() {
        return c() && this.f12194b.size() >= this.f12193a;
    }
}
