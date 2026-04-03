package b4;

import a4.o0;
import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import k2.o1;

/* JADX INFO: compiled from: VideoRendererEventListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface z {

    /* JADX INFO: compiled from: VideoRendererEventListener.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Handler f2218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final z f2219b;

        public a(@Nullable Handler handler, @Nullable z zVar) {
            this.f2218a = zVar != null ? (Handler) a4.a.e(handler) : null;
            this.f2219b = zVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(String str, long j10, long j11) {
            ((z) o0.j(this.f2219b)).onVideoDecoderInitialized(str, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(String str) {
            ((z) o0.j(this.f2219b)).onVideoDecoderReleased(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(n2.e eVar) {
            eVar.c();
            ((z) o0.j(this.f2219b)).i(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(int i10, long j10) {
            ((z) o0.j(this.f2219b)).onDroppedFrames(i10, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(n2.e eVar) {
            ((z) o0.j(this.f2219b)).c(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(o1 o1Var, n2.i iVar) {
            ((z) o0.j(this.f2219b)).k(o1Var);
            ((z) o0.j(this.f2219b)).d(o1Var, iVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(Object obj, long j10) {
            ((z) o0.j(this.f2219b)).onRenderedFirstFrame(obj, j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(long j10, int i10) {
            ((z) o0.j(this.f2219b)).onVideoFrameProcessingOffset(j10, i10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(Exception exc) {
            ((z) o0.j(this.f2219b)).onVideoCodecError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(b0 b0Var) {
            ((z) o0.j(this.f2219b)).f(b0Var);
        }

        public void A(final Object obj) {
            if (this.f2218a != null) {
                final long jElapsedRealtime = SystemClock.elapsedRealtime();
                this.f2218a.post(new Runnable() { // from class: b4.w
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2208a.w(obj, jElapsedRealtime);
                    }
                });
            }
        }

        public void B(final long j10, final int i10) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2200a.x(j10, i10);
                    }
                });
            }
        }

        public void C(final Exception exc) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.v
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2206a.y(exc);
                    }
                });
            }
        }

        public void D(final b0 b0Var) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2198a.z(b0Var);
                    }
                });
            }
        }

        public void k(final String str, final long j10, final long j11) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.y
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2214a.q(str, j10, j11);
                    }
                });
            }
        }

        public void l(final String str) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2196a.r(str);
                    }
                });
            }
        }

        public void m(final n2.e eVar) {
            eVar.c();
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2192a.s(eVar);
                    }
                });
            }
        }

        public void n(final int i10, final long j10) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.x
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2211a.t(i10, j10);
                    }
                });
            }
        }

        public void o(final n2.e eVar) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2194a.u(eVar);
                    }
                });
            }
        }

        public void p(final o1 o1Var, @Nullable final n2.i iVar) {
            Handler handler = this.f2218a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: b4.u
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f2203a.v(o1Var, iVar);
                    }
                });
            }
        }
    }

    void c(n2.e eVar);

    void d(o1 o1Var, @Nullable n2.i iVar);

    void f(b0 b0Var);

    void i(n2.e eVar);

    @Deprecated
    void k(o1 o1Var);

    void onDroppedFrames(int i10, long j10);

    void onRenderedFirstFrame(Object obj, long j10);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j10, long j11);

    void onVideoDecoderReleased(String str);

    void onVideoFrameProcessingOffset(long j10, int i10);
}
