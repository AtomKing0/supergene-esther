package k2;

import androidx.media3.common.C;
import androidx.media3.exoplayer.DefaultLoadControl;

/* JADX INFO: compiled from: DefaultLoadControl.java */
/* JADX INFO: loaded from: classes2.dex */
public class k implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final z3.p f29198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f29199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final long f29200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f29201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final long f29202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f29203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f29204g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final long f29205h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final boolean f29206i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f29207j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f29208k;

    public k() {
        this(new z3.p(true, 65536), 50000, 50000, 2500, 5000, -1, false, 0, false);
    }

    private static void b(int i10, int i11, String str, String str2) {
        a4.a.b(i10 >= i11, str + " cannot be less than " + str2);
    }

    private static int d(int i10) {
        switch (i10) {
            case -2:
                return 0;
            case -1:
            default:
                throw new IllegalArgumentException();
            case 0:
                return DefaultLoadControl.DEFAULT_MUXED_BUFFER_SIZE;
            case 1:
                return 13107200;
            case 2:
                return DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE;
            case 3:
            case 4:
            case 5:
            case 6:
                return 131072;
        }
    }

    private void e(boolean z10) {
        int i10 = this.f29203f;
        if (i10 == -1) {
            i10 = 13107200;
        }
        this.f29207j = i10;
        this.f29208k = false;
        if (z10) {
            this.f29198a.d();
        }
    }

    @Override // k2.u1
    public void a(a3[] a3VarArr, l3.e1 e1Var, x3.s[] sVarArr) {
        int iC = this.f29203f;
        if (iC == -1) {
            iC = c(a3VarArr, sVarArr);
        }
        this.f29207j = iC;
        this.f29198a.e(iC);
    }

    protected int c(a3[] a3VarArr, x3.s[] sVarArr) {
        int iD = 0;
        for (int i10 = 0; i10 < a3VarArr.length; i10++) {
            if (sVarArr[i10] != null) {
                iD += d(a3VarArr[i10].getTrackType());
            }
        }
        return Math.max(13107200, iD);
    }

    @Override // k2.u1
    public z3.b getAllocator() {
        return this.f29198a;
    }

    @Override // k2.u1
    public long getBackBufferDurationUs() {
        return this.f29205h;
    }

    @Override // k2.u1
    public void onPrepared() {
        e(false);
    }

    @Override // k2.u1
    public void onReleased() {
        e(true);
    }

    @Override // k2.u1
    public void onStopped() {
        e(true);
    }

    @Override // k2.u1
    public boolean retainBackBufferFromKeyframe() {
        return this.f29206i;
    }

    @Override // k2.u1
    public boolean shouldContinueLoading(long j10, long j11, float f10) {
        boolean z10 = true;
        boolean z11 = this.f29198a.c() >= this.f29207j;
        long jMin = this.f29199b;
        if (f10 > 1.0f) {
            jMin = Math.min(a4.o0.U(jMin, f10), this.f29200c);
        }
        if (j11 < Math.max(jMin, 500000L)) {
            if (!this.f29204g && z11) {
                z10 = false;
            }
            this.f29208k = z10;
            if (!z10 && j11 < 500000) {
                a4.t.i("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j11 >= this.f29200c || z11) {
            this.f29208k = false;
        }
        return this.f29208k;
    }

    @Override // k2.u1
    public boolean shouldStartPlayback(long j10, float f10, boolean z10, long j11) {
        long jZ = a4.o0.Z(j10, f10);
        long jMin = z10 ? this.f29202e : this.f29201d;
        if (j11 != C.TIME_UNSET) {
            jMin = Math.min(j11 / 2, jMin);
        }
        return jMin <= 0 || jZ >= jMin || (!this.f29204g && this.f29198a.c() >= this.f29207j);
    }

    protected k(z3.p pVar, int i10, int i11, int i12, int i13, int i14, boolean z10, int i15, boolean z11) {
        b(i12, 0, "bufferForPlaybackMs", "0");
        b(i13, 0, "bufferForPlaybackAfterRebufferMs", "0");
        b(i10, i12, "minBufferMs", "bufferForPlaybackMs");
        b(i10, i13, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        b(i11, i10, "maxBufferMs", "minBufferMs");
        b(i15, 0, "backBufferDurationMs", "0");
        this.f29198a = pVar;
        this.f29199b = a4.o0.w0(i10);
        this.f29200c = a4.o0.w0(i11);
        this.f29201d = a4.o0.w0(i12);
        this.f29202e = a4.o0.w0(i13);
        this.f29203f = i14;
        this.f29207j = i14 == -1 ? 13107200 : i14;
        this.f29204g = z10;
        this.f29205h = a4.o0.w0(i15);
        this.f29206i = z11;
    }
}
