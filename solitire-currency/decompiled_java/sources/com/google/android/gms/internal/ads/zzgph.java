package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzgph {
    static {
        int i10 = zzguc.zza;
        try {
            zza();
        } catch (GeneralSecurityException e10) {
            throw new ExceptionInInitializerError(e10);
        }
    }

    public static void zza() throws GeneralSecurityException {
        zzgpn.zzd();
        zzgor.zzd();
        zzgpa.zza(true);
        if (zzgks.zzb()) {
            return;
        }
        zzgoi.zzd(true);
    }
}
