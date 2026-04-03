package z2;

import a4.l0;
import a4.o0;
import androidx.core.view.InputDeviceCompat;
import z2.i0;

/* JADX INFO: compiled from: SectionReader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c0 implements i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b0 f37036a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a4.c0 f37037b = new a4.c0(32);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f37038c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f37039d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f37040e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f37041f;

    public c0(b0 b0Var) {
        this.f37036a = b0Var;
    }

    @Override // z2.i0
    public void a(a4.c0 c0Var, int i10) {
        boolean z10 = (i10 & 1) != 0;
        int iE = z10 ? c0Var.e() + c0Var.D() : -1;
        if (this.f37041f) {
            if (!z10) {
                return;
            }
            this.f37041f = false;
            c0Var.P(iE);
            this.f37039d = 0;
        }
        while (c0Var.a() > 0) {
            int i11 = this.f37039d;
            if (i11 < 3) {
                if (i11 == 0) {
                    int iD = c0Var.D();
                    c0Var.P(c0Var.e() - 1);
                    if (iD == 255) {
                        this.f37041f = true;
                        return;
                    }
                }
                int iMin = Math.min(c0Var.a(), 3 - this.f37039d);
                c0Var.j(this.f37037b.d(), this.f37039d, iMin);
                int i12 = this.f37039d + iMin;
                this.f37039d = i12;
                if (i12 == 3) {
                    this.f37037b.P(0);
                    this.f37037b.O(3);
                    this.f37037b.Q(1);
                    int iD2 = this.f37037b.D();
                    int iD3 = this.f37037b.D();
                    this.f37040e = (iD2 & 128) != 0;
                    this.f37038c = (((iD2 & 15) << 8) | iD3) + 3;
                    int iB = this.f37037b.b();
                    int i13 = this.f37038c;
                    if (iB < i13) {
                        this.f37037b.c(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i13, this.f37037b.b() * 2)));
                    }
                }
            } else {
                int iMin2 = Math.min(c0Var.a(), this.f37038c - this.f37039d);
                c0Var.j(this.f37037b.d(), this.f37039d, iMin2);
                int i14 = this.f37039d + iMin2;
                this.f37039d = i14;
                int i15 = this.f37038c;
                if (i14 != i15) {
                    continue;
                } else {
                    if (!this.f37040e) {
                        this.f37037b.O(i15);
                    } else {
                        if (o0.r(this.f37037b.d(), 0, this.f37038c, -1) != 0) {
                            this.f37041f = true;
                            return;
                        }
                        this.f37037b.O(this.f37038c - 4);
                    }
                    this.f37037b.P(0);
                    this.f37036a.a(this.f37037b);
                    this.f37039d = 0;
                }
            }
        }
    }

    @Override // z2.i0
    public void b(l0 l0Var, p2.n nVar, i0.d dVar) {
        this.f37036a.b(l0Var, nVar, dVar);
        this.f37041f = true;
    }

    @Override // z2.i0
    public void seek() {
        this.f37041f = true;
    }
}
