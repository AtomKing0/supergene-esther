package p2;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;
import k2.o1;
import p2.e0;

/* JADX INFO: compiled from: DummyTrackOutput.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f32526a = new byte[4096];

    @Override // p2.e0
    public void b(a4.c0 c0Var, int i10, int i11) {
        c0Var.Q(i10);
    }

    @Override // p2.e0
    public /* synthetic */ int c(z3.h hVar, int i10, boolean z10) {
        return d0.a(this, hVar, i10, z10);
    }

    @Override // p2.e0
    public int d(z3.h hVar, int i10, boolean z10, int i11) throws IOException {
        int i12 = hVar.read(this.f32526a, 0, Math.min(this.f32526a.length, i10));
        if (i12 != -1) {
            return i12;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // p2.e0
    public /* synthetic */ void e(a4.c0 c0Var, int i10) {
        d0.b(this, c0Var, i10);
    }

    @Override // p2.e0
    public void f(o1 o1Var) {
    }

    @Override // p2.e0
    public void a(long j10, int i10, int i11, int i12, @Nullable e0.a aVar) {
    }
}
