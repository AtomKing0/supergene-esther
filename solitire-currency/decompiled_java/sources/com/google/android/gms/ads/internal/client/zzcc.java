package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbfh;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfn;
import com.google.android.gms.internal.ads.zzbjw;
import com.google.android.gms.internal.ads.zzbjy;
import com.google.android.gms.internal.ads.zzbjz;
import com.google.android.gms.internal.ads.zzbom;
import com.google.android.gms.internal.ads.zzbsf;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbsm;
import com.google.android.gms.internal.ads.zzbsn;
import com.google.android.gms.internal.ads.zzbvq;
import com.google.android.gms.internal.ads.zzbwf;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbyl;
import com.google.android.gms.internal.ads.zzbym;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcc extends zzaxm implements zzce {
    zzcc(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IClientApi");
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbom zzbomVar, int i10) throws RemoteException {
        zzbq zzboVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzboVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdLoaderBuilder");
            zzboVar = iInterfaceQueryLocalInterface instanceof zzbq ? (zzbq) iInterfaceQueryLocalInterface : new zzbo(strongBinder);
        }
        parcelZzdb.recycle();
        return zzboVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbom zzbomVar, int i10) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(13, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbom zzbomVar, int i10) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, zzbom zzbomVar, int i10) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, zzq zzqVar, String str, int i10) throws RemoteException {
        zzbu zzbsVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzqVar);
        parcelZza.writeString(str);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(10, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbsVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IAdManager");
            zzbsVar = iInterfaceQueryLocalInterface instanceof zzbu ? (zzbu) iInterfaceQueryLocalInterface : new zzbs(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbsVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i10) throws RemoteException {
        zzco zzcmVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(9, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzcmVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
            zzcmVar = iInterfaceQueryLocalInterface instanceof zzco ? (zzco) iInterfaceQueryLocalInterface : new zzcm(strongBinder);
        }
        parcelZzdb.recycle();
        return zzcmVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException {
        zzdj zzdhVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(17, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzdhVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IOutOfContextTester");
            zzdhVar = iInterfaceQueryLocalInterface instanceof zzdj ? (zzdj) iInterfaceQueryLocalInterface : new zzdh(strongBinder);
        }
        parcelZzdb.recycle();
        return zzdhVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfh zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, iObjectWrapper2);
        Parcel parcelZzdb = zzdb(5, parcelZza);
        zzbfh zzbfhVarZzdA = zzbfg.zzdA(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfhVarZzdA;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfn zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, iObjectWrapper2);
        zzaxo.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzdb = zzdb(11, parcelZza);
        zzbfn zzbfnVarZze = zzbfm.zze(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfnVarZze;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjz zzk(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10, zzbjw zzbjwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        zzaxo.zzf(parcelZza, zzbjwVar);
        Parcel parcelZzdb = zzdb(16, parcelZza);
        zzbjz zzbjzVarZzb = zzbjy.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbjzVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbsg zzl(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(15, parcelZza);
        zzbsg zzbsgVarZzb = zzbsf.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbsgVarZzb;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbsn zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzdb = zzdb(8, parcelZza);
        zzbsn zzbsnVarZzI = zzbsm.zzI(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbsnVarZzI;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbvq zzn(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbwg zzo(IObjectWrapper iObjectWrapper, String str, zzbom zzbomVar, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(12, parcelZza);
        zzbwg zzbwgVarZzq = zzbwf.zzq(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbwgVarZzq;
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbym zzp(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        Parcel parcelZzdb = zzdb(14, parcelZza);
        zzbym zzbymVarZzb = zzbyl.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbymVarZzb;
    }
}
