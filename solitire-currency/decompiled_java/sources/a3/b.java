package a3;

import a4.c0;
import a4.o0;
import a4.t;
import android.net.Uri;
import android.util.Pair;
import androidx.media3.common.MimeTypes;
import com.ironsource.c3;
import java.io.IOException;
import java.util.Map;
import k2.j2;
import k2.o1;
import p2.a0;
import p2.e0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;

/* JADX INFO: compiled from: WavExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements l {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final r f88h = new r() { // from class: a3.a
        @Override // p2.r
        public final l[] createExtractors() {
            return b.f();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private n f89a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private e0 f90b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private InterfaceC0003b f93e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f91c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f92d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f94f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f95g = -1;

    /* JADX INFO: compiled from: WavExtractor.java */
    private static final class a implements InterfaceC0003b {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private static final int[] f96m = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private static final int[] f97n = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, 307, 337, 371, c3.a.b.f11499h, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f98a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e0 f99b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a3.c f100c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f101d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final byte[] f102e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final c0 f103f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final int f104g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final o1 f105h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f106i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private long f107j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private int f108k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private long f109l;

        public a(n nVar, e0 e0Var, a3.c cVar) throws j2 {
            this.f98a = nVar;
            this.f99b = e0Var;
            this.f100c = cVar;
            int iMax = Math.max(1, cVar.f120c / 10);
            this.f104g = iMax;
            c0 c0Var = new c0(cVar.f124g);
            c0Var.v();
            int iV = c0Var.v();
            this.f101d = iV;
            int i10 = cVar.f119b;
            int i11 = (((cVar.f122e - (i10 * 4)) * 8) / (cVar.f123f * i10)) + 1;
            if (iV == i11) {
                int iL = o0.l(iMax, iV);
                this.f102e = new byte[cVar.f122e * iL];
                this.f103f = new c0(iL * f(iV, i10));
                int i12 = ((cVar.f120c * cVar.f122e) * 8) / iV;
                this.f105h = new o1.b().e0(MimeTypes.AUDIO_RAW).G(i12).Z(i12).W(f(iMax, i10)).H(cVar.f119b).f0(cVar.f120c).Y(2).E();
                return;
            }
            throw j2.a("Expected frames per block: " + i11 + "; got: " + iV, null);
        }

        private void b(byte[] bArr, int i10, c0 c0Var) {
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < this.f100c.f119b; i12++) {
                    c(bArr, i11, i12, c0Var.d());
                }
            }
            int iE = e(this.f101d * i10);
            c0Var.P(0);
            c0Var.O(iE);
        }

        private void c(byte[] bArr, int i10, int i11, byte[] bArr2) {
            a3.c cVar = this.f100c;
            int i12 = cVar.f122e;
            int i13 = cVar.f119b;
            int i14 = (i10 * i12) + (i11 * 4);
            int i15 = (i13 * 4) + i14;
            int i16 = (i12 / i13) - 4;
            int iP = (short) (((bArr[i14 + 1] & 255) << 8) | (bArr[i14] & 255));
            int iMin = Math.min(bArr[i14 + 2] & 255, 88);
            int i17 = f97n[iMin];
            int i18 = ((i10 * this.f101d * i13) + i11) * 2;
            bArr2[i18] = (byte) (iP & 255);
            bArr2[i18 + 1] = (byte) (iP >> 8);
            for (int i19 = 0; i19 < i16 * 2; i19++) {
                int i20 = bArr[((i19 / 8) * i13 * 4) + i15 + ((i19 / 2) % 4)] & 255;
                int i21 = i19 % 2 == 0 ? i20 & 15 : i20 >> 4;
                int i22 = ((((i21 & 7) * 2) + 1) * i17) >> 3;
                if ((i21 & 8) != 0) {
                    i22 = -i22;
                }
                iP = o0.p(iP + i22, -32768, 32767);
                i18 += i13 * 2;
                bArr2[i18] = (byte) (iP & 255);
                bArr2[i18 + 1] = (byte) (iP >> 8);
                int i23 = iMin + f96m[i21];
                int[] iArr = f97n;
                iMin = o0.p(i23, 0, iArr.length - 1);
                i17 = iArr[iMin];
            }
        }

        private int d(int i10) {
            return i10 / (this.f100c.f119b * 2);
        }

        private int e(int i10) {
            return f(i10, this.f100c.f119b);
        }

        private static int f(int i10, int i11) {
            return i10 * 2 * i11;
        }

        private void g(int i10) {
            long jF0 = this.f107j + o0.F0(this.f109l, 1000000L, this.f100c.f120c);
            int iE = e(i10);
            this.f99b.a(jF0, 1, iE, this.f108k - iE, null);
            this.f109l += (long) i10;
            this.f108k -= iE;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0020  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0035 -> B:4:0x001b). Please report as a decompilation issue!!! */
        @Override // a3.b.InterfaceC0003b
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean a(p2.m r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.f104g
                int r1 = r6.f108k
                int r1 = r6.d(r1)
                int r0 = r0 - r1
                int r1 = r6.f101d
                int r0 = a4.o0.l(r0, r1)
                a3.c r1 = r6.f100c
                int r1 = r1.f122e
                int r0 = r0 * r1
                r1 = 0
                int r1 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                r2 = 1
                if (r1 != 0) goto L1d
            L1b:
                r1 = r2
                goto L1e
            L1d:
                r1 = 0
            L1e:
                if (r1 != 0) goto L3e
                int r3 = r6.f106i
                if (r3 >= r0) goto L3e
                int r3 = r0 - r3
                long r3 = (long) r3
                long r3 = java.lang.Math.min(r3, r8)
                int r3 = (int) r3
                byte[] r4 = r6.f102e
                int r5 = r6.f106i
                int r3 = r7.read(r4, r5, r3)
                r4 = -1
                if (r3 != r4) goto L38
                goto L1b
            L38:
                int r4 = r6.f106i
                int r4 = r4 + r3
                r6.f106i = r4
                goto L1e
            L3e:
                int r7 = r6.f106i
                a3.c r8 = r6.f100c
                int r8 = r8.f122e
                int r7 = r7 / r8
                if (r7 <= 0) goto L75
                byte[] r8 = r6.f102e
                a4.c0 r9 = r6.f103f
                r6.b(r8, r7, r9)
                int r8 = r6.f106i
                a3.c r9 = r6.f100c
                int r9 = r9.f122e
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.f106i = r8
                a4.c0 r7 = r6.f103f
                int r7 = r7.f()
                p2.e0 r8 = r6.f99b
                a4.c0 r9 = r6.f103f
                r8.e(r9, r7)
                int r8 = r6.f108k
                int r8 = r8 + r7
                r6.f108k = r8
                int r7 = r6.d(r8)
                int r8 = r6.f104g
                if (r7 < r8) goto L75
                r6.g(r8)
            L75:
                if (r1 == 0) goto L82
                int r7 = r6.f108k
                int r7 = r6.d(r7)
                if (r7 <= 0) goto L82
                r6.g(r7)
            L82:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: a3.b.a.a(p2.m, long):boolean");
        }

        @Override // a3.b.InterfaceC0003b
        public void init(int i10, long j10) {
            this.f98a.h(new e(this.f100c, this.f101d, i10, j10));
            this.f99b.f(this.f105h);
        }

        @Override // a3.b.InterfaceC0003b
        public void reset(long j10) {
            this.f106i = 0;
            this.f107j = j10;
            this.f108k = 0;
            this.f109l = 0L;
        }
    }

    /* JADX INFO: renamed from: a3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: WavExtractor.java */
    private interface InterfaceC0003b {
        boolean a(m mVar, long j10) throws IOException;

        void init(int i10, long j10) throws j2;

        void reset(long j10);
    }

    /* JADX INFO: compiled from: WavExtractor.java */
    private static final class c implements InterfaceC0003b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final n f110a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e0 f111b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final a3.c f112c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final o1 f113d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f114e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f115f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f116g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f117h;

        public c(n nVar, e0 e0Var, a3.c cVar, String str, int i10) throws j2 {
            this.f110a = nVar;
            this.f111b = e0Var;
            this.f112c = cVar;
            int i11 = (cVar.f119b * cVar.f123f) / 8;
            if (cVar.f122e == i11) {
                int i12 = cVar.f120c;
                int i13 = i12 * i11 * 8;
                int iMax = Math.max(i11, (i12 * i11) / 10);
                this.f114e = iMax;
                this.f113d = new o1.b().e0(str).G(i13).Z(i13).W(iMax).H(cVar.f119b).f0(cVar.f120c).Y(i10).E();
                return;
            }
            throw j2.a("Expected block size: " + i11 + "; got: " + cVar.f122e, null);
        }

        @Override // a3.b.InterfaceC0003b
        public boolean a(m mVar, long j10) throws IOException {
            int i10;
            int i11;
            long j11 = j10;
            while (j11 > 0 && (i10 = this.f116g) < (i11 = this.f114e)) {
                int iC = this.f111b.c(mVar, (int) Math.min(i11 - i10, j11), true);
                if (iC == -1) {
                    j11 = 0;
                } else {
                    this.f116g += iC;
                    j11 -= (long) iC;
                }
            }
            int i12 = this.f112c.f122e;
            int i13 = this.f116g / i12;
            if (i13 > 0) {
                long jF0 = this.f115f + o0.F0(this.f117h, 1000000L, r1.f120c);
                int i14 = i13 * i12;
                int i15 = this.f116g - i14;
                this.f111b.a(jF0, 1, i14, i15, null);
                this.f117h += (long) i13;
                this.f116g = i15;
            }
            return j11 <= 0;
        }

        @Override // a3.b.InterfaceC0003b
        public void init(int i10, long j10) {
            this.f110a.h(new e(this.f112c, 1, i10, j10));
            this.f111b.f(this.f113d);
        }

        @Override // a3.b.InterfaceC0003b
        public void reset(long j10) {
            this.f115f = j10;
            this.f116g = 0;
            this.f117h = 0L;
        }
    }

    private void e() {
        a4.a.i(this.f90b);
        o0.j(this.f89a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] f() {
        return new l[]{new b()};
    }

    private void g(m mVar) throws IOException {
        a4.a.g(mVar.getPosition() == 0);
        int i10 = this.f94f;
        if (i10 != -1) {
            mVar.skipFully(i10);
            this.f91c = 4;
        } else {
            if (!d.a(mVar)) {
                throw j2.a("Unsupported or unrecognized wav file type.", null);
            }
            mVar.skipFully((int) (mVar.getPeekPosition() - mVar.getPosition()));
            this.f91c = 1;
        }
    }

    private void h(m mVar) throws IOException {
        a3.c cVarB = d.b(mVar);
        int i10 = cVarB.f118a;
        if (i10 == 17) {
            this.f93e = new a(this.f89a, this.f90b, cVarB);
        } else if (i10 == 6) {
            this.f93e = new c(this.f89a, this.f90b, cVarB, MimeTypes.AUDIO_ALAW, -1);
        } else if (i10 == 7) {
            this.f93e = new c(this.f89a, this.f90b, cVarB, MimeTypes.AUDIO_MLAW, -1);
        } else {
            int iA = m2.o0.a(i10, cVarB.f123f);
            if (iA == 0) {
                throw j2.c("Unsupported WAV format type: " + cVarB.f118a);
            }
            this.f93e = new c(this.f89a, this.f90b, cVarB, MimeTypes.AUDIO_RAW, iA);
        }
        this.f91c = 3;
    }

    private void i(m mVar) throws IOException {
        this.f92d = d.c(mVar);
        this.f91c = 2;
    }

    private int j(m mVar) throws IOException {
        a4.a.g(this.f95g != -1);
        return ((InterfaceC0003b) a4.a.e(this.f93e)).a(mVar, this.f95g - mVar.getPosition()) ? -1 : 0;
    }

    private void k(m mVar) throws IOException {
        Pair<Long, Long> pairE = d.e(mVar);
        this.f94f = ((Long) pairE.first).intValue();
        long jLongValue = ((Long) pairE.second).longValue();
        long j10 = this.f92d;
        if (j10 != -1 && jLongValue == 4294967295L) {
            jLongValue = j10;
        }
        this.f95g = ((long) this.f94f) + jLongValue;
        long length = mVar.getLength();
        if (length != -1 && this.f95g > length) {
            t.i("WavExtractor", "Data exceeds input length: " + this.f95g + ", " + length);
            this.f95g = length;
        }
        ((InterfaceC0003b) a4.a.e(this.f93e)).init(this.f94f, this.f95g);
        this.f91c = 4;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        e();
        int i10 = this.f91c;
        if (i10 == 0) {
            g(mVar);
            return 0;
        }
        if (i10 == 1) {
            i(mVar);
            return 0;
        }
        if (i10 == 2) {
            h(mVar);
            return 0;
        }
        if (i10 == 3) {
            k(mVar);
            return 0;
        }
        if (i10 == 4) {
            return j(mVar);
        }
        throw new IllegalStateException();
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f89a = nVar;
        this.f90b = nVar.track(0, 1);
        nVar.endTracks();
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        return d.a(mVar);
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        this.f91c = j10 == 0 ? 0 : 4;
        InterfaceC0003b interfaceC0003b = this.f93e;
        if (interfaceC0003b != null) {
            interfaceC0003b.reset(j11);
        }
    }

    @Override // p2.l
    public void release() {
    }
}
