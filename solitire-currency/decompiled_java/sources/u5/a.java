package u5;

import java.util.List;

/* JADX INFO: compiled from: AutoValue_HeartBeatResult.java */
/* JADX INFO: loaded from: classes3.dex */
final class a extends r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f34618a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f34619b;

    a(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f34618a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f34619b = list;
    }

    @Override // u5.r
    public List<String> b() {
        return this.f34619b;
    }

    @Override // u5.r
    public String c() {
        return this.f34618a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f34618a.equals(rVar.c()) && this.f34619b.equals(rVar.b());
    }

    public int hashCode() {
        return ((this.f34618a.hashCode() ^ 1000003) * 1000003) ^ this.f34619b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f34618a + ", usedDates=" + this.f34619b + "}";
    }
}
