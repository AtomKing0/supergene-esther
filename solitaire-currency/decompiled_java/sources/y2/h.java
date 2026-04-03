package y2;

import a4.c0;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.OpusUtil;
import com.google.common.collect.y;
import java.util.Arrays;
import java.util.List;
import k2.j2;
import k2.o1;
import m2.i0;
import p2.h0;
import y2.i;

/* JADX INFO: compiled from: OpusReader.java */
/* JADX INFO: loaded from: classes2.dex */
final class h extends i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final byte[] f36473o = {79, 112, 117, 115, 72, 101, 97, 100};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final byte[] f36474p = {79, 112, 117, 115, 84, 97, 103, 115};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f36475n;

    h() {
    }

    private long n(byte[] bArr) {
        int i10;
        int i11 = bArr[0] & 255;
        int i12 = i11 & 3;
        if (i12 != 0) {
            i10 = 2;
            if (i12 != 1 && i12 != 2) {
                i10 = bArr[1] & 63;
            }
        } else {
            i10 = 1;
        }
        int i13 = i11 >> 3;
        int i14 = i13 & 3;
        return ((long) i10) * ((long) (i13 >= 16 ? 2500 << i14 : i13 >= 12 ? 10000 << (i14 & 1) : i14 == 3 ? 60000 : 10000 << i14));
    }

    private static boolean o(c0 c0Var, byte[] bArr) {
        if (c0Var.a() < bArr.length) {
            return false;
        }
        int iE = c0Var.e();
        byte[] bArr2 = new byte[bArr.length];
        c0Var.j(bArr2, 0, bArr.length);
        c0Var.P(iE);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean p(c0 c0Var) {
        return o(c0Var, f36473o);
    }

    @Override // y2.i
    protected long f(c0 c0Var) {
        return c(n(c0Var.d()));
    }

    @Override // y2.i
    protected boolean h(c0 c0Var, long j10, i.b bVar) throws j2 {
        if (o(c0Var, f36473o)) {
            byte[] bArrCopyOf = Arrays.copyOf(c0Var.d(), c0Var.f());
            int iC = i0.c(bArrCopyOf);
            List<byte[]> listA = i0.a(bArrCopyOf);
            if (bVar.f36489a != null) {
                return true;
            }
            bVar.f36489a = new o1.b().e0(MimeTypes.AUDIO_OPUS).H(iC).f0(OpusUtil.SAMPLE_RATE).T(listA).E();
            return true;
        }
        byte[] bArr = f36474p;
        if (!o(c0Var, bArr)) {
            a4.a.i(bVar.f36489a);
            return false;
        }
        a4.a.i(bVar.f36489a);
        if (this.f36475n) {
            return true;
        }
        this.f36475n = true;
        c0Var.Q(bArr.length);
        c3.a aVarC = h0.c(y.n(h0.j(c0Var, false, false).f32492b));
        if (aVarC == null) {
            return true;
        }
        bVar.f36489a = bVar.f36489a.b().X(aVarC.b(bVar.f36489a.f29345j)).E();
        return true;
    }

    @Override // y2.i
    protected void l(boolean z10) {
        super.l(z10);
        if (z10) {
            this.f36475n = false;
        }
    }
}
