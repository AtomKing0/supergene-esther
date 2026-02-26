package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbyk extends zzaxm implements zzbym {
    zzbyk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final IObjectWrapper zze(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, String str, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, iObjectWrapper2);
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, iObjectWrapper3);
        Parcel parcelZzdb = zzdb(11, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzf(IObjectWrapper iObjectWrapper, zzbyq zzbyqVar, zzbyj zzbyjVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzbyqVar);
        zzaxo.zzf(parcelZza, zzbyjVar);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzg(zzbtl zzbtlVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbtlVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzi(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbym
    public final void zzm(List list, IObjectWrapper iObjectWrapper, zzbtc zzbtcVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeTypedList(list);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbtcVar);
        zzdc(5, parcelZza);
    }
}
