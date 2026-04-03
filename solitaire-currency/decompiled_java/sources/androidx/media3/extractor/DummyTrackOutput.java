package androidx.media3.extractor;

import androidx.annotation.Nullable;
import androidx.media3.common.DataReader;
import androidx.media3.common.Format;
import androidx.media3.common.util.ParsableByteArray;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.extractor.TrackOutput;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class DummyTrackOutput implements TrackOutput {
    private final byte[] readBuffer = new byte[4096];

    @Override // androidx.media3.extractor.TrackOutput
    public /* synthetic */ int sampleData(DataReader dataReader, int i10, boolean z10) {
        return g.a(this, dataReader, i10, z10);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public /* synthetic */ void sampleData(ParsableByteArray parsableByteArray, int i10) {
        g.b(this, parsableByteArray, i10);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public int sampleData(DataReader dataReader, int i10, boolean z10, int i11) throws IOException {
        int i12 = dataReader.read(this.readBuffer, 0, Math.min(this.readBuffer.length, i10));
        if (i12 != -1) {
            return i12;
        }
        if (z10) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void sampleData(ParsableByteArray parsableByteArray, int i10, int i11) {
        parsableByteArray.skipBytes(i10);
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void format(Format format) {
    }

    @Override // androidx.media3.extractor.TrackOutput
    public void sampleMetadata(long j10, int i10, int i11, int i12, @Nullable TrackOutput.CryptoData cryptoData) {
    }
}
