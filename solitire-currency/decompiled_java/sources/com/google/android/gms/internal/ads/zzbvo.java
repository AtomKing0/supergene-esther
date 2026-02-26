package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbvo extends zzaxm {
    zzbvo(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.reward.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbvn zzbvnVar, String str, String str2) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbvnVar);
        parcelZza.writeString(str);
        parcelZza.writeString(str2);
        zzdc(2, parcelZza);
    }
}
