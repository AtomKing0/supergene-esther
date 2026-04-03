package u0;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: ResourceCacheKey.java */
/* JADX INFO: loaded from: classes2.dex */
final class x implements r0.f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final o1.g<Class<?>, byte[]> f34430j = new o1.g<>(50);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final v0.b f34431b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final r0.f f34432c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final r0.f f34433d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f34434e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f34435f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Class<?> f34436g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final r0.h f34437h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final r0.l<?> f34438i;

    x(v0.b bVar, r0.f fVar, r0.f fVar2, int i10, int i11, r0.l<?> lVar, Class<?> cls, r0.h hVar) {
        this.f34431b = bVar;
        this.f34432c = fVar;
        this.f34433d = fVar2;
        this.f34434e = i10;
        this.f34435f = i11;
        this.f34438i = lVar;
        this.f34436g = cls;
        this.f34437h = hVar;
    }

    private byte[] c() {
        o1.g<Class<?>, byte[]> gVar = f34430j;
        byte[] bArrG = gVar.g(this.f34436g);
        if (bArrG != null) {
            return bArrG;
        }
        byte[] bytes = this.f34436g.getName().getBytes(r0.f.f33247a);
        gVar.k(this.f34436g, bytes);
        return bytes;
    }

    @Override // r0.f
    public void b(@NonNull MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.f34431b.d(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.f34434e).putInt(this.f34435f).array();
        this.f34433d.b(messageDigest);
        this.f34432c.b(messageDigest);
        messageDigest.update(bArr);
        r0.l<?> lVar = this.f34438i;
        if (lVar != null) {
            lVar.b(messageDigest);
        }
        this.f34437h.b(messageDigest);
        messageDigest.update(c());
        this.f34431b.put(bArr);
    }

    @Override // r0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return this.f34435f == xVar.f34435f && this.f34434e == xVar.f34434e && o1.k.c(this.f34438i, xVar.f34438i) && this.f34436g.equals(xVar.f34436g) && this.f34432c.equals(xVar.f34432c) && this.f34433d.equals(xVar.f34433d) && this.f34437h.equals(xVar.f34437h);
    }

    @Override // r0.f
    public int hashCode() {
        int iHashCode = (((((this.f34432c.hashCode() * 31) + this.f34433d.hashCode()) * 31) + this.f34434e) * 31) + this.f34435f;
        r0.l<?> lVar = this.f34438i;
        if (lVar != null) {
            iHashCode = (iHashCode * 31) + lVar.hashCode();
        }
        return (((iHashCode * 31) + this.f34436g.hashCode()) * 31) + this.f34437h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.f34432c + ", signature=" + this.f34433d + ", width=" + this.f34434e + ", height=" + this.f34435f + ", decodedResourceClass=" + this.f34436g + ", transformation='" + this.f34438i + "', options=" + this.f34437h + '}';
    }
}
