package z2;

import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: Id3Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r implements m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p2.e0 f37294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37295c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f37297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f37298f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.c0 f37293a = new a4.c0(10);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f37296d = C.TIME_UNSET;

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        a4.a.i(this.f37294b);
        if (this.f37295c) {
            int iA = c0Var.a();
            int i10 = this.f37298f;
            if (i10 < 10) {
                int iMin = Math.min(iA, 10 - i10);
                System.arraycopy(c0Var.d(), c0Var.e(), this.f37293a.d(), this.f37298f, iMin);
                if (this.f37298f + iMin == 10) {
                    this.f37293a.P(0);
                    if (73 != this.f37293a.D() || 68 != this.f37293a.D() || 51 != this.f37293a.D()) {
                        a4.t.i("Id3Reader", "Discarding invalid ID3 tag");
                        this.f37295c = false;
                        return;
                    } else {
                        this.f37293a.Q(3);
                        this.f37297e = this.f37293a.C() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.f37297e - this.f37298f);
            this.f37294b.e(c0Var, iMin2);
            this.f37298f += iMin2;
        }
    }

    @Override // z2.m
    public void b() {
        int i10;
        a4.a.i(this.f37294b);
        if (this.f37295c && (i10 = this.f37297e) != 0 && this.f37298f == i10) {
            long j10 = this.f37296d;
            if (j10 != C.TIME_UNSET) {
                this.f37294b.a(j10, 1, i10, 0, null);
            }
            this.f37295c = false;
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        p2.e0 e0VarTrack = nVar.track(dVar.c(), 5);
        this.f37294b = e0VarTrack;
        e0VarTrack.f(new o1.b().S(dVar.b()).e0(MimeTypes.APPLICATION_ID3).E());
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if ((i10 & 4) == 0) {
            return;
        }
        this.f37295c = true;
        if (j10 != C.TIME_UNSET) {
            this.f37296d = j10;
        }
        this.f37297e = 0;
        this.f37298f = 0;
    }

    @Override // z2.m
    public void seek() {
        this.f37295c = false;
        this.f37296d = C.TIME_UNSET;
    }
}
