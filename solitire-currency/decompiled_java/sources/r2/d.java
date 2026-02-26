package r2;

import a4.c0;
import a4.o0;
import a4.t;
import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: AviStreamHeaderChunk.java */
/* JADX INFO: loaded from: classes2.dex */
final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f33284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f33285f;

    private d(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f33280a = i10;
        this.f33281b = i11;
        this.f33282c = i12;
        this.f33283d = i13;
        this.f33284e = i14;
        this.f33285f = i15;
    }

    public static d c(c0 c0Var) {
        int iQ = c0Var.q();
        c0Var.Q(12);
        int iQ2 = c0Var.q();
        int iQ3 = c0Var.q();
        int iQ4 = c0Var.q();
        c0Var.Q(4);
        int iQ5 = c0Var.q();
        int iQ6 = c0Var.q();
        c0Var.Q(8);
        return new d(iQ, iQ2, iQ3, iQ4, iQ5, iQ6);
    }

    public long a() {
        return o0.F0(this.f33284e, ((long) this.f33282c) * 1000000, this.f33283d);
    }

    public int b() {
        int i10 = this.f33280a;
        if (i10 == 1935960438) {
            return 2;
        }
        if (i10 == 1935963489) {
            return 1;
        }
        if (i10 == 1937012852) {
            return 3;
        }
        t.i("AviStreamHeaderChunk", "Found unsupported streamType fourCC: " + Integer.toHexString(this.f33280a));
        return -1;
    }

    @Override // r2.a
    public int getType() {
        return AviExtractor.FOURCC_strh;
    }
}
