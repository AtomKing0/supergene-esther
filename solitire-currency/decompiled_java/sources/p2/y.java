package p2;

import androidx.annotation.Nullable;
import h3.h;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: Id3Peeker.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.c0 f32550a = new a4.c0(10);

    @Nullable
    public c3.a a(m mVar, @Nullable h.a aVar) throws IOException {
        c3.a aVarE = null;
        int i10 = 0;
        while (true) {
            try {
                mVar.peekFully(this.f32550a.d(), 0, 10);
                this.f32550a.P(0);
                if (this.f32550a.G() != 4801587) {
                    break;
                }
                this.f32550a.Q(3);
                int iC = this.f32550a.C();
                int i11 = iC + 10;
                if (aVarE == null) {
                    byte[] bArr = new byte[i11];
                    System.arraycopy(this.f32550a.d(), 0, bArr, 0, 10);
                    mVar.peekFully(bArr, 10, iC);
                    aVarE = new h3.h(aVar).e(bArr, i11);
                } else {
                    mVar.advancePeekPosition(iC);
                }
                i10 += i11;
            } catch (EOFException unused) {
            }
        }
        mVar.resetPeekPosition();
        mVar.advancePeekPosition(i10);
        return aVarE;
    }
}
