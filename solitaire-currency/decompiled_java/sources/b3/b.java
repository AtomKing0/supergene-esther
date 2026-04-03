package b3;

import a4.m0;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import b3.b;
import b3.l;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: AsynchronousMediaCodecAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
final class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f1939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final g f1940b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final e f1941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f1942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f1943e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f1944f;

    /* JADX INFO: renamed from: b3.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsynchronousMediaCodecAdapter.java */
    public static final class C0148b implements l.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final e5.u<HandlerThread> f1945a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final e5.u<HandlerThread> f1946b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f1947c;

        public C0148b(final int i10, boolean z10) {
            this(new e5.u() { // from class: b3.c
                @Override // e5.u
                public final Object get() {
                    return b.C0148b.e(i10);
                }
            }, new e5.u() { // from class: b3.d
                @Override // e5.u
                public final Object get() {
                    return b.C0148b.f(i10);
                }
            }, z10);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread e(int i10) {
            return new HandlerThread(b.g(i10));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i10) {
            return new HandlerThread(b.h(i10));
        }

        @Override // b3.l.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public b a(l.a aVar) throws Exception {
            MediaCodec mediaCodecCreateByCodecName;
            b bVar;
            String str = aVar.f1992a.f2000a;
            b bVar2 = null;
            try {
                m0.a("createCodec:" + str);
                mediaCodecCreateByCodecName = MediaCodec.createByCodecName(str);
                try {
                    bVar = new b(mediaCodecCreateByCodecName, this.f1945a.get(), this.f1946b.get(), this.f1947c);
                } catch (Exception e10) {
                    e = e10;
                }
            } catch (Exception e11) {
                e = e11;
                mediaCodecCreateByCodecName = null;
            }
            try {
                m0.c();
                bVar.j(aVar.f1993b, aVar.f1995d, aVar.f1996e, aVar.f1997f);
                return bVar;
            } catch (Exception e12) {
                e = e12;
                bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.release();
                } else if (mediaCodecCreateByCodecName != null) {
                    mediaCodecCreateByCodecName.release();
                }
                throw e;
            }
        }

        @VisibleForTesting
        C0148b(e5.u<HandlerThread> uVar, e5.u<HandlerThread> uVar2, boolean z10) {
            this.f1945a = uVar;
            this.f1946b = uVar2;
            this.f1947c = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String g(int i10) {
        return i(i10, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String h(int i10) {
        return i(i10, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String i(int i10, String str) {
        StringBuilder sb = new StringBuilder(str);
        if (i10 == 1) {
            sb.append("Audio");
        } else if (i10 == 2) {
            sb.append("Video");
        } else {
            sb.append("Unknown(");
            sb.append(i10);
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i10) {
        this.f1940b.h(this.f1939a);
        m0.a("configureCodec");
        this.f1939a.configure(mediaFormat, surface, mediaCrypto, i10);
        m0.c();
        this.f1941c.q();
        m0.a("startCodec");
        this.f1939a.start();
        m0.c();
        this.f1944f = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(l.c cVar, MediaCodec mediaCodec, long j10, long j11) {
        cVar.a(this, j10, j11);
    }

    private void l() {
        if (this.f1942d) {
            try {
                this.f1941c.r();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e10);
            }
        }
    }

    @Override // b3.l
    public void a(int i10, int i11, n2.c cVar, long j10, int i12) {
        this.f1941c.n(i10, i11, cVar, j10, i12);
    }

    @Override // b3.l
    public void b(final l.c cVar, Handler handler) {
        l();
        this.f1939a.setOnFrameRenderedListener(new MediaCodec.OnFrameRenderedListener() { // from class: b3.a
            @Override // android.media.MediaCodec.OnFrameRenderedListener
            public final void onFrameRendered(MediaCodec mediaCodec, long j10, long j11) {
                this.f1937a.k(cVar, mediaCodec, j10, j11);
            }
        }, handler);
    }

    @Override // b3.l
    public int dequeueInputBufferIndex() {
        return this.f1940b.c();
    }

    @Override // b3.l
    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.f1940b.d(bufferInfo);
    }

    @Override // b3.l
    public void flush() {
        this.f1941c.i();
        this.f1939a.flush();
        this.f1940b.e();
        this.f1939a.start();
    }

    @Override // b3.l
    @Nullable
    public ByteBuffer getInputBuffer(int i10) {
        return this.f1939a.getInputBuffer(i10);
    }

    @Override // b3.l
    @Nullable
    public ByteBuffer getOutputBuffer(int i10) {
        return this.f1939a.getOutputBuffer(i10);
    }

    @Override // b3.l
    public MediaFormat getOutputFormat() {
        return this.f1940b.g();
    }

    @Override // b3.l
    public boolean needsReconfiguration() {
        return false;
    }

    @Override // b3.l
    public void queueInputBuffer(int i10, int i11, int i12, long j10, int i13) {
        this.f1941c.m(i10, i11, i12, j10, i13);
    }

    @Override // b3.l
    public void release() {
        try {
            if (this.f1944f == 1) {
                this.f1941c.p();
                this.f1940b.o();
            }
            this.f1944f = 2;
        } finally {
            if (!this.f1943e) {
                this.f1939a.release();
                this.f1943e = true;
            }
        }
    }

    @Override // b3.l
    public void releaseOutputBuffer(int i10, boolean z10) {
        this.f1939a.releaseOutputBuffer(i10, z10);
    }

    @Override // b3.l
    public void setOutputSurface(Surface surface) {
        l();
        this.f1939a.setOutputSurface(surface);
    }

    @Override // b3.l
    public void setParameters(Bundle bundle) {
        l();
        this.f1939a.setParameters(bundle);
    }

    @Override // b3.l
    public void setVideoScalingMode(int i10) {
        l();
        this.f1939a.setVideoScalingMode(i10);
    }

    private b(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean z10) {
        this.f1939a = mediaCodec;
        this.f1940b = new g(handlerThread);
        this.f1941c = new e(mediaCodec, handlerThread2);
        this.f1942d = z10;
        this.f1944f = 0;
    }

    @Override // b3.l
    public void releaseOutputBuffer(int i10, long j10) {
        this.f1939a.releaseOutputBuffer(i10, j10);
    }
}
