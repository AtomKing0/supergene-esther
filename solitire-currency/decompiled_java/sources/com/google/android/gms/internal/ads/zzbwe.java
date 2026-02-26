package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbwe extends zzaxm implements zzbwg {
    zzbwe(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final Bundle zzb() throws RemoteException {
        Parcel parcelZzdb = zzdb(9, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException {
        Parcel parcelZzdb = zzdb(12, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final zzbwd zzd() throws RemoteException {
        zzbwd zzbwbVar;
        Parcel parcelZzdb = zzdb(11, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbwbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            zzbwbVar = iInterfaceQueryLocalInterface instanceof zzbwd ? (zzbwd) iInterfaceQueryLocalInterface : new zzbwb(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbwbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final String zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzf(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbwn zzbwnVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, zzbwnVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbwn zzbwnVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, zzbwnVar);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzh(boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = zzaxo.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzdc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzi(com.google.android.gms.ads.internal.client.zzdd zzddVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzddVar);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzj(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzdgVar);
        zzdc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzk(zzbwj zzbwjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbwjVar);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzl(zzbwu zzbwuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbwuVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z10) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final boolean zzo() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbwg
    public final void zzp(zzbwo zzbwoVar) throws RemoteException {
        throw null;
    }
}
