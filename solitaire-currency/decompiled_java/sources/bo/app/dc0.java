package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class dc0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zb0 f2643a;

    public dc0(w40 sealedSession) {
        kotlin.jvm.internal.t.i(sealedSession, "sealedSession");
        this.f2643a = sealedSession;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof dc0) && kotlin.jvm.internal.t.d(this.f2643a, ((dc0) obj).f2643a);
    }

    public final int hashCode() {
        return this.f2643a.hashCode();
    }

    public final String toString() {
        return "SessionSealedEvent(sealedSession=" + this.f2643a + ')';
    }
}
