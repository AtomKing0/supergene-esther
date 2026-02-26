package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class s70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t70 f3836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3837b;

    public s70(t70 pathType, String remoteUrl) {
        kotlin.jvm.internal.t.i(pathType, "pathType");
        kotlin.jvm.internal.t.i(remoteUrl, "remoteUrl");
        this.f3836a = pathType;
        this.f3837b = remoteUrl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s70)) {
            return false;
        }
        s70 s70Var = (s70) obj;
        return this.f3836a == s70Var.f3836a && kotlin.jvm.internal.t.d(this.f3837b, s70Var.f3837b);
    }

    public final int hashCode() {
        return this.f3837b.hashCode() + (this.f3836a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RemotePath(pathType=");
        sb.append(this.f3836a);
        sb.append(", remoteUrl=");
        return h1.a(sb, this.f3837b, ')');
    }
}
