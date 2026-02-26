package w2;

import a4.o0;
import a4.u;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import p2.b0;
import p2.c0;

/* JADX INFO: compiled from: IndexSeeker.java */
/* JADX INFO: loaded from: classes2.dex */
final class b implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f35328a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final u f35329b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final u f35330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f35331d;

    public b(long j10, long j11, long j12) {
        this.f35331d = j10;
        this.f35328a = j12;
        u uVar = new u();
        this.f35329b = uVar;
        u uVar2 = new u();
        this.f35330c = uVar2;
        uVar.a(0L);
        uVar2.a(j11);
    }

    public boolean a(long j10) {
        u uVar = this.f35329b;
        return j10 - uVar.b(uVar.c() - 1) < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US;
    }

    public void b(long j10, long j11) {
        if (a(j10)) {
            return;
        }
        this.f35329b.a(j10);
        this.f35330c.a(j11);
    }

    void c(long j10) {
        this.f35331d = j10;
    }

    @Override // w2.g
    public long getDataEndPosition() {
        return this.f35328a;
    }

    @Override // p2.b0
    public long getDurationUs() {
        return this.f35331d;
    }

    @Override // p2.b0
    public b0.a getSeekPoints(long j10) {
        int iF = o0.f(this.f35329b, j10, true, true);
        c0 c0Var = new c0(this.f35329b.b(iF), this.f35330c.b(iF));
        if (c0Var.f32449a == j10 || iF == this.f35329b.c() - 1) {
            return new b0.a(c0Var);
        }
        int i10 = iF + 1;
        return new b0.a(c0Var, new c0(this.f35329b.b(i10), this.f35330c.b(i10)));
    }

    @Override // w2.g
    public long getTimeUs(long j10) {
        return this.f35329b.b(o0.f(this.f35330c, j10, true, true));
    }

    @Override // p2.b0
    public boolean isSeekable() {
        return true;
    }
}
