package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Limit.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class r {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements s9.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s9.h f33795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h9.p f33796b;

        public a(s9.h hVar, h9.p pVar) {
            this.f33795a = hVar;
            this.f33796b = pVar;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar) {
            Object objCollect = this.f33795a.collect(new b(new kotlin.jvm.internal.i0(), iVar, this.f33796b), dVar);
            return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
        }
    }

    /* JADX INFO: compiled from: Limit.kt */
    static final class b<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.i0 f33797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i<T> f33798b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h9.p<T, z8.d<? super Boolean>, Object> f33799c;

        /* JADX INFO: compiled from: Limit.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$dropWhile$1$1", f = "Limit.kt", l = {37, 38, 40}, m = "emit")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f33800j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            Object f33801k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            /* synthetic */ Object f33802l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ b<T> f33803m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            int f33804n;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(b<? super T> bVar, z8.d<? super a> dVar) {
                super(dVar);
                this.f33803m = bVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33802l = obj;
                this.f33804n |= Integer.MIN_VALUE;
                return this.f33803m.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        b(kotlin.jvm.internal.i0 i0Var, i<? super T> iVar, h9.p<? super T, ? super z8.d<? super Boolean>, ? extends Object> pVar) {
            this.f33797a = i0Var;
            this.f33798b = iVar;
            this.f33799c = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:36:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r7, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof s9.r.b.a
                if (r0 == 0) goto L13
                r0 = r8
                s9.r$b$a r0 = (s9.r.b.a) r0
                int r1 = r0.f33804n
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33804n = r1
                goto L18
            L13:
                s9.r$b$a r0 = new s9.r$b$a
                r0.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r0.f33802l
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33804n
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                v8.u.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.f33801k
                java.lang.Object r2 = r0.f33800j
                s9.r$b r2 = (s9.r.b) r2
                v8.u.b(r8)
                goto L6c
            L41:
                v8.u.b(r8)
                goto L59
            L45:
                v8.u.b(r8)
                kotlin.jvm.internal.i0 r8 = r6.f33797a
                boolean r8 = r8.f29826a
                if (r8 == 0) goto L5c
                s9.i<T> r8 = r6.f33798b
                r0.f33804n = r5
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L59
                return r1
            L59:
                v8.k0 r7 = v8.k0.f35197a
                return r7
            L5c:
                h9.p<T, z8.d<? super java.lang.Boolean>, java.lang.Object> r8 = r6.f33799c
                r0.f33800j = r6
                r0.f33801k = r7
                r0.f33804n = r4
                java.lang.Object r8 = r8.mo4invoke(r7, r0)
                if (r8 != r1) goto L6b
                return r1
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.i0 r8 = r2.f33797a
                r8.f29826a = r5
                s9.i<T> r8 = r2.f33798b
                r2 = 0
                r0.f33800j = r2
                r0.f33801k = r2
                r0.f33804n = r3
                java.lang.Object r7 = r8.emit(r7, r0)
                if (r7 != r1) goto L88
                return r1
            L88:
                v8.k0 r7 = v8.k0.f35197a
                return r7
            L8b:
                v8.k0 r7 = v8.k0.f35197a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.r.b.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: Limit.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt", f = "Limit.kt", l = {73}, m = "emitAbort$FlowKt__LimitKt")
    static final class c<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33805j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33806k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33807l;

        c(z8.d<? super c> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33806k = obj;
            this.f33807l |= Integer.MIN_VALUE;
            return r.c(null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class d<T> implements s9.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s9.h f33808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f33809b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$$inlined$unsafeFlow$1", f = "Limit.kt", l = {116}, m = "collect")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33810j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f33811k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f33813m;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33810j = obj;
                this.f33811k |= Integer.MIN_VALUE;
                return d.this.collect(null, this);
            }
        }

        public d(s9.h hVar, int i10) {
            this.f33808a = hVar;
            this.f33809b = i10;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, s9.i, s9.i<? super T>] */
        /* JADX WARN: Type inference failed for: r7v1, types: [s9.i] */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v9 */
        @Override // s9.h
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r7, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof s9.r.d.a
                if (r0 == 0) goto L13
                r0 = r8
                s9.r$d$a r0 = (s9.r.d.a) r0
                int r1 = r0.f33811k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33811k = r1
                goto L18
            L13:
                s9.r$d$a r0 = new s9.r$d$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f33810j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33811k
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r7 = r0.f33813m
                s9.i r7 = (s9.i) r7
                v8.u.b(r8)     // Catch: t9.a -> L51
                goto L55
            L2d:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L35:
                v8.u.b(r8)
                kotlin.jvm.internal.l0 r8 = new kotlin.jvm.internal.l0
                r8.<init>()
                s9.h r2 = r6.f33808a     // Catch: t9.a -> L51
                s9.r$e r4 = new s9.r$e     // Catch: t9.a -> L51
                int r5 = r6.f33809b     // Catch: t9.a -> L51
                r4.<init>(r8, r5, r7)     // Catch: t9.a -> L51
                r0.f33813m = r7     // Catch: t9.a -> L51
                r0.f33811k = r3     // Catch: t9.a -> L51
                java.lang.Object r7 = r2.collect(r4, r0)     // Catch: t9.a -> L51
                if (r7 != r1) goto L55
                return r1
            L51:
                r8 = move-exception
                t9.o.a(r8, r7)
            L55:
                v8.k0 r7 = v8.k0.f35197a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.r.d.collect(s9.i, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: Limit.kt */
    static final class e<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.l0 f33814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f33815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T> f33816c;

        /* JADX INFO: compiled from: Limit.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1", f = "Limit.kt", l = {61, 63}, m = "emit")
        static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33817j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ e<T> f33818k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33819l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            a(e<? super T> eVar, z8.d<? super a> dVar) {
                super(dVar);
                this.f33818k = eVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33817j = obj;
                this.f33819l |= Integer.MIN_VALUE;
                return this.f33818k.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        e(kotlin.jvm.internal.l0 l0Var, int i10, i<? super T> iVar) {
            this.f33814a = l0Var;
            this.f33815b = i10;
            this.f33816c = iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r6, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof s9.r.e.a
                if (r0 == 0) goto L13
                r0 = r7
                s9.r$e$a r0 = (s9.r.e.a) r0
                int r1 = r0.f33819l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33819l = r1
                goto L18
            L13:
                s9.r$e$a r0 = new s9.r$e$a
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f33817j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33819l
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L38
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                v8.u.b(r7)
                goto L5f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                v8.u.b(r7)
                goto L51
            L38:
                v8.u.b(r7)
                kotlin.jvm.internal.l0 r7 = r5.f33814a
                int r2 = r7.f29831a
                int r2 = r2 + r4
                r7.f29831a = r2
                int r7 = r5.f33815b
                if (r2 >= r7) goto L54
                s9.i<T> r7 = r5.f33816c
                r0.f33819l = r4
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L51
                return r1
            L51:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            L54:
                s9.i<T> r7 = r5.f33816c
                r0.f33819l = r3
                java.lang.Object r6 = s9.r.a(r7, r6, r0)
                if (r6 != r1) goto L5f
                return r1
            L5f:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.r.e.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class f<T> implements s9.h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ s9.h f33820a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h9.p f33821b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$$inlined$unsafeFlow$1", f = "Limit.kt", l = {125}, m = "collect")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33822j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f33823k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f33825m;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33822j = obj;
                this.f33823k |= Integer.MIN_VALUE;
                return f.this.collect(null, this);
            }
        }

        public f(s9.h hVar, h9.p pVar) {
            this.f33820a = hVar;
            this.f33821b = pVar;
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
                boolean r0 = r7 instanceof s9.r.f.a
                if (r0 == 0) goto L13
                r0 = r7
                s9.r$f$a r0 = (s9.r.f.a) r0
                int r1 = r0.f33823k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33823k = r1
                goto L18
            L13:
                s9.r$f$a r0 = new s9.r$f$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f33822j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33823k
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r6 = r0.f33825m
                s9.r$g r6 = (s9.r.g) r6
                v8.u.b(r7)     // Catch: t9.a -> L2d
                goto L53
            L2d:
                r7 = move-exception
                goto L50
            L2f:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L37:
                v8.u.b(r7)
                s9.h r7 = r5.f33820a
                s9.r$g r2 = new s9.r$g
                h9.p r4 = r5.f33821b
                r2.<init>(r4, r6)
                r0.f33825m = r2     // Catch: t9.a -> L4e
                r0.f33823k = r3     // Catch: t9.a -> L4e
                java.lang.Object r6 = r7.collect(r2, r0)     // Catch: t9.a -> L4e
                if (r6 != r1) goto L53
                return r1
            L4e:
                r7 = move-exception
                r6 = r2
            L50:
                t9.o.a(r7, r6)
            L53:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.r.f.collect(s9.i, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: Limit.kt */
    public static final class g<T> implements i<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9.p f33826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f33827b;

        /* JADX INFO: compiled from: Limit.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$takeWhile$lambda$6$$inlined$collectWhile$1", f = "Limit.kt", l = {142, 143}, m = "emit")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            Object f33828j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f33829k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33830l;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33832n;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33829k = obj;
                this.f33830l |= Integer.MIN_VALUE;
                return g.this.emit(null, this);
            }
        }

        public g(h9.p pVar, i iVar) {
            this.f33826a = pVar;
            this.f33827b = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0081  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r9) {
            /*
                r7 = this;
                boolean r0 = r9 instanceof s9.r.g.a
                if (r0 == 0) goto L13
                r0 = r9
                s9.r$g$a r0 = (s9.r.g.a) r0
                int r1 = r0.f33830l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33830l = r1
                goto L18
            L13:
                s9.r$g$a r0 = new s9.r$g$a
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f33829k
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33830l
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r8 = r0.f33828j
                s9.r$g r8 = (s9.r.g) r8
                v8.u.b(r9)
                goto L7c
            L30:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r9)
                throw r8
            L38:
                java.lang.Object r8 = r0.f33832n
                java.lang.Object r2 = r0.f33828j
                s9.r$g r2 = (s9.r.g) r2
                v8.u.b(r9)
                r6 = r9
                r9 = r8
                r8 = r2
                r2 = r6
                goto L63
            L46:
                v8.u.b(r9)
                h9.p r9 = r7.f33826a
                r0.f33828j = r7
                r0.f33832n = r8
                r0.f33830l = r4
                r2 = 6
                kotlin.jvm.internal.r.c(r2)
                java.lang.Object r9 = r9.mo4invoke(r8, r0)
                r2 = 7
                kotlin.jvm.internal.r.c(r2)
                if (r9 != r1) goto L60
                return r1
            L60:
                r2 = r9
                r9 = r8
                r8 = r7
            L63:
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L7b
                s9.i r2 = r8.f33827b
                r0.f33828j = r8
                r5 = 0
                r0.f33832n = r5
                r0.f33830l = r3
                java.lang.Object r9 = r2.emit(r9, r0)
                if (r9 != r1) goto L7c
                return r1
            L7b:
                r4 = 0
            L7c:
                if (r4 == 0) goto L81
                v8.k0 r8 = v8.k0.f35197a
                return r8
            L81:
                t9.a r9 = new t9.a
                r9.<init>(r8)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.r.g.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX INFO: compiled from: Limit.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", l = {152}, m = "invokeSuspend")
    static final class h<R> extends kotlin.coroutines.jvm.internal.l implements h9.p<i<? super R>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33833j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33834k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ s9.h<T> f33835l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ h9.q<i<? super R>, T, z8.d<? super Boolean>, Object> f33836m;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* JADX INFO: compiled from: Limit.kt */
        public static final class a<T> implements i<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ h9.q f33837a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i f33838b;

            /* JADX INFO: renamed from: s9.r$h$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Limit.kt */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1", f = "Limit.kt", l = {142}, m = "emit")
            public static final class C0682a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                Object f33839j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                /* synthetic */ Object f33840k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                int f33841l;

                public C0682a(z8.d dVar) {
                    super(dVar);
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f33840k = obj;
                    this.f33841l |= Integer.MIN_VALUE;
                    return a.this.emit(null, this);
                }
            }

            public a(h9.q qVar, i iVar) {
                this.f33837a = qVar;
                this.f33838b = iVar;
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
                    boolean r0 = r6 instanceof s9.r.h.a.C0682a
                    if (r0 == 0) goto L13
                    r0 = r6
                    s9.r$h$a$a r0 = (s9.r.h.a.C0682a) r0
                    int r1 = r0.f33841l
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f33841l = r1
                    goto L18
                L13:
                    s9.r$h$a$a r0 = new s9.r$h$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f33840k
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f33841l
                    r3 = 1
                    if (r2 == 0) goto L35
                    if (r2 != r3) goto L2d
                    java.lang.Object r5 = r0.f33839j
                    s9.r$h$a r5 = (s9.r.h.a) r5
                    v8.u.b(r6)
                    goto L50
                L2d:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L35:
                    v8.u.b(r6)
                    h9.q r6 = r4.f33837a
                    s9.i r2 = r4.f33838b
                    r0.f33839j = r4
                    r0.f33841l = r3
                    r3 = 6
                    kotlin.jvm.internal.r.c(r3)
                    java.lang.Object r6 = r6.invoke(r2, r5, r0)
                    r5 = 7
                    kotlin.jvm.internal.r.c(r5)
                    if (r6 != r1) goto L4f
                    return r1
                L4f:
                    r5 = r4
                L50:
                    java.lang.Boolean r6 = (java.lang.Boolean) r6
                    boolean r6 = r6.booleanValue()
                    if (r6 == 0) goto L5b
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                L5b:
                    t9.a r6 = new t9.a
                    r6.<init>(r5)
                    throw r6
                */
                throw new UnsupportedOperationException("Method not decompiled: s9.r.h.a.emit(java.lang.Object, z8.d):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        h(s9.h<? extends T> hVar, h9.q<? super i<? super R>, ? super T, ? super z8.d<? super Boolean>, ? extends Object> qVar, z8.d<? super h> dVar) {
            super(2, dVar);
            this.f33835l = hVar;
            this.f33836m = qVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            h hVar = new h(this.f33835l, this.f33836m, dVar);
            hVar.f33834k = obj;
            return hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            a aVar;
            Object objE = a9.d.e();
            int i10 = this.f33833j;
            if (i10 == 0) {
                v8.u.b(obj);
                i iVar = (i) this.f33834k;
                s9.h<T> hVar = this.f33835l;
                a aVar2 = new a(this.f33836m, iVar);
                try {
                    this.f33834k = aVar2;
                    this.f33833j = 1;
                    if (hVar.collect(aVar2, this) == objE) {
                        return objE;
                    }
                } catch (t9.a e10) {
                    e = e10;
                    aVar = aVar2;
                    t9.o.a(e, aVar);
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                aVar = (a) this.f33834k;
                try {
                    v8.u.b(obj);
                } catch (t9.a e11) {
                    e = e11;
                    t9.o.a(e, aVar);
                }
            }
            return v8.k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull i<? super R> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((h) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    @NotNull
    public static final <T> s9.h<T> b(@NotNull s9.h<? extends T> hVar, @NotNull h9.p<? super T, ? super z8.d<? super Boolean>, ? extends Object> pVar) {
        return new a(hVar, pVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(s9.i<? super T> r4, T r5, z8.d<? super v8.k0> r6) {
        /*
            boolean r0 = r6 instanceof s9.r.c
            if (r0 == 0) goto L13
            r0 = r6
            s9.r$c r0 = (s9.r.c) r0
            int r1 = r0.f33807l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33807l = r1
            goto L18
        L13:
            s9.r$c r0 = new s9.r$c
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f33806k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33807l
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f33805j
            s9.i r4 = (s9.i) r4
            v8.u.b(r6)
            goto L43
        L35:
            v8.u.b(r6)
            r0.f33805j = r4
            r0.f33807l = r3
            java.lang.Object r5 = r4.emit(r5, r0)
            if (r5 != r1) goto L43
            return r1
        L43:
            t9.a r5 = new t9.a
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.r.c(s9.i, java.lang.Object, z8.d):java.lang.Object");
    }

    @NotNull
    public static final <T> s9.h<T> d(@NotNull s9.h<? extends T> hVar, int i10) {
        if (i10 > 0) {
            return new d(hVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " should be positive").toString());
    }

    @NotNull
    public static final <T> s9.h<T> e(@NotNull s9.h<? extends T> hVar, @NotNull h9.p<? super T, ? super z8.d<? super Boolean>, ? extends Object> pVar) {
        return new f(hVar, pVar);
    }

    @NotNull
    public static final <T, R> s9.h<R> f(@NotNull s9.h<? extends T> hVar, @NotNull h9.q<? super i<? super R>, ? super T, ? super z8.d<? super Boolean>, ? extends Object> qVar) {
        return j.z(new h(hVar, qVar, null));
    }
}
