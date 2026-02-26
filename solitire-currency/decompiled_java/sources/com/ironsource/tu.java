package com.ironsource;

import com.ironsource.k7;
import com.ironsource.mediationsdk.logger.IronLog;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class tu<Smash extends k7<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final q0 f15484a;

    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            return x8.b.a(Integer.valueOf(((k7) t10).i().k()), Integer.valueOf(((k7) t11).i().k()));
        }
    }

    public tu(@NotNull q0 managerData) {
        kotlin.jvm.internal.t.i(managerData, "managerData");
        this.f15484a = managerData;
    }

    public final boolean a(@NotNull k7<?> smash, @NotNull List<? extends Smash> waterfall) {
        Object next;
        kotlin.jvm.internal.t.i(smash, "smash");
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        Iterator<T> it = b(waterfall).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!((k7) next).x()) {
                break;
            }
        }
        return kotlin.jvm.internal.t.d(next, smash);
    }

    @NotNull
    public final List<Smash> b(@NotNull List<? extends Smash> waterfall) {
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        return kotlin.collections.d0.I0(waterfall, new a());
    }

    @Nullable
    public final Smash c(@NotNull List<? extends Smash> waterfall) {
        Object next;
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        Iterator<T> it = b(waterfall).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((k7) next).B()) {
                break;
            }
        }
        return (Smash) next;
    }

    @NotNull
    public final uu<Smash> d(@NotNull List<? extends Smash> waterfall) {
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        IronLog.INTERNAL.verbose(this.f15484a.b().name() + " waterfall size: " + waterfall.size());
        vu<Smash> vuVarA = vu.f15970g.a(this.f15484a.c() ? ru.BIDDER_SENSITIVE : ru.DEFAULT, this.f15484a.j(), this.f15484a.n(), waterfall);
        Iterator<? extends Smash> it = waterfall.iterator();
        while (it.hasNext()) {
            vuVarA.d(it.next());
            if (vuVarA.e()) {
                return new uu<>(vuVarA);
            }
        }
        return new uu<>(vuVarA);
    }

    public final boolean a(@NotNull List<? extends Smash> waterfall) {
        int i10;
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        if ((waterfall instanceof Collection) && waterfall.isEmpty()) {
            i10 = 0;
        } else {
            Iterator<T> it = waterfall.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (((k7) it.next()).y() && (i10 = i10 + 1) < 0) {
                    kotlin.collections.v.t();
                }
            }
        }
        return i10 >= this.f15484a.j();
    }
}
