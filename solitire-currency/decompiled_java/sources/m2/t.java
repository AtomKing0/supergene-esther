package m2;

import android.os.Handler;
import androidx.annotation.Nullable;
import k2.o1;

/* JADX INFO: compiled from: AudioRendererEventListener.java */
/* JADX INFO: loaded from: classes2.dex */
public interface t {

    /* JADX INFO: compiled from: AudioRendererEventListener.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private final Handler f31375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        private final t f31376b;

        public a(@Nullable Handler handler, @Nullable t tVar) {
            this.f31375a = tVar != null ? (Handler) a4.a.e(handler) : null;
            this.f31376b = tVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void A(int i10, long j10, long j11) {
            ((t) a4.o0.j(this.f31376b)).onAudioUnderrun(i10, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void r(Exception exc) {
            ((t) a4.o0.j(this.f31376b)).onAudioCodecError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void s(Exception exc) {
            ((t) a4.o0.j(this.f31376b)).onAudioSinkError(exc);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void t(String str, long j10, long j11) {
            ((t) a4.o0.j(this.f31376b)).onAudioDecoderInitialized(str, j10, j11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void u(String str) {
            ((t) a4.o0.j(this.f31376b)).onAudioDecoderReleased(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void v(n2.e eVar) {
            eVar.c();
            ((t) a4.o0.j(this.f31376b)).b(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void w(n2.e eVar) {
            ((t) a4.o0.j(this.f31376b)).g(eVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void x(o1 o1Var, n2.i iVar) {
            ((t) a4.o0.j(this.f31376b)).h(o1Var);
            ((t) a4.o0.j(this.f31376b)).e(o1Var, iVar);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void y(long j10) {
            ((t) a4.o0.j(this.f31376b)).onAudioPositionAdvancing(j10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void z(boolean z10) {
            ((t) a4.o0.j(this.f31376b)).onSkipSilenceEnabledChanged(z10);
        }

        public void B(final long j10) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31311a.y(j10);
                    }
                });
            }
        }

        public void C(final boolean z10) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31369a.z(z10);
                    }
                });
            }
        }

        public void D(final int i10, final long j10, final long j11) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.s
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31371a.A(i10, j10, j11);
                    }
                });
            }
        }

        public void k(final Exception exc) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31363a.r(exc);
                    }
                });
            }
        }

        public void l(final Exception exc) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.o
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31361a.s(exc);
                    }
                });
            }
        }

        public void m(final String str, final long j10, final long j11) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.q
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31365a.t(str, j10, j11);
                    }
                });
            }
        }

        public void n(final String str) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.j
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31294a.u(str);
                    }
                });
            }
        }

        public void o(final n2.e eVar) {
            eVar.c();
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31335a.v(eVar);
                    }
                });
            }
        }

        public void p(final n2.e eVar) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31352a.w(eVar);
                    }
                });
            }
        }

        public void q(final o1 o1Var, @Nullable final n2.i iVar) {
            Handler handler = this.f31375a;
            if (handler != null) {
                handler.post(new Runnable() { // from class: m2.k
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f31296a.x(o1Var, iVar);
                    }
                });
            }
        }
    }

    void b(n2.e eVar);

    void e(o1 o1Var, @Nullable n2.i iVar);

    void g(n2.e eVar);

    @Deprecated
    void h(o1 o1Var);

    void onAudioCodecError(Exception exc);

    void onAudioDecoderInitialized(String str, long j10, long j11);

    void onAudioDecoderReleased(String str);

    void onAudioPositionAdvancing(long j10);

    void onAudioSinkError(Exception exc);

    void onAudioUnderrun(int i10, long j10, long j11);

    void onSkipSilenceEnabledChanged(boolean z10);
}
