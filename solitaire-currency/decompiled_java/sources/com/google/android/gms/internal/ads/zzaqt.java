package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaqt {
    public static double zza(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i10 = bArr[0] << 24;
        int i11 = bArr[1] << 16;
        int i12 = bArr[2] << 8;
        return ((double) ((((i10 & ViewCompat.MEASURED_STATE_MASK) | (i11 & 16711680)) | (65280 & i12)) | (bArr[3] & 255))) / 1.073741824E9d;
    }

    public static double zzb(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        int i10 = bArr[0] << 24;
        int i11 = bArr[1] << 16;
        int i12 = bArr[2] << 8;
        return ((double) ((((i10 & ViewCompat.MEASURED_STATE_MASK) | (i11 & 16711680)) | (65280 & i12)) | (bArr[3] & 255))) / 65536.0d;
    }

    public static int zzc(byte b10) {
        return b10 < 0 ? b10 + 256 : b10;
    }

    public static int zzd(ByteBuffer byteBuffer) {
        return (zzc(byteBuffer.get()) << 8) + zzc(byteBuffer.get());
    }

    public static long zze(ByteBuffer byteBuffer) {
        long j10 = byteBuffer.getInt();
        return j10 < 0 ? j10 + 4294967296L : j10;
    }

    public static long zzf(ByteBuffer byteBuffer) {
        long jZze = zze(byteBuffer) << 32;
        if (jZze >= 0) {
            return jZze + zze(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
