package u9;

import java.lang.Comparable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.q0;

/* JADX INFO: compiled from: ThreadSafeHeap.kt */
/* JADX INFO: loaded from: classes5.dex */
public class p0<T extends q0 & Comparable<? super T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f34691b = AtomicIntegerFieldUpdater.newUpdater(p0.class, "_size");
    private volatile int _size;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private T[] f34692a;

    private final T[] f() {
        T[] tArr = this.f34692a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new q0[4];
            this.f34692a = tArr2;
            return tArr2;
        }
        if (c() < tArr.length) {
            return tArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(tArr, c() * 2);
        kotlin.jvm.internal.t.h(objArrCopyOf, "copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((q0[]) objArrCopyOf);
        this.f34692a = tArr3;
        return tArr3;
    }

    private final void j(int i10) {
        f34691b.set(this, i10);
    }

    private final void k(int i10) {
        while (true) {
            int i11 = (i10 * 2) + 1;
            if (i11 >= c()) {
                return;
            }
            T[] tArr = this.f34692a;
            kotlin.jvm.internal.t.f(tArr);
            int i12 = i11 + 1;
            if (i12 < c()) {
                T t10 = tArr[i12];
                kotlin.jvm.internal.t.f(t10);
                T t11 = tArr[i11];
                kotlin.jvm.internal.t.f(t11);
                if (((Comparable) t10).compareTo(t11) < 0) {
                    i11 = i12;
                }
            }
            T t12 = tArr[i10];
            kotlin.jvm.internal.t.f(t12);
            T t13 = tArr[i11];
            kotlin.jvm.internal.t.f(t13);
            if (((Comparable) t12).compareTo(t13) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    private final void l(int i10) {
        while (i10 > 0) {
            T[] tArr = this.f34692a;
            kotlin.jvm.internal.t.f(tArr);
            int i11 = (i10 - 1) / 2;
            T t10 = tArr[i11];
            kotlin.jvm.internal.t.f(t10);
            T t11 = tArr[i10];
            kotlin.jvm.internal.t.f(t11);
            if (((Comparable) t10).compareTo(t11) <= 0) {
                return;
            }
            m(i10, i11);
            i10 = i11;
        }
    }

    private final void m(int i10, int i11) {
        T[] tArr = this.f34692a;
        kotlin.jvm.internal.t.f(tArr);
        T t10 = tArr[i11];
        kotlin.jvm.internal.t.f(t10);
        T t11 = tArr[i10];
        kotlin.jvm.internal.t.f(t11);
        tArr[i10] = t10;
        tArr[i11] = t11;
        t10.setIndex(i10);
        t11.setIndex(i11);
    }

    public final void a(@NotNull T t10) {
        t10.d(this);
        q0[] q0VarArrF = f();
        int iC = c();
        j(iC + 1);
        q0VarArrF[iC] = t10;
        t10.setIndex(iC);
        l(iC);
    }

    @Nullable
    public final T b() {
        T[] tArr = this.f34692a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final int c() {
        return f34691b.get(this);
    }

    public final boolean d() {
        return c() == 0;
    }

    @Nullable
    public final T e() {
        T t10;
        synchronized (this) {
            t10 = (T) b();
        }
        return t10;
    }

    public final boolean g(@NotNull T t10) {
        boolean z10;
        synchronized (this) {
            if (t10.c() == null) {
                z10 = false;
            } else {
                h(t10.getIndex());
                z10 = true;
            }
        }
        return z10;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final T h(int r6) {
        /*
            r5 = this;
            T extends u9.q0 & java.lang.Comparable<? super T>[] r0 = r5.f34692a
            kotlin.jvm.internal.t.f(r0)
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.j(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.m(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            kotlin.jvm.internal.t.f(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            kotlin.jvm.internal.t.f(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.m(r6, r1)
            r5.l(r1)
            goto L3d
        L3a:
            r5.k(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            kotlin.jvm.internal.t.f(r6)
            r1 = 0
            r6.d(r1)
            r6.setIndex(r2)
            int r2 = r5.c()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.p0.h(int):u9.q0");
    }

    @Nullable
    public final T i() {
        T t10;
        synchronized (this) {
            t10 = c() > 0 ? (T) h(0) : null;
        }
        return t10;
    }
}
