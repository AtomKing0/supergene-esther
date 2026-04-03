package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Distinct.kt */
/* JADX INFO: loaded from: classes5.dex */
final class g<T> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h<T> f33685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final h9.l<T, Object> f33686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final h9.p<Object, Object, Boolean> f33687c;

    /* JADX INFO: compiled from: Distinct.kt */
    static final class a<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g<T> f33688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.n0<Object> f33689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ i<T> f33690c;

        /* JADX INFO: renamed from: s9.g$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Distinct.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.DistinctFlowImpl$collect$2", f = "Distinct.kt", l = {77}, m = "emit")
        static final class C0677a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33691j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ a<T> f33692k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33693l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0677a(a<? super T> aVar, z8.d<? super C0677a> dVar) {
                super(dVar);
                this.f33692k = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33691j = obj;
                this.f33693l |= Integer.MIN_VALUE;
                return this.f33692k.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(g<T> gVar, kotlin.jvm.internal.n0<Object> n0Var, i<? super T> iVar) {
            this.f33688a = gVar;
            this.f33689b = n0Var;
            this.f33690c = iVar;
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
                boolean r0 = r7 instanceof s9.g.a.C0677a
                if (r0 == 0) goto L13
                r0 = r7
                s9.g$a$a r0 = (s9.g.a.C0677a) r0
                int r1 = r0.f33693l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33693l = r1
                goto L18
            L13:
                s9.g$a$a r0 = new s9.g$a$a
                r0.<init>(r5, r7)
            L18:
                java.lang.Object r7 = r0.f33691j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33693l
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r7)
                goto L67
            L29:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L31:
                v8.u.b(r7)
                s9.g<T> r7 = r5.f33688a
                h9.l<T, java.lang.Object> r7 = r7.f33686b
                java.lang.Object r7 = r7.invoke(r6)
                kotlin.jvm.internal.n0<java.lang.Object> r2 = r5.f33689b
                T r2 = r2.f29834a
                u9.h0 r4 = t9.s.f34171a
                if (r2 == r4) goto L58
                s9.g<T> r4 = r5.f33688a
                h9.p<java.lang.Object, java.lang.Object, java.lang.Boolean> r4 = r4.f33687c
                java.lang.Object r2 = r4.mo4invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L55
                goto L58
            L55:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            L58:
                kotlin.jvm.internal.n0<java.lang.Object> r2 = r5.f33689b
                r2.f29834a = r7
                s9.i<T> r7 = r5.f33690c
                r0.f33693l = r3
                java.lang.Object r6 = r7.emit(r6, r0)
                if (r6 != r1) goto L67
                return r1
            L67:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.g.a.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(@NotNull h<? extends T> hVar, @NotNull h9.l<? super T, ? extends Object> lVar, @NotNull h9.p<Object, Object, Boolean> pVar) {
        this.f33685a = hVar;
        this.f33686b = lVar;
        this.f33687c = pVar;
    }

    @Override // s9.h
    @Nullable
    public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar) {
        kotlin.jvm.internal.n0 n0Var = new kotlin.jvm.internal.n0();
        n0Var.f29834a = (T) t9.s.f34171a;
        Object objCollect = this.f33685a.collect(new a(this, n0Var, iVar), dVar);
        return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
    }
}
