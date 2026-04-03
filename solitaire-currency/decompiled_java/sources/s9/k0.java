package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SharingStarted.kt */
/* JADX INFO: loaded from: classes5.dex */
final class k0 implements i0 {

    /* JADX INFO: compiled from: SharingStarted.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedLazily$command$1", f = "SharingStarted.kt", l = {155}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.l implements h9.p<i<? super g0>, z8.d<? super v8.k0>, Object> {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        int f33713j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private /* synthetic */ Object f33714k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ m0<Integer> f33715l;

        /* JADX INFO: renamed from: s9.k0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SharingStarted.kt */
        static final class C0679a<T> implements i {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ kotlin.jvm.internal.i0 f33716a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ i<g0> f33717b;

            /* JADX INFO: renamed from: s9.k0$a$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: SharingStarted.kt */
            @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.StartedLazily$command$1$1", f = "SharingStarted.kt", l = {158}, m = "emit")
            static final class C0680a extends kotlin.coroutines.jvm.internal.d {

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                /* synthetic */ Object f33718j;

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                final /* synthetic */ C0679a<T> f33719k;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                int f33720l;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C0680a(C0679a<? super T> c0679a, z8.d<? super C0680a> dVar) {
                    super(dVar);
                    this.f33719k = c0679a;
                }

                @Override // kotlin.coroutines.jvm.internal.a
                @Nullable
                public final Object invokeSuspend(@NotNull Object obj) {
                    this.f33718j = obj;
                    this.f33720l |= Integer.MIN_VALUE;
                    return this.f33719k.b(0, this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            C0679a(kotlin.jvm.internal.i0 i0Var, i<? super g0> iVar) {
                this.f33716a = i0Var;
                this.f33717b = iVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object b(int r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
                /*
                    r4 = this;
                    boolean r0 = r6 instanceof s9.k0.a.C0679a.C0680a
                    if (r0 == 0) goto L13
                    r0 = r6
                    s9.k0$a$a$a r0 = (s9.k0.a.C0679a.C0680a) r0
                    int r1 = r0.f33720l
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f33720l = r1
                    goto L18
                L13:
                    s9.k0$a$a$a r0 = new s9.k0$a$a$a
                    r0.<init>(r4, r6)
                L18:
                    java.lang.Object r6 = r0.f33718j
                    java.lang.Object r1 = a9.b.e()
                    int r2 = r0.f33720l
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    v8.u.b(r6)
                    goto L4b
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    v8.u.b(r6)
                    if (r5 <= 0) goto L4e
                    kotlin.jvm.internal.i0 r5 = r4.f33716a
                    boolean r6 = r5.f29826a
                    if (r6 != 0) goto L4e
                    r5.f29826a = r3
                    s9.i<s9.g0> r5 = r4.f33717b
                    s9.g0 r6 = s9.g0.START
                    r0.f33720l = r3
                    java.lang.Object r5 = r5.emit(r6, r0)
                    if (r5 != r1) goto L4b
                    return r1
                L4b:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                L4e:
                    v8.k0 r5 = v8.k0.f35197a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: s9.k0.a.C0679a.b(int, z8.d):java.lang.Object");
            }

            @Override // s9.i
            public /* bridge */ /* synthetic */ Object emit(Object obj, z8.d dVar) {
                return b(((Number) obj).intValue(), dVar);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(m0<Integer> m0Var, z8.d<? super a> dVar) {
            super(2, dVar);
            this.f33715l = m0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            a aVar = new a(this.f33715l, dVar);
            aVar.f33714k = obj;
            return aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.f33713j;
            if (i10 == 0) {
                v8.u.b(obj);
                i iVar = (i) this.f33714k;
                kotlin.jvm.internal.i0 i0Var = new kotlin.jvm.internal.i0();
                m0<Integer> m0Var = this.f33715l;
                C0679a c0679a = new C0679a(i0Var, iVar);
                this.f33713j = 1;
                if (m0Var.collect(c0679a, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
            }
            throw new v8.h();
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull i<? super g0> iVar, @Nullable z8.d<? super v8.k0> dVar) {
            return ((a) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
        }
    }

    @Override // s9.i0
    @NotNull
    public h<g0> a(@NotNull m0<Integer> m0Var) {
        return j.z(new a(m0Var, null));
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Lazily";
    }
}
