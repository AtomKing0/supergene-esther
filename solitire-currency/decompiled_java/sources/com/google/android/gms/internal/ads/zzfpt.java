package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfpt extends zzaxm {
    zzfpt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfpr zze(zzfpp zzfppVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzfppVar);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        zzfpr zzfprVar = (zzfpr) zzaxo.zza(parcelZzdb, zzfpr.CREATOR);
        parcelZzdb.recycle();
        return zzfprVar;
    }

    public final zzfqa zzf(zzfpy zzfpyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzfpyVar);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        zzfqa zzfqaVar = (zzfqa) zzaxo.zza(parcelZzdb, zzfqa.CREATOR);
        parcelZzdb.recycle();
        return zzfqaVar;
    }

    public final void zzg(zzfpm zzfpmVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzfpmVar);
        zzdc(2, parcelZza);
    }
}
