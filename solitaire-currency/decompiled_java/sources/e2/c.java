package e2;

import f2.x;
import h2.b;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import w1.j;
import y1.o;
import y1.t;
import z1.m;

/* JADX INFO: compiled from: DefaultScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Logger f24713f = Logger.getLogger(t.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final x f24714a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f24715b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final z1.e f24716c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final g2.d f24717d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final h2.b f24718e;

    public c(Executor executor, z1.e eVar, x xVar, g2.d dVar, h2.b bVar) {
        this.f24715b = executor;
        this.f24716c = eVar;
        this.f24714a = xVar;
        this.f24717d = dVar;
        this.f24718e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object d(o oVar, y1.i iVar) {
        this.f24717d.Z(oVar, iVar);
        this.f24714a.a(oVar, 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(final o oVar, j jVar, y1.i iVar) {
        try {
            m mVar = this.f24716c.get(oVar.b());
            if (mVar == null) {
                String str = String.format("Transport backend '%s' is not registered", oVar.b());
                f24713f.warning(str);
                jVar.a(new IllegalArgumentException(str));
            } else {
                final y1.i iVarA = mVar.a(iVar);
                this.f24718e.i(new b.a() { // from class: e2.b
                    @Override // h2.b.a
                    public final Object execute() {
                        return this.f24710a.d(oVar, iVarA);
                    }
                });
                jVar.a(null);
            }
        } catch (Exception e10) {
            f24713f.warning("Error scheduling event " + e10.getMessage());
            jVar.a(e10);
        }
    }

    @Override // e2.e
    public void a(final o oVar, final y1.i iVar, final j jVar) {
        this.f24715b.execute(new Runnable() { // from class: e2.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f24706a.e(oVar, jVar, iVar);
            }
        });
    }
}
