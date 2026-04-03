package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzehs extends zzbqe {
    final /* synthetic */ zzeht zza;
    private final zzeew zzb;

    /* synthetic */ zzehs(zzeht zzehtVar, zzeew zzeewVar, zzehr zzehrVar) {
        this.zza = zzehtVar;
        this.zzb = zzeewVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zze(String str) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqf
    public final void zzg(zzbpb zzbpbVar) throws RemoteException {
        this.zza.zzc = zzbpbVar;
        ((zzegp) this.zzb.zzc).zzo();
    }
}
