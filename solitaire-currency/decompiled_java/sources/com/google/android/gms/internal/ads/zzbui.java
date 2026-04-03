package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbui extends zzaxm implements zzbuk {
    zzbui(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zze(zzbvb zzbvbVar, zzbuu zzbuuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzf(zzbvb zzbvbVar, zzbuu zzbuuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzg(zzbvb zzbvbVar, zzbuu zzbuuVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbvbVar);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbuk
    public final void zzh(String str, zzbuu zzbuuVar) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, zzbuuVar);
        zzdc(7, parcelZza);
    }
}
