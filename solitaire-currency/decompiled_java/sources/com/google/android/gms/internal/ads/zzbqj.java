package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbqj extends zzaxm implements zzbql {
    zzbqj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(5, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final zzbra zzg() throws RemoteException {
        Parcel parcelZzdb = zzdb(3, zza());
        zzbra zzbraVar = (zzbra) zzaxo.zza(parcelZzdb, zzbra.CREATOR);
        parcelZzdb.recycle();
        return zzbraVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzq zzqVar, zzbqo zzbqoVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzaxo.zzd(parcelZza, bundle);
        zzaxo.zzd(parcelZza, bundle2);
        zzaxo.zzd(parcelZza, zzqVar);
        zzaxo.zzf(parcelZza, zzbqoVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpw zzbpwVar, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbpwVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(23, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpz zzbpzVar, zzbos zzbosVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbpzVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, zzqVar);
        zzdc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpz zzbpzVar, zzbos zzbosVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbpzVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, zzqVar);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqc zzbqcVar, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbqcVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqf zzbqfVar, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbqfVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(18, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqf zzbqfVar, zzbos zzbosVar, zzbes zzbesVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbqfVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzaxo.zzd(parcelZza, zzbesVar);
        zzdc(22, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbqiVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbqi zzbqiVar, zzbos zzbosVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzaxo.zzd(parcelZza, zzlVar);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbqiVar);
        zzaxo.zzf(parcelZza, zzbosVar);
        zzdc(16, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final void zzq(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(19, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzdb = zzdb(24, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzdb = zzdb(15, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbql
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzdb = zzdb(17, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
