package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbol;
import com.google.android.gms.internal.ads.zzbom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcj extends zzaxm implements zzcl {
    zzcj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.ILiteSdkInfo");
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzbom getAdapterCreator() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        zzbom zzbomVarZzf = zzbol.zzf(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbomVarZzf;
    }

    @Override // com.google.android.gms.ads.internal.client.zzcl
    public final zzen getLiteSdkVersion() throws RemoteException {
        Parcel parcelZzdb = zzdb(1, zza());
        zzen zzenVar = (zzen) zzaxo.zza(parcelZzdb, zzen.CREATOR);
        parcelZzdb.recycle();
        return zzenVar;
    }
}
