package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Builders.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class k {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class a<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Iterable f33706a;

        /* JADX INFO: renamed from: s9.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SafeCollector.common.kt */
        @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__BuildersKt$asFlow$$inlined$unsafeFlow$3", f = "Builders.kt", l = {116}, m = "collect")
        public static final class C0678a extends kotlin.coroutines.jvm.internal.d {

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            /* synthetic */ Object f33707j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            int f33708k;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            Object f33710m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            Object f33711n;

            public C0678a(z8.d dVar) {
                super(dVar);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f33707j = obj;
                this.f33708k |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(Iterable iterable) {
            this.f33706a = iterable;
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
                boolean r0 = r7 instanceof s9.k.a.C0678a
                if (r0 == 0) goto L13
                r0 = r7
                s9.k$a$a r0 = (s9.k.a.C0678a) r0
                int r1 = r0.f33708k
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f33708k = r1
                goto L18
            L13:
                s9.k$a$a r0 = new s9.k$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f33707j
                java.lang.Object r1 = a9.b.e()
                int r2 = r0.f33708k
                r3 = 1
                if (r2 == 0) goto L3a
                if (r2 != r3) goto L32
                java.lang.Object r6 = r0.f33711n
                java.util.Iterator r6 = (java.util.Iterator) r6
                java.lang.Object r2 = r0.f33710m
                s9.i r2 = (s9.i) r2
                v8.u.b(r7)
                r7 = r2
                goto L46
            L32:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L3a:
                v8.u.b(r7)
                java.lang.Iterable r7 = r5.f33706a
                java.util.Iterator r7 = r7.iterator()
                r4 = r7
                r7 = r6
                r6 = r4
            L46:
                boolean r2 = r6.hasNext()
                if (r2 == 0) goto L5d
                java.lang.Object r2 = r6.next()
                r0.f33710m = r7
                r0.f33711n = r6
                r0.f33708k = r3
                java.lang.Object r2 = r7.emit(r2, r0)
                if (r2 != r1) goto L46
                return r1
            L5d:
                v8.k0 r6 = v8.k0.f35197a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: s9.k.a.collect(s9.i, z8.d):java.lang.Object");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: compiled from: SafeCollector.common.kt */
    public static final class b<T> implements h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f33712a;

        public b(Object obj) {
            this.f33712a = obj;
        }

        @Override // s9.h
        @Nullable
        public Object collect(@NotNull i<? super T> iVar, @NotNull z8.d<? super v8.k0> dVar) {
            Object objEmit = iVar.emit((Object) this.f33712a, dVar);
            return objEmit == a9.d.e() ? objEmit : v8.k0.f35197a;
        }
    }

    @NotNull
    public static final <T> h<T> a(@NotNull Iterable<? extends T> iterable) {
        return new a(iterable);
    }

    @NotNull
    public static final <T> h<T> b(@NotNull h9.p<? super r9.r<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return new s9.b(pVar, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> h<T> c(@NotNull h9.p<? super r9.r<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return new f(pVar, null, 0, null, 14, null);
    }

    @NotNull
    public static final <T> h<T> d(@NotNull h9.p<? super i<? super T>, ? super z8.d<? super v8.k0>, ? extends Object> pVar) {
        return new b0(pVar);
    }

    @NotNull
    public static final <T> h<T> e(T t10) {
        return new b(t10);
    }
}
