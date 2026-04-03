package bo.app;

import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class df0 {
    public static boolean a(g10 triggerEvent, bh0 action, long j10, long j11) {
        long j12;
        kotlin.jvm.internal.t.i(triggerEvent, "triggerEvent");
        kotlin.jvm.internal.t.i(action, "action");
        if (triggerEvent instanceof od0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, cg0.f2514q, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) ze0.f4435a, 14, (Object) null);
            return true;
        }
        long jNowInSeconds = DateTimeUtils.nowInSeconds();
        g90 g90Var = action.f2453b;
        long j13 = jNowInSeconds + ((long) g90Var.f2886d);
        int i10 = g90Var.f2889g;
        if (i10 != -1) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, cg0.f2514q, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new af0(i10), 14, (Object) null);
            j12 = j10 + ((long) i10);
        } else {
            j12 = j10 + j11;
        }
        long j14 = j12;
        if (j13 >= j14) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, cg0.f2514q, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new bf0(j13, j14), 12, (Object) null);
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, cg0.f2514q, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new cf0(j11, j14, j13), 12, (Object) null);
        return false;
    }
}
