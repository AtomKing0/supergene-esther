package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class ed0 extends uu {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ox f2728l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ed0(cs dispatchDataProvider) {
        super(k00.TEMPLATE_REQUEST, dispatchDataProvider);
        kotlin.jvm.internal.t.i(dispatchDataProvider, "dispatchDataProvider");
        this.f2728l = new ox((int) TimeUnit.MINUTES.toMillis(1L), dispatchDataProvider.b().f(), dispatchDataProvider.b().g());
    }

    @Override // bo.app.uu
    public final void a(long j10) {
        ArrayList arrayList = this.f4048f;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            a90 a90Var = ((z80) obj).f4413d;
            if (a90Var == a90.PENDING_RETRY || a90Var == a90.PENDING_START) {
                arrayList2.add(obj);
            }
        }
        ArrayList<z80> arrayList3 = new ArrayList();
        for (Object obj2 : arrayList2) {
            z80 z80Var = (z80) obj2;
            l00 l00Var = z80Var.f4410a;
            gd0 gd0Var = l00Var instanceof gd0 ? (gd0) l00Var : null;
            if ((gd0Var != null ? ((we0) gd0Var.f2899k).f4202b + gd0Var.f2902n : -1L) < z80Var.f4411b) {
                arrayList3.add(obj2);
            }
        }
        for (z80 z80Var2 : arrayList3) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new dd0(j10, z80Var2), 7, (Object) null);
            z80Var2.a(j10, a90.COMPLETE);
        }
    }

    @Override // bo.app.uu
    public final ox a() {
        return this.f2728l;
    }
}
