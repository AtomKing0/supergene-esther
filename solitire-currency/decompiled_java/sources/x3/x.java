package x3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import k2.h;
import l3.c1;

/* JADX INFO: compiled from: TrackSelectionOverride.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements k2.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final h.a<x> f36025c = new h.a() { // from class: x3.w
        @Override // k2.h.a
        public final k2.h fromBundle(Bundle bundle) {
            return x.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c1 f36026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.google.common.collect.y<Integer> f36027b;

    public x(c1 c1Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= c1Var.f30482a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f36026a = c1Var;
        this.f36027b = com.google.common.collect.y.m(list);
    }

    private static String c(int i10) {
        return Integer.toString(i10, 36);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ x d(Bundle bundle) {
        return new x((c1) c1.f30481f.fromBundle((Bundle) a4.a.e(bundle.getBundle(c(0)))), g5.e.c((int[]) a4.a.e(bundle.getIntArray(c(1)))));
    }

    public int b() {
        return this.f36026a.f30484c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.f36026a.equals(xVar.f36026a) && this.f36027b.equals(xVar.f36027b);
    }

    public int hashCode() {
        return this.f36026a.hashCode() + (this.f36027b.hashCode() * 31);
    }

    @Override // k2.h
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c(0), this.f36026a.toBundle());
        bundle.putIntArray(c(1), g5.e.k(this.f36027b));
        return bundle;
    }
}
