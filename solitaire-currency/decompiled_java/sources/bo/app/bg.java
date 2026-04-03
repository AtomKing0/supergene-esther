package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class bg {
    public final boolean a(String key) {
        kotlin.jvm.internal.t.i(key, "key");
        if (p9.q.z(key)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) zf.f4436a, 6, (Object) null);
            return false;
        }
        if (!p9.q.K(key, "$", false, 2, null)) {
            return true;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) ag.f2376a, 6, (Object) null);
        return false;
    }
}
