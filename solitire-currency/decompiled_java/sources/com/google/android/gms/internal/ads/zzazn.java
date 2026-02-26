package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzazn extends zzaxm implements zzazp {
    zzazn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAd");
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final com.google.android.gms.ads.internal.client.zzbu zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final com.google.android.gms.ads.internal.client.zzdn zzf() throws RemoteException {
        Parcel parcelZzdb = zzdb(5, zza());
        com.google.android.gms.ads.internal.client.zzdn zzdnVarZzb = com.google.android.gms.ads.internal.client.zzdm.zzb(parcelZzdb.readStrongBinder());
        parcelZzdb.recycle();
        return zzdnVarZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzg(boolean z10) throws RemoteException {
        Parcel parcelZza = zza();
        int i10 = zzaxo.zza;
        parcelZza.writeInt(z10 ? 1 : 0);
        zzdc(6, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzh(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, zzdgVar);
        zzdc(7, parcelZza);
    }

    @Override // com.google.android.gms.internal.ads.zzazp
    public final void zzi(IObjectWrapper iObjectWrapper, zzazw zzazwVar) throws RemoteException {
        Parcel parcelZza = zza();
        zzaxo.zzf(parcelZza, iObjectWrapper);
        zzaxo.zzf(parcelZza, zzazwVar);
        zzdc(4, parcelZza);
    }
}
