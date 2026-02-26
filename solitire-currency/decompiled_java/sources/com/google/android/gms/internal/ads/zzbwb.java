package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbwb extends zzaxm implements zzbwd {
    zzbwb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final int zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        int i10 = parcelZzdb.readInt();
        parcelZzdb.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.ads.zzbwd
    public final String zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(1, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }
}
