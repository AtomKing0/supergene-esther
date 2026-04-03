package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzboz extends zzaxm implements zzbpb {
    zzboz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzA() throws RemoteException {
        Parcel parcelZzdb = zzdb(18, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final boolean zzB() throws RemoteException {
        Parcel parcelZzdb = zzdb(17, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final double zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(8, zza());
        double d10 = parcelZzdb.readDouble();
        parcelZzdb.recycle();
        return d10;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(23, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzg() throws RemoteException {
        Parcel parcelZzdb = zzdb(25, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final float zzh() throws RemoteException {
        Parcel parcelZzdb = zzdb(24, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final Bundle zzi() throws RemoteException {
        Parcel parcelZzdb = zzdb(16, zza());
        Bundle bundle = (Bundle) zzaxo.zza(parcelZzdb, Bundle.CREATOR);
        parcelZzdb.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final com.google.android.gms.ads.internal.client.zzdq zzj() throws RemoteException {
        Parcel parcelZzdb = zzdb(11, zza());
        com.google.android.gms.ads.internal.client.zzdq zzdqVarZzb = com.google.android.gms.ads.internal.client.zzdp.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdqVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbew zzk() throws RemoteException {
        Parcel parcelZzdb = zzdb(12, zza());
        zzbew zzbewVarZzj = zzbev.zzj(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbewVarZzj;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final zzbfd zzl() throws RemoteException {
        Parcel parcelZzdb = zzdb(5, zza());
        zzbfd zzbfdVarZzg = zzbfc.zzg(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzbfdVarZzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final IObjectWrapper zzm() throws RemoteException {
        Parcel parcelZzdb = zzdb(13, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel parcelZzdb = zzdb(14, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final IObjectWrapper zzo() throws RemoteException {
        Parcel parcelZzdb = zzdb(15, zza());
        IObjectWrapper iObjectWrapperAsInterface = IObjectWrapper.Stub.asInterface(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return iObjectWrapperAsInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzp() throws RemoteException {
        Parcel parcelZzdb = zzdb(7, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzq() throws RemoteException {
        Parcel parcelZzdb = zzdb(4, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzr() throws RemoteException {
        Parcel parcelZzdb = zzdb(6, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzs() throws RemoteException {
        Parcel parcelZzdb = zzdb(2, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzt() throws RemoteException {
        Parcel parcelZzdb = zzdb(10, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final String zzu() throws RemoteException {
        Parcel parcelZzdb = zzdb(9, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final List zzv() throws RemoteException {
        Parcel parcelZzdb = zzdb(3, zza());
        ArrayList arrayListZzb = zzaxo.zzb(parcelZzdb);
        parcelZzdb.recycle();
        return arrayListZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(20, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzx() throws RemoteException {
        zzdc(19, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzy(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, iObjectWrapper2);
        zzaxo.zzf(parcelZza, iObjectWrapper3);
        zzdc(21, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpb
    public final void zzz(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(22, parcelZza);
    }
}
