package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Emitters.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class p {

    /* JADX INFO: compiled from: Emitters.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt", f = "Emitters.kt", l = {216}, m = "invokeSafely$FlowKt__EmittersKt")
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33753j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f33754k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f33755l;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33754k = obj;
            this.f33755l |= Integer.MIN_VALUE;
            return p.c(null, null, null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class b<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h f33756a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h9.q f33757b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {115, 122, 129}, m = "collect")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33758j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f33759k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f33761m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33762n;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33758j = obj;
                this.f33759k |= Integer.MIN_VALUE;
                return b.this.collect(null, this);
            }
        }

        public b(h hVar, h9.q qVar) {
            this.f33756a = hVar;
            this.f33757b = qVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ab A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.h
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r9, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof s9.p.b.a
                if (r0 == 0) goto L13
                r0 = r10
                s9.p$b$a r0 = (s9.p.b.a) r0
                int r1 = r0.f33759k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33759k = r1
                goto L18
            L13:
                s9.p$b$a r0 = new s9.p$b$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f33758j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33759k
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L54
                if (r2 == r5) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r9 = r0.f33761m
                t9.t r9 = (t9.t) r9
                v8.u.b(r10)     // Catch: java.lang.Throwable -> L34
                goto L88
            L34:
                r10 = move-exception
                goto L92
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f33761m
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                v8.u.b(r10)
                goto Lac
            L46:
                java.lang.Object r9 = r0.f33762n
                s9.i r9 = (s9.i) r9
                java.lang.Object r2 = r0.f33761m
                s9.p$b r2 = (s9.p.b) r2
                v8.u.b(r10)     // Catch: java.lang.Throwable -> L52
                goto L67
            L52:
                r9 = move-exception
                goto L98
            L54:
                v8.u.b(r10)
                s9.h r10 = r8.f33756a     // Catch: java.lang.Throwable -> L96
                r0.f33761m = r8     // Catch: java.lang.Throwable -> L96
                r0.f33762n = r9     // Catch: java.lang.Throwable -> L96
                r0.f33759k = r5     // Catch: java.lang.Throwable -> L96
                java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L96
                if (r10 != r1) goto L66
                return r1
            L66:
                r2 = r8
            L67:
                t9.t r10 = new t9.t
                z8.g r4 = r0.getContext()
                r10.<init>(r9, r4)
                h9.q r9 = r2.f33757b     // Catch: java.lang.Throwable -> L8e
                r0.f33761m = r10     // Catch: java.lang.Throwable -> L8e
                r0.f33762n = r6     // Catch: java.lang.Throwable -> L8e
                r0.f33759k = r3     // Catch: java.lang.Throwable -> L8e
                r2 = 6
                kotlin.jvm.internal.r.c(r2)     // Catch: java.lang.Throwable -> L8e
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L8e
                r0 = 7
                kotlin.jvm.internal.r.c(r0)     // Catch: java.lang.Throwable -> L8e
                if (r9 != r1) goto L87
                return r1
            L87:
                r9 = r10
            L88:
                r9.releaseIntercepted()
                v8.k0 r9 = v8.k0.f35197a
                return r9
            L8e:
                r9 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L92:
                r9.releaseIntercepted()
                throw r10
            L96:
                r9 = move-exception
                r2 = r8
            L98:
                s9.s0 r10 = new s9.s0
                r10.<init>(r9)
                h9.q r2 = r2.f33757b
                r0.f33761m = r9
                r0.f33762n = r6
                r0.f33759k = r4
                java.lang.Object r10 = s9.p.a(r10, r2, r9, r0)
                if (r10 != r1) goto Lac
                return r1
            Lac:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.p.b.collect(s9.i, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class c<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ h9.p f33763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ h f33764b;

        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {117, 121}, m = "collect")
        public static final class a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33765j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f33766k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f33768m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33769n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            Object f33770o;

            public a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33765j = obj;
                this.f33766k |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(h9.p pVar, h hVar) {
            this.f33763a = pVar;
            this.f33764b = hVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.h
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(@org.jetbrains.annotations.NotNull s9.i<? super T> r7, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof s9.p.c.a
                if (r0 == 0) goto L13
                r0 = r8
                s9.p$c$a r0 = (s9.p.c.a) r0
                int r1 = r0.f33766k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33766k = r1
                goto L18
            L13:
                s9.p$c$a r0 = new s9.p$c$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f33765j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33766k
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                v8.u.b(r8)
                goto L83
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f33770o
                t9.t r7 = (t9.t) r7
                java.lang.Object r2 = r0.f33769n
                s9.i r2 = (s9.i) r2
                java.lang.Object r4 = r0.f33768m
                s9.p$c r4 = (s9.p.c) r4
                v8.u.b(r8)     // Catch: java.lang.Throwable -> L44
                goto L6e
            L44:
                r8 = move-exception
                goto L8a
            L46:
                v8.u.b(r8)
                t9.t r8 = new t9.t
                z8.g r2 = r0.getContext()
                r8.<init>(r7, r2)
                h9.p r2 = r6.f33763a     // Catch: java.lang.Throwable -> L86
                r0.f33768m = r6     // Catch: java.lang.Throwable -> L86
                r0.f33769n = r7     // Catch: java.lang.Throwable -> L86
                r0.f33770o = r8     // Catch: java.lang.Throwable -> L86
                r0.f33766k = r4     // Catch: java.lang.Throwable -> L86
                r4 = 6
                kotlin.jvm.internal.r.c(r4)     // Catch: java.lang.Throwable -> L86
                java.lang.Object r2 = r2.mo4invoke(r8, r0)     // Catch: java.lang.Throwable -> L86
                r4 = 7
                kotlin.jvm.internal.r.c(r4)     // Catch: java.lang.Throwable -> L86
                if (r2 != r1) goto L6b
                return r1
            L6b:
                r4 = r6
                r2 = r7
                r7 = r8
            L6e:
                r7.releaseIntercepted()
                s9.h r7 = r4.f33764b
                r8 = 0
                r0.f33768m = r8
                r0.f33769n = r8
                r0.f33770o = r8
                r0.f33766k = r3
                java.lang.Object r7 = r7.collect(r2, r0)
                if (r7 != r1) goto L83
                return r1
            L83:
                v8.k0 r7 = v8.k0.f35197a
                return r7
            L86:
                r7 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
            L8a:
                r7.releaseIntercepted()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.p.c.collect(s9.i, z8.d):java.lang.Object");
        }
    }

    public static final void b(@NotNull i<?> iVar) {
        if (iVar instanceof s0) {
            throw ((s0) iVar).f33853a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object c(s9.i<? super T> r4, h9.q<? super s9.i<? super T>, ? super java.lang.Throwable, ? super z8.d<? super v8.k0>, ? extends java.lang.Object> r5, java.lang.Throwable r6, z8.d<? super v8.k0> r7) {
        /*
            boolean r0 = r7 instanceof s9.p.a
            if (r0 == 0) goto L13
            r0 = r7
            s9.p$a r0 = (s9.p.a) r0
            int r1 = r0.f33755l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33755l = r1
            goto L18
        L13:
            s9.p$a r0 = new s9.p$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f33754k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33755l
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.f33753j
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            v8.u.b(r7)     // Catch: java.lang.Throwable -> L47
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            v8.u.b(r7)
            r0.f33753j = r6     // Catch: java.lang.Throwable -> L47
            r0.f33755l = r3     // Catch: java.lang.Throwable -> L47
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L47
            if (r4 != r1) goto L44
            return r1
        L44:
            v8.k0 r4 = v8.k0.f35197a
            return r4
        L47:
            r4 = move-exception
            if (r6 == 0) goto L4f
            if (r6 == r4) goto L4f
            v8.e.a(r4, r6)
        L4f:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.p.c(s9.i, h9.q, java.lang.Throwable, z8.d):java.lang.Object");
    }

    @NotNull
    public static final <T> h<T> d(@NotNull h<? extends T> hVar, @NotNull h9.q<? super i<? super T>, ? super Throwable, ? super z8.d<? super v8.k0>, ? extends Object> qVar) {
        return new b(hVar, qVar);
    }

    @NotNull
    public static final <T> h<T> e(@NotNull h<? extends T> hVar, @NotNull h9.p<? super i<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return new c(pVar, hVar);
    }
}
