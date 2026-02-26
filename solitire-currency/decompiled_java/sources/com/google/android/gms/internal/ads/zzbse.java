package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbse extends zzaxm implements zzbsg {
    zzbse(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.offline.IOfflineUtils");
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zze(Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, intent);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzf(String[] strArr, int[] iArr, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzg(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzh() throws RemoteException {
        zzdc(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzi(IObjectWrapper iObjectWrapper, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbsg
    public final void zzj(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.offline.buffering.zza zzaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzd(parcelZza, zzaVar);
        zzdc(6, parcelZza);
    }
}
