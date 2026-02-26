package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import javax.crypto.AEADBadTagException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzgke {
    private final zzgkc zza;
    private final zzgkc zzb;

    public zzgke(byte[] bArr) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        this.zza = zza(bArr, 1);
        this.zzb = zza(bArr, 0);
    }

    abstract zzgkc zza(byte[] bArr, int i10) throws InvalidKeyException;

    public final byte[] zzb(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() < 16) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        int iPosition = byteBuffer.position();
        byte[] bArr3 = new byte[16];
        byteBuffer.position(byteBuffer.limit() - 16);
        byteBuffer.get(bArr3);
        byteBuffer.position(iPosition);
        byteBuffer.limit(byteBuffer.limit() - 16);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        try {
            byte[] bArr4 = new byte[32];
            this.zzb.zzc(bArr, 0).get(bArr4);
            int length = bArr2.length;
            int i10 = length & 15;
            int i11 = i10 == 0 ? length : (length + 16) - i10;
            int iRemaining = byteBuffer.remaining();
            int i12 = iRemaining % 16;
            int i13 = (i12 == 0 ? iRemaining : (iRemaining + 16) - i12) + i11;
            ByteBuffer byteBufferOrder = ByteBuffer.allocate(i13 + 16).order(ByteOrder.LITTLE_ENDIAN);
            byteBufferOrder.put(bArr2);
            byteBufferOrder.position(i11);
            byteBufferOrder.put(byteBuffer);
            byteBufferOrder.position(i13);
            byteBufferOrder.putLong(length);
            byteBufferOrder.putLong(iRemaining);
            if (!MessageDigest.isEqual(zzgki.zza(bArr4, byteBufferOrder.array()), bArr3)) {
                throw new GeneralSecurityException("invalid MAC");
            }
            byteBuffer.position(iPosition);
            return this.zza.zzd(bArr, byteBuffer);
        } catch (GeneralSecurityException e10) {
            throw new AEADBadTagException(e10.toString());
        }
    }
}
