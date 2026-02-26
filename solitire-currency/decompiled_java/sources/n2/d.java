package n2;

import androidx.annotation.Nullable;
import n2.f;

/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d<I, O, E extends f> {
    @Nullable
    I dequeueInputBuffer() throws f;

    @Nullable
    O dequeueOutputBuffer() throws f;

    void flush();

    void queueInputBuffer(I i10) throws f;

    void release();
}
