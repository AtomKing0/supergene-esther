package y1;

/* JADX INFO: compiled from: TransportRuntime_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements a2.b<t> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<i2.a> f36429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<i2.a> f36430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<e2.e> f36431c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u8.a<f2.r> f36432d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u8.a<f2.v> f36433e;

    public v(u8.a<i2.a> aVar, u8.a<i2.a> aVar2, u8.a<e2.e> aVar3, u8.a<f2.r> aVar4, u8.a<f2.v> aVar5) {
        this.f36429a = aVar;
        this.f36430b = aVar2;
        this.f36431c = aVar3;
        this.f36432d = aVar4;
        this.f36433e = aVar5;
    }

    public static v a(u8.a<i2.a> aVar, u8.a<i2.a> aVar2, u8.a<e2.e> aVar3, u8.a<f2.r> aVar4, u8.a<f2.v> aVar5) {
        return new v(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static t c(i2.a aVar, i2.a aVar2, e2.e eVar, f2.r rVar, f2.v vVar) {
        return new t(aVar, aVar2, eVar, rVar, vVar);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t get() {
        return c(this.f36429a.get(), this.f36430b.get(), this.f36431c.get(), this.f36432d.get(), this.f36433e.get());
    }
}
