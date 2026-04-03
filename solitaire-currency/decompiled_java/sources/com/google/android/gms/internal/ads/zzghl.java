package com.google.android.gms.internal.ads;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzghl implements zzgdo {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = new byte[0];
    private static final Set zzc;
    private final String zzd;
    private final zzgdo zze;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzc = Collections.unmodifiableSet(hashSet);
    }

    @Deprecated
    zzghl(zzgsz zzgszVar, zzgdo zzgdoVar) throws GeneralSecurityException {
        if (zzc.contains(zzgszVar.zzi())) {
            this.zzd = zzgszVar.zzi();
            zzgsy zzgsyVarZzc = zzgsz.zzc(zzgszVar);
            zzgsyVarZzc.zza(zzgtz.RAW);
            zzget.zza(((zzgsz) zzgsyVarZzc.zzbr()).zzaV());
            this.zze = zzgdoVar;
            return;
        }
        throw new IllegalArgumentException("Unsupported DEK key type: " + zzgszVar.zzi() + ". Only Tink AEAD key types are supported.");
    }

    @Override // com.google.android.gms.internal.ads.zzgdo
    public final byte[] zza(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        try {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
            int i10 = byteBufferWrap.getInt();
            if (i10 <= 0 || i10 > bArr.length - 4) {
                throw new GeneralSecurityException("invalid ciphertext");
            }
            byte[] bArr3 = new byte[i10];
            byteBufferWrap.get(bArr3, 0, i10);
            byte[] bArr4 = new byte[byteBufferWrap.remaining()];
            byteBufferWrap.get(bArr4, 0, byteBufferWrap.remaining());
            byte[] bArrZza = this.zze.zza(bArr3, zzb);
            String str = this.zzd;
            zzgwm zzgwmVar = zzgwm.zzb;
            return ((zzgdo) zzgmh.zza().zzc(zzgmk.zzc().zza(zzgnl.zza(str, zzgwm.zzv(bArrZza, 0, bArrZza.length), zzgsu.SYMMETRIC, zzgtz.RAW, null), zzgdx.zza()), zzgdo.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException | NegativeArraySizeException | BufferUnderflowException e10) {
            throw new GeneralSecurityException("invalid ciphertext", e10);
        }
    }
}
