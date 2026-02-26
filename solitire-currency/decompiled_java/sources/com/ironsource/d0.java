package com.ironsource;

import com.ironsource.mediationsdk.logger.IronLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f11729c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final s1 f11730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final nu f11731b;

    public static final class a {

        /* JADX INFO: renamed from: com.ironsource.d0$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0254a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11732a;

            static {
                int[] iArr = new int[ru.values().length];
                try {
                    iArr[ru.BIDDER_SENSITIVE.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ru.DEFAULT.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f11732a = iArr;
            }
        }

        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final d0 a(@NotNull s1 adUnitData, @NotNull nu waterfallInstances) {
            kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
            kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
            int i10 = C0254a.f11732a[(adUnitData.d() ? ru.BIDDER_SENSITIVE : ru.DEFAULT).ordinal()];
            if (i10 == 1) {
                return new o7(adUnitData, waterfallInstances);
            }
            if (i10 == 2) {
                return adUnitData.r() ? new ds(adUnitData, waterfallInstances) : new u9(adUnitData, waterfallInstances);
            }
            throw new v8.q();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final List<x> f11733a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<x> f11734b = new ArrayList();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private final List<x> f11735c = new ArrayList();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f11736d;

        @NotNull
        public final List<x> a() {
            return this.f11733a;
        }

        @NotNull
        public final List<x> b() {
            return this.f11734b;
        }

        @NotNull
        public final List<x> c() {
            return this.f11735c;
        }

        public final boolean d() {
            return this.f11736d;
        }

        public final boolean e() {
            return g() == 0;
        }

        public final boolean f() {
            return this.f11733a.isEmpty() && this.f11735c.isEmpty();
        }

        public final int g() {
            return this.f11733a.size() + this.f11734b.size() + this.f11735c.size();
        }

        public final void a(boolean z10) {
            this.f11736d = z10;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final x f11737a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final List<x> f11738b;

        /* JADX WARN: Multi-variable type inference failed */
        public c(@Nullable x xVar, @NotNull List<? extends x> orderedInstances) {
            kotlin.jvm.internal.t.i(orderedInstances, "orderedInstances");
            this.f11737a = xVar;
            this.f11738b = orderedInstances;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ c a(c cVar, x xVar, List list, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                xVar = cVar.f11737a;
            }
            if ((i10 & 2) != 0) {
                list = cVar.f11738b;
            }
            return cVar.a(xVar, list);
        }

        @NotNull
        public final List<x> b() {
            return this.f11738b;
        }

        @Nullable
        public final x c() {
            return this.f11737a;
        }

        @NotNull
        public final List<x> d() {
            return this.f11738b;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return kotlin.jvm.internal.t.d(this.f11737a, cVar.f11737a) && kotlin.jvm.internal.t.d(this.f11738b, cVar.f11738b);
        }

        public int hashCode() {
            x xVar = this.f11737a;
            return ((xVar == null ? 0 : xVar.hashCode()) * 31) + this.f11738b.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowSelection(instanceToShow=" + this.f11737a + ", orderedInstances=" + this.f11738b + ')';
        }

        @NotNull
        public final c a(@Nullable x xVar, @NotNull List<? extends x> orderedInstances) {
            kotlin.jvm.internal.t.i(orderedInstances, "orderedInstances");
            return new c(xVar, orderedInstances);
        }

        @Nullable
        public final x a() {
            return this.f11737a;
        }
    }

    public static final class d<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Integer.valueOf(((x) t10).g().k()), Integer.valueOf(((x) t11).g().k()));
        }
    }

    public d0(@NotNull s1 adUnitData, @NotNull nu waterfallInstances) {
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        this.f11730a = adUnitData;
        this.f11731b = waterfallInstances;
    }

    private final List<x> b() {
        return kotlin.collections.d0.I0(this.f11731b.b(), new d());
    }

    public abstract void a(@NotNull x xVar, @NotNull b bVar);

    public final boolean a() {
        int i10;
        List<x> listB = this.f11731b.b();
        if ((listB instanceof Collection) && listB.isEmpty()) {
            i10 = 0;
        } else {
            Iterator<T> it = listB.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (((x) it.next()).u() && (i10 = i10 + 1) < 0) {
                    kotlin.collections.v.t();
                }
            }
        }
        return i10 >= this.f11730a.l();
    }

    @NotNull
    public final c c() {
        Object next;
        List<x> listB = b();
        Iterator<T> it = listB.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((x) next).u()) {
                break;
            }
        }
        return new c((x) next, listB);
    }

    @NotNull
    public final b d() {
        IronLog.INTERNAL.verbose(this.f11730a.b().a().name() + " waterfall size: " + this.f11731b.b().size());
        b bVar = new b();
        Iterator<x> it = this.f11731b.b().iterator();
        while (it.hasNext() && !b(it.next(), bVar)) {
        }
        return bVar;
    }

    private final boolean b(x xVar, b bVar) {
        IronLog ironLog;
        StringBuilder sb;
        String str;
        List<x> listC;
        if (!xVar.t()) {
            if (xVar.u()) {
                IronLog.INTERNAL.verbose(xVar.c().name() + " - Instance " + xVar.o() + " is already loaded");
                listC = bVar.b();
            } else if (xVar.v()) {
                IronLog.INTERNAL.verbose(xVar.c().name() + " - Instance " + xVar.o() + " still loading");
                listC = bVar.c();
            } else {
                if (!a(xVar, this.f11731b)) {
                    a(xVar, bVar);
                    return a(bVar);
                }
                ironLog = IronLog.INTERNAL;
                sb = new StringBuilder();
                sb.append(xVar.c().name());
                sb.append(" - Instance ");
                sb.append(xVar.o());
                str = " is not better than already loaded instances";
            }
            listC.add(xVar);
            return a(bVar);
        }
        ironLog = IronLog.INTERNAL;
        sb = new StringBuilder();
        sb.append(xVar.c().name());
        sb.append(" - Instance ");
        sb.append(xVar.o());
        str = " is failed to load";
        sb.append(str);
        ironLog.verbose(sb.toString());
        return a(bVar);
    }

    public boolean a(@NotNull b loadSelection) {
        kotlin.jvm.internal.t.i(loadSelection, "loadSelection");
        return loadSelection.g() >= this.f11730a.l();
    }

    public final boolean a(@NotNull x instance) {
        Object next;
        kotlin.jvm.internal.t.i(instance, "instance");
        Iterator<T> it = b().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((x) next).t()) {
                break;
            }
        }
        return kotlin.jvm.internal.t.d(next, instance);
    }

    protected boolean a(@NotNull x instance, @NotNull nu waterfallInstances) {
        kotlin.jvm.internal.t.i(instance, "instance");
        kotlin.jvm.internal.t.i(waterfallInstances, "waterfallInstances");
        return false;
    }
}
