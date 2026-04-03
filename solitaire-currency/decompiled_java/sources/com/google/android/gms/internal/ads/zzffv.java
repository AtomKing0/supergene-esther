package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzffv {
    @VisibleForTesting
    public zzffv() {
        try {
            zzgev.zza();
        } catch (GeneralSecurityException e10) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to Configure Aead. ".concat(e10.toString()));
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CryptoUtils.registerAead");
        }
    }

    public static final String zza() {
        zzgwl zzgwlVarZzt = zzgwm.zzt();
        try {
            zzgdr.zzb(zzgej.zzb(zzgeb.zza(zzgmg.zzb().zza("AES128_GCM"))), zzgdq.zzb(zzgwlVarZzt));
        } catch (IOException | GeneralSecurityException e10) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to generate key".concat(e10.toString()));
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CryptoUtils.generateKey");
        }
        String strEncodeToString = Base64.encodeToString(zzgwlVarZzt.zzb().zzA(), 11);
        zzgwlVarZzt.zzc();
        return strEncodeToString;
    }

    public static final String zzb(byte[] bArr, byte[] bArr2, String str, zzdsf zzdsfVar) {
        zzgej zzgejVarZzc = zzc(str);
        if (zzgejVarZzc == null) {
            return null;
        }
        try {
            byte[] bArrZza = ((zzgdo) zzgejVarZzc.zzd(zzgnp.zza(), zzgdo.class)).zza(bArr, bArr2);
            zzdsfVar.zzb().put("ds", "1");
            return new String(bArrZza, "UTF-8");
        } catch (UnsupportedEncodingException | UnsupportedOperationException | GeneralSecurityException e10) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to decrypt ".concat(e10.toString()));
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CryptoUtils.decrypt");
            zzdsfVar.zzb().put("dsf", e10.toString());
            return null;
        }
    }

    private static final zzgej zzc(String str) {
        try {
            return zzgdr.zza(zzgdp.zzb(Base64.decode(str, 11)));
        } catch (IOException | GeneralSecurityException e10) {
            com.google.android.gms.ads.internal.util.zze.zza("Failed to get keysethandle".concat(e10.toString()));
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "CryptoUtils.getHandle");
            return null;
        }
    }
}
