package b3;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.io.IOException;
import java.nio.ByteBuffer;
import k2.o1;

/* JADX INFO: compiled from: MediaCodecAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {

    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f1992a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MediaFormat f1993b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o1 f1994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final Surface f1995d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public final MediaCrypto f1996e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f1997f;

        private a(n nVar, MediaFormat mediaFormat, o1 o1Var, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i10) {
            this.f1992a = nVar;
            this.f1993b = mediaFormat;
            this.f1994c = o1Var;
            this.f1995d = surface;
            this.f1996e = mediaCrypto;
            this.f1997f = i10;
        }

        public static a a(n nVar, MediaFormat mediaFormat, o1 o1Var, @Nullable MediaCrypto mediaCrypto) {
            return new a(nVar, mediaFormat, o1Var, null, mediaCrypto, 0);
        }

        public static a b(n nVar, MediaFormat mediaFormat, o1 o1Var, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new a(nVar, mediaFormat, o1Var, surface, mediaCrypto, 0);
        }
    }

    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public interface b {
        l a(a aVar) throws IOException;
    }

    /* JADX INFO: compiled from: MediaCodecAdapter.java */
    public interface c {
        void a(l lVar, long j10, long j11);
    }

    void a(int i10, int i11, n2.c cVar, long j10, int i12);

    @RequiresApi(23)
    void b(c cVar, Handler handler);

    int dequeueInputBufferIndex();

    int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo);

    void flush();

    @Nullable
    ByteBuffer getInputBuffer(int i10);

    @Nullable
    ByteBuffer getOutputBuffer(int i10);

    MediaFormat getOutputFormat();

    boolean needsReconfiguration();

    void queueInputBuffer(int i10, int i11, int i12, long j10, int i13);

    void release();

    @RequiresApi(21)
    void releaseOutputBuffer(int i10, long j10);

    void releaseOutputBuffer(int i10, boolean z10);

    @RequiresApi(23)
    void setOutputSurface(Surface surface);

    @RequiresApi(19)
    void setParameters(Bundle bundle);

    void setVideoScalingMode(int i10);
}
