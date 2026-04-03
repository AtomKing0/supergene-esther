package u0;

import androidx.annotation.NonNull;
import java.security.MessageDigest;

/* JADX INFO: compiled from: DataCacheKey.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements r0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r0.f f34245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r0.f f34246c;

    d(r0.f fVar, r0.f fVar2) {
        this.f34245b = fVar;
        this.f34246c = fVar2;
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        this.f34245b.b(messageDigest);
        this.f34246c.b(messageDigest);
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f34245b.equals(dVar.f34245b) && this.f34246c.equals(dVar.f34246c);
    }

    @Override // r0.f
    public int hashCode() {
        return (this.f34245b.hashCode() * 31) + this.f34246c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f34245b + ", signature=" + this.f34246c + '}';
    }
}
