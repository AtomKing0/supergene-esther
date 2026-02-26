package androidx.media3.exoplayer.source.mediaparser;

import android.annotation.SuppressLint;
import android.media.MediaParser;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.DataReader;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
@SuppressLint({"Override"})
@UnstableApi
public final class InputReaderAdapterV30 implements MediaParser.SeekableInputReader {
    private long currentPosition;

    @Nullable
    private DataReader dataReader;
    private long lastSeekPosition;
    private long resourceLength;

    public long getAndResetSeekPosition() {
        long j10 = this.lastSeekPosition;
        this.lastSeekPosition = -1L;
        return j10;
    }

    @Override // android.media.MediaParser.InputReader
    public long getLength() {
        return this.resourceLength;
    }

    @Override // android.media.MediaParser.InputReader
    public long getPosition() {
        return this.currentPosition;
    }

    @Override // android.media.MediaParser.InputReader
    public int read(byte[] bArr, int i10, int i11) throws IOException {
        int i12 = ((DataReader) Util.castNonNull(this.dataReader)).read(bArr, i10, i11);
        this.currentPosition += (long) i12;
        return i12;
    }

    @Override // android.media.MediaParser.SeekableInputReader
    public void seekToPosition(long j10) {
        this.lastSeekPosition = j10;
    }

    public void setCurrentPosition(long j10) {
        this.currentPosition = j10;
    }

    public void setDataReader(DataReader dataReader, long j10) {
        this.dataReader = dataReader;
        this.resourceLength = j10;
        this.lastSeekPosition = -1L;
    }
}
