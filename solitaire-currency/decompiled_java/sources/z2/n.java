package z2;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import java.util.Arrays;
import z2.i0;

/* JADX INFO: compiled from: H262Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n implements m {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static final double[] f37169q = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private p2.e0 f37171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final k0 f37172c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final a4.c0 f37173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final u f37174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final boolean[] f37175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f37176g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f37177h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f37178i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37179j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f37180k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f37181l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private long f37182m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f37183n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f37184o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f37185p;

    /* JADX INFO: compiled from: H262Reader.java */
    private static final class a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final byte[] f37186e = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f37187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f37190d;

        public a(int i10) {
            this.f37190d = new byte[i10];
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f37187a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f37190d;
                int length = bArr2.length;
                int i13 = this.f37188b;
                if (length < i13 + i12) {
                    this.f37190d = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy(bArr, i10, this.f37190d, this.f37188b, i12);
                this.f37188b += i12;
            }
        }

        public boolean b(int i10, int i11) {
            if (this.f37187a) {
                int i12 = this.f37188b - i11;
                this.f37188b = i12;
                if (this.f37189c != 0 || i10 != 181) {
                    this.f37187a = false;
                    return true;
                }
                this.f37189c = i12;
            } else if (i10 == 179) {
                this.f37187a = true;
            }
            byte[] bArr = f37186e;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f37187a = false;
            this.f37188b = 0;
            this.f37189c = 0;
        }
    }

    public n() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static android.util.Pair<k2.o1, java.lang.Long> d(z2.n.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.f37190d
            int r1 = r8.f37188b
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            r4 = r0[r3]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r5 = 6
            r5 = r0[r5]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r6 = r4 >> 4
            r2 = r2 | r6
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r5
            r5 = 7
            r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L3d
            r7 = 3
            if (r6 == r7) goto L37
            if (r6 == r1) goto L31
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L44
        L31:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L42
        L37:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L42
        L3d:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L42:
            float r6 = (float) r6
            float r1 = r1 / r6
        L44:
            k2.o1$b r6 = new k2.o1$b
            r6.<init>()
            k2.o1$b r9 = r6.S(r9)
            java.lang.String r6 = "video/mpeg2"
            k2.o1$b r9 = r9.e0(r6)
            k2.o1$b r9 = r9.j0(r2)
            k2.o1$b r9 = r9.Q(r4)
            k2.o1$b r9 = r9.a0(r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            k2.o1$b r9 = r9.T(r1)
            k2.o1 r9 = r9.E()
            r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + (-1)
            if (r1 < 0) goto L98
            double[] r2 = z2.n.f37169q
            int r4 = r2.length
            if (r1 >= r4) goto L98
            r1 = r2[r1]
            int r8 = r8.f37189c
            int r8 = r8 + 9
            r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L90
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L90:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L9a
        L98:
            r0 = 0
        L9a:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.n.d(z2.n$a, java.lang.String):android.util.Pair");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0142  */
    @Override // z2.m
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(a4.c0 r21) {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z2.n.a(a4.c0):void");
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37170a = dVar.b();
        this.f37171b = nVar.track(dVar.c(), 2);
        k0 k0Var = this.f37172c;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        this.f37181l = j10;
    }

    @Override // z2.m
    public void seek() {
        a4.y.a(this.f37175f);
        this.f37176g.c();
        u uVar = this.f37174e;
        if (uVar != null) {
            uVar.d();
        }
        this.f37177h = 0L;
        this.f37178i = false;
        this.f37181l = C.TIME_UNSET;
        this.f37183n = C.TIME_UNSET;
    }

    n(@Nullable k0 k0Var) {
        this.f37172c = k0Var;
        this.f37175f = new boolean[4];
        this.f37176g = new a(128);
        if (k0Var != null) {
            this.f37174e = new u(178, 128);
            this.f37173d = new a4.c0();
        } else {
            this.f37174e = null;
            this.f37173d = null;
        }
        this.f37181l = C.TIME_UNSET;
        this.f37183n = C.TIME_UNSET;
    }

    @Override // z2.m
    public void b() {
    }
}
