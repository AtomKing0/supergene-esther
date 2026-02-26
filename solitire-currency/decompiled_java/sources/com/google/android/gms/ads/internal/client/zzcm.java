package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaxm;
import com.google.android.gms.internal.ads.zzaxo;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzblc;
import com.google.android.gms.internal.ads.zzbom;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcm extends zzaxm implements zzco {
    zzcm(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final float zze() throws RemoteException {
        Parcel parcelZzdb = zzdb(7, zza());
        float f10 = parcelZzdb.readFloat();
        parcelZzdb.recycle();
        return f10;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final String zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(9, zza());
        String string = parcelZzdb.readString();
        parcelZzdb.recycle();
        return string;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final List zzg() throws RemoteException {
        Parcel parcelZzdb = zzdb(13, zza());
        ArrayList arrayListCreateTypedArrayList = parcelZzdb.createTypedArrayList(zzbkv.CREATOR);
        parcelZzdb.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzh(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(10, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzi() throws RemoteException {
        zzdc(15, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzj(boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = zzaxo.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzdc(17, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzk() throws RemoteException {
        zzdc(1, zza());
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzl(String str, IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(null);
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzm(zzda zzdaVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzdaVar);
        zzdc(16, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzn(IObjectWrapper iObjectWrapper, String str) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        parcelZza.writeString(str);
        zzdc(5, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzo(zzbom zzbomVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzbomVar);
        zzdc(11, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzp(boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = zzaxo.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzdc(4, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzq(float f10) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeFloat(f10);
        zzdc(2, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzr(String str) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzs(zzblc zzblcVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzblcVar);
        zzdc(12, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzt(String str) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeString(str);
        zzdc(18, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzu(zzff zzffVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzd(parcelZza, zzffVar);
        zzdc(14, parcelZza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final boolean zzv() throws RemoteException {
        Parcel parcelZzdb = zzdb(8, zza());
        boolean zZzg = zzaxo.zzg(parcelZzdb);
        parcelZzdb.recycle();
        return zZzg;
    }
}
