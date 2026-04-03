package k2;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DefaultMediaClock.java */
/* JADX INFO: loaded from: classes2.dex */
final class l implements a4.v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a4.h0 f29265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f29266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private a3 f29267c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private a4.v f29268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f29269e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f29270f;

    /* JADX INFO: compiled from: DefaultMediaClock.java */
    public interface a {
        void h(q2 q2Var);
    }

    public l(a aVar, a4.d dVar) {
        this.f29266b = aVar;
        this.f29265a = new a4.h0(dVar);
    }

    private boolean e(boolean z10) {
        a3 a3Var = this.f29267c;
        return a3Var == null || a3Var.isEnded() || (!this.f29267c.isReady() && (z10 || this.f29267c.hasReadStreamToEnd()));
    }

    private void i(boolean z10) {
        if (e(z10)) {
            this.f29269e = true;
            if (this.f29270f) {
                this.f29265a.c();
                return;
            }
            return;
        }
        a4.v vVar = (a4.v) a4.a.e(this.f29268d);
        long positionUs = vVar.getPositionUs();
        if (this.f29269e) {
            if (positionUs < this.f29265a.getPositionUs()) {
                this.f29265a.d();
                return;
            } else {
                this.f29269e = false;
                if (this.f29270f) {
                    this.f29265a.c();
                }
            }
        }
        this.f29265a.a(positionUs);
        q2 playbackParameters = vVar.getPlaybackParameters();
        if (playbackParameters.equals(this.f29265a.getPlaybackParameters())) {
            return;
        }
        this.f29265a.b(playbackParameters);
        this.f29266b.h(playbackParameters);
    }

    public void a(a3 a3Var) {
        if (a3Var == this.f29267c) {
            this.f29268d = null;
            this.f29267c = null;
            this.f29269e = true;
        }
    }

    @Override // a4.v
    public void b(q2 q2Var) {
        a4.v vVar = this.f29268d;
        if (vVar != null) {
            vVar.b(q2Var);
            q2Var = this.f29268d.getPlaybackParameters();
        }
        this.f29265a.b(q2Var);
    }

    public void c(a3 a3Var) throws q {
        a4.v vVar;
        a4.v mediaClock = a3Var.getMediaClock();
        if (mediaClock == null || mediaClock == (vVar = this.f29268d)) {
            return;
        }
        if (vVar != null) {
            throw q.i(new IllegalStateException("Multiple renderer media clocks enabled."));
        }
        this.f29268d = mediaClock;
        this.f29267c = a3Var;
        mediaClock.b(this.f29265a.getPlaybackParameters());
    }

    public void d(long j10) {
        this.f29265a.a(j10);
    }

    public void f() {
        this.f29270f = true;
        this.f29265a.c();
    }

    public void g() {
        this.f29270f = false;
        this.f29265a.d();
    }

    @Override // a4.v
    public q2 getPlaybackParameters() {
        a4.v vVar = this.f29268d;
        return vVar != null ? vVar.getPlaybackParameters() : this.f29265a.getPlaybackParameters();
    }

    @Override // a4.v
    public long getPositionUs() {
        return this.f29269e ? this.f29265a.getPositionUs() : ((a4.v) a4.a.e(this.f29268d)).getPositionUs();
    }

    public long h(boolean z10) {
        i(z10);
        return getPositionUs();
    }
}
