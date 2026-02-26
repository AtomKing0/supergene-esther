package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.upstream.CmcdData;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcos {
    private final zzdsk zza;
    private final zzfex zzb;

    zzcos(zzdsk zzdskVar, zzfex zzfexVar) {
        this.zza = zzdskVar;
        this.zzb = zzfexVar;
    }

    public final void zza(long j10, int i10) {
        zzdsj zzdsjVarZza = this.zza.zza();
        zzdsjVarZza.zzd(this.zzb.zzb.zzb);
        zzdsjVarZza.zzb("action", "ad_closed");
        zzdsjVarZza.zzb("show_time", String.valueOf(j10));
        zzdsjVarZza.zzb("ad_format", "app_open_ad");
        int i11 = i10 - 1;
        zzdsjVarZza.zzb("acr", i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "u" : "ac" : "cb" : "cc" : "bb" : CmcdData.Factory.STREAMING_FORMAT_HLS);
        zzdsjVarZza.zzf();
    }
}
