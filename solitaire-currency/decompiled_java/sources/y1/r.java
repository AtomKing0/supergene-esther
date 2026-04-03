package y1;

/* JADX INFO: compiled from: TransportImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class r<T> implements w1.h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final o f36419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f36420b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final w1.c f36421c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final w1.g<T, byte[]> f36422d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final s f36423e;

    r(o oVar, String str, w1.c cVar, w1.g<T, byte[]> gVar, s sVar) {
        this.f36419a = oVar;
        this.f36420b = str;
        this.f36421c = cVar;
        this.f36422d = gVar;
        this.f36423e = sVar;
    }

    @Override // w1.h
    public void a(w1.d<T> dVar) {
        d(dVar, new w1.j() { // from class: y1.q
            @Override // w1.j
            public final void a(Exception exc) {
                r.c(exc);
            }
        });
    }

    public void d(w1.d<T> dVar, w1.j jVar) {
        this.f36423e.a(n.a().e(this.f36419a).c(dVar).f(this.f36420b).d(this.f36422d).b(this.f36421c).a(), jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(Exception exc) {
    }
}
