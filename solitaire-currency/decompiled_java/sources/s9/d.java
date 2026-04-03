package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Context.kt */
/* JADX INFO: loaded from: classes5.dex */
final class d<T> implements c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h<T> f33653a;

    /* JADX INFO: compiled from: Context.kt */
    static final class a<T> implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ i<T> f33654a;

        /* JADX INFO: renamed from: s9.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Context.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.CancellableFlowImpl$collect$2", f = "Context.kt", l = {275}, m = "emit")
        static final class C0676a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33655j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            final /* synthetic */ a<T> f33656k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            int f33657l;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            C0676a(a<? super T> aVar, z8.d<? super C0676a> dVar) {
                super(dVar);
                this.f33656k = aVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33655j = obj;
                this.f33657l |= Integer.MIN_VALUE;
                return this.f33656k.emit(null, this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(i<? super T> iVar) {
            this.f33654a = iVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // s9.i
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r6) {
            /*
                r4 = this;
                boolean r0 = r6 instanceof s9.d.a.C0676a
                if (r0 == 0) goto L13
                r0 = r6
                s9.d$a$a r0 = (s9.d.a.C0676a) r0
                int r1 = r0.f33657l
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33657l = r1
                goto L18
            L13:
                s9.d$a$a r0 = new s9.d$a$a
                r0.<init>(r4, r6)
            L18:
                java.lang.Object r6 = r0.f33655j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33657l
                r3 = 1
                if (r2 == 0) goto L31
                if (r2 != r3) goto L29
                v8.u.b(r6)
                goto L46
            L29:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L31:
                v8.u.b(r6)
                z8.g r6 = r0.getContext()
                kotlinx.coroutines.f2.k(r6)
                s9.i<T> r6 = r4.f33654a
                r0.f33657l = r3
                java.lang.Object r5 = r6.emit(r5, r0)
                if (r5 != r1) goto L46
                return r1
            L46:
                v8.k0 r5 = v8.k0.f35197a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.d.a.emit(java.lang.Object, z8.d):java.lang.Object");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(@NotNull h<? extends T> hVar) {
        this.f33653a = hVar;
    }

    @Override // s9.h
    @Nullable
    public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar) {
        Object objCollect = this.f33653a.collect(new a(iVar), dVar);
        return objCollect == a9.d.e() ? objCollect : v8.k0.f35197a;
    }
}
