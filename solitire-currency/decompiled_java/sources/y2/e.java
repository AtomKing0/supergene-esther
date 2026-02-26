package y2;

import a4.c0;
import androidx.media3.extractor.ogg.OggPageHeader;
import java.io.IOException;
import java.util.Arrays;
import p2.m;
import p2.o;

/* JADX INFO: compiled from: OggPacket.java */
/* JADX INFO: loaded from: classes2.dex */
final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f36457a = new f();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c0 f36458b = new c0(new byte[OggPageHeader.MAX_PAGE_PAYLOAD], 0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36459c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f36460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f36461e;

    e() {
    }

    private int a(int i10) {
        int i11;
        int i12 = 0;
        this.f36460d = 0;
        do {
            int i13 = this.f36460d;
            int i14 = i10 + i13;
            f fVar = this.f36457a;
            if (i14 >= fVar.f36468g) {
                break;
            }
            int[] iArr = fVar.f36471j;
            this.f36460d = i13 + 1;
            i11 = iArr[i13 + i10];
            i12 += i11;
        } while (i11 == 255);
        return i12;
    }

    public f b() {
        return this.f36457a;
    }

    public c0 c() {
        return this.f36458b;
    }

    public boolean d(m mVar) throws IOException {
        int i10;
        a4.a.g(mVar != null);
        if (this.f36461e) {
            this.f36461e = false;
            this.f36458b.L(0);
        }
        while (!this.f36461e) {
            if (this.f36459c < 0) {
                if (!this.f36457a.c(mVar) || !this.f36457a.a(mVar, true)) {
                    return false;
                }
                f fVar = this.f36457a;
                int iA = fVar.f36469h;
                if ((fVar.f36463b & 1) == 1 && this.f36458b.f() == 0) {
                    iA += a(0);
                    i10 = this.f36460d + 0;
                } else {
                    i10 = 0;
                }
                if (!o.e(mVar, iA)) {
                    return false;
                }
                this.f36459c = i10;
            }
            int iA2 = a(this.f36459c);
            int i11 = this.f36459c + this.f36460d;
            if (iA2 > 0) {
                c0 c0Var = this.f36458b;
                c0Var.c(c0Var.f() + iA2);
                if (!o.d(mVar, this.f36458b.d(), this.f36458b.f(), iA2)) {
                    return false;
                }
                c0 c0Var2 = this.f36458b;
                c0Var2.O(c0Var2.f() + iA2);
                this.f36461e = this.f36457a.f36471j[i11 + (-1)] != 255;
            }
            if (i11 == this.f36457a.f36468g) {
                i11 = -1;
            }
            this.f36459c = i11;
        }
        return true;
    }

    public void e() {
        this.f36457a.b();
        this.f36458b.L(0);
        this.f36459c = -1;
        this.f36461e = false;
    }

    public void f() {
        if (this.f36458b.d().length == 65025) {
            return;
        }
        c0 c0Var = this.f36458b;
        c0Var.N(Arrays.copyOf(c0Var.d(), Math.max(OggPageHeader.MAX_PAGE_PAYLOAD, this.f36458b.f())), this.f36458b.f());
    }
}
