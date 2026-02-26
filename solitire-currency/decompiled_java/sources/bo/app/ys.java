package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class ys {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4381a;

    public ys(String mite) {
        kotlin.jvm.internal.t.i(mite, "mite");
        this.f4381a = mite;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ys) && kotlin.jvm.internal.t.d(this.f4381a, ((ys) obj).f4381a);
    }

    public final int hashCode() {
        return this.f4381a.hashCode();
    }

    public final String toString() {
        return h1.a(new StringBuilder("DustMiteReceivedEvent(mite="), this.f4381a, ')');
    }
}
