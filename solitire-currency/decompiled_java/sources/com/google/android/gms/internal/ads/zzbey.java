package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbey extends zzaxm implements zzbfa {
    zzbey(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IMediaContent");
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(6, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final float zzg() throws RemoteException {
        Parcel parcelZzdb = zzdb(5, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel parcelZzdb = zzdb(7, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final IObjectWrapper zzi() throws RemoteException {
        Parcel parcelZzdb = zzdb(4, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(3, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzk() throws RemoteException {
        Parcel parcelZzdb = zzdb(10, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final boolean zzl() throws RemoteException {
        Parcel parcelZzdb = zzdb(8, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfa
    public final void zzm(zzbgl zzbglVar) throws RemoteException {
        throw null;
    }
}
