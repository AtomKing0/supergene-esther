package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class eo extends uu {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f2745l = BrazeLogger.getBrazeLogTag((Class<?>) eo.class);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eo(cs dispatchDataProvider) {
        super(k00.V3_DATA, dispatchDataProvider);
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
    }

    @Override // bo.app.uu
    public final void a(long j10) {
        ca caVar;
        ca caVar2;
        ArrayList arrayList = this.f4048f;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            a90 a90Var = ((z80) obj).f4413d;
            if (a90Var == a90.PENDING_START || a90Var == a90.PENDING_RETRY) {
                arrayList2.add(obj);
            }
        }
        List listI0 = kotlin.collections.d0.I0(arrayList2, new bo());
        int size = listI0.size();
        if (size < 2) {
            return;
        }
        z80 z80Var = (z80) kotlin.collections.d0.i0(listI0);
        List<z80> listSubList = listI0.subList(1, size);
        l00 l00Var = z80Var != null ? z80Var.f4410a : null;
        cp cpVar = l00Var instanceof cp ? (cp) l00Var : null;
        if (cpVar == null) {
            return;
        }
        for (z80 z80Var2 : listSubList) {
            l00 l00Var2 = z80Var2.f4410a;
            cp cpVar2 = l00Var2 instanceof cp ? (cp) l00Var2 : null;
            if (cpVar2 != null && ((cpVar.f2585l == null || cpVar2.f2585l == null) && (((caVar = cpVar.f2586m) == null || caVar.f2496b) && ((caVar2 = cpVar2.f2586m) == null || caVar2.f2496b)))) {
                k50 k50Var = cpVar2.f2583j;
                Boolean bool = (cpVar.f2583j.b() || k50Var.b()) ? Boolean.TRUE : null;
                Boolean bool2 = (cpVar.f2583j.c() || k50Var.c()) ? Boolean.TRUE : null;
                i50 outboundConfigParams = cpVar.f2583j.f3217d;
                if (outboundConfigParams != null) {
                    kotlin.jvm.internal.t.i(outboundConfigParams, "outboundConfigParams");
                } else {
                    outboundConfigParams = null;
                }
                i50 outboundConfigParams2 = k50Var.f3217d;
                if (outboundConfigParams2 != null) {
                    kotlin.jvm.internal.t.i(outboundConfigParams2, "outboundConfigParams");
                    outboundConfigParams = outboundConfigParams2;
                }
                String str = cpVar.f2583j.f3214a;
                if (str == null) {
                    str = null;
                }
                String str2 = k50Var.f3214a;
                if (str2 != null) {
                    str = str2;
                }
                cpVar.f2583j = new k50(str, bool, bool2, outboundConfigParams);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, f2745l, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new co(z80Var2, j10, z80Var), 14, (Object) null);
                z80Var2.a(j10, a90.BATCHED);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new Cdo(cpVar2, z80Var), 7, (Object) null);
            }
        }
    }
}
