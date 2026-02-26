package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class c70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f2489a;

    public c70(long j10) {
        this.f2489a = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c70) && this.f2489a == ((c70) obj).f2489a;
    }

    public final int hashCode() {
        return androidx.compose.animation.a.a(this.f2489a);
    }

    public final String toString() {
        return "PushMaxRequestSuccessEvent(lastUpdateTime=" + this.f2489a + ')';
    }
}
