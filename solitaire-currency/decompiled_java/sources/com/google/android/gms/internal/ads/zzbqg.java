package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbqg extends zzaxm implements zzbqi {
    zzbqg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRewardedCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zze(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString("Adapter returned null.");
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzeVar);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbqi
    public final void zzg() throws RemoteException {
        zzdc(2, zza());
    }
}
