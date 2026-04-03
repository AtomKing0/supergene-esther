package z2;

import a4.l0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import k2.j2;
import z2.i0;

/* JADX INFO: compiled from: PesReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f37340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.b0 f37341b = new a4.b0(new byte[10]);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f37342c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37343d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private l0 f37344e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f37345f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f37346g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f37347h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f37348i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f37349j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f37350k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f37351l;

    public w(m mVar) {
        this.f37340a = mVar;
    }

    private boolean c(a4.c0 c0Var, @Nullable byte[] bArr, int i10) {
        int iMin = Math.min(c0Var.a(), i10 - this.f37343d);
        if (iMin <= 0) {
            return true;
        }
        if (bArr == null) {
            c0Var.Q(iMin);
        } else {
            c0Var.j(bArr, this.f37343d, iMin);
        }
        int i11 = this.f37343d + iMin;
        this.f37343d = i11;
        return i11 == i10;
    }

    private boolean d() {
        this.f37341b.p(0);
        int iH = this.f37341b.h(24);
        if (iH != 1) {
            a4.t.i("PesReader", "Unexpected start code prefix: " + iH);
            this.f37349j = -1;
            return false;
        }
        this.f37341b.r(8);
        int iH2 = this.f37341b.h(16);
        this.f37341b.r(5);
        this.f37350k = this.f37341b.g();
        this.f37341b.r(2);
        this.f37345f = this.f37341b.g();
        this.f37346g = this.f37341b.g();
        this.f37341b.r(6);
        int iH3 = this.f37341b.h(8);
        this.f37348i = iH3;
        if (iH2 == 0) {
            this.f37349j = -1;
        } else {
            int i10 = ((iH2 + 6) - 9) - iH3;
            this.f37349j = i10;
            if (i10 < 0) {
                a4.t.i("PesReader", "Found negative packet payload size: " + this.f37349j);
                this.f37349j = -1;
            }
        }
        return true;
    }

    private void e() {
        this.f37341b.p(0);
        this.f37351l = C.TIME_UNSET;
        if (this.f37345f) {
            this.f37341b.r(4);
            long jH = ((long) this.f37341b.h(3)) << 30;
            this.f37341b.r(1);
            long jH2 = jH | ((long) (this.f37341b.h(15) << 15));
            this.f37341b.r(1);
            long jH3 = jH2 | ((long) this.f37341b.h(15));
            this.f37341b.r(1);
            if (!this.f37347h && this.f37346g) {
                this.f37341b.r(4);
                long jH4 = ((long) this.f37341b.h(3)) << 30;
                this.f37341b.r(1);
                long jH5 = jH4 | ((long) (this.f37341b.h(15) << 15));
                this.f37341b.r(1);
                long jH6 = jH5 | ((long) this.f37341b.h(15));
                this.f37341b.r(1);
                this.f37344e.b(jH6);
                this.f37347h = true;
            }
            this.f37351l = this.f37344e.b(jH3);
        }
    }

    private void f(int i10) {
        this.f37342c = i10;
        this.f37343d = 0;
    }

    @Override // z2.i0
    public final void a(a4.c0 c0Var, int i10) throws j2 {
        a4.a.i(this.f37344e);
        if ((i10 & 1) != 0) {
            int i11 = this.f37342c;
            if (i11 != 0 && i11 != 1) {
                if (i11 == 2) {
                    a4.t.i("PesReader", "Unexpected start indicator reading extended header");
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException();
                    }
                    if (this.f37349j != -1) {
                        a4.t.i("PesReader", "Unexpected start indicator: expected " + this.f37349j + " more bytes");
                    }
                    this.f37340a.b();
                }
            }
            f(1);
        }
        while (c0Var.a() > 0) {
            int i12 = this.f37342c;
            if (i12 != 0) {
                if (i12 != 1) {
                    if (i12 == 2) {
                        if (c(c0Var, this.f37341b.f141a, Math.min(10, this.f37348i)) && c(c0Var, null, this.f37348i)) {
                            e();
                            i10 |= this.f37350k ? 4 : 0;
                            this.f37340a.packetStarted(this.f37351l, i10);
                            f(3);
                        }
                    } else {
                        if (i12 != 3) {
                            throw new IllegalStateException();
                        }
                        int iA = c0Var.a();
                        int i13 = this.f37349j;
                        int i14 = i13 != -1 ? iA - i13 : 0;
                        if (i14 > 0) {
                            iA -= i14;
                            c0Var.O(c0Var.e() + iA);
                        }
                        this.f37340a.a(c0Var);
                        int i15 = this.f37349j;
                        if (i15 != -1) {
                            int i16 = i15 - iA;
                            this.f37349j = i16;
                            if (i16 == 0) {
                                this.f37340a.b();
                                f(1);
                            }
                        }
                    }
                } else if (c(c0Var, this.f37341b.f141a, 9)) {
                    f(d() ? 2 : 0);
                }
            } else {
                c0Var.Q(c0Var.a());
            }
        }
    }

    @Override // z2.i0
    public void b(l0 l0Var, p2.n nVar, i0.d dVar) {
        this.f37344e = l0Var;
        this.f37340a.c(nVar, dVar);
    }

    @Override // z2.i0
    public final void seek() {
        this.f37342c = 0;
        this.f37343d = 0;
        this.f37347h = false;
        this.f37340a.seek();
    }
}
