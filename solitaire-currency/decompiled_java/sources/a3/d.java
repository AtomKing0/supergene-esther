package a3;

import a4.c0;
import a4.o0;
import a4.t;
import android.util.Pair;
import androidx.media3.extractor.WavUtil;
import java.io.IOException;
import k2.j2;
import p2.m;

/* JADX INFO: compiled from: WavHeaderReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: compiled from: WavHeaderReader.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f125a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f126b;

        private a(int i10, long j10) {
            this.f125a = i10;
            this.f126b = j10;
        }

        public static a a(m mVar, c0 c0Var) throws IOException {
            mVar.peekFully(c0Var.d(), 0, 8);
            c0Var.P(0);
            return new a(c0Var.n(), c0Var.t());
        }
    }

    public static boolean a(m mVar) throws IOException {
        c0 c0Var = new c0(8);
        int i10 = a.a(mVar, c0Var).f125a;
        if (i10 != 1380533830 && i10 != 1380333108) {
            return false;
        }
        mVar.peekFully(c0Var.d(), 0, 4);
        c0Var.P(0);
        int iN = c0Var.n();
        if (iN == 1463899717) {
            return true;
        }
        t.c("WavHeaderReader", "Unsupported form type: " + iN);
        return false;
    }

    public static c b(m mVar) throws IOException {
        byte[] bArr;
        c0 c0Var = new c0(16);
        a aVarD = d(WavUtil.FMT_FOURCC, mVar, c0Var);
        a4.a.g(aVarD.f126b >= 16);
        mVar.peekFully(c0Var.d(), 0, 16);
        c0Var.P(0);
        int iV = c0Var.v();
        int iV2 = c0Var.v();
        int iU = c0Var.u();
        int iU2 = c0Var.u();
        int iV3 = c0Var.v();
        int iV4 = c0Var.v();
        int i10 = ((int) aVarD.f126b) - 16;
        if (i10 > 0) {
            byte[] bArr2 = new byte[i10];
            mVar.peekFully(bArr2, 0, i10);
            bArr = bArr2;
        } else {
            bArr = o0.f219f;
        }
        mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
        return new c(iV, iV2, iU, iU2, iV3, iV4, bArr);
    }

    public static long c(m mVar) throws IOException {
        c0 c0Var = new c0(8);
        a aVarA = a.a(mVar, c0Var);
        if (aVarA.f125a != 1685272116) {
            mVar.resetPeekPosition();
            return -1L;
        }
        mVar.advancePeekPosition(8);
        c0Var.P(0);
        mVar.peekFully(c0Var.d(), 0, 8);
        long jR = c0Var.r();
        mVar.skipFully(((int) aVarA.f126b) + 8);
        return jR;
    }

    private static a d(int i10, m mVar, c0 c0Var) throws IOException {
        a aVarA = a.a(mVar, c0Var);
        while (aVarA.f125a != i10) {
            t.i("WavHeaderReader", "Ignoring unknown WAV chunk: " + aVarA.f125a);
            long j10 = aVarA.f126b + 8;
            if (j10 > 2147483647L) {
                throw j2.c("Chunk is too large (~2GB+) to skip; id: " + aVarA.f125a);
            }
            mVar.skipFully((int) j10);
            aVarA = a.a(mVar, c0Var);
        }
        return aVarA;
    }

    public static Pair<Long, Long> e(m mVar) throws IOException {
        mVar.resetPeekPosition();
        a aVarD = d(1684108385, mVar, new c0(8));
        mVar.skipFully(8);
        return Pair.create(Long.valueOf(mVar.getPosition()), Long.valueOf(aVarD.f126b));
    }
}
