package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class mo extends kotlin.coroutines.jvm.internal.l implements h9.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3440b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public /* synthetic */ Object f3441c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ zo f3442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ long f3443e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mo(zo zoVar, long j10, z8.d dVar) {
        super(2, dVar);
        this.f3442d = zoVar;
        this.f3443e = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    public final z8.d create(Object obj, z8.d dVar) {
        mo moVar = new mo(this.f3442d, this.f3443e, dVar);
        moVar.f3441c = obj;
        return moVar;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final Object mo4invoke(Object obj, Object obj2) {
        return ((mo) create((kotlinx.coroutines.o0) obj, (z8.d) obj2)).invokeSuspend(v8.k0.f35197a);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0065 -> B:20:0x0068). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = a9.b.e()
            int r1 = r13.f3440b
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L2b
            if (r1 == r3) goto L21
            if (r1 != r2) goto L19
            long r3 = r13.f3439a
            java.lang.Object r1 = r13.f3441c
            kotlinx.coroutines.o0 r1 = (kotlinx.coroutines.o0) r1
            v8.u.b(r14)
            r14 = r13
            goto L68
        L19:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L21:
            long r3 = r13.f3439a
            java.lang.Object r1 = r13.f3441c
            kotlinx.coroutines.o0 r1 = (kotlinx.coroutines.o0) r1
            v8.u.b(r14)
            goto L47
        L2b:
            v8.u.b(r14)
            java.lang.Object r14 = r13.f3441c
            r1 = r14
            kotlinx.coroutines.o0 r1 = (kotlinx.coroutines.o0) r1
            bo.app.zo r14 = r13.f3442d
            long r4 = r14.f4462g
            long r6 = r13.f3443e
            r13.f3441c = r1
            r13.f3439a = r4
            r13.f3440b = r3
            java.lang.Object r14 = kotlinx.coroutines.y0.a(r6, r13)
            if (r14 != r0) goto L46
            return r0
        L46:
            r3 = r4
        L47:
            com.braze.Braze$Companion r14 = com.braze.Braze.Companion
            bo.app.zo r5 = r13.f3442d
            android.content.Context r5 = r5.f4456a
            com.braze.Braze r14 = r14.getInstance(r5)
            r14.requestImmediateDataFlush()
            r14 = r13
        L55:
            boolean r5 = kotlinx.coroutines.p0.h(r1)
            if (r5 == 0) goto L86
            r14.f3441c = r1
            r14.f3439a = r3
            r14.f3440b = r2
            java.lang.Object r5 = kotlinx.coroutines.y0.a(r3, r14)
            if (r5 != r0) goto L68
            return r0
        L68:
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = bo.app.zo.f4455m
            com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.V
            bo.app.lo r10 = bo.app.lo.f3344a
            r8 = 0
            r9 = 0
            r11 = 12
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default(r5, r6, r7, r8, r9, r10, r11, r12)
            com.braze.Braze$Companion r5 = com.braze.Braze.Companion
            bo.app.zo r6 = r14.f3442d
            android.content.Context r6 = r6.f4456a
            com.braze.Braze r5 = r5.getInstance(r6)
            r5.requestImmediateDataFlush()
            goto L55
        L86:
            v8.k0 r14 = v8.k0.f35197a
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.mo.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
