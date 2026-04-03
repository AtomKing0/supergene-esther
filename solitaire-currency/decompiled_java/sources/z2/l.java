package z2;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.util.Collections;
import java.util.List;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: DvbSubtitleReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<i0.a> f37163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final p2.e0[] f37164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f37168f = C.TIME_UNSET;

    public l(List<i0.a> list) {
        this.f37163a = list;
        this.f37164b = new p2.e0[list.size()];
    }

    private boolean d(a4.c0 c0Var, int i10) {
        if (c0Var.a() == 0) {
            return false;
        }
        if (c0Var.D() != i10) {
            this.f37165c = false;
        }
        this.f37166d--;
        return this.f37165c;
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        if (this.f37165c) {
            if (this.f37166d != 2 || d(c0Var, 32)) {
                if (this.f37166d != 1 || d(c0Var, 0)) {
                    int iE = c0Var.e();
                    int iA = c0Var.a();
                    for (p2.e0 e0Var : this.f37164b) {
                        c0Var.P(iE);
                        e0Var.e(c0Var, iA);
                    }
                    this.f37167e += iA;
                }
            }
        }
    }

    @Override // z2.m
    public void b() {
        if (this.f37165c) {
            if (this.f37168f != C.TIME_UNSET) {
                for (p2.e0 e0Var : this.f37164b) {
                    e0Var.a(this.f37168f, 1, this.f37167e, 0, null);
                }
            }
            this.f37165c = false;
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        for (int i10 = 0; i10 < this.f37164b.length; i10++) {
            i0.a aVar = this.f37163a.get(i10);
            dVar.a();
            p2.e0 e0VarTrack = nVar.track(dVar.c(), 3);
            e0VarTrack.f(new o1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_DVBSUBS).T(Collections.singletonList(aVar.f37138c)).V(aVar.f37136a).E());
            this.f37164b[i10] = e0VarTrack;
        }
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.f37165c = true;
        if (j10 != C.TIME_UNSET) {
            this.f37168f = j10;
        }
        this.f37167e = 0;
        this.f37166d = 2;
    }

    @Override // z2.m
    public void seek() {
        this.f37165c = false;
        this.f37168f = C.TIME_UNSET;
    }
}
