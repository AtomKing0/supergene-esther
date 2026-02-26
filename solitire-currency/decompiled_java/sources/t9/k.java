package t9;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.collections.i0;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r9.u;
import v8.k0;

/* JADX INFO: compiled from: Combine.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: compiled from: Combine.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {54, 76, 79}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f34146j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f34147k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f34148l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        int f34149m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f34150n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private /* synthetic */ Object f34151o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ s9.h<T>[] f34152p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ h9.a<T[]> f34153q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final /* synthetic */ h9.q<s9.i<? super R>, T[], z8.d<? super k0>, Object> f34154r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ s9.i<R> f34155s;

        /* JADX INFO: renamed from: t9.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Combine.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {31}, m = "invokeSuspend")
        static final class C0695a extends kotlin.coroutines.jvm.internal.l implements h9.p<o0, z8.d<? super k0>, Object> {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            int f34156j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ s9.h<T>[] f34157k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            final /* synthetic */ int f34158l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            final /* synthetic */ AtomicInteger f34159m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            final /* synthetic */ r9.d<i0<Object>> f34160n;

            /* JADX INFO: renamed from: t9.k$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: Combine.kt */
            static final class C0696a<T> implements s9.i {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ r9.d<i0<Object>> f34161a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ int f34162b;

                /* JADX INFO: renamed from: t9.k$a$a$a$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: Combine.kt */
                @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1", f = "Combine.kt", l = {32, 33}, m = "emit")
                static final class C0697a extends kotlin.coroutines.jvm.internal.d {

                    /* JADX INFO: renamed from: j, reason: collision with root package name */
                    /* synthetic */ Object f34163j;

                    /* JADX INFO: renamed from: k, reason: collision with root package name */
                    final /* synthetic */ C0696a<T> f34164k;

                    /* JADX INFO: renamed from: l, reason: collision with root package name */
                    int f34165l;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    C0697a(C0696a<? super T> c0696a, z8.d<? super C0697a> dVar) {
                        super(dVar);
                        this.f34164k = c0696a;
                    }

                    @Override // kotlin.coroutines.jvm.internal.a
                    @Nullable
                    public final Object invokeSuspend(@NotNull Object obj) {
                        this.f34163j = obj;
                        this.f34165l |= Integer.MIN_VALUE;
                        return this.f34164k.emit(null, this);
                    }
                }

                C0696a(r9.d<i0<Object>> dVar, int i10) {
                    this.f34161a = dVar;
                    this.f34162b = i10;
                }

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
                        boolean r0 = r8 instanceof t9.k.a.C0695a.C0696a.C0697a
                        if (r0 == 0) goto L13
                        r0 = r8
                        t9.k$a$a$a$a r0 = (t9.k.a.C0695a.C0696a.C0697a) r0
                        int r1 = r0.f34165l
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f34165l = r1
                        goto L18
                    L13:
                        t9.k$a$a$a$a r0 = new t9.k$a$a$a$a
                        r0.<init>(r6, r8)
                    L18:
                        java.lang.Object r8 = r0.f34163j
                        java.lang.Object r1 = a9.b.e()
                        int r2 = r0.f34165l
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L38
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        v8.u.b(r8)
                        goto L56
                    L2c:
                        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                        java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                        r7.<init>(r8)
                        throw r7
                    L34:
                        v8.u.b(r8)
                        goto L4d
                    L38:
                        v8.u.b(r8)
                        r9.d<kotlin.collections.i0<java.lang.Object>> r8 = r6.f34161a
                        kotlin.collections.i0 r2 = new kotlin.collections.i0
                        int r5 = r6.f34162b
                        r2.<init>(r5, r7)
                        r0.f34165l = r4
                        java.lang.Object r7 = r8.p(r2, r0)
                        if (r7 != r1) goto L4d
                        return r1
                    L4d:
                        r0.f34165l = r3
                        java.lang.Object r7 = kotlinx.coroutines.l3.a(r0)
                        if (r7 != r1) goto L56
                        return r1
                    L56:
                        v8.k0 r7 = v8.k0.f35197a
                        return r7
                    */
                    throw new UnsupportedOperationException("Method not decompiled: t9.k.a.C0695a.C0696a.emit(java.lang.Object, z8.d):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0695a(s9.h<? extends T>[] hVarArr, int i10, AtomicInteger atomicInteger, r9.d<i0<Object>> dVar, z8.d<? super C0695a> dVar2) {
                super(2, dVar2);
                this.f34157k = hVarArr;
                this.f34158l = i10;
                this.f34159m = atomicInteger;
                this.f34160n = dVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                return new C0695a(this.f34157k, this.f34158l, this.f34159m, this.f34160n, dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                AtomicInteger atomicInteger;
                Object objE = a9.d.e();
                int i10 = this.f34156j;
                try {
                    if (i10 == 0) {
                        v8.u.b(obj);
                        s9.h[] hVarArr = this.f34157k;
                        int i11 = this.f34158l;
                        s9.h hVar = hVarArr[i11];
                        C0696a c0696a = new C0696a(this.f34160n, i11);
                        this.f34156j = 1;
                        if (hVar.collect(c0696a, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        v8.u.b(obj);
                    }
                    if (atomicInteger.decrementAndGet() == 0) {
                        u.a.a(this.f34160n, null, 1, null);
                    }
                    return k0.f35197a;
                } finally {
                    if (this.f34159m.decrementAndGet() == 0) {
                        u.a.a(this.f34160n, null, 1, null);
                    }
                }
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
                return ((C0695a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(s9.h<? extends T>[] hVarArr, h9.a<T[]> aVar, h9.q<? super s9.i<? super R>, ? super T[], ? super z8.d<? super k0>, ? extends Object> qVar, s9.i<? super R> iVar, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f34152p = hVarArr;
            this.f34153q = aVar;
            this.f34154r = qVar;
            this.f34155s = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f34152p, this.f34153q, this.f34154r, this.f34155s, dVar);
            aVar.f34151o = obj;
            return aVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x00e3  */
        /* JADX WARN: Removed duplicated region for block: B:28:0x00e6 A[LOOP:0: B:28:0x00e6->B:51:?, LOOP_START, PHI: r6 r10
          0x00e6: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00e1, B:51:?] A[DONT_GENERATE, DONT_INLINE]
          0x00e6: PHI (r10v8 kotlin.collections.i0) = (r10v7 kotlin.collections.i0), (r10v21 kotlin.collections.i0) binds: [B:25:0x00e1, B:51:?] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x012e -> B:20:0x00c3). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.a
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) {
            /*
                Method dump skipped, instruction units count: 357
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: t9.k.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
            return ((a) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    @Nullable
    public static final <R, T> Object a(@NotNull s9.i<? super R> iVar, @NotNull s9.h<? extends T>[] hVarArr, @NotNull h9.a<T[]> aVar, @NotNull h9.q<? super s9.i<? super R>, ? super T[], ? super z8.d<? super k0>, ? extends Object> qVar, @NotNull z8.d<? super k0> dVar) {
        Object objA = n.a(new a(hVarArr, aVar, qVar, iVar, null), dVar);
        return objA == a9.d.e() ? objA : k0.f35197a;
    }
}
