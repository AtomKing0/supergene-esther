package b3;

import a4.m0;
import a4.o0;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b3.l;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: SynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f2068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private ByteBuffer[] f2069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private ByteBuffer[] f2070c;

    /* JADX INFO: compiled from: SynchronousMediaCodecAdapter.java */
    public static class b implements l.b {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [b3.x$a] */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        @Override // b3.l.b
        public l a(l.a aVar) throws Throwable {
            MediaCodec mediaCodecB;
            MediaCodec mediaCodec = 0;
            mediaCodec = 0;
            try {
                mediaCodecB = b(aVar);
            } catch (IOException e10) {
                e = e10;
            } catch (RuntimeException e11) {
                e = e11;
            }
            try {
                m0.a("configureCodec");
                mediaCodecB.configure(aVar.f1993b, aVar.f1995d, aVar.f1996e, aVar.f1997f);
                m0.c();
                m0.a("startCodec");
                mediaCodecB.start();
                m0.c();
                return new x(mediaCodecB);
            } catch (IOException | RuntimeException e12) {
                e = e12;
                mediaCodec = mediaCodecB;
                if (mediaCodec != 0) {
                    mediaCodec.release();
                }
                throw e;
            }
        }

        protected MediaCodec b(l.a aVar) throws IOException {
            a4.a.e(aVar.f1992a);
            String str = aVar.f1992a.f2000a;
            m0.a("createCodec:" + str);
            MediaCodec mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
            m0.c();
            return mediaCodecCreateByCodecName;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d(l.c cVar, MediaCodec mediaCodec, long j10, long j11) {
        cVar.a(this, j10, j11);
    }

    @Override // b3.l
    public void a(int i10, int i11, n2.c cVar, long j10, int i12) {
        this.f2068a.queueSecureInputBuffer(i10, i11, cVar.a(), j10, i12);
    }

    @Override // b3.l
    @RequiresApi(23)
    public void b(final l.c cVar, Handler handler) {
        this.f2068a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: b3.w
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
                this.f2066a.d(cVar, mediaCodec, j10, j11);
            }
        }, handler);
    }

    @Override // b3.l
    public int dequeueInputBufferIndex() {
        return this.f2068a.dequeueInputBuffer(0L);
    }

    @Override // b3.l
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int iDequeueOutputBuffer;
        do {
            iDequeueOutputBuffer = this.f2068a.dequeueOutputBuffer(bufferInfo, 0L);
            if (iDequeueOutputBuffer == -3 && o0.f214a < 21) {
                this.f2070c = this.f2068a.getOutputBuffers();
            }
        } while (iDequeueOutputBuffer == -3);
        return iDequeueOutputBuffer;
    }

    @Override // b3.l
    public void flush() {
        this.f2068a.flush();
    }

    @Override // b3.l
    @Nullable
    public ByteBuffer getInputBuffer(int i10) {
        return o0.f214a >= 21 ? this.f2068a.getInputBuffer(i10) : ((ByteBuffer[]) o0.j(this.f2069b))[i10];
    }

    @Override // b3.l
    @Nullable
    public ByteBuffer getOutputBuffer(int i10) {
        return o0.f214a >= 21 ? this.f2068a.getOutputBuffer(i10) : ((ByteBuffer[]) o0.j(this.f2070c))[i10];
    }

    @Override // b3.l
    public MediaFormat getOutputFormat() {
        return this.f2068a.getOutputFormat();
    }

    @Override // b3.l
    public boolean needsReconfiguration() {
        return false;
    }

    @Override // b3.l
    public void queueInputBuffer(int i10, int i11, int i12, long j10, int i13) {
        this.f2068a.queueInputBuffer(i10, i11, i12, j10, i13);
    }

    @Override // b3.l
    public void release() {
        this.f2069b = null;
        this.f2070c = null;
        this.f2068a.release();
    }

    @Override // b3.l
    public void releaseOutputBuffer(int i10, boolean z10) {
        this.f2068a.releaseOutputBuffer(i10, z10);
    }

    @Override // b3.l
    @RequiresApi(23)
    public void setOutputSurface(Surface surface) {
        this.f2068a.setOutputSurface(surface);
    }

    @Override // b3.l
    @RequiresApi(19)
    public void setParameters(Bundle bundle) {
        this.f2068a.setParameters(bundle);
    }

    @Override // b3.l
    public void setVideoScalingMode(int i10) {
        this.f2068a.setVideoScalingMode(i10);
    }

    private x(MediaCodec mediaCodec) {
        this.f2068a = mediaCodec;
        if (o0.f214a < 21) {
            this.f2069b = mediaCodec.getInputBuffers();
            this.f2070c = mediaCodec.getOutputBuffers();
        }
    }

    @Override // b3.l
    @RequiresApi(21)
    public void releaseOutputBuffer(int i10, long j10) {
        this.f2068a.releaseOutputBuffer(i10, j10);
    }
}
