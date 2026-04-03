package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfaq implements zzemz {
    final /* synthetic */ zzfar zza;

    zzfaq(zzfar zzfarVar) {
        this.zza = zzfarVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final void zza() {
        synchronized (this.zza) {
            this.zza.zza = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzemz
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzcpe zzcpeVar = (zzcpe) obj;
        synchronized (this.zza) {
            zzcpe zzcpeVar2 = this.zza.zza;
            if (zzcpeVar2 != null) {
                zzcpeVar2.zzb();
            }
            zzfar zzfarVar = this.zza;
            zzfarVar.zza = zzcpeVar;
            zzcpeVar.zzc(zzfarVar);
            zzfar zzfarVar2 = this.zza;
            zzfarVar2.zzg.zzk(new zzcpf(zzcpeVar, zzfarVar2, zzfarVar2.zzg, zzfarVar2.zzi));
            zzcpeVar.zzk();
        }
    }
}
