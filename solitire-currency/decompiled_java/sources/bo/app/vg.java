package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class vg {
    public static final void a(Object obj, h9.a aVar) {
        try {
            aVar.invoke();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, obj, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) new ug(obj), 4, (Object) null);
        }
    }
}
