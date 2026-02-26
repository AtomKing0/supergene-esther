package m2;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import m2.g;

/* JADX INFO: compiled from: ChannelMappingAudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class a0 extends z {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private int[] f31147i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private int[] f31148j;

    a0() {
    }

    @Override // m2.z
    public g.a c(g.a aVar) throws g.b {
        int[] iArr = this.f31147i;
        if (iArr == null) {
            return g.a.f31274e;
        }
        if (aVar.f31277c != 2) {
            throw new g.b(aVar);
        }
        boolean z10 = aVar.f31276b != iArr.length;
        int i10 = 0;
        while (i10 < iArr.length) {
            int i11 = iArr[i10];
            if (i11 >= aVar.f31276b) {
                throw new g.b(aVar);
            }
            z10 |= i11 != i10;
            i10++;
        }
        return z10 ? new g.a(aVar.f31275a, iArr.length, 2) : g.a.f31274e;
    }

    @Override // m2.z
    protected void d() {
        this.f31148j = this.f31147i;
    }

    @Override // m2.z
    protected void f() {
        this.f31148j = null;
        this.f31147i = null;
    }

    public void h(@Nullable int[] iArr) {
        this.f31147i = iArr;
    }

    @Override // m2.g
    public void queueInput(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) a4.a.e(this.f31148j);
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        ByteBuffer byteBufferG = g(((iLimit - iPosition) / this.f31425b.f31278d) * this.f31426c.f31278d);
        while (iPosition < iLimit) {
            for (int i10 : iArr) {
                byteBufferG.putShort(byteBuffer.getShort((i10 * 2) + iPosition));
            }
            iPosition += this.f31425b.f31278d;
        }
        byteBuffer.position(iLimit);
        byteBufferG.flip();
    }
}
