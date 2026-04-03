package h3;

import a4.b0;
import a4.c0;
import a4.o0;
import a4.t;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: Id3Decoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h extends c3.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f26446b = new a() { // from class: h3.g
        @Override // h3.h.a
        public final boolean evaluate(int i10, int i11, int i12, int i13, int i14) {
            return h.z(i10, i11, i12, i13, i14);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final a f26447a;

    /* JADX INFO: compiled from: Id3Decoder.java */
    public interface a {
        boolean evaluate(int i10, int i11, int i12, int i13, int i14);
    }

    /* JADX INFO: compiled from: Id3Decoder.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f26448a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f26449b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f26450c;

        public b(int i10, boolean z10, int i11) {
            this.f26448a = i10;
            this.f26449b = z10;
            this.f26450c = i11;
        }
    }

    public h() {
        this(null);
    }

    private static int A(c0 c0Var, int i10) {
        byte[] bArrD = c0Var.d();
        int iE = c0Var.e();
        int i11 = iE;
        while (true) {
            int i12 = i11 + 1;
            if (i12 >= iE + i10) {
                return i10;
            }
            if ((bArrD[i11] & 255) == 255 && bArrD[i12] == 0) {
                System.arraycopy(bArrD, i11 + 2, bArrD, i12, (i10 - (i11 - iE)) - 2);
                i10--;
            }
            i11 = i12;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0079 A[PHI: r3
      0x0079: PHI (r3v16 int) = (r3v5 int), (r3v19 int) binds: [B:40:0x0086, B:31:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static boolean B(a4.c0 r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.e()
        L8:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Laf
            r4 = 1
            r5 = r20
            if (r3 < r5) goto Lab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L22
            int r7 = r18.n()     // Catch: java.lang.Throwable -> Laf
            long r8 = r18.F()     // Catch: java.lang.Throwable -> Laf
            int r10 = r18.J()     // Catch: java.lang.Throwable -> Laf
            goto L2c
        L22:
            int r7 = r18.G()     // Catch: java.lang.Throwable -> Laf
            int r8 = r18.G()     // Catch: java.lang.Throwable -> Laf
            long r8 = (long) r8
            r10 = r6
        L2c:
            r11 = 0
            if (r7 != 0) goto L3a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L3a
            if (r10 != 0) goto L3a
            r1.P(r2)
            return r4
        L3a:
            r7 = 4
            if (r0 != r7) goto L6b
            if (r21 != 0) goto L6b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r11 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r11 == 0) goto L4b
            r1.P(r2)
            return r6
        L4b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L6b:
            if (r0 != r7) goto L7b
            r3 = r10 & 64
            if (r3 == 0) goto L73
            r3 = r4
            goto L74
        L73:
            r3 = r6
        L74:
            r7 = r10 & 1
            if (r7 == 0) goto L79
            goto L8b
        L79:
            r4 = r6
            goto L8b
        L7b:
            if (r0 != r3) goto L89
            r3 = r10 & 32
            if (r3 == 0) goto L83
            r3 = r4
            goto L84
        L83:
            r3 = r6
        L84:
            r7 = r10 & 128(0x80, float:1.8E-43)
            if (r7 == 0) goto L79
            goto L8b
        L89:
            r3 = r6
            r4 = r3
        L8b:
            if (r4 == 0) goto L8f
            int r3 = r3 + 4
        L8f:
            long r3 = (long) r3
            int r3 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r3 >= 0) goto L98
            r1.P(r2)
            return r6
        L98:
            int r3 = r18.a()     // Catch: java.lang.Throwable -> Laf
            long r3 = (long) r3
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 >= 0) goto La5
            r1.P(r2)
            return r6
        La5:
            int r3 = (int) r8
            r1.Q(r3)     // Catch: java.lang.Throwable -> Laf
            goto L8
        Lab:
            r1.P(r2)
            return r4
        Laf:
            r0 = move-exception
            r1.P(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.h.B(a4.c0, int, int, boolean):boolean");
    }

    private static byte[] d(byte[] bArr, int i10, int i11) {
        return i11 <= i10 ? o0.f219f : Arrays.copyOfRange(bArr, i10, i11);
    }

    private static h3.a f(c0 c0Var, int i10, int i11) throws UnsupportedEncodingException {
        int iY;
        String str;
        int iD = c0Var.D();
        String strV = v(iD);
        int i12 = i10 - 1;
        byte[] bArr = new byte[i12];
        c0Var.j(bArr, 0, i12);
        if (i11 == 2) {
            str = "image/" + e5.c.e(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = MimeTypes.IMAGE_JPEG;
            }
            iY = 2;
        } else {
            iY = y(bArr, 0);
            String strE = e5.c.e(new String(bArr, 0, iY, "ISO-8859-1"));
            if (strE.indexOf(47) == -1) {
                str = "image/" + strE;
            } else {
                str = strE;
            }
        }
        int i13 = bArr[iY + 1] & 255;
        int i14 = iY + 2;
        int iX = x(bArr, i14, iD);
        return new h3.a(str, new String(bArr, i14, iX - i14, strV), i13, d(bArr, iX + u(iD), i12));
    }

    private static h3.b g(c0 c0Var, int i10, String str) {
        byte[] bArr = new byte[i10];
        c0Var.j(bArr, 0, i10);
        return new h3.b(str, bArr);
    }

    private static c h(c0 c0Var, int i10, int i11, boolean z10, int i12, @Nullable a aVar) throws UnsupportedEncodingException {
        int iE = c0Var.e();
        int iY = y(c0Var.d(), iE);
        String str = new String(c0Var.d(), iE, iY - iE, "ISO-8859-1");
        c0Var.P(iY + 1);
        int iN = c0Var.n();
        int iN2 = c0Var.n();
        long jF = c0Var.F();
        long j10 = jF == 4294967295L ? -1L : jF;
        long jF2 = c0Var.F();
        long j11 = jF2 == 4294967295L ? -1L : jF2;
        ArrayList arrayList = new ArrayList();
        int i13 = iE + i10;
        while (c0Var.e() < i13) {
            i iVarK = k(i11, c0Var, z10, i12, aVar);
            if (iVarK != null) {
                arrayList.add(iVarK);
            }
        }
        return new c(str, iN, iN2, j10, j11, (i[]) arrayList.toArray(new i[0]));
    }

    private static d i(c0 c0Var, int i10, int i11, boolean z10, int i12, @Nullable a aVar) throws UnsupportedEncodingException {
        int iE = c0Var.e();
        int iY = y(c0Var.d(), iE);
        String str = new String(c0Var.d(), iE, iY - iE, "ISO-8859-1");
        c0Var.P(iY + 1);
        int iD = c0Var.D();
        boolean z11 = (iD & 2) != 0;
        boolean z12 = (iD & 1) != 0;
        int iD2 = c0Var.D();
        String[] strArr = new String[iD2];
        for (int i13 = 0; i13 < iD2; i13++) {
            int iE2 = c0Var.e();
            int iY2 = y(c0Var.d(), iE2);
            strArr[i13] = new String(c0Var.d(), iE2, iY2 - iE2, "ISO-8859-1");
            c0Var.P(iY2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i14 = iE + i10;
        while (c0Var.e() < i14) {
            i iVarK = k(i11, c0Var, z10, i12, aVar);
            if (iVarK != null) {
                arrayList.add(iVarK);
            }
        }
        return new d(str, z11, z12, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    @Nullable
    private static e j(c0 c0Var, int i10) throws UnsupportedEncodingException {
        if (i10 < 4) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        byte[] bArr = new byte[3];
        c0Var.j(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i11 = i10 - 4;
        byte[] bArr2 = new byte[i11];
        c0Var.j(bArr2, 0, i11);
        int iX = x(bArr2, 0, iD);
        String str2 = new String(bArr2, 0, iX, strV);
        int iU = iX + u(iD);
        return new e(str, str2, p(bArr2, iU, x(bArr2, iU, iD), strV));
    }

    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01ea A[Catch: all -> 0x012e, UnsupportedEncodingException -> 0x0218, TryCatch #0 {UnsupportedEncodingException -> 0x0218, blocks: (B:91:0x011c, B:159:0x01f4, B:93:0x0124, B:102:0x013d, B:104:0x0145, B:112:0x015f, B:121:0x0177, B:132:0x0192, B:139:0x01a4, B:145:0x01b3, B:150:0x01cb, B:156:0x01e5, B:157:0x01ea), top: B:169:0x0112, outer: #1 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static h3.i k(int r19, a4.c0 r20, boolean r21, int r22, @androidx.annotation.Nullable h3.h.a r23) {
        /*
            Method dump skipped, instruction units count: 558
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h3.h.k(int, a4.c0, boolean, int, h3.h$a):h3.i");
    }

    private static f l(c0 c0Var, int i10) throws UnsupportedEncodingException {
        int iD = c0Var.D();
        String strV = v(iD);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        int iY = y(bArr, 0);
        String str = new String(bArr, 0, iY, "ISO-8859-1");
        int i12 = iY + 1;
        int iX = x(bArr, i12, iD);
        String strP = p(bArr, i12, iX, strV);
        int iU = iX + u(iD);
        int iX2 = x(bArr, iU, iD);
        return new f(str, strP, p(bArr, iU, iX2, strV), d(bArr, iX2 + u(iD), i11));
    }

    @Nullable
    private static b m(c0 c0Var) {
        if (c0Var.a() < 10) {
            t.i("Id3Decoder", "Data too short to be an ID3 tag");
            return null;
        }
        int iG = c0Var.G();
        boolean z10 = false;
        if (iG != 4801587) {
            t.i("Id3Decoder", "Unexpected first three bytes of ID3 tag header: 0x" + String.format("%06X", Integer.valueOf(iG)));
            return null;
        }
        int iD = c0Var.D();
        c0Var.Q(1);
        int iD2 = c0Var.D();
        int iC = c0Var.C();
        if (iD == 2) {
            if ((iD2 & 64) != 0) {
                t.i("Id3Decoder", "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (iD == 3) {
            if ((iD2 & 64) != 0) {
                int iN = c0Var.n();
                c0Var.Q(iN);
                iC -= iN + 4;
            }
        } else {
            if (iD != 4) {
                t.i("Id3Decoder", "Skipped ID3 tag with unsupported majorVersion=" + iD);
                return null;
            }
            if ((iD2 & 64) != 0) {
                int iC2 = c0Var.C();
                c0Var.Q(iC2 - 4);
                iC -= iC2;
            }
            if ((iD2 & 16) != 0) {
                iC -= 10;
            }
        }
        if (iD < 4 && (iD2 & 128) != 0) {
            z10 = true;
        }
        return new b(iD, z10, iC);
    }

    private static k n(c0 c0Var, int i10) {
        int iJ = c0Var.J();
        int iG = c0Var.G();
        int iG2 = c0Var.G();
        int iD = c0Var.D();
        int iD2 = c0Var.D();
        b0 b0Var = new b0();
        b0Var.m(c0Var);
        int i11 = ((i10 - 10) * 8) / (iD + iD2);
        int[] iArr = new int[i11];
        int[] iArr2 = new int[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int iH = b0Var.h(iD);
            int iH2 = b0Var.h(iD2);
            iArr[i12] = iH;
            iArr2[i12] = iH2;
        }
        return new k(iJ, iG, iG2, iArr, iArr2);
    }

    private static l o(c0 c0Var, int i10) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        c0Var.j(bArr, 0, i10);
        int iY = y(bArr, 0);
        return new l(new String(bArr, 0, iY, "ISO-8859-1"), d(bArr, iY + 1, i10));
    }

    private static String p(byte[] bArr, int i10, int i11, String str) throws UnsupportedEncodingException {
        return (i11 <= i10 || i11 > bArr.length) ? "" : new String(bArr, i10, i11 - i10, str);
    }

    @Nullable
    private static m q(c0 c0Var, int i10, String str) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        return new m(str, null, new String(bArr, 0, x(bArr, 0, iD), strV));
    }

    @Nullable
    private static m r(c0 c0Var, int i10) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        int iX = x(bArr, 0, iD);
        String str = new String(bArr, 0, iX, strV);
        int iU = iX + u(iD);
        return new m("TXXX", str, p(bArr, iU, x(bArr, iU, iD), strV));
    }

    private static n s(c0 c0Var, int i10, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i10];
        c0Var.j(bArr, 0, i10);
        return new n(str, null, new String(bArr, 0, y(bArr, 0), "ISO-8859-1"));
    }

    @Nullable
    private static n t(c0 c0Var, int i10) throws UnsupportedEncodingException {
        if (i10 < 1) {
            return null;
        }
        int iD = c0Var.D();
        String strV = v(iD);
        int i11 = i10 - 1;
        byte[] bArr = new byte[i11];
        c0Var.j(bArr, 0, i11);
        int iX = x(bArr, 0, iD);
        String str = new String(bArr, 0, iX, strV);
        int iU = iX + u(iD);
        return new n("WXXX", str, p(bArr, iU, y(bArr, iU), "ISO-8859-1"));
    }

    private static int u(int i10) {
        return (i10 == 0 || i10 == 3) ? 1 : 2;
    }

    private static String v(int i10) {
        return i10 != 1 ? i10 != 2 ? i10 != 3 ? "ISO-8859-1" : "UTF-8" : "UTF-16BE" : "UTF-16";
    }

    private static String w(int i10, int i11, int i12, int i13, int i14) {
        return i10 == 2 ? String.format(Locale.US, "%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)) : String.format(Locale.US, "%c%c%c%c", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14));
    }

    private static int x(byte[] bArr, int i10, int i11) {
        int iY = y(bArr, i10);
        if (i11 == 0 || i11 == 3) {
            return iY;
        }
        while (iY < bArr.length - 1) {
            if ((iY - i10) % 2 == 0 && bArr[iY + 1] == 0) {
                return iY;
            }
            iY = y(bArr, iY + 1);
        }
        return bArr.length;
    }

    private static int y(byte[] bArr, int i10) {
        while (i10 < bArr.length) {
            if (bArr[i10] == 0) {
                return i10;
            }
            i10++;
        }
        return bArr.length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean z(int i10, int i11, int i12, int i13, int i14) {
        return false;
    }

    @Override // c3.h
    @Nullable
    protected c3.a b(c3.e eVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    @Nullable
    public c3.a e(byte[] bArr, int i10) {
        ArrayList arrayList = new ArrayList();
        c0 c0Var = new c0(bArr, i10);
        b bVarM = m(c0Var);
        if (bVarM == null) {
            return null;
        }
        int iE = c0Var.e();
        int i11 = bVarM.f26448a == 2 ? 6 : 10;
        int iA = bVarM.f26450c;
        if (bVarM.f26449b) {
            iA = A(c0Var, bVarM.f26450c);
        }
        c0Var.O(iE + iA);
        boolean z10 = false;
        if (!B(c0Var, bVarM.f26448a, i11, false)) {
            if (bVarM.f26448a != 4 || !B(c0Var, 4, i11, true)) {
                t.i("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + bVarM.f26448a);
                return null;
            }
            z10 = true;
        }
        while (c0Var.a() >= i11) {
            i iVarK = k(bVarM.f26448a, c0Var, z10, i11, this.f26447a);
            if (iVarK != null) {
                arrayList.add(iVarK);
            }
        }
        return new c3.a(arrayList);
    }

    public h(@Nullable a aVar) {
        this.f26447a = aVar;
    }
}
