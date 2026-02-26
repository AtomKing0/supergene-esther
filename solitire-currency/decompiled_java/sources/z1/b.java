package z1;

import z1.g;

/* JADX INFO: compiled from: AutoValue_BackendResponse.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final g.a f36976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f36977b;

    b(g.a aVar, long j10) {
        if (aVar == null) {
            throw new NullPointerException("Null status");
        }
        this.f36976a = aVar;
        this.f36977b = j10;
    }

    @Override // z1.g
    public long b() {
        return this.f36977b;
    }

    @Override // z1.g
    public g.a c() {
        return this.f36976a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.f36976a.equals(gVar.c()) && this.f36977b == gVar.b();
    }

    public int hashCode() {
        int iHashCode = (this.f36976a.hashCode() ^ 1000003) * 1000003;
        long j10 = this.f36977b;
        return iHashCode ^ ((int) (j10 ^ (j10 >>> 32)));
    }

    public String toString() {
        return "BackendResponse{status=" + this.f36976a + ", nextRequestWaitMillis=" + this.f36977b + "}";
    }
}
