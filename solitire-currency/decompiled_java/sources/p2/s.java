package p2;

import a4.o0;
import androidx.media3.extractor.ts.PsExtractor;
import java.io.IOException;
import k2.j2;

/* JADX INFO: compiled from: FlacFrameReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: compiled from: FlacFrameReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f32528a;
    }

    private static boolean a(a4.c0 c0Var, v vVar, int i10) {
        int iJ = j(c0Var, i10);
        return iJ != -1 && iJ <= vVar.f32533b;
    }

    private static boolean b(a4.c0 c0Var, int i10) {
        return c0Var.D() == o0.s(c0Var.d(), i10, c0Var.e() - 1, 0);
    }

    private static boolean c(a4.c0 c0Var, v vVar, boolean z10, a aVar) {
        try {
            long jK = c0Var.K();
            if (!z10) {
                jK *= (long) vVar.f32533b;
            }
            aVar.f32528a = jK;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public static boolean d(a4.c0 c0Var, v vVar, int i10, a aVar) {
        int iE = c0Var.e();
        long jF = c0Var.F();
        long j10 = jF >>> 16;
        if (j10 != i10) {
            return false;
        }
        return g((int) ((jF >> 4) & 15), vVar) && f((int) ((jF >> 1) & 7), vVar) && !(((jF & 1) > 1L ? 1 : ((jF & 1) == 1L ? 0 : -1)) == 0) && c(c0Var, vVar, ((j10 & 1) > 1L ? 1 : ((j10 & 1) == 1L ? 0 : -1)) == 0, aVar) && a(c0Var, vVar, (int) ((jF >> 12) & 15)) && e(c0Var, vVar, (int) ((jF >> 8) & 15)) && b(c0Var, iE);
    }

    private static boolean e(a4.c0 c0Var, v vVar, int i10) {
        int i11 = vVar.f32536e;
        if (i10 == 0) {
            return true;
        }
        if (i10 <= 11) {
            return i10 == vVar.f32537f;
        }
        if (i10 == 12) {
            return c0Var.D() * 1000 == i11;
        }
        if (i10 > 14) {
            return false;
        }
        int iJ = c0Var.J();
        if (i10 == 14) {
            iJ *= 10;
        }
        return iJ == i11;
    }

    private static boolean f(int i10, v vVar) {
        return i10 == 0 || i10 == vVar.f32540i;
    }

    private static boolean g(int i10, v vVar) {
        return i10 <= 7 ? i10 == vVar.f32538g - 1 : i10 <= 10 && vVar.f32538g == 2;
    }

    public static boolean h(m mVar, v vVar, int i10, a aVar) throws IOException {
        long peekPosition = mVar.getPeekPosition();
        byte[] bArr = new byte[2];
        mVar.peekFully(bArr, 0, 2);
        if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i10) {
            mVar.resetPeekPosition();
            mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
            return false;
        }
        a4.c0 c0Var = new a4.c0(16);
        System.arraycopy(bArr, 0, c0Var.d(), 0, 2);
        c0Var.O(o.c(mVar, c0Var.d(), 2, 14));
        mVar.resetPeekPosition();
        mVar.advancePeekPosition((int) (peekPosition - mVar.getPosition()));
        return d(c0Var, vVar, i10, aVar);
    }

    public static long i(m mVar, v vVar) throws IOException {
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(1);
        byte[] bArr = new byte[1];
        mVar.peekFully(bArr, 0, 1);
        boolean z10 = (bArr[0] & 1) == 1;
        mVar.advancePeekPosition(2);
        int i10 = z10 ? 7 : 6;
        a4.c0 c0Var = new a4.c0(i10);
        c0Var.O(o.c(mVar, c0Var.d(), 0, i10));
        mVar.resetPeekPosition();
        a aVar = new a();
        if (c(c0Var, vVar, z10, aVar)) {
            return aVar.f32528a;
        }
        throw j2.a(null, null);
    }

    public static int j(a4.c0 c0Var, int i10) {
        switch (i10) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i10 - 2);
            case 6:
                return c0Var.D() + 1;
            case 7:
                return c0Var.J() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i10 - 8);
            default:
                return -1;
        }
    }
}
