package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ac0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zb0 f2368a;

    public ac0(w40 session) {
        kotlin.jvm.internal.t.i(session, "session");
        this.f2368a = session;
        if (!(!session.d())) {
            throw new IllegalArgumentException("Session created events cannot be created with already sealed sessions.".toString());
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ac0) && kotlin.jvm.internal.t.d(this.f2368a, ((ac0) obj).f2368a);
    }

    public final int hashCode() {
        return this.f2368a.hashCode();
    }

    public final String toString() {
        return "SessionCreatedEvent(session=" + this.f2368a + ')';
    }
}
