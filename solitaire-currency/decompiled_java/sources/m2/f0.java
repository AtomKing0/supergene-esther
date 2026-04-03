package m2;

import java.nio.ByteBuffer;
import m2.g;

/* JADX INFO: compiled from: FloatResamplingAudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class f0 extends z {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f31272i = Float.floatToIntBits(Float.NaN);

    f0() {
    }

    private static void h(int i10, ByteBuffer byteBuffer) {
        int iFloatToIntBits = Float.floatToIntBits((float) (((double) i10) * 4.656612875245797E-10d));
        if (iFloatToIntBits == f31272i) {
            iFloatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(iFloatToIntBits);
    }

    @Override // m2.z
    public g.a c(g.a aVar) throws g.b {
        int i10 = aVar.f31277c;
        if (a4.o0.n0(i10)) {
            return i10 != 4 ? new g.a(aVar.f31275a, aVar.f31276b, 4) : g.a.f31274e;
        }
        throw new g.b(aVar);
    }

    @Override // m2.g
    public void queueInput(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferG;
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        int i11 = this.f31425b.f31277c;
        if (i11 == 536870912) {
            byteBufferG = g((i10 / 3) * 4);
            while (iPosition < iLimit) {
                h(((byteBuffer.get(iPosition) & 255) << 8) | ((byteBuffer.get(iPosition + 1) & 255) << 16) | ((byteBuffer.get(iPosition + 2) & 255) << 24), byteBufferG);
                iPosition += 3;
            }
        } else {
            if (i11 != 805306368) {
                throw new IllegalStateException();
            }
            byteBufferG = g(i10);
            while (iPosition < iLimit) {
                h((byteBuffer.get(iPosition) & 255) | ((byteBuffer.get(iPosition + 1) & 255) << 8) | ((byteBuffer.get(iPosition + 2) & 255) << 16) | ((byteBuffer.get(iPosition + 3) & 255) << 24), byteBufferG);
                iPosition += 4;
            }
        }
        byteBuffer.position(byteBuffer.limit());
        byteBufferG.flip();
    }
}
