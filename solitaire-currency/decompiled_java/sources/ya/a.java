package ya;

import java.util.Queue;
import za.e;

/* JADX INFO: compiled from: EventRecodingLogger.java */
/* JADX INFO: loaded from: classes5.dex */
public class a implements xa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f36934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    e f36935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Queue<d> f36936c;

    public a(e eVar, Queue<d> queue) {
        this.f36935b = eVar;
        this.f36934a = eVar.getName();
        this.f36936c = queue;
    }

    private void c(b bVar, xa.c cVar, String str, Object[] objArr, Throwable th) {
        d dVar = new d();
        dVar.j(System.currentTimeMillis());
        dVar.c(bVar);
        dVar.d(this.f36935b);
        dVar.e(this.f36934a);
        dVar.f(cVar);
        dVar.g(str);
        dVar.h(Thread.currentThread().getName());
        dVar.b(objArr);
        dVar.i(th);
        this.f36936c.add(dVar);
    }

    private void d(b bVar, xa.c cVar, String str, Throwable th) {
        c(bVar, cVar, str, null, th);
    }

    @Override // xa.a
    public void a(String str) {
        d(b.WARN, null, str, null);
    }

    @Override // xa.a
    public void b(String str) {
        d(b.TRACE, null, str, null);
    }

    @Override // xa.a
    public String getName() {
        return this.f36934a;
    }
}
