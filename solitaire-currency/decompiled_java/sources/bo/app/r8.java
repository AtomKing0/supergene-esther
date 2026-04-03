package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
public final class r8 extends z8.a implements kotlinx.coroutines.l0 {
    public r8(l0.b bVar) {
        super(bVar);
    }

    @Override // kotlinx.coroutines.l0
    public final void handleException(z8.g gVar, Throwable th) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) BrazeCoroutineScope.INSTANCE, BrazeLogger.Priority.E, th, false, (h9.a) new p8(th), 4, (Object) null);
    }
}
