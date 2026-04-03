package com.google.android.gms.ads;

import androidx.annotation.VisibleForTesting;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public final class zzb {
    public static int zza(AdSize adSize) {
        return adSize.zzb();
    }

    public static int zzb(AdSize adSize) {
        return adSize.zza();
    }

    public static AdSize zzc(int i10, int i11, String str) {
        return new AdSize(i10, i11, str);
    }

    public static AdSize zzd(int i10, int i11) {
        AdSize adSize = new AdSize(i10, i11);
        adSize.zze(true);
        adSize.zzc(i11);
        return adSize;
    }

    public static AdSize zze(int i10, int i11) {
        AdSize adSize = new AdSize(i10, i11);
        adSize.zzf(true);
        adSize.zzd(i11);
        return adSize;
    }

    public static boolean zzf(AdSize adSize) {
        return adSize.zzg();
    }

    public static boolean zzg(AdSize adSize) {
        return adSize.zzh();
    }

    public static boolean zzh(AdSize adSize) {
        return adSize.zzi();
    }
}
