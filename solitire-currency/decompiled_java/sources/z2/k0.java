package z2;

import androidx.media3.common.MimeTypes;
import java.util.List;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: UserDataReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o1> f37161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p2.e0[] f37162b;

    public k0(List<o1> list) {
        this.f37161a = list;
        this.f37162b = new p2.e0[list.size()];
    }

    public void a(long j10, a4.c0 c0Var) {
        if (c0Var.a() < 9) {
            return;
        }
        int iN = c0Var.n();
        int iN2 = c0Var.n();
        int iD = c0Var.D();
        if (iN == 434 && iN2 == 1195456820 && iD == 3) {
            p2.c.b(j10, c0Var, this.f37162b);
        }
    }

    public void b(p2.n nVar, i0.d dVar) {
        for (int i10 = 0; i10 < this.f37162b.length; i10++) {
            dVar.a();
            p2.e0 e0VarTrack = nVar.track(dVar.c(), 3);
            o1 o1Var = this.f37161a.get(i10);
            String str = o1Var.f29347l;
            a4.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            e0VarTrack.f(new o1.b().S(dVar.b()).e0(str).g0(o1Var.f29339d).V(o1Var.f29338c).F(o1Var.D).T(o1Var.f29349n).E());
            this.f37162b[i10] = e0VarTrack;
        }
    }
}
