package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class s80 implements a80 {
    @Override // bo.app.a80
    public final void a(n apiResponse) {
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new q80(apiResponse), 7, (Object) null);
    }

    @Override // bo.app.a80
    public final void a(s50 apiResponse) {
        kotlin.jvm.internal.t.i(apiResponse, "apiResponse");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new r80(apiResponse), 7, (Object) null);
    }
}
