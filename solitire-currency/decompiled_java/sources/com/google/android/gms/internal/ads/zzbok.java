package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbok extends zzaxm implements zzbom {
    zzbok(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final zzbop zzb(String str) throws RemoteException {
        zzbop zzbonVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbonVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
            zzbonVar = iInterfaceQueryLocalInterface instanceof zzbop ? (zzbop) iInterfaceQueryLocalInterface : new zzbon(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbonVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final zzbql zzc(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        zzbql zzbqlVarZzb = zzbqk.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbqlVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final boolean zzd(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(4, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbom
    public final boolean zze(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
