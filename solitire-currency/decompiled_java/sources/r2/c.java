package r2;

import a4.c0;
import androidx.media3.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: AviMainHeaderChunk.java */
/* JADX INFO: loaded from: classes2.dex */
final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f33276a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f33277b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f33278c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f33279d;

    private c(int i10, int i11, int i12, int i13) {
        this.f33276a = i10;
        this.f33277b = i11;
        this.f33278c = i12;
        this.f33279d = i13;
    }

    public static c b(c0 c0Var) {
        int iQ = c0Var.q();
        c0Var.Q(8);
        int iQ2 = c0Var.q();
        int iQ3 = c0Var.q();
        c0Var.Q(4);
        int iQ4 = c0Var.q();
        c0Var.Q(12);
        return new c(iQ, iQ2, iQ3, iQ4);
    }

    public boolean a() {
        return (this.f33277b & 16) == 16;
    }

    @Override // r2.a
    public int getType() {
        return AviExtractor.FOURCC_avih;
    }
}
