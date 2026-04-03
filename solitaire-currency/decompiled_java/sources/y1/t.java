package y1;

import android.content.Context;
import androidx.annotation.RestrictTo;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: compiled from: TransportRuntime.java */
/* JADX INFO: loaded from: classes2.dex */
public class t implements s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile u f36424e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i2.a f36425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i2.a f36426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e2.e f36427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f2.r f36428d;

    t(i2.a aVar, i2.a aVar2, e2.e eVar, f2.r rVar, f2.v vVar) {
        this.f36425a = aVar;
        this.f36426b = aVar2;
        this.f36427c = eVar;
        this.f36428d = rVar;
        vVar.c();
    }

    private i b(n nVar) {
        return i.a().i(this.f36425a.a()).k(this.f36426b.a()).j(nVar.g()).h(new h(nVar.b(), nVar.d())).g(nVar.c().a()).d();
    }

    public static t c() {
        u uVar = f36424e;
        if (uVar != null) {
            return uVar.c();
        }
        throw new IllegalStateException("Not initialized!");
    }

    private static Set<w1.c> d(f fVar) {
        return fVar instanceof g ? Collections.unmodifiableSet(((g) fVar).a()) : Collections.singleton(w1.c.b("proto"));
    }

    public static void f(Context context) {
        if (f36424e == null) {
            synchronized (t.class) {
                if (f36424e == null) {
                    f36424e = e.i().a(context).build();
                }
            }
        }
    }

    @Override // y1.s
    public void a(n nVar, w1.j jVar) {
        this.f36427c.a(nVar.f().f(nVar.c().c()), b(nVar), jVar);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public f2.r e() {
        return this.f36428d;
    }

    public w1.i g(f fVar) {
        return new p(d(fVar), o.a().b(fVar.getName()).c(fVar.getExtras()).a(), this);
    }
}
