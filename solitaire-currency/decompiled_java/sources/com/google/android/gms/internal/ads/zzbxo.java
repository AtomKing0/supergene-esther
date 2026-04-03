package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbxo {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    zzbxo(Clock clock, com.google.android.gms.ads.internal.util.zzg zzgVar, zzbya zzbyaVar) {
        this.zza = zzgVar;
    }

    public final void zza(int i10, long j10) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzak)).booleanValue()) {
            return;
        }
        if (j10 - this.zza.zzf() < 0) {
            com.google.android.gms.ads.internal.util.zze.zza("Receiving npa decision in the past, ignoring.");
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzal)).booleanValue()) {
            this.zza.zzM(i10);
            this.zza.zzN(j10);
        } else {
            this.zza.zzM(-1);
            this.zza.zzN(j10);
        }
    }
}
