package bo.app;

import com.braze.support.BrazeLogger;

/* JADX INFO: loaded from: classes2.dex */
public final class cv implements e10 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e10 f2601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v00 f2602b;

    public cv(tc0 sessionStorageManager, vw eventPublisher) {
        kotlin.jvm.internal.t.i(sessionStorageManager, "sessionStorageManager");
        kotlin.jvm.internal.t.i(eventPublisher, "eventPublisher");
        this.f2601a = sessionStorageManager;
        this.f2602b = eventPublisher;
    }

    @Override // bo.app.e10
    public final void a(String sessionId) {
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
        try {
            this.f2601a.a(sessionId);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) yu.f4383a, 4, (Object) null);
            a(this.f2602b, e10);
        }
    }

    @Override // bo.app.e10
    public final zb0 a() {
        try {
            return this.f2601a.a();
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) av.f2402a, 4, (Object) null);
            a(this.f2602b, e10);
            return null;
        }
    }

    public final void a(v00 eventPublisher, Exception throwable) {
        kotlin.jvm.internal.t.i(eventPublisher, "eventPublisher");
        kotlin.jvm.internal.t.i(throwable, "throwable");
        try {
            ((vw) eventPublisher).b(uc0.class, new uc0("A storage exception has occurred. Please view the stack trace for more details.", throwable));
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) zu.f4485a, 4, (Object) null);
        }
    }

    @Override // bo.app.e10
    public final void a(w40 session) {
        kotlin.jvm.internal.t.i(session, "session");
        try {
            this.f2601a.a(session);
        } catch (Exception e10) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e10, false, (h9.a) bv.f2473a, 4, (Object) null);
            a(this.f2602b, e10);
        }
    }
}
