package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u9.s;
import z8.g;

/* JADX INFO: compiled from: JobSupport.kt */
/* JADX INFO: loaded from: classes5.dex */
public class j2 implements b2, w, s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f29913a = AtomicReferenceFieldUpdater.newUpdater(j2.class, Object.class, "_state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f29914b = AtomicReferenceFieldUpdater.newUpdater(j2.class, Object.class, "_parentHandle");

    @Nullable
    private volatile Object _parentHandle;

    @Nullable
    private volatile Object _state;

    /* JADX INFO: compiled from: JobSupport.kt */
    private static final class a<T> extends p<T> {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @NotNull
        private final j2 f29915i;

        public a(@NotNull z8.d<? super T> dVar, @NotNull j2 j2Var) {
            super(dVar, 1);
            this.f29915i = j2Var;
        }

        @Override // kotlinx.coroutines.p
        @NotNull
        protected String I() {
            return "AwaitContinuation";
        }

        @Override // kotlinx.coroutines.p
        @NotNull
        public Throwable x(@NotNull b2 b2Var) {
            Throwable thE;
            Object objF0 = this.f29915i.f0();
            return (!(objF0 instanceof c) || (thE = ((c) objF0).e()) == null) ? objF0 instanceof c0 ? ((c0) objF0).f29865a : b2Var.x() : thE;
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    private static final class b extends i2 {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final j2 f29916e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        private final c f29917f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        private final v f29918g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        private final Object f29919h;

        public b(@NotNull j2 j2Var, @NotNull c cVar, @NotNull v vVar, @Nullable Object obj) {
            this.f29916e = j2Var;
            this.f29917f = cVar;
            this.f29918g = vVar;
            this.f29919h = obj;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
            q(th);
            return v8.k0.f35197a;
        }

        @Override // kotlinx.coroutines.e0
        public void q(@Nullable Throwable th) {
            this.f29916e.Q(this.f29917f, this.f29918g, this.f29919h);
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    private static final class c implements v1 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private static final AtomicIntegerFieldUpdater f29920b = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isCompleting");

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        private static final AtomicReferenceFieldUpdater f29921c = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_rootCause");

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        private static final AtomicReferenceFieldUpdater f29922d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "_exceptionsHolder");

        @Nullable
        private volatile Object _exceptionsHolder;
        private volatile int _isCompleting;

        @Nullable
        private volatile Object _rootCause;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final o2 f29923a;

        public c(@NotNull o2 o2Var, boolean z10, @Nullable Throwable th) {
            this.f29923a = o2Var;
            this._isCompleting = z10 ? 1 : 0;
            this._rootCause = th;
        }

        private final ArrayList<Throwable> c() {
            return new ArrayList<>(4);
        }

        private final Object d() {
            return f29922d.get(this);
        }

        private final void k(Object obj) {
            f29922d.set(this, obj);
        }

        public final void a(@NotNull Throwable th) {
            Throwable thE = e();
            if (thE == null) {
                l(th);
                return;
            }
            if (th == thE) {
                return;
            }
            Object objD = d();
            if (objD == null) {
                k(th);
                return;
            }
            if (objD instanceof Throwable) {
                if (th == objD) {
                    return;
                }
                ArrayList<Throwable> arrayListC = c();
                arrayListC.add(objD);
                arrayListC.add(th);
                k(arrayListC);
                return;
            }
            if (objD instanceof ArrayList) {
                ((ArrayList) objD).add(th);
                return;
            }
            throw new IllegalStateException(("State is " + objD).toString());
        }

        @Override // kotlinx.coroutines.v1
        @NotNull
        public o2 b() {
            return this.f29923a;
        }

        @Nullable
        public final Throwable e() {
            return (Throwable) f29921c.get(this);
        }

        public final boolean f() {
            return e() != null;
        }

        public final boolean g() {
            return f29920b.get(this) != 0;
        }

        public final boolean h() {
            return d() == k2.f29939e;
        }

        @NotNull
        public final List<Throwable> i(@Nullable Throwable th) {
            ArrayList<Throwable> arrayListC;
            Object objD = d();
            if (objD == null) {
                arrayListC = c();
            } else if (objD instanceof Throwable) {
                ArrayList<Throwable> arrayListC2 = c();
                arrayListC2.add(objD);
                arrayListC = arrayListC2;
            } else {
                if (!(objD instanceof ArrayList)) {
                    throw new IllegalStateException(("State is " + objD).toString());
                }
                arrayListC = (ArrayList) objD;
            }
            Throwable thE = e();
            if (thE != null) {
                arrayListC.add(0, thE);
            }
            if (th != null && !kotlin.jvm.internal.t.d(th, thE)) {
                arrayListC.add(th);
            }
            k(k2.f29939e);
            return arrayListC;
        }

        @Override // kotlinx.coroutines.v1
        public boolean isActive() {
            return e() == null;
        }

        public final void j(boolean z10) {
            f29920b.set(this, z10 ? 1 : 0);
        }

        public final void l(@Nullable Throwable th) {
            f29921c.set(this, th);
        }

        @NotNull
        public String toString() {
            return "Finishing[cancelling=" + f() + ", completing=" + g() + ", rootCause=" + e() + ", exceptions=" + d() + ", list=" + b() + ']';
        }
    }

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static final class d extends s.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ j2 f29924d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f29925e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(u9.s sVar, j2 j2Var, Object obj) {
            super(sVar);
            this.f29924d = j2Var;
            this.f29925e = obj;
        }

        @Override // u9.b
        @Nullable
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object d(@NotNull u9.s sVar) {
            if (this.f29924d.f0() == this.f29925e) {
                return null;
            }
            return u9.r.a();
        }
    }

    /* JADX INFO: compiled from: JobSupport.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.JobSupport$children$1", f = "JobSupport.kt", l = {956, 958}, m = "invokeSuspend")
    static final class e extends kotlin.coroutines.jvm.internal.k implements h9.p<o9.i<? super b2>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f29926j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f29927k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f29928l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private /* synthetic */ Object f29929m;

        e(z8.d<? super e> dVar) {
            super(2, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            e eVar = j2.this.new e(dVar);
            eVar.f29929m = obj;
            return eVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x006d -> B:27:0x0083). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0080 -> B:27:0x0083). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r7.f29928l
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L2b
                if (r1 == r3) goto L27
                if (r1 != r2) goto L1f
                java.lang.Object r1 = r7.f29927k
                u9.s r1 = (u9.s) r1
                java.lang.Object r3 = r7.f29926j
                u9.q r3 = (u9.q) r3
                java.lang.Object r4 = r7.f29929m
                o9.i r4 = (o9.i) r4
                v8.u.b(r8)
                r8 = r7
                goto L83
            L1f:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L27:
                v8.u.b(r8)
                goto L88
            L2b:
                v8.u.b(r8)
                java.lang.Object r8 = r7.f29929m
                o9.i r8 = (o9.i) r8
                kotlinx.coroutines.j2 r1 = kotlinx.coroutines.j2.this
                java.lang.Object r1 = r1.f0()
                boolean r4 = r1 instanceof kotlinx.coroutines.v
                if (r4 == 0) goto L49
                kotlinx.coroutines.v r1 = (kotlinx.coroutines.v) r1
                kotlinx.coroutines.w r1 = r1.f29988e
                r7.f29928l = r3
                java.lang.Object r8 = r8.a(r1, r7)
                if (r8 != r0) goto L88
                return r0
            L49:
                boolean r3 = r1 instanceof kotlinx.coroutines.v1
                if (r3 == 0) goto L88
                kotlinx.coroutines.v1 r1 = (kotlinx.coroutines.v1) r1
                kotlinx.coroutines.o2 r1 = r1.b()
                if (r1 == 0) goto L88
                java.lang.Object r3 = r1.i()
                java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
                kotlin.jvm.internal.t.g(r3, r4)
                u9.s r3 = (u9.s) r3
                r4 = r8
                r8 = r7
                r6 = r3
                r3 = r1
                r1 = r6
            L65:
                boolean r5 = kotlin.jvm.internal.t.d(r1, r3)
                if (r5 != 0) goto L88
                boolean r5 = r1 instanceof kotlinx.coroutines.v
                if (r5 == 0) goto L83
                r5 = r1
                kotlinx.coroutines.v r5 = (kotlinx.coroutines.v) r5
                kotlinx.coroutines.w r5 = r5.f29988e
                r8.f29929m = r4
                r8.f29926j = r3
                r8.f29927k = r1
                r8.f29928l = r2
                java.lang.Object r5 = r4.a(r5, r8)
                if (r5 != r0) goto L83
                return r0
            L83:
                u9.s r1 = r1.j()
                goto L65
            L88:
                v8.k0 r8 = v8.k0.f35197a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.j2.e.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o9.i<? super b2> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((e) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    public j2(boolean z10) {
        this._state = z10 ? k2.f29941g : k2.f29940f;
    }

    private final void A(Throwable th, List<? extends Throwable> list) {
        if (list.size() <= 1) {
            return;
        }
        Set setNewSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        for (Throwable th2 : list) {
            if (th2 != th && th2 != th && !(th2 instanceof CancellationException) && setNewSetFromMap.add(th2)) {
                v8.f.a(th, th2);
            }
        }
    }

    private final void A0(j1 j1Var) {
        o2 o2Var = new o2();
        Object u1Var = o2Var;
        if (!j1Var.isActive()) {
            u1Var = new u1(o2Var);
        }
        androidx.concurrent.futures.a.a(f29913a, this, j1Var, u1Var);
    }

    private final void C0(i2 i2Var) {
        i2Var.e(new o2());
        androidx.concurrent.futures.a.a(f29913a, this, i2Var, i2Var.j());
    }

    private final Object E(z8.d<Object> dVar) throws Throwable {
        a aVar = new a(a9.c.c(dVar), this);
        aVar.C();
        r.a(aVar, J(new t2(aVar)));
        Object objZ = aVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }

    private final int F0(Object obj) {
        if (obj instanceof j1) {
            if (((j1) obj).isActive()) {
                return 0;
            }
            if (!androidx.concurrent.futures.a.a(f29913a, this, obj, k2.f29941g)) {
                return -1;
            }
            z0();
            return 1;
        }
        if (!(obj instanceof u1)) {
            return 0;
        }
        if (!androidx.concurrent.futures.a.a(f29913a, this, obj, ((u1) obj).b())) {
            return -1;
        }
        z0();
        return 1;
    }

    private final String H0(Object obj) {
        if (!(obj instanceof c)) {
            return obj instanceof v1 ? ((v1) obj).isActive() ? "Active" : "New" : obj instanceof c0 ? "Cancelled" : "Completed";
        }
        c cVar = (c) obj;
        return cVar.f() ? "Cancelling" : cVar.g() ? "Completing" : "Active";
    }

    private final Object I(Object obj) {
        Object objN0;
        do {
            Object objF0 = f0();
            if (!(objF0 instanceof v1) || ((objF0 instanceof c) && ((c) objF0).g())) {
                return k2.f29935a;
            }
            objN0 = N0(objF0, new c0(T(obj), false, 2, null));
        } while (objN0 == k2.f29937c);
        return objN0;
    }

    public static /* synthetic */ CancellationException J0(j2 j2Var, Throwable th, String str, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toCancellationException");
        }
        if ((i10 & 1) != 0) {
            str = null;
        }
        return j2Var.I0(th, str);
    }

    private final boolean K(Throwable th) {
        if (l0()) {
            return true;
        }
        boolean z10 = th instanceof CancellationException;
        u uVarE0 = e0();
        return (uVarE0 == null || uVarE0 == q2.f29976a) ? z10 : uVarE0.a(th) || z10;
    }

    private final boolean L0(v1 v1Var, Object obj) throws Throwable {
        if (!androidx.concurrent.futures.a.a(f29913a, this, v1Var, k2.g(obj))) {
            return false;
        }
        x0(null);
        y0(obj);
        P(v1Var, obj);
        return true;
    }

    private final boolean M0(v1 v1Var, Throwable th) throws Throwable {
        o2 o2VarD0 = d0(v1Var);
        if (o2VarD0 == null) {
            return false;
        }
        if (!androidx.concurrent.futures.a.a(f29913a, this, v1Var, new c(o2VarD0, false, th))) {
            return false;
        }
        v0(o2VarD0, th);
        return true;
    }

    private final Object N0(Object obj, Object obj2) {
        return !(obj instanceof v1) ? k2.f29935a : ((!(obj instanceof j1) && !(obj instanceof i2)) || (obj instanceof v) || (obj2 instanceof c0)) ? O0((v1) obj, obj2) : L0((v1) obj, obj2) ? obj2 : k2.f29937c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r2v2 */
    private final Object O0(v1 v1Var, Object obj) throws Throwable {
        o2 o2VarD0 = d0(v1Var);
        if (o2VarD0 == null) {
            return k2.f29937c;
        }
        c cVar = v1Var instanceof c ? (c) v1Var : null;
        if (cVar == null) {
            cVar = new c(o2VarD0, false, null);
        }
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        synchronized (cVar) {
            if (cVar.g()) {
                return k2.f29935a;
            }
            cVar.j(true);
            if (cVar != v1Var && !androidx.concurrent.futures.a.a(f29913a, this, v1Var, cVar)) {
                return k2.f29937c;
            }
            boolean zF = cVar.f();
            c0 c0Var = obj instanceof c0 ? (c0) obj : null;
            if (c0Var != null) {
                cVar.a(c0Var.f29865a);
            }
            ?? E = Boolean.valueOf(zF ? false : true).booleanValue() ? cVar.e() : 0;
            n0Var.f29834a = E;
            v8.k0 k0Var = v8.k0.f35197a;
            if (E != 0) {
                v0(o2VarD0, E);
            }
            v vVarV = V(v1Var);
            return (vVarV == null || !P0(cVar, vVarV, obj)) ? U(cVar, obj) : k2.f29936b;
        }
    }

    private final void P(v1 v1Var, Object obj) throws Throwable {
        u uVarE0 = e0();
        if (uVarE0 != null) {
            uVarE0.dispose();
            E0(q2.f29976a);
        }
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.f29865a : null;
        if (!(v1Var instanceof i2)) {
            o2 o2VarB = v1Var.b();
            if (o2VarB != null) {
                w0(o2VarB, th);
                return;
            }
            return;
        }
        try {
            ((i2) v1Var).q(th);
        } catch (Throwable th2) {
            j0(new f0("Exception in completion handler " + v1Var + " for " + this, th2));
        }
    }

    private final boolean P0(c cVar, v vVar, Object obj) {
        while (b2.a.d(vVar.f29988e, false, false, new b(this, cVar, vVar, obj), 1, null) == q2.f29976a) {
            vVar = u0(vVar);
            if (vVar == null) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(c cVar, v vVar, Object obj) {
        v vVarU0 = u0(vVar);
        if (vVarU0 == null || !P0(cVar, vVarU0, obj)) {
            C(U(cVar, obj));
        }
    }

    private final Throwable T(Object obj) {
        if (obj == null ? true : obj instanceof Throwable) {
            Throwable th = (Throwable) obj;
            return th == null ? new c2(M(), null, this) : th;
        }
        kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        return ((s2) obj).S();
    }

    private final Object U(c cVar, Object obj) throws Throwable {
        boolean zF;
        Throwable thZ;
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        Throwable th = c0Var != null ? c0Var.f29865a : null;
        synchronized (cVar) {
            zF = cVar.f();
            List<Throwable> listI = cVar.i(th);
            thZ = Z(cVar, listI);
            if (thZ != null) {
                A(thZ, listI);
            }
        }
        if (thZ != null && thZ != th) {
            obj = new c0(thZ, false, 2, null);
        }
        if (thZ != null) {
            if (K(thZ) || g0(thZ)) {
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                ((c0) obj).b();
            }
        }
        if (!zF) {
            x0(thZ);
        }
        y0(obj);
        androidx.concurrent.futures.a.a(f29913a, this, cVar, k2.g(obj));
        P(cVar, obj);
        return obj;
    }

    private final v V(v1 v1Var) {
        v vVar = v1Var instanceof v ? (v) v1Var : null;
        if (vVar != null) {
            return vVar;
        }
        o2 o2VarB = v1Var.b();
        if (o2VarB != null) {
            return u0(o2VarB);
        }
        return null;
    }

    private final Throwable Y(Object obj) {
        c0 c0Var = obj instanceof c0 ? (c0) obj : null;
        if (c0Var != null) {
            return c0Var.f29865a;
        }
        return null;
    }

    private final Throwable Z(c cVar, List<? extends Throwable> list) {
        Object next;
        Object obj = null;
        if (list.isEmpty()) {
            if (cVar.f()) {
                return new c2(M(), null, this);
            }
            return null;
        }
        List<? extends Throwable> list2 = list;
        Iterator<T> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!(((Throwable) next) instanceof CancellationException)) {
                break;
            }
        }
        Throwable th = (Throwable) next;
        if (th != null) {
            return th;
        }
        Throwable th2 = list.get(0);
        if (th2 instanceof d3) {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                Throwable th3 = (Throwable) next2;
                if (th3 != th2 && (th3 instanceof d3)) {
                    obj = next2;
                    break;
                }
            }
            Throwable th4 = (Throwable) obj;
            if (th4 != null) {
                return th4;
            }
        }
        return th2;
    }

    private final o2 d0(v1 v1Var) {
        o2 o2VarB = v1Var.b();
        if (o2VarB != null) {
            return o2VarB;
        }
        if (v1Var instanceof j1) {
            return new o2();
        }
        if (v1Var instanceof i2) {
            C0((i2) v1Var);
            return null;
        }
        throw new IllegalStateException(("State should have list: " + v1Var).toString());
    }

    private final boolean m0() {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof v1)) {
                return false;
            }
        } while (F0(objF0) < 0);
        return true;
    }

    private final Object o0(z8.d<? super v8.k0> dVar) throws Throwable {
        p pVar = new p(a9.c.c(dVar), 1);
        pVar.C();
        r.a(pVar, J(new u2(pVar)));
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ == a9.d.e() ? objZ : v8.k0.f35197a;
    }

    private final Object p0(Object obj) throws Throwable {
        Throwable thT = null;
        while (true) {
            Object objF0 = f0();
            if (objF0 instanceof c) {
                synchronized (objF0) {
                    if (((c) objF0).h()) {
                        return k2.f29938d;
                    }
                    boolean zF = ((c) objF0).f();
                    if (obj != null || !zF) {
                        if (thT == null) {
                            thT = T(obj);
                        }
                        ((c) objF0).a(thT);
                    }
                    Throwable thE = zF ^ true ? ((c) objF0).e() : null;
                    if (thE != null) {
                        v0(((c) objF0).b(), thE);
                    }
                    return k2.f29935a;
                }
            }
            if (!(objF0 instanceof v1)) {
                return k2.f29938d;
            }
            if (thT == null) {
                thT = T(obj);
            }
            v1 v1Var = (v1) objF0;
            if (!v1Var.isActive()) {
                Object objN0 = N0(objF0, new c0(thT, false, 2, null));
                if (objN0 == k2.f29935a) {
                    throw new IllegalStateException(("Cannot happen in " + objF0).toString());
                }
                if (objN0 != k2.f29937c) {
                    return objN0;
                }
            } else if (M0(v1Var, thT)) {
                return k2.f29935a;
            }
        }
    }

    private final i2 s0(h9.l<? super Throwable, v8.k0> lVar, boolean z10) {
        i2 a2Var;
        if (z10) {
            a2Var = lVar instanceof d2 ? (d2) lVar : null;
            if (a2Var == null) {
                a2Var = new z1(lVar);
            }
        } else {
            a2Var = lVar instanceof i2 ? (i2) lVar : null;
            if (a2Var == null) {
                a2Var = new a2(lVar);
            }
        }
        a2Var.s(this);
        return a2Var;
    }

    private final v u0(u9.s sVar) {
        while (sVar.l()) {
            sVar = sVar.k();
        }
        while (true) {
            sVar = sVar.j();
            if (!sVar.l()) {
                if (sVar instanceof v) {
                    return (v) sVar;
                }
                if (sVar instanceof o2) {
                    return null;
                }
            }
        }
    }

    private final void v0(o2 o2Var, Throwable th) throws Throwable {
        x0(th);
        Object objI = o2Var.i();
        kotlin.jvm.internal.t.g(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        f0 f0Var = null;
        for (u9.s sVarJ = (u9.s) objI; !kotlin.jvm.internal.t.d(sVarJ, o2Var); sVarJ = sVarJ.j()) {
            if (sVarJ instanceof d2) {
                i2 i2Var = (i2) sVarJ;
                try {
                    i2Var.q(th);
                } catch (Throwable th2) {
                    if (f0Var != null) {
                        v8.f.a(f0Var, th2);
                    } else {
                        f0Var = new f0("Exception in completion handler " + i2Var + " for " + this, th2);
                        v8.k0 k0Var = v8.k0.f35197a;
                    }
                }
            }
        }
        if (f0Var != null) {
            j0(f0Var);
        }
        K(th);
    }

    private final void w0(o2 o2Var, Throwable th) throws Throwable {
        Object objI = o2Var.i();
        kotlin.jvm.internal.t.g(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        f0 f0Var = null;
        for (u9.s sVarJ = (u9.s) objI; !kotlin.jvm.internal.t.d(sVarJ, o2Var); sVarJ = sVarJ.j()) {
            if (sVarJ instanceof i2) {
                i2 i2Var = (i2) sVarJ;
                try {
                    i2Var.q(th);
                } catch (Throwable th2) {
                    if (f0Var != null) {
                        v8.f.a(f0Var, th2);
                    } else {
                        f0Var = new f0("Exception in completion handler " + i2Var + " for " + this, th2);
                        v8.k0 k0Var = v8.k0.f35197a;
                    }
                }
            }
        }
        if (f0Var != null) {
            j0(f0Var);
        }
    }

    private final boolean y(Object obj, o2 o2Var, i2 i2Var) {
        int iP;
        d dVar = new d(i2Var, this, obj);
        do {
            iP = o2Var.k().p(i2Var, o2Var, dVar);
            if (iP == 1) {
                return true;
            }
        } while (iP != 2);
        return false;
    }

    @Override // kotlinx.coroutines.w
    public final void B(@NotNull s2 s2Var) throws Throwable {
        G(s2Var);
    }

    @Nullable
    protected final Object D(@NotNull z8.d<Object> dVar) throws Throwable {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof v1)) {
                if (objF0 instanceof c0) {
                    throw ((c0) objF0).f29865a;
                }
                return k2.h(objF0);
            }
        } while (F0(objF0) < 0);
        return E(dVar);
    }

    public final void D0(@NotNull i2 i2Var) {
        Object objF0;
        do {
            objF0 = f0();
            if (!(objF0 instanceof i2)) {
                if (!(objF0 instanceof v1) || ((v1) objF0).b() == null) {
                    return;
                }
                i2Var.m();
                return;
            }
            if (objF0 != i2Var) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f29913a, this, objF0, k2.f29941g));
    }

    public final void E0(@Nullable u uVar) {
        f29914b.set(this, uVar);
    }

    public final boolean F(@Nullable Throwable th) {
        return G(th);
    }

    public final boolean G(@Nullable Object obj) throws Throwable {
        Object objP0 = k2.f29935a;
        if (b0() && (objP0 = I(obj)) == k2.f29936b) {
            return true;
        }
        if (objP0 == k2.f29935a) {
            objP0 = p0(obj);
        }
        if (objP0 == k2.f29935a || objP0 == k2.f29936b) {
            return true;
        }
        if (objP0 == k2.f29938d) {
            return false;
        }
        C(objP0);
        return true;
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public final u G0(@NotNull w wVar) {
        g1 g1VarD = b2.a.d(this, true, false, new v(wVar), 2, null);
        kotlin.jvm.internal.t.g(g1VarD, "null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
        return (u) g1VarD;
    }

    public void H(@NotNull Throwable th) throws Throwable {
        G(th);
    }

    @NotNull
    protected final CancellationException I0(@NotNull Throwable th, @Nullable String str) {
        CancellationException c2Var = th instanceof CancellationException ? (CancellationException) th : null;
        if (c2Var == null) {
            if (str == null) {
                str = M();
            }
            c2Var = new c2(str, th, this);
        }
        return c2Var;
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public final g1 J(@NotNull h9.l<? super Throwable, v8.k0> lVar) {
        return h0(false, true, lVar);
    }

    @NotNull
    public final String K0() {
        return t0() + '{' + H0(f0()) + '}';
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    public String M() {
        return "Job was cancelled";
    }

    public boolean N(@NotNull Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return G(th) && a0();
    }

    @Override // kotlinx.coroutines.s2
    @NotNull
    public CancellationException S() {
        Throwable thE;
        Object objF0 = f0();
        if (objF0 instanceof c) {
            thE = ((c) objF0).e();
        } else if (objF0 instanceof c0) {
            thE = ((c0) objF0).f29865a;
        } else {
            if (objF0 instanceof v1) {
                throw new IllegalStateException(("Cannot be cancelling child in this state: " + objF0).toString());
            }
            thE = null;
        }
        CancellationException cancellationException = thE instanceof CancellationException ? (CancellationException) thE : null;
        if (cancellationException != null) {
            return cancellationException;
        }
        return new c2("Parent job is " + H0(objF0), thE, this);
    }

    @Nullable
    public final Object X() throws Throwable {
        Object objF0 = f0();
        if (!(!(objF0 instanceof v1))) {
            throw new IllegalStateException("This job has not completed yet".toString());
        }
        if (objF0 instanceof c0) {
            throw ((c0) objF0).f29865a;
        }
        return k2.h(objF0);
    }

    public boolean a0() {
        return true;
    }

    public boolean b0() {
        return false;
    }

    @Override // kotlinx.coroutines.b2
    public void cancel(@Nullable CancellationException cancellationException) throws Throwable {
        if (cancellationException == null) {
            cancellationException = new c2(M(), null, this);
        }
        H(cancellationException);
    }

    @Nullable
    public final u e0() {
        return (u) f29914b.get(this);
    }

    @Nullable
    public final Object f0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f29913a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof u9.a0)) {
                return obj;
            }
            ((u9.a0) obj).a(this);
        }
    }

    @Override // z8.g.b, z8.g
    public <R> R fold(R r10, @NotNull h9.p<? super R, ? super g.b, ? extends R> pVar) {
        return (R) b2.a.b(this, r10, pVar);
    }

    protected boolean g0(@NotNull Throwable th) {
        return false;
    }

    @Override // z8.g.b, z8.g
    @Nullable
    public <E extends g.b> E get(@NotNull g.c<E> cVar) {
        return (E) b2.a.c(this, cVar);
    }

    @Override // z8.g.b
    @NotNull
    public final g.c<?> getKey() {
        return b2.O7;
    }

    @Override // kotlinx.coroutines.b2
    @Nullable
    public b2 getParent() {
        u uVarE0 = e0();
        if (uVarE0 != null) {
            return uVarE0.getParent();
        }
        return null;
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public final g1 h0(boolean z10, boolean z11, @NotNull h9.l<? super Throwable, v8.k0> lVar) {
        i2 i2VarS0 = s0(lVar, z10);
        while (true) {
            Object objF0 = f0();
            if (objF0 instanceof j1) {
                j1 j1Var = (j1) objF0;
                if (!j1Var.isActive()) {
                    A0(j1Var);
                } else if (androidx.concurrent.futures.a.a(f29913a, this, objF0, i2VarS0)) {
                    return i2VarS0;
                }
            } else {
                if (!(objF0 instanceof v1)) {
                    if (z11) {
                        c0 c0Var = objF0 instanceof c0 ? (c0) objF0 : null;
                        lVar.invoke(c0Var != null ? c0Var.f29865a : null);
                    }
                    return q2.f29976a;
                }
                o2 o2VarB = ((v1) objF0).b();
                if (o2VarB == null) {
                    kotlin.jvm.internal.t.g(objF0, "null cannot be cast to non-null type kotlinx.coroutines.JobNode");
                    C0((i2) objF0);
                } else {
                    g1 g1Var = q2.f29976a;
                    if (z10 && (objF0 instanceof c)) {
                        synchronized (objF0) {
                            thE = ((c) objF0).e();
                            if (thE == null || ((lVar instanceof v) && !((c) objF0).g())) {
                                if (y(objF0, o2VarB, i2VarS0)) {
                                    if (thE == null) {
                                        return i2VarS0;
                                    }
                                    g1Var = i2VarS0;
                                }
                            }
                            v8.k0 k0Var = v8.k0.f35197a;
                        }
                    }
                    if (thE != null) {
                        if (z11) {
                            lVar.invoke(thE);
                        }
                        return g1Var;
                    }
                    if (y(objF0, o2VarB, i2VarS0)) {
                        return i2VarS0;
                    }
                }
            }
        }
    }

    @Override // kotlinx.coroutines.b2
    public final boolean i() {
        return !(f0() instanceof v1);
    }

    @Override // kotlinx.coroutines.b2
    public boolean isActive() {
        Object objF0 = f0();
        return (objF0 instanceof v1) && ((v1) objF0).isActive();
    }

    @Override // kotlinx.coroutines.b2
    public final boolean isCancelled() {
        Object objF0 = f0();
        return (objF0 instanceof c0) || ((objF0 instanceof c) && ((c) objF0).f());
    }

    protected final void k0(@Nullable b2 b2Var) {
        if (b2Var == null) {
            E0(q2.f29976a);
            return;
        }
        b2Var.start();
        u uVarG0 = b2Var.G0(this);
        E0(uVarG0);
        if (i()) {
            uVarG0.dispose();
            E0(q2.f29976a);
        }
    }

    protected boolean l0() {
        return false;
    }

    @Override // z8.g.b, z8.g
    @NotNull
    public z8.g minusKey(@NotNull g.c<?> cVar) {
        return b2.a.e(this, cVar);
    }

    @Override // z8.g
    @NotNull
    public z8.g plus(@NotNull z8.g gVar) {
        return b2.a.f(this, gVar);
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public final o9.g<b2> q() {
        return o9.k.b(new e(null));
    }

    public final boolean q0(@Nullable Object obj) {
        Object objN0;
        do {
            objN0 = N0(f0(), obj);
            if (objN0 == k2.f29935a) {
                return false;
            }
            if (objN0 == k2.f29936b) {
                return true;
            }
        } while (objN0 == k2.f29937c);
        C(objN0);
        return true;
    }

    @Nullable
    public final Object r0(@Nullable Object obj) {
        Object objN0;
        do {
            objN0 = N0(f0(), obj);
            if (objN0 == k2.f29935a) {
                throw new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, Y(obj));
            }
        } while (objN0 == k2.f29937c);
        return objN0;
    }

    @Override // kotlinx.coroutines.b2
    public final boolean start() {
        int iF0;
        do {
            iF0 = F0(f0());
            if (iF0 == 0) {
                return false;
            }
        } while (iF0 != 1);
        return true;
    }

    @NotNull
    public String t0() {
        return s0.a(this);
    }

    @NotNull
    public String toString() {
        return K0() + '@' + s0.b(this);
    }

    @Override // kotlinx.coroutines.b2
    @NotNull
    public final CancellationException x() {
        Object objF0 = f0();
        if (!(objF0 instanceof c)) {
            if (objF0 instanceof v1) {
                throw new IllegalStateException(("Job is still new or active: " + this).toString());
            }
            if (objF0 instanceof c0) {
                return J0(this, ((c0) objF0).f29865a, null, 1, null);
            }
            return new c2(s0.a(this) + " has completed normally", null, this);
        }
        Throwable thE = ((c) objF0).e();
        if (thE != null) {
            CancellationException cancellationExceptionI0 = I0(thE, s0.a(this) + " is cancelling");
            if (cancellationExceptionI0 != null) {
                return cancellationExceptionI0;
            }
        }
        throw new IllegalStateException(("Job is still new or active: " + this).toString());
    }

    @Override // kotlinx.coroutines.b2
    @Nullable
    public final Object z(@NotNull z8.d<? super v8.k0> dVar) throws Throwable {
        if (m0()) {
            Object objO0 = o0(dVar);
            return objO0 == a9.d.e() ? objO0 : v8.k0.f35197a;
        }
        f2.k(dVar.getContext());
        return v8.k0.f35197a;
    }

    protected void z0() {
    }

    protected void C(@Nullable Object obj) {
    }

    public void j0(@NotNull Throwable th) throws Throwable {
        throw th;
    }

    protected void x0(@Nullable Throwable th) {
    }

    protected void y0(@Nullable Object obj) {
    }
}
