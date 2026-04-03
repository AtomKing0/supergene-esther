package p2;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import k2.j2;
import p2.v;

/* JADX INFO: compiled from: FlacMetadataReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t {

    /* JADX INFO: compiled from: FlacMetadataReader.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public v f32529a;

        public a(@Nullable v vVar) {
            this.f32529a = vVar;
        }
    }

    public static boolean a(m mVar) throws IOException {
        a4.c0 c0Var = new a4.c0(4);
        mVar.peekFully(c0Var.d(), 0, 4);
        return c0Var.F() == 1716281667;
    }

    public static int b(m mVar) throws IOException {
        mVar.resetPeekPosition();
        a4.c0 c0Var = new a4.c0(2);
        mVar.peekFully(c0Var.d(), 0, 2);
        int iJ = c0Var.J();
        if ((iJ >> 2) == 16382) {
            mVar.resetPeekPosition();
            return iJ;
        }
        mVar.resetPeekPosition();
        throw j2.a("First frame does not start with sync code.", null);
    }

    @Nullable
    public static c3.a c(m mVar, boolean z10) throws IOException {
        c3.a aVarA = new y().a(mVar, z10 ? null : h3.h.f26446b);
        if (aVarA == null || aVarA.e() == 0) {
            return null;
        }
        return aVarA;
    }

    @Nullable
    public static c3.a d(m mVar, boolean z10) throws IOException {
        mVar.resetPeekPosition();
        long peekPosition = mVar.getPeekPosition();
        c3.a aVarC = c(mVar, z10);
        mVar.skipFully((int) (mVar.getPeekPosition() - peekPosition));
        return aVarC;
    }

    public static boolean e(m mVar, a aVar) throws IOException {
        mVar.resetPeekPosition();
        a4.b0 b0Var = new a4.b0(new byte[4]);
        mVar.peekFully(b0Var.f141a, 0, 4);
        boolean zG = b0Var.g();
        int iH = b0Var.h(7);
        int iH2 = b0Var.h(24) + 4;
        if (iH == 0) {
            aVar.f32529a = h(mVar);
        } else {
            v vVar = aVar.f32529a;
            if (vVar == null) {
                throw new IllegalArgumentException();
            }
            if (iH == 3) {
                aVar.f32529a = vVar.b(g(mVar, iH2));
            } else if (iH == 4) {
                aVar.f32529a = vVar.c(j(mVar, iH2));
            } else if (iH == 6) {
                a4.c0 c0Var = new a4.c0(iH2);
                mVar.readFully(c0Var.d(), 0, iH2);
                c0Var.Q(4);
                aVar.f32529a = vVar.a(com.google.common.collect.y.r(f3.a.a(c0Var)));
            } else {
                mVar.skipFully(iH2);
            }
        }
        return zG;
    }

    public static v.a f(a4.c0 c0Var) {
        c0Var.Q(1);
        int iG = c0Var.G();
        long jE = ((long) c0Var.e()) + ((long) iG);
        int i10 = iG / 18;
        long[] jArrCopyOf = new long[i10];
        long[] jArrCopyOf2 = new long[i10];
        int i11 = 0;
        while (true) {
            if (i11 >= i10) {
                break;
            }
            long jW = c0Var.w();
            if (jW == -1) {
                jArrCopyOf = Arrays.copyOf(jArrCopyOf, i11);
                jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i11);
                break;
            }
            jArrCopyOf[i11] = jW;
            jArrCopyOf2[i11] = c0Var.w();
            c0Var.Q(2);
            i11++;
        }
        c0Var.Q((int) (jE - ((long) c0Var.e())));
        return new v.a(jArrCopyOf, jArrCopyOf2);
    }

    private static v.a g(m mVar, int i10) throws IOException {
        a4.c0 c0Var = new a4.c0(i10);
        mVar.readFully(c0Var.d(), 0, i10);
        return f(c0Var);
    }

    private static v h(m mVar) throws IOException {
        byte[] bArr = new byte[38];
        mVar.readFully(bArr, 0, 38);
        return new v(bArr, 4);
    }

    public static void i(m mVar) throws IOException {
        a4.c0 c0Var = new a4.c0(4);
        mVar.readFully(c0Var.d(), 0, 4);
        if (c0Var.F() != 1716281667) {
            throw j2.a("Failed to read FLAC stream marker.", null);
        }
    }

    private static List<String> j(m mVar, int i10) throws IOException {
        a4.c0 c0Var = new a4.c0(i10);
        mVar.readFully(c0Var.d(), 0, i10);
        c0Var.Q(4);
        return Arrays.asList(h0.j(c0Var, false, false).f32492b);
    }
}
