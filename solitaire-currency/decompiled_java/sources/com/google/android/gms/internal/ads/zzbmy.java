package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbmy implements zzbzx {
    final /* synthetic */ zzbmz zza;

    zzbmy(zzbmz zzbmzVar) {
        this.zza = zzbmzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbzx
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        final zzblv zzblvVar = (zzblv) obj;
        zzbzo.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmx
            @Override // java.lang.Runnable
            public final void run() {
                zzblv zzblvVar2 = zzblvVar;
                zzblvVar2.zzr("/result", zzbiw.zzo);
                zzblvVar2.zzc();
            }
        });
    }
}
