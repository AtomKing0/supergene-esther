package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class gb0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb0 f2893a;

    public gb0(fb0 serverConfig) {
        kotlin.jvm.internal.t.i(serverConfig, "serverConfig");
        this.f2893a = serverConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof gb0) && kotlin.jvm.internal.t.d(this.f2893a, ((gb0) obj).f2893a);
    }

    public final int hashCode() {
        return this.f2893a.hashCode();
    }

    public final String toString() {
        return "ServerConfigReceivedEvent(serverConfig=" + this.f2893a + ')';
    }
}
