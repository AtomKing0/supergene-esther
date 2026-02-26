package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzers implements zzhfc {
    private final zzhfu zza;
    private final zzhfu zzb;

    public zzers(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar;
        this.zzb = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzetw((zzeqg) this.zza.zzb(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzld)).intValue(), (ScheduledExecutorService) this.zzb.zzb());
    }
}
