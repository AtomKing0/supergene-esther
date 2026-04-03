package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Reduce.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class t {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class a<T> implements s9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0 f33854a;

        public a(kotlin.jvm.internal.n0 n0Var) {
            this.f33854a = n0Var;
        }

        @Override // s9.i
        @Nullable
        public Object emit(T t10, @NotNull z8.d<? super v8.k0> dVar) {
            this.f33854a.f29834a = t10;
            throw new t9.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class b<T> implements s9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9.p f33855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0 f33856b;

        /* JADX INFO: compiled from: Limit.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$first$$inlined$collectWhile$2", f = "Reduce.kt", l = {142}, m = "emit")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f33857j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f33858k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33859l;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33861n;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33858k = obj;
                this.f33859l |= Integer.MIN_VALUE;
                return b.this.emit(null, this);
            }
        }

        public b(h9.p pVar, kotlin.jvm.internal.n0 n0Var) {
            this.f33855a = pVar;
            this.f33856b = n0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof s9.t.b.a
                if (r0 == 0) goto L13
                r0 = r6
                s9.t$b$a r0 = (s9.t.b.a) r0
                int r1 = r0.f33859l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33859l = r1
                goto L18
            L13:
                s9.t$b$a r0 = new s9.t$b$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f33858k
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33859l
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f33861n
                java.lang.Object r0 = r0.f33857j
                s9.t$b r0 = (s9.t.b) r0
                v8.u.b(r6)
                goto L52
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L37:
                v8.u.b(r6)
                h9.p r6 = r4.f33855a
                r0.f33857j = r4
                r0.f33861n = r5
                r0.f33859l = r3
                r2 = 6
                kotlin.jvm.internal.r.c(r2)
                java.lang.Object r6 = r6.mo4invoke(r5, r0)
                r0 = 7
                kotlin.jvm.internal.r.c(r0)
                if (r6 != r1) goto L51
                return r1
            L51:
                r0 = r4
            L52:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L5f
                kotlin.jvm.internal.n0 r6 = r0.f33856b
                r6.f29834a = r5
                r3 = 0
            L5f:
                if (r3 == 0) goto L64
                v8.k0 r5 = v8.k0.f35197a
                return r5
            L64:
                t9.a r5 = new t9.a
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.t.b.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "first")
    static final class c<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33862j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33863k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33864l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33865m;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33864l = obj;
            this.f33865m |= Integer.MIN_VALUE;
            return s9.j.w(null, this);
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "first")
    static final class d<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33866j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33867k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33868l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f33869m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f33870n;

        d(z8.d<? super d> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33869m = obj;
            this.f33870n |= Integer.MIN_VALUE;
            return s9.j.v(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class e<T> implements s9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0 f33871a;

        public e(kotlin.jvm.internal.n0 n0Var) {
            this.f33871a = n0Var;
        }

        @Override // s9.i
        @Nullable
        public Object emit(T t10, @NotNull z8.d<? super v8.k0> dVar) {
            this.f33871a.f29834a = t10;
            throw new t9.a(this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class f<T> implements s9.i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9.p f33872a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0 f33873b;

        /* JADX INFO: compiled from: Limit.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt$firstOrNull$$inlined$collectWhile$2", f = "Reduce.kt", l = {142}, m = "emit")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f33874j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f33875k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33876l;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33878n;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33875k = obj;
                this.f33876l |= Integer.MIN_VALUE;
                return f.this.emit(null, this);
            }
        }

        public f(h9.p pVar, kotlin.jvm.internal.n0 n0Var) {
            this.f33872a = pVar;
            this.f33873b = n0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof s9.t.f.a
                if (r0 == 0) goto L13
                r0 = r6
                s9.t$f$a r0 = (s9.t.f.a) r0
                int r1 = r0.f33876l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33876l = r1
                goto L18
            L13:
                s9.t$f$a r0 = new s9.t$f$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f33875k
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33876l
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f33878n
                java.lang.Object r0 = r0.f33874j
                s9.t$f r0 = (s9.t.f) r0
                v8.u.b(r6)
                goto L52
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L37:
                v8.u.b(r6)
                h9.p r6 = r4.f33872a
                r0.f33874j = r4
                r0.f33878n = r5
                r0.f33876l = r3
                r2 = 6
                kotlin.jvm.internal.r.c(r2)
                java.lang.Object r6 = r6.mo4invoke(r5, r0)
                r0 = 7
                kotlin.jvm.internal.r.c(r0)
                if (r6 != r1) goto L51
                return r1
            L51:
                r0 = r4
            L52:
                java.lang.Boolean r6 = (java.lang.Boolean) r6
                boolean r6 = r6.booleanValue()
                if (r6 == 0) goto L5f
                kotlin.jvm.internal.n0 r6 = r0.f33873b
                r6.f29834a = r5
                r3 = 0
            L5f:
                if (r3 == 0) goto L64
                v8.k0 r5 = v8.k0.f35197a
                return r5
            L64:
                t9.a r5 = new t9.a
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.t.f.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "firstOrNull")
    static final class g<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33879j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33880k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33881l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33882m;

        g(z8.d<? super g> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33881l = obj;
            this.f33882m |= Integer.MIN_VALUE;
            return s9.j.y(null, this);
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {183}, m = "firstOrNull")
    static final class h<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33883j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33884k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        /* synthetic */ Object f33885l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f33886m;

        h(z8.d<? super h> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33885l = obj;
            this.f33886m |= Integer.MIN_VALUE;
            return s9.j.x(null, null, this);
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ReduceKt", f = "Reduce.kt", l = {57}, m = "single")
    static final class i<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33887j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33888k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33889l;

        i(z8.d<? super i> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33888k = obj;
            this.f33889l |= Integer.MIN_VALUE;
            return s9.j.K(null, this);
        }
    }

    /* JADX INFO: compiled from: Reduce.kt */
    static final class j<T> implements s9.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0<Object> f33890a;

        j(kotlin.jvm.internal.n0<Object> n0Var) {
            this.f33890a = n0Var;
        }

        @Override // s9.i
        @Nullable
        public final Object emit(T t10, @NotNull z8.d<? super v8.k0> dVar) {
            kotlin.jvm.internal.n0<Object> n0Var = this.f33890a;
            if (!(n0Var.f29834a == t9.s.f34171a)) {
                throw new IllegalArgumentException("Flow has more than one element".toString());
            }
            n0Var.f29834a = t10;
            return v8.k0.f35197a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object a(@org.jetbrains.annotations.NotNull s9.h<? extends T> r4, @org.jetbrains.annotations.NotNull h9.p<? super T, ? super z8.d<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull z8.d<? super T> r6) {
        /*
            boolean r0 = r6 instanceof s9.t.d
            if (r0 == 0) goto L13
            r0 = r6
            s9.t$d r0 = (s9.t.d) r0
            int r1 = r0.f33870n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33870n = r1
            goto L18
        L13:
            s9.t$d r0 = new s9.t$d
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f33869m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33870n
            r3 = 1
            if (r2 == 0) goto L3f
            if (r2 != r3) goto L37
            java.lang.Object r4 = r0.f33868l
            s9.t$b r4 = (s9.t.b) r4
            java.lang.Object r5 = r0.f33867k
            kotlin.jvm.internal.n0 r5 = (kotlin.jvm.internal.n0) r5
            java.lang.Object r0 = r0.f33866j
            h9.p r0 = (h9.p) r0
            v8.u.b(r6)     // Catch: t9.a -> L35
            goto L6a
        L35:
            r6 = move-exception
            goto L67
        L37:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3f:
            v8.u.b(r6)
            kotlin.jvm.internal.n0 r6 = new kotlin.jvm.internal.n0
            r6.<init>()
            u9.h0 r2 = t9.s.f34171a
            r6.f29834a = r2
            s9.t$b r2 = new s9.t$b
            r2.<init>(r5, r6)
            r0.f33866j = r5     // Catch: t9.a -> L62
            r0.f33867k = r6     // Catch: t9.a -> L62
            r0.f33868l = r2     // Catch: t9.a -> L62
            r0.f33870n = r3     // Catch: t9.a -> L62
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: t9.a -> L62
            if (r4 != r1) goto L5f
            return r1
        L5f:
            r0 = r5
            r5 = r6
            goto L6a
        L62:
            r4 = move-exception
            r0 = r5
            r5 = r6
            r6 = r4
            r4 = r2
        L67:
            t9.o.a(r6, r4)
        L6a:
            T r4 = r5.f29834a
            u9.h0 r5 = t9.s.f34171a
            if (r4 == r5) goto L71
            return r4
        L71:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Expected at least one element matching the predicate "
            r5.append(r6)
            r5.append(r0)
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.t.a(s9.h, h9.p, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object b(@org.jetbrains.annotations.NotNull s9.h<? extends T> r4, @org.jetbrains.annotations.NotNull z8.d<? super T> r5) {
        /*
            boolean r0 = r5 instanceof s9.t.c
            if (r0 == 0) goto L13
            r0 = r5
            s9.t$c r0 = (s9.t.c) r0
            int r1 = r0.f33865m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33865m = r1
            goto L18
        L13:
            s9.t$c r0 = new s9.t$c
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f33864l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33865m
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f33863k
            s9.t$a r4 = (s9.t.a) r4
            java.lang.Object r0 = r0.f33862j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r5)     // Catch: t9.a -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            v8.u.b(r5)
            kotlin.jvm.internal.n0 r5 = new kotlin.jvm.internal.n0
            r5.<init>()
            u9.h0 r2 = t9.s.f34171a
            r5.f29834a = r2
            s9.t$a r2 = new s9.t$a
            r2.<init>(r5)
            r0.f33862j = r5     // Catch: t9.a -> L5b
            r0.f33863k = r2     // Catch: t9.a -> L5b
            r0.f33865m = r3     // Catch: t9.a -> L5b
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: t9.a -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            t9.o.a(r5, r4)
        L62:
            T r4 = r0.f29834a
            u9.h0 r5 = t9.s.f34171a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.t.b(s9.h, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(@org.jetbrains.annotations.NotNull s9.h<? extends T> r4, @org.jetbrains.annotations.NotNull h9.p<? super T, ? super z8.d<? super java.lang.Boolean>, ? extends java.lang.Object> r5, @org.jetbrains.annotations.NotNull z8.d<? super T> r6) {
        /*
            boolean r0 = r6 instanceof s9.t.h
            if (r0 == 0) goto L13
            r0 = r6
            s9.t$h r0 = (s9.t.h) r0
            int r1 = r0.f33886m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33886m = r1
            goto L18
        L13:
            s9.t$h r0 = new s9.t$h
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f33885l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33886m
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f33884k
            s9.t$f r4 = (s9.t.f) r4
            java.lang.Object r5 = r0.f33883j
            kotlin.jvm.internal.n0 r5 = (kotlin.jvm.internal.n0) r5
            v8.u.b(r6)     // Catch: t9.a -> L31
            goto L5e
        L31:
            r6 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            v8.u.b(r6)
            kotlin.jvm.internal.n0 r6 = new kotlin.jvm.internal.n0
            r6.<init>()
            s9.t$f r2 = new s9.t$f
            r2.<init>(r5, r6)
            r0.f33883j = r6     // Catch: t9.a -> L57
            r0.f33884k = r2     // Catch: t9.a -> L57
            r0.f33886m = r3     // Catch: t9.a -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: t9.a -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r5 = r6
            goto L5e
        L57:
            r4 = move-exception
            r5 = r6
            r6 = r4
            r4 = r2
        L5b:
            t9.o.a(r6, r4)
        L5e:
            T r4 = r5.f29834a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.t.c(s9.h, h9.p, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object d(@org.jetbrains.annotations.NotNull s9.h<? extends T> r4, @org.jetbrains.annotations.NotNull z8.d<? super T> r5) {
        /*
            boolean r0 = r5 instanceof s9.t.g
            if (r0 == 0) goto L13
            r0 = r5
            s9.t$g r0 = (s9.t.g) r0
            int r1 = r0.f33882m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33882m = r1
            goto L18
        L13:
            s9.t$g r0 = new s9.t$g
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f33881l
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33882m
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.f33880k
            s9.t$e r4 = (s9.t.e) r4
            java.lang.Object r0 = r0.f33879j
            kotlin.jvm.internal.n0 r0 = (kotlin.jvm.internal.n0) r0
            v8.u.b(r5)     // Catch: t9.a -> L31
            goto L5e
        L31:
            r5 = move-exception
            goto L5b
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            v8.u.b(r5)
            kotlin.jvm.internal.n0 r5 = new kotlin.jvm.internal.n0
            r5.<init>()
            s9.t$e r2 = new s9.t$e
            r2.<init>(r5)
            r0.f33879j = r5     // Catch: t9.a -> L57
            r0.f33880k = r2     // Catch: t9.a -> L57
            r0.f33882m = r3     // Catch: t9.a -> L57
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: t9.a -> L57
            if (r4 != r1) goto L55
            return r1
        L55:
            r0 = r5
            goto L5e
        L57:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5b:
            t9.o.a(r5, r4)
        L5e:
            T r4 = r0.f29834a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.t.d(s9.h, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object e(@org.jetbrains.annotations.NotNull s9.h<? extends T> r4, @org.jetbrains.annotations.NotNull z8.d<? super T> r5) {
        /*
            boolean r0 = r5 instanceof s9.t.i
            if (r0 == 0) goto L13
            r0 = r5
            s9.t$i r0 = (s9.t.i) r0
            int r1 = r0.f33889l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33889l = r1
            goto L18
        L13:
            s9.t$i r0 = new s9.t$i
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f33888k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33889l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.f33887j
            kotlin.jvm.internal.n0 r4 = (kotlin.jvm.internal.n0) r4
            v8.u.b(r5)
            goto L52
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            v8.u.b(r5)
            kotlin.jvm.internal.n0 r5 = new kotlin.jvm.internal.n0
            r5.<init>()
            u9.h0 r2 = t9.s.f34171a
            r5.f29834a = r2
            s9.t$j r2 = new s9.t$j
            r2.<init>(r5)
            r0.f33887j = r5
            r0.f33889l = r3
            java.lang.Object r4 = r4.collect(r2, r0)
            if (r4 != r1) goto L51
            return r1
        L51:
            r4 = r5
        L52:
            T r4 = r4.f29834a
            u9.h0 r5 = t9.s.f34171a
            if (r4 == r5) goto L59
            return r4
        L59:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Flow is empty"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.t.e(s9.h, z8.d):java.lang.Object");
    }
}
