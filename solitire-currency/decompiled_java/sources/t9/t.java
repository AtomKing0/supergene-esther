package t9;

import kotlinx.coroutines.f2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import z8.g;

/* JADX INFO: compiled from: SafeCollector.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class t<T> extends kotlin.coroutines.jvm.internal.d implements s9.i<T> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public final s9.i<T> f34174j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NotNull
    public final z8.g f34175k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f34176l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    private z8.g f34177m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @Nullable
    private z8.d<? super k0> f34178n;

    /* JADX INFO: compiled from: SafeCollector.kt */
    static final class a extends kotlin.jvm.internal.v implements h9.p<Integer, g.b, Integer> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f34179g = new a();

        a() {
            super(2);
        }

        @NotNull
        public final Integer a(int i10, @NotNull g.b bVar) {
            return Integer.valueOf(i10 + 1);
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ Integer mo4invoke(Integer num, g.b bVar) {
            return a(num.intValue(), bVar);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public t(@NotNull s9.i<? super T> iVar, @NotNull z8.g gVar) {
        super(q.f34168a, z8.h.f37608a);
        this.f34174j = iVar;
        this.f34175k = gVar;
        this.f34176l = ((Number) gVar.fold(0, a.f34179g)).intValue();
    }

    private final void f(z8.g gVar, z8.g gVar2, T t10) {
        if (gVar2 instanceof l) {
            h((l) gVar2, t10);
        }
        v.a(this, gVar);
    }

    private final Object g(z8.d<? super k0> dVar, T t10) {
        z8.g context = dVar.getContext();
        f2.k(context);
        z8.g gVar = this.f34177m;
        if (gVar != context) {
            f(context, gVar, t10);
            this.f34177m = context;
        }
        this.f34178n = dVar;
        h9.q qVar = u.f34180a;
        s9.i<T> iVar = this.f34174j;
        kotlin.jvm.internal.t.g(iVar, "null cannot be cast to non-null type kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>");
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Unit>");
        Object objInvoke = qVar.invoke(iVar, t10, this);
        if (!kotlin.jvm.internal.t.d(objInvoke, a9.d.e())) {
            this.f34178n = null;
        }
        return objInvoke;
    }

    private final void h(l lVar, Object obj) {
        throw new IllegalStateException(p9.j.f("\n            Flow exception transparency is violated:\n                Previous 'emit' call has thrown exception " + lVar.f34166a + ", but then emission attempt of value '" + obj + "' has been detected.\n                Emissions from 'catch' blocks are prohibited in order to avoid unspecified behaviour, 'Flow.catch' operator can be used instead.\n                For a more detailed explanation, please refer to Flow documentation.\n            ").toString());
    }

    @Override // s9.i
    @Nullable
    public Object emit(T t10, @NotNull z8.d<? super k0> dVar) {
        try {
            Object objG = g(dVar, t10);
            if (objG == a9.d.e()) {
                kotlin.coroutines.jvm.internal.h.c(dVar);
            }
            return objG == a9.d.e() ? objG : k0.f35197a;
        } catch (Throwable th) {
            this.f34177m = new l(th, dVar.getContext());
            throw th;
        }
    }

    @Override // kotlin.coroutines.jvm.internal.a, kotlin.coroutines.jvm.internal.e
    @Nullable
    public kotlin.coroutines.jvm.internal.e getCallerFrame() {
        z8.d<? super k0> dVar = this.f34178n;
        if (dVar instanceof kotlin.coroutines.jvm.internal.e) {
            return (kotlin.coroutines.jvm.internal.e) dVar;
        }
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.d, z8.d
    @NotNull
    public z8.g getContext() {
        z8.g gVar = this.f34177m;
        return gVar == null ? z8.h.f37608a : gVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public Object invokeSuspend(@NotNull Object obj) {
        Throwable thE = v8.t.e(obj);
        if (thE != null) {
            this.f34177m = new l(thE, getContext());
        }
        z8.d<? super k0> dVar = this.f34178n;
        if (dVar != null) {
            dVar.resumeWith(obj);
        }
        return a9.d.e();
    }

    @Override // kotlin.coroutines.jvm.internal.d, kotlin.coroutines.jvm.internal.a
    public void releaseIntercepted() {
        super.releaseIntercepted();
    }
}
