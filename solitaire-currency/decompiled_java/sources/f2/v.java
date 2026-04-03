package f2;

import h2.b;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: WorkInitializer.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f25650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g2.d f25651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x f25652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final h2.b f25653d;

    v(Executor executor, g2.d dVar, x xVar, h2.b bVar) {
        this.f25650a = executor;
        this.f25651b = dVar;
        this.f25652c = xVar;
        this.f25653d = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d() {
        Iterator<y1.o> it = this.f25651b.u().iterator();
        while (it.hasNext()) {
            this.f25652c.a(it.next(), 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.f25653d.i(new b.a() { // from class: f2.u
            @Override // h2.b.a
            public final Object execute() {
                return this.f25649a.d();
            }
        });
    }

    public void c() {
        this.f25650a.execute(new Runnable() { // from class: f2.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f25648a.e();
            }
        });
    }
}
