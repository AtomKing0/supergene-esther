package f2;

import f2.f;
import java.util.Map;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i2.a f25586a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<w1.e, f.b> f25587b;

    b(i2.a aVar, Map<w1.e, f.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.f25586a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f25587b = map;
    }

    @Override // f2.f
    i2.a e() {
        return this.f25586a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f25586a.equals(fVar.e()) && this.f25587b.equals(fVar.h());
    }

    @Override // f2.f
    Map<w1.e, f.b> h() {
        return this.f25587b;
    }

    public int hashCode() {
        return ((this.f25586a.hashCode() ^ 1000003) * 1000003) ^ this.f25587b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f25586a + ", values=" + this.f25587b + "}";
    }
}
