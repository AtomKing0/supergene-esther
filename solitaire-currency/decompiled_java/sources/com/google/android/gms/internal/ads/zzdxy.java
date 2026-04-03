package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdxy implements zzgcf {
    final /* synthetic */ Context zza;

    zzdxy(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final void zza(Throwable th) {
        if (((Boolean) zzbdk.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzba)) {
            zzbbg.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgcf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbdk.zzj.zze()).booleanValue()) {
            zzbbg.zze(this.zza);
        }
    }
}
