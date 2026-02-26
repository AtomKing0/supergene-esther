package io.ktor.utils.io.internal;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.g1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: CancellableReusableContinuation.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b<T> implements z8.d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26825a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "state");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f26826b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "jobCancellationHandler");

    @NotNull
    private volatile /* synthetic */ Object state = null;

    @NotNull
    private volatile /* synthetic */ Object jobCancellationHandler = null;

    /* JADX INFO: compiled from: CancellableReusableContinuation.kt */
    private final class a implements h9.l<Throwable, k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final b2 f26827a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private g1 f26828b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ b<T> f26829c;

        public a(@NotNull b bVar, b2 job) {
            t.i(job, "job");
            this.f26829c = bVar;
            this.f26827a = job;
            g1 g1VarD = b2.a.d(job, true, false, this, 2, null);
            if (job.isActive()) {
                this.f26828b = g1VarD;
            }
        }

        public final void a() {
            g1 g1Var = this.f26828b;
            if (g1Var != null) {
                this.f26828b = null;
                g1Var.dispose();
            }
        }

        @NotNull
        public final b2 b() {
            return this.f26827a;
        }

        public void c(@Nullable Throwable th) {
            this.f26829c.g(this);
            a();
            if (th != null) {
                this.f26829c.n(this.f26827a, th);
            }
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            c(th);
            return k0.f35197a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(b<T>.a aVar) {
        androidx.concurrent.futures.a.a(f26826b, this, aVar, null);
    }

    private final void h(z8.g gVar) {
        Object obj;
        a aVar;
        b2 b2Var = (b2) gVar.get(b2.O7);
        a aVar2 = (a) this.jobCancellationHandler;
        if ((aVar2 != null ? aVar2.b() : null) == b2Var) {
            return;
        }
        if (b2Var == null) {
            a aVar3 = (a) f26826b.getAndSet(this, null);
            if (aVar3 != null) {
                aVar3.a();
                return;
            }
            return;
        }
        a aVar4 = new a(this, b2Var);
        do {
            obj = this.jobCancellationHandler;
            aVar = (a) obj;
            if (aVar != null && aVar.b() == b2Var) {
                aVar4.a();
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f26826b, this, obj, aVar4));
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(b2 b2Var, Throwable th) {
        Object obj;
        z8.d dVar;
        do {
            obj = this.state;
            if (!(obj instanceof z8.d)) {
                return;
            }
            dVar = (z8.d) obj;
            if (dVar.getContext().get(b2.O7) != b2Var) {
                return;
            }
        } while (!androidx.concurrent.futures.a.a(f26825a, this, obj, null));
        t.g(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<T of io.ktor.utils.io.internal.CancellableReusableContinuation>");
        t.a aVar = v8.t.f35208b;
        dVar.resumeWith(v8.t.b(u.a(th)));
    }

    public final void d(@NotNull T value) {
        kotlin.jvm.internal.t.i(value, "value");
        resumeWith(v8.t.b(value));
        a aVar = (a) f26826b.getAndSet(this, null);
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void e(@NotNull Throwable cause) {
        kotlin.jvm.internal.t.i(cause, "cause");
        t.a aVar = v8.t.f35208b;
        resumeWith(v8.t.b(u.a(cause)));
        a aVar2 = (a) f26826b.getAndSet(this, null);
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    @NotNull
    public final Object f(@NotNull z8.d<? super T> actual) {
        kotlin.jvm.internal.t.i(actual, "actual");
        while (true) {
            Object obj = this.state;
            if (obj == null) {
                if (androidx.concurrent.futures.a.a(f26825a, this, null, actual)) {
                    h(actual.getContext());
                    return a9.d.e();
                }
            } else if (androidx.concurrent.futures.a.a(f26825a, this, obj, null)) {
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type T of io.ktor.utils.io.internal.CancellableReusableContinuation");
                return obj;
            }
        }
    }

    @Override // z8.d
    @NotNull
    public z8.g getContext() {
        z8.g context;
        Object obj = this.state;
        z8.d dVar = obj instanceof z8.d ? (z8.d) obj : null;
        return (dVar == null || (context = dVar.getContext()) == null) ? z8.h.f37608a : context;
    }

    @Override // z8.d
    public void resumeWith(@NotNull Object obj) {
        Object obj2;
        Object objE;
        do {
            obj2 = this.state;
            if (obj2 == null) {
                objE = v8.t.e(obj);
                if (objE == null) {
                    u.b(obj);
                    objE = obj;
                }
            } else if (!(obj2 instanceof z8.d)) {
                return;
            } else {
                objE = null;
            }
        } while (!androidx.concurrent.futures.a.a(f26825a, this, obj2, objE));
        if (obj2 instanceof z8.d) {
            ((z8.d) obj2).resumeWith(obj);
        }
    }
}
