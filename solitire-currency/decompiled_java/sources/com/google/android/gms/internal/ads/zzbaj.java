package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbaj extends zzaxm {
    zzbaj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.cache.ICacheService");
    }

    public final long zze(zzbah zzbahVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbahVar);
        Parcel parcelZzdb = zzdb(3, parcelZza);
        long j10 = parcelZzdb.readLong();
        parcelZzdb.recycle();
        return j10;
    }

    public final zzbae zzf(zzbah zzbahVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbahVar);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        zzbae zzbaeVar = (zzbae) zzaxo.zza(parcelZzdb, zzbae.CREATOR);
        parcelZzdb.recycle();
        return zzbaeVar;
    }

    public final zzbae zzg(zzbah zzbahVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzbahVar);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        zzbae zzbaeVar = (zzbae) zzaxo.zza(parcelZzdb, zzbae.CREATOR);
        parcelZzdb.recycle();
        return zzbaeVar;
    }
}
