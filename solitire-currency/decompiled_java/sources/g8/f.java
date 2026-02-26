package g8;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: ByteChannels.kt */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: compiled from: ByteChannels.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.util.ByteChannelsKt", f = "ByteChannels.kt", l = {91}, m = "toByteArray")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        /* synthetic */ Object f25887j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        int f25888k;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f25887j = obj;
            this.f25888k |= Integer.MIN_VALUE;
            return f.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull io.ktor.utils.io.g r8, @org.jetbrains.annotations.NotNull z8.d<? super byte[]> r9) {
        /*
            boolean r0 = r9 instanceof g8.f.a
            if (r0 == 0) goto L13
            r0 = r9
            g8.f$a r0 = (g8.f.a) r0
            int r1 = r0.f25888k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f25888k = r1
            goto L18
        L13:
            g8.f$a r0 = new g8.f$a
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f25887j
            java.lang.Object r0 = a9.b.e()
            int r1 = r4.f25888k
            r7 = 1
            if (r1 == 0) goto L32
            if (r1 != r7) goto L2a
            v8.u.b(r9)
            goto L43
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            v8.u.b(r9)
            r2 = 0
            r5 = 1
            r6 = 0
            r4.f25888k = r7
            r1 = r8
            java.lang.Object r9 = io.ktor.utils.io.g.b.a(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L43
            return r0
        L43:
            p8.j r9 = (p8.j) r9
            r8 = 0
            r0 = 0
            byte[] r8 = p8.s.c(r9, r8, r7, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: g8.f.a(io.ktor.utils.io.g, z8.d):java.lang.Object");
    }
}
