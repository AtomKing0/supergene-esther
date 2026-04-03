package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbgv extends zzaxm implements zzbgx {
    zzbgv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgx
    public final void zze() throws RemoteException {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbgx
    public final void zzf(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(1, parcelZza);
    }
}
