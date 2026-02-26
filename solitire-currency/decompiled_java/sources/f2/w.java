package f2;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkInitializer_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements a2.b<v> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Executor> f25654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<g2.d> f25655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<x> f25656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u8.a<h2.b> f25657d;

    public w(u8.a<Executor> aVar, u8.a<g2.d> aVar2, u8.a<x> aVar3, u8.a<h2.b> aVar4) {
        this.f25654a = aVar;
        this.f25655b = aVar2;
        this.f25656c = aVar3;
        this.f25657d = aVar4;
    }

    public static w a(u8.a<Executor> aVar, u8.a<g2.d> aVar2, u8.a<x> aVar3, u8.a<h2.b> aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, g2.d dVar, x xVar, h2.b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c(this.f25654a.get(), this.f25655b.get(), this.f25656c.get(), this.f25657d.get());
    }
}
