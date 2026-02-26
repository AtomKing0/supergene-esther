package a4;

import k2.q2;

/* JADX INFO: compiled from: StandaloneMediaClock.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h0 implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d f167a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f168b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f169c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f170d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private q2 f171e = q2.f29419d;

    public h0(d dVar) {
        this.f167a = dVar;
    }

    public void a(long j10) {
        this.f169c = j10;
        if (this.f168b) {
            this.f170d = this.f167a.elapsedRealtime();
        }
    }

    @Override // a4.v
    public void b(q2 q2Var) {
        if (this.f168b) {
            a(getPositionUs());
        }
        this.f171e = q2Var;
    }

    public void c() {
        if (this.f168b) {
            return;
        }
        this.f170d = this.f167a.elapsedRealtime();
        this.f168b = true;
    }

    public void d() {
        if (this.f168b) {
            a(getPositionUs());
            this.f168b = false;
        }
    }

    @Override // a4.v
    public q2 getPlaybackParameters() {
        return this.f171e;
    }

    @Override // a4.v
    public long getPositionUs() {
        long j10 = this.f169c;
        if (!this.f168b) {
            return j10;
        }
        long jElapsedRealtime = this.f167a.elapsedRealtime() - this.f170d;
        q2 q2Var = this.f171e;
        return j10 + (q2Var.f29421a == 1.0f ? o0.w0(jElapsedRealtime) : q2Var.b(jElapsedRealtime));
    }
}
