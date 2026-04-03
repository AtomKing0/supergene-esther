package z2;

import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import androidx.media3.extractor.ts.PsExtractor;
import java.util.Arrays;
import java.util.Collections;
import k2.o1;
import z2.i0;

/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o implements m {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f37191l = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final k0 f37192a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final a4.c0 f37193b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private final u f37196e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b f37197f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f37198g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f37199h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private p2.e0 f37200i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f37201j;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean[] f37194c = new boolean[4];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f37195d = new a(128);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private long f37202k = C.TIME_UNSET;

    /* JADX INFO: compiled from: H263Reader.java */
    private static final class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final byte[] f37203f = {0, 0, 1};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f37204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f37205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f37206c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f37207d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public byte[] f37208e;

        public a(int i10) {
            this.f37208e = new byte[i10];
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f37204a) {
                int i12 = i11 - i10;
                byte[] bArr2 = this.f37208e;
                int length = bArr2.length;
                int i13 = this.f37206c;
                if (length < i13 + i12) {
                    this.f37208e = Arrays.copyOf(bArr2, (i13 + i12) * 2);
                }
                System.arraycopy(bArr, i10, this.f37208e, this.f37206c, i12);
                this.f37206c += i12;
            }
        }

        public boolean b(int i10, int i11) {
            int i12 = this.f37205b;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 != 2) {
                        if (i12 != 3) {
                            if (i12 != 4) {
                                throw new IllegalStateException();
                            }
                            if (i10 == 179 || i10 == 181) {
                                this.f37206c -= i11;
                                this.f37204a = false;
                                return true;
                            }
                        } else if ((i10 & PsExtractor.VIDEO_STREAM_MASK) != 32) {
                            a4.t.i("H263Reader", "Unexpected start code value");
                            c();
                        } else {
                            this.f37207d = this.f37206c;
                            this.f37205b = 4;
                        }
                    } else if (i10 > 31) {
                        a4.t.i("H263Reader", "Unexpected start code value");
                        c();
                    } else {
                        this.f37205b = 3;
                    }
                } else if (i10 != 181) {
                    a4.t.i("H263Reader", "Unexpected start code value");
                    c();
                } else {
                    this.f37205b = 2;
                }
            } else if (i10 == 176) {
                this.f37205b = 1;
                this.f37204a = true;
            }
            byte[] bArr = f37203f;
            a(bArr, 0, bArr.length);
            return false;
        }

        public void c() {
            this.f37204a = false;
            this.f37206c = 0;
            this.f37205b = 0;
        }
    }

    /* JADX INFO: compiled from: H263Reader.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final p2.e0 f37209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f37210b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f37211c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f37212d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f37213e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f37214f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private long f37215g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private long f37216h;

        public b(p2.e0 e0Var) {
            this.f37209a = e0Var;
        }

        public void a(byte[] bArr, int i10, int i11) {
            if (this.f37211c) {
                int i12 = this.f37214f;
                int i13 = (i10 + 1) - i12;
                if (i13 >= i11) {
                    this.f37214f = i12 + (i11 - i10);
                } else {
                    this.f37212d = ((bArr[i13] & 192) >> 6) == 0;
                    this.f37211c = false;
                }
            }
        }

        public void b(long j10, int i10, boolean z10) {
            if (this.f37213e == 182 && z10 && this.f37210b) {
                long j11 = this.f37216h;
                if (j11 != C.TIME_UNSET) {
                    this.f37209a.a(j11, this.f37212d ? 1 : 0, (int) (j10 - this.f37215g), i10, null);
                }
            }
            if (this.f37213e != 179) {
                this.f37215g = j10;
            }
        }

        public void c(int i10, long j10) {
            this.f37213e = i10;
            this.f37212d = false;
            this.f37210b = i10 == 182 || i10 == 179;
            this.f37211c = i10 == 182;
            this.f37214f = 0;
            this.f37216h = j10;
        }

        public void d() {
            this.f37210b = false;
            this.f37211c = false;
            this.f37212d = false;
            this.f37213e = -1;
        }
    }

    o(@Nullable k0 k0Var) {
        this.f37192a = k0Var;
        if (k0Var != null) {
            this.f37196e = new u(178, 128);
            this.f37193b = new a4.c0();
        } else {
            this.f37196e = null;
            this.f37193b = null;
        }
    }

    private static o1 d(a aVar, int i10, String str) {
        byte[] bArrCopyOf = Arrays.copyOf(aVar.f37208e, aVar.f37206c);
        a4.b0 b0Var = new a4.b0(bArrCopyOf);
        b0Var.s(i10);
        b0Var.s(4);
        b0Var.q();
        b0Var.r(8);
        if (b0Var.g()) {
            b0Var.r(4);
            b0Var.r(3);
        }
        int iH = b0Var.h(4);
        float f10 = 1.0f;
        if (iH == 15) {
            int iH2 = b0Var.h(8);
            int iH3 = b0Var.h(8);
            if (iH3 == 0) {
                a4.t.i("H263Reader", "Invalid aspect ratio");
            } else {
                f10 = iH2 / iH3;
            }
        } else {
            float[] fArr = f37191l;
            if (iH < fArr.length) {
                f10 = fArr[iH];
            } else {
                a4.t.i("H263Reader", "Invalid aspect ratio");
            }
        }
        if (b0Var.g()) {
            b0Var.r(2);
            b0Var.r(1);
            if (b0Var.g()) {
                b0Var.r(15);
                b0Var.q();
                b0Var.r(15);
                b0Var.q();
                b0Var.r(15);
                b0Var.q();
                b0Var.r(3);
                b0Var.r(11);
                b0Var.q();
                b0Var.r(15);
                b0Var.q();
            }
        }
        if (b0Var.h(2) != 0) {
            a4.t.i("H263Reader", "Unhandled video object layer shape");
        }
        b0Var.q();
        int iH4 = b0Var.h(16);
        b0Var.q();
        if (b0Var.g()) {
            if (iH4 == 0) {
                a4.t.i("H263Reader", "Invalid vop_increment_time_resolution");
            } else {
                int i11 = 0;
                for (int i12 = iH4 - 1; i12 > 0; i12 >>= 1) {
                    i11++;
                }
                b0Var.r(i11);
            }
        }
        b0Var.q();
        int iH5 = b0Var.h(13);
        b0Var.q();
        int iH6 = b0Var.h(13);
        b0Var.q();
        b0Var.q();
        return new o1.b().S(str).e0(MimeTypes.VIDEO_MP4V).j0(iH5).Q(iH6).a0(f10).T(Collections.singletonList(bArrCopyOf)).E();
    }

    @Override // z2.m
    public void a(a4.c0 c0Var) {
        a4.a.i(this.f37197f);
        a4.a.i(this.f37200i);
        int iE = c0Var.e();
        int iF = c0Var.f();
        byte[] bArrD = c0Var.d();
        this.f37198g += (long) c0Var.a();
        this.f37200i.e(c0Var, c0Var.a());
        while (true) {
            int iC = a4.y.c(bArrD, iE, iF, this.f37194c);
            if (iC == iF) {
                break;
            }
            int i10 = iC + 3;
            int i11 = c0Var.d()[i10] & 255;
            int i12 = iC - iE;
            int i13 = 0;
            if (!this.f37201j) {
                if (i12 > 0) {
                    this.f37195d.a(bArrD, iE, iC);
                }
                if (this.f37195d.b(i11, i12 < 0 ? -i12 : 0)) {
                    p2.e0 e0Var = this.f37200i;
                    a aVar = this.f37195d;
                    e0Var.f(d(aVar, aVar.f37207d, (String) a4.a.e(this.f37199h)));
                    this.f37201j = true;
                }
            }
            this.f37197f.a(bArrD, iE, iC);
            u uVar = this.f37196e;
            if (uVar != null) {
                if (i12 > 0) {
                    uVar.a(bArrD, iE, iC);
                } else {
                    i13 = -i12;
                }
                if (this.f37196e.b(i13)) {
                    u uVar2 = this.f37196e;
                    ((a4.c0) o0.j(this.f37193b)).N(this.f37196e.f37335d, a4.y.q(uVar2.f37335d, uVar2.f37336e));
                    ((k0) o0.j(this.f37192a)).a(this.f37202k, this.f37193b);
                }
                if (i11 == 178 && c0Var.d()[iC + 2] == 1) {
                    this.f37196e.e(i11);
                }
            }
            int i14 = iF - iC;
            this.f37197f.b(this.f37198g - ((long) i14), i14, this.f37201j);
            this.f37197f.c(i11, this.f37202k);
            iE = i10;
        }
        if (!this.f37201j) {
            this.f37195d.a(bArrD, iE, iF);
        }
        this.f37197f.a(bArrD, iE, iF);
        u uVar3 = this.f37196e;
        if (uVar3 != null) {
            uVar3.a(bArrD, iE, iF);
        }
    }

    @Override // z2.m
    public void c(p2.n nVar, i0.d dVar) {
        dVar.a();
        this.f37199h = dVar.b();
        p2.e0 e0VarTrack = nVar.track(dVar.c(), 2);
        this.f37200i = e0VarTrack;
        this.f37197f = new b(e0VarTrack);
        k0 k0Var = this.f37192a;
        if (k0Var != null) {
            k0Var.b(nVar, dVar);
        }
    }

    @Override // z2.m
    public void packetStarted(long j10, int i10) {
        if (j10 != C.TIME_UNSET) {
            this.f37202k = j10;
        }
    }

    @Override // z2.m
    public void seek() {
        a4.y.a(this.f37194c);
        this.f37195d.c();
        b bVar = this.f37197f;
        if (bVar != null) {
            bVar.d();
        }
        u uVar = this.f37196e;
        if (uVar != null) {
            uVar.d();
        }
        this.f37198g = 0L;
        this.f37202k = C.TIME_UNSET;
    }

    @Override // z2.m
    public void b() {
    }
}
