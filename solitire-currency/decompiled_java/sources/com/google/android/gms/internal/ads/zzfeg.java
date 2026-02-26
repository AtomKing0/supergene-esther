package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfeg implements zzemz {
    final /* synthetic */ zzfei zza;

    zzfeg(zzfei zzfeiVar) {
        this.zza = zzfeiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zzd = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        synchronized (this.zza) {
            this.zza.zzd = (zzdop) obj;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdg)).booleanValue()) {
                ((zzdop) obj).zzd().zza = this.zza.zzc;
            }
            this.zza.zzd.zzk();
        }
    }
}
