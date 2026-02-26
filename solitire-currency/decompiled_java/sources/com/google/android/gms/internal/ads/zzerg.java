package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzerg implements zzhfc {
    private final zzhfu zza;

    public zzerg(zzhfu zzhfuVar, zzhfu zzhfuVar2) {
        this.zza = zzhfuVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzhfu, com.google.android.gms.internal.ads.zzhft
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzetw(zzesg.zza(), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzlm)).intValue(), (ScheduledExecutorService) this.zza.zzb());
    }
}
