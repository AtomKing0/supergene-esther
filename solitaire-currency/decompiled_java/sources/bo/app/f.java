package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y9.d f2760a = y9.f.b(1, 0, 2, null);

    public final synchronized void a(Object obj, boolean z10) {
        if (this.f2760a.b() != 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (h9.a) new a(obj, z10), 6, (Object) null);
            return;
        }
        b(obj, z10);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (h9.a) new b(this), 6, (Object) null);
        this.f2760a.release();
    }

    public abstract Object b();

    public abstract void b(Object obj, boolean z10);

    public final synchronized Object a() {
        Object objB;
        if (this.f2760a.c()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) new c(this), 7, (Object) null);
            objB = b();
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (h9.a) d.f2611a, 7, (Object) null);
            objB = null;
        }
        return objB;
    }
}
