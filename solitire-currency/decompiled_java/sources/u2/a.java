package u2;

import a4.c0;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.MimeTypes;
import c3.a;
import java.io.IOException;
import k2.o1;
import p2.a0;
import p2.b0;
import p2.l;
import p2.m;
import p2.n;
import x2.k;

/* JADX INFO: compiled from: JpegExtractor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private n f34496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f34497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f34498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f34499e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private i3.b f34501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private m f34502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private c f34503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private k f34504j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c0 f34495a = new c0(6);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f34500f = -1;

    private void d(m mVar) throws IOException {
        this.f34495a.L(2);
        mVar.peekFully(this.f34495a.d(), 0, 2);
        mVar.advancePeekPosition(this.f34495a.J() - 2);
    }

    private void e() {
        g(new a.b[0]);
        ((n) a4.a.e(this.f34496b)).endTracks();
        this.f34496b.h(new b0.b(C.TIME_UNSET));
        this.f34497c = 6;
    }

    @Nullable
    private static i3.b f(String str, long j10) throws IOException {
        b bVarA;
        if (j10 == -1 || (bVarA = e.a(str)) == null) {
            return null;
        }
        return bVarA.a(j10);
    }

    private void g(a.b... bVarArr) {
        ((n) a4.a.e(this.f34496b)).track(1024, 4).f(new o1.b().K(MimeTypes.IMAGE_JPEG).X(new c3.a(bVarArr)).E());
    }

    private int h(m mVar) throws IOException {
        this.f34495a.L(2);
        mVar.peekFully(this.f34495a.d(), 0, 2);
        return this.f34495a.J();
    }

    private void i(m mVar) throws IOException {
        this.f34495a.L(2);
        mVar.readFully(this.f34495a.d(), 0, 2);
        int iJ = this.f34495a.J();
        this.f34498d = iJ;
        if (iJ == 65498) {
            if (this.f34500f != -1) {
                this.f34497c = 4;
                return;
            } else {
                e();
                return;
            }
        }
        if ((iJ < 65488 || iJ > 65497) && iJ != 65281) {
            this.f34497c = 1;
        }
    }

    private void j(m mVar) throws IOException {
        String strX;
        if (this.f34498d == 65505) {
            c0 c0Var = new c0(this.f34499e);
            mVar.readFully(c0Var.d(), 0, this.f34499e);
            if (this.f34501g == null && "http://ns.adobe.com/xap/1.0/".equals(c0Var.x()) && (strX = c0Var.x()) != null) {
                i3.b bVarF = f(strX, mVar.getLength());
                this.f34501g = bVarF;
                if (bVarF != null) {
                    this.f34500f = bVarF.f26577d;
                }
            }
        } else {
            mVar.skipFully(this.f34499e);
        }
        this.f34497c = 0;
    }

    private void k(m mVar) throws IOException {
        this.f34495a.L(2);
        mVar.readFully(this.f34495a.d(), 0, 2);
        this.f34499e = this.f34495a.J() - 2;
        this.f34497c = 2;
    }

    private void l(m mVar) throws IOException {
        if (!mVar.peekFully(this.f34495a.d(), 0, 1, true)) {
            e();
            return;
        }
        mVar.resetPeekPosition();
        if (this.f34504j == null) {
            this.f34504j = new k();
        }
        c cVar = new c(mVar, this.f34500f);
        this.f34503i = cVar;
        if (!this.f34504j.c(cVar)) {
            e();
        } else {
            this.f34504j.b(new d(this.f34500f, (n) a4.a.e(this.f34496b)));
            m();
        }
    }

    private void m() {
        g((a.b) a4.a.e(this.f34501g));
        this.f34497c = 5;
    }

    @Override // p2.l
    public int a(m mVar, a0 a0Var) throws IOException {
        int i10 = this.f34497c;
        if (i10 == 0) {
            i(mVar);
            return 0;
        }
        if (i10 == 1) {
            k(mVar);
            return 0;
        }
        if (i10 == 2) {
            j(mVar);
            return 0;
        }
        if (i10 == 4) {
            long position = mVar.getPosition();
            long j10 = this.f34500f;
            if (position != j10) {
                a0Var.f32443a = j10;
                return 1;
            }
            l(mVar);
            return 0;
        }
        if (i10 != 5) {
            if (i10 == 6) {
                return -1;
            }
            throw new IllegalStateException();
        }
        if (this.f34503i == null || mVar != this.f34502h) {
            this.f34502h = mVar;
            this.f34503i = new c(mVar, this.f34500f);
        }
        int iA = ((k) a4.a.e(this.f34504j)).a(this.f34503i, a0Var);
        if (iA == 1) {
            a0Var.f32443a += this.f34500f;
        }
        return iA;
    }

    @Override // p2.l
    public void b(n nVar) {
        this.f34496b = nVar;
    }

    @Override // p2.l
    public boolean c(m mVar) throws IOException {
        if (h(mVar) != 65496) {
            return false;
        }
        int iH = h(mVar);
        this.f34498d = iH;
        if (iH == 65504) {
            d(mVar);
            this.f34498d = h(mVar);
        }
        if (this.f34498d != 65505) {
            return false;
        }
        mVar.advancePeekPosition(2);
        this.f34495a.L(6);
        mVar.peekFully(this.f34495a.d(), 0, 6);
        return this.f34495a.F() == 1165519206 && this.f34495a.J() == 0;
    }

    @Override // p2.l
    public void release() {
        k kVar = this.f34504j;
        if (kVar != null) {
            kVar.release();
        }
    }

    @Override // p2.l
    public void seek(long j10, long j11) {
        if (j10 == 0) {
            this.f34497c = 0;
            this.f34504j = null;
        } else if (this.f34497c == 5) {
            ((k) a4.a.e(this.f34504j)).seek(j10, j11);
        }
    }
}
