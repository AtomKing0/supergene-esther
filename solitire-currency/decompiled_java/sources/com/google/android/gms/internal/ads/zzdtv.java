package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzdtv extends com.google.android.gms.ads.internal.client.zzbg {
    final /* synthetic */ zzdtp zza;
    final /* synthetic */ zzdtw zzb;

    zzdtv(zzdtw zzdtwVar, zzdtp zzdtpVar) {
        this.zza = zzdtpVar;
        this.zzb = zzdtwVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzc() throws RemoteException {
        this.zza.zzb(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzd() throws RemoteException {
        this.zza.zzc(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zze(int i10) throws RemoteException {
        this.zza.zzd(this.zzb.zza, i10);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        this.zza.zzd(this.zzb.zza, zzeVar.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzi() throws RemoteException {
        this.zza.zze(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzj() throws RemoteException {
        this.zza.zzg(this.zzb.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzg() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzh() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzk() {
    }
}
