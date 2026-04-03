package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbpq extends zzbor {
    private final Adapter zza;
    private final zzbvy zzb;

    zzbpq(Adapter adapter, zzbvy zzbvyVar) {
        this.zza = adapter;
        this.zzb = zzbvyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zze() throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzf() throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzg(int i10) throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzg(ObjectWrapper.wrap(this.zza), i10);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzo() throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzp() throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzt(zzbwd zzbwdVar) throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzm(ObjectWrapper.wrap(this.zza), new zzbvz(zzbwdVar.zzf(), zzbwdVar.zze()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzu() throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzy() throws RemoteException {
        zzbvy zzbvyVar = this.zzb;
        if (zzbvyVar != null) {
            zzbvyVar.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzm() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzv() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzw() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzx() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzj(int i10) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzs(zzbvz zzbvzVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzi(int i10, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzq(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzr(zzbfx zzbfxVar, String str) throws RemoteException {
    }
}
