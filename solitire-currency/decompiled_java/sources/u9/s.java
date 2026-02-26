package u9;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: LockFreeLinkedList.kt */
/* JADX INFO: loaded from: classes5.dex */
public class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34698a = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34699b = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_prev");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private static final AtomicReferenceFieldUpdater f34700c = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_removedRef");

    @Nullable
    private volatile Object _next = this;

    @Nullable
    private volatile Object _prev = this;

    @Nullable
    private volatile Object _removedRef;

    /* JADX INFO: compiled from: LockFreeLinkedList.kt */
    public static abstract class a extends u9.b<s> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public final s f34701b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public s f34702c;

        public a(@NotNull s sVar) {
            this.f34701b = sVar;
        }

        @Override // u9.b
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(@NotNull s sVar, @Nullable Object obj) {
            boolean z10 = obj == null;
            s sVar2 = z10 ? this.f34701b : this.f34702c;
            if (sVar2 != null && androidx.concurrent.futures.a.a(s.f34698a, sVar, this, sVar2) && z10) {
                s sVar3 = this.f34701b;
                s sVar4 = this.f34702c;
                kotlin.jvm.internal.t.f(sVar4);
                sVar3.h(sVar4);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (androidx.concurrent.futures.a.a(r4, r3, r2, ((u9.b0) r5).f34647a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final u9.s f(u9.a0 r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = u9.s.f34699b
            java.lang.Object r0 = r0.get(r8)
            u9.s r0 = (u9.s) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = u9.s.f34698a
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = u9.s.f34699b
            boolean r0 = androidx.concurrent.futures.a.a(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.l()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof u9.a0
            if (r6 == 0) goto L34
            u9.a0 r5 = (u9.a0) r5
            r5.a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof u9.b0
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            u9.b0 r5 = (u9.b0) r5
            u9.s r5 = r5.f34647a
            boolean r2 = androidx.concurrent.futures.a.a(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = u9.s.f34699b
            java.lang.Object r2 = r4.get(r2)
            u9.s r2 = (u9.s) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            kotlin.jvm.internal.t.g(r5, r3)
            r3 = r5
            u9.s r3 = (u9.s) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: u9.s.f(u9.a0):u9.s");
    }

    private final s g(s sVar) {
        while (sVar.l()) {
            sVar = (s) f34699b.get(sVar);
        }
        return sVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(s sVar) {
        s sVar2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34699b;
        do {
            sVar2 = (s) atomicReferenceFieldUpdater.get(sVar);
            if (i() != sVar) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f34699b, sVar, sVar2, this));
        if (l()) {
            sVar.f(null);
        }
    }

    private final b0 o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34700c;
        b0 b0Var = (b0) atomicReferenceFieldUpdater.get(this);
        if (b0Var != null) {
            return b0Var;
        }
        b0 b0Var2 = new b0(this);
        atomicReferenceFieldUpdater.lazySet(this, b0Var2);
        return b0Var2;
    }

    public final boolean e(@NotNull s sVar) {
        f34699b.lazySet(sVar, this);
        f34698a.lazySet(sVar, this);
        while (i() == this) {
            if (androidx.concurrent.futures.a.a(f34698a, this, this, sVar)) {
                sVar.h(this);
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final Object i() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34698a;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof a0)) {
                return obj;
            }
            ((a0) obj).a(this);
        }
    }

    @NotNull
    public final s j() {
        return r.b(i());
    }

    @NotNull
    public final s k() {
        s sVarF = f(null);
        return sVarF == null ? g((s) f34699b.get(this)) : sVarF;
    }

    public boolean l() {
        return i() instanceof b0;
    }

    public boolean m() {
        return n() == null;
    }

    @Nullable
    public final s n() {
        Object objI;
        s sVar;
        do {
            objI = i();
            if (objI instanceof b0) {
                return ((b0) objI).f34647a;
            }
            if (objI == this) {
                return (s) objI;
            }
            kotlin.jvm.internal.t.g(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            sVar = (s) objI;
        } while (!androidx.concurrent.futures.a.a(f34698a, this, objI, sVar.o()));
        sVar.f(null);
        return null;
    }

    public final int p(@NotNull s sVar, @NotNull s sVar2, @NotNull a aVar) {
        f34699b.lazySet(sVar, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f34698a;
        atomicReferenceFieldUpdater.lazySet(sVar, sVar2);
        aVar.f34702c = sVar2;
        if (androidx.concurrent.futures.a.a(atomicReferenceFieldUpdater, this, sVar2, aVar)) {
            return aVar.a(this) == null ? 1 : 2;
        }
        return 0;
    }

    @NotNull
    public String toString() {
        return new kotlin.jvm.internal.e0(this) { // from class: u9.s.b
            @Override // kotlin.jvm.internal.e0, kotlin.reflect.KProperty0
            @Nullable
            public Object get() {
                return kotlinx.coroutines.s0.a(this.receiver);
            }
        } + '@' + kotlinx.coroutines.s0.b(this);
    }
}
