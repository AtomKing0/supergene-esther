package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzauu {
    private static Cipher zza;
    private static final Object zzb = new Object();
    private static final Object zzc = new Object();

    public zzauu(SecureRandom secureRandom) {
    }

    private static final Cipher zzc() throws NoSuchPaddingException, NoSuchAlgorithmException {
        Cipher cipher;
        synchronized (zzc) {
            if (zza == null) {
                zza = Cipher.getInstance("AES/CBC/PKCS5Padding");
            }
            cipher = zza;
        }
        return cipher;
    }

    public final String zza(byte[] bArr, byte[] bArr2) throws zzaut {
        byte[] bArrDoFinal;
        byte[] iv;
        int length = bArr.length;
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzb) {
                zzc().init(1, secretKeySpec, (SecureRandom) null);
                bArrDoFinal = zzc().doFinal(bArr2);
                iv = zzc().getIV();
            }
            int length2 = bArrDoFinal.length + iv.length;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(iv).put(bArrDoFinal);
            byteBufferAllocate.flip();
            byte[] bArr3 = new byte[length2];
            byteBufferAllocate.get(bArr3);
            return zzasz.zza(bArr3, false);
        } catch (InvalidKeyException e10) {
            throw new zzaut(this, e10);
        } catch (NoSuchAlgorithmException e11) {
            throw new zzaut(this, e11);
        } catch (BadPaddingException e12) {
            throw new zzaut(this, e12);
        } catch (IllegalBlockSizeException e13) {
            throw new zzaut(this, e13);
        } catch (NoSuchPaddingException e14) {
            throw new zzaut(this, e14);
        }
    }

    public final byte[] zzb(byte[] bArr, String str) throws zzaut {
        byte[] bArrDoFinal;
        int length = bArr.length;
        try {
            byte[] bArrZzb = zzasz.zzb(str, false);
            int length2 = bArrZzb.length;
            if (length2 <= 16) {
                throw new zzaut(this);
            }
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length2);
            byteBufferAllocate.put(bArrZzb);
            byteBufferAllocate.flip();
            byte[] bArr2 = new byte[16];
            byte[] bArr3 = new byte[length2 - 16];
            byteBufferAllocate.get(bArr2);
            byteBufferAllocate.get(bArr3);
            SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
            synchronized (zzb) {
                zzc().init(2, secretKeySpec, new IvParameterSpec(bArr2));
                bArrDoFinal = zzc().doFinal(bArr3);
            }
            return bArrDoFinal;
        } catch (IllegalArgumentException e10) {
            throw new zzaut(this, e10);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new zzaut(this, e11);
        } catch (InvalidKeyException e12) {
            throw new zzaut(this, e12);
        } catch (NoSuchAlgorithmException e13) {
            throw new zzaut(this, e13);
        } catch (BadPaddingException e14) {
            throw new zzaut(this, e14);
        } catch (IllegalBlockSizeException e15) {
            throw new zzaut(this, e15);
        } catch (NoSuchPaddingException e16) {
            throw new zzaut(this, e16);
        }
    }
}
