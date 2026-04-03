package i;

import bo.app.h00;
import bo.app.mf;
import bo.app.mn;
import bo.app.tf;
import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class k {
    public static void a(h00 h00Var, long j10, long j11) {
        tf tfVar = (tf) h00Var;
        if (tfVar.f3924f.w()) {
            tfVar.a(new mn(tfVar.f3924f, tfVar.f3923e.getBaseUrlForRequests(), j10, j11, tfVar.f3920b, 0));
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) tfVar, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) mf.f3416a, 6, (Object) null);
        }
    }
}
