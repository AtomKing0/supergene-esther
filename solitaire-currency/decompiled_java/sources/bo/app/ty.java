package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class ty implements m00 {
    @Override // bo.app.m00
    public final e00 a(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new sy(cardId), 6, (Object) null);
        return null;
    }

    @Override // bo.app.m00
    public final e00 b(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        z9 z9Var = ba.f2429g;
        z9Var.getClass();
        kotlin.jvm.internal.t.i(cardId, "cardId");
        return z9Var.a(new b9(cardId));
    }

    @Override // bo.app.m00
    public final e00 c(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new ry(cardId), 6, (Object) null);
        return null;
    }

    @Override // bo.app.m00
    public final e00 d(String cardId) {
        kotlin.jvm.internal.t.i(cardId, "cardId");
        z9 z9Var = ba.f2429g;
        z9Var.getClass();
        kotlin.jvm.internal.t.i(cardId, "cardId");
        return z9Var.a(new c9(cardId));
    }
}
