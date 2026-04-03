package bo.app;

import com.braze.support.BrazeLogger;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class pa0 extends z8.a implements kotlinx.coroutines.l0 {
    public pa0(l0.b bVar) {
        super(bVar);
    }

    @Override // kotlinx.coroutines.l0
    public final void handleException(z8.g gVar, Throwable th) {
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) qa0.f3696a, BrazeLogger.Priority.E, th, false, (h9.a) new oa0(th), 4, (Object) null);
            v00 v00Var = qa0.f3697b;
            if (v00Var != null) {
                ((vw) v00Var).b(Throwable.class, th);
            }
        } catch (Exception unused) {
        }
    }
}
