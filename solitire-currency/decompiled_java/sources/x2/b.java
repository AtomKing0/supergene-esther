package x2;

import a4.c0;
import a4.o0;
import a4.t;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.mp4.Atom;
import androidx.media3.extractor.ts.PsExtractor;
import c3.a;
import com.google.common.collect.y;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k2.j2;
import k2.o1;
import p2.x;
import x2.a;

/* JADX INFO: compiled from: AtomParsers.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f35734a = o0.h0("OpusHead");

    /* JADX INFO: compiled from: AtomParsers.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f35736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f35738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f35739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c0 f35740f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final c0 f35741g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f35742h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f35743i;

        public a(c0 c0Var, c0 c0Var2, boolean z10) throws j2 {
            this.f35741g = c0Var;
            this.f35740f = c0Var2;
            this.f35739e = z10;
            c0Var2.P(12);
            this.f35735a = c0Var2.H();
            c0Var.P(12);
            this.f35743i = c0Var.H();
            p2.o.a(c0Var.n() == 1, "first_chunk must be 1");
            this.f35736b = -1;
        }

        public boolean a() {
            int i10 = this.f35736b + 1;
            this.f35736b = i10;
            if (i10 == this.f35735a) {
                return false;
            }
            this.f35738d = this.f35739e ? this.f35740f.I() : this.f35740f.F();
            if (this.f35736b == this.f35742h) {
                this.f35737c = this.f35741g.H();
                this.f35741g.Q(4);
                int i11 = this.f35743i - 1;
                this.f35743i = i11;
                this.f35742h = i11 > 0 ? this.f35741g.H() - 1 : -1;
            }
            return true;
        }
    }

    /* JADX INFO: renamed from: x2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AtomParsers.java */
    private static final class C0731b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f35744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final byte[] f35745b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f35746c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final long f35747d;

        public C0731b(String str, byte[] bArr, long j10, long j11) {
            this.f35744a = str;
            this.f35745b = bArr;
            this.f35746c = j10;
            this.f35747d = j11;
        }
    }

    /* JADX INFO: compiled from: AtomParsers.java */
    private interface c {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    /* JADX INFO: compiled from: AtomParsers.java */
    private static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final p[] f35748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public o1 f35749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f35751d = 0;

        public d(int i10) {
            this.f35748a = new p[i10];
        }
    }

    /* JADX INFO: compiled from: AtomParsers.java */
    static final class e implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35753b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final c0 f35754c;

        public e(a.b bVar, o1 o1Var) {
            c0 c0Var = bVar.f35733b;
            this.f35754c = c0Var;
            c0Var.P(12);
            int iH = c0Var.H();
            if (MimeTypes.AUDIO_RAW.equals(o1Var.f29347l)) {
                int iY = o0.Y(o1Var.A, o1Var.f29360y);
                if (iH == 0 || iH % iY != 0) {
                    t.i("AtomParsers", "Audio sample size mismatch. stsd sample size: " + iY + ", stsz sample size: " + iH);
                    iH = iY;
                }
            }
            this.f35752a = iH == 0 ? -1 : iH;
            this.f35753b = c0Var.H();
        }

        @Override // x2.b.c
        public int getFixedSampleSize() {
            return this.f35752a;
        }

        @Override // x2.b.c
        public int getSampleCount() {
            return this.f35753b;
        }

        @Override // x2.b.c
        public int readNextSampleSize() {
            int i10 = this.f35752a;
            return i10 == -1 ? this.f35754c.H() : i10;
        }
    }

    /* JADX INFO: compiled from: AtomParsers.java */
    static final class f implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f35755a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f35756b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35757c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f35758d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f35759e;

        public f(a.b bVar) {
            c0 c0Var = bVar.f35733b;
            this.f35755a = c0Var;
            c0Var.P(12);
            this.f35757c = c0Var.H() & 255;
            this.f35756b = c0Var.H();
        }

        @Override // x2.b.c
        public int getFixedSampleSize() {
            return -1;
        }

        @Override // x2.b.c
        public int getSampleCount() {
            return this.f35756b;
        }

        @Override // x2.b.c
        public int readNextSampleSize() {
            int i10 = this.f35757c;
            if (i10 == 8) {
                return this.f35755a.D();
            }
            if (i10 == 16) {
                return this.f35755a.J();
            }
            int i11 = this.f35758d;
            this.f35758d = i11 + 1;
            if (i11 % 2 != 0) {
                return this.f35759e & 15;
            }
            int iD = this.f35755a.D();
            this.f35759e = iD;
            return (iD & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }

    /* JADX INFO: compiled from: AtomParsers.java */
    private static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f35761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f35762c;

        public g(int i10, long j10, int i11) {
            this.f35760a = i10;
            this.f35761b = j10;
            this.f35762c = i11;
        }
    }

    public static List<r> A(a.C0730a c0730a, x xVar, long j10, @Nullable o2.m mVar, boolean z10, boolean z11, e5.g<o, o> gVar) throws j2 {
        o oVarApply;
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < c0730a.f35732d.size(); i10++) {
            a.C0730a c0730a2 = c0730a.f35732d.get(i10);
            if (c0730a2.f35729a == 1953653099 && (oVarApply = gVar.apply(z(c0730a2, (a.b) a4.a.e(c0730a.g(Atom.TYPE_mvhd)), j10, mVar, z10, z11))) != null) {
                arrayList.add(v(oVarApply, (a.C0730a) a4.a.e(((a.C0730a) a4.a.e(((a.C0730a) a4.a.e(c0730a2.f(Atom.TYPE_mdia))).f(Atom.TYPE_minf))).f(Atom.TYPE_stbl)), xVar));
            }
        }
        return arrayList;
    }

    public static Pair<c3.a, c3.a> B(a.b bVar) {
        c0 c0Var = bVar.f35733b;
        c0Var.P(8);
        c3.a aVarC = null;
        c3.a aVarU = null;
        while (c0Var.a() >= 8) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            if (iN2 == 1835365473) {
                c0Var.P(iE);
                aVarC = C(c0Var, iE + iN);
            } else if (iN2 == 1936553057) {
                c0Var.P(iE);
                aVarU = u(c0Var, iE + iN);
            }
            c0Var.P(iE + iN);
        }
        return Pair.create(aVarC, aVarU);
    }

    @Nullable
    private static c3.a C(c0 c0Var, int i10) {
        c0Var.Q(8);
        e(c0Var);
        while (c0Var.e() < i10) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            if (c0Var.n() == 1768715124) {
                c0Var.P(iE);
                return l(c0Var, iE + iN);
            }
            c0Var.P(iE + iN);
        }
        return null;
    }

    private static void D(c0 c0Var, int i10, int i11, int i12, int i13, int i14, @Nullable o2.m mVar, d dVar, int i15) throws j2 {
        o2.m mVar2;
        int i16;
        int i17;
        byte[] bArr;
        float f10;
        List<byte[]> list;
        String str;
        int i18 = i11;
        int i19 = i12;
        o2.m mVarB = mVar;
        d dVar2 = dVar;
        c0Var.P(i18 + 8 + 8);
        c0Var.Q(16);
        int iJ = c0Var.J();
        int iJ2 = c0Var.J();
        c0Var.Q(50);
        int iE = c0Var.e();
        int iIntValue = i10;
        if (iIntValue == 1701733238) {
            Pair<Integer, p> pairS = s(c0Var, i18, i19);
            if (pairS != null) {
                iIntValue = ((Integer) pairS.first).intValue();
                mVarB = mVarB == null ? null : mVarB.b(((p) pairS.second).f35870b);
                dVar2.f35748a[i15] = (p) pairS.second;
            }
            c0Var.P(iE);
        }
        String str2 = MimeTypes.VIDEO_H263;
        String str3 = iIntValue == 1831958048 ? MimeTypes.VIDEO_MPEG : iIntValue == 1211250227 ? MimeTypes.VIDEO_H263 : null;
        float fQ = 1.0f;
        byte[] bArrR = null;
        String str4 = null;
        List<byte[]> listR = null;
        int i20 = -1;
        int iB = -1;
        int i21 = -1;
        int iC = -1;
        ByteBuffer byteBuffer = null;
        C0731b c0731bI = null;
        boolean z10 = false;
        while (true) {
            if (iE - i18 >= i19) {
                mVar2 = mVarB;
                break;
            }
            c0Var.P(iE);
            int iE2 = c0Var.e();
            String str5 = str2;
            int iN = c0Var.n();
            if (iN == 0) {
                mVar2 = mVarB;
                if (c0Var.e() - i18 == i19) {
                    break;
                }
            } else {
                mVar2 = mVarB;
            }
            p2.o.a(iN > 0, "childAtomSize must be positive");
            int iN2 = c0Var.n();
            if (iN2 == 1635148611) {
                p2.o.a(str3 == null, null);
                c0Var.P(iE2 + 8);
                b4.a aVarB = b4.a.b(c0Var);
                listR = aVarB.f2071a;
                dVar2.f35750c = aVarB.f2072b;
                if (!z10) {
                    fQ = aVarB.f2075e;
                }
                str4 = aVarB.f2076f;
                str = "video/avc";
            } else if (iN2 == 1752589123) {
                p2.o.a(str3 == null, null);
                c0Var.P(iE2 + 8);
                b4.f fVarA = b4.f.a(c0Var);
                listR = fVarA.f2107a;
                dVar2.f35750c = fVarA.f2108b;
                if (!z10) {
                    fQ = fVarA.f2111e;
                }
                str4 = fVarA.f2112f;
                str = "video/hevc";
            } else {
                if (iN2 == 1685480259 || iN2 == 1685485123) {
                    i16 = iJ2;
                    i17 = iIntValue;
                    bArr = bArrR;
                    f10 = fQ;
                    list = listR;
                    b4.d dVarA = b4.d.a(c0Var);
                    if (dVarA != null) {
                        str4 = dVarA.f2092c;
                        str3 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                } else if (iN2 == 1987076931) {
                    p2.o.a(str3 == null, null);
                    str = iIntValue == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                } else if (iN2 == 1635135811) {
                    p2.o.a(str3 == null, null);
                    str = "video/av01";
                } else if (iN2 == 1668050025) {
                    ByteBuffer byteBufferA = byteBuffer == null ? a() : byteBuffer;
                    byteBufferA.position(21);
                    byteBufferA.putShort(c0Var.z());
                    byteBufferA.putShort(c0Var.z());
                    byteBuffer = byteBufferA;
                    i16 = iJ2;
                    i17 = iIntValue;
                    iE += iN;
                    i18 = i11;
                    i19 = i12;
                    dVar2 = dVar;
                    str2 = str5;
                    mVarB = mVar2;
                    iIntValue = i17;
                    iJ2 = i16;
                } else if (iN2 == 1835295606) {
                    ByteBuffer byteBufferA2 = byteBuffer == null ? a() : byteBuffer;
                    short sZ = c0Var.z();
                    short sZ2 = c0Var.z();
                    short sZ3 = c0Var.z();
                    i17 = iIntValue;
                    short sZ4 = c0Var.z();
                    short sZ5 = c0Var.z();
                    List<byte[]> list2 = listR;
                    short sZ6 = c0Var.z();
                    byte[] bArr2 = bArrR;
                    short sZ7 = c0Var.z();
                    float f11 = fQ;
                    short sZ8 = c0Var.z();
                    long jF = c0Var.F();
                    long jF2 = c0Var.F();
                    i16 = iJ2;
                    byteBufferA2.position(1);
                    byteBufferA2.putShort(sZ5);
                    byteBufferA2.putShort(sZ6);
                    byteBufferA2.putShort(sZ);
                    byteBufferA2.putShort(sZ2);
                    byteBufferA2.putShort(sZ3);
                    byteBufferA2.putShort(sZ4);
                    byteBufferA2.putShort(sZ7);
                    byteBufferA2.putShort(sZ8);
                    byteBufferA2.putShort((short) (jF / 10000));
                    byteBufferA2.putShort((short) (jF2 / 10000));
                    byteBuffer = byteBufferA2;
                    listR = list2;
                    bArrR = bArr2;
                    fQ = f11;
                    iE += iN;
                    i18 = i11;
                    i19 = i12;
                    dVar2 = dVar;
                    str2 = str5;
                    mVarB = mVar2;
                    iIntValue = i17;
                    iJ2 = i16;
                } else {
                    i16 = iJ2;
                    i17 = iIntValue;
                    bArr = bArrR;
                    f10 = fQ;
                    list = listR;
                    if (iN2 == 1681012275) {
                        p2.o.a(str3 == null, null);
                        str3 = str5;
                    } else if (iN2 == 1702061171) {
                        p2.o.a(str3 == null, null);
                        c0731bI = i(c0Var, iE2);
                        String str6 = c0731bI.f35744a;
                        byte[] bArr3 = c0731bI.f35745b;
                        listR = bArr3 != null ? y.r(bArr3) : list;
                        str3 = str6;
                        bArrR = bArr;
                        fQ = f10;
                        iE += iN;
                        i18 = i11;
                        i19 = i12;
                        dVar2 = dVar;
                        str2 = str5;
                        mVarB = mVar2;
                        iIntValue = i17;
                        iJ2 = i16;
                    } else if (iN2 == 1885434736) {
                        fQ = q(c0Var, iE2);
                        listR = list;
                        bArrR = bArr;
                        z10 = true;
                        iE += iN;
                        i18 = i11;
                        i19 = i12;
                        dVar2 = dVar;
                        str2 = str5;
                        mVarB = mVar2;
                        iIntValue = i17;
                        iJ2 = i16;
                    } else if (iN2 == 1937126244) {
                        bArrR = r(c0Var, iE2, iN);
                        listR = list;
                        fQ = f10;
                        iE += iN;
                        i18 = i11;
                        i19 = i12;
                        dVar2 = dVar;
                        str2 = str5;
                        mVarB = mVar2;
                        iIntValue = i17;
                        iJ2 = i16;
                    } else if (iN2 == 1936995172) {
                        int iD = c0Var.D();
                        c0Var.Q(3);
                        if (iD == 0) {
                            int iD2 = c0Var.D();
                            if (iD2 == 0) {
                                i20 = 0;
                            } else if (iD2 == 1) {
                                i20 = 1;
                            } else if (iD2 == 2) {
                                i20 = 2;
                            } else if (iD2 == 3) {
                                i20 = 3;
                            }
                        }
                    } else if (iN2 == 1668246642) {
                        int iN3 = c0Var.n();
                        if (iN3 == 1852009592 || iN3 == 1852009571) {
                            int iJ3 = c0Var.J();
                            int iJ4 = c0Var.J();
                            c0Var.Q(2);
                            boolean z11 = iN == 19 && (c0Var.D() & 128) != 0;
                            iB = b4.c.b(iJ3);
                            i21 = z11 ? 1 : 2;
                            iC = b4.c.c(iJ4);
                        } else {
                            t.i("AtomParsers", "Unsupported color type: " + x2.a.a(iN3));
                        }
                    }
                }
                listR = list;
                bArrR = bArr;
                fQ = f10;
                iE += iN;
                i18 = i11;
                i19 = i12;
                dVar2 = dVar;
                str2 = str5;
                mVarB = mVar2;
                iIntValue = i17;
                iJ2 = i16;
            }
            str3 = str;
            i16 = iJ2;
            i17 = iIntValue;
            iE += iN;
            i18 = i11;
            i19 = i12;
            dVar2 = dVar;
            str2 = str5;
            mVarB = mVar2;
            iIntValue = i17;
            iJ2 = i16;
        }
        int i22 = iJ2;
        byte[] bArr4 = bArrR;
        float f12 = fQ;
        List<byte[]> list3 = listR;
        if (str3 == null) {
            return;
        }
        o1.b bVarM = new o1.b().R(i13).e0(str3).I(str4).j0(iJ).Q(i22).a0(f12).d0(i14).b0(bArr4).h0(i20).T(list3).M(mVar2);
        int i23 = iB;
        int i24 = i21;
        int i25 = iC;
        if (i23 != -1 || i24 != -1 || i25 != -1 || byteBuffer != null) {
            bVarM.J(new b4.c(i23, i24, i25, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (c0731bI != null) {
            bVarM.G(g5.e.j(c0731bI.f35746c)).Z(g5.e.j(c0731bI.f35747d));
        }
        dVar.f35749b = bVarM.E();
    }

    private static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static boolean b(long[] jArr, long j10, long j11, long j12) {
        int length = jArr.length - 1;
        return jArr[0] <= j11 && j11 < jArr[o0.p(4, 0, length)] && jArr[o0.p(jArr.length - 4, 0, length)] < j12 && j12 <= j10;
    }

    private static int c(c0 c0Var, int i10, int i11, int i12) throws j2 {
        int iE = c0Var.e();
        p2.o.a(iE >= i11, null);
        while (iE - i11 < i12) {
            c0Var.P(iE);
            int iN = c0Var.n();
            p2.o.a(iN > 0, "childAtomSize must be positive");
            if (c0Var.n() == i10) {
                return iE;
            }
            iE += iN;
        }
        return -1;
    }

    private static int d(int i10) {
        if (i10 == 1936684398) {
            return 1;
        }
        if (i10 == 1986618469) {
            return 2;
        }
        if (i10 == 1952807028 || i10 == 1935832172 || i10 == 1937072756 || i10 == 1668047728) {
            return 3;
        }
        return i10 == 1835365473 ? 5 : -1;
    }

    public static void e(c0 c0Var) {
        int iE = c0Var.e();
        c0Var.Q(4);
        if (c0Var.n() != 1751411826) {
            iE += 4;
        }
        c0Var.P(iE);
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0167  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void f(a4.c0 r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, @androidx.annotation.Nullable o2.m r29, x2.b.d r30, int r31) throws k2.j2 {
        /*
            Method dump skipped, instruction units count: 864
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.b.f(a4.c0, int, int, int, int, java.lang.String, boolean, o2.m, x2.b$d, int):void");
    }

    @Nullable
    static Pair<Integer, p> g(c0 c0Var, int i10, int i11) throws j2 {
        int i12 = i10 + 8;
        int i13 = -1;
        int i14 = 0;
        String strA = null;
        Integer numValueOf = null;
        while (i12 - i10 < i11) {
            c0Var.P(i12);
            int iN = c0Var.n();
            int iN2 = c0Var.n();
            if (iN2 == 1718775137) {
                numValueOf = Integer.valueOf(c0Var.n());
            } else if (iN2 == 1935894637) {
                c0Var.Q(4);
                strA = c0Var.A(4);
            } else if (iN2 == 1935894633) {
                i13 = i12;
                i14 = iN;
            }
            i12 += iN;
        }
        if (!C.CENC_TYPE_cenc.equals(strA) && !C.CENC_TYPE_cbc1.equals(strA) && !C.CENC_TYPE_cens.equals(strA) && !C.CENC_TYPE_cbcs.equals(strA)) {
            return null;
        }
        p2.o.a(numValueOf != null, "frma atom is mandatory");
        p2.o.a(i13 != -1, "schi atom is mandatory");
        p pVarT = t(c0Var, i13, i14, strA);
        p2.o.a(pVarT != null, "tenc atom is mandatory");
        return Pair.create(numValueOf, (p) o0.j(pVarT));
    }

    @Nullable
    private static Pair<long[], long[]> h(a.C0730a c0730a) {
        a.b bVarG = c0730a.g(Atom.TYPE_elst);
        if (bVarG == null) {
            return null;
        }
        c0 c0Var = bVarG.f35733b;
        c0Var.P(8);
        int iC = x2.a.c(c0Var.n());
        int iH = c0Var.H();
        long[] jArr = new long[iH];
        long[] jArr2 = new long[iH];
        for (int i10 = 0; i10 < iH; i10++) {
            jArr[i10] = iC == 1 ? c0Var.I() : c0Var.F();
            jArr2[i10] = iC == 1 ? c0Var.w() : c0Var.n();
            if (c0Var.z() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            c0Var.Q(2);
        }
        return Pair.create(jArr, jArr2);
    }

    private static C0731b i(c0 c0Var, int i10) {
        c0Var.P(i10 + 8 + 4);
        c0Var.Q(1);
        j(c0Var);
        c0Var.Q(2);
        int iD = c0Var.D();
        if ((iD & 128) != 0) {
            c0Var.Q(2);
        }
        if ((iD & 64) != 0) {
            c0Var.Q(c0Var.D());
        }
        if ((iD & 32) != 0) {
            c0Var.Q(2);
        }
        c0Var.Q(1);
        j(c0Var);
        String strF = a4.x.f(c0Var.D());
        if (MimeTypes.AUDIO_MPEG.equals(strF) || MimeTypes.AUDIO_DTS.equals(strF) || MimeTypes.AUDIO_DTS_HD.equals(strF)) {
            return new C0731b(strF, null, -1L, -1L);
        }
        c0Var.Q(4);
        long jF = c0Var.F();
        long jF2 = c0Var.F();
        c0Var.Q(1);
        int iJ = j(c0Var);
        byte[] bArr = new byte[iJ];
        c0Var.j(bArr, 0, iJ);
        return new C0731b(strF, bArr, jF2 > 0 ? jF2 : -1L, jF > 0 ? jF : -1L);
    }

    private static int j(c0 c0Var) {
        int iD = c0Var.D();
        int i10 = iD & 127;
        while ((iD & 128) == 128) {
            iD = c0Var.D();
            i10 = (i10 << 7) | (iD & 127);
        }
        return i10;
    }

    private static int k(c0 c0Var) {
        c0Var.P(16);
        return c0Var.n();
    }

    @Nullable
    private static c3.a l(c0 c0Var, int i10) {
        c0Var.Q(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var.e() < i10) {
            a.b bVarC = h.c(c0Var);
            if (bVarC != null) {
                arrayList.add(bVarC);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c3.a(arrayList);
    }

    private static Pair<Long, String> m(c0 c0Var) {
        c0Var.P(8);
        int iC = x2.a.c(c0Var.n());
        c0Var.Q(iC == 0 ? 8 : 16);
        long jF = c0Var.F();
        c0Var.Q(iC == 0 ? 4 : 8);
        int iJ = c0Var.J();
        return Pair.create(Long.valueOf(jF), "" + ((char) (((iJ >> 10) & 31) + 96)) + ((char) (((iJ >> 5) & 31) + 96)) + ((char) ((iJ & 31) + 96)));
    }

    @Nullable
    public static c3.a n(a.C0730a c0730a) {
        a.b bVarG = c0730a.g(Atom.TYPE_hdlr);
        a.b bVarG2 = c0730a.g(Atom.TYPE_keys);
        a.b bVarG3 = c0730a.g(Atom.TYPE_ilst);
        if (bVarG == null || bVarG2 == null || bVarG3 == null || k(bVarG.f35733b) != 1835299937) {
            return null;
        }
        c0 c0Var = bVarG2.f35733b;
        c0Var.P(12);
        int iN = c0Var.n();
        String[] strArr = new String[iN];
        for (int i10 = 0; i10 < iN; i10++) {
            int iN2 = c0Var.n();
            c0Var.Q(4);
            strArr[i10] = c0Var.A(iN2 - 8);
        }
        c0 c0Var2 = bVarG3.f35733b;
        c0Var2.P(8);
        ArrayList arrayList = new ArrayList();
        while (c0Var2.a() > 8) {
            int iE = c0Var2.e();
            int iN3 = c0Var2.n();
            int iN4 = c0Var2.n() - 1;
            if (iN4 < 0 || iN4 >= iN) {
                t.i("AtomParsers", "Skipped metadata with unknown key index: " + iN4);
            } else {
                i3.a aVarF = h.f(c0Var2, iE + iN3, strArr[iN4]);
                if (aVarF != null) {
                    arrayList.add(aVarF);
                }
            }
            c0Var2.P(iE + iN3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new c3.a(arrayList);
    }

    private static void o(c0 c0Var, int i10, int i11, int i12, d dVar) {
        c0Var.P(i11 + 8 + 8);
        if (i10 == 1835365492) {
            c0Var.x();
            String strX = c0Var.x();
            if (strX != null) {
                dVar.f35749b = new o1.b().R(i12).e0(strX).E();
            }
        }
    }

    private static long p(c0 c0Var) {
        c0Var.P(8);
        c0Var.Q(x2.a.c(c0Var.n()) != 0 ? 16 : 8);
        return c0Var.F();
    }

    private static float q(c0 c0Var, int i10) {
        c0Var.P(i10 + 8);
        return c0Var.H() / c0Var.H();
    }

    @Nullable
    private static byte[] r(c0 c0Var, int i10, int i11) {
        int i12 = i10 + 8;
        while (i12 - i10 < i11) {
            c0Var.P(i12);
            int iN = c0Var.n();
            if (c0Var.n() == 1886547818) {
                return Arrays.copyOfRange(c0Var.d(), i12, iN + i12);
            }
            i12 += iN;
        }
        return null;
    }

    @Nullable
    private static Pair<Integer, p> s(c0 c0Var, int i10, int i11) throws j2 {
        Pair<Integer, p> pairG;
        int iE = c0Var.e();
        while (iE - i10 < i11) {
            c0Var.P(iE);
            int iN = c0Var.n();
            p2.o.a(iN > 0, "childAtomSize must be positive");
            if (c0Var.n() == 1936289382 && (pairG = g(c0Var, iE, iN)) != null) {
                return pairG;
            }
            iE += iN;
        }
        return null;
    }

    @Nullable
    private static p t(c0 c0Var, int i10, int i11, String str) {
        int i12;
        int i13;
        int i14 = i10 + 8;
        while (true) {
            byte[] bArr = null;
            if (i14 - i10 >= i11) {
                return null;
            }
            c0Var.P(i14);
            int iN = c0Var.n();
            if (c0Var.n() == 1952804451) {
                int iC = x2.a.c(c0Var.n());
                c0Var.Q(1);
                if (iC == 0) {
                    c0Var.Q(1);
                    i13 = 0;
                    i12 = 0;
                } else {
                    int iD = c0Var.D();
                    i12 = iD & 15;
                    i13 = (iD & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z10 = c0Var.D() == 1;
                int iD2 = c0Var.D();
                byte[] bArr2 = new byte[16];
                c0Var.j(bArr2, 0, 16);
                if (z10 && iD2 == 0) {
                    int iD3 = c0Var.D();
                    bArr = new byte[iD3];
                    c0Var.j(bArr, 0, iD3);
                }
                return new p(z10, str, iD2, bArr2, i13, i12, bArr);
            }
            i14 += iN;
        }
    }

    @Nullable
    private static c3.a u(c0 c0Var, int i10) {
        c0Var.Q(12);
        while (c0Var.e() < i10) {
            int iE = c0Var.e();
            int iN = c0Var.n();
            if (c0Var.n() == 1935766900) {
                if (iN < 14) {
                    return null;
                }
                c0Var.Q(5);
                int iD = c0Var.D();
                if (iD != 12 && iD != 13) {
                    return null;
                }
                float f10 = iD == 12 ? 240.0f : 120.0f;
                c0Var.Q(1);
                return new c3.a(new i3.e(f10, c0Var.D()));
            }
            c0Var.P(iE + iN);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0431  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0442  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0448  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x044b  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0426 A[EDGE_INSN: B:210:0x0426->B:169:0x0426 BREAK  A[LOOP:2: B:152:0x03c5->B:168:0x041f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static x2.r v(x2.o r38, x2.a.C0730a r39, p2.x r40) throws k2.j2 {
        /*
            Method dump skipped, instruction units count: 1308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x2.b.v(x2.o, x2.a$a, p2.x):x2.r");
    }

    private static d w(c0 c0Var, int i10, int i11, String str, @Nullable o2.m mVar, boolean z10) throws j2 {
        int i12;
        c0Var.P(12);
        int iN = c0Var.n();
        d dVar = new d(iN);
        for (int i13 = 0; i13 < iN; i13++) {
            int iE = c0Var.e();
            int iN2 = c0Var.n();
            p2.o.a(iN2 > 0, "childAtomSize must be positive");
            int iN3 = c0Var.n();
            if (iN3 == 1635148593 || iN3 == 1635148595 || iN3 == 1701733238 || iN3 == 1831958048 || iN3 == 1836070006 || iN3 == 1752589105 || iN3 == 1751479857 || iN3 == 1932670515 || iN3 == 1211250227 || iN3 == 1987063864 || iN3 == 1987063865 || iN3 == 1635135537 || iN3 == 1685479798 || iN3 == 1685479729 || iN3 == 1685481573 || iN3 == 1685481521) {
                i12 = iE;
                D(c0Var, iN3, i12, iN2, i10, i11, mVar, dVar, i13);
            } else if (iN3 == 1836069985 || iN3 == 1701733217 || iN3 == 1633889587 || iN3 == 1700998451 || iN3 == 1633889588 || iN3 == 1835823201 || iN3 == 1685353315 || iN3 == 1685353317 || iN3 == 1685353320 || iN3 == 1685353324 || iN3 == 1685353336 || iN3 == 1935764850 || iN3 == 1935767394 || iN3 == 1819304813 || iN3 == 1936684916 || iN3 == 1953984371 || iN3 == 778924082 || iN3 == 778924083 || iN3 == 1835557169 || iN3 == 1835560241 || iN3 == 1634492771 || iN3 == 1634492791 || iN3 == 1970037111 || iN3 == 1332770163 || iN3 == 1716281667) {
                i12 = iE;
                f(c0Var, iN3, iE, iN2, i10, str, z10, mVar, dVar, i13);
            } else {
                if (iN3 == 1414810956 || iN3 == 1954034535 || iN3 == 2004251764 || iN3 == 1937010800 || iN3 == 1664495672) {
                    x(c0Var, iN3, iE, iN2, i10, str, dVar);
                } else if (iN3 == 1835365492) {
                    o(c0Var, iN3, iE, i10, dVar);
                } else if (iN3 == 1667329389) {
                    dVar.f35749b = new o1.b().R(i10).e0(MimeTypes.APPLICATION_CAMERA_MOTION).E();
                }
                i12 = iE;
            }
            c0Var.P(i12 + iN2);
        }
        return dVar;
    }

    private static void x(c0 c0Var, int i10, int i11, int i12, int i13, String str, d dVar) {
        c0Var.P(i11 + 8 + 8);
        String str2 = MimeTypes.APPLICATION_TTML;
        y yVarR = null;
        long j10 = Long.MAX_VALUE;
        if (i10 != 1414810956) {
            if (i10 == 1954034535) {
                int i14 = (i12 - 8) - 8;
                byte[] bArr = new byte[i14];
                c0Var.j(bArr, 0, i14);
                yVarR = y.r(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i10 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i10 == 1937010800) {
                j10 = 0;
            } else {
                if (i10 != 1664495672) {
                    throw new IllegalStateException();
                }
                dVar.f35751d = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            }
        }
        dVar.f35749b = new o1.b().R(i13).e0(str2).V(str).i0(j10).T(yVarR).E();
    }

    private static g y(c0 c0Var) {
        boolean z10;
        c0Var.P(8);
        int iC = x2.a.c(c0Var.n());
        c0Var.Q(iC == 0 ? 8 : 16);
        int iN = c0Var.n();
        c0Var.Q(4);
        int iE = c0Var.e();
        int i10 = iC == 0 ? 4 : 8;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            if (i12 >= i10) {
                z10 = true;
                break;
            }
            if (c0Var.d()[iE + i12] != -1) {
                z10 = false;
                break;
            }
            i12++;
        }
        long j10 = C.TIME_UNSET;
        if (z10) {
            c0Var.Q(i10);
        } else {
            long jF = iC == 0 ? c0Var.F() : c0Var.I();
            if (jF != 0) {
                j10 = jF;
            }
        }
        c0Var.Q(16);
        int iN2 = c0Var.n();
        int iN3 = c0Var.n();
        c0Var.Q(4);
        int iN4 = c0Var.n();
        int iN5 = c0Var.n();
        if (iN2 == 0 && iN3 == 65536 && iN4 == -65536 && iN5 == 0) {
            i11 = 90;
        } else if (iN2 == 0 && iN3 == -65536 && iN4 == 65536 && iN5 == 0) {
            i11 = 270;
        } else if (iN2 == -65536 && iN3 == 0 && iN4 == 0 && iN5 == -65536) {
            i11 = 180;
        }
        return new g(iN, j10, i11);
    }

    @Nullable
    private static o z(a.C0730a c0730a, a.b bVar, long j10, @Nullable o2.m mVar, boolean z10, boolean z11) throws j2 {
        a.b bVar2;
        long j11;
        long[] jArr;
        long[] jArr2;
        a.C0730a c0730aF;
        Pair<long[], long[]> pairH;
        a.C0730a c0730a2 = (a.C0730a) a4.a.e(c0730a.f(Atom.TYPE_mdia));
        int iD = d(k(((a.b) a4.a.e(c0730a2.g(Atom.TYPE_hdlr))).f35733b));
        if (iD == -1) {
            return null;
        }
        g gVarY = y(((a.b) a4.a.e(c0730a.g(Atom.TYPE_tkhd))).f35733b);
        long jF0 = C.TIME_UNSET;
        if (j10 == C.TIME_UNSET) {
            bVar2 = bVar;
            j11 = gVarY.f35761b;
        } else {
            bVar2 = bVar;
            j11 = j10;
        }
        long jP = p(bVar2.f35733b);
        if (j11 != C.TIME_UNSET) {
            jF0 = o0.F0(j11, 1000000L, jP);
        }
        long j12 = jF0;
        a.C0730a c0730a3 = (a.C0730a) a4.a.e(((a.C0730a) a4.a.e(c0730a2.f(Atom.TYPE_minf))).f(Atom.TYPE_stbl));
        Pair<Long, String> pairM = m(((a.b) a4.a.e(c0730a2.g(Atom.TYPE_mdhd))).f35733b);
        d dVarW = w(((a.b) a4.a.e(c0730a3.g(Atom.TYPE_stsd))).f35733b, gVarY.f35760a, gVarY.f35762c, (String) pairM.second, mVar, z11);
        if (z10 || (c0730aF = c0730a.f(Atom.TYPE_edts)) == null || (pairH = h(c0730aF)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) pairH.first;
            jArr2 = (long[]) pairH.second;
            jArr = jArr3;
        }
        if (dVarW.f35749b == null) {
            return null;
        }
        return new o(gVarY.f35760a, iD, ((Long) pairM.first).longValue(), jP, j12, dVarW.f35749b, dVarW.f35751d, dVarW.f35748a, dVarW.f35750c, jArr, jArr2);
    }
}
