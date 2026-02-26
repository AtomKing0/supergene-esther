package e2;

import f2.x;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: DefaultScheduler_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements a2.b<c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Executor> f24719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<z1.e> f24720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<x> f24721c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u8.a<g2.d> f24722d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u8.a<h2.b> f24723e;

    public d(u8.a<Executor> aVar, u8.a<z1.e> aVar2, u8.a<x> aVar3, u8.a<g2.d> aVar4, u8.a<h2.b> aVar5) {
        this.f24719a = aVar;
        this.f24720b = aVar2;
        this.f24721c = aVar3;
        this.f24722d = aVar4;
        this.f24723e = aVar5;
    }

    public static d a(u8.a<Executor> aVar, u8.a<z1.e> aVar2, u8.a<x> aVar3, u8.a<g2.d> aVar4, u8.a<h2.b> aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, z1.e eVar, x xVar, g2.d dVar, h2.b bVar) {
        return new c(executor, eVar, xVar, dVar, bVar);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c(this.f24719a.get(), this.f24720b.get(), this.f24721c.get(), this.f24722d.get(), this.f24723e.get());
    }
}
