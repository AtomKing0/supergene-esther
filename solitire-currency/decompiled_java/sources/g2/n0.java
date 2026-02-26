package g2;

/* JADX INFO: compiled from: SQLiteEventStore_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n0 implements a2.b<m0> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<i2.a> f25833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<i2.a> f25834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<e> f25835c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u8.a<t0> f25836d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u8.a<String> f25837e;

    public n0(u8.a<i2.a> aVar, u8.a<i2.a> aVar2, u8.a<e> aVar3, u8.a<t0> aVar4, u8.a<String> aVar5) {
        this.f25833a = aVar;
        this.f25834b = aVar2;
        this.f25835c = aVar3;
        this.f25836d = aVar4;
        this.f25837e = aVar5;
    }

    public static n0 a(u8.a<i2.a> aVar, u8.a<i2.a> aVar2, u8.a<e> aVar3, u8.a<t0> aVar4, u8.a<String> aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(i2.a aVar, i2.a aVar2, Object obj, Object obj2, u8.a<String> aVar3) {
        return new m0(aVar, aVar2, (e) obj, (t0) obj2, aVar3);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c(this.f25833a.get(), this.f25834b.get(), this.f25835c.get(), this.f25836d.get(), this.f25837e);
    }
}
