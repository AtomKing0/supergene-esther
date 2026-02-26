package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzccf implements zzheo {
    private final ByteBuffer zza;

    zzccf(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.duplicate();
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final int zza(ByteBuffer byteBuffer) throws IOException {
        if (this.zza.remaining() == 0 && byteBuffer.remaining() > 0) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), this.zza.remaining());
        byte[] bArr = new byte[iMin];
        this.zza.get(bArr);
        byteBuffer.put(bArr);
        return iMin;
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final long zzb() throws IOException {
        return this.zza.position();
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final long zzc() throws IOException {
        return this.zza.limit();
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final ByteBuffer zzd(long j10, long j11) throws IOException {
        ByteBuffer byteBuffer = this.zza;
        int iPosition = byteBuffer.position();
        byteBuffer.position((int) j10);
        ByteBuffer byteBufferSlice = this.zza.slice();
        byteBufferSlice.limit((int) j11);
        this.zza.position(iPosition);
        return byteBufferSlice;
    }

    @Override // com.google.android.gms.internal.ads.zzheo
    public final void zze(long j10) throws IOException {
        this.zza.position((int) j10);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }
}
