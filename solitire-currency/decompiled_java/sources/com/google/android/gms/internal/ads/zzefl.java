package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzefl extends zzbpv {
    private final zzeew zza;

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zze(String str) throws RemoteException {
        ((zzegp) this.zza.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzegp) this.zza.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbpw
    public final void zzg() throws RemoteException {
        ((zzegp) this.zza.zzc).zzo();
    }
}
