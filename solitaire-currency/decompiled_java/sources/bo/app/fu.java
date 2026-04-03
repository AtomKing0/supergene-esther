package bo.app;

import com.braze.support.BrazeLogger;
import kotlinx.coroutines.b2;

/* JADX INFO: loaded from: classes2.dex */
public final class fu {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f2842b = BrazeLogger.getBrazeLogTag((Class<?>) fu.class);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b2 f2843a;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /* JADX WARN: Type inference failed for: r0v20, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v23, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x009a -> B:12:0x0047). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(bo.app.fu r24, kotlinx.coroutines.o0 r25, r9.t r26, h9.l r27, z8.d r28) {
        /*
            Method dump skipped, instruction units count: 542
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.fu.a(bo.app.fu, kotlinx.coroutines.o0, r9.t, h9.l, z8.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0016  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(bo.app.fu r13, z8.d r14) {
        /*
            r13.getClass()
            boolean r0 = r14 instanceof bo.app.ht
            if (r0 == 0) goto L16
            r0 = r14
            bo.app.ht r0 = (bo.app.ht) r0
            int r1 = r0.f3003d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L16
            int r1 = r1 - r2
            r0.f3003d = r1
            goto L1b
        L16:
            bo.app.ht r0 = new bo.app.ht
            r0.<init>(r13, r14)
        L1b:
            java.lang.Object r14 = r0.f3001b
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.f3003d
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 == r4) goto L39
            if (r2 != r3) goto L31
            bo.app.fu r13 = r0.f3000a
            v8.u.b(r14)
            goto L70
        L31:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L39:
            bo.app.fu r13 = r0.f3000a
            v8.u.b(r14)
            goto L63
        L3f:
            v8.u.b(r14)
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = bo.app.fu.f2842b
            bo.app.jt r10 = new bo.app.jt
            r10.<init>(r13)
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 14
            r12 = 0
            com.braze.support.BrazeLogger.brazelog$default(r5, r6, r7, r8, r9, r10, r11, r12)
            kotlinx.coroutines.b2 r14 = r13.f2843a
            if (r14 == 0) goto L70
            r0.f3000a = r13
            r0.f3003d = r4
            java.lang.Object r14 = kotlinx.coroutines.f2.g(r14, r0)
            if (r14 != r1) goto L63
            goto L75
        L63:
            r0.f3000a = r13
            r0.f3003d = r3
            r2 = 50
            java.lang.Object r14 = kotlinx.coroutines.y0.a(r2, r0)
            if (r14 != r1) goto L70
            goto L75
        L70:
            r14 = 0
            r13.f2843a = r14
            v8.k0 r1 = v8.k0.f35197a
        L75:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.fu.a(bo.app.fu, z8.d):java.lang.Object");
    }
}
