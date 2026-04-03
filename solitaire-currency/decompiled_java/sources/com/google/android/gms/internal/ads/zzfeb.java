package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfeb implements zzemz {
    final /* synthetic */ zzfec zza;

    zzfeb(zzfec zzfecVar) {
        this.zza = zzfecVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzi = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzi = (zzdop) obj;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdg)).booleanValue()) {
                ((zzdop) obj).zzd().zza = this.zza.zzd;
            }
            this.zza.zzi.zzk();
        }
    }
}
