package u9;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LockFreeTaskQueue.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class u<E> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public static final a f34704e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34705f = AtomicReferenceFieldUpdater.newUpdater(u.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f34706g = AtomicLongFieldUpdater.newUpdater(u.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final h0 f34707h = new h0("REMOVE_FROZEN");

    @Nullable
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f34708a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f34709b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34710c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final AtomicReferenceArray f34711d;

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final int a(long j10) {
            return (j10 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j10, int i10) {
            return d(j10, 1073741823L) | (((long) i10) << 0);
        }

        public final long c(long j10, int i10) {
            return d(j10, 1152921503533105152L) | (((long) i10) << 30);
        }

        public final long d(long j10, long j11) {
            return j10 & (~j11);
        }
    }

    /* JADX INFO: compiled from: LockFreeTaskQueue.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f34712a;

        public b(int i10) {
            this.f34712a = i10;
        }
    }

    public u(int i10, boolean z10) {
        this.f34708a = i10;
        this.f34709b = z10;
        int i11 = i10 - 1;
        this.f34710c = i11;
        this.f34711d = new AtomicReferenceArray(i10);
        if (!(i11 <= 1073741823)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (!((i10 & i11) == 0)) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final u<E> b(long j10) {
        u<E> uVar = new u<>(this.f34708a * 2, this.f34709b);
        int i10 = (int) ((1073741823 & j10) >> 0);
        int i11 = (int) ((1152921503533105152L & j10) >> 30);
        while (true) {
            int i12 = this.f34710c;
            if ((i10 & i12) == (i11 & i12)) {
                f34706g.set(uVar, f34704e.d(j10, 1152921504606846976L));
                return uVar;
            }
            Object bVar = this.f34711d.get(i12 & i10);
            if (bVar == null) {
                bVar = new b(i10);
            }
            uVar.f34711d.set(uVar.f34710c & i10, bVar);
            i10++;
        }
    }

    private final u<E> c(long j10) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34705f;
        while (true) {
            u<E> uVar = (u) atomicReferenceFieldUpdater.get(this);
            if (uVar != null) {
                return uVar;
            }
            androidx.concurrent.futures.a.a(f34705f, this, null, b(j10));
        }
    }

    private final u<E> e(int i10, E e10) {
        Object obj = this.f34711d.get(this.f34710c & i10);
        if (!(obj instanceof b) || ((b) obj).f34712a != i10) {
            return null;
        }
        this.f34711d.set(i10 & this.f34710c, e10);
        return this;
    }

    private final long h() {
        long j10;
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34706g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 1152921504606846976L) != 0) {
                return j10;
            }
            j11 = j10 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j11));
        return j11;
    }

    private final u<E> k(int i10, int i11) {
        long j10;
        int i12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34706g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            i12 = (int) ((1073741823 & j10) >> 0);
            if ((1152921504606846976L & j10) != 0) {
                return i();
            }
        } while (!f34706g.compareAndSet(this, j10, f34704e.b(j10, i11)));
        this.f34711d.set(this.f34710c & i12, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(@org.jetbrains.annotations.NotNull E r14) {
        /*
            r13 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = u9.u.f34706g
        L2:
            long r3 = r0.get(r13)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            u9.u$a r14 = u9.u.f34704e
            int r14 = r14.a(r3)
            return r14
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            r9 = 0
            long r1 = r1 >> r9
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r10 = (int) r5
            int r11 = r13.f34710c
            int r2 = r10 + 2
            r2 = r2 & r11
            r5 = r1 & r11
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r13.f34709b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L51
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r13.f34711d
            r12 = r10 & r11
            java.lang.Object r2 = r2.get(r12)
            if (r2 == 0) goto L51
            int r2 = r13.f34708a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L50
            int r10 = r10 - r1
            r1 = r10 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L2
        L50:
            return r6
        L51:
            int r1 = r10 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = u9.u.f34706g
            u9.u$a r5 = u9.u.f34704e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r13
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f34711d
            r1 = r10 & r11
            r0.set(r1, r14)
            r0 = r13
        L6c:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = u9.u.f34706g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L83
            u9.u r0 = r0.i()
            u9.u r0 = r0.e(r10, r14)
            if (r0 != 0) goto L6c
        L83:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.u.a(java.lang.Object):int");
    }

    public final boolean d() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34706g;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if ((j10 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j10) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, j10 | 2305843009213693952L));
        return true;
    }

    public final int f() {
        long j10 = f34706g.get(this);
        return (((int) ((j10 & 1152921503533105152L) >> 30)) - ((int) ((1073741823 & j10) >> 0))) & 1073741823;
    }

    public final boolean g() {
        long j10 = f34706g.get(this);
        return ((int) ((1073741823 & j10) >> 0)) == ((int) ((j10 & 1152921503533105152L) >> 30));
    }

    @NotNull
    public final u<E> i() {
        return c(h());
    }

    @Nullable
    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f34706g;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j10) != 0) {
                return f34707h;
            }
            int i10 = (int) ((1073741823 & j10) >> 0);
            int i11 = this.f34710c;
            if ((((int) ((1152921503533105152L & j10) >> 30)) & i11) == (i10 & i11)) {
                return null;
            }
            Object obj = this.f34711d.get(i11 & i10);
            if (obj == null) {
                if (this.f34709b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i12 = (i10 + 1) & 1073741823;
                if (f34706g.compareAndSet(this, j10, f34704e.b(j10, i12))) {
                    this.f34711d.set(this.f34710c & i10, null);
                    return obj;
                }
                if (this.f34709b) {
                    u<E> uVarK = this;
                    do {
                        uVarK = uVarK.k(i10, i12);
                    } while (uVarK != null);
                    return obj;
                }
            }
        }
    }
}
