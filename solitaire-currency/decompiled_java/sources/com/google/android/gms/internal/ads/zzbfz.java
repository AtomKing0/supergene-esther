package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbfz extends zzaxm implements zzbgb {
    zzbfz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgb
    public final void zze(zzbfs zzbfsVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfsVar);
        zzdc(1, parcelZza);
    }
}
