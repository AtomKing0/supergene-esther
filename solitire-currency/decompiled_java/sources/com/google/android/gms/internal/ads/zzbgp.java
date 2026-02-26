package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbgp extends zzaxm implements zzbgr {
    zzbgp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgr
    public final void zze(zzbha zzbhaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbhaVar);
        zzdc(1, parcelZza);
    }
}
