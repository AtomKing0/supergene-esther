package androidx.media3.datasource;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class ByteArrayDataSink implements DataSink {
    private ByteArrayOutputStream stream;

    @Override // androidx.media3.datasource.DataSink
    public void close() throws IOException {
        ((ByteArrayOutputStream) Util.castNonNull(this.stream)).close();
    }

    @Nullable
    public byte[] getData() {
        ByteArrayOutputStream byteArrayOutputStream = this.stream;
        if (byteArrayOutputStream == null) {
            return null;
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override // androidx.media3.datasource.DataSink
    public void open(DataSpec dataSpec) {
        long j10 = dataSpec.length;
        if (j10 == -1) {
            this.stream = new ByteArrayOutputStream();
        } else {
            Assertions.checkArgument(j10 <= 2147483647L);
            this.stream = new ByteArrayOutputStream((int) dataSpec.length);
        }
    }

    @Override // androidx.media3.datasource.DataSink
    public void write(byte[] bArr, int i10, int i11) {
        ((ByteArrayOutputStream) Util.castNonNull(this.stream)).write(bArr, i10, i11);
    }
}
