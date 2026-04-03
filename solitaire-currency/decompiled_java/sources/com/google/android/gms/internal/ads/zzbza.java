package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbza extends com.google.android.gms.ads.internal.util.zzb {
    final /* synthetic */ zzbze zza;

    zzbza(zzbze zzbzeVar) {
        this.zza = zzbzeVar;
    }

    @Override // com.google.android.gms.ads.internal.util.zzb
    public final void zza() {
        zzbze zzbzeVar = this.zza;
        zzbbz zzbbzVar = new zzbbz(zzbzeVar.zze, zzbzeVar.zzf.afmaVersion);
        synchronized (this.zza.zza) {
            try {
                com.google.android.gms.ads.internal.zzu.zze();
                zzbcc.zza(this.zza.zzh, zzbbzVar);
            } catch (IllegalArgumentException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot config CSI reporter.", e10);
            }
        }
    }
}
