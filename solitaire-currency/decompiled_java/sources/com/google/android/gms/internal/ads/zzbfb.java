package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbfb extends zzaxm implements zzbfd {
    zzbfb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeAdImage");
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final double zzb() throws RemoteException {
        Parcel parcelZzdb = zzdb(3, zza());
        double d10 = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d10;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final int zzc() throws RemoteException {
        Parcel parcelZzdb = zzdb(5, zza());
        int i10 = parcelZzdb.readInt();
        parcelZzdb.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final int zzd() throws RemoteException {
        Parcel parcelZzdb = zzdb(4, zza());
        int i10 = parcelZzdb.readInt();
        parcelZzdb.recycle();
        return i10;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final Uri zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        Uri uri = (Uri) zzaxo.zza(parcelZzdb, Uri.CREATOR);
        parcelZzdb.recycle();
        return uri;
    }

    @Override // com.google.android.gms.internal.ads.zzbfd
    public final IObjectWrapper zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(1, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }
}
