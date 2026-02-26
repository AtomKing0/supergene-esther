package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbgy extends zzaxm implements zzbha {
    zzbgy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzA() throws RemoteException {
        zzdc(28, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzB(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzdc(17, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzC() throws RemoteException {
        zzdc(27, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzD(com.google.android.gms.ads.internal.client.zzcs zzcsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzcsVar);
        zzdc(26, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzE(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzdgVar);
        zzdc(32, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzF(zzbgx zzbgxVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbgxVar);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzG() throws RemoteException {
        Parcel parcelZzdb = zzdb(30, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzH() throws RemoteException {
        Parcel parcelZzdb = zzdb(24, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final boolean zzI(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        Parcel parcelZzdb = zzdb(16, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final double zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(8, zza());
        double d10 = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d10;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final Bundle zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(20, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final com.google.android.gms.ads.internal.client.zzdn zzg() throws RemoteException {
        Parcel parcelZzdb = zzdb(31, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzdb = zzdb(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbew zzi() throws RemoteException {
        zzbew zzbeuVar;
        Parcel parcelZzdb = zzdb(14, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbeuVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
            zzbeuVar = iInterfaceQueryLocalInterface instanceof zzbew ? (zzbew) iInterfaceQueryLocalInterface : new zzbeu(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbeuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbfa zzj() throws RemoteException {
        zzbfa zzbeyVar;
        Parcel parcelZzdb = zzdb(29, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbeyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbeyVar = iInterfaceQueryLocalInterface instanceof zzbfa ? (zzbfa) iInterfaceQueryLocalInterface : new zzbey(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final zzbfd zzk() throws RemoteException {
        zzbfd zzbfbVar;
        Parcel parcelZzdb = zzdb(5, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbfbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbfbVar = iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbfbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final IObjectWrapper zzl() throws RemoteException {
        Parcel parcelZzdb = zzdb(19, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcelZzdb = zzdb(18, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzn() throws RemoteException {
        Parcel parcelZzdb = zzdb(7, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzo() throws RemoteException {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzp() throws RemoteException {
        Parcel parcelZzdb = zzdb(6, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzq() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzr() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzs() throws RemoteException {
        Parcel parcelZzdb = zzdb(10, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final String zzt() throws RemoteException {
        Parcel parcelZzdb = zzdb(9, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List zzu() throws RemoteException {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final List zzv() throws RemoteException {
        Parcel parcelZzdb = zzdb(23, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzw() throws RemoteException {
        zzdc(22, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzx() throws RemoteException {
        zzdc(13, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzy(com.google.android.gms.ads.internal.client.zzcw zzcwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzcwVar);
        zzdc(25, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbha
    public final void zzz(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzdc(15, parcelZza);
    }
}
