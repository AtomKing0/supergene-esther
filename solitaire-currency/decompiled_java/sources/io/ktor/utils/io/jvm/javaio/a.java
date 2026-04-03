package io.ktor.utils.io.jvm.javaio;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t0;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.b2;
import kotlinx.coroutines.g1;
import kotlinx.coroutines.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.q;
import v8.t;
import v8.u;

/* JADX INFO: compiled from: Blocking.kt */
/* JADX INFO: loaded from: classes3.dex */
abstract class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final /* synthetic */ AtomicReferenceFieldUpdater f26880f = AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "state");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final b2 f26881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final z8.d<k0> f26882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final g1 f26883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f26884d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f26885e;

    @NotNull
    volatile /* synthetic */ int result;

    @NotNull
    volatile /* synthetic */ Object state;

    /* JADX INFO: renamed from: io.ktor.utils.io.jvm.javaio.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Blocking.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.jvm.javaio.BlockingAdapter$block$1", f = "Blocking.kt", l = {186}, m = "invokeSuspend")
    static final class C0578a extends l implements h9.l<z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f26886j;

        C0578a(z8.d<? super C0578a> dVar) {
            super(1, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@NotNull z8.d<?> dVar) {
            return a.this.new C0578a(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f26886j;
            if (i10 == 0) {
                u.b(obj);
                a aVar = a.this;
                this.f26886j = 1;
                if (aVar.h(this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }

        @Override // h9.l
        @Nullable
        public final Object invoke(@Nullable z8.d<? super k0> dVar) {
            return ((C0578a) create(dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX INFO: compiled from: Blocking.kt */
    static final class b extends v implements h9.l<Throwable, k0> {
        b() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(Throwable th) {
            invoke2(th);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@Nullable Throwable th) {
            if (th != null) {
                z8.d dVar = a.this.f26882b;
                t.a aVar = t.f35208b;
                dVar.resumeWith(t.b(u.a(th)));
            }
        }
    }

    /* JADX INFO: compiled from: Blocking.kt */
    public static final class c implements z8.d<k0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final z8.g f26889a;

        c() {
            this.f26889a = a.this.g() != null ? i.f26918a.plus(a.this.g()) : i.f26918a;
        }

        @Override // z8.d
        @NotNull
        public z8.g getContext() {
            return this.f26889a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // z8.d
        public void resumeWith(@NotNull Object obj) {
            Object obj2;
            boolean z10;
            Throwable thE;
            b2 b2VarG;
            Object objE = t.e(obj);
            if (objE == null) {
                objE = k0.f35197a;
            }
            a aVar = a.this;
            do {
                obj2 = aVar.state;
                z10 = obj2 instanceof Thread;
                if (!(z10 ? true : obj2 instanceof z8.d ? true : kotlin.jvm.internal.t.d(obj2, this))) {
                    return;
                }
            } while (!androidx.concurrent.futures.a.a(a.f26880f, aVar, obj2, objE));
            if (z10) {
                f.a().b(obj2);
            } else if ((obj2 instanceof z8.d) && (thE = t.e(obj)) != null) {
                ((z8.d) obj2).resumeWith(t.b(u.a(thE)));
            }
            if (t.g(obj) && !(t.e(obj) instanceof CancellationException) && (b2VarG = a.this.g()) != null) {
                b2.a.a(b2VarG, null, 1, null);
            }
            g1 g1Var = a.this.f26883c;
            if (g1Var != null) {
                g1Var.dispose();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public a() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    private final void i(Thread thread) {
        if (this.state != thread) {
            return;
        }
        if (!f.b()) {
            io.ktor.utils.io.jvm.javaio.b.b().a("Blocking network thread detected. \nIt can possible lead to a performance decline or even a deadlock.\nPlease make sure you're using blocking IO primitives like InputStream and OutputStream only in \nthe context of Dispatchers.IO:\n```\nwithContext(Dispatchers.IO) {\n    myInputStream.read()\n}\n```");
        }
        while (true) {
            long jB = n1.b();
            if (this.state != thread) {
                return;
            }
            if (jB > 0) {
                f.a().a(jB);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final Object j(z8.d<Object> dVar) {
        Object obj;
        z8.d dVarC;
        Object obj2 = null;
        while (true) {
            Object obj3 = this.state;
            if (obj3 instanceof Thread) {
                dVarC = a9.c.c(dVar);
                obj = obj3;
            } else {
                if (!kotlin.jvm.internal.t.d(obj3, this)) {
                    throw new IllegalStateException("Already suspended or in finished state");
                }
                obj = obj2;
                dVarC = a9.c.c(dVar);
            }
            if (androidx.concurrent.futures.a.a(f26880f, this, obj3, dVarC)) {
                if (obj != null) {
                    f.a().b(obj);
                }
                return a9.d.e();
            }
            obj2 = obj;
        }
    }

    protected final void d(int i10) {
        this.result = i10;
    }

    protected final int e() {
        return this.f26885e;
    }

    protected final int f() {
        return this.f26884d;
    }

    @Nullable
    public final b2 g() {
        return this.f26881a;
    }

    @Nullable
    protected abstract Object h(@NotNull z8.d<? super k0> dVar);

    public final void k() {
        g1 g1Var = this.f26883c;
        if (g1Var != null) {
            g1Var.dispose();
        }
        z8.d<k0> dVar = this.f26882b;
        t.a aVar = t.f35208b;
        dVar.resumeWith(t.b(u.a(new CancellationException("Stream closed"))));
    }

    public final int l(@NotNull Object jobToken) throws Throwable {
        Object obj;
        Object qVar;
        kotlin.jvm.internal.t.i(jobToken, "jobToken");
        Thread thread = Thread.currentThread();
        z8.d dVar = null;
        do {
            obj = this.state;
            if (obj instanceof z8.d) {
                kotlin.jvm.internal.t.g(obj, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any>");
                dVar = (z8.d) obj;
                qVar = thread;
            } else {
                if (obj instanceof k0) {
                    return this.result;
                }
                if (obj instanceof Throwable) {
                    throw ((Throwable) obj);
                }
                if (obj instanceof Thread) {
                    throw new IllegalStateException("There is already thread owning adapter");
                }
                if (kotlin.jvm.internal.t.d(obj, this)) {
                    throw new IllegalStateException("Not yet started");
                }
                qVar = new q();
            }
            kotlin.jvm.internal.t.h(qVar, "when (value) {\n         …Exception()\n            }");
        } while (!androidx.concurrent.futures.a.a(f26880f, this, obj, qVar));
        kotlin.jvm.internal.t.f(dVar);
        dVar.resumeWith(t.b(jobToken));
        kotlin.jvm.internal.t.h(thread, "thread");
        i(thread);
        Object obj2 = this.state;
        if (obj2 instanceof Throwable) {
            throw ((Throwable) obj2);
        }
        return this.result;
    }

    public final int m(@NotNull byte[] buffer, int i10, int i11) {
        kotlin.jvm.internal.t.i(buffer, "buffer");
        this.f26884d = i10;
        this.f26885e = i11;
        return l(buffer);
    }

    public a(@Nullable b2 b2Var) {
        this.f26881a = b2Var;
        c cVar = new c();
        this.f26882b = cVar;
        this.state = this;
        this.result = 0;
        this.f26883c = b2Var != null ? b2Var.J(new b()) : null;
        ((h9.l) t0.f(new C0578a(null), 1)).invoke(cVar);
        if (!(this.state != this)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public /* synthetic */ a(b2 b2Var, int i10, k kVar) {
        this((i10 & 1) != 0 ? null : b2Var);
    }
}
