package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzegd extends zzbpy {
    final /* synthetic */ zzege zza;
    private final zzeew zzb;

    /* synthetic */ zzegd(zzege zzegeVar, zzeew zzeewVar, zzegc zzegcVar) {
        this.zza = zzegeVar;
        this.zzb = zzeewVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zze(String str) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzi(0, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        ((zzegp) this.zzb.zzc).zzh(zzeVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        this.zza.zzc = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzegp) this.zzb.zzc).zzo();
    }

    @Override // com.google.android.gms.internal.ads.zzbpz
    public final void zzh(zzbov zzbovVar) throws RemoteException {
        this.zza.zzd = zzbovVar;
        ((zzegp) this.zzb.zzc).zzo();
    }
}
