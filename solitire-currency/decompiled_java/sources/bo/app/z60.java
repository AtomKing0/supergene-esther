package bo.app;

/* JADX INFO: loaded from: classes2.dex */
public final class z60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4404b;

    public z60(String id, long j10) {
        kotlin.jvm.internal.t.i(id, "id");
        this.f4403a = id;
        this.f4404b = j10;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z60)) {
            return false;
        }
        z60 z60Var = (z60) obj;
        return kotlin.jvm.internal.t.d(this.f4403a, z60Var.f4403a) && this.f4404b == z60Var.f4404b;
    }

    public final int hashCode() {
        return androidx.compose.animation.a.a(this.f4404b) + (this.f4403a.hashCode() * 31);
    }

    public final String toString() {
        return "CampaignData(id=" + this.f4403a + ", timestamp=" + this.f4404b + ')';
    }
}
