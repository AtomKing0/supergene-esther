package androidx.media3.exoplayer.upstream;

import androidx.media3.common.util.UnstableApi;

/* JADX INFO: loaded from: classes2.dex */
@UnstableApi
public final class Allocation {
    public final byte[] data;
    public final int offset;

    public Allocation(byte[] bArr, int i10) {
        this.data = bArr;
        this.offset = i10;
    }
}
