package r9;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.j3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.e0;
import u9.f0;
import u9.g0;
import u9.s0;
import u9.z;
import v8.k0;
import v8.t;

/* JADX INFO: compiled from: BufferedChannel.kt */
/* JADX INFO: loaded from: classes5.dex */
public class b<E> implements r9.d<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f33338d = AtomicLongFieldUpdater.newUpdater(b.class, "sendersAndCloseStatus");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f33339e = AtomicLongFieldUpdater.newUpdater(b.class, "receivers");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f33340f = AtomicLongFieldUpdater.newUpdater(b.class, "bufferEnd");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private static final AtomicLongFieldUpdater f33341g = AtomicLongFieldUpdater.newUpdater(b.class, "completedExpandBuffersAndPauseFlag");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33342h = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "sendSegment");

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33343i = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "receiveSegment");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33344j = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "bufferEndSegment");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33345k = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_closeCause");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f33346l = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "closeHandler");

    @Nullable
    private volatile Object _closeCause;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f33347a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final h9.l<E, k0> f33348b;
    private volatile long bufferEnd;

    @Nullable
    private volatile Object bufferEndSegment;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final h9.q<x9.b<?>, Object, Object, h9.l<Throwable, k0>> f33349c;

    @Nullable
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;

    @Nullable
    private volatile Object receiveSegment;
    private volatile long receivers;

    @Nullable
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    /* JADX INFO: compiled from: BufferedChannel.kt */
    private final class a implements f<E>, j3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private Object f33350a = r9.c.f33384p;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private kotlinx.coroutines.p<? super Boolean> f33351b;

        public a() {
        }

        private final Object f(i<E> iVar, int i10, long j10, z8.d<? super Boolean> dVar) throws Throwable {
            Boolean boolA;
            b<E> bVar = b.this;
            kotlinx.coroutines.p pVarB = kotlinx.coroutines.r.b(a9.c.c(dVar));
            try {
                this.f33351b = pVarB;
                Object objG0 = bVar.G0(iVar, i10, j10, this);
                if (objG0 == r9.c.f33381m) {
                    bVar.p0(this, iVar, i10);
                } else {
                    h9.l<Throwable, k0> lVarA = null;
                    if (objG0 == r9.c.f33383o) {
                        if (j10 < bVar.R()) {
                            iVar.b();
                        }
                        i iVar2 = (i) b.f33343i.get(bVar);
                        while (true) {
                            if (bVar.Y()) {
                                h();
                                break;
                            }
                            long andIncrement = b.f33339e.getAndIncrement(bVar);
                            int i11 = r9.c.f33370b;
                            long j11 = andIncrement / ((long) i11);
                            int i12 = (int) (andIncrement % ((long) i11));
                            if (iVar2.f34654c != j11) {
                                i iVarK = bVar.K(j11, iVar2);
                                if (iVarK != null) {
                                    iVar2 = iVarK;
                                }
                            }
                            Object objG02 = bVar.G0(iVar2, i12, andIncrement, this);
                            if (objG02 == r9.c.f33381m) {
                                bVar.p0(this, iVar2, i12);
                                break;
                            }
                            if (objG02 == r9.c.f33383o) {
                                if (andIncrement < bVar.R()) {
                                    iVar2.b();
                                }
                            } else {
                                if (objG02 == r9.c.f33382n) {
                                    throw new IllegalStateException("unexpected".toString());
                                }
                                iVar2.b();
                                this.f33350a = objG02;
                                this.f33351b = null;
                                boolA = kotlin.coroutines.jvm.internal.b.a(true);
                                h9.l<E, k0> lVar = bVar.f33348b;
                                if (lVar != null) {
                                    lVarA = z.a(lVar, objG02, pVarB.getContext());
                                }
                            }
                        }
                    } else {
                        iVar.b();
                        this.f33350a = objG0;
                        this.f33351b = null;
                        boolA = kotlin.coroutines.jvm.internal.b.a(true);
                        h9.l<E, k0> lVar2 = bVar.f33348b;
                        if (lVar2 != null) {
                            lVarA = z.a(lVar2, objG0, pVarB.getContext());
                        }
                    }
                    pVarB.l(boolA, lVarA);
                }
                Object objZ = pVarB.z();
                if (objZ == a9.d.e()) {
                    kotlin.coroutines.jvm.internal.h.c(dVar);
                }
                return objZ;
            } catch (Throwable th) {
                pVarB.K();
                throw th;
            }
        }

        private final boolean g() throws Throwable {
            this.f33350a = r9.c.z();
            Throwable thN = b.this.N();
            if (thN == null) {
                return false;
            }
            throw g0.a(thN);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h() {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f33351b;
            kotlin.jvm.internal.t.f(pVar);
            this.f33351b = null;
            this.f33350a = r9.c.z();
            Throwable thN = b.this.N();
            if (thN == null) {
                t.a aVar = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(Boolean.FALSE));
            } else {
                t.a aVar2 = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(v8.u.a(thN)));
            }
        }

        @Override // kotlinx.coroutines.j3
        public void a(@NotNull e0<?> e0Var, int i10) {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f33351b;
            if (pVar != null) {
                pVar.a(e0Var, i10);
            }
        }

        @Override // r9.f
        @Nullable
        public Object b(@NotNull z8.d<? super Boolean> dVar) {
            i<E> iVar;
            b<E> bVar = b.this;
            i<E> iVar2 = (i) b.f33343i.get(bVar);
            while (!bVar.Y()) {
                long andIncrement = b.f33339e.getAndIncrement(bVar);
                int i10 = r9.c.f33370b;
                long j10 = andIncrement / ((long) i10);
                int i11 = (int) (andIncrement % ((long) i10));
                if (iVar2.f34654c != j10) {
                    i<E> iVarK = bVar.K(j10, iVar2);
                    if (iVarK == null) {
                        continue;
                    } else {
                        iVar = iVarK;
                    }
                } else {
                    iVar = iVar2;
                }
                Object objG0 = bVar.G0(iVar, i11, andIncrement, null);
                if (objG0 == r9.c.f33381m) {
                    throw new IllegalStateException("unreachable".toString());
                }
                if (objG0 != r9.c.f33383o) {
                    if (objG0 == r9.c.f33382n) {
                        return f(iVar, i11, andIncrement, dVar);
                    }
                    iVar.b();
                    this.f33350a = objG0;
                    return kotlin.coroutines.jvm.internal.b.a(true);
                }
                if (andIncrement < bVar.R()) {
                    iVar.b();
                }
                iVar2 = iVar;
            }
            return kotlin.coroutines.jvm.internal.b.a(g());
        }

        public final boolean i(E e10) {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f33351b;
            kotlin.jvm.internal.t.f(pVar);
            this.f33351b = null;
            this.f33350a = e10;
            Boolean bool = Boolean.TRUE;
            h9.l<E, k0> lVar = b.this.f33348b;
            return r9.c.B(pVar, bool, lVar != null ? z.a(lVar, e10, pVar.getContext()) : null);
        }

        public final void j() {
            kotlinx.coroutines.p<? super Boolean> pVar = this.f33351b;
            kotlin.jvm.internal.t.f(pVar);
            this.f33351b = null;
            this.f33350a = r9.c.z();
            Throwable thN = b.this.N();
            if (thN == null) {
                t.a aVar = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(Boolean.FALSE));
            } else {
                t.a aVar2 = v8.t.f35208b;
                pVar.resumeWith(v8.t.b(v8.u.a(thN)));
            }
        }

        @Override // r9.f
        public E next() throws Throwable {
            E e10 = (E) this.f33350a;
            if (!(e10 != r9.c.f33384p)) {
                throw new IllegalStateException("`hasNext()` has not been invoked".toString());
            }
            this.f33350a = r9.c.f33384p;
            if (e10 != r9.c.z()) {
                return e10;
            }
            throw g0.a(b.this.O());
        }
    }

    /* JADX INFO: renamed from: r9.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BufferedChannel.kt */
    private static final class C0666b implements j3 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final kotlinx.coroutines.o<Boolean> f33353a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final /* synthetic */ kotlinx.coroutines.p<Boolean> f33354b;

        @Override // kotlinx.coroutines.j3
        public void a(@NotNull e0<?> e0Var, int i10) {
            this.f33354b.a(e0Var, i10);
        }

        @NotNull
        public final kotlinx.coroutines.o<Boolean> b() {
            return this.f33353a;
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    static final class c extends kotlin.jvm.internal.v implements h9.q<x9.b<?>, Object, Object, h9.l<? super Throwable, ? extends k0>> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b<E> f33355g;

        /* JADX INFO: compiled from: BufferedChannel.kt */
        static final class a extends kotlin.jvm.internal.v implements h9.l<Throwable, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            final /* synthetic */ Object f33356g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            final /* synthetic */ b<E> f33357h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            final /* synthetic */ x9.b<?> f33358i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Object obj, b<E> bVar, x9.b<?> bVar2) {
                super(1);
                this.f33356g = obj;
                this.f33357h = bVar;
                this.f33358i = bVar2;
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
                invoke2(th);
                return k0.f35197a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Throwable th) {
                if (this.f33356g != r9.c.z()) {
                    z.b(this.f33357h.f33348b, this.f33356g, this.f33358i.getContext());
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(b<E> bVar) {
            super(3);
            this.f33355g = bVar;
        }

        @Override // h9.q
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final h9.l<Throwable, k0> invoke(@NotNull x9.b<?> bVar, @Nullable Object obj, @Nullable Object obj2) {
            return new a(obj2, this.f33355g, bVar);
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {739}, m = "receiveCatching-JP2dKIU$suspendImpl")
    static final class d<E> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f33359j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ b<E> f33360k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33361l;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(b<E> bVar, z8.d<? super d> dVar) {
            super(dVar);
            this.f33360k = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            this.f33359j = obj;
            this.f33361l |= Integer.MIN_VALUE;
            Object objS0 = b.s0(this.f33360k, this);
            return objS0 == a9.d.e() ? objS0 : h.b(objS0);
        }
    }

    /* JADX INFO: compiled from: BufferedChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.channels.BufferedChannel", f = "BufferedChannel.kt", l = {3056}, m = "receiveCatchingOnNoWaiterSuspend-GKJJFZk")
    static final class e extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33362j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33363k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33364l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f33365m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f33366n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ b<E> f33367o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f33368p;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(b<E> bVar, z8.d<? super e> dVar) {
            super(dVar);
            this.f33367o = bVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) throws Throwable {
            this.f33366n = obj;
            this.f33368p |= Integer.MIN_VALUE;
            Object objT0 = this.f33367o.t0(null, 0, 0L, this);
            return objT0 == a9.d.e() ? objT0 : h.b(objT0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(int i10, @Nullable h9.l<? super E, k0> lVar) {
        this.f33347a = i10;
        this.f33348b = lVar;
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i10 + ", should be >=0").toString());
        }
        this.bufferEnd = r9.c.A(i10);
        this.completedExpandBuffersAndPauseFlag = M();
        i iVar = new i(0L, null, this, 3);
        this.sendSegment = iVar;
        this.receiveSegment = iVar;
        if (c0()) {
            iVar = r9.c.f33369a;
            kotlin.jvm.internal.t.g(iVar, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = iVar;
        this.f33349c = lVar != 0 ? new c(this) : null;
        this._closeCause = r9.c.f33387s;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0122 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.Object A0(r9.i<E> r21, int r22, E r23, long r24, z8.d<? super v8.k0> r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.A0(r9.i, int, java.lang.Object, long, z8.d):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void B(i<E> iVar, long j10) {
        Object objB = u9.n.b(null, 1, null);
        loop0: while (iVar != null) {
            for (int i10 = r9.c.f33370b - 1; -1 < i10; i10--) {
                if ((iVar.f34654c * ((long) r9.c.f33370b)) + ((long) i10) < j10) {
                    break loop0;
                }
                while (true) {
                    Object objW = iVar.w(i10);
                    if (objW != null && objW != r9.c.f33373e) {
                        if (!(objW instanceof v)) {
                            if (!(objW instanceof j3)) {
                                break;
                            }
                            if (iVar.r(i10, objW, r9.c.z())) {
                                objB = u9.n.c(objB, objW);
                                iVar.x(i10, true);
                                break;
                            }
                        } else {
                            if (iVar.r(i10, objW, r9.c.z())) {
                                objB = u9.n.c(objB, ((v) objW).f33410a);
                                iVar.x(i10, true);
                                break;
                            }
                        }
                    } else {
                        if (iVar.r(i10, objW, r9.c.z())) {
                            iVar.p();
                            break;
                        }
                    }
                }
            }
            iVar = (i) iVar.g();
        }
        if (objB != null) {
            if (!(objB instanceof ArrayList)) {
                w0((j3) objB);
                return;
            }
            kotlin.jvm.internal.t.g(objB, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            ArrayList arrayList = (ArrayList) objB;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                w0((j3) arrayList.get(size));
            }
        }
    }

    private final boolean B0(long j10) {
        if (a0(j10)) {
            return false;
        }
        return !z(j10 & 1152921504606846975L);
    }

    private final i<E> C() {
        Object obj = f33344j.get(this);
        i iVar = (i) f33342h.get(this);
        if (iVar.f34654c > ((i) obj).f34654c) {
            obj = iVar;
        }
        i iVar2 = (i) f33343i.get(this);
        if (iVar2.f34654c > ((i) obj).f34654c) {
            obj = iVar2;
        }
        return (i) u9.d.b((u9.e) obj);
    }

    private final boolean C0(Object obj, E e10) {
        if (obj instanceof x9.b) {
            return ((x9.b) obj).c(this, e10);
        }
        if (obj instanceof s) {
            kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            s sVar = (s) obj;
            kotlinx.coroutines.p<h<? extends E>> pVar = sVar.f33409a;
            h hVarB = h.b(h.f33392b.c(e10));
            h9.l<E, k0> lVar = this.f33348b;
            return r9.c.B(pVar, hVarB, lVar != null ? z.a(lVar, e10, sVar.f33409a.getContext()) : null);
        }
        if (obj instanceof a) {
            kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((a) obj).i(e10);
        }
        if (obj instanceof kotlinx.coroutines.o) {
            kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            kotlinx.coroutines.o oVar = (kotlinx.coroutines.o) obj;
            h9.l<E, k0> lVar2 = this.f33348b;
            return r9.c.B(oVar, e10, lVar2 != null ? z.a(lVar2, e10, oVar.getContext()) : null);
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean D0(Object obj, i<E> iVar, int i10) {
        if (obj instanceof kotlinx.coroutines.o) {
            kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return r9.c.C((kotlinx.coroutines.o) obj, k0.f35197a, null, 2, null);
        }
        if (obj instanceof x9.b) {
            kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            x9.d dVarF = ((x9.a) obj).f(this, k0.f35197a);
            if (dVarF == x9.d.REREGISTER) {
                iVar.s(i10);
            }
            return dVarF == x9.d.SUCCESSFUL;
        }
        if (obj instanceof C0666b) {
            return r9.c.C(((C0666b) obj).b(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final void E(long j10) {
        v0(F(j10));
    }

    private final boolean E0(i<E> iVar, int i10, long j10) {
        Object objW = iVar.w(i10);
        if (!(objW instanceof j3) || j10 < f33339e.get(this) || !iVar.r(i10, objW, r9.c.f33375g)) {
            return F0(iVar, i10, j10);
        }
        if (D0(objW, iVar, i10)) {
            iVar.A(i10, r9.c.f33372d);
            return true;
        }
        iVar.A(i10, r9.c.f33378j);
        iVar.x(i10, false);
        return false;
    }

    private final i<E> F(long j10) {
        i<E> iVarC = C();
        if (b0()) {
            long jD0 = d0(iVarC);
            if (jD0 != -1) {
                H(jD0);
            }
        }
        B(iVarC, j10);
        return iVarC;
    }

    private final boolean F0(i<E> iVar, int i10, long j10) {
        while (true) {
            Object objW = iVar.w(i10);
            if (objW instanceof j3) {
                if (j10 < f33339e.get(this)) {
                    if (iVar.r(i10, objW, new v((j3) objW))) {
                        return true;
                    }
                } else if (iVar.r(i10, objW, r9.c.f33375g)) {
                    if (D0(objW, iVar, i10)) {
                        iVar.A(i10, r9.c.f33372d);
                        return true;
                    }
                    iVar.A(i10, r9.c.f33378j);
                    iVar.x(i10, false);
                    return false;
                }
            } else {
                if (objW == r9.c.f33378j) {
                    return false;
                }
                if (objW == null) {
                    if (iVar.r(i10, objW, r9.c.f33373e)) {
                        return true;
                    }
                } else {
                    if (objW == r9.c.f33372d || objW == r9.c.f33376h || objW == r9.c.f33377i || objW == r9.c.f33379k || objW == r9.c.z()) {
                        return true;
                    }
                    if (objW != r9.c.f33374f) {
                        throw new IllegalStateException(("Unexpected cell state: " + objW).toString());
                    }
                }
            }
        }
    }

    private final void G() {
        t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object G0(i<E> iVar, int i10, long j10, Object obj) {
        Object objW = iVar.w(i10);
        if (objW == null) {
            if (j10 >= (f33338d.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return r9.c.f33382n;
                }
                if (iVar.r(i10, objW, obj)) {
                    I();
                    return r9.c.f33381m;
                }
            }
        } else if (objW == r9.c.f33372d && iVar.r(i10, objW, r9.c.f33377i)) {
            I();
            return iVar.y(i10);
        }
        return H0(iVar, i10, j10, obj);
    }

    private final Object H0(i<E> iVar, int i10, long j10, Object obj) {
        while (true) {
            Object objW = iVar.w(i10);
            if (objW == null || objW == r9.c.f33373e) {
                if (j10 < (f33338d.get(this) & 1152921504606846975L)) {
                    if (iVar.r(i10, objW, r9.c.f33376h)) {
                        I();
                        return r9.c.f33383o;
                    }
                } else {
                    if (obj == null) {
                        return r9.c.f33382n;
                    }
                    if (iVar.r(i10, objW, obj)) {
                        I();
                        return r9.c.f33381m;
                    }
                }
            } else {
                if (objW != r9.c.f33372d) {
                    if (objW != r9.c.f33378j && objW != r9.c.f33376h) {
                        if (objW == r9.c.z()) {
                            I();
                            return r9.c.f33383o;
                        }
                        if (objW != r9.c.f33375g && iVar.r(i10, objW, r9.c.f33374f)) {
                            boolean z10 = objW instanceof v;
                            if (z10) {
                                objW = ((v) objW).f33410a;
                            }
                            if (D0(objW, iVar, i10)) {
                                iVar.A(i10, r9.c.f33377i);
                                I();
                                return iVar.y(i10);
                            }
                            iVar.A(i10, r9.c.f33378j);
                            iVar.x(i10, false);
                            if (z10) {
                                I();
                            }
                            return r9.c.f33383o;
                        }
                    }
                    return r9.c.f33383o;
                }
                if (iVar.r(i10, objW, r9.c.f33377i)) {
                    I();
                    return iVar.y(i10);
                }
            }
        }
    }

    private final void I() {
        if (c0()) {
            return;
        }
        i<E> iVar = (i) f33344j.get(this);
        while (true) {
            long andIncrement = f33340f.getAndIncrement(this);
            int i10 = r9.c.f33370b;
            long j10 = andIncrement / ((long) i10);
            if (R() <= andIncrement) {
                if (iVar.f34654c < j10 && iVar.e() != 0) {
                    h0(j10, iVar);
                }
                U(this, 0L, 1, null);
                return;
            }
            if (iVar.f34654c != j10) {
                i<E> iVarJ = J(j10, iVar, andIncrement);
                if (iVarJ == null) {
                    continue;
                } else {
                    iVar = iVarJ;
                }
            }
            if (E0(iVar, (int) (andIncrement % ((long) i10)), andIncrement)) {
                U(this, 0L, 1, null);
                return;
            }
            U(this, 0L, 1, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int I0(i<E> iVar, int i10, E e10, long j10, Object obj, boolean z10) {
        iVar.B(i10, e10);
        if (z10) {
            return J0(iVar, i10, e10, j10, obj, z10);
        }
        Object objW = iVar.w(i10);
        if (objW == null) {
            if (z(j10)) {
                if (iVar.r(i10, null, r9.c.f33372d)) {
                    return 1;
                }
            } else {
                if (obj == null) {
                    return 3;
                }
                if (iVar.r(i10, null, obj)) {
                    return 2;
                }
            }
        } else if (objW instanceof j3) {
            iVar.s(i10);
            if (C0(objW, e10)) {
                iVar.A(i10, r9.c.f33377i);
                n0();
                return 0;
            }
            if (iVar.t(i10, r9.c.f33379k) != r9.c.f33379k) {
                iVar.x(i10, true);
            }
            return 5;
        }
        return J0(iVar, i10, e10, j10, obj, z10);
    }

    private final i<E> J(long j10, i<E> iVar, long j11) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33344j;
        h9.p pVar = (h9.p) r9.c.y();
        do {
            objC = u9.d.c(iVar, j10, pVar);
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
        if (f0.c(objC)) {
            G();
            h0(j10, iVar);
            U(this, 0L, 1, null);
            return null;
        }
        i<E> iVar2 = (i) f0.b(objC);
        long j12 = iVar2.f34654c;
        if (j12 <= j10) {
            return iVar2;
        }
        int i10 = r9.c.f33370b;
        if (f33340f.compareAndSet(this, j11 + 1, ((long) i10) * j12)) {
            T((iVar2.f34654c * ((long) i10)) - j11);
            return null;
        }
        U(this, 0L, 1, null);
        return null;
    }

    private final int J0(i<E> iVar, int i10, E e10, long j10, Object obj, boolean z10) {
        while (true) {
            Object objW = iVar.w(i10);
            if (objW == null) {
                if (!z(j10) || z10) {
                    if (z10) {
                        if (iVar.r(i10, null, r9.c.f33378j)) {
                            iVar.x(i10, false);
                            return 4;
                        }
                    } else {
                        if (obj == null) {
                            return 3;
                        }
                        if (iVar.r(i10, null, obj)) {
                            return 2;
                        }
                    }
                } else if (iVar.r(i10, null, r9.c.f33372d)) {
                    return 1;
                }
            } else {
                if (objW != r9.c.f33373e) {
                    if (objW == r9.c.f33379k) {
                        iVar.s(i10);
                        return 5;
                    }
                    if (objW == r9.c.f33376h) {
                        iVar.s(i10);
                        return 5;
                    }
                    if (objW == r9.c.z()) {
                        iVar.s(i10);
                        G();
                        return 4;
                    }
                    iVar.s(i10);
                    if (objW instanceof v) {
                        objW = ((v) objW).f33410a;
                    }
                    if (C0(objW, e10)) {
                        iVar.A(i10, r9.c.f33377i);
                        n0();
                        return 0;
                    }
                    if (iVar.t(i10, r9.c.f33379k) != r9.c.f33379k) {
                        iVar.x(i10, true);
                    }
                    return 5;
                }
                if (iVar.r(i10, objW, r9.c.f33372d)) {
                    return 1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i<E> K(long j10, i<E> iVar) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33343i;
        h9.p pVar = (h9.p) r9.c.y();
        do {
            objC = u9.d.c(iVar, j10, pVar);
            if (!f0.c(objC)) {
                e0 e0VarB = f0.b(objC);
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
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
            } else {
                break;
            }
        } while (!z10);
        if (f0.c(objC)) {
            G();
            if (iVar.f34654c * ((long) r9.c.f33370b) >= R()) {
                return null;
            }
            iVar.b();
            return null;
        }
        i<E> iVar2 = (i) f0.b(objC);
        if (!c0() && j10 <= M() / ((long) r9.c.f33370b)) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = f33344j;
            while (true) {
                e0 e0Var2 = (e0) atomicReferenceFieldUpdater2.get(this);
                if (e0Var2.f34654c >= iVar2.f34654c || !iVar2.q()) {
                    break;
                }
                if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater2, this, e0Var2, iVar2)) {
                    if (e0Var2.m()) {
                        e0Var2.k();
                    }
                } else if (iVar2.m()) {
                    iVar2.k();
                }
            }
        }
        long j11 = iVar2.f34654c;
        if (j11 <= j10) {
            return iVar2;
        }
        int i10 = r9.c.f33370b;
        K0(j11 * ((long) i10));
        if (iVar2.f34654c * ((long) i10) >= R()) {
            return null;
        }
        iVar2.b();
        return null;
    }

    private final void K0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f33339e;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            if (j11 >= j10) {
                return;
            }
        } while (!f33339e.compareAndSet(this, j11, j10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final i<E> L(long j10, i<E> iVar) {
        Object objC;
        boolean z10;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33342h;
        h9.p pVar = (h9.p) r9.c.y();
        do {
            objC = u9.d.c(iVar, j10, pVar);
            if (!f0.c(objC)) {
                e0 e0VarB = f0.b(objC);
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
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
            } else {
                break;
            }
        } while (!z10);
        if (f0.c(objC)) {
            G();
            if (iVar.f34654c * ((long) r9.c.f33370b) >= P()) {
                return null;
            }
            iVar.b();
            return null;
        }
        i<E> iVar2 = (i) f0.b(objC);
        long j11 = iVar2.f34654c;
        if (j11 <= j10) {
            return iVar2;
        }
        int i10 = r9.c.f33370b;
        L0(j11 * ((long) i10));
        if (iVar2.f34654c * ((long) i10) >= P()) {
            return null;
        }
        iVar2.b();
        return null;
    }

    private final void L0(long j10) {
        long j11;
        long j12;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f33338d;
        do {
            j11 = atomicLongFieldUpdater.get(this);
            j12 = 1152921504606846975L & j11;
            if (j12 >= j10) {
                return;
            }
        } while (!f33338d.compareAndSet(this, j11, r9.c.w(j12, (int) (j11 >> 60))));
    }

    private final long M() {
        return f33340f.get(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable O() {
        Throwable thN = N();
        return thN == null ? new m("Channel was closed") : thN;
    }

    private final void T(long j10) {
        if ((f33341g.addAndGet(this, j10) & 4611686018427387904L) != 0) {
            do {
            } while ((f33341g.get(this) & 4611686018427387904L) != 0);
        }
    }

    static /* synthetic */ void U(b bVar, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i10 & 1) != 0) {
            j10 = 1;
        }
        bVar.T(j10);
    }

    private final void V() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33346l;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, obj, obj == null ? r9.c.f33385q : r9.c.f33386r));
        if (obj == null) {
            return;
        }
        ((h9.l) obj).invoke(N());
    }

    private final boolean W(i<E> iVar, int i10, long j10) {
        Object objW;
        do {
            objW = iVar.w(i10);
            if (objW != null && objW != r9.c.f33373e) {
                if (objW == r9.c.f33372d) {
                    return true;
                }
                if (objW == r9.c.f33378j || objW == r9.c.z() || objW == r9.c.f33377i || objW == r9.c.f33376h) {
                    return false;
                }
                if (objW == r9.c.f33375g) {
                    return true;
                }
                return objW != r9.c.f33374f && j10 == P();
            }
        } while (!iVar.r(i10, objW, r9.c.f33376h));
        I();
        return false;
    }

    private final boolean X(long j10, boolean z10) {
        int i10 = (int) (j10 >> 60);
        if (i10 == 0 || i10 == 1) {
            return false;
        }
        if (i10 == 2) {
            F(j10 & 1152921504606846975L);
            if (z10 && S()) {
                return false;
            }
        } else {
            if (i10 != 3) {
                throw new IllegalStateException(("unexpected close status: " + i10).toString());
            }
            E(j10 & 1152921504606846975L);
        }
        return true;
    }

    private final boolean Z(long j10) {
        return X(j10, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean a0(long j10) {
        return X(j10, false);
    }

    private final boolean c0() {
        long jM = M();
        return jM == 0 || jM == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (r9.i) r8.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final long d0(r9.i<E> r8) {
        /*
            r7 = this;
        L0:
            int r0 = r9.c.f33370b
            int r0 = r0 + (-1)
        L4:
            r1 = -1
            r3 = -1
            if (r3 >= r0) goto L3c
            long r3 = r8.f34654c
            int r5 = r9.c.f33370b
            long r5 = (long) r5
            long r3 = r3 * r5
            long r5 = (long) r0
            long r3 = r3 + r5
            long r5 = r7.P()
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L1a
            return r1
        L1a:
            java.lang.Object r1 = r8.w(r0)
            if (r1 == 0) goto L2c
            u9.h0 r2 = r9.c.k()
            if (r1 != r2) goto L27
            goto L2c
        L27:
            u9.h0 r2 = r9.c.f33372d
            if (r1 != r2) goto L39
            return r3
        L2c:
            u9.h0 r2 = r9.c.z()
            boolean r1 = r8.r(r0, r1, r2)
            if (r1 == 0) goto L1a
            r8.p()
        L39:
            int r0 = r0 + (-1)
            goto L4
        L3c:
            u9.e r8 = r8.g()
            r9.i r8 = (r9.i) r8
            if (r8 != 0) goto L0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.d0(r9.i):long");
    }

    private final void e0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f33338d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            if (((int) (j10 >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, r9.c.w(1152921504606846975L & j10, 1)));
    }

    private final void f0() {
        long j10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f33338d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, r9.c.w(1152921504606846975L & j10, 3)));
    }

    private final void g0() {
        long j10;
        long jW;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f33338d;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            int i10 = (int) (j10 >> 60);
            if (i10 == 0) {
                jW = r9.c.w(j10 & 1152921504606846975L, 2);
            } else if (i10 != 1) {
                return;
            } else {
                jW = r9.c.w(j10 & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j10, jW));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void h0(long j10, i<E> iVar) {
        boolean z10;
        i<E> iVar2;
        i<E> iVar3;
        while (iVar.f34654c < j10 && (iVar3 = (i) iVar.e()) != null) {
            iVar = iVar3;
        }
        while (true) {
            if (!iVar.h() || (iVar2 = (i) iVar.e()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33344j;
                while (true) {
                    e0 e0Var = (e0) atomicReferenceFieldUpdater.get(this);
                    z10 = true;
                    if (e0Var.f34654c >= iVar.f34654c) {
                        break;
                    }
                    if (!iVar.q()) {
                        z10 = false;
                        break;
                    } else if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, e0Var, iVar)) {
                        if (e0Var.m()) {
                            e0Var.k();
                        }
                    } else if (iVar.m()) {
                        iVar.k();
                    }
                }
                if (z10) {
                    return;
                }
            } else {
                iVar = iVar2;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(kotlinx.coroutines.o<? super h<? extends E>> oVar) {
        t.a aVar = v8.t.f35208b;
        oVar.resumeWith(v8.t.b(h.b(h.f33392b.a(N()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0(kotlinx.coroutines.o<? super E> oVar) {
        t.a aVar = v8.t.f35208b;
        oVar.resumeWith(v8.t.b(v8.u.a(O())));
    }

    private final Object l0(E e10, z8.d<? super k0> dVar) throws Throwable {
        s0 s0VarD;
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(a9.c.c(dVar), 1);
        pVar.C();
        h9.l<E, k0> lVar = this.f33348b;
        if (lVar == null || (s0VarD = z.d(lVar, e10, null, 2, null)) == null) {
            Throwable thQ = Q();
            t.a aVar = v8.t.f35208b;
            pVar.resumeWith(v8.t.b(v8.u.a(thQ)));
        } else {
            v8.f.a(s0VarD, Q());
            t.a aVar2 = v8.t.f35208b;
            pVar.resumeWith(v8.t.b(v8.u.a(s0VarD)));
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(E e10, kotlinx.coroutines.o<? super k0> oVar) {
        h9.l<E, k0> lVar = this.f33348b;
        if (lVar != null) {
            z.b(lVar, e10, oVar.getContext());
        }
        Throwable thQ = Q();
        t.a aVar = v8.t.f35208b;
        oVar.resumeWith(v8.t.b(v8.u.a(thQ)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p0(j3 j3Var, i<E> iVar, int i10) {
        o0();
        j3Var.a(iVar, i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q0(j3 j3Var, i<E> iVar, int i10) {
        j3Var.a(iVar, i10 + r9.c.f33370b);
    }

    static /* synthetic */ <E> Object r0(b<E> bVar, z8.d<? super E> dVar) throws Throwable {
        i<E> iVar;
        i<E> iVar2 = (i) f33343i.get(bVar);
        while (!bVar.Y()) {
            long andIncrement = f33339e.getAndIncrement(bVar);
            int i10 = r9.c.f33370b;
            long j10 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (iVar2.f34654c != j10) {
                i<E> iVarK = bVar.K(j10, iVar2);
                if (iVarK == null) {
                    continue;
                } else {
                    iVar = iVarK;
                }
            } else {
                iVar = iVar2;
            }
            Object objG0 = bVar.G0(iVar, i11, andIncrement, null);
            if (objG0 == r9.c.f33381m) {
                throw new IllegalStateException("unexpected".toString());
            }
            if (objG0 != r9.c.f33383o) {
                if (objG0 == r9.c.f33382n) {
                    return bVar.u0(iVar, i11, andIncrement, dVar);
                }
                iVar.b();
                return objG0;
            }
            if (andIncrement < bVar.R()) {
                iVar.b();
            }
            iVar2 = iVar;
        }
        throw g0.a(bVar.O());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    static /* synthetic */ <E> java.lang.Object s0(r9.b<E> r14, z8.d<? super r9.h<? extends E>> r15) throws java.lang.Throwable {
        /*
            boolean r0 = r15 instanceof r9.b.d
            if (r0 == 0) goto L13
            r0 = r15
            r9.b$d r0 = (r9.b.d) r0
            int r1 = r0.f33361l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33361l = r1
            goto L18
        L13:
            r9.b$d r0 = new r9.b$d
            r0.<init>(r14, r15)
        L18:
            r6 = r0
            java.lang.Object r15 = r6.f33359j
            java.lang.Object r0 = a9.b.e()
            int r1 = r6.f33361l
            r2 = 1
            if (r1 == 0) goto L39
            if (r1 != r2) goto L31
            v8.u.b(r15)
            r9.h r15 = (r9.h) r15
            java.lang.Object r14 = r15.k()
            goto Lb6
        L31:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L39:
            v8.u.b(r15)
            r15 = 0
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = j()
            java.lang.Object r1 = r1.get(r14)
            r9.i r1 = (r9.i) r1
        L47:
            boolean r3 = r14.Y()
            if (r3 == 0) goto L59
            r9.h$b r15 = r9.h.f33392b
            java.lang.Throwable r14 = r14.N()
            java.lang.Object r14 = r15.a(r14)
            goto Lb6
        L59:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = k()
            long r4 = r3.getAndIncrement(r14)
            int r3 = r9.c.f33370b
            long r7 = (long) r3
            long r7 = r4 / r7
            long r9 = (long) r3
            long r9 = r4 % r9
            int r3 = (int) r9
            long r9 = r1.f34654c
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L79
            r9.i r7 = b(r14, r7, r1)
            if (r7 != 0) goto L77
            goto L47
        L77:
            r13 = r7
            goto L7a
        L79:
            r13 = r1
        L7a:
            r7 = r14
            r8 = r13
            r9 = r3
            r10 = r4
            r12 = r15
            java.lang.Object r1 = x(r7, r8, r9, r10, r12)
            u9.h0 r7 = r9.c.r()
            if (r1 == r7) goto Lb7
            u9.h0 r7 = r9.c.h()
            if (r1 != r7) goto L9c
            long r7 = r14.R()
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 >= 0) goto L9a
            r13.b()
        L9a:
            r1 = r13
            goto L47
        L9c:
            u9.h0 r15 = r9.c.s()
            if (r1 != r15) goto Lad
            r6.f33361l = r2
            r1 = r14
            r2 = r13
            java.lang.Object r14 = r1.t0(r2, r3, r4, r6)
            if (r14 != r0) goto Lb6
            return r0
        Lad:
            r13.b()
            r9.h$b r14 = r9.h.f33392b
            java.lang.Object r14 = r14.c(r1)
        Lb6:
            return r14
        Lb7:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "unexpected"
            java.lang.String r15 = r15.toString()
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.s0(r9.b, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t0(r9.i<E> r11, int r12, long r13, z8.d<? super r9.h<? extends E>> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 317
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.t0(r9.i, int, long, z8.d):java.lang.Object");
    }

    private final Object u0(i<E> iVar, int i10, long j10, z8.d<? super E> dVar) throws Throwable {
        kotlinx.coroutines.p pVarB = kotlinx.coroutines.r.b(a9.c.c(dVar));
        try {
            Object objG0 = G0(iVar, i10, j10, pVarB);
            if (objG0 == r9.c.f33381m) {
                p0(pVarB, iVar, i10);
            } else {
                h9.l<Throwable, k0> lVarA = null;
                lVarA = null;
                if (objG0 == r9.c.f33383o) {
                    if (j10 < R()) {
                        iVar.b();
                    }
                    i iVar2 = (i) f33343i.get(this);
                    while (true) {
                        if (Y()) {
                            k0(pVarB);
                            break;
                        }
                        long andIncrement = f33339e.getAndIncrement(this);
                        int i11 = r9.c.f33370b;
                        long j11 = andIncrement / ((long) i11);
                        int i12 = (int) (andIncrement % ((long) i11));
                        if (iVar2.f34654c != j11) {
                            i iVarK = K(j11, iVar2);
                            if (iVarK != null) {
                                iVar2 = iVarK;
                            }
                        }
                        objG0 = G0(iVar2, i12, andIncrement, pVarB);
                        if (objG0 == r9.c.f33381m) {
                            kotlinx.coroutines.p pVar = pVarB instanceof j3 ? pVarB : null;
                            if (pVar != null) {
                                p0(pVar, iVar2, i12);
                            }
                        } else if (objG0 == r9.c.f33383o) {
                            if (andIncrement < R()) {
                                iVar2.b();
                            }
                        } else {
                            if (objG0 == r9.c.f33382n) {
                                throw new IllegalStateException("unexpected".toString());
                            }
                            iVar2.b();
                            h9.l<E, k0> lVar = this.f33348b;
                            if (lVar != null) {
                                lVarA = z.a(lVar, objG0, pVarB.getContext());
                            }
                        }
                    }
                } else {
                    iVar.b();
                    h9.l<E, k0> lVar2 = this.f33348b;
                    if (lVar2 != null) {
                        lVarA = z.a(lVar2, objG0, pVarB.getContext());
                    }
                }
                pVarB.l(objG0, lVarA);
            }
            Object objZ = pVarB.z();
            if (objZ == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objZ;
        } catch (Throwable th) {
            pVarB.K();
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (r9.i) r12.g();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void v0(r9.i<E> r12) {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.v0(r9.i):void");
    }

    private final void w0(j3 j3Var) {
        y0(j3Var, true);
    }

    private final void x0(j3 j3Var) {
        y0(j3Var, false);
    }

    private final void y0(j3 j3Var, boolean z10) {
        if (j3Var instanceof C0666b) {
            kotlinx.coroutines.o<Boolean> oVarB = ((C0666b) j3Var).b();
            t.a aVar = v8.t.f35208b;
            oVarB.resumeWith(v8.t.b(Boolean.FALSE));
            return;
        }
        if (j3Var instanceof kotlinx.coroutines.o) {
            z8.d dVar = (z8.d) j3Var;
            t.a aVar2 = v8.t.f35208b;
            dVar.resumeWith(v8.t.b(v8.u.a(z10 ? O() : Q())));
        } else if (j3Var instanceof s) {
            kotlinx.coroutines.p<h<? extends E>> pVar = ((s) j3Var).f33409a;
            t.a aVar3 = v8.t.f35208b;
            pVar.resumeWith(v8.t.b(h.b(h.f33392b.a(N()))));
        } else if (j3Var instanceof a) {
            ((a) j3Var).j();
        } else {
            if (j3Var instanceof x9.b) {
                ((x9.b) j3Var).c(this, r9.c.z());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + j3Var).toString());
        }
    }

    private final boolean z(long j10) {
        return j10 < M() || j10 < P() + ((long) this.f33347a);
    }

    static /* synthetic */ <E> Object z0(b<E> bVar, E e10, z8.d<? super k0> dVar) throws Throwable {
        i<E> iVar;
        i<E> iVar2 = (i) f33342h.get(bVar);
        while (true) {
            long andIncrement = f33338d.getAndIncrement(bVar);
            long j10 = andIncrement & 1152921504606846975L;
            boolean zA0 = bVar.a0(andIncrement);
            int i10 = r9.c.f33370b;
            long j11 = j10 / ((long) i10);
            int i11 = (int) (j10 % ((long) i10));
            if (iVar2.f34654c != j11) {
                i<E> iVarL = bVar.L(j11, iVar2);
                if (iVarL != null) {
                    iVar = iVarL;
                } else if (zA0) {
                    Object objL0 = bVar.l0(e10, dVar);
                    if (objL0 == a9.d.e()) {
                        return objL0;
                    }
                }
            } else {
                iVar = iVar2;
            }
            int iI0 = bVar.I0(iVar, i11, e10, j10, null, zA0);
            if (iI0 == 0) {
                iVar.b();
                break;
            }
            if (iI0 == 1) {
                break;
            }
            if (iI0 != 2) {
                if (iI0 == 3) {
                    Object objA0 = bVar.A0(iVar, i11, e10, j10, dVar);
                    if (objA0 == a9.d.e()) {
                        return objA0;
                    }
                } else if (iI0 != 4) {
                    if (iI0 == 5) {
                        iVar.b();
                    }
                    iVar2 = iVar;
                } else {
                    if (j10 < bVar.P()) {
                        iVar.b();
                    }
                    Object objL02 = bVar.l0(e10, dVar);
                    if (objL02 == a9.d.e()) {
                        return objL02;
                    }
                }
            } else if (zA0) {
                iVar.p();
                Object objL03 = bVar.l0(e10, dVar);
                if (objL03 == a9.d.e()) {
                    return objL03;
                }
            }
        }
        return k0.f35197a;
    }

    public boolean A(@Nullable Throwable th) {
        if (th == null) {
            th = new CancellationException("Channel was cancelled");
        }
        return D(th, true);
    }

    protected boolean D(@Nullable Throwable th, boolean z10) {
        if (z10) {
            e0();
        }
        boolean zA = androidx.concurrent.futures.a.a(f33345k, this, r9.c.f33387s, th);
        if (z10) {
            f0();
        } else {
            g0();
        }
        G();
        i0();
        if (zA) {
            V();
        }
        return zA;
    }

    protected final void H(long j10) {
        s0 s0VarD;
        i<E> iVar = (i) f33343i.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f33339e;
            long j11 = atomicLongFieldUpdater.get(this);
            if (j10 < Math.max(((long) this.f33347a) + j11, M())) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j11, j11 + 1)) {
                int i10 = r9.c.f33370b;
                long j12 = j11 / ((long) i10);
                int i11 = (int) (j11 % ((long) i10));
                if (iVar.f34654c != j12) {
                    i<E> iVarK = K(j12, iVar);
                    if (iVarK == null) {
                        continue;
                    } else {
                        iVar = iVarK;
                    }
                }
                Object objG0 = G0(iVar, i11, j11, null);
                if (objG0 != r9.c.f33383o) {
                    iVar.b();
                    h9.l<E, k0> lVar = this.f33348b;
                    if (lVar != null && (s0VarD = z.d(lVar, objG0, null, 2, null)) != null) {
                        throw s0VarD;
                    }
                } else if (j11 < R()) {
                    iVar.b();
                }
            }
        }
    }

    public final void M0(long j10) {
        long j11;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j12;
        if (c0()) {
            return;
        }
        while (M() <= j10) {
        }
        int i10 = r9.c.f33371c;
        for (int i11 = 0; i11 < i10; i11++) {
            long jM = M();
            if (jM == (4611686018427387903L & f33341g.get(this)) && jM == M()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = f33341g;
        do {
            j11 = atomicLongFieldUpdater2.get(this);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j11, r9.c.v(j11 & 4611686018427387903L, true)));
        while (true) {
            long jM2 = M();
            atomicLongFieldUpdater = f33341g;
            long j13 = atomicLongFieldUpdater.get(this);
            long j14 = j13 & 4611686018427387903L;
            boolean z10 = (4611686018427387904L & j13) != 0;
            if (jM2 == j14 && jM2 == M()) {
                break;
            } else if (!z10) {
                atomicLongFieldUpdater.compareAndSet(this, j13, r9.c.v(j14, true));
            }
        }
        do {
            j12 = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j12, r9.c.v(j12 & 4611686018427387903L, false)));
    }

    @Nullable
    protected final Throwable N() {
        return (Throwable) f33345k.get(this);
    }

    public final long P() {
        return f33339e.get(this);
    }

    @NotNull
    protected final Throwable Q() {
        Throwable thN = N();
        return thN == null ? new n("Channel was closed") : thN;
    }

    public final long R() {
        return f33338d.get(this) & 1152921504606846975L;
    }

    public final boolean S() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33343i;
            i<E> iVarK = (i) atomicReferenceFieldUpdater.get(this);
            long jP = P();
            if (R() <= jP) {
                return false;
            }
            int i10 = r9.c.f33370b;
            long j10 = jP / ((long) i10);
            if (iVarK.f34654c == j10 || (iVarK = K(j10, iVarK)) != null) {
                iVarK.b();
                if (W(iVarK, (int) (jP % ((long) i10)), jP)) {
                    return true;
                }
                f33339e.compareAndSet(this, jP, jP + 1);
            } else if (((i) atomicReferenceFieldUpdater.get(this)).f34654c < j10) {
                return false;
            }
        }
    }

    public boolean Y() {
        return Z(f33338d.get(this));
    }

    protected boolean b0() {
        return false;
    }

    @Override // r9.t
    public final void cancel(@Nullable CancellationException cancellationException) {
        A(cancellationException);
    }

    @Override // r9.u
    public boolean d(@Nullable Throwable th) {
        return D(th, false);
    }

    @Override // r9.t
    @Nullable
    public Object e(@NotNull z8.d<? super h<? extends E>> dVar) {
        return s0(this, dVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bb, code lost:
    
        return r9.h.f33392b.c(v8.k0.f35197a);
     */
    @Override // r9.u
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(E r15) {
        /*
            r14 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = r9.b.f33338d
            long r0 = r0.get(r14)
            boolean r0 = r14.B0(r0)
            if (r0 == 0) goto L13
            r9.h$b r15 = r9.h.f33392b
            java.lang.Object r15 = r15.b()
            return r15
        L13:
            u9.h0 r8 = r9.c.j()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = l()
            java.lang.Object r0 = r0.get(r14)
            r9.i r0 = (r9.i) r0
        L21:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = m()
            long r1 = r1.getAndIncrement(r14)
            r3 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            long r9 = r1 & r3
            boolean r11 = n(r14, r1)
            int r1 = r9.c.f33370b
            long r2 = (long) r1
            long r2 = r9 / r2
            long r4 = (long) r1
            long r4 = r9 % r4
            int r12 = (int) r4
            long r4 = r0.f34654c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L4e
            r9.i r1 = c(r14, r2, r0)
            if (r1 != 0) goto L4c
            if (r11 == 0) goto L21
            goto L8e
        L4c:
            r13 = r1
            goto L4f
        L4e:
            r13 = r0
        L4f:
            r0 = r14
            r1 = r13
            r2 = r12
            r3 = r15
            r4 = r9
            r6 = r8
            r7 = r11
            int r0 = y(r0, r1, r2, r3, r4, r6, r7)
            if (r0 == 0) goto Lb0
            r1 = 1
            if (r0 == r1) goto Lb3
            r1 = 2
            if (r0 == r1) goto L89
            r1 = 3
            if (r0 == r1) goto L7d
            r1 = 4
            if (r0 == r1) goto L71
            r1 = 5
            if (r0 == r1) goto L6c
            goto L6f
        L6c:
            r13.b()
        L6f:
            r0 = r13
            goto L21
        L71:
            long r0 = r14.P()
            int r15 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r15 >= 0) goto L8e
            r13.b()
            goto L8e
        L7d:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "unexpected"
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L89:
            if (r11 == 0) goto L99
            r13.p()
        L8e:
            r9.h$b r15 = r9.h.f33392b
            java.lang.Throwable r0 = r14.Q()
            java.lang.Object r15 = r15.a(r0)
            goto Lbb
        L99:
            boolean r15 = r8 instanceof kotlinx.coroutines.j3
            if (r15 == 0) goto La0
            kotlinx.coroutines.j3 r8 = (kotlinx.coroutines.j3) r8
            goto La1
        La0:
            r8 = 0
        La1:
            if (r8 == 0) goto La6
            v(r14, r8, r13, r12)
        La6:
            r13.p()
            r9.h$b r15 = r9.h.f33392b
            java.lang.Object r15 = r15.b()
            goto Lbb
        Lb0:
            r13.b()
        Lb3:
            r9.h$b r15 = r9.h.f33392b
            v8.k0 r0 = v8.k0.f35197a
            java.lang.Object r15 = r15.c(r0)
        Lbb:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.f(java.lang.Object):java.lang.Object");
    }

    @Override // r9.u
    public void g(@NotNull h9.l<? super Throwable, k0> lVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f33346l;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, null, lVar)) {
            return;
        }
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != r9.c.f33385q) {
                if (obj == r9.c.f33386r) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked".toString());
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!androidx.concurrent.futures.a.a(f33346l, this, r9.c.f33385q, r9.c.f33386r));
        lVar.invoke(N());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // r9.t
    @NotNull
    public Object h() {
        i iVar;
        long j10 = f33339e.get(this);
        long j11 = f33338d.get(this);
        if (Z(j11)) {
            return h.f33392b.a(N());
        }
        if (j10 >= (j11 & 1152921504606846975L)) {
            return h.f33392b.b();
        }
        Object obj = r9.c.f33379k;
        i iVar2 = (i) f33343i.get(this);
        while (!Y()) {
            long andIncrement = f33339e.getAndIncrement(this);
            int i10 = r9.c.f33370b;
            long j12 = andIncrement / ((long) i10);
            int i11 = (int) (andIncrement % ((long) i10));
            if (iVar2.f34654c != j12) {
                i iVarK = K(j12, iVar2);
                if (iVarK == null) {
                    continue;
                } else {
                    iVar = iVarK;
                }
            } else {
                iVar = iVar2;
            }
            Object objG0 = G0(iVar, i11, andIncrement, obj);
            if (objG0 == r9.c.f33381m) {
                j3 j3Var = obj instanceof j3 ? (j3) obj : null;
                if (j3Var != null) {
                    p0(j3Var, iVar, i11);
                }
                M0(andIncrement);
                iVar.p();
                return h.f33392b.b();
            }
            if (objG0 != r9.c.f33383o) {
                if (objG0 == r9.c.f33382n) {
                    throw new IllegalStateException("unexpected".toString());
                }
                iVar.b();
                return h.f33392b.c(objG0);
            }
            if (andIncrement < R()) {
                iVar.b();
            }
            iVar2 = iVar;
        }
        return h.f33392b.a(N());
    }

    @Override // r9.t
    @NotNull
    public f<E> iterator() {
        return new a();
    }

    @Override // r9.u
    @Nullable
    public Object p(E e10, @NotNull z8.d<? super k0> dVar) {
        return z0(this, e10, dVar);
    }

    @Override // r9.t
    @Nullable
    public Object s(@NotNull z8.d<? super E> dVar) {
        return r0(this, dVar);
    }

    @Override // r9.u
    public boolean t() {
        return a0(f33338d.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e1, code lost:
    
        r3 = (r9.i) r3.e();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e8, code lost:
    
        if (r3 != null) goto L101;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 531
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r9.b.toString():java.lang.String");
    }

    protected void i0() {
    }

    protected void n0() {
    }

    protected void o0() {
    }
}
