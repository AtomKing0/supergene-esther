package androidx.media3.exoplayer.offline;

import androidx.media3.common.util.UnstableApi;
import java.io.Closeable;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public interface DownloadCursor extends Closeable {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();

    int getCount();

    Download getDownload();

    int getPosition();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i10);

    boolean moveToPrevious();
}
