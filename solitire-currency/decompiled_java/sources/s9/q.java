package s9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Errors.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class q {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f33772a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h9.q f33773b;

        /* JADX INFO: renamed from: s9.q$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1", f = "Errors.kt", l = {114, 115}, m = "collect")
        public static final class C0681a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33774j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f33775k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f33777m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33778n;

            public C0681a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33774j = obj;
                this.f33775k |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(h hVar, h9.q qVar) {
            this.f33772a = hVar;
            this.f33773b = qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.h
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof s9.q.a.C0681a
                if (r0 == 0) goto L13
                r0 = r7
                s9.q$a$a r0 = (s9.q.a.C0681a) r0
                int r1 = r0.f33775k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33775k = r1
                goto L18
            L13:
                s9.q$a$a r0 = new s9.q$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f33774j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33775k
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                v8.u.b(r7)
                goto L6f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.f33778n
                s9.i r6 = (s9.i) r6
                java.lang.Object r2 = r0.f33777m
                s9.q$a r2 = (s9.q.a) r2
                v8.u.b(r7)
                goto L53
            L40:
                v8.u.b(r7)
                s9.h r7 = r5.f33772a
                r0.f33777m = r5
                r0.f33778n = r6
                r0.f33775k = r4
                java.lang.Object r7 = s9.j.i(r7, r6, r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                r2 = r5
            L53:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L6f
                h9.q r2 = r2.f33773b
                r4 = 0
                r0.f33777m = r4
                r0.f33778n = r4
                r0.f33775k = r3
                r3 = 6
                kotlin.jvm.internal.r.c(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.r.c(r7)
                if (r6 != r1) goto L6f
                return r1
            L6f:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.q.a.collect(s9.i, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt", f = "Errors.kt", l = {156}, m = "catchImpl")
    static final class b<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33779j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33780k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33781l;

        b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33780k = obj;
            this.f33781l |= Integer.MIN_VALUE;
            return j.i(null, null, this);
        }
    }

    /* JADX INFO: compiled from: Errors.kt */
    static final class c<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<T> f33782a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0<Throwable> f33783b;

        /* JADX INFO: compiled from: Errors.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$catchImpl$2", f = "Errors.kt", l = {158}, m = "emit")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f33784j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f33785k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ c<T> f33786l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            int f33787m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(c<? super T> cVar, z8.d<? super a> dVar) {
                super(dVar);
                this.f33786l = cVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33785k = obj;
                this.f33787m |= Integer.MIN_VALUE;
                return this.f33786l.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(i<? super T> iVar, kotlin.jvm.internal.n0<Throwable> n0Var) {
            this.f33782a = iVar;
            this.f33783b = n0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof s9.q.c.a
                if (r0 == 0) goto L13
                r0 = r6
                s9.q$c$a r0 = (s9.q.c.a) r0
                int r1 = r0.f33787m
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33787m = r1
                goto L18
            L13:
                s9.q$c$a r0 = new s9.q$c$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f33785k
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33787m
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f33784j
                s9.q$c r5 = (s9.q.c) r5
                v8.u.b(r6)     // Catch: java.lang.Throwable -> L2d
                goto L47
            L2d:
                r6 = move-exception
                goto L4c
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L37:
                v8.u.b(r6)
                s9.i<T> r6 = r4.f33782a     // Catch: java.lang.Throwable -> L4a
                r0.f33784j = r4     // Catch: java.lang.Throwable -> L4a
                r0.f33787m = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                v8.k0 r5 = v8.k0.f35197a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                kotlin.jvm.internal.n0<java.lang.Throwable> r5 = r5.f33783b
                r5.f29834a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.q.c.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    @NotNull
    public static final <T> h<T> a(@NotNull h<? extends T> hVar, @NotNull h9.q<? super i<? super T>, ? super Throwable, ? super z8.d<? super v8.k0>, ? extends Object> qVar) {
        return new a(hVar, qVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull s9.h<? extends T> r4, @org.jetbrains.annotations.NotNull s9.i<? super T> r5, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Throwable> r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof s9.q.b
            if (r0 == 0) goto L13
            r0 = r6
            s9.q$b r0 = (s9.q.b) r0
            int r1 = r0.f33781l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33781l = r1
            goto L18
        L13:
            s9.q$b r0 = new s9.q$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f33780k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33781l
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f33779j
            kotlin.jvm.internal.n0 r4 = (kotlin.jvm.internal.n0) r4
            v8.u.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            v8.u.b(r6)
            kotlin.jvm.internal.n0 r6 = new kotlin.jvm.internal.n0
            r6.<init>()
            s9.q$c r2 = new s9.q$c     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.f33779j = r6     // Catch: java.lang.Throwable -> L51
            r0.f33781l = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            T r4 = r4.f29834a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            z8.g r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            v8.e.a(r4, r5)
            throw r4
        L72:
            v8.e.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.q.b(s9.h, s9.i, z8.d):java.lang.Object");
    }

    private static final boolean c(Throwable th, z8.g gVar) {
        b2 b2Var = (b2) gVar.get(b2.O7);
        if (b2Var == null || !b2Var.isCancelled()) {
            return false;
        }
        return d(th, b2Var.x());
    }

    private static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && kotlin.jvm.internal.t.d(th2, th);
    }
}
