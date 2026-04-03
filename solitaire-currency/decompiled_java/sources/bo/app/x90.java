package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class x90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r90 f4255a;

    public x90(r90 debugConfig) {
        kotlin.jvm.internal.t.i(debugConfig, "debugConfig");
        this.f4255a = debugConfig;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof x90) && kotlin.jvm.internal.t.d(this.f4255a, ((x90) obj).f4255a);
    }

    public final int hashCode() {
        return this.f4255a.hashCode();
    }

    public final String toString() {
        return "SdkDebuggerConfigUpdateEvent(debugConfig=" + this.f4255a + ')';
    }
}
