package f6;

/* JADX INFO: compiled from: AutoValue_LibraryVersion.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f25712b;

    a(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.f25711a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f25712b = str2;
    }

    @Override // f6.f
    public String b() {
        return this.f25711a;
    }

    @Override // f6.f
    public String c() {
        return this.f25712b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f25711a.equals(fVar.b()) && this.f25712b.equals(fVar.c());
    }

    public int hashCode() {
        return ((this.f25711a.hashCode() ^ 1000003) * 1000003) ^ this.f25712b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.f25711a + ", version=" + this.f25712b + "}";
    }
}
