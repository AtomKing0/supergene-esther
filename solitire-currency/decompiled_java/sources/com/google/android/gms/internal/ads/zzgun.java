package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import javax.crypto.AEADBadTagException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgun implements zzgdo {
    private static final ThreadLocal zza = new zzgul();
    private static final ThreadLocal zzb = new zzgum();
    private final byte[] zzc;
    private final byte[] zzd;
    private final byte[] zze;
    private final SecretKeySpec zzf;
    private final int zzg;

    private zzgun(byte[] bArr, int i10, byte[] bArr2) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        if (i10 != 12 && i10 != 16) {
            throw new IllegalArgumentException("IV size should be either 12 or 16 bytes");
        }
        this.zzg = i10;
        zzgvp.zza(bArr.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        this.zzf = secretKeySpec;
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, secretKeySpec);
        byte[] bArrZzc = zzc(cipher.doFinal(new byte[16]));
        this.zzc = bArrZzc;
        this.zzd = zzc(bArrZzc);
        this.zze = bArr2;
    }

    public static zzgdo zzb(zzgft zzgftVar) throws GeneralSecurityException {
        if (!zzgkr.zza(1)) {
            throw new GeneralSecurityException("Can not use AES-EAX in FIPS-mode.");
        }
        zzgftVar.zzb();
        return new zzgun(zzgftVar.zzd().zzd(zzgdx.zza()), zzgftVar.zzb().zzb(), zzgftVar.zzc().zzc());
    }

    private static byte[] zzc(byte[] bArr) {
        byte[] bArr2 = new byte[16];
        int i10 = 0;
        while (i10 < 15) {
            byte b10 = bArr[i10];
            int i11 = i10 + 1;
            bArr2[i10] = (byte) (((b10 + b10) ^ ((bArr[i11] & 255) >>> 7)) & 255);
            i10 = i11;
        }
        byte b11 = bArr[15];
        bArr2[15] = (byte) (((bArr[0] >> 7) & 135) ^ (b11 + b11));
        return bArr2;
    }

    private final byte[] zzd(Cipher cipher, int i10, byte[] bArr, int i11, int i12) throws BadPaddingException, IllegalBlockSizeException {
        int length;
        byte[] bArrZzf;
        byte[] bArr2 = new byte[16];
        bArr2[15] = (byte) i10;
        if (i12 == 0) {
            return cipher.doFinal(zzf(bArr2, this.zzc));
        }
        byte[] bArrDoFinal = cipher.doFinal(bArr2);
        int i13 = 0;
        int i14 = 0;
        while (i12 - i14 > 16) {
            for (int i15 = 0; i15 < 16; i15++) {
                bArrDoFinal[i15] = (byte) (bArr[(i11 + i14) + i15] ^ bArrDoFinal[i15]);
            }
            bArrDoFinal = cipher.doFinal(bArrDoFinal);
            i14 += 16;
        }
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i14 + i11, i11 + i12);
        if (bArrCopyOfRange.length == 16) {
            bArrZzf = zzf(bArrCopyOfRange, this.zzc);
        } else {
            byte[] bArrCopyOf = Arrays.copyOf(this.zzd, 16);
            while (true) {
                length = bArrCopyOfRange.length;
                if (i13 >= length) {
                    break;
                }
                bArrCopyOf[i13] = (byte) (bArrCopyOf[i13] ^ bArrCopyOfRange[i13]);
                i13++;
            }
            bArrCopyOf[length] = (byte) (bArrCopyOf[length] ^ 128);
            bArrZzf = bArrCopyOf;
        }
        return cipher.doFinal(zzf(bArrDoFinal, bArrZzf));
    }

    private final byte[] zze(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        int length = bArr.length;
        int i10 = (length - this.zzg) - 16;
        if (i10 < 0) {
            throw new GeneralSecurityException("ciphertext too short");
        }
        Cipher cipher = (Cipher) zza.get();
        cipher.init(1, this.zzf);
        byte[] bArrZzd = zzd(cipher, 0, bArr, 0, this.zzg);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] bArr3 = bArr2;
        byte[] bArrZzd2 = zzd(cipher, 1, bArr3, 0, bArr3.length);
        byte[] bArrZzd3 = zzd(cipher, 2, bArr, this.zzg, i10);
        int i11 = length - 16;
        byte b10 = 0;
        for (int i12 = 0; i12 < 16; i12++) {
            b10 = (byte) (b10 | (((bArr[i11 + i12] ^ bArrZzd2[i12]) ^ bArrZzd[i12]) ^ bArrZzd3[i12]));
        }
        if (b10 != 0) {
            throw new AEADBadTagException("tag mismatch");
        }
        Cipher cipher2 = (Cipher) zzb.get();
        cipher2.init(1, this.zzf, new IvParameterSpec(bArrZzd));
        return cipher2.doFinal(bArr, this.zzg, i10);
    }

    private static byte[] zzf(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        byte[] bArr3 = new byte[length];
        for (int i10 = 0; i10 < length; i10++) {
            bArr3[i10] = (byte) (bArr[i10] ^ bArr2[i10]);
        }
        return bArr3;
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        byte[] bArr3 = this.zze;
        if (bArr3.length == 0) {
            return zze(bArr, bArr2);
        }
        if (!zzgoa.zzc(bArr3, bArr)) {
            throw new GeneralSecurityException("Decryption failed (OutputPrefix mismatch).");
        }
        byte[] bArr4 = this.zze;
        return zze(Arrays.copyOfRange(bArr, bArr4.length, bArr.length), bArr2);
    }
}
