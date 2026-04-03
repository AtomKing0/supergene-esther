package io.ktor.utils.io.internal;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SequentialCopyTo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {26, 31, 39}, m = "copyToSequentialImpl")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26864j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26865k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        long f26866l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        long f26867m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        long f26868n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        /* synthetic */ Object f26869o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        int f26870p;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26869o = obj;
            this.f26870p |= Integer.MIN_VALUE;
            return j.b(null, null, 0L, this);
        }
    }

    /* JADX INFO: compiled from: SequentialCopyTo.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.internal.SequentialCopyToKt", f = "SequentialCopyTo.kt", l = {60, 66}, m = "copyToTail")
    static final class b extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26871j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f26872k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26873l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        /* synthetic */ Object f26874m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        int f26875n;

        b(z8.d<? super b> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26874m = obj;
            this.f26875n |= Integer.MIN_VALUE;
            return j.c(null, null, 0L, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00e7 -> B:53:0x010b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:0x00ee -> B:52:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x0100 -> B:52:0x0103). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(@org.jetbrains.annotations.NotNull io.ktor.utils.io.f r19, @org.jetbrains.annotations.NotNull io.ktor.utils.io.f r20, long r21, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Long> r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.j.b(io.ktor.utils.io.f, io.ktor.utils.io.f, long, z8.d):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v10, types: [q8.a] */
    /* JADX WARN: Type inference failed for: r9v17 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(io.ktor.utils.io.f r8, io.ktor.utils.io.f r9, long r10, z8.d<? super java.lang.Long> r12) throws java.lang.Throwable {
        /*
            boolean r0 = r12 instanceof io.ktor.utils.io.internal.j.b
            if (r0 == 0) goto L13
            r0 = r12
            io.ktor.utils.io.internal.j$b r0 = (io.ktor.utils.io.internal.j.b) r0
            int r1 = r0.f26875n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26875n = r1
            goto L18
        L13:
            io.ktor.utils.io.internal.j$b r0 = new io.ktor.utils.io.internal.j$b
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f26874m
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26875n
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4e
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            int r8 = r0.f26873l
            java.lang.Object r9 = r0.f26871j
            q8.a r9 = (q8.a) r9
            v8.u.b(r12)     // Catch: java.lang.Throwable -> L4c
            goto La8
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.f26872k
            r9 = r8
            q8.a r9 = (q8.a) r9
            java.lang.Object r8 = r0.f26871j
            io.ktor.utils.io.f r8 = (io.ktor.utils.io.f) r8
            v8.u.b(r12)     // Catch: java.lang.Throwable -> L4c
            r7 = r9
            r9 = r8
            r8 = r12
            r12 = r7
            goto L77
        L4c:
            r8 = move-exception
            goto Lb9
        L4e:
            v8.u.b(r12)
            q8.a$d r12 = q8.a.f33167j
            s8.g r12 = r12.c()
            java.lang.Object r12 = r12.k0()
            q8.a r12 = (q8.a) r12
            int r2 = r12.e()     // Catch: java.lang.Throwable -> Lb7
            long r5 = (long) r2     // Catch: java.lang.Throwable -> Lb7
            long r10 = n9.m.k(r10, r5)     // Catch: java.lang.Throwable -> Lb7
            int r10 = (int) r10     // Catch: java.lang.Throwable -> Lb7
            r12.s(r10)     // Catch: java.lang.Throwable -> Lb7
            r0.f26871j = r9     // Catch: java.lang.Throwable -> Lb7
            r0.f26872k = r12     // Catch: java.lang.Throwable -> Lb7
            r0.f26875n = r4     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r8 = r8.k(r12, r0)     // Catch: java.lang.Throwable -> Lb7
            if (r8 != r1) goto L77
            return r1
        L77:
            java.lang.Number r8 = (java.lang.Number) r8     // Catch: java.lang.Throwable -> Lb7
            int r8 = r8.intValue()     // Catch: java.lang.Throwable -> Lb7
            r10 = -1
            if (r8 != r10) goto L97
            q8.a$d r8 = q8.a.f33167j     // Catch: java.lang.Throwable -> Lb7
            s8.g r9 = r8.c()     // Catch: java.lang.Throwable -> Lb7
            r12.A(r9)     // Catch: java.lang.Throwable -> Lb7
            r9 = 0
            java.lang.Long r9 = kotlin.coroutines.jvm.internal.b.e(r9)     // Catch: java.lang.Throwable -> Lb7
            s8.g r8 = r8.c()
            r12.A(r8)
            return r9
        L97:
            r0.f26871j = r12     // Catch: java.lang.Throwable -> Lb7
            r10 = 0
            r0.f26872k = r10     // Catch: java.lang.Throwable -> Lb7
            r0.f26873l = r8     // Catch: java.lang.Throwable -> Lb7
            r0.f26875n = r3     // Catch: java.lang.Throwable -> Lb7
            java.lang.Object r9 = r9.e(r12, r0)     // Catch: java.lang.Throwable -> Lb7
            if (r9 != r1) goto La7
            return r1
        La7:
            r9 = r12
        La8:
            long r10 = (long) r8
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.b.e(r10)     // Catch: java.lang.Throwable -> L4c
            q8.a$d r10 = q8.a.f33167j
            s8.g r10 = r10.c()
            r9.A(r10)
            return r8
        Lb7:
            r8 = move-exception
            r9 = r12
        Lb9:
            q8.a$d r10 = q8.a.f33167j
            s8.g r10 = r10.c()
            r9.A(r10)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.internal.j.c(io.ktor.utils.io.f, io.ktor.utils.io.f, long, z8.d):java.lang.Object");
    }
}
