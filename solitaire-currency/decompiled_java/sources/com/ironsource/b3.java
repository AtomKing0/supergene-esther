package com.ironsource;

import com.ironsource.k9;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class b3 implements j3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final e3 f11339a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final ge f11340b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final dl<Integer, Integer> f11341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final k9 f11342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private List<g3> f11343e;

    public b3(@NotNull e3 eventBaseData, @NotNull ge eventsManager, @NotNull dl<Integer, Integer> eventsMapper, @NotNull k9 currentTimeProvider) {
        kotlin.jvm.internal.t.i(eventBaseData, "eventBaseData");
        kotlin.jvm.internal.t.i(eventsManager, "eventsManager");
        kotlin.jvm.internal.t.i(eventsMapper, "eventsMapper");
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        this.f11339a = eventBaseData;
        this.f11340b = eventsManager;
        this.f11341c = eventsMapper;
        this.f11342d = currentTimeProvider;
        this.f11343e = new ArrayList();
    }

    @Override // com.ironsource.j3
    public void a() {
        this.f11343e.clear();
    }

    @NotNull
    public final List<g3> b() {
        return this.f11343e;
    }

    public /* synthetic */ b3(e3 e3Var, ge geVar, dl dlVar, k9 k9Var, int i10, kotlin.jvm.internal.k kVar) {
        this(e3Var, geVar, dlVar, (i10 & 8) != 0 ? new k9.a() : k9Var);
    }

    private final JSONObject b(List<? extends g3> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            ((g3) it.next()).a(linkedHashMap);
        }
        return new JSONObject(linkedHashMap);
    }

    @Override // com.ironsource.j3
    public void a(int i10, @NotNull List<g3> arrayList) {
        kotlin.jvm.internal.t.i(arrayList, "arrayList");
        try {
            Iterator<T> it = this.f11339a.a().iterator();
            while (it.hasNext()) {
                arrayList.add((g3) it.next());
            }
            Iterator<T> it2 = this.f11343e.iterator();
            while (it2.hasNext()) {
                arrayList.add((g3) it2.next());
            }
            this.f11340b.a(new kb(this.f11341c.a(Integer.valueOf(i10)).intValue(), this.f11342d.a(), b(arrayList)));
        } catch (Exception e10) {
            i9.d().a(e10);
            System.out.println((Object) ("LogRemote | Exception: " + e10.getMessage()));
        }
    }

    public final void a(@NotNull List<g3> list) {
        kotlin.jvm.internal.t.i(list, "<set-?>");
        this.f11343e = list;
    }

    @Override // com.ironsource.j3
    public void a(@NotNull g3... analyticsEventEntity) {
        kotlin.jvm.internal.t.i(analyticsEventEntity, "analyticsEventEntity");
        for (g3 g3Var : analyticsEventEntity) {
            this.f11343e.add(g3Var);
        }
    }
}
