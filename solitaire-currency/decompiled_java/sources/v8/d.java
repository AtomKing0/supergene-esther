package v8;

import kotlin.jvm.internal.t0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: compiled from: DeepRecursive.kt */
/* JADX INFO: loaded from: classes5.dex */
final class d<T, R> extends c<T, R> implements z8.d<R> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private h9.q<? super c<?, ?>, Object, ? super z8.d<Object>, ? extends Object> f35172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private Object f35173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private z8.d<Object> f35174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private Object f35175d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull h9.q<? super c<T, R>, ? super T, ? super z8.d<? super R>, ? extends Object> block, T t10) {
        super(null);
        kotlin.jvm.internal.t.i(block, "block");
        this.f35172a = block;
        this.f35173b = t10;
        kotlin.jvm.internal.t.g(this, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f35174c = this;
        this.f35175d = b.f35166a;
    }

    @Override // v8.c
    @Nullable
    public Object a(T t10, @NotNull z8.d<? super R> dVar) {
        kotlin.jvm.internal.t.g(dVar, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
        this.f35174c = dVar;
        this.f35173b = t10;
        Object objE = a9.d.e();
        if (objE == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objE;
    }

    public final R c() {
        while (true) {
            R r10 = (R) this.f35175d;
            z8.d<Object> dVar = this.f35174c;
            if (dVar == null) {
                u.b(r10);
                return r10;
            }
            if (t.d(b.f35166a, r10)) {
                try {
                    h9.q<? super c<?, ?>, Object, ? super z8.d<Object>, ? extends Object> qVar = this.f35172a;
                    Object obj = this.f35173b;
                    Object objD = !(qVar instanceof kotlin.coroutines.jvm.internal.a) ? a9.c.d(qVar, this, obj, dVar) : ((h9.q) t0.f(qVar, 3)).invoke(this, obj, dVar);
                    if (objD != a9.d.e()) {
                        dVar.resumeWith(t.b(objD));
                    }
                } catch (Throwable th) {
                    t.a aVar = t.f35208b;
                    dVar.resumeWith(t.b(u.a(th)));
                }
            } else {
                this.f35175d = b.f35166a;
                dVar.resumeWith(r10);
            }
        }
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        return z8.h.f37608a;
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        this.f35174c = null;
        this.f35175d = obj;
    }
}
