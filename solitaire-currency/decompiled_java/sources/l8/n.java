package l8;

import h9.q;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: SuspendFunctionGun.kt */
/* JADX INFO: loaded from: classes.dex */
public final class n<TSubject, TContext> extends e<TSubject, TContext> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> f30963b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final z8.d<k0> f30964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private TSubject f30965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private final z8.d<TSubject>[] f30966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30967f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f30968g;

    /* JADX INFO: compiled from: SuspendFunctionGun.kt */
    public static final class a implements z8.d<k0>, kotlin.coroutines.jvm.internal.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f30969a = Integer.MIN_VALUE;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ n<TSubject, TContext> f30970b;

        a(n<TSubject, TContext> nVar) {
            this.f30970b = nVar;
        }

        private final z8.d<?> a() {
            if (this.f30969a == Integer.MIN_VALUE) {
                this.f30969a = ((n) this.f30970b).f30967f;
            }
            if (this.f30969a < 0) {
                this.f30969a = Integer.MIN_VALUE;
                return null;
            }
            try {
                z8.d<?>[] dVarArr = ((n) this.f30970b).f30966e;
                int i10 = this.f30969a;
                z8.d<?> dVar = dVarArr[i10];
                if (dVar == null) {
                    return m.f30962a;
                }
                this.f30969a = i10 - 1;
                return dVar;
            } catch (Throwable unused) {
                return m.f30962a;
            }
        }

        @Override // kotlin.coroutines.jvm.internal.e
        @Nullable
        public kotlin.coroutines.jvm.internal.e getCallerFrame() {
            z8.d<?> dVarA = a();
            if (dVarA instanceof kotlin.coroutines.jvm.internal.e) {
                return (kotlin.coroutines.jvm.internal.e) dVarA;
            }
            return null;
        }

        @Override // z8.d
        @NotNull
        public z8.g getContext() {
            z8.d dVar = ((n) this.f30970b).f30966e[((n) this.f30970b).f30967f];
            if (dVar != this && dVar != null) {
                return dVar.getContext();
            }
            int i10 = ((n) this.f30970b).f30967f - 1;
            while (i10 >= 0) {
                int i11 = i10 - 1;
                z8.d dVar2 = ((n) this.f30970b).f30966e[i10];
                if (dVar2 != this && dVar2 != null) {
                    return dVar2.getContext();
                }
                i10 = i11;
            }
            throw new IllegalStateException("Not started".toString());
        }

        @Override // z8.d
        public void resumeWith(@NotNull Object obj) {
            if (!t.g(obj)) {
                this.f30970b.m(false);
                return;
            }
            n<TSubject, TContext> nVar = this.f30970b;
            Throwable thE = t.e(obj);
            kotlin.jvm.internal.t.f(thE);
            nVar.n(t.b(u.a(thE)));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public n(@NotNull TSubject initial, @NotNull TContext context, @NotNull List<? extends q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object>> blocks) {
        super(context);
        kotlin.jvm.internal.t.i(initial, "initial");
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(blocks, "blocks");
        this.f30963b = blocks;
        this.f30964c = new a(this);
        this.f30965d = initial;
        this.f30966e = new z8.d[blocks.size()];
        this.f30967f = -1;
    }

    private final void k() {
        int i10 = this.f30967f;
        if (i10 < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        z8.d<TSubject>[] dVarArr = this.f30966e;
        this.f30967f = i10 - 1;
        dVarArr[i10] = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean m(boolean z10) {
        int i10;
        do {
            i10 = this.f30968g;
            if (i10 == this.f30963b.size()) {
                if (z10) {
                    return true;
                }
                t.a aVar = t.f35208b;
                n(t.b(l()));
                return false;
            }
            this.f30968g = i10 + 1;
            try {
            } catch (Throwable th) {
                t.a aVar2 = t.f35208b;
                n(t.b(u.a(th)));
                return false;
            }
        } while (this.f30963b.get(i10).invoke(this, l(), this.f30964c) != a9.d.e());
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(Object obj) {
        int i10 = this.f30967f;
        if (i10 < 0) {
            throw new IllegalStateException("No more continuations to resume".toString());
        }
        z8.d<TSubject> dVar = this.f30966e[i10];
        kotlin.jvm.internal.t.f(dVar);
        z8.d<TSubject>[] dVarArr = this.f30966e;
        int i11 = this.f30967f;
        this.f30967f = i11 - 1;
        dVarArr[i11] = null;
        if (!t.g(obj)) {
            dVar.resumeWith(obj);
            return;
        }
        Throwable thE = t.e(obj);
        kotlin.jvm.internal.t.f(thE);
        dVar.resumeWith(t.b(u.a(k.a(thE, dVar))));
    }

    @Override // l8.e
    @Nullable
    public Object b(@NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar) {
        this.f30968g = 0;
        if (this.f30963b.size() == 0) {
            return tsubject;
        }
        o(tsubject);
        if (this.f30967f < 0) {
            return d(dVar);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // l8.e
    @Nullable
    public Object d(@NotNull z8.d<? super TSubject> dVar) {
        Object objE;
        if (this.f30968g == this.f30963b.size()) {
            objE = l();
        } else {
            j(a9.c.c(dVar));
            if (m(true)) {
                k();
                objE = l();
            } else {
                objE = a9.d.e();
            }
        }
        if (objE == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objE;
    }

    @Override // l8.e
    @Nullable
    public Object e(@NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar) {
        o(tsubject);
        return d(dVar);
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f30964c.getContext();
    }

    public final void j(@NotNull z8.d<? super TSubject> continuation) {
        kotlin.jvm.internal.t.i(continuation, "continuation");
        z8.d<TSubject>[] dVarArr = this.f30966e;
        int i10 = this.f30967f + 1;
        this.f30967f = i10;
        dVarArr[i10] = continuation;
    }

    @NotNull
    public TSubject l() {
        return this.f30965d;
    }

    public void o(@NotNull TSubject tsubject) {
        kotlin.jvm.internal.t.i(tsubject, "<set-?>");
        this.f30965d = tsubject;
    }
}
