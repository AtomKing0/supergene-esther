package m2;

import java.nio.ByteBuffer;
import m2.g;

/* JADX INFO: compiled from: TrimmingAudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
final class n0 extends z {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f31354i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f31355j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f31356k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f31357l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f31358m = a4.o0.f219f;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f31359n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f31360o;

    @Override // m2.z
    public g.a c(g.a aVar) throws g.b {
        if (aVar.f31277c != 2) {
            throw new g.b(aVar);
        }
        this.f31356k = true;
        return (this.f31354i == 0 && this.f31355j == 0) ? g.a.f31274e : aVar;
    }

    @Override // m2.z
    protected void d() {
        if (this.f31356k) {
            this.f31356k = false;
            int i10 = this.f31355j;
            int i11 = this.f31425b.f31278d;
            this.f31358m = new byte[i10 * i11];
            this.f31357l = this.f31354i * i11;
        }
        this.f31359n = 0;
    }

    @Override // m2.z
    protected void e() {
        if (this.f31356k) {
            int i10 = this.f31359n;
            if (i10 > 0) {
                this.f31360o += (long) (i10 / this.f31425b.f31278d);
            }
            this.f31359n = 0;
        }
    }

    @Override // m2.z
    protected void f() {
        this.f31358m = a4.o0.f219f;
    }

    @Override // m2.z, m2.g
    public ByteBuffer getOutput() {
        int i10;
        if (super.isEnded() && (i10 = this.f31359n) > 0) {
            g(i10).put(this.f31358m, 0, this.f31359n).flip();
            this.f31359n = 0;
        }
        return super.getOutput();
    }

    public long h() {
        return this.f31360o;
    }

    public void i() {
        this.f31360o = 0L;
    }

    @Override // m2.z, m2.g
    public boolean isEnded() {
        return super.isEnded() && this.f31359n == 0;
    }

    public void j(int i10, int i11) {
        this.f31354i = i10;
        this.f31355j = i11;
    }

    @Override // m2.g
    public void queueInput(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit();
        int i10 = iLimit - iPosition;
        if (i10 == 0) {
            return;
        }
        int iMin = Math.min(i10, this.f31357l);
        this.f31360o += (long) (iMin / this.f31425b.f31278d);
        this.f31357l -= iMin;
        byteBuffer.position(iPosition + iMin);
        if (this.f31357l > 0) {
            return;
        }
        int i11 = i10 - iMin;
        int length = (this.f31359n + i11) - this.f31358m.length;
        ByteBuffer byteBufferG = g(length);
        int iP = a4.o0.p(length, 0, this.f31359n);
        byteBufferG.put(this.f31358m, 0, iP);
        int iP2 = a4.o0.p(length - iP, 0, i11);
        byteBuffer.limit(byteBuffer.position() + iP2);
        byteBufferG.put(byteBuffer);
        byteBuffer.limit(iLimit);
        int i12 = i11 - iP2;
        int i13 = this.f31359n - iP;
        this.f31359n = i13;
        byte[] bArr = this.f31358m;
        System.arraycopy(bArr, iP, bArr, 0, i13);
        byteBuffer.get(this.f31358m, this.f31359n, i12);
        this.f31359n += i12;
        byteBufferG.flip();
    }
}
