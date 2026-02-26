package g2;

/* JADX INFO: compiled from: AutoValue_PersistedEvent.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f25799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final y1.o f25800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final y1.i f25801c;

    b(long j10, y1.o oVar, y1.i iVar) {
        this.f25799a = j10;
        if (oVar == null) {
            throw new NullPointerException("Null transportContext");
        }
        this.f25800b = oVar;
        if (iVar == null) {
            throw new NullPointerException("Null event");
        }
        this.f25801c = iVar;
    }

    @Override // g2.k
    public y1.i b() {
        return this.f25801c;
    }

    @Override // g2.k
    public long c() {
        return this.f25799a;
    }

    @Override // g2.k
    public y1.o d() {
        return this.f25800b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f25799a == kVar.c() && this.f25800b.equals(kVar.d()) && this.f25801c.equals(kVar.b());
    }

    public int hashCode() {
        long j10 = this.f25799a;
        return ((((((int) (j10 ^ (j10 >>> 32))) ^ 1000003) * 1000003) ^ this.f25800b.hashCode()) * 1000003) ^ this.f25801c.hashCode();
    }

    public String toString() {
        return "PersistedEvent{id=" + this.f25799a + ", transportContext=" + this.f25800b + ", event=" + this.f25801c + "}";
    }
}
