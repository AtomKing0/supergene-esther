package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgkc {
    int[] zza;
    private final int zzb;

    public zzgkc(byte[] bArr, int i10) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.zza = zzgjy.zze(bArr);
        this.zzb = i10;
    }

    abstract int zza();

    abstract int[] zzb(int[] iArr, int i10);

    final ByteBuffer zzc(byte[] bArr, int i10) {
        int[] iArrZzb = zzb(zzgjy.zze(bArr), i10);
        int[] iArr = (int[]) iArrZzb.clone();
        zzgjy.zzc(iArr);
        for (int i11 = 0; i11 < 16; i11++) {
            iArrZzb[i11] = iArrZzb[i11] + iArr[i11];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrZzb, 0, 16);
        return byteBufferOrder;
    }

    public final byte[] zzd(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        if (bArr.length != zza()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + zza());
        }
        int iRemaining = byteBuffer.remaining();
        int i10 = iRemaining / 64;
        int i11 = 0;
        while (true) {
            int i12 = i10 + 1;
            if (i11 >= i12) {
                return byteBufferAllocate.array();
            }
            ByteBuffer byteBufferZzc = zzc(bArr, this.zzb + i11);
            if (i11 == i12 - 1) {
                zzgup.zza(byteBufferAllocate, byteBuffer, byteBufferZzc, iRemaining % 64);
            } else {
                zzgup.zza(byteBufferAllocate, byteBuffer, byteBufferZzc, 64);
            }
            i11++;
        }
    }
}
