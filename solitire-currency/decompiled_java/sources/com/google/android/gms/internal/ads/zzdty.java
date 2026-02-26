package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdty extends zzbwm {
    final /* synthetic */ zzdua zza;

    zzdty(zzdua zzduaVar) {
        this.zza = zzduaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zze(int i10) throws RemoteException {
        zzdua zzduaVar = this.zza;
        zzduaVar.zzb.zzm(zzduaVar.zza, i10);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        zzdua zzduaVar = this.zza;
        zzduaVar.zzb.zzm(zzduaVar.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwn
    public final void zzg() throws RemoteException {
        zzdua zzduaVar = this.zza;
        zzduaVar.zzb.zzp(zzduaVar.zza);
    }
}
