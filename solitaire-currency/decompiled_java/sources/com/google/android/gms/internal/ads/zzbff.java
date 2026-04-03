package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbff extends zzaxm implements zzbfh {
    zzbff(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdViewDelegate");
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final IObjectWrapper zzb(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzc() throws RemoteException {
        zzdc(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzd(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdv(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(1, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdx(zzbfa zzbfaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbfaVar);
        zzdc(8, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdy(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(9, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zzdz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfh
    public final void zze(IObjectWrapper iObjectWrapper, int i10) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeInt(i10);
        zzdc(5, parcelZza);
    }
}
