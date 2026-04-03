package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.x1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class lb implements w1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final x1 f13004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<w1> f13005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ug f13006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final sk f13007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final pt f13008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private final k4 f13009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final j0 f13010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final ut f13011h;

    public lb(@NotNull IronSource.AD_UNIT adFormat, @NotNull x1.b level, @NotNull List<? extends w1> eventsInterfaces, @Nullable m7 m7Var) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(level, "level");
        kotlin.jvm.internal.t.i(eventsInterfaces, "eventsInterfaces");
        x1 x1Var = new x1(adFormat, level, this, m7Var);
        this.f13004a = x1Var;
        this.f13005b = kotlin.collections.d0.R0(eventsInterfaces);
        ug ugVar = x1Var.f16107f;
        kotlin.jvm.internal.t.h(ugVar, "wrapper.init");
        this.f13006c = ugVar;
        sk skVar = x1Var.f16108g;
        kotlin.jvm.internal.t.h(skVar, "wrapper.load");
        this.f13007d = skVar;
        pt ptVar = x1Var.f16109h;
        kotlin.jvm.internal.t.h(ptVar, "wrapper.token");
        this.f13008e = ptVar;
        k4 k4Var = x1Var.f16110i;
        kotlin.jvm.internal.t.h(k4Var, "wrapper.auction");
        this.f13009f = k4Var;
        j0 j0Var = x1Var.f16111j;
        kotlin.jvm.internal.t.h(j0Var, "wrapper.adInteraction");
        this.f13010g = j0Var;
        ut utVar = x1Var.f16112k;
        kotlin.jvm.internal.t.h(utVar, "wrapper.troubleshoot");
        this.f13011h = utVar;
    }

    @NotNull
    public final j0 a() {
        return this.f13010g;
    }

    @NotNull
    public final k4 b() {
        return this.f13009f;
    }

    @NotNull
    public final List<w1> c() {
        return this.f13005b;
    }

    @NotNull
    public final ug d() {
        return this.f13006c;
    }

    @NotNull
    public final sk e() {
        return this.f13007d;
    }

    @NotNull
    public final pt f() {
        return this.f13008e;
    }

    @NotNull
    public final ut g() {
        return this.f13011h;
    }

    public /* synthetic */ lb(IronSource.AD_UNIT ad_unit, x1.b bVar, List list, m7 m7Var, int i10, kotlin.jvm.internal.k kVar) {
        this(ad_unit, bVar, (i10 & 4) != 0 ? kotlin.collections.v.l() : list, (i10 & 8) != 0 ? null : m7Var);
    }

    @Override // com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@NotNull u1 event) {
        kotlin.jvm.internal.t.i(event, "event");
        HashMap map = new HashMap();
        Iterator<T> it = this.f13005b.iterator();
        while (it.hasNext()) {
            Map<String, Object> mapA = ((w1) it.next()).a(event);
            kotlin.jvm.internal.t.h(mapA, "it.getEventsAdditionalDataMap(event)");
            map.putAll(mapA);
        }
        return map;
    }

    public final void a(@NotNull w1 eventInterface) {
        kotlin.jvm.internal.t.i(eventInterface, "eventInterface");
        this.f13005b.add(eventInterface);
    }

    public final void a(boolean z10) {
        if (z10) {
            this.f13007d.a(true);
        } else {
            if (z10) {
                throw new v8.q();
            }
            this.f13007d.a();
        }
    }
}
