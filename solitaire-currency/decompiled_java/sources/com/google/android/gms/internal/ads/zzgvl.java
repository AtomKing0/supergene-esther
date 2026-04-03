package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgvl implements zzgqi {
    private static final ThreadLocal zza = new zzgvk();
    private final SecretKey zzb;
    private final byte[] zzc;
    private final byte[] zzd;

    public zzgvl(byte[] bArr) throws GeneralSecurityException {
        zzgvp.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzb = secretKeySpec;
        Cipher cipherZzb = zzb();
        cipherZzb.init(1, secretKeySpec);
        byte[] bArrZza = zzgpz.zza(cipherZzb.doFinal(new byte[16]));
        this.zzc = bArrZza;
        this.zzd = zzgpz.zza(bArrZza);
    }

    private static Cipher zzb() throws GeneralSecurityException {
        if (zzgkr.zza(1)) {
            return (Cipher) zza.get();
        }
        throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
    }

    @Override // com.google.android.gms.internal.ads.zzgqi
    public final byte[] zza(byte[] bArr, int i10) throws GeneralSecurityException {
        byte[] bArrZzc;
        if (i10 > 16) {
            throw new InvalidAlgorithmParameterException("outputLength too large, max is 16 bytes");
        }
        SecretKey secretKey = this.zzb;
        Cipher cipherZzb = zzb();
        cipherZzb.init(1, secretKey);
        int length = bArr.length;
        int iMax = Math.max(1, (int) Math.ceil(((double) length) / 16.0d));
        int i11 = iMax - 1;
        int i12 = i11 * 16;
        if (iMax * 16 == length) {
            bArrZzc = zzgup.zzd(bArr, i12, this.zzc, 0, 16);
        } else {
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i12, length);
            int length2 = bArrCopyOfRange.length;
            if (length2 >= 16) {
                throw new IllegalArgumentException("x must be smaller than a block.");
            }
            byte[] bArrCopyOf = Arrays.copyOf(bArrCopyOfRange, 16);
            bArrCopyOf[length2] = -128;
            bArrZzc = zzgup.zzc(bArrCopyOf, this.zzd);
        }
        byte[] bArrDoFinal = new byte[16];
        for (int i13 = 0; i13 < i11; i13++) {
            bArrDoFinal = cipherZzb.doFinal(zzgup.zzd(bArrDoFinal, 0, bArr, i13 * 16, 16));
        }
        return Arrays.copyOf(cipherZzb.doFinal(zzgup.zzc(bArrZzc, bArrDoFinal)), i10);
    }
}
