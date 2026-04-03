package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbfv extends zzaxm implements zzbfx {
    zzbfv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.INativeCustomTemplateAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final zzbfa zzf() throws RemoteException {
        zzbfa zzbeyVar;
        Parcel parcelZzdb = zzdb(16, zza());
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbeyVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IMediaContent");
            zzbeyVar = iInterfaceQueryLocalInterface instanceof zzbfa ? (zzbfa) iInterfaceQueryLocalInterface : new zzbey(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbeyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final zzbfd zzg(String str) throws RemoteException {
        zzbfd zzbfbVar;
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(2, parcelZza);
        IBinder strongBinder = parcelZzdb.readStrongBinder();
        if (strongBinder == null) {
            zzbfbVar = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage");
            zzbfbVar = iInterfaceQueryLocalInterface instanceof zzbfd ? (zzbfd) iInterfaceQueryLocalInterface : new zzbfb(strongBinder);
        }
        parcelZzdb.recycle();
        return zzbfbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final IObjectWrapper zzh() throws RemoteException {
        Parcel parcelZzdb = zzdb(9, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final String zzi() throws RemoteException {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final String zzj(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        Parcel parcelZzdb = zzdb(1, parcelZza);
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final List zzk() throws RemoteException {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList<String> arrayListCreateStringArrayList = parcelZzdb.createStringArrayList();
        parcelZzdb.recycle();
        return arrayListCreateStringArrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzl() throws RemoteException {
        zzdc(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzm() throws RemoteException {
        zzdc(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzn(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzo() throws RemoteException {
        zzdc(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final void zzp(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzq() throws RemoteException {
        Parcel parcelZzdb = zzdb(12, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzdb = zzdb(17, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        Parcel parcelZzdb = zzdb(10, parcelZza);
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbfx
    public final boolean zzt() throws RemoteException {
        Parcel parcelZzdb = zzdb(13, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
