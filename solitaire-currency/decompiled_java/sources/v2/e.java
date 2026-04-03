package v2;

import a4.c0;
import a4.o0;
import a4.t;
import a4.u;
import a4.y;
import android.net.Uri;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import k2.i;
import k2.j2;
import o2.m;
import p2.a0;
import p2.b0;
import p2.e0;
import p2.f0;
import p2.l;
import p2.m;
import p2.n;
import p2.q;
import p2.r;

/* JADX INFO: compiled from: MatroskaExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public class e implements l {

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public static final r f35035c0 = new r() { // from class: v2.d
        @Override // p2.r
        public final l[] createExtractors() {
            return e.z();
        }

        @Override // p2.r
        public /* synthetic */ l[] createExtractors(Uri uri, Map map) {
            return q.a(this, uri, map);
        }
    };

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    private static final byte[] f35036d0 = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    private static final byte[] f35037e0 = o0.h0("Format: Start, End, ReadOrder, Layer, Style, Name, MarginL, MarginR, MarginV, Effect, Text");

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    private static final byte[] f35038f0 = {68, 105, 97, 108, 111, 103, 117, 101, 58, 32, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 58, 48, 48, 58, 48, 48, 58, 48, 48, 44};

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    private static final byte[] f35039g0 = {87, 69, 66, 86, 84, 84, 10, 10, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 46, 48, 48, 48, 10};

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    private static final UUID f35040h0 = new UUID(72057594037932032L, -9223371306706625679L);

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    private static final Map<String, Integer> f35041i0;
    private long A;
    private long B;

    @Nullable
    private u C;

    @Nullable
    private u D;
    private boolean E;
    private boolean F;
    private int G;
    private long H;
    private long I;
    private int J;
    private int K;
    private int[] L;
    private int M;
    private int N;
    private int O;
    private int P;
    private boolean Q;
    private long R;
    private int S;
    private int T;
    private int U;
    private boolean V;
    private boolean W;
    private boolean X;
    private int Y;
    private byte Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final v2.c f35042a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    private boolean f35043a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f35044b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    private n f35045b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SparseArray<c> f35046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f35047d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final c0 f35048e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c0 f35049f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final c0 f35050g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final c0 f35051h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final c0 f35052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final c0 f35053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final c0 f35054k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final c0 f35055l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final c0 f35056m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final c0 f35057n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private ByteBuffer f35058o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f35059p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private long f35060q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f35061r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private long f35062s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f35063t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @Nullable
    private c f35064u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f35065v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f35066w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private long f35067x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private boolean f35068y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private long f35069z;

    /* JADX INFO: compiled from: MatroskaExtractor.java */
    private final class b implements v2.b {
        private b() {
        }

        @Override // v2.b
        public void a(int i10, int i11, m mVar) throws IOException {
            e.this.k(i10, i11, mVar);
        }

        @Override // v2.b
        public void endMasterElement(int i10) throws j2 {
            e.this.n(i10);
        }

        @Override // v2.b
        public void floatElement(int i10, double d10) throws j2 {
            e.this.q(i10, d10);
        }

        @Override // v2.b
        public int getElementType(int i10) {
            return e.this.t(i10);
        }

        @Override // v2.b
        public void integerElement(int i10, long j10) throws j2 {
            e.this.w(i10, j10);
        }

        @Override // v2.b
        public boolean isLevel1Element(int i10) {
            return e.this.y(i10);
        }

        @Override // v2.b
        public void startMasterElement(int i10, long j10, long j11) throws j2 {
            e.this.F(i10, j10, j11);
        }

        @Override // v2.b
        public void stringElement(int i10, String str) throws j2 {
            e.this.G(i10, str);
        }
    }

    /* JADX INFO: compiled from: MatroskaExtractor.java */
    protected static final class c {
        public byte[] N;
        public f0 T;
        public boolean U;
        public e0 X;
        public int Y;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f35071a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f35072b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f35073c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f35074d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f35075e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f35076f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f35077g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f35078h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte[] f35079i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public e0.a f35080j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public byte[] f35081k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public o2.m f35082l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f35083m = -1;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f35084n = -1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f35085o = -1;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f35086p = -1;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f35087q = 0;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public int f35088r = -1;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public float f35089s = 0.0f;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public float f35090t = 0.0f;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public float f35091u = 0.0f;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public byte[] f35092v = null;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public int f35093w = -1;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public boolean f35094x = false;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public int f35095y = -1;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public int f35096z = -1;
        public int A = -1;
        public int B = 1000;
        public int C = 200;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public float G = -1.0f;
        public float H = -1.0f;
        public float I = -1.0f;
        public float J = -1.0f;
        public float K = -1.0f;
        public float L = -1.0f;
        public float M = -1.0f;
        public int O = 1;
        public int P = -1;
        public int Q = 8000;
        public long R = 0;
        public long S = 0;
        public boolean V = true;
        private String W = "eng";

        protected c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f() {
            a4.a.e(this.X);
        }

        private byte[] g(String str) throws j2 {
            byte[] bArr = this.f35081k;
            if (bArr != null) {
                return bArr;
            }
            throw j2.a("Missing CodecPrivate for codec " + str, null);
        }

        @Nullable
        private byte[] h() {
            if (this.D == -1.0f || this.E == -1.0f || this.F == -1.0f || this.G == -1.0f || this.H == -1.0f || this.I == -1.0f || this.J == -1.0f || this.K == -1.0f || this.L == -1.0f || this.M == -1.0f) {
                return null;
            }
            byte[] bArr = new byte[25];
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put((byte) 0);
            byteBufferOrder.putShort((short) ((this.D * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.E * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.F * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.G * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.H * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.I * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.J * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) ((this.K * 50000.0f) + 0.5f));
            byteBufferOrder.putShort((short) (this.L + 0.5f));
            byteBufferOrder.putShort((short) (this.M + 0.5f));
            byteBufferOrder.putShort((short) this.B);
            byteBufferOrder.putShort((short) this.C);
            return bArr;
        }

        private static Pair<String, List<byte[]>> k(c0 c0Var) throws j2 {
            try {
                c0Var.Q(16);
                long jT = c0Var.t();
                if (jT == 1482049860) {
                    return new Pair<>(MimeTypes.VIDEO_DIVX, null);
                }
                if (jT == 859189832) {
                    return new Pair<>(MimeTypes.VIDEO_H263, null);
                }
                if (jT != 826496599) {
                    t.i("MatroskaExtractor", "Unknown FourCC. Setting mimeType to video/x-unknown");
                    return new Pair<>(MimeTypes.VIDEO_UNKNOWN, null);
                }
                byte[] bArrD = c0Var.d();
                for (int iE = c0Var.e() + 20; iE < bArrD.length - 4; iE++) {
                    if (bArrD[iE] == 0 && bArrD[iE + 1] == 0 && bArrD[iE + 2] == 1 && bArrD[iE + 3] == 15) {
                        return new Pair<>(MimeTypes.VIDEO_VC1, Collections.singletonList(Arrays.copyOfRange(bArrD, iE, bArrD.length)));
                    }
                }
                throw j2.a("Failed to find FourCC VC1 initialization data", null);
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw j2.a("Error parsing FourCC private data", null);
            }
        }

        private static boolean l(c0 c0Var) throws j2 {
            try {
                int iV = c0Var.v();
                if (iV == 1) {
                    return true;
                }
                if (iV != 65534) {
                    return false;
                }
                c0Var.P(24);
                if (c0Var.w() == e.f35040h0.getMostSignificantBits()) {
                    if (c0Var.w() == e.f35040h0.getLeastSignificantBits()) {
                        return true;
                    }
                }
                return false;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw j2.a("Error parsing MS/ACM codec private", null);
            }
        }

        private static List<byte[]> m(byte[] bArr) throws j2 {
            int i10;
            int i11;
            try {
                if (bArr[0] != 2) {
                    throw j2.a("Error parsing vorbis codec private", null);
                }
                int i12 = 0;
                int i13 = 1;
                while (true) {
                    i10 = bArr[i13];
                    if ((i10 & 255) != 255) {
                        break;
                    }
                    i12 += 255;
                    i13++;
                }
                int i14 = i13 + 1;
                int i15 = i12 + (i10 & 255);
                int i16 = 0;
                while (true) {
                    i11 = bArr[i14];
                    if ((i11 & 255) != 255) {
                        break;
                    }
                    i16 += 255;
                    i14++;
                }
                int i17 = i14 + 1;
                int i18 = i16 + (i11 & 255);
                if (bArr[i17] != 1) {
                    throw j2.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr2 = new byte[i15];
                System.arraycopy(bArr, i17, bArr2, 0, i15);
                int i19 = i17 + i15;
                if (bArr[i19] != 3) {
                    throw j2.a("Error parsing vorbis codec private", null);
                }
                int i20 = i19 + i18;
                if (bArr[i20] != 5) {
                    throw j2.a("Error parsing vorbis codec private", null);
                }
                byte[] bArr3 = new byte[bArr.length - i20];
                System.arraycopy(bArr, i20, bArr3, 0, bArr.length - i20);
                ArrayList arrayList = new ArrayList(2);
                arrayList.add(bArr2);
                arrayList.add(bArr3);
                return arrayList;
            } catch (ArrayIndexOutOfBoundsException unused) {
                throw j2.a("Error parsing vorbis codec private", null);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean o(boolean z10) {
            return "A_OPUS".equals(this.f35072b) ? z10 : this.f35076f > 0;
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        /* JADX WARN: Removed duplicated region for block: B:202:0x0417  */
        /* JADX WARN: Removed duplicated region for block: B:207:0x0430  */
        /* JADX WARN: Removed duplicated region for block: B:208:0x0432  */
        /* JADX WARN: Removed duplicated region for block: B:211:0x043f  */
        /* JADX WARN: Removed duplicated region for block: B:212:0x0451  */
        /* JADX WARN: Removed duplicated region for block: B:278:0x055b  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x0015  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(p2.n r20, int r21) throws k2.j2 {
            /*
                Method dump skipped, instruction units count: 1648
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: v2.e.c.i(p2.n, int):void");
        }

        public void j() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.a(this.X, this.f35080j);
            }
        }

        public void n() {
            f0 f0Var = this.T;
            if (f0Var != null) {
                f0Var.b();
            }
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("htc_video_rotA-000", 0);
        map.put("htc_video_rotA-090", 90);
        map.put("htc_video_rotA-180", 180);
        map.put("htc_video_rotA-270", 270);
        f35041i0 = Collections.unmodifiableMap(map);
    }

    public e() {
        this(0);
    }

    private boolean A(a0 a0Var, long j10) {
        if (this.f35068y) {
            this.A = j10;
            a0Var.f32443a = this.f35069z;
            this.f35068y = false;
            return true;
        }
        if (this.f35065v) {
            long j11 = this.A;
            if (j11 != -1) {
                a0Var.f32443a = j11;
                this.A = -1L;
                return true;
            }
        }
        return false;
    }

    private void B(m mVar, int i10) throws IOException {
        if (this.f35050g.f() >= i10) {
            return;
        }
        if (this.f35050g.b() < i10) {
            c0 c0Var = this.f35050g;
            c0Var.c(Math.max(c0Var.b() * 2, i10));
        }
        mVar.readFully(this.f35050g.d(), this.f35050g.f(), i10 - this.f35050g.f());
        this.f35050g.O(i10);
    }

    private void C() {
        this.S = 0;
        this.T = 0;
        this.U = 0;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = 0;
        this.Z = (byte) 0;
        this.f35043a0 = false;
        this.f35053j.L(0);
    }

    private long D(long j10) throws j2 {
        long j11 = this.f35061r;
        if (j11 != C.TIME_UNSET) {
            return o0.F0(j10, j11, 1000L);
        }
        throw j2.a("Can't scale timecode prior to timecodeScale being set.", null);
    }

    private static void E(String str, long j10, byte[] bArr) {
        byte[] bArrR;
        int i10;
        str.hashCode();
        switch (str) {
            case "S_TEXT/ASS":
                bArrR = r(j10, "%01d:%02d:%02d:%02d", 10000L);
                i10 = 21;
                break;
            case "S_TEXT/WEBVTT":
                bArrR = r(j10, "%02d:%02d:%02d.%03d", 1000L);
                i10 = 25;
                break;
            case "S_TEXT/UTF8":
                bArrR = r(j10, "%02d:%02d:%02d,%03d", 1000L);
                i10 = 19;
                break;
            default:
                throw new IllegalArgumentException();
        }
        System.arraycopy(bArrR, 0, bArr, i10, bArrR.length);
    }

    private int H(m mVar, c cVar, int i10, boolean z10) throws IOException {
        int i11;
        if ("S_TEXT/UTF8".equals(cVar.f35072b)) {
            I(mVar, f35036d0, i10);
            return p();
        }
        if ("S_TEXT/ASS".equals(cVar.f35072b)) {
            I(mVar, f35038f0, i10);
            return p();
        }
        if ("S_TEXT/WEBVTT".equals(cVar.f35072b)) {
            I(mVar, f35039g0, i10);
            return p();
        }
        e0 e0Var = cVar.X;
        if (!this.V) {
            if (cVar.f35078h) {
                this.O &= -1073741825;
                if (!this.W) {
                    mVar.readFully(this.f35050g.d(), 0, 1);
                    this.S++;
                    if ((this.f35050g.d()[0] & 128) == 128) {
                        throw j2.a("Extension bit is set in signal byte", null);
                    }
                    this.Z = this.f35050g.d()[0];
                    this.W = true;
                }
                byte b10 = this.Z;
                if ((b10 & 1) == 1) {
                    boolean z11 = (b10 & 2) == 2;
                    this.O |= 1073741824;
                    if (!this.f35043a0) {
                        mVar.readFully(this.f35055l.d(), 0, 8);
                        this.S += 8;
                        this.f35043a0 = true;
                        this.f35050g.d()[0] = (byte) ((z11 ? 128 : 0) | 8);
                        this.f35050g.P(0);
                        e0Var.b(this.f35050g, 1, 1);
                        this.T++;
                        this.f35055l.P(0);
                        e0Var.b(this.f35055l, 8, 1);
                        this.T += 8;
                    }
                    if (z11) {
                        if (!this.X) {
                            mVar.readFully(this.f35050g.d(), 0, 1);
                            this.S++;
                            this.f35050g.P(0);
                            this.Y = this.f35050g.D();
                            this.X = true;
                        }
                        int i12 = this.Y * 4;
                        this.f35050g.L(i12);
                        mVar.readFully(this.f35050g.d(), 0, i12);
                        this.S += i12;
                        short s10 = (short) ((this.Y / 2) + 1);
                        int i13 = (s10 * 6) + 2;
                        ByteBuffer byteBuffer = this.f35058o;
                        if (byteBuffer == null || byteBuffer.capacity() < i13) {
                            this.f35058o = ByteBuffer.allocate(i13);
                        }
                        this.f35058o.position(0);
                        this.f35058o.putShort(s10);
                        int i14 = 0;
                        int i15 = 0;
                        while (true) {
                            i11 = this.Y;
                            if (i14 >= i11) {
                                break;
                            }
                            int iH = this.f35050g.H();
                            if (i14 % 2 == 0) {
                                this.f35058o.putShort((short) (iH - i15));
                            } else {
                                this.f35058o.putInt(iH - i15);
                            }
                            i14++;
                            i15 = iH;
                        }
                        int i16 = (i10 - this.S) - i15;
                        if (i11 % 2 == 1) {
                            this.f35058o.putInt(i16);
                        } else {
                            this.f35058o.putShort((short) i16);
                            this.f35058o.putInt(0);
                        }
                        this.f35056m.N(this.f35058o.array(), i13);
                        e0Var.b(this.f35056m, i13, 1);
                        this.T += i13;
                    }
                }
            } else {
                byte[] bArr = cVar.f35079i;
                if (bArr != null) {
                    this.f35053j.N(bArr, bArr.length);
                }
            }
            if (cVar.o(z10)) {
                this.O |= 268435456;
                this.f35057n.L(0);
                int iF = (this.f35053j.f() + i10) - this.S;
                this.f35050g.L(4);
                this.f35050g.d()[0] = (byte) ((iF >> 24) & 255);
                this.f35050g.d()[1] = (byte) ((iF >> 16) & 255);
                this.f35050g.d()[2] = (byte) ((iF >> 8) & 255);
                this.f35050g.d()[3] = (byte) (iF & 255);
                e0Var.b(this.f35050g, 4, 2);
                this.T += 4;
            }
            this.V = true;
        }
        int iF2 = i10 + this.f35053j.f();
        if (!"V_MPEG4/ISO/AVC".equals(cVar.f35072b) && !"V_MPEGH/ISO/HEVC".equals(cVar.f35072b)) {
            if (cVar.T != null) {
                a4.a.g(this.f35053j.f() == 0);
                cVar.T.d(mVar);
            }
            while (true) {
                int i17 = this.S;
                if (i17 >= iF2) {
                    break;
                }
                int iJ = J(mVar, e0Var, iF2 - i17);
                this.S += iJ;
                this.T += iJ;
            }
        } else {
            byte[] bArrD = this.f35049f.d();
            bArrD[0] = 0;
            bArrD[1] = 0;
            bArrD[2] = 0;
            int i18 = cVar.Y;
            int i19 = 4 - i18;
            while (this.S < iF2) {
                int i20 = this.U;
                if (i20 == 0) {
                    K(mVar, bArrD, i19, i18);
                    this.S += i18;
                    this.f35049f.P(0);
                    this.U = this.f35049f.H();
                    this.f35048e.P(0);
                    e0Var.e(this.f35048e, 4);
                    this.T += 4;
                } else {
                    int iJ2 = J(mVar, e0Var, i20);
                    this.S += iJ2;
                    this.T += iJ2;
                    this.U -= iJ2;
                }
            }
        }
        if ("A_VORBIS".equals(cVar.f35072b)) {
            this.f35051h.P(0);
            e0Var.e(this.f35051h, 4);
            this.T += 4;
        }
        return p();
    }

    private void I(m mVar, byte[] bArr, int i10) throws IOException {
        int length = bArr.length + i10;
        if (this.f35054k.b() < length) {
            this.f35054k.M(Arrays.copyOf(bArr, length + i10));
        } else {
            System.arraycopy(bArr, 0, this.f35054k.d(), 0, bArr.length);
        }
        mVar.readFully(this.f35054k.d(), bArr.length, i10);
        this.f35054k.P(0);
        this.f35054k.O(length);
    }

    private int J(m mVar, e0 e0Var, int i10) throws IOException {
        int iA = this.f35053j.a();
        if (iA <= 0) {
            return e0Var.c(mVar, i10, false);
        }
        int iMin = Math.min(i10, iA);
        e0Var.e(this.f35053j, iMin);
        return iMin;
    }

    private void K(m mVar, byte[] bArr, int i10, int i11) throws IOException {
        int iMin = Math.min(i11, this.f35053j.a());
        mVar.readFully(bArr, i10 + iMin, i11 - iMin);
        if (iMin > 0) {
            this.f35053j.j(bArr, i10, iMin);
        }
    }

    private void h(int i10) throws j2 {
        if (this.C == null || this.D == null) {
            throw j2.a("Element " + i10 + " must be in a Cues", null);
        }
    }

    private void i(int i10) throws j2 {
        if (this.f35064u != null) {
            return;
        }
        throw j2.a("Element " + i10 + " must be in a TrackEntry", null);
    }

    private void j() {
        a4.a.i(this.f35045b0);
    }

    private b0 l(@Nullable u uVar, @Nullable u uVar2) {
        int i10;
        if (this.f35060q == -1 || this.f35063t == C.TIME_UNSET || uVar == null || uVar.c() == 0 || uVar2 == null || uVar2.c() != uVar.c()) {
            return new b0.b(this.f35063t);
        }
        int iC = uVar.c();
        int[] iArrCopyOf = new int[iC];
        long[] jArrCopyOf = new long[iC];
        long[] jArrCopyOf2 = new long[iC];
        long[] jArrCopyOf3 = new long[iC];
        int i11 = 0;
        for (int i12 = 0; i12 < iC; i12++) {
            jArrCopyOf3[i12] = uVar.b(i12);
            jArrCopyOf[i12] = this.f35060q + uVar2.b(i12);
        }
        while (true) {
            i10 = iC - 1;
            if (i11 >= i10) {
                break;
            }
            int i13 = i11 + 1;
            iArrCopyOf[i11] = (int) (jArrCopyOf[i13] - jArrCopyOf[i11]);
            jArrCopyOf2[i11] = jArrCopyOf3[i13] - jArrCopyOf3[i11];
            i11 = i13;
        }
        iArrCopyOf[i10] = (int) ((this.f35060q + this.f35059p) - jArrCopyOf[i10]);
        long j10 = this.f35063t - jArrCopyOf3[i10];
        jArrCopyOf2[i10] = j10;
        if (j10 <= 0) {
            t.i("MatroskaExtractor", "Discarding last cue point with unexpected duration: " + j10);
            iArrCopyOf = Arrays.copyOf(iArrCopyOf, i10);
            jArrCopyOf = Arrays.copyOf(jArrCopyOf, i10);
            jArrCopyOf2 = Arrays.copyOf(jArrCopyOf2, i10);
            jArrCopyOf3 = Arrays.copyOf(jArrCopyOf3, i10);
        }
        return new p2.d(iArrCopyOf, jArrCopyOf, jArrCopyOf2, jArrCopyOf3);
    }

    private void m(c cVar, long j10, int i10, int i11, int i12) {
        f0 f0Var = cVar.T;
        if (f0Var != null) {
            f0Var.c(cVar.X, j10, i10, i11, i12, cVar.f35080j);
        } else {
            if ("S_TEXT/UTF8".equals(cVar.f35072b) || "S_TEXT/ASS".equals(cVar.f35072b) || "S_TEXT/WEBVTT".equals(cVar.f35072b)) {
                if (this.K > 1) {
                    t.i("MatroskaExtractor", "Skipping subtitle sample in laced block.");
                } else {
                    long j11 = this.I;
                    if (j11 == C.TIME_UNSET) {
                        t.i("MatroskaExtractor", "Skipping subtitle sample with no duration.");
                    } else {
                        E(cVar.f35072b, j11, this.f35054k.d());
                        int iE = this.f35054k.e();
                        while (true) {
                            if (iE >= this.f35054k.f()) {
                                break;
                            }
                            if (this.f35054k.d()[iE] == 0) {
                                this.f35054k.O(iE);
                                break;
                            }
                            iE++;
                        }
                        e0 e0Var = cVar.X;
                        c0 c0Var = this.f35054k;
                        e0Var.e(c0Var, c0Var.f());
                        i11 += this.f35054k.f();
                    }
                }
            }
            if ((268435456 & i10) != 0) {
                if (this.K > 1) {
                    this.f35057n.L(0);
                } else {
                    int iF = this.f35057n.f();
                    cVar.X.b(this.f35057n, iF, 2);
                    i11 += iF;
                }
            }
            cVar.X.a(j10, i10, i11, i12, cVar.f35080j);
        }
        this.F = true;
    }

    private static int[] o(@Nullable int[] iArr, int i10) {
        return iArr == null ? new int[i10] : iArr.length >= i10 ? iArr : new int[Math.max(iArr.length * 2, i10)];
    }

    private int p() {
        int i10 = this.T;
        C();
        return i10;
    }

    private static byte[] r(long j10, String str, long j11) {
        a4.a.a(j10 != C.TIME_UNSET);
        int i10 = (int) (j10 / 3600000000L);
        long j12 = j10 - ((((long) i10) * 3600) * 1000000);
        int i11 = (int) (j12 / 60000000);
        long j13 = j12 - ((((long) i11) * 60) * 1000000);
        int i12 = (int) (j13 / 1000000);
        return o0.h0(String.format(Locale.US, str, Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf((int) ((j13 - (((long) i12) * 1000000)) / j11))));
    }

    private static boolean x(String str) {
        str.hashCode();
        switch (str) {
            case "V_MPEG4/ISO/AP":
            case "V_MPEG4/ISO/SP":
            case "A_MS/ACM":
            case "A_TRUEHD":
            case "A_VORBIS":
            case "A_MPEG/L2":
            case "A_MPEG/L3":
            case "V_MS/VFW/FOURCC":
            case "S_DVBSUB":
            case "V_MPEG4/ISO/ASP":
            case "V_MPEG4/ISO/AVC":
            case "S_VOBSUB":
            case "A_DTS/LOSSLESS":
            case "A_AAC":
            case "A_AC3":
            case "A_DTS":
            case "V_AV1":
            case "V_VP8":
            case "V_VP9":
            case "S_HDMV/PGS":
            case "V_THEORA":
            case "A_DTS/EXPRESS":
            case "A_PCM/FLOAT/IEEE":
            case "A_PCM/INT/BIG":
            case "A_PCM/INT/LIT":
            case "S_TEXT/ASS":
            case "V_MPEGH/ISO/HEVC":
            case "S_TEXT/WEBVTT":
            case "S_TEXT/UTF8":
            case "V_MPEG2":
            case "A_EAC3":
            case "A_FLAC":
            case "A_OPUS":
                return true;
            default:
                return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ l[] z() {
        return new l[]{new e()};
    }

    @CallSuper
    protected void F(int i10, long j10, long j11) throws j2 {
        j();
        if (i10 == 160) {
            this.Q = false;
            this.R = 0L;
            return;
        }
        if (i10 == 174) {
            this.f35064u = new c();
            return;
        }
        if (i10 == 187) {
            this.E = false;
            return;
        }
        if (i10 == 19899) {
            this.f35066w = -1;
            this.f35067x = -1L;
            return;
        }
        if (i10 == 20533) {
            s(i10).f35078h = true;
            return;
        }
        if (i10 == 21968) {
            s(i10).f35094x = true;
            return;
        }
        if (i10 == 408125543) {
            long j12 = this.f35060q;
            if (j12 != -1 && j12 != j10) {
                throw j2.a("Multiple Segment elements not supported", null);
            }
            this.f35060q = j10;
            this.f35059p = j11;
            return;
        }
        if (i10 == 475249515) {
            this.C = new u();
            this.D = new u();
        } else if (i10 == 524531317 && !this.f35065v) {
            if (this.f35047d && this.f35069z != -1) {
                this.f35068y = true;
            } else {
                this.f35045b0.h(new b0.b(this.f35063t));
                this.f35065v = true;
            }
        }
    }

    @CallSuper
    protected void G(int i10, String str) throws j2 {
        if (i10 == 134) {
            s(i10).f35072b = str;
            return;
        }
        if (i10 != 17026) {
            if (i10 == 21358) {
                s(i10).f35071a = str;
                return;
            } else {
                if (i10 != 2274716) {
                    return;
                }
                s(i10).W = str;
                return;
            }
        }
        if ("webm".equals(str) || "matroska".equals(str)) {
            return;
        }
        throw j2.a("DocType " + str + " not supported", null);
    }

    @Override // p2.l
    public final int a(m mVar, a0 a0Var) throws IOException {
        this.F = false;
        boolean zA = true;
        while (zA && !this.F) {
            zA = this.f35042a.a(mVar);
            if (zA && A(a0Var, mVar.getPosition())) {
                return 1;
            }
        }
        if (zA) {
            return 0;
        }
        for (int i10 = 0; i10 < this.f35046c.size(); i10++) {
            c cVarValueAt = this.f35046c.valueAt(i10);
            cVarValueAt.f();
            cVarValueAt.j();
        }
        return -1;
    }

    @Override // p2.l
    public final void b(n nVar) {
        this.f35045b0 = nVar;
    }

    @Override // p2.l
    public final boolean c(m mVar) throws IOException {
        return new f().b(mVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:85:0x0237, code lost:
    
        throw k2.j2.a("EBML lacing sample size out of range.", null);
     */
    @androidx.annotation.CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void k(int r23, int r24, p2.m r25) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 756
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: v2.e.k(int, int, p2.m):void");
    }

    @CallSuper
    protected void n(int i10) throws j2 {
        j();
        if (i10 == 160) {
            if (this.G != 2) {
                return;
            }
            c cVar = this.f35046c.get(this.M);
            cVar.f();
            if (this.R > 0 && "A_OPUS".equals(cVar.f35072b)) {
                this.f35057n.M(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putLong(this.R).array());
            }
            int i11 = 0;
            for (int i12 = 0; i12 < this.K; i12++) {
                i11 += this.L[i12];
            }
            int i13 = 0;
            while (i13 < this.K) {
                long j10 = this.H + ((long) ((cVar.f35075e * i13) / 1000));
                int i14 = this.O;
                if (i13 == 0 && !this.Q) {
                    i14 |= 1;
                }
                int i15 = this.L[i13];
                int i16 = i11 - i15;
                m(cVar, j10, i14, i15, i16);
                i13++;
                i11 = i16;
            }
            this.G = 0;
            return;
        }
        if (i10 == 174) {
            c cVar2 = (c) a4.a.i(this.f35064u);
            String str = cVar2.f35072b;
            if (str == null) {
                throw j2.a("CodecId is missing in TrackEntry element", null);
            }
            if (x(str)) {
                cVar2.i(this.f35045b0, cVar2.f35073c);
                this.f35046c.put(cVar2.f35073c, cVar2);
            }
            this.f35064u = null;
            return;
        }
        if (i10 == 19899) {
            int i17 = this.f35066w;
            if (i17 != -1) {
                long j11 = this.f35067x;
                if (j11 != -1) {
                    if (i17 == 475249515) {
                        this.f35069z = j11;
                        return;
                    }
                    return;
                }
            }
            throw j2.a("Mandatory element SeekID or SeekPosition not found", null);
        }
        if (i10 == 25152) {
            i(i10);
            c cVar3 = this.f35064u;
            if (cVar3.f35078h) {
                if (cVar3.f35080j == null) {
                    throw j2.a("Encrypted Track found but ContentEncKeyID was not found", null);
                }
                cVar3.f35082l = new o2.m(new m.b(i.f29126a, "video/webm", this.f35064u.f35080j.f32465b));
                return;
            }
            return;
        }
        if (i10 == 28032) {
            i(i10);
            c cVar4 = this.f35064u;
            if (cVar4.f35078h && cVar4.f35079i != null) {
                throw j2.a("Combining encryption and compression is not supported", null);
            }
            return;
        }
        if (i10 == 357149030) {
            if (this.f35061r == C.TIME_UNSET) {
                this.f35061r = 1000000L;
            }
            long j12 = this.f35062s;
            if (j12 != C.TIME_UNSET) {
                this.f35063t = D(j12);
                return;
            }
            return;
        }
        if (i10 == 374648427) {
            if (this.f35046c.size() == 0) {
                throw j2.a("No valid tracks were found", null);
            }
            this.f35045b0.endTracks();
        } else {
            if (i10 != 475249515) {
                return;
            }
            if (!this.f35065v) {
                this.f35045b0.h(l(this.C, this.D));
                this.f35065v = true;
            }
            this.C = null;
            this.D = null;
        }
    }

    @CallSuper
    protected void q(int i10, double d10) throws j2 {
        if (i10 == 181) {
            s(i10).Q = (int) d10;
        }
        if (i10 == 17545) {
            this.f35062s = (long) d10;
            return;
        }
        switch (i10) {
            case 21969:
                s(i10).D = (float) d10;
                break;
            case 21970:
                s(i10).E = (float) d10;
                break;
            case 21971:
                s(i10).F = (float) d10;
                break;
            case 21972:
                s(i10).G = (float) d10;
                break;
            case 21973:
                s(i10).H = (float) d10;
                break;
            case 21974:
                s(i10).I = (float) d10;
                break;
            case 21975:
                s(i10).J = (float) d10;
                break;
            case 21976:
                s(i10).K = (float) d10;
                break;
            case 21977:
                s(i10).L = (float) d10;
                break;
            case 21978:
                s(i10).M = (float) d10;
                break;
            default:
                switch (i10) {
                    case 30323:
                        s(i10).f35089s = (float) d10;
                        break;
                    case 30324:
                        s(i10).f35090t = (float) d10;
                        break;
                    case 30325:
                        s(i10).f35091u = (float) d10;
                        break;
                }
                break;
        }
    }

    protected c s(int i10) throws j2 {
        i(i10);
        return this.f35064u;
    }

    @Override // p2.l
    @CallSuper
    public void seek(long j10, long j11) {
        this.B = C.TIME_UNSET;
        this.G = 0;
        this.f35042a.reset();
        this.f35044b.e();
        C();
        for (int i10 = 0; i10 < this.f35046c.size(); i10++) {
            this.f35046c.valueAt(i10).n();
        }
    }

    @CallSuper
    protected int t(int i10) {
        switch (i10) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 238:
            case 241:
            case 251:
            case 16871:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 21998:
            case 22186:
            case 22203:
            case 25188:
            case 30114:
            case 30321:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 21358:
            case 2274716:
                return 3;
            case 160:
            case 166:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 16868:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30113:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 165:
            case 16877:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
            case 30323:
            case 30324:
            case 30325:
                return 5;
            default:
                return 0;
        }
    }

    protected void u(c cVar, p2.m mVar, int i10) throws IOException {
        if (cVar.f35077g != 1685485123 && cVar.f35077g != 1685480259) {
            mVar.skipFully(i10);
            return;
        }
        byte[] bArr = new byte[i10];
        cVar.N = bArr;
        mVar.readFully(bArr, 0, i10);
    }

    protected void v(c cVar, int i10, p2.m mVar, int i11) throws IOException {
        if (i10 != 4 || !"V_VP9".equals(cVar.f35072b)) {
            mVar.skipFully(i11);
        } else {
            this.f35057n.L(i11);
            mVar.readFully(this.f35057n.d(), 0, i11);
        }
    }

    @CallSuper
    protected void w(int i10, long j10) throws j2 {
        if (i10 == 20529) {
            if (j10 == 0) {
                return;
            }
            throw j2.a("ContentEncodingOrder " + j10 + " not supported", null);
        }
        if (i10 == 20530) {
            if (j10 == 1) {
                return;
            }
            throw j2.a("ContentEncodingScope " + j10 + " not supported", null);
        }
        switch (i10) {
            case 131:
                s(i10).f35074d = (int) j10;
                return;
            case 136:
                s(i10).V = j10 == 1;
                return;
            case 155:
                this.I = D(j10);
                return;
            case 159:
                s(i10).O = (int) j10;
                return;
            case 176:
                s(i10).f35083m = (int) j10;
                return;
            case 179:
                h(i10);
                this.C.a(D(j10));
                return;
            case 186:
                s(i10).f35084n = (int) j10;
                return;
            case 215:
                s(i10).f35073c = (int) j10;
                return;
            case 231:
                this.B = D(j10);
                return;
            case 238:
                this.P = (int) j10;
                return;
            case 241:
                if (this.E) {
                    return;
                }
                h(i10);
                this.D.a(j10);
                this.E = true;
                return;
            case 251:
                this.Q = true;
                return;
            case 16871:
                s(i10).f35077g = (int) j10;
                return;
            case 16980:
                if (j10 == 3) {
                    return;
                }
                throw j2.a("ContentCompAlgo " + j10 + " not supported", null);
            case 17029:
                if (j10 < 1 || j10 > 2) {
                    throw j2.a("DocTypeReadVersion " + j10 + " not supported", null);
                }
                return;
            case 17143:
                if (j10 == 1) {
                    return;
                }
                throw j2.a("EBMLReadVersion " + j10 + " not supported", null);
            case 18401:
                if (j10 == 5) {
                    return;
                }
                throw j2.a("ContentEncAlgo " + j10 + " not supported", null);
            case 18408:
                if (j10 == 1) {
                    return;
                }
                throw j2.a("AESSettingsCipherMode " + j10 + " not supported", null);
            case 21420:
                this.f35067x = j10 + this.f35060q;
                return;
            case 21432:
                int i11 = (int) j10;
                i(i10);
                if (i11 == 0) {
                    this.f35064u.f35093w = 0;
                    return;
                }
                if (i11 == 1) {
                    this.f35064u.f35093w = 2;
                    return;
                } else if (i11 == 3) {
                    this.f35064u.f35093w = 1;
                    return;
                } else {
                    if (i11 != 15) {
                        return;
                    }
                    this.f35064u.f35093w = 3;
                    return;
                }
            case 21680:
                s(i10).f35085o = (int) j10;
                return;
            case 21682:
                s(i10).f35087q = (int) j10;
                return;
            case 21690:
                s(i10).f35086p = (int) j10;
                return;
            case 21930:
                s(i10).U = j10 == 1;
                return;
            case 21998:
                s(i10).f35076f = (int) j10;
                return;
            case 22186:
                s(i10).R = j10;
                return;
            case 22203:
                s(i10).S = j10;
                return;
            case 25188:
                s(i10).P = (int) j10;
                return;
            case 30114:
                this.R = j10;
                return;
            case 30321:
                i(i10);
                int i12 = (int) j10;
                if (i12 == 0) {
                    this.f35064u.f35088r = 0;
                    return;
                }
                if (i12 == 1) {
                    this.f35064u.f35088r = 1;
                    return;
                } else if (i12 == 2) {
                    this.f35064u.f35088r = 2;
                    return;
                } else {
                    if (i12 != 3) {
                        return;
                    }
                    this.f35064u.f35088r = 3;
                    return;
                }
            case 2352003:
                s(i10).f35075e = (int) j10;
                return;
            case 2807729:
                this.f35061r = j10;
                return;
            default:
                switch (i10) {
                    case 21945:
                        i(i10);
                        int i13 = (int) j10;
                        if (i13 == 1) {
                            this.f35064u.A = 2;
                            return;
                        } else {
                            if (i13 != 2) {
                                return;
                            }
                            this.f35064u.A = 1;
                            return;
                        }
                    case 21946:
                        i(i10);
                        int iC = b4.c.c((int) j10);
                        if (iC != -1) {
                            this.f35064u.f35096z = iC;
                            return;
                        }
                        return;
                    case 21947:
                        i(i10);
                        this.f35064u.f35094x = true;
                        int iB = b4.c.b((int) j10);
                        if (iB != -1) {
                            this.f35064u.f35095y = iB;
                            return;
                        }
                        return;
                    case 21948:
                        s(i10).B = (int) j10;
                        return;
                    case 21949:
                        s(i10).C = (int) j10;
                        return;
                    default:
                        return;
                }
        }
    }

    @CallSuper
    protected boolean y(int i10) {
        return i10 == 357149030 || i10 == 524531317 || i10 == 475249515 || i10 == 374648427;
    }

    public e(int i10) {
        this(new v2.a(), i10);
    }

    e(v2.c cVar, int i10) {
        this.f35060q = -1L;
        this.f35061r = C.TIME_UNSET;
        this.f35062s = C.TIME_UNSET;
        this.f35063t = C.TIME_UNSET;
        this.f35069z = -1L;
        this.A = -1L;
        this.B = C.TIME_UNSET;
        this.f35042a = cVar;
        cVar.b(new b());
        this.f35047d = (i10 & 1) == 0;
        this.f35044b = new g();
        this.f35046c = new SparseArray<>();
        this.f35050g = new c0(4);
        this.f35051h = new c0(ByteBuffer.allocate(4).putInt(-1).array());
        this.f35052i = new c0(4);
        this.f35048e = new c0(y.f258a);
        this.f35049f = new c0(4);
        this.f35053j = new c0();
        this.f35054k = new c0();
        this.f35055l = new c0(8);
        this.f35056m = new c0();
        this.f35057n = new c0();
        this.L = new int[1];
    }

    @Override // p2.l
    public final void release() {
    }
}
