package c4;

import a4.c0;
import a4.o0;
import androidx.annotation.Nullable;
import androidx.media3.common.MimeTypes;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import java.nio.ByteBuffer;
import k2.b3;
import k2.o1;
import k2.q;

/* JADX INFO: compiled from: CameraMotionRenderer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends k2.f {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n2.g f4507n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final c0 f4508o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private long f4509p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @Nullable
    private a f4510q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private long f4511r;

    public b() {
        super(6);
        this.f4507n = new n2.g(1);
        this.f4508o = new c0();
    }

    @Nullable
    private float[] x(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.f4508o.N(byteBuffer.array(), byteBuffer.limit());
        this.f4508o.P(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i10 = 0; i10 < 3; i10++) {
            fArr[i10] = Float.intBitsToFloat(this.f4508o.q());
        }
        return fArr;
    }

    private void y() {
        a aVar = this.f4510q;
        if (aVar != null) {
            aVar.onCameraMotionReset();
        }
    }

    @Override // k2.c3
    public int a(o1 o1Var) {
        return MimeTypes.APPLICATION_CAMERA_MOTION.equals(o1Var.f29347l) ? b3.a(4) : b3.a(0);
    }

    @Override // k2.a3, k2.c3
    public String getName() {
        return "CameraMotionRenderer";
    }

    @Override // k2.f, k2.v2.b
    public void handleMessage(int i10, @Nullable Object obj) throws q {
        if (i10 == 8) {
            this.f4510q = (a) obj;
        } else {
            super.handleMessage(i10, obj);
        }
    }

    @Override // k2.a3
    public boolean isEnded() {
        return hasReadStreamToEnd();
    }

    @Override // k2.a3
    public boolean isReady() {
        return true;
    }

    @Override // k2.f
    protected void n() {
        y();
    }

    @Override // k2.f
    protected void p(long j10, boolean z10) {
        this.f4511r = Long.MIN_VALUE;
        y();
    }

    @Override // k2.a3
    public void render(long j10, long j11) {
        while (!hasReadStreamToEnd() && this.f4511r < SilenceSkippingAudioProcessor.DEFAULT_MINIMUM_SILENCE_DURATION_US + j10) {
            this.f4507n.c();
            if (u(i(), this.f4507n, 0) != -4 || this.f4507n.h()) {
                return;
            }
            n2.g gVar = this.f4507n;
            this.f4511r = gVar.f31588e;
            if (this.f4510q != null && !gVar.g()) {
                this.f4507n.n();
                float[] fArrX = x((ByteBuffer) o0.j(this.f4507n.f31586c));
                if (fArrX != null) {
                    ((a) o0.j(this.f4510q)).onCameraMotion(this.f4511r - this.f4509p, fArrX);
                }
            }
        }
    }

    @Override // k2.f
    protected void t(o1[] o1VarArr, long j10, long j11) {
        this.f4509p = j11;
    }
}
