package l8;

import h9.q;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: DebugPipelineContext.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a<TSubject, TContext> extends e<TSubject, TContext> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final List<q<e<TSubject, TContext>, TSubject, z8.d<? super k0>, Object>> f30935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final z8.g f30936c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private TSubject f30937d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30938e;

    /* JADX INFO: renamed from: l8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DebugPipelineContext.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.util.pipeline.DebugPipelineContext", f = "DebugPipelineContext.kt", l = {80}, m = "proceedLoop")
    static final class C0623a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f30939j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f30940k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ a<TSubject, TContext> f30941l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f30942m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0623a(a<TSubject, TContext> aVar, z8.d<? super C0623a> dVar) {
            super(dVar);
            this.f30941l = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f30940k = obj;
            this.f30942m |= Integer.MIN_VALUE;
            return this.f30941l.i(this);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public a(@NotNull TContext context, @NotNull List<? extends q<? super e<TSubject, TContext>, ? super TSubject, ? super z8.d<? super k0>, ? extends Object>> interceptors, @NotNull TSubject subject, @NotNull z8.g coroutineContext) {
        super(context);
        t.i(context, "context");
        t.i(interceptors, "interceptors");
        t.i(subject, "subject");
        t.i(coroutineContext, "coroutineContext");
        this.f30935b = interceptors;
        this.f30936c = coroutineContext;
        this.f30937d = subject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(z8.d<? super TSubject> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof l8.a.C0623a
            if (r0 == 0) goto L13
            r0 = r7
            l8.a$a r0 = (l8.a.C0623a) r0
            int r1 = r0.f30942m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f30942m = r1
            goto L18
        L13:
            l8.a$a r0 = new l8.a$a
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.f30940k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f30942m
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r2 = r0.f30939j
            l8.a r2 = (l8.a) r2
            v8.u.b(r7)
            goto L39
        L2d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L35:
            v8.u.b(r7)
            r2 = r6
        L39:
            int r7 = r2.f30938e
            r4 = -1
            if (r7 != r4) goto L3f
            goto L4a
        L3f:
            java.util.List<h9.q<l8.e<TSubject, TContext>, TSubject, z8.d<? super v8.k0>, java.lang.Object>> r4 = r2.f30935b
            int r5 = r4.size()
            if (r7 < r5) goto L4f
            r2.g()
        L4a:
            java.lang.Object r7 = r2.h()
            return r7
        L4f:
            java.lang.Object r4 = r4.get(r7)
            h9.q r4 = (h9.q) r4
            int r7 = r7 + 1
            r2.f30938e = r7
            java.lang.String r7 = "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.coroutines.SuspendFunction2<io.ktor.util.pipeline.PipelineContext<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext>, TSubject of io.ktor.util.pipeline.DebugPipelineContext, kotlin.Unit>{ io.ktor.util.pipeline.PipelineKt.PipelineInterceptor<TSubject of io.ktor.util.pipeline.DebugPipelineContext, TContext of io.ktor.util.pipeline.DebugPipelineContext> }"
            kotlin.jvm.internal.t.g(r4, r7)
            java.lang.Object r7 = r2.h()
            r0.f30939j = r2
            r0.f30942m = r3
            java.lang.Object r7 = r4.invoke(r2, r7, r0)
            if (r7 != r1) goto L39
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.a.i(z8.d):java.lang.Object");
    }

    @Override // l8.e
    @Nullable
    public Object b(@NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar) {
        this.f30938e = 0;
        j(tsubject);
        return d(dVar);
    }

    @Override // l8.e
    @Nullable
    public Object d(@NotNull z8.d<? super TSubject> dVar) {
        int i10 = this.f30938e;
        if (i10 < 0) {
            return h();
        }
        if (i10 < this.f30935b.size()) {
            return i(dVar);
        }
        g();
        return h();
    }

    @Override // l8.e
    @Nullable
    public Object e(@NotNull TSubject tsubject, @NotNull z8.d<? super TSubject> dVar) {
        j(tsubject);
        return d(dVar);
    }

    public void g() {
        this.f30938e = -1;
    }

    @Override // kotlinx.coroutines.o0
    @NotNull
    public z8.g getCoroutineContext() {
        return this.f30936c;
    }

    @NotNull
    public TSubject h() {
        return this.f30937d;
    }

    public void j(@NotNull TSubject tsubject) {
        t.i(tsubject, "<set-?>");
        this.f30937d = tsubject;
    }
}
