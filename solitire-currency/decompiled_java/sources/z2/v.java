package z2;

import a4.l0;
import a4.o0;
import androidx.media3.common.C;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: PassthroughSectionPayloadReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v implements b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private o1 f37337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private l0 f37338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private p2.e0 f37339c;

    public v(String str) {
        this.f37337a = new o1.b().e0(str).E();
    }

    private void c() {
        a4.a.i(this.f37338b);
        o0.j(this.f37339c);
    }

    @Override // z2.b0
    public void a(a4.c0 c0Var) {
        c();
        long jD = this.f37338b.d();
        long jE = this.f37338b.e();
        if (jD == C.TIME_UNSET || jE == C.TIME_UNSET) {
            return;
        }
        o1 o1Var = this.f37337a;
        if (jE != o1Var.f29351p) {
            o1 o1VarE = o1Var.b().i0(jE).E();
            this.f37337a = o1VarE;
            this.f37339c.f(o1VarE);
        }
        int iA = c0Var.a();
        this.f37339c.e(c0Var, iA);
        this.f37339c.a(jD, 1, iA, 0, null);
    }

    @Override // z2.b0
    public void b(l0 l0Var, p2.n nVar, i0.d dVar) {
        this.f37338b = l0Var;
        dVar.a();
        p2.e0 e0VarTrack = nVar.track(dVar.c(), 5);
        this.f37339c = e0VarTrack;
        e0VarTrack.f(this.f37337a);
    }
}
