package androidx.media3.exoplayer.mediacodec;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.media3.decoder.CryptoInfo;

/* JADX INFO: loaded from: classes2.dex */
interface MediaCodecBufferEnqueuer {
    void flush();

    void maybeThrowException();

    void queueInputBuffer(int i10, int i11, int i12, long j10, int i13);

    void queueSecureInputBuffer(int i10, int i11, CryptoInfo cryptoInfo, long j10, int i12);

    @RequiresApi(19)
    void setParameters(Bundle bundle);

    void shutdown();

    void start();

    void waitUntilQueueingComplete() throws InterruptedException;
}
