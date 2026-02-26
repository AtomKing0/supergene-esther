package w9;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.s0;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.c0;
import u9.h0;
import v8.k0;

/* JADX INFO: compiled from: CoroutineScheduler.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    public static final C0721a f35502h = new C0721a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f35503i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f35504j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f35505k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    public static final h0 f35506l = new h0("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f35508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f35509c;
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    public final String f35510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final w9.d f35511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    public final w9.d f35512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public final c0<c> f35513g;
    private volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: w9.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public static final class C0721a {
        private C0721a() {
        }

        public /* synthetic */ C0721a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f35514a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f35514a = iArr;
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i10, int i11, long j10, @NotNull String str) {
        this.f35507a = i10;
        this.f35508b = i11;
        this.f35509c = j10;
        this.f35510d = str;
        if (!(i10 >= 1)) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (!(i11 >= i10)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (!(i11 <= 2097150)) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (!(j10 > 0)) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f35511e = new w9.d();
        this.f35512f = new w9.d();
        this.f35513g = new c0<>((i10 + 1) * 2);
        this.controlState = ((long) i10) << 42;
        this._isTerminated = 0;
    }

    private final int B(c cVar) {
        Object objI = cVar.i();
        while (objI != f35506l) {
            if (objI == null) {
                return 0;
            }
            c cVar2 = (c) objI;
            int iH = cVar2.h();
            if (iH != 0) {
                return iH;
            }
            objI = cVar2.i();
        }
        return -1;
    }

    private final boolean G0(long j10) {
        if (o.e(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f35507a) {
            int i10 = i();
            if (i10 == 1 && this.f35507a > 1) {
                i();
            }
            if (i10 > 0) {
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ boolean I0(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f35504j.get(aVar);
        }
        return aVar.G0(j10);
    }

    private final c J() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f35503i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVarB = this.f35513g.b((int) (2097151 & j10));
            if (cVarB == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int iB = B(cVarB);
            if (iB >= 0 && f35503i.compareAndSet(this, j10, ((long) iB) | j11)) {
                cVarB.r(f35506l);
                return cVarB;
            }
        }
    }

    private final boolean J0() {
        c cVarJ;
        do {
            cVarJ = J();
            if (cVarJ == null) {
                return false;
            }
        } while (!c.j().compareAndSet(cVarJ, -1, 0));
        LockSupport.unpark(cVarJ);
        return true;
    }

    private final void W(long j10, boolean z10) {
        if (z10 || J0() || G0(j10)) {
            return;
        }
        J0();
    }

    private final boolean c(h hVar) {
        return hVar.f35540b.b() == 1 ? this.f35512f.a(hVar) : this.f35511e.a(hVar);
    }

    private final int i() {
        synchronized (this.f35513g) {
            if (isTerminated()) {
                return -1;
            }
            AtomicLongFieldUpdater atomicLongFieldUpdater = f35504j;
            long j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 & 2097151);
            int iE = o.e(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
            if (iE >= this.f35507a) {
                return 0;
            }
            if (i10 >= this.f35508b) {
                return 0;
            }
            int i11 = ((int) (f35504j.get(this) & 2097151)) + 1;
            if (!(i11 > 0 && this.f35513g.b(i11) == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            c cVar = new c(this, i11);
            this.f35513g.c(i11, cVar);
            if (!(i11 == ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this))))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            int i12 = iE + 1;
            cVar.start();
            return i12;
        }
    }

    private final h i0(c cVar, h hVar, boolean z10) {
        if (cVar == null || cVar.f35518c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f35540b.b() == 0 && cVar.f35518c == d.BLOCKING) {
            return hVar;
        }
        cVar.f35522g = true;
        return cVar.f35516a.a(hVar, z10);
    }

    private final c q() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !t.d(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public static /* synthetic */ void z(a aVar, Runnable runnable, i iVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            iVar = l.f35549g;
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        aVar.x(runnable, iVar, z10);
    }

    public final boolean L(@NotNull c cVar) {
        long j10;
        int iH;
        if (cVar.i() != f35506l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f35503i;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            iH = cVar.h();
            cVar.r(this.f35513g.b((int) (2097151 & j10)));
        } while (!f35503i.compareAndSet(this, j10, ((2097152 + j10) & (-2097152)) | ((long) iH)));
        return true;
    }

    public final void O(@NotNull c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f35503i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iB = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (iB == i10) {
                iB = i11 == 0 ? B(cVar) : i11;
            }
            if (iB >= 0 && f35503i.compareAndSet(this, j10, j11 | ((long) iB))) {
                return;
            }
        }
    }

    public final void R(@NotNull h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void S(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = w9.a.f35505k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            w9.a$c r0 = r7.q()
            u9.c0<w9.a$c> r1 = r7.f35513g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = a()     // Catch: java.lang.Throwable -> L87
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L87
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L49
            r1 = r2
        L23:
            u9.c0<w9.a$c> r4 = r7.f35513g
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.t.f(r4)
            w9.a$c r4 = (w9.a.c) r4
            if (r4 == r0) goto L44
        L30:
            boolean r5 = r4.isAlive()
            if (r5 == 0) goto L3d
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L30
        L3d:
            w9.n r4 = r4.f35516a
            w9.d r5 = r7.f35512f
            r4.f(r5)
        L44:
            if (r1 == r3) goto L49
            int r1 = r1 + 1
            goto L23
        L49:
            w9.d r8 = r7.f35512f
            r8.b()
            w9.d r8 = r7.f35511e
            r8.b()
        L53:
            if (r0 == 0) goto L5b
            w9.h r8 = r0.g(r2)
            if (r8 != 0) goto L83
        L5b:
            w9.d r8 = r7.f35511e
            java.lang.Object r8 = r8.d()
            w9.h r8 = (w9.h) r8
            if (r8 != 0) goto L83
            w9.d r8 = r7.f35512f
            java.lang.Object r8 = r8.d()
            w9.h r8 = (w9.h) r8
            if (r8 != 0) goto L83
            if (r0 == 0) goto L76
            w9.a$d r8 = w9.a.d.TERMINATED
            r0.u(r8)
        L76:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = w9.a.f35503i
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = w9.a.f35504j
            r8.set(r7, r0)
            return
        L83:
            r7.R(r8)
            goto L53
        L87:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: w9.a.S(long):void");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        S(10000L);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NotNull Runnable runnable) {
        z(this, runnable, null, false, 6, null);
    }

    public final void h0() {
        if (J0() || I0(this, 0L, 1, null)) {
            return;
        }
        J0();
    }

    public final boolean isTerminated() {
        return f35505k.get(this) != 0;
    }

    @NotNull
    public final h n(@NotNull Runnable runnable, @NotNull i iVar) {
        long jA = l.f35548f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, jA, iVar);
        }
        h hVar = (h) runnable;
        hVar.f35539a = jA;
        hVar.f35540b = iVar;
        return hVar;
    }

    @NotNull
    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f35513g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVarB = this.f35513g.b(i15);
            if (cVarB != null) {
                int iE = cVarB.f35516a.e();
                int i16 = b.f35514a[cVarB.f35518c.ordinal()];
                if (i16 == 1) {
                    i12++;
                } else if (i16 == 2) {
                    i11++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iE);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i16 == 3) {
                    i10++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iE);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i16 == 4) {
                    i13++;
                    if (iE > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iE);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i16 == 5) {
                    i14++;
                }
            }
        }
        long j10 = f35504j.get(this);
        return this.f35510d + '@' + s0.b(this) + "[Pool Size {core = " + this.f35507a + ", max = " + this.f35508b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f35511e.c() + ", global blocking queue size = " + this.f35512f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f35507a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final void x(@NotNull Runnable runnable, @NotNull i iVar, boolean z10) {
        kotlinx.coroutines.c.a();
        h hVarN = n(runnable, iVar);
        boolean z11 = false;
        boolean z12 = hVarN.f35540b.b() == 1;
        long jAddAndGet = z12 ? f35504j.addAndGet(this, 2097152L) : 0L;
        c cVarQ = q();
        h hVarI0 = i0(cVarQ, hVarN, z10);
        if (hVarI0 != null && !c(hVarI0)) {
            throw new RejectedExecutionException(this.f35510d + " was terminated");
        }
        if (z10 && cVarQ != null) {
            z11 = true;
        }
        if (z12) {
            W(jAddAndGet, z11);
        } else {
            if (z11) {
                return;
            }
            h0();
        }
    }

    /* JADX INFO: compiled from: CoroutineScheduler.kt */
    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NotNull
        private static final AtomicIntegerFieldUpdater f35515i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public final n f35516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final n0<h> f35517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public d f35518c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f35519d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private long f35520e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f35521f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f35522g;
        private volatile int indexInArray;

        @Nullable
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        private c() {
            setDaemon(true);
            this.f35516a = new n();
            this.f35517b = new n0<>();
            this.f35518c = d.DORMANT;
            this.nextParkedWorker = a.f35506l;
            this.f35521f = l9.c.f30972a.c();
        }

        private final void b(int i10) {
            if (i10 == 0) {
                return;
            }
            a.f35504j.addAndGet(a.this, -2097152L);
            if (this.f35518c != d.TERMINATED) {
                this.f35518c = d.DORMANT;
            }
        }

        private final void c(int i10) {
            if (i10 != 0 && u(d.BLOCKING)) {
                a.this.h0();
            }
        }

        private final void d(h hVar) {
            int iB = hVar.f35540b.b();
            k(iB);
            c(iB);
            a.this.R(hVar);
            b(iB);
        }

        private final h e(boolean z10) {
            h hVarO;
            h hVarO2;
            if (z10) {
                boolean z11 = m(a.this.f35507a * 2) == 0;
                if (z11 && (hVarO2 = o()) != null) {
                    return hVarO2;
                }
                h hVarG = this.f35516a.g();
                if (hVarG != null) {
                    return hVarG;
                }
                if (!z11 && (hVarO = o()) != null) {
                    return hVarO;
                }
            } else {
                h hVarO3 = o();
                if (hVarO3 != null) {
                    return hVarO3;
                }
            }
            return v(3);
        }

        private final h f() {
            h hVarH = this.f35516a.h();
            if (hVarH != null) {
                return hVarH;
            }
            h hVarD = a.this.f35512f.d();
            return hVarD == null ? v(1) : hVarD;
        }

        @NotNull
        public static final AtomicIntegerFieldUpdater j() {
            return f35515i;
        }

        private final void k(int i10) {
            this.f35519d = 0L;
            if (this.f35518c == d.PARKING) {
                this.f35518c = d.BLOCKING;
            }
        }

        private final boolean l() {
            return this.nextParkedWorker != a.f35506l;
        }

        private final void n() {
            if (this.f35519d == 0) {
                this.f35519d = System.nanoTime() + a.this.f35509c;
            }
            LockSupport.parkNanos(a.this.f35509c);
            if (System.nanoTime() - this.f35519d >= 0) {
                this.f35519d = 0L;
                w();
            }
        }

        private final h o() {
            if (m(2) == 0) {
                h hVarD = a.this.f35511e.d();
                return hVarD != null ? hVarD : a.this.f35512f.d();
            }
            h hVarD2 = a.this.f35512f.d();
            return hVarD2 != null ? hVarD2 : a.this.f35511e.d();
        }

        private final void p() {
            loop0: while (true) {
                boolean z10 = false;
                while (!a.this.isTerminated() && this.f35518c != d.TERMINATED) {
                    h hVarG = g(this.f35522g);
                    if (hVarG != null) {
                        this.f35520e = 0L;
                        d(hVarG);
                    } else {
                        this.f35522g = false;
                        if (this.f35520e == 0) {
                            t();
                        } else if (z10) {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f35520e);
                            this.f35520e = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
                break loop0;
            }
            u(d.TERMINATED);
        }

        private final boolean s() {
            boolean z10;
            if (this.f35518c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f35504j;
            while (true) {
                long j10 = atomicLongFieldUpdater.get(aVar);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    z10 = false;
                    break;
                }
                if (a.f35504j.compareAndSet(aVar, j10, j10 - 4398046511104L)) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                return false;
            }
            this.f35518c = d.CPU_ACQUIRED;
            return true;
        }

        private final void t() {
            if (!l()) {
                a.this.L(this);
                return;
            }
            f35515i.set(this, -1);
            while (l() && f35515i.get(this) == -1 && !a.this.isTerminated() && this.f35518c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        private final h v(int i10) {
            int i11 = (int) (a.f35504j.get(a.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int iM = m(i11);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                iM++;
                if (iM > i11) {
                    iM = 1;
                }
                c cVarB = aVar.f35513g.b(iM);
                if (cVarB != null && cVarB != this) {
                    long jN = cVarB.f35516a.n(i10, this.f35517b);
                    if (jN == -1) {
                        n0<h> n0Var = this.f35517b;
                        h hVar = n0Var.f29834a;
                        n0Var.f29834a = null;
                        return hVar;
                    }
                    if (jN > 0) {
                        jMin = Math.min(jMin, jN);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f35520e = jMin;
            return null;
        }

        private final void w() {
            a aVar = a.this;
            synchronized (aVar.f35513g) {
                if (aVar.isTerminated()) {
                    return;
                }
                if (((int) (a.f35504j.get(aVar) & 2097151)) <= aVar.f35507a) {
                    return;
                }
                if (f35515i.compareAndSet(this, -1, 1)) {
                    int i10 = this.indexInArray;
                    q(0);
                    aVar.O(this, i10, 0);
                    int andDecrement = (int) (a.f35504j.getAndDecrement(aVar) & 2097151);
                    if (andDecrement != i10) {
                        c cVarB = aVar.f35513g.b(andDecrement);
                        t.f(cVarB);
                        c cVar = cVarB;
                        aVar.f35513g.c(i10, cVar);
                        cVar.q(i10);
                        aVar.O(cVar, andDecrement, i10);
                    }
                    aVar.f35513g.c(andDecrement, null);
                    k0 k0Var = k0.f35197a;
                    this.f35518c = d.TERMINATED;
                }
            }
        }

        @Nullable
        public final h g(boolean z10) {
            return s() ? e(z10) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        @Nullable
        public final Object i() {
            return this.nextParkedWorker;
        }

        public final int m(int i10) {
            int i11 = this.f35521f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f35521f = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & Integer.MAX_VALUE) % i10;
        }

        public final void q(int i10) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f35510d);
            sb.append("-worker-");
            sb.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb.toString());
            this.indexInArray = i10;
        }

        public final void r(@Nullable Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean u(@NotNull d dVar) {
            d dVar2 = this.f35518c;
            boolean z10 = dVar2 == d.CPU_ACQUIRED;
            if (z10) {
                a.f35504j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f35518c = dVar;
            }
            return z10;
        }

        public c(a aVar, int i10) {
            this();
            q(i10);
        }
    }
}
