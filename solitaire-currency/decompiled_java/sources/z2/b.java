package z2;

import android.net.Uri;
import androidx.media3.common.C;
import java.io.IOException;
import java.util.Map;
import p2.b0;
import z2.i0;

/* JADX INFO: compiled from: Ac3Extractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements p2.l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final p2.r f37020d = new p2.r() { // from class: z2.a
        @Override // p2.r
        public final p2.l[] createExtractors() {
            return b.e();
        }

        @Override // p2.r
        public /* synthetic */ p2.l[] createExtractors(Uri uri, Map map) {
            return p2.q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c f37021a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.c0 f37022b = new a4.c0(2786);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f37023c;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ p2.l[] e() {
        return new p2.l[]{new b()};
    }

    @Override // p2.l
    public int a(p2.m mVar, p2.a0 a0Var) throws IOException {
        int i10 = mVar.read(this.f37022b.d(), 0, 2786);
        if (i10 == -1) {
            return -1;
        }
        this.f37022b.P(0);
        this.f37022b.O(i10);
        if (!this.f37023c) {
            this.f37021a.packetStarted(0L, 4);
            this.f37023c = true;
        }
        this.f37021a.a(this.f37022b);
        return 0;
    }

    @Override // p2.l
    public void b(p2.n nVar) {
        this.f37021a.c(nVar, new i0.d(0, 1));
        nVar.endTracks();
        nVar.h(new b0.b(C.TIME_UNSET));
    }

    @Override // p2.l
    public boolean c(p2.m mVar) throws IOException {
        a4.c0 c0Var = new a4.c0(10);
        int i10 = 0;
        while (true) {
            mVar.peekFully(c0Var.d(), 0, 10);
            c0Var.P(0);
            if (c0Var.G() != 4801587) {
                break;
            }
            c0Var.Q(3);
            int iC = c0Var.C();
            i10 += iC + 10;
            mVar.advancePeekPosition(iC);
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i10);
        int i11 = 0;
        int i12 = i10;
        while (true) {
            mVar.peekFully(c0Var.d(), 0, 6);
            c0Var.P(0);
            if (c0Var.J() != 2935) {
                mVar.resetPeekPosition();
                i12++;
                if (i12 - i10 >= 8192) {
                    return false;
                }
                mVar.advancePeekPosition(i12);
                i11 = 0;
            } else {
                i11++;
                if (i11 >= 4) {
                    return true;
                }
                int iF = m2.b.f(c0Var.d());
                if (iF == -1) {
                    return false;
                }
                mVar.advancePeekPosition(iF - 6);
            }
        }
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f37023c = false;
        this.f37021a.seek();
    }

    @Override // p2.l
    public void release() {
    }
}
