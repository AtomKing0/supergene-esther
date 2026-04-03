package n2;

import a4.o0;

/* JADX INFO: compiled from: DecoderCounters.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f31573a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f31574b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f31575c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f31576d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f31577e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f31578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f31579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f31580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f31581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f31582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f31583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f31584l;

    private void b(long j10, int i10) {
        this.f31583k += j10;
        this.f31584l += i10;
    }

    public void a(long j10) {
        b(j10, 1);
    }

    public synchronized void c() {
    }

    public String toString() {
        return o0.z("DecoderCounters {\n decoderInits=%s,\n decoderReleases=%s\n queuedInputBuffers=%s\n skippedInputBuffers=%s\n renderedOutputBuffers=%s\n skippedOutputBuffers=%s\n droppedBuffers=%s\n droppedInputBuffers=%s\n maxConsecutiveDroppedBuffers=%s\n droppedToKeyframeEvents=%s\n totalVideoFrameProcessingOffsetUs=%s\n videoFrameProcessingOffsetCount=%s\n}", Integer.valueOf(this.f31573a), Integer.valueOf(this.f31574b), Integer.valueOf(this.f31575c), Integer.valueOf(this.f31576d), Integer.valueOf(this.f31577e), Integer.valueOf(this.f31578f), Integer.valueOf(this.f31579g), Integer.valueOf(this.f31580h), Integer.valueOf(this.f31581i), Integer.valueOf(this.f31582j), Long.valueOf(this.f31583k), Integer.valueOf(this.f31584l));
    }
}
