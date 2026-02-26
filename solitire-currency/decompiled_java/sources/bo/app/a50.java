package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class a50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z40 f2351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z40 f2352b;

    public a50(z40 oldNetworkLevel, z40 newNetworkLevel) {
        kotlin.jvm.internal.t.i(oldNetworkLevel, "oldNetworkLevel");
        kotlin.jvm.internal.t.i(newNetworkLevel, "newNetworkLevel");
        this.f2351a = oldNetworkLevel;
        this.f2352b = newNetworkLevel;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a50)) {
            return false;
        }
        a50 a50Var = (a50) obj;
        return this.f2351a == a50Var.f2351a && this.f2352b == a50Var.f2352b;
    }

    public final int hashCode() {
        return this.f2352b.hashCode() + (this.f2351a.hashCode() * 31);
    }

    public final String toString() {
        return "NetworkLevelChangeEvent(oldNetworkLevel=" + this.f2351a + ", newNetworkLevel=" + this.f2352b + ')';
    }
}
