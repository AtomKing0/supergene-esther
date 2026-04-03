package z2;

import androidx.media3.common.MimeTypes;
import java.util.List;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: SeiReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<o1> f37042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p2.e0[] f37043b;

    public d0(List<o1> list) {
        this.f37042a = list;
        this.f37043b = new p2.e0[list.size()];
    }

    public void a(long j10, a4.c0 c0Var) {
        p2.c.a(j10, c0Var, this.f37043b);
    }

    public void b(p2.n nVar, i0.d dVar) {
        for (int i10 = 0; i10 < this.f37043b.length; i10++) {
            dVar.a();
            p2.e0 e0VarTrack = nVar.track(dVar.c(), 3);
            o1 o1Var = this.f37042a.get(i10);
            String str = o1Var.f29347l;
            a4.a.b(MimeTypes.APPLICATION_CEA608.equals(str) || MimeTypes.APPLICATION_CEA708.equals(str), "Invalid closed caption mime type provided: " + str);
            String strB = o1Var.f29336a;
            if (strB == null) {
                strB = dVar.b();
            }
            e0VarTrack.f(new o1.b().S(strB).e0(str).g0(o1Var.f29339d).V(o1Var.f29338c).F(o1Var.D).T(o1Var.f29349n).E());
            this.f37043b[i10] = e0VarTrack;
        }
    }
}
