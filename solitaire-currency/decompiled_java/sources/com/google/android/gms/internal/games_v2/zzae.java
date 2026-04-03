package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzae extends zza {
    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.connect.IGamesConnectService");
    }

    public final void zzd(zzad zzadVar, zzy zzyVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzc.zzf(parcelZza, zzadVar);
        zzc.zzd(parcelZza, zzyVar);
        zzc(2, parcelZza);
    }
}
