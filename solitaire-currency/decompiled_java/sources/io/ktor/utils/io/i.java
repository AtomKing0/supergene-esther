package io.ktor.utils.io;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteReadChannel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: compiled from: ByteReadChannel.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.utils.io.ByteReadChannelKt", f = "ByteReadChannel.kt", l = {261}, m = "copyAndClose")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f26813j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f26814k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f26815l;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f26814k = obj;
            this.f26815l |= Integer.MIN_VALUE;
            return i.b(null, null, 0L, this);
        }
    }

    public static final boolean a(@NotNull g gVar) {
        kotlin.jvm.internal.t.i(gVar, "<this>");
        return gVar.b(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(@org.jetbrains.annotations.NotNull io.ktor.utils.io.g r4, @org.jetbrains.annotations.NotNull io.ktor.utils.io.j r5, long r6, @org.jetbrains.annotations.NotNull z8.d<? super java.lang.Long> r8) {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.i.a
            if (r0 == 0) goto L13
            r0 = r8
            io.ktor.utils.io.i$a r0 = (io.ktor.utils.io.i.a) r0
            int r1 = r0.f26815l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f26815l = r1
            goto L18
        L13:
            io.ktor.utils.io.i$a r0 = new io.ktor.utils.io.i$a
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f26814k
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f26815l
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r4 = r0.f26813j
            r5 = r4
            io.ktor.utils.io.j r5 = (io.ktor.utils.io.j) r5
            v8.u.b(r8)
            goto L44
        L2e:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L36:
            v8.u.b(r8)
            r0.f26813j = r5
            r0.f26815l = r3
            java.lang.Object r8 = io.ktor.utils.io.h.b(r4, r5, r6, r0)
            if (r8 != r1) goto L44
            return r1
        L44:
            java.lang.Number r8 = (java.lang.Number) r8
            long r6 = r8.longValue()
            io.ktor.utils.io.k.a(r5)
            java.lang.Long r4 = kotlin.coroutines.jvm.internal.b.e(r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.i.b(io.ktor.utils.io.g, io.ktor.utils.io.j, long, z8.d):java.lang.Object");
    }

    public static /* synthetic */ Object c(g gVar, j jVar, long j10, z8.d dVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = Long.MAX_VALUE;
        }
        return b(gVar, jVar, j10, dVar);
    }

    @Nullable
    public static final Object d(@NotNull g gVar, @NotNull byte[] bArr, @NotNull z8.d<? super Integer> dVar) {
        return gVar.g(bArr, 0, bArr.length, dVar);
    }
}
