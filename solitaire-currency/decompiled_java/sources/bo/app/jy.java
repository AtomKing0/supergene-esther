package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class jy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ny f3184a;

    public jy(ny request) {
        kotlin.jvm.internal.t.i(request, "request");
        this.f3184a = request;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof jy) && kotlin.jvm.internal.t.d(this.f3184a, ((jy) obj).f3184a);
    }

    public final int hashCode() {
        return this.f3184a.hashCode();
    }

    public final String toString() {
        return "FeatureFlagsRequestSuccessEvent(request=" + this.f3184a + ')';
    }
}
