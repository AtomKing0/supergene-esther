package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazq extends zzaxm implements zzazs {
    zzazq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzb(int i10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzeVar);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazs
    public final void zzd(zzazp zzazpVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzazpVar);
        zzdc(1, parcelZza);
    }
}
