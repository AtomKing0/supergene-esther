package kotlinx.coroutines;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Timeout.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class f3 {

    /* JADX INFO: compiled from: Timeout.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.TimeoutKt", f = "Timeout.kt", l = {104}, m = "withTimeoutOrNull")
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f29894j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f29895k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f29896l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f29897m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f29898n;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f29897m = obj;
            this.f29898n |= Integer.MIN_VALUE;
            return f3.e(0L, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlinx.coroutines.d3 a(long r2, @org.jetbrains.annotations.NotNull kotlinx.coroutines.x0 r4, @org.jetbrains.annotations.NotNull kotlinx.coroutines.b2 r5) {
        /*
            boolean r0 = r4 instanceof kotlinx.coroutines.z0
            if (r0 == 0) goto L7
            kotlinx.coroutines.z0 r4 = (kotlinx.coroutines.z0) r4
            goto L8
        L7:
            r4 = 0
        L8:
            if (r4 == 0) goto L18
            q9.b$a r0 = q9.b.f33177b
            q9.e r0 = q9.e.f33186d
            long r0 = q9.d.t(r2, r0)
            java.lang.String r4 = r4.R(r0)
            if (r4 != 0) goto L2e
        L18:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Timed out waiting for "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = " ms"
            r4.append(r2)
            java.lang.String r4 = r4.toString()
        L2e:
            kotlinx.coroutines.d3 r2 = new kotlinx.coroutines.d3
            r2.<init>(r4, r5)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.f3.a(long, kotlinx.coroutines.x0, kotlinx.coroutines.b2):kotlinx.coroutines.d3");
    }

    private static final <U, T extends U> Object b(e3<U, ? super T> e3Var, h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar) {
        f2.i(e3Var, y0.b(e3Var.f34650d.getContext()).invokeOnTimeout(e3Var.f29889e, e3Var, e3Var.getContext()));
        return v9.b.c(e3Var, e3Var, pVar);
    }

    @Nullable
    public static final <T> Object c(long j10, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
        if (j10 <= 0) {
            throw new d3("Timed out immediately");
        }
        Object objB = b(new e3(j10, dVar), pVar);
        if (objB == a9.d.e()) {
            kotlin.coroutines.jvm.internal.h.c(dVar);
        }
        return objB;
    }

    @Nullable
    public static final <T> Object d(long j10, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
        return c(y0.c(j10), pVar, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlinx.coroutines.e3] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object e(long r7, @org.jetbrains.annotations.NotNull h9.p<? super kotlinx.coroutines.o0, ? super z8.d<? super T>, ? extends java.lang.Object> r9, @org.jetbrains.annotations.NotNull z8.d<? super T> r10) {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.f3.a
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.f3$a r0 = (kotlinx.coroutines.f3.a) r0
            int r1 = r0.f29898n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f29898n = r1
            goto L18
        L13:
            kotlinx.coroutines.f3$a r0 = new kotlinx.coroutines.f3$a
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.f29897m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f29898n
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 != r4) goto L34
            java.lang.Object r7 = r0.f29896l
            kotlin.jvm.internal.n0 r7 = (kotlin.jvm.internal.n0) r7
            java.lang.Object r8 = r0.f29895k
            h9.p r8 = (h9.p) r8
            v8.u.b(r10)     // Catch: kotlinx.coroutines.d3 -> L32
            goto L6b
        L32:
            r8 = move-exception
            goto L6e
        L34:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3c:
            v8.u.b(r10)
            r5 = 0
            int r10 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r10 > 0) goto L46
            return r3
        L46:
            kotlin.jvm.internal.n0 r10 = new kotlin.jvm.internal.n0
            r10.<init>()
            r0.f29895k = r9     // Catch: kotlinx.coroutines.d3 -> L6c
            r0.f29896l = r10     // Catch: kotlinx.coroutines.d3 -> L6c
            r0.f29894j = r7     // Catch: kotlinx.coroutines.d3 -> L6c
            r0.f29898n = r4     // Catch: kotlinx.coroutines.d3 -> L6c
            kotlinx.coroutines.e3 r2 = new kotlinx.coroutines.e3     // Catch: kotlinx.coroutines.d3 -> L6c
            r2.<init>(r7, r0)     // Catch: kotlinx.coroutines.d3 -> L6c
            r10.f29834a = r2     // Catch: kotlinx.coroutines.d3 -> L6c
            java.lang.Object r7 = b(r2, r9)     // Catch: kotlinx.coroutines.d3 -> L6c
            java.lang.Object r8 = a9.b.e()     // Catch: kotlinx.coroutines.d3 -> L6c
            if (r7 != r8) goto L67
            kotlin.coroutines.jvm.internal.h.c(r0)     // Catch: kotlinx.coroutines.d3 -> L6c
        L67:
            if (r7 != r1) goto L6a
            return r1
        L6a:
            r10 = r7
        L6b:
            return r10
        L6c:
            r8 = move-exception
            r7 = r10
        L6e:
            kotlinx.coroutines.b2 r9 = r8.f29875a
            T r7 = r7.f29834a
            if (r9 != r7) goto L75
            return r3
        L75:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.f3.e(long, h9.p, z8.d):java.lang.Object");
    }

    @Nullable
    public static final <T> Object f(long j10, @NotNull h9.p<? super o0, ? super z8.d<? super T>, ? extends Object> pVar, @NotNull z8.d<? super T> dVar) {
        return e(y0.c(j10), pVar, dVar);
    }
}
