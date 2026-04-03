package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzerc implements zzhfc {
    private final zzhfu zza;

    public zzerc(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfxw zzfxwVarZzn;
        zzeqi zzeqiVarZza = zzeqk.zza();
        ScheduledExecutorService scheduledExecutorService = (ScheduledExecutorService) this.zza.zzb();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdG)).booleanValue()) {
            zzfxwVarZzn = zzfxw.zzo(new zzetw(zzeqiVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdH)).intValue(), scheduledExecutorService));
        } else {
            zzfxwVarZzn = zzfxw.zzn();
        }
        zzhfk.zzb(zzfxwVarZzn);
        return zzfxwVarZzn;
    }
}
