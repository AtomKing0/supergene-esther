package m2;

import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;
import m2.g;

/* JADX INFO: compiled from: SilenceSkippingAudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k0 extends z {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final long f31299i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final long f31300j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final short f31301k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f31302l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f31303m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f31304n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private byte[] f31305o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f31306p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f31307q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private int f31308r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private boolean f31309s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private long f31310t;

    public k0() {
        this(150000L, 20000L, SilenceSkippingAudioProcessor.DEFAULT_SILENCE_THRESHOLD_LEVEL);
    }

    private int h(long j10) {
        return (int) ((j10 * ((long) this.f31425b.f31275a)) / 1000000);
    }

    private int i(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        do {
            iLimit -= 2;
            if (iLimit < byteBuffer.position()) {
                return byteBuffer.position();
            }
        } while (Math.abs((int) byteBuffer.getShort(iLimit)) <= this.f31301k);
        int i10 = this.f31302l;
        return ((iLimit / i10) * i10) + i10;
    }

    private int j(ByteBuffer byteBuffer) {
        for (int iPosition = byteBuffer.position(); iPosition < byteBuffer.limit(); iPosition += 2) {
            if (Math.abs((int) byteBuffer.getShort(iPosition)) > this.f31301k) {
                int i10 = this.f31302l;
                return i10 * (iPosition / i10);
            }
        }
        return byteBuffer.limit();
    }

    private void l(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        g(iRemaining).put(byteBuffer).flip();
        if (iRemaining > 0) {
            this.f31309s = true;
        }
    }

    private void m(byte[] bArr, int i10) {
        g(i10).put(bArr, 0, i10).flip();
        if (i10 > 0) {
            this.f31309s = true;
        }
    }

    private void n(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iJ = j(byteBuffer);
        int iPosition = iJ - byteBuffer.position();
        byte[] bArr = this.f31304n;
        int length = bArr.length;
        int i10 = this.f31307q;
        int i11 = length - i10;
        if (iJ < iLimit && iPosition < i11) {
            m(bArr, i10);
            this.f31307q = 0;
            this.f31306p = 0;
            return;
        }
        int iMin = Math.min(iPosition, i11);
        byteBuffer.limit(byteBuffer.position() + iMin);
        byteBuffer.get(this.f31304n, this.f31307q, iMin);
        int i12 = this.f31307q + iMin;
        this.f31307q = i12;
        byte[] bArr2 = this.f31304n;
        if (i12 == bArr2.length) {
            if (this.f31309s) {
                m(bArr2, this.f31308r);
                this.f31310t += (long) ((this.f31307q - (this.f31308r * 2)) / this.f31302l);
            } else {
                this.f31310t += (long) ((i12 - this.f31308r) / this.f31302l);
            }
            r(byteBuffer, this.f31304n, this.f31307q);
            this.f31307q = 0;
            this.f31306p = 2;
        }
        byteBuffer.limit(iLimit);
    }

    private void o(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        byteBuffer.limit(Math.min(iLimit, byteBuffer.position() + this.f31304n.length));
        int i10 = i(byteBuffer);
        if (i10 == byteBuffer.position()) {
            this.f31306p = 1;
        } else {
            byteBuffer.limit(i10);
            l(byteBuffer);
        }
        byteBuffer.limit(iLimit);
    }

    private void p(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit();
        int iJ = j(byteBuffer);
        byteBuffer.limit(iJ);
        this.f31310t += (long) (byteBuffer.remaining() / this.f31302l);
        r(byteBuffer, this.f31305o, this.f31308r);
        if (iJ < iLimit) {
            m(this.f31305o, this.f31308r);
            this.f31306p = 0;
            byteBuffer.limit(iLimit);
        }
    }

    private void r(ByteBuffer byteBuffer, byte[] bArr, int i10) {
        int iMin = Math.min(byteBuffer.remaining(), this.f31308r);
        int i11 = this.f31308r - iMin;
        System.arraycopy(bArr, i10 - i11, this.f31305o, 0, i11);
        byteBuffer.position(byteBuffer.limit() - iMin);
        byteBuffer.get(this.f31305o, i11, iMin);
    }

    @Override // m2.z
    public g.a c(g.a aVar) throws g.b {
        if (aVar.f31277c == 2) {
            return this.f31303m ? aVar : g.a.f31274e;
        }
        throw new g.b(aVar);
    }

    @Override // m2.z
    protected void d() {
        if (this.f31303m) {
            this.f31302l = this.f31425b.f31278d;
            int iH = h(this.f31299i) * this.f31302l;
            if (this.f31304n.length != iH) {
                this.f31304n = new byte[iH];
            }
            int iH2 = h(this.f31300j) * this.f31302l;
            this.f31308r = iH2;
            if (this.f31305o.length != iH2) {
                this.f31305o = new byte[iH2];
            }
        }
        this.f31306p = 0;
        this.f31310t = 0L;
        this.f31307q = 0;
        this.f31309s = false;
    }

    @Override // m2.z
    protected void e() {
        int i10 = this.f31307q;
        if (i10 > 0) {
            m(this.f31304n, i10);
        }
        if (this.f31309s) {
            return;
        }
        this.f31310t += (long) (this.f31308r / this.f31302l);
    }

    @Override // m2.z
    protected void f() {
        this.f31303m = false;
        this.f31308r = 0;
        byte[] bArr = a4.o0.f219f;
        this.f31304n = bArr;
        this.f31305o = bArr;
    }

    @Override // m2.z, m2.g
    public boolean isActive() {
        return this.f31303m;
    }

    public long k() {
        return this.f31310t;
    }

    public void q(boolean z10) {
        this.f31303m = z10;
    }

    @Override // m2.g
    public void queueInput(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !b()) {
            int i10 = this.f31306p;
            if (i10 == 0) {
                o(byteBuffer);
            } else if (i10 == 1) {
                n(byteBuffer);
            } else {
                if (i10 != 2) {
                    throw new IllegalStateException();
                }
                p(byteBuffer);
            }
        }
    }

    public k0(long j10, long j11, short s10) {
        a4.a.a(j11 <= j10);
        this.f31299i = j10;
        this.f31300j = j11;
        this.f31301k = s10;
        byte[] bArr = a4.o0.f219f;
        this.f31304n = bArr;
        this.f31305o = bArr;
    }
}
