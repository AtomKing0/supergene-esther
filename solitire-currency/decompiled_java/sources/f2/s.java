package f2;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: Uploader_Factory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s implements a2.b<r> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final u8.a<Context> f25639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u8.a<z1.e> f25640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u8.a<g2.d> f25641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final u8.a<x> f25642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final u8.a<Executor> f25643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final u8.a<h2.b> f25644f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final u8.a<i2.a> f25645g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final u8.a<i2.a> f25646h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final u8.a<g2.c> f25647i;

    public s(u8.a<Context> aVar, u8.a<z1.e> aVar2, u8.a<g2.d> aVar3, u8.a<x> aVar4, u8.a<Executor> aVar5, u8.a<h2.b> aVar6, u8.a<i2.a> aVar7, u8.a<i2.a> aVar8, u8.a<g2.c> aVar9) {
        this.f25639a = aVar;
        this.f25640b = aVar2;
        this.f25641c = aVar3;
        this.f25642d = aVar4;
        this.f25643e = aVar5;
        this.f25644f = aVar6;
        this.f25645g = aVar7;
        this.f25646h = aVar8;
        this.f25647i = aVar9;
    }

    public static s a(u8.a<Context> aVar, u8.a<z1.e> aVar2, u8.a<g2.d> aVar3, u8.a<x> aVar4, u8.a<Executor> aVar5, u8.a<h2.b> aVar6, u8.a<i2.a> aVar7, u8.a<i2.a> aVar8, u8.a<g2.c> aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, z1.e eVar, g2.d dVar, x xVar, Executor executor, h2.b bVar, i2.a aVar, i2.a aVar2, g2.c cVar) {
        return new r(context, eVar, dVar, xVar, executor, bVar, aVar, aVar2, cVar);
    }

    @Override // u8.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c(this.f25639a.get(), this.f25640b.get(), this.f25641c.get(), this.f25642d.get(), this.f25643e.get(), this.f25644f.get(), this.f25645g.get(), this.f25646h.get(), this.f25647i.get());
    }
}
