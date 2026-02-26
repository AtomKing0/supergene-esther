package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzgkp extends ThreadLocal {
    zzgkp() {
    }

    protected static final Cipher zza() {
        try {
            Cipher cipher = (Cipher) zzguz.zza.zza("AES/GCM-SIV/NoPadding");
            if (zzgkq.zze(cipher)) {
                return cipher;
            }
            return null;
        } catch (GeneralSecurityException e10) {
            throw new IllegalStateException(e10);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* bridge */ /* synthetic */ Object initialValue() {
        return zza();
    }
}
