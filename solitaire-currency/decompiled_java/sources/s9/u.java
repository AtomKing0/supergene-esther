package s9;

import kotlinx.coroutines.b2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Share.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class u {

    /* JADX INFO: compiled from: Share.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1", f = "Share.kt", l = {214, 218, 219, 225}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<kotlinx.coroutines.o0, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33891j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ i0 f33892k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ h<T> f33893l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ x<T> f33894m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ T f33895n;

        /* JADX INFO: renamed from: s9.u$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Share.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$1", f = "Share.kt", l = {}, m = "invokeSuspend")
        static final class C0683a extends kotlin.coroutines.jvm.internal.l implements h9.p<Integer, z8.d<? super Boolean>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f33896j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ int f33897k;

            C0683a(z8.d<? super C0683a> dVar) {
                super(2, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                C0683a c0683a = new C0683a(dVar);
                c0683a.f33897k = ((Number) obj).intValue();
                return c0683a;
            }

            @Nullable
            public final Object invoke(int i10, @Nullable z8.d<? super Boolean> dVar) {
                return ((C0683a) create(Integer.valueOf(i10), dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                a9.d.e();
                if (this.f33896j != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return kotlin.coroutines.jvm.internal.b.a(this.f33897k > 0);
            }

            @Override // h9.p
            /* JADX INFO: renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo4invoke(Integer num, z8.d<? super Boolean> dVar) {
                return invoke(num.intValue(), dVar);
            }
        }

        /* JADX INFO: compiled from: Share.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharing$1$2", f = "Share.kt", l = {227}, m = "invokeSuspend")
        static final class b extends kotlin.coroutines.jvm.internal.l implements h9.p<g0, z8.d<? super v8.k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f33898j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            /* synthetic */ Object f33899k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ h<T> f33900l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ x<T> f33901m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ T f33902n;

            /* JADX INFO: renamed from: s9.u$a$b$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Share.kt */
            public /* synthetic */ class C0684a {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f33903a;

                static {
                    int[] iArr = new int[g0.values().length];
                    try {
                        iArr[g0.START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[g0.STOP.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[g0.STOP_AND_RESET_REPLAY_CACHE.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    f33903a = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            b(h<? extends T> hVar, x<T> xVar, T t10, z8.d<? super b> dVar) {
                super(2, dVar);
                this.f33900l = hVar;
                this.f33901m = xVar;
                this.f33902n = t10;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                b bVar = new b(this.f33900l, this.f33901m, this.f33902n, dVar);
                bVar.f33899k = obj;
                return bVar;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull g0 g0Var, @Nullable z8.d<? super v8.k0> dVar) {
                return ((b) create(g0Var, dVar)).invokeSuspend(v8.k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.f33898j;
                if (i10 == 0) {
                    v8.u.b(obj);
                    int i11 = C0684a.f33903a[((g0) this.f33899k).ordinal()];
                    if (i11 == 1) {
                        h<T> hVar = this.f33900l;
                        i iVar = this.f33901m;
                        this.f33898j = 1;
                        if (hVar.collect(iVar, this) == objE) {
                            return objE;
                        }
                    } else if (i11 == 3) {
                        T t10 = this.f33902n;
                        if (t10 == e0.f33681a) {
                            this.f33901m.e();
                        } else {
                            this.f33901m.a(t10);
                        }
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    v8.u.b(obj);
                }
                return v8.k0.f35197a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(i0 i0Var, h<? extends T> hVar, x<T> xVar, T t10, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f33892k = i0Var;
            this.f33893l = hVar;
            this.f33894m = xVar;
            this.f33895n = t10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return new a(this.f33892k, this.f33893l, this.f33894m, this.f33895n, dVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0068 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = a9.b.e()
                int r1 = r7.f33891j
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L25
                if (r1 == r5) goto L21
                if (r1 == r4) goto L1d
                if (r1 == r3) goto L21
                if (r1 != r2) goto L15
                goto L21
            L15:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L1d:
                v8.u.b(r8)
                goto L5c
            L21:
                v8.u.b(r8)
                goto L8d
            L25:
                v8.u.b(r8)
                s9.i0 r8 = r7.f33892k
                s9.i0$a r1 = s9.i0.f33702a
                s9.i0 r6 = r1.c()
                if (r8 != r6) goto L3f
                s9.h<T> r8 = r7.f33893l
                s9.x<T> r1 = r7.f33894m
                r7.f33891j = r5
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L8d
                return r0
            L3f:
                s9.i0 r8 = r7.f33892k
                s9.i0 r1 = r1.d()
                r5 = 0
                if (r8 != r1) goto L69
                s9.x<T> r8 = r7.f33894m
                s9.m0 r8 = r8.c()
                s9.u$a$a r1 = new s9.u$a$a
                r1.<init>(r5)
                r7.f33891j = r4
                java.lang.Object r8 = s9.j.v(r8, r1, r7)
                if (r8 != r0) goto L5c
                return r0
            L5c:
                s9.h<T> r8 = r7.f33893l
                s9.x<T> r1 = r7.f33894m
                r7.f33891j = r3
                java.lang.Object r8 = r8.collect(r1, r7)
                if (r8 != r0) goto L8d
                return r0
            L69:
                s9.i0 r8 = r7.f33892k
                s9.x<T> r1 = r7.f33894m
                s9.m0 r1 = r1.c()
                s9.h r8 = r8.a(r1)
                s9.h r8 = s9.j.p(r8)
                s9.u$a$b r1 = new s9.u$a$b
                s9.h<T> r3 = r7.f33893l
                s9.x<T> r4 = r7.f33894m
                T r6 = r7.f33895n
                r1.<init>(r3, r4, r6, r5)
                r7.f33891j = r2
                java.lang.Object r8 = s9.j.l(r8, r1, r7)
                if (r8 != r0) goto L8d
                return r0
            L8d:
                v8.k0 r8 = v8.k0.f35197a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.u.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull kotlinx.coroutines.o0 o0Var, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    @NotNull
    public static final <T> c0<T> a(@NotNull x<T> xVar) {
        return new z(xVar, null);
    }

    @NotNull
    public static final <T> m0<T> b(@NotNull y<T> yVar) {
        return new a0(yVar, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final <T> s9.h0<T> c(s9.h<? extends T> r7, int r8) {
        /*
            r9.d$a r0 = r9.d.Q7
            int r0 = r0.a()
            int r0 = n9.m.e(r8, r0)
            int r0 = r0 - r8
            boolean r1 = r7 instanceof t9.e
            if (r1 == 0) goto L3d
            r1 = r7
            t9.e r1 = (t9.e) r1
            s9.h r2 = r1.j()
            if (r2 == 0) goto L3d
            s9.h0 r7 = new s9.h0
            int r3 = r1.f34114b
            r4 = -3
            if (r3 == r4) goto L26
            r4 = -2
            if (r3 == r4) goto L26
            if (r3 == 0) goto L26
            r0 = r3
            goto L35
        L26:
            r9.a r4 = r1.f34115c
            r9.a r5 = r9.a.SUSPEND
            r6 = 0
            if (r4 != r5) goto L30
            if (r3 != 0) goto L35
            goto L34
        L30:
            if (r8 != 0) goto L34
            r0 = 1
            goto L35
        L34:
            r0 = r6
        L35:
            r9.a r8 = r1.f34115c
            z8.g r1 = r1.f34113a
            r7.<init>(r2, r0, r8, r1)
            return r7
        L3d:
            s9.h0 r8 = new s9.h0
            r9.a r1 = r9.a.SUSPEND
            z8.h r2 = z8.h.f37608a
            r8.<init>(r7, r0, r1, r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.u.c(s9.h, int):s9.h0");
    }

    private static final <T> b2 d(kotlinx.coroutines.o0 o0Var, z8.g gVar, h<? extends T> hVar, x<T> xVar, i0 i0Var, T t10) {
        return kotlinx.coroutines.i.c(o0Var, gVar, kotlin.jvm.internal.t.d(i0Var, i0.f33702a.c()) ? kotlinx.coroutines.q0.DEFAULT : kotlinx.coroutines.q0.UNDISPATCHED, new a(i0Var, hVar, xVar, t10, null));
    }

    @NotNull
    public static final <T> c0<T> e(@NotNull c0<? extends T> c0Var, @NotNull h9.p<? super i<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return new r0(c0Var, pVar);
    }

    @NotNull
    public static final <T> c0<T> f(@NotNull h<? extends T> hVar, @NotNull kotlinx.coroutines.o0 o0Var, @NotNull i0 i0Var, int i10) {
        h0 h0VarC = c(hVar, i10);
        x xVarA = e0.a(i10, h0VarC.f33699b, h0VarC.f33700c);
        return new z(xVarA, d(o0Var, h0VarC.f33701d, h0VarC.f33698a, xVarA, i0Var, e0.f33681a));
    }

    @NotNull
    public static final <T> m0<T> g(@NotNull h<? extends T> hVar, @NotNull kotlinx.coroutines.o0 o0Var, @NotNull i0 i0Var, T t10) {
        h0 h0VarC = c(hVar, 1);
        y yVarA = o0.a(t10);
        return new a0(yVarA, d(o0Var, h0VarC.f33701d, h0VarC.f33698a, yVarA, i0Var, t10));
    }
}
