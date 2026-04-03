package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface Decoder<I, O, E extends DecoderException> {
    @Nullable
    I dequeueInputBuffer() throws DecoderException;

    @Nullable
    O dequeueOutputBuffer() throws DecoderException;

    void flush();

    String getName();

    void queueInputBuffer(I i10) throws DecoderException;

    void release();

    void setOutputStartTimeUs(long j10);
}
