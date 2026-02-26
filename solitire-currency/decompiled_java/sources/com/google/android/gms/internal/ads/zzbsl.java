package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsl extends zzaxm implements zzbsn {
    zzbsl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final boolean zzH() throws RemoteException {
        Parcel parcelZzdb = zzdb(11, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzh(int i10, int i11, Intent intent) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        parcelZza.writeInt(i11);
        zzaxo.zzd(parcelZza, intent);
        zzdc(12, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzi() throws RemoteException {
        zzdc(10, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(13, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzl(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzm() throws RemoteException {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzo() throws RemoteException {
        zzdc(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzp(int i10, String[] strArr, int[] iArr) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i10);
        parcelZza.writeStringArray(strArr);
        parcelZza.writeIntArray(iArr);
        zzdc(15, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzq() throws RemoteException {
        zzdc(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzr() throws RemoteException {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzs(Bundle bundle) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, bundle);
        Parcel parcelZzdb = zzdb(6, parcelZza);
        if (parcelZzdb.readInt() != 0) {
            bundle.readFromParcel(parcelZzdb);
        }
        parcelZzdb.recycle();
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzt() throws RemoteException {
        zzdc(3, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzu() throws RemoteException {
        zzdc(7, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzv() throws RemoteException {
        zzdc(14, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbsn
    public final void zzx() throws RemoteException {
        zzdc(9, zza());
    }
}
