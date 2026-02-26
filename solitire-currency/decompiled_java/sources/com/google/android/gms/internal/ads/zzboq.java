package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboq extends zzaxm implements zzbos {
    zzboq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zze() throws RemoteException {
        zzdc(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzf() throws RemoteException {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzg(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzeVar);
        zzdc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzi(int i10, String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        parcelZza.writeString(str);
        zzdc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzj(int i10) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzeVar);
        zzdc(24, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzl(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzm() throws RemoteException {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzn() throws RemoteException {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzo() throws RemoteException {
        zzdc(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzp() throws RemoteException {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzq(String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzr(zzbfx zzbfxVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfxVar);
        parcelZza.writeString(str);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzs(zzbvz zzbvzVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzt(zzbwd zzbwdVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbwdVar);
        zzdc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzu() throws RemoteException {
        zzdc(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzv() throws RemoteException {
        zzdc(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzw() throws RemoteException {
        zzdc(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzx() throws RemoteException {
        zzdc(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbos
    public final void zzy() throws RemoteException {
        zzdc(13, zza());
    }
}
