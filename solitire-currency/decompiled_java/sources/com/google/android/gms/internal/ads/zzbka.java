package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbka extends zzaxm implements zzbkc {
    zzbka(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbkc
    public final zzbjz zze(IObjectWrapper iObjectWrapper, zzbom zzbomVar, int i10, zzbjw zzbjwVar) throws RemoteException {
        zzbjz zzbjxVar;
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzbomVar);
        parcelZza.writeInt(242402000);
        zzaxo.zzf(parcelZza, zzbjwVar);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbjxVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            zzbjxVar = iInterfaceQueryLocalInterface instanceof zzbjz ? (zzbjz) iInterfaceQueryLocalInterface : new zzbjx(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbjxVar;
    }
}
