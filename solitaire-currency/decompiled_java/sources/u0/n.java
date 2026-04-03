package u0;

import androidx.annotation.NonNull;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: EngineKey.java */
/* JADX INFO: loaded from: classes2.dex */
class n implements r0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f34384b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f34385c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f34386d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Class<?> f34387e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Class<?> f34388f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final r0.f f34389g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Map<Class<?>, r0.l<?>> f34390h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r0.h f34391i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f34392j;

    n(Object obj, r0.f fVar, int i10, int i11, Map<Class<?>, r0.l<?>> map, Class<?> cls, Class<?> cls2, r0.h hVar) {
        this.f34384b = o1.j.d(obj);
        this.f34389g = (r0.f) o1.j.e(fVar, "Signature must not be null");
        this.f34385c = i10;
        this.f34386d = i11;
        this.f34390h = (Map) o1.j.d(map);
        this.f34387e = (Class) o1.j.e(cls, "Resource class must not be null");
        this.f34388f = (Class) o1.j.e(cls2, "Transcode class must not be null");
        this.f34391i = (r0.h) o1.j.d(hVar);
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f34384b.equals(nVar.f34384b) && this.f34389g.equals(nVar.f34389g) && this.f34386d == nVar.f34386d && this.f34385c == nVar.f34385c && this.f34390h.equals(nVar.f34390h) && this.f34387e.equals(nVar.f34387e) && this.f34388f.equals(nVar.f34388f) && this.f34391i.equals(nVar.f34391i);
    }

    @Override // r0.f
    public int hashCode() {
        if (this.f34392j == 0) {
            int iHashCode = this.f34384b.hashCode();
            this.f34392j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.f34389g.hashCode()) * 31) + this.f34385c) * 31) + this.f34386d;
            this.f34392j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.f34390h.hashCode();
            this.f34392j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.f34387e.hashCode();
            this.f34392j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f34388f.hashCode();
            this.f34392j = iHashCode5;
            this.f34392j = (iHashCode5 * 31) + this.f34391i.hashCode();
        }
        return this.f34392j;
    }

    public String toString() {
        return "EngineKey{model=" + this.f34384b + ", width=" + this.f34385c + ", height=" + this.f34386d + ", resourceClass=" + this.f34387e + ", transcodeClass=" + this.f34388f + ", signature=" + this.f34389g + ", hashCode=" + this.f34392j + ", transformations=" + this.f34390h + ", options=" + this.f34391i + '}';
    }
}
