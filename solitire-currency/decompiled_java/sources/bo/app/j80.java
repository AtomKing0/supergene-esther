package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class j80 extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3137a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f3138b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v80 f3139c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j80(v80 v80Var, z8.d dVar) {
        super(2, dVar);
        this.f3139c = v80Var;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        j80 j80Var = new j80(this.f3139c, dVar);
        j80Var.f3138b = obj;
        return j80Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        j80 j80Var = new j80(this.f3139c, (z8.d) obj2);
        j80Var.f3138b = (kotlinx.coroutines.o0) obj;
        return j80Var.invokeSuspend(v8.k0.f35197a);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007f -> B:13:0x0031). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = a9.b.e()
            int r1 = r12.f3137a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L28
            if (r1 == r3) goto L1e
            if (r1 != r2) goto L16
            java.lang.Object r1 = r12.f3138b
            kotlinx.coroutines.o0 r1 = (kotlinx.coroutines.o0) r1
            v8.u.b(r13)
            goto L30
        L16:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L1e:
            java.lang.Object r1 = r12.f3138b
            kotlinx.coroutines.o0 r1 = (kotlinx.coroutines.o0) r1
            v8.u.b(r13)
            r13 = r12
        L26:
            r5 = r1
            goto L59
        L28:
            v8.u.b(r13)
            java.lang.Object r13 = r12.f3138b
            r1 = r13
            kotlinx.coroutines.o0 r1 = (kotlinx.coroutines.o0) r1
        L30:
            r13 = r12
        L31:
            boolean r4 = kotlinx.coroutines.p0.h(r1)
            if (r4 == 0) goto L81
            bo.app.v80 r4 = r13.f3139c     // Catch: java.lang.Exception -> L3d
            bo.app.v80.a(r4)     // Catch: java.lang.Exception -> L3d
            goto L26
        L3d:
            r4 = move-exception
            r7 = r4
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.E
            bo.app.h80 r9 = bo.app.h80.f2961a
            r8 = 0
            r10 = 4
            r11 = 0
            r5 = r1
            com.braze.support.BrazeLogger.brazelog$default(r4, r5, r6, r7, r8, r9, r10, r11)
            long r4 = bo.app.v80.f4081p
            r13.f3138b = r1
            r13.f3137a = r3
            java.lang.Object r4 = kotlinx.coroutines.y0.a(r4, r13)
            if (r4 != r0) goto L26
            return r0
        L59:
            bo.app.v80 r1 = r13.f3139c
            java.util.concurrent.atomic.AtomicInteger r1 = r1.f4092k
            int r1 = r1.get()
            r4 = 5
            if (r1 < r4) goto L72
            com.braze.support.BrazeLogger r4 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r6 = com.braze.support.BrazeLogger.Priority.I
            bo.app.i80 r9 = bo.app.i80.f3032a
            r7 = 0
            r8 = 0
            r10 = 6
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default(r4, r5, r6, r7, r8, r9, r10, r11)
            goto L81
        L72:
            r13.f3138b = r5
            r13.f3137a = r2
            r6 = 10
            java.lang.Object r1 = kotlinx.coroutines.y0.a(r6, r13)
            if (r1 != r0) goto L7f
            return r0
        L7f:
            r1 = r5
            goto L31
        L81:
            v8.k0 r13 = v8.k0.f35197a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.j80.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
