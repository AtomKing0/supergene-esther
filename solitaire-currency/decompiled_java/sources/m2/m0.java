package m2;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import m2.g;

/* JADX INFO: compiled from: SonicAudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m0 implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f31337b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f31338c = 1.0f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f31339d = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g.a f31340e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private g.a f31341f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private g.a f31342g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private g.a f31343h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f31344i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    private l0 f31345j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ByteBuffer f31346k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private ShortBuffer f31347l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ByteBuffer f31348m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private long f31349n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private long f31350o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private boolean f31351p;

    public m0() {
        g.a aVar = g.a.f31274e;
        this.f31340e = aVar;
        this.f31341f = aVar;
        this.f31342g = aVar;
        this.f31343h = aVar;
        ByteBuffer byteBuffer = g.f31273a;
        this.f31346k = byteBuffer;
        this.f31347l = byteBuffer.asShortBuffer();
        this.f31348m = byteBuffer;
        this.f31337b = -1;
    }

    @Override // m2.g
    public g.a a(g.a aVar) throws g.b {
        if (aVar.f31277c != 2) {
            throw new g.b(aVar);
        }
        int i10 = this.f31337b;
        if (i10 == -1) {
            i10 = aVar.f31275a;
        }
        this.f31340e = aVar;
        g.a aVar2 = new g.a(i10, aVar.f31276b, 2);
        this.f31341f = aVar2;
        this.f31344i = true;
        return aVar2;
    }

    public long b(long j10) {
        if (this.f31350o < 1024) {
            return (long) (((double) this.f31338c) * j10);
        }
        long jL = this.f31349n - ((long) ((l0) a4.a.e(this.f31345j)).l());
        int i10 = this.f31343h.f31275a;
        int i11 = this.f31342g.f31275a;
        return i10 == i11 ? a4.o0.F0(j10, jL, this.f31350o) : a4.o0.F0(j10, jL * ((long) i10), this.f31350o * ((long) i11));
    }

    public void c(float f10) {
        if (this.f31339d != f10) {
            this.f31339d = f10;
            this.f31344i = true;
        }
    }

    public void d(float f10) {
        if (this.f31338c != f10) {
            this.f31338c = f10;
            this.f31344i = true;
        }
    }

    @Override // m2.g
    public void flush() {
        if (isActive()) {
            g.a aVar = this.f31340e;
            this.f31342g = aVar;
            g.a aVar2 = this.f31341f;
            this.f31343h = aVar2;
            if (this.f31344i) {
                this.f31345j = new l0(aVar.f31275a, aVar.f31276b, this.f31338c, this.f31339d, aVar2.f31275a);
            } else {
                l0 l0Var = this.f31345j;
                if (l0Var != null) {
                    l0Var.i();
                }
            }
        }
        this.f31348m = g.f31273a;
        this.f31349n = 0L;
        this.f31350o = 0L;
        this.f31351p = false;
    }

    @Override // m2.g
    public ByteBuffer getOutput() {
        int iK;
        l0 l0Var = this.f31345j;
        if (l0Var != null && (iK = l0Var.k()) > 0) {
            if (this.f31346k.capacity() < iK) {
                ByteBuffer byteBufferOrder = ByteBuffer.allocateDirect(iK).order(ByteOrder.nativeOrder());
                this.f31346k = byteBufferOrder;
                this.f31347l = byteBufferOrder.asShortBuffer();
            } else {
                this.f31346k.clear();
                this.f31347l.clear();
            }
            l0Var.j(this.f31347l);
            this.f31350o += (long) iK;
            this.f31346k.limit(iK);
            this.f31348m = this.f31346k;
        }
        ByteBuffer byteBuffer = this.f31348m;
        this.f31348m = g.f31273a;
        return byteBuffer;
    }

    @Override // m2.g
    public boolean isActive() {
        return this.f31341f.f31275a != -1 && (Math.abs(this.f31338c - 1.0f) >= 1.0E-4f || Math.abs(this.f31339d - 1.0f) >= 1.0E-4f || this.f31341f.f31275a != this.f31340e.f31275a);
    }

    @Override // m2.g
    public boolean isEnded() {
        l0 l0Var;
        return this.f31351p && ((l0Var = this.f31345j) == null || l0Var.k() == 0);
    }

    @Override // m2.g
    public void queueEndOfStream() {
        l0 l0Var = this.f31345j;
        if (l0Var != null) {
            l0Var.s();
        }
        this.f31351p = true;
    }

    @Override // m2.g
    public void queueInput(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            l0 l0Var = (l0) a4.a.e(this.f31345j);
            ShortBuffer shortBufferAsShortBuffer = byteBuffer.asShortBuffer();
            int iRemaining = byteBuffer.remaining();
            this.f31349n += (long) iRemaining;
            l0Var.t(shortBufferAsShortBuffer);
            byteBuffer.position(byteBuffer.position() + iRemaining);
        }
    }

    @Override // m2.g
    public void reset() {
        this.f31338c = 1.0f;
        this.f31339d = 1.0f;
        g.a aVar = g.a.f31274e;
        this.f31340e = aVar;
        this.f31341f = aVar;
        this.f31342g = aVar;
        this.f31343h = aVar;
        ByteBuffer byteBuffer = g.f31273a;
        this.f31346k = byteBuffer;
        this.f31347l = byteBuffer.asShortBuffer();
        this.f31348m = byteBuffer;
        this.f31337b = -1;
        this.f31344i = false;
        this.f31345j = null;
        this.f31349n = 0L;
        this.f31350o = 0L;
        this.f31351p = false;
    }
}
