package y1;

import java.util.Set;

/* JADX INFO: compiled from: TransportFactoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class p implements w1.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<w1.c> f36416a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final o f36417b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final s f36418c;

    p(Set<w1.c> set, o oVar, s sVar) {
        this.f36416a = set;
        this.f36417b = oVar;
        this.f36418c = sVar;
    }

    @Override // w1.i
    public <T> w1.h<T> a(String str, Class<T> cls, w1.c cVar, w1.g<T, byte[]> gVar) {
        if (this.f36416a.contains(cVar)) {
            return new r(this.f36417b, str, cVar, gVar, this.f36418c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", cVar, this.f36416a));
    }
}
