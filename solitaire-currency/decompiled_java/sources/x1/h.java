package x1;

/* JADX INFO: compiled from: AutoValue_LogResponse.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35665a;

    h(long j10) {
        this.f35665a = j10;
    }

    @Override // x1.n
    public long c() {
        return this.f35665a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && this.f35665a == ((n) obj).c();
    }

    public int hashCode() {
        long j10 = this.f35665a;
        return ((int) (j10 ^ (j10 >>> 32))) ^ 1000003;
    }

    public String toString() {
        return "LogResponse{nextRequestWaitMillis=" + this.f35665a + "}";
    }
}
