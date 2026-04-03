package m2;

import androidx.annotation.CallSuper;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import m2.g;

/* JADX INFO: compiled from: BaseAudioProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class z implements g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected g.a f31425b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected g.a f31426c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private g.a f31427d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g.a f31428e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ByteBuffer f31429f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ByteBuffer f31430g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f31431h;

    public z() {
        ByteBuffer byteBuffer = g.f31273a;
        this.f31429f = byteBuffer;
        this.f31430g = byteBuffer;
        g.a aVar = g.a.f31274e;
        this.f31427d = aVar;
        this.f31428e = aVar;
        this.f31425b = aVar;
        this.f31426c = aVar;
    }

    @Override // m2.g
    public final g.a a(g.a aVar) throws g.b {
        this.f31427d = aVar;
        this.f31428e = c(aVar);
        return isActive() ? this.f31428e : g.a.f31274e;
    }

    protected final boolean b() {
        return this.f31430g.hasRemaining();
    }

    protected abstract g.a c(g.a aVar) throws g.b;

    @Override // m2.g
    public final void flush() {
        this.f31430g = g.f31273a;
        this.f31431h = false;
        this.f31425b = this.f31427d;
        this.f31426c = this.f31428e;
        d();
    }

    protected final ByteBuffer g(int i10) {
        if (this.f31429f.capacity() < i10) {
            this.f31429f = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        } else {
            this.f31429f.clear();
        }
        ByteBuffer byteBuffer = this.f31429f;
        this.f31430g = byteBuffer;
        return byteBuffer;
    }

    @Override // m2.g
    @CallSuper
    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer = this.f31430g;
        this.f31430g = g.f31273a;
        return byteBuffer;
    }

    @Override // m2.g
    public boolean isActive() {
        return this.f31428e != g.a.f31274e;
    }

    @Override // m2.g
    @CallSuper
    public boolean isEnded() {
        return this.f31431h && this.f31430g == g.f31273a;
    }

    @Override // m2.g
    public final void queueEndOfStream() {
        this.f31431h = true;
        e();
    }

    @Override // m2.g
    public final void reset() {
        flush();
        this.f31429f = g.f31273a;
        g.a aVar = g.a.f31274e;
        this.f31427d = aVar;
        this.f31428e = aVar;
        this.f31425b = aVar;
        this.f31426c = aVar;
        f();
    }

    protected void d() {
    }

    protected void e() {
    }

    protected void f() {
    }
}
