package q3;

import a4.c0;
import a4.o0;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;
import n3.b;
import n3.h;
import n3.i;
import n3.k;

/* JADX INFO: compiled from: PgsDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a extends h {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final c0 f33150o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final c0 f33151p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final C0659a f33152q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @Nullable
    private Inflater f33153r;

    /* JADX INFO: renamed from: q3.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PgsDecoder.java */
    private static final class C0659a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final c0 f33154a = new c0();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int[] f33155b = new int[256];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f33156c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f33157d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f33158e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f33159f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private int f33160g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private int f33161h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private int f33162i;

        /* JADX INFO: Access modifiers changed from: private */
        public void e(c0 c0Var, int i10) {
            int iG;
            if (i10 < 4) {
                return;
            }
            c0Var.Q(3);
            int i11 = i10 - 4;
            if ((c0Var.D() & 128) != 0) {
                if (i11 < 7 || (iG = c0Var.G()) < 4) {
                    return;
                }
                this.f33161h = c0Var.J();
                this.f33162i = c0Var.J();
                this.f33154a.L(iG - 4);
                i11 -= 7;
            }
            int iE = this.f33154a.e();
            int iF = this.f33154a.f();
            if (iE >= iF || i11 <= 0) {
                return;
            }
            int iMin = Math.min(i11, iF - iE);
            c0Var.j(this.f33154a.d(), iE, iMin);
            this.f33154a.P(iE + iMin);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(c0 c0Var, int i10) {
            if (i10 < 19) {
                return;
            }
            this.f33157d = c0Var.J();
            this.f33158e = c0Var.J();
            c0Var.Q(11);
            this.f33159f = c0Var.J();
            this.f33160g = c0Var.J();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(c0 c0Var, int i10) {
            if (i10 % 5 != 2) {
                return;
            }
            c0Var.Q(2);
            Arrays.fill(this.f33155b, 0);
            int i11 = i10 / 5;
            for (int i12 = 0; i12 < i11; i12++) {
                int iD = c0Var.D();
                int iD2 = c0Var.D();
                int iD3 = c0Var.D();
                int iD4 = c0Var.D();
                double d10 = iD2;
                double d11 = iD3 - 128;
                double d12 = iD4 - 128;
                this.f33155b[iD] = (o0.p((int) ((d10 - (0.34414d * d12)) - (d11 * 0.71414d)), 0, 255) << 8) | (c0Var.D() << 24) | (o0.p((int) ((1.402d * d11) + d10), 0, 255) << 16) | o0.p((int) (d10 + (d12 * 1.772d)), 0, 255);
            }
            this.f33156c = true;
        }

        @Nullable
        public n3.b d() {
            int iD;
            if (this.f33157d == 0 || this.f33158e == 0 || this.f33161h == 0 || this.f33162i == 0 || this.f33154a.f() == 0 || this.f33154a.e() != this.f33154a.f() || !this.f33156c) {
                return null;
            }
            this.f33154a.P(0);
            int i10 = this.f33161h * this.f33162i;
            int[] iArr = new int[i10];
            int i11 = 0;
            while (i11 < i10) {
                int iD2 = this.f33154a.D();
                if (iD2 != 0) {
                    iD = i11 + 1;
                    iArr[i11] = this.f33155b[iD2];
                } else {
                    int iD3 = this.f33154a.D();
                    if (iD3 != 0) {
                        iD = ((iD3 & 64) == 0 ? iD3 & 63 : ((iD3 & 63) << 8) | this.f33154a.D()) + i11;
                        Arrays.fill(iArr, i11, iD, (iD3 & 128) == 0 ? 0 : this.f33155b[this.f33154a.D()]);
                    }
                }
                i11 = iD;
            }
            return new b.C0631b().f(Bitmap.createBitmap(iArr, this.f33161h, this.f33162i, Bitmap.Config.ARGB_8888)).k(this.f33159f / this.f33157d).l(0).h(this.f33160g / this.f33158e, 0).i(0).n(this.f33161h / this.f33157d).g(this.f33162i / this.f33158e).a();
        }

        public void h() {
            this.f33157d = 0;
            this.f33158e = 0;
            this.f33159f = 0;
            this.f33160g = 0;
            this.f33161h = 0;
            this.f33162i = 0;
            this.f33154a.L(0);
            this.f33156c = false;
        }
    }

    public a() {
        super("PgsDecoder");
        this.f33150o = new c0();
        this.f33151p = new c0();
        this.f33152q = new C0659a();
    }

    private void x(c0 c0Var) {
        if (c0Var.a() <= 0 || c0Var.h() != 120) {
            return;
        }
        if (this.f33153r == null) {
            this.f33153r = new Inflater();
        }
        if (o0.l0(c0Var, this.f33151p, this.f33153r)) {
            c0Var.N(this.f33151p.d(), this.f33151p.f());
        }
    }

    @Nullable
    private static n3.b y(c0 c0Var, C0659a c0659a) {
        int iF = c0Var.f();
        int iD = c0Var.D();
        int iJ = c0Var.J();
        int iE = c0Var.e() + iJ;
        n3.b bVarD = null;
        if (iE > iF) {
            c0Var.P(iF);
            return null;
        }
        if (iD != 128) {
            switch (iD) {
                case 20:
                    c0659a.g(c0Var, iJ);
                    break;
                case 21:
                    c0659a.e(c0Var, iJ);
                    break;
                case 22:
                    c0659a.f(c0Var, iJ);
                    break;
            }
        } else {
            bVarD = c0659a.d();
            c0659a.h();
        }
        c0Var.P(iE);
        return bVarD;
    }

    @Override // n3.h
    protected i v(byte[] bArr, int i10, boolean z10) throws k {
        this.f33150o.N(bArr, i10);
        x(this.f33150o);
        this.f33152q.h();
        ArrayList arrayList = new ArrayList();
        while (this.f33150o.a() >= 3) {
            n3.b bVarY = y(this.f33150o, this.f33152q);
            if (bVarY != null) {
                arrayList.add(bVarY);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }
}
