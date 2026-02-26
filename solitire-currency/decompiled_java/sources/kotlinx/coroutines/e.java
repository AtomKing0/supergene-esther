package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Await.kt */
/* JADX INFO: loaded from: classes5.dex */
final class e<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private static final AtomicIntegerFieldUpdater f29876b = AtomicIntegerFieldUpdater.newUpdater(e.class, "notCompletedCount");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final v0<T>[] f29877a;
    private volatile int notCompletedCount;

    /* JADX INFO: compiled from: Await.kt */
    private final class a extends i2 {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        private static final AtomicReferenceFieldUpdater f29878h = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "_disposer");

        @Nullable
        private volatile Object _disposer;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        private final o<List<? extends T>> f29879e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public g1 f29880f;

        /* JADX WARN: Multi-variable type inference failed */
        public a(@NotNull o<? super List<? extends T>> oVar) {
            this.f29879e = oVar;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
            q(th);
            return v8.k0.f35197a;
        }

        @Override // kotlinx.coroutines.e0
        public void q(@Nullable Throwable th) {
            if (th != null) {
                Object objJ = this.f29879e.j(th);
                if (objJ != null) {
                    this.f29879e.u(objJ);
                    e<T>.b bVarT = t();
                    if (bVarT != null) {
                        bVarT.e();
                        return;
                    }
                    return;
                }
                return;
            }
            if (e.f29876b.decrementAndGet(e.this) == 0) {
                o<List<? extends T>> oVar = this.f29879e;
                v0[] v0VarArr = ((e) e.this).f29877a;
                ArrayList arrayList = new ArrayList(v0VarArr.length);
                for (v0 v0Var : v0VarArr) {
                    arrayList.add(v0Var.n());
                }
                oVar.resumeWith(v8.t.b(arrayList));
            }
        }

        @Nullable
        public final e<T>.b t() {
            return (b) f29878h.get(this);
        }

        @NotNull
        public final g1 u() {
            g1 g1Var = this.f29880f;
            if (g1Var != null) {
                return g1Var;
            }
            kotlin.jvm.internal.t.A("handle");
            return null;
        }

        public final void v(@Nullable e<T>.b bVar) {
            f29878h.set(this, bVar);
        }

        public final void w(@NotNull g1 g1Var) {
            this.f29880f = g1Var;
        }
    }

    /* JADX INFO: compiled from: Await.kt */
    private final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final e<T>.a[] f29882a;

        public b(@NotNull e<T>.a[] aVarArr) {
            this.f29882a = aVarArr;
        }

        @Override // kotlinx.coroutines.n
        public void d(@Nullable Throwable th) {
            e();
        }

        public final void e() {
            for (e<T>.a aVar : this.f29882a) {
                aVar.u().dispose();
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(Throwable th) {
            d(th);
            return v8.k0.f35197a;
        }

        @NotNull
        public String toString() {
            return "DisposeHandlersOnCancel[" + this.f29882a + ']';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(@NotNull v0<? extends T>[] v0VarArr) {
        this.f29877a = v0VarArr;
        this.notCompletedCount = v0VarArr.length;
    }

    @Nullable
    public final Object c(@NotNull z8.d<? super List<? extends T>> dVar) throws Throwable {
        p pVar = new p(a9.c.c(dVar), 1);
        pVar.C();
        int length = this.f29877a.length;
        a[] aVarArr = new a[length];
        for (int i10 = 0; i10 < length; i10++) {
            v0 v0Var = this.f29877a[i10];
            v0Var.start();
            a aVar = new a(pVar);
            aVar.w(v0Var.J(aVar));
            v8.k0 k0Var = v8.k0.f35197a;
            aVarArr[i10] = aVar;
        }
        e<T>.b bVar = new b(aVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            aVarArr[i11].v(bVar);
        }
        if (pVar.i()) {
            bVar.e();
        } else {
            pVar.m(bVar);
        }
        Object objZ = pVar.z();
        if (objZ == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objZ;
    }
}
