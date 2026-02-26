package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbon extends zzaxm implements zzbop {
    zzbon(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(28, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzB(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzE() throws RemoteException {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzF() throws RemoteException {
        zzdc(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzG(boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = zzaxo.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzdc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(39, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzI() throws RemoteException {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(37, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(30, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzL() throws RemoteException {
        zzdc(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzM() throws RemoteException {
        Parcel parcelZzdb = zzdb(22, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final boolean zzN() throws RemoteException {
        Parcel parcelZzdb = zzdb(13, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbox zzO() throws RemoteException {
        zzbox zzboxVar;
        Parcel parcelZzdb = zzdb(15, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzboxVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            zzboxVar = iInterfaceQueryLocalInterface instanceof zzbox ? (zzbox) iInterfaceQueryLocalInterface : new zzbox(strongBinder);
        }
        parcelZzdb.recycle();
        return zzboxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzboy zzP() throws RemoteException {
        zzboy zzboyVar;
        Parcel parcelZzdb = zzdb(16, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzboyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            zzboyVar = iInterfaceQueryLocalInterface instanceof zzboy ? (zzboy) iInterfaceQueryLocalInterface : new zzboy(strongBinder);
        }
        parcelZzdb.recycle();
        return zzboyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzdb = zzdb(26, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbfx zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbov zzj() throws RemoteException {
        zzbov zzbotVar;
        Parcel parcelZzdb = zzdb(36, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbotVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            zzbotVar = iInterfaceQueryLocalInterface instanceof zzbov ? (zzbov) iInterfaceQueryLocalInterface : new zzbot(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbotVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbpb zzk() throws RemoteException {
        zzbpb zzbozVar;
        Parcel parcelZzdb = zzdb(27, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbozVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            zzbozVar = iInterfaceQueryLocalInterface instanceof zzbpb ? (zzbpb) iInterfaceQueryLocalInterface : new zzboz(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbra zzl() throws RemoteException {
        Parcel parcelZzdb = zzdb(33, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final zzbra zzm() throws RemoteException {
        Parcel parcelZzdb = zzdb(34, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzo() throws RemoteException {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbvy zzbvyVar, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(null);
        zzaxo.zzf(parcelZza, zzbvyVar);
        parcelZza.writeString(str2);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzq(IObjectWrapper iObjectWrapper, zzbkz zzbkzVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbkzVar);
        parcelZza.writeTypedList(list);
        zzdc(31, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzr(IObjectWrapper iObjectWrapper, zzbvy zzbvyVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbvyVar);
        parcelZza.writeStringList(list);
        zzdc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzs(com.google.android.gms.ads.internal.client.zzl zzlVar, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzdc(11, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(38, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzqVar);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzqVar);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(35, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbos zzbosVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbop
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzbos zzbosVar, zzbes zzbesVar, List list) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzlVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, zzbesVar);
        parcelZza.writeStringList(list);
        zzdc(14, parcelZza);
    }
}
