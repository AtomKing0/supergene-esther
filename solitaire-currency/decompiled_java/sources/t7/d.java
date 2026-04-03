package t7;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SavedCall.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: compiled from: SavedCall.kt */
    @kotlin.coroutines.jvm.internal.f(c = "io.ktor.client.call.SavedCallKt", f = "SavedCall.kt", l = {73}, m = "save")
    static final class a extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f34091j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        /* synthetic */ Object f34092k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f34093l;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f34092k = obj;
            this.f34093l |= Integer.MIN_VALUE;
            return d.a(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(@org.jetbrains.annotations.NotNull t7.b r8, @org.jetbrains.annotations.NotNull z8.d<? super t7.b> r9) {
        /*
            boolean r0 = r9 instanceof t7.d.a
            if (r0 == 0) goto L13
            r0 = r9
            t7.d$a r0 = (t7.d.a) r0
            int r1 = r0.f34093l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f34093l = r1
            goto L18
        L13:
            t7.d$a r0 = new t7.d$a
            r0.<init>(r9)
        L18:
            r4 = r0
            java.lang.Object r9 = r4.f34092k
            java.lang.Object r0 = a9.b.e()
            int r1 = r4.f34093l
            r7 = 1
            if (r1 == 0) goto L36
            if (r1 != r7) goto L2e
            java.lang.Object r8 = r4.f34091j
            t7.b r8 = (t7.b) r8
            v8.u.b(r9)
            goto L50
        L2e:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L36:
            v8.u.b(r9)
            b8.c r9 = r8.f()
            io.ktor.utils.io.g r1 = r9.c()
            r2 = 0
            r5 = 1
            r6 = 0
            r4.f34091j = r8
            r4.f34093l = r7
            java.lang.Object r9 = io.ktor.utils.io.g.b.a(r1, r2, r4, r5, r6)
            if (r9 != r0) goto L50
            return r0
        L50:
            p8.j r9 = (p8.j) r9
            r0 = 0
            r1 = 0
            byte[] r9 = p8.s.c(r9, r0, r7, r1)
            t7.e r0 = new t7.e
            s7.a r1 = r8.d()
            a8.b r2 = r8.e()
            b8.c r8 = r8.f()
            r0.<init>(r1, r2, r8, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t7.d.a(t7.b, z8.d):java.lang.Object");
    }
}
