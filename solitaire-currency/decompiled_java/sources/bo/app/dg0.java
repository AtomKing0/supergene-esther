package bo.app;

import bo.app.dg0;
import bo.app.k10;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/* JADX INFO: loaded from: classes2.dex */
public final class dg0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Comparator f2652b = new Comparator() { // from class: i.f
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return dg0.a((k10) obj, (k10) obj2);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PriorityQueue f2653a;

    public dg0(ArrayList fallbackActions) {
        kotlin.jvm.internal.t.i(fallbackActions, "fallbackActions");
        PriorityQueue priorityQueue = new PriorityQueue(12, f2652b);
        this.f2653a = priorityQueue;
        priorityQueue.addAll(fallbackActions);
    }

    public static final int a(k10 actionA, k10 actionB) {
        kotlin.jvm.internal.t.i(actionA, "actionA");
        kotlin.jvm.internal.t.i(actionB, "actionB");
        bh0 bh0Var = (bh0) actionA;
        int i10 = bh0Var.f2453b.f2885c;
        bh0 bh0Var2 = (bh0) actionB;
        int i11 = bh0Var2.f2453b.f2885c;
        if (i10 > i11) {
            return -1;
        }
        if (i10 < i11) {
            return 1;
        }
        return bh0Var.f2452a.compareTo(bh0Var2.f2452a);
    }
}
