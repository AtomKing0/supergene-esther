package y9;

import androidx.media3.extractor.text.ttml.TtmlNode;
import h9.l;
import h9.p;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.h;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.j3;
import kotlinx.coroutines.o;
import kotlinx.coroutines.r;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;
import u9.f0;
import v8.k0;

/* JADX INFO: compiled from: Semaphore.kt */
/* JADX INFO: loaded from: classes5.dex */
public class e implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f36917c = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, TtmlNode.TAG_HEAD);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f36918d = AtomicLongFieldUpdater.newUpdater(e.class, "deqIdx");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f36919e = AtomicReferenceFieldUpdater.newUpdater(e.class, Object.class, "tail");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f36920f = AtomicLongFieldUpdater.newUpdater(e.class, "enqIdx");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f36921g = AtomicIntegerFieldUpdater.newUpdater(e.class, "_availablePermits");
    private volatile int _availablePermits;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f36922a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final l<Throwable, k0> f36923b;
    private volatile long deqIdx;
    private volatile long enqIdx;

    @Nullable
    private volatile Object head;

    @Nullable
    private volatile Object tail;

    /* JADX INFO: compiled from: Semaphore.kt */
    /* synthetic */ class a extends q implements p<Long, g, g> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f36924b = new a();

        a() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @NotNull
        public final g a(long j10, @Nullable g gVar) {
            return f.j(j10, gVar);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ g mo4invoke(Long l10, g gVar) {
            return a(l10.longValue(), gVar);
        }
    }

    /* JADX INFO: compiled from: Semaphore.kt */
    static final class b extends v implements l<Throwable, k0> {
        b() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull Throwable th) {
            e.this.release();
        }
    }

    /* JADX INFO: compiled from: Semaphore.kt */
    /* synthetic */ class c extends q implements p<Long, g, g> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f36926b = new c();

        c() {
            super(2, f.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
        }

        @NotNull
        public final g a(long j10, @Nullable g gVar) {
            return f.j(j10, gVar);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ g mo4invoke(Long l10, g gVar) {
            return a(l10.longValue(), gVar);
        }
    }

    public e(int i10, int i11) {
        this.f36922a = i10;
        if (!(i10 > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + i10).toString());
        }
        if (!(i11 >= 0 && i11 <= i10)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + i10).toString());
        }
        g gVar = new g(0L, null, 2);
        this.head = gVar;
        this.tail = gVar;
        this._availablePermits = i10 - i11;
        this.f36923b = new b();
    }

    static /* synthetic */ Object j(e eVar, z8.d<? super k0> dVar) throws Throwable {
        if (eVar.n() > 0) {
            return k0.f35197a;
        }
        Object objK = eVar.k(dVar);
        return objK == a9.d.e() ? objK : k0.f35197a;
    }

    private final Object k(z8.d<? super k0> dVar) throws Throwable {
        kotlinx.coroutines.p pVarB = r.b(a9.c.c(dVar));
        try {
            if (!l(pVarB)) {
                i(pVarB);
            }
            Object objZ = pVarB.z();
            if (objZ == a9.d.e()) {
                h.c(dVar);
            }
            return objZ == a9.d.e() ? objZ : k0.f35197a;
        } catch (Throwable th) {
            pVarB.K();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean l(j3 j3Var) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36919e;
        g gVar = (g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f36920f.getAndIncrement(this);
        a aVar = a.f36924b;
        long j10 = andIncrement / ((long) f.f36932f);
        do {
            objC = u9.d.c(gVar, j10, aVar);
            if (f0.c(objC)) {
                break;
            }
            e0 e0VarB = f0.b(objC);
            while (true) {
                e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                if (e0Var.f34654c >= e0VarB.f34654c) {
                    break;
                }
                if (!e0VarB.q()) {
                    z10 = false;
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, e0Var, e0VarB)) {
                    if (e0Var.m()) {
                        e0Var.k();
                    }
                } else if (e0VarB.m()) {
                    e0VarB.k();
                }
            }
            z10 = true;
        } while (!z10);
        g gVar2 = (g) f0.b(objC);
        int i10 = (int) (andIncrement % ((long) f.f36932f));
        if (s8.c.a(gVar2.r(), i10, null, j3Var)) {
            j3Var.a(gVar2, i10);
            return true;
        }
        if (!s8.c.a(gVar2.r(), i10, f.f36928b, f.f36929c)) {
            return false;
        }
        if (j3Var instanceof o) {
            t.g(j3Var, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((o) j3Var).l(k0.f35197a, this.f36923b);
            return true;
        }
        if (j3Var instanceof x9.b) {
            ((x9.b) j3Var).b(k0.f35197a);
            return true;
        }
        throw new IllegalStateException(("unexpected: " + j3Var).toString());
    }

    private final void m() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i10;
        int i11;
        do {
            atomicIntegerFieldUpdater = f36921g;
            i10 = atomicIntegerFieldUpdater.get(this);
            i11 = this.f36922a;
            if (i10 <= i11) {
                return;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i10, i11));
    }

    private final int n() {
        int andDecrement;
        do {
            andDecrement = f36921g.getAndDecrement(this);
        } while (andDecrement > this.f36922a);
        return andDecrement;
    }

    private final boolean o(Object obj) {
        if (!(obj instanceof o)) {
            if (obj instanceof x9.b) {
                return ((x9.b) obj).c(this, k0.f35197a);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        o oVar = (o) obj;
        Object objK = oVar.k(k0.f35197a, null, this.f36923b);
        if (objK == null) {
            return false;
        }
        oVar.u(objK);
        return true;
    }

    private final boolean p() {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f36917c;
        g gVar = (g) atomicReferenceFieldUpdater.get(this);
        long andIncrement = f36918d.getAndIncrement(this);
        long j10 = andIncrement / ((long) f.f36932f);
        c cVar = c.f36926b;
        do {
            objC = u9.d.c(gVar, j10, cVar);
            if (f0.c(objC)) {
                break;
            }
            e0 e0VarB = f0.b(objC);
            while (true) {
                e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                if (e0Var.f34654c >= e0VarB.f34654c) {
                    break;
                }
                if (!e0VarB.q()) {
                    z10 = false;
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, e0Var, e0VarB)) {
                    if (e0Var.m()) {
                        e0Var.k();
                    }
                } else if (e0VarB.m()) {
                    e0VarB.k();
                }
            }
            z10 = true;
        } while (!z10);
        g gVar2 = (g) f0.b(objC);
        gVar2.b();
        if (gVar2.f34654c > j10) {
            return false;
        }
        int i10 = (int) (andIncrement % ((long) f.f36932f));
        Object andSet = gVar2.r().getAndSet(i10, f.f36928b);
        if (andSet != null) {
            if (andSet == f.f36931e) {
                return false;
            }
            return o(andSet);
        }
        int i11 = f.f36927a;
        for (int i12 = 0; i12 < i11; i12++) {
            if (gVar2.r().get(i10) == f.f36929c) {
                return true;
            }
        }
        return !s8.c.a(gVar2.r(), i10, f.f36928b, f.f36930d);
    }

    @Override // y9.d
    @Nullable
    public Object a(@NotNull z8.d<? super k0> dVar) {
        return j(this, dVar);
    }

    @Override // y9.d
    public int b() {
        return Math.max(f36921g.get(this), 0);
    }

    @Override // y9.d
    public boolean c() {
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f36921g;
            int i10 = atomicIntegerFieldUpdater.get(this);
            if (i10 > this.f36922a) {
                m();
            } else {
                if (i10 <= 0) {
                    return false;
                }
                if (atomicIntegerFieldUpdater.compareAndSet(this, i10, i10 - 1)) {
                    return true;
                }
            }
        }
    }

    protected final void i(@NotNull o<? super k0> oVar) {
        while (n() <= 0) {
            t.g(oVar, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (l((j3) oVar)) {
                return;
            }
        }
        oVar.l(k0.f35197a, this.f36923b);
    }

    @Override // y9.d
    public void release() {
        do {
            int andIncrement = f36921g.getAndIncrement(this);
            if (andIncrement >= this.f36922a) {
                m();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.f36922a).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!p());
    }
}
