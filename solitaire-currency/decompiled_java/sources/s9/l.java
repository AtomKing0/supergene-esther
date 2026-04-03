package s9;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Channels.kt */
/* JADX INFO: loaded from: classes5.dex */
final /* synthetic */ class l {

    /* JADX INFO: compiled from: Channels.kt */
    @kotlin.coroutines.jvm.internal.f(c = "kotlinx.coroutines.flow.FlowKt__ChannelsKt", f = "Channels.kt", l = {36, 37}, m = "emitAllImpl$FlowKt__ChannelsKt")
    static final class a<T> extends kotlin.coroutines.jvm.internal.d {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        Object f33721j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Object f33722k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        Object f33723l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        boolean f33724m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        /* synthetic */ Object f33725n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        int f33726o;

        a(z8.d<? super a> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f33725n = obj;
            this.f33726o |= Integer.MIN_VALUE;
            return l.d(null, null, false, this);
        }
    }

    @NotNull
    public static final <T> h<T> b(@NotNull r9.t<? extends T> tVar) {
        return new e(tVar, true, null, 0, null, 28, null);
    }

    @Nullable
    public static final <T> Object c(@NotNull i<? super T> iVar, @NotNull r9.t<? extends T> tVar, @NotNull z8.d<? super v8.k0> dVar) {
        Object objD = d(iVar, tVar, true, dVar);
        return objD == a9.d.e() ? objD : v8.k0.f35197a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d A[Catch: all -> 0x009b, TRY_LEAVE, TryCatch #0 {all -> 0x009b, blocks: (B:13:0x0036, B:22:0x0060, B:26:0x0075, B:28:0x007d, B:18:0x0052, B:21:0x005c), top: B:41:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008f -> B:14:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <T> java.lang.Object d(s9.i<? super T> r6, r9.t<? extends T> r7, boolean r8, z8.d<? super v8.k0> r9) {
        /*
            boolean r0 = r9 instanceof s9.l.a
            if (r0 == 0) goto L13
            r0 = r9
            s9.l$a r0 = (s9.l.a) r0
            int r1 = r0.f33726o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f33726o = r1
            goto L18
        L13:
            s9.l$a r0 = new s9.l$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f33725n
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f33726o
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L56
            if (r2 == r4) goto L44
            if (r2 != r3) goto L3c
            boolean r8 = r0.f33724m
            java.lang.Object r6 = r0.f33723l
            r9.f r6 = (r9.f) r6
            java.lang.Object r7 = r0.f33722k
            r9.t r7 = (r9.t) r7
            java.lang.Object r2 = r0.f33721j
            s9.i r2 = (s9.i) r2
            v8.u.b(r9)     // Catch: java.lang.Throwable -> L9b
        L39:
            r9 = r6
            r6 = r2
            goto L60
        L3c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L44:
            boolean r8 = r0.f33724m
            java.lang.Object r6 = r0.f33723l
            r9.f r6 = (r9.f) r6
            java.lang.Object r7 = r0.f33722k
            r9.t r7 = (r9.t) r7
            java.lang.Object r2 = r0.f33721j
            s9.i r2 = (s9.i) r2
            v8.u.b(r9)     // Catch: java.lang.Throwable -> L9b
            goto L75
        L56:
            v8.u.b(r9)
            s9.j.t(r6)
            r9.f r9 = r7.iterator()     // Catch: java.lang.Throwable -> L9b
        L60:
            r0.f33721j = r6     // Catch: java.lang.Throwable -> L9b
            r0.f33722k = r7     // Catch: java.lang.Throwable -> L9b
            r0.f33723l = r9     // Catch: java.lang.Throwable -> L9b
            r0.f33724m = r8     // Catch: java.lang.Throwable -> L9b
            r0.f33726o = r4     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r2 = r9.b(r0)     // Catch: java.lang.Throwable -> L9b
            if (r2 != r1) goto L71
            return r1
        L71:
            r5 = r2
            r2 = r6
            r6 = r9
            r9 = r5
        L75:
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch: java.lang.Throwable -> L9b
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L9b
            if (r9 == 0) goto L92
            java.lang.Object r9 = r6.next()     // Catch: java.lang.Throwable -> L9b
            r0.f33721j = r2     // Catch: java.lang.Throwable -> L9b
            r0.f33722k = r7     // Catch: java.lang.Throwable -> L9b
            r0.f33723l = r6     // Catch: java.lang.Throwable -> L9b
            r0.f33724m = r8     // Catch: java.lang.Throwable -> L9b
            r0.f33726o = r3     // Catch: java.lang.Throwable -> L9b
            java.lang.Object r9 = r2.emit(r9, r0)     // Catch: java.lang.Throwable -> L9b
            if (r9 != r1) goto L39
            return r1
        L92:
            if (r8 == 0) goto L98
            r6 = 0
            r9.j.a(r7, r6)
        L98:
            v8.k0 r6 = v8.k0.f35197a
            return r6
        L9b:
            r6 = move-exception
            throw r6     // Catch: java.lang.Throwable -> L9d
        L9d:
            r9 = move-exception
            if (r8 == 0) goto La3
            r9.j.a(r7, r6)
        La3:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s9.l.d(s9.i, r9.t, boolean, z8.d):java.lang.Object");
    }
}
