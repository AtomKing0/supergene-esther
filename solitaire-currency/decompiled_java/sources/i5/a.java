package i5;

/* JADX INFO: compiled from: AutoValue_StartupTime.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f26588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f26589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f26590c;

    a(long j10, long j11, long j12) {
        this.f26588a = j10;
        this.f26589b = j11;
        this.f26590c = j12;
    }

    @Override // i5.l
    public long b() {
        return this.f26589b;
    }

    @Override // i5.l
    public long c() {
        return this.f26588a;
    }

    @Override // i5.l
    public long d() {
        return this.f26590c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.f26588a == lVar.c() && this.f26589b == lVar.b() && this.f26590c == lVar.d();
    }

    public int hashCode() {
        long j10 = this.f26588a;
        long j11 = this.f26589b;
        int i10 = (((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j11 ^ (j11 >>> 32)))) * 1000003;
        long j12 = this.f26590c;
        return i10 ^ ((int) ((j12 >>> 32) ^ j12));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f26588a + ", elapsedRealtime=" + this.f26589b + ", uptimeMillis=" + this.f26590c + "}";
    }
}
